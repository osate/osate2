package edu.uah.rsesc.aadl.age.services.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
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
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.services.ModificationService;
import edu.uah.rsesc.aadl.age.ui.xtext.AgeXtextUtil;

public class DefaultModificationService implements ModificationService {
	private final IFeatureProvider fp;
	
	public DefaultModificationService(final IFeatureProvider fp) {
		this.fp = fp;
	}
	
	@Override
	public <MR> MR modifyModel(final NamedElement element, final Modifier<MR> modifier) {
		if(element == null) {
			return null;
		}
		
		final MR modifierResult;
		if(!(element.eResource() instanceof XtextResource)) {
			throw new RuntimeException("Unexpected case. Resource is not an XtextResource");
		}
		
		// Try to get the Xtext document	
		final IXtextDocument doc = AgeXtextUtil.getDocumentByQualifiedName(element.getQualifiedName());
		if(doc == null) {
			final XtextResource res = (XtextResource)element.eResource();
			modifierResult = modifySafely(res, modifier);
			try {
				element.eResource().save(SaveOptions.defaultOptions().toOptionsMap());	
			} catch (IOException e) {
				throw new RuntimeException(e);
			};				
			
			Display.getDefault().syncExec(new Runnable() {
				public void run() {			
					// Update the entire diagram
					fp.getDiagramTypeProvider().getNotificationService().updatePictogramElements(new PictogramElement[] { fp.getDiagramTypeProvider().getDiagram() });					
				}
			});					
		} else {
			modifierResult = doc.modify(new IUnitOfWork<MR, XtextResource>() {
				@Override
				public MR exec(XtextResource  res) throws Exception {
					return modifySafely(res, modifier);
				}
			});	
		}

		return modifierResult;
	}
	
	/**
	 * Modifies the resource. If changes causes a validation error, the changes are reverted.
	 * @param resource
	 * @param modifier
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <MR> MR modifySafely(final XtextResource resource, final Modifier<MR> modifier) {
		if(resource.getContents().size() < 1) {
			return null;
		}

		// Ensure that the resource does not have an editing domain
		if(TransactionUtil.getEditingDomain(resource) != null) {
			throw new RuntimeException("Unexpected case: resource already has an editing domain");
		}

		// Create a new editing domain
		final TransactionalEditingDomain domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resource.getResourceSet());
		
		MR result = null;
		try {
			// Execute a new recording command
			final RecordingCommand cmd = new RecordingCommand(domain) {
				private MR modifierResult;
				
				@Override
				protected void doExecute() {
					modifierResult = modifier.modify(resource);
				}
				
				@Override
				public Collection<?> getResult() {
					return Collections.singletonList(modifierResult);
				}
				
			};
			domain.getCommandStack().execute(cmd);
			final Object[] cmdResult = cmd.getResult().toArray();
			if(cmdResult.length > 0) {
				result = (MR)cmdResult[0];
			}
		} finally {				
			// Undo the changes if any of the validators fail
			final List<Diagnostic> concreteValidationErrors = resource.validateConcreteSyntax();
			if(resource.getErrors().size() > 0 || concreteValidationErrors.size() > 0 && domain.getCommandStack().canUndo()) {
				System.err.println("Undoing modification");
				System.err.println("Concrete Syntax Validation Errors:");
				for(final Diagnostic diag : concreteValidationErrors) {
					System.err.println(diag);
				}
				System.out.println(concreteValidationErrors);
				domain.getCommandStack().undo();
				result = null;
			}			
	
			// Flush and dispose of the editing domain
			domain.getCommandStack().flush();			
			domain.dispose();	
		}
		
		return result;
	}
}
