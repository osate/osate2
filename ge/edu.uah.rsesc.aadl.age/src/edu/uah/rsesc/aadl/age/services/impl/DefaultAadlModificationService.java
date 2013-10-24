package edu.uah.rsesc.aadl.age.services.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.ui.xtext.AgeXtextUtil;
import edu.uah.rsesc.aadl.age.util.Log;

public class DefaultAadlModificationService implements AadlModificationService {
	private final IFeatureProvider fp;
	
	public DefaultAadlModificationService(final IFeatureProvider fp) {
		this.fp = fp;
	}
	
	@Override
	public <E extends Element, R> R modify(final E element, final Modifier<E, R> modifier) {
		if(element == null) {
			return null;
		}
		
		final R modifierResult;
		if(!(element.eResource() instanceof XtextResource)) {
			throw new RuntimeException("Unexpected case. Resource is not an XtextResource");
		}

		// Try to get the Xtext document	
		final NamedElement root = element.getElementRoot();
		final IXtextDocument doc = AgeXtextUtil.getDocumentByQualifiedName(root.getQualifiedName());
		if(doc == null) {
			final XtextResource res = (XtextResource)element.eResource();
			final ModifySafelyResults<R> modifySafelyResult = modifySafely(res, element, modifier, true);
			modifierResult = modifySafelyResult.modifierResult;
			if(modifySafelyResult.modificationSuccessful) {
				Display.getDefault().syncExec(new Runnable() {
					public void run() {			
						// Update the entire diagram
						fp.getDiagramTypeProvider().getNotificationService().updatePictogramElements(new PictogramElement[] { fp.getDiagramTypeProvider().getDiagram() });					
					}
				});
			}
		} else {
			final URI elementUri = EcoreUtil.getURI(element);
			modifierResult = doc.modify(new IUnitOfWork<R, XtextResource>() {
				@Override
				public R exec(final XtextResource  res) throws Exception {
					@SuppressWarnings("unchecked")
					final E element = (E)res.getResourceSet().getEObject(elementUri, true);
					if(element == null) {
						return null;
					}
					
					return modifySafely(res, element, modifier, false).modifierResult;
				}
			});	
		}

		return modifierResult;
	}
	
	/**
	 * Class used to return the results of the modifySafely method
	 * @author philip.alldredge
	 *
	 * @param <R>
	 */
	private static class ModifySafelyResults<R> {
		public ModifySafelyResults(final boolean modificationSuccessful, final R modifierResult) {
			this.modificationSuccessful = modificationSuccessful;
			this.modifierResult = modifierResult;
		}
		
		public final boolean modificationSuccessful;
		public final R modifierResult;
	}
	/**
	 * Modifies the resource. If changes causes a validation error, the changes are reverted.
	 * @param resource
	 * @param modifier
	 * @param saveOnSuccess is whether the resource should be saved if the modification is successful. If true, the save will take place after the modification but
	 * before the afterModification callback. This ensures that any diagram operations that occur in afterModification will use the up to date model.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <E extends Element, R> ModifySafelyResults<R> modifySafely(final XtextResource resource, final E element, final Modifier<E, R> modifier, final boolean saveOnSuccess) {
		if(resource.getContents().size() < 1) {
			return null;
		}

		// Ensure that the resource does not have an editing domain
		if(TransactionUtil.getEditingDomain(resource) != null) {
			throw new RuntimeException("Unexpected case: resource already has an editing domain");
		}

		// Create a new editing domain
		final TransactionalEditingDomain domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resource.getResourceSet());
		
		R result = null;
		boolean modificationSuccessful = false;
		try {
			// Execute a new recording command
			final RecordingCommand cmd = new RecordingCommand(domain) {
				private R modifierResult;
				
				@Override
				protected void doExecute() {
					modifierResult = modifier.modify(resource, element);
				}
				
				@Override
				public Collection<?> getResult() {
					return Collections.singletonList(modifierResult);
				}
				
			};
			domain.getCommandStack().execute(cmd);
			final Object[] cmdResult = cmd.getResult().toArray();
			if(cmdResult.length > 0) {
				result = (R)cmdResult[0];
			}
			
			// Mark the modification as successful
			modificationSuccessful = true;
		} finally {
			// Undo the changes if any of the validators fail
			final List<Diagnostic> concreteValidationErrors = resource.validateConcreteSyntax();
			// Disabled checking for resource errors because that includes errors that will occur in normal operations(unless refactoring/chain deleting/modification is implemented)
			if(!modificationSuccessful || (/*resource.getErrors().size() > 0 || */concreteValidationErrors.size() > 0) && domain.getCommandStack().canUndo()) {
				Log.error("Error. Undoing modification");
				/*if(resource.getErrors().size() > 0) {
					Log.error("Errors:");
					for(final org.eclipse.emf.ecore.resource.Resource.Diagnostic diag : resource.getErrors()) {
						Log.error(diag.toString());
					}
				}
				*/
				if(concreteValidationErrors.size() > 0) {
					Log.error("Concrete Syntax Validation Errors:");
					for(final Diagnostic diag : concreteValidationErrors) {
						Log.error(diag.toString());
					}
				}
				
				if(domain.getCommandStack().canUndo()) {
					domain.getCommandStack().undo();
				}
				modificationSuccessful = false;
				result = null;
			}
	
			// Flush and dispose of the editing domain
			domain.getCommandStack().flush();			
			domain.dispose();	
			
			if(modificationSuccessful) {
				if(saveOnSuccess) {
					try {
						resource.save(SaveOptions.defaultOptions().toOptionsMap());	
					} catch (IOException e) {
						throw new RuntimeException(e);
					};
				}

				/*
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/

				modifier.afterModification(resource, element);
			}
		}
		
		return new ModifySafelyResults<R>(modificationSuccessful, result);
	}
}
