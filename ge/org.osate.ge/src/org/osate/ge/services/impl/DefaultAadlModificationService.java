/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.services.impl;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexUnparserRegistry;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.ui.xtext.AgeXtextUtil;
import org.osate.ge.util.Log;

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

		class ModifyRunnable implements Runnable {
			public R result;
			
			@Override
			public void run() {
				final R modifierResult;
				if(!(element.eResource() instanceof XtextResource)) {
					throw new RuntimeException("Unexpected case. Resource is not an XtextResource");
				}

				// Try to get the Xtext document	
				final NamedElement root = element.getElementRoot();
				final IXtextDocument doc = AgeXtextUtil.getDocumentByPackageName(root.getQualifiedName());
				if(doc == null) {
					final XtextResource res = (XtextResource)element.eResource();
					final ModifySafelyResults<R> modifySafelyResult = modifySafely(res, element, modifier, false);//true);
					modifierResult = modifySafelyResult.modifierResult;
					
					if(modifySafelyResult.modificationSuccessful) {
						// Save the model
						try {
							res.save(SaveOptions.defaultOptions().toOptionsMap());	
						} catch (IOException e) {
							throw new RuntimeException(e);
						};
						
						// Update the diagram
						Display.getDefault().syncExec(new Runnable() {
							public void run() {			
								// Update the entire diagram
								fp.getDiagramTypeProvider().getNotificationService().updatePictogramElements(new PictogramElement[] { fp.getDiagramTypeProvider().getDiagram() });					
							}
						});
						
						// Call the after modification callback
						modifier.afterCommit(res);
					}
				} else {
					// TODO: Fix wording
					// Determine what the root actual/parsed annex element is if the element is in an annex
					final EObject parsedAnnexRoot = getParsedAnnexRoot(element);
					
					// If the element which needs to be edited is in an annex, modify the default annex element. This is needed because objects inside of annexes 
					// may not have unique URI's
					final EObject elementToModify = parsedAnnexRoot == null ? element : parsedAnnexRoot.eContainer();
					final URI modificationElementUri = EcoreUtil.getURI(elementToModify);
					final ModifySafelyResults<R> modifySafelyResult = doc.modify(new IUnitOfWork<ModifySafelyResults<R>, XtextResource>() {
						@SuppressWarnings("unchecked")
						@Override
						public ModifySafelyResults<R> exec(final XtextResource res) throws Exception {
							final EObject elementToModify = res.getResourceSet().getEObject(modificationElementUri, true);
							if(elementToModify == null) {
								return null;
							}
							
							if(elementToModify instanceof DefaultAnnexLibrary || elementToModify instanceof DefaultAnnexSubclause) {
								return modifyAnnexInXtextDocument(res, elementToModify, element, modifier);
							} else {
								return modifySafely(res, (E)elementToModify, modifier, false);
							}
						}
					});
					modifierResult = modifySafelyResult.modifierResult;
					
					// Call the after modification callback
					if(modifySafelyResult.modificationSuccessful) {
						// Call readonly on the document. This will should cause Xtext's reconciler to be called to ensure the document matches the model.
						// If modify() has been called in the display thread, then the diagram should be updated by the diagram editor as well
						doc.readOnly(new IUnitOfWork<Object, XtextResource>() {
							@Override
							public Object exec(final XtextResource res) throws Exception {
								modifier.afterCommit(res);
								return null;
							}
						});	
					}
				}

				result = modifierResult;
			}
			
		};
		
		// We want to run the modification in the display thread. Executing in the display thread will allow the diagram editor updates to be ran synchronously
		final ModifyRunnable modifyRunnable = new ModifyRunnable();
		if(Display.getDefault().getThread() == Thread.currentThread()) {
			Log.info("Executing modification without a thread switch");
			try {
				modifyRunnable.run();
			} catch(RuntimeException ex) {			
				final Status status = new Status(IStatus.ERROR, Activator.getPluginId(), "An error occured modifying the AADL model.", ex);
				StatusManager.getManager().handle(status, StatusManager.SHOW | StatusManager.LOG);
				throw ex; // Rethrow exception to let caller know that there was a problem.
			}
		} else {
			Log.info("Executing modification after switching to display thread");
			Display.getDefault().syncExec(modifyRunnable);	
		}
		
		return modifyRunnable.result;
	}
		
	// TODO: Rename
	// TODO: Rename userElement
	private <E extends EObject, R> ModifySafelyResults<R> modifyAnnexInXtextDocument(final XtextResource resource, final EObject defaultAnnexElement, final E userElement, final Modifier<E, R> modifier) {
		// TODO: Test with models in separate files. May need to copy entire resource set.
		// Make a copy of the parsed annex root and add it to a temporary resource
		final EObject parsedAnnexElement = getParsedAnnexElement(defaultAnnexElement);							
		final ResourceSet tmpResourceSet = new ResourceSetImpl();
		final Resource tmpResource = tmpResourceSet.createResource(resource.getURI()); // TODO: Use that resource uri or the one from the default annex elmeent? Same one?
		tmpResource.getContents().addAll(EcoreUtil.copyAll(resource.getContents()));
		final EObject parsedAnnexRootClone = tmpResourceSet.getEObject(EcoreUtil.getURI(parsedAnnexElement), false);
		// TODO: Error checking
		
		// TODO: Use the word object more than clone
		// TODO: Get the object inside of the clone
		final Deque<Integer> indexStack = getParsedAnnexRootIndices(userElement);
		EObject tmpClonedObject = parsedAnnexRootClone;
		while(!indexStack.isEmpty()) {
			tmpClonedObject = tmpClonedObject.eContents().get(indexStack.pop());
		}
		
		@SuppressWarnings("unchecked")
		final E clonedObject = (E)tmpClonedObject;
		
		// Modify the annex by modifying the cloned object, unparsing, and then updating the source text of the original default annex element. 
		return modifySafely(resource, defaultAnnexElement, new Modifier<EObject, R>() {
			@Override
			public R modify(final Resource resource, final EObject elementToModify) {
				// Modify the cloned object
				final R result = modifier.modify(resource, clonedObject);
				
				// Unparse the annex text of the cloned object and update the Xtext document
				if(parsedAnnexRootClone instanceof AnnexLibrary) {									
					final String sourceTxt = "{**" + getAnnexUnparserRegistry().getAnnexUnparser(((AnnexLibrary)defaultAnnexElement).getName()).unparseAnnexLibrary((AnnexLibrary)parsedAnnexRootClone, "  ") + "**}";
					final DefaultAnnexLibrary defaultAnnexLibrary = (DefaultAnnexLibrary)elementToModify;
					EcoreUtil.delete(defaultAnnexLibrary.getParsedAnnexLibrary());
					defaultAnnexLibrary.setSourceText(sourceTxt);
				} else if(parsedAnnexRootClone instanceof AnnexSubclause) {
					final String sourceTxt = "{**" + getAnnexUnparserRegistry().getAnnexUnparser(((AnnexSubclause)defaultAnnexElement).getName()).unparseAnnexSubclause((AnnexSubclause)parsedAnnexRootClone, "  ") + "**}";
					final DefaultAnnexSubclause defaultAnnexSubclause = (DefaultAnnexSubclause)elementToModify;
					EcoreUtil.delete(defaultAnnexSubclause.getParsedAnnexSubclause());
					defaultAnnexSubclause.setSourceText(sourceTxt);
				} else {
					throw new RuntimeException("Unhandled case, parsedAnnexRoot is of type: " + parsedAnnexRootClone.getClass());
				}

				return result;
			}

			@Override
			public void beforeCommit(final Resource resource, final EObject element, final R modificationResult) {
				modifier.beforeCommit(resource, clonedObject, modificationResult);
			}

			@Override
			public void afterCommit(final Resource resource) {
				modifier.afterCommit(resource);
			}
		}, false);
	}
	
	// TODO: Rename methods
	
	private AnnexUnparserRegistry getAnnexUnparserRegistry() {
		return (AnnexUnparserRegistry)AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID);
	}
	
	
	private EObject getParsedAnnexElement(final EObject defaultAnnexObject) {
		if(defaultAnnexObject instanceof DefaultAnnexLibrary) {
			return ((DefaultAnnexLibrary) defaultAnnexObject).getParsedAnnexLibrary();
		} else if(defaultAnnexObject instanceof DefaultAnnexSubclause) {
			return ((DefaultAnnexSubclause) defaultAnnexObject).getParsedAnnexSubclause();
		} else {
			throw new RuntimeException("Unexpected type: " + defaultAnnexObject.getClass().getName());
		}
	}
	
	/**
	 * Finds the parsed AnnexLibrary or AnnexSubclause for a model object. Returns null if the object is not part of a parsed annex.
	 * Used to determine whether special handling for the object is necessary
	 */
	private EObject getParsedAnnexRoot(final EObject obj) {
		// If the object is a default annex library or subclause, then it is not part of a parsed annex
		if(obj instanceof DefaultAnnexLibrary || obj instanceof DefaultAnnexSubclause) {
			return null;
		}
		
		// Find the root of the parsed annex 
		EObject tmp = obj;
		while(tmp != null && !(tmp instanceof AnnexLibrary || tmp instanceof AnnexSubclause)) {
			tmp = tmp.eContainer();
		}
		
		return tmp;
	}
	
	// TODO: Rename
	private Deque<Integer> getParsedAnnexRootIndices(final EObject obj) {
		assert !(obj instanceof DefaultAnnexLibrary || obj instanceof DefaultAnnexSubclause);
		
		final Deque<Integer> indices = new ArrayDeque<Integer>();
		
		// Find the root of the parsed annex 
		EObject tmp = obj;
		while(tmp != null && !(tmp instanceof AnnexLibrary || tmp instanceof AnnexSubclause)) {
			
			final int newIndex = ECollections.indexOf(tmp.eContainer().eContents(), tmp, 0);
			if(newIndex == -1) {
				throw new RuntimeException("Unable to get index inside of container contents");
			}
			
			indices.push(newIndex);;
			tmp = tmp.eContainer();
		}
		
		return indices;
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
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <E extends EObject, R> ModifySafelyResults<R> modifySafely(final XtextResource resource, final E element, final Modifier<E, R> modifier, final boolean testSerialization) {
		if(resource.getContents().size() < 1) {
			return null;
		}

		// Create a new editing domain
		final TransactionalEditingDomain domain = Objects.requireNonNull(TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.osate.aadl2.ModelEditingDomain"), "unable to retrieve editing domain");
		
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
			
			// Try to serialize the resource. In some cases serialization can fail and leave a corrupt model if we are editing without an xtext document
			// The real serialization will occur later.
			if(testSerialization) {
				resource.getSerializer().serialize(resource.getContents().get(0));
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
			
			if(modificationSuccessful) {
				// Call the after modification callback
				modifier.beforeCommit(resource, element, result);
			}
		}
		
		return new ModifySafelyResults<R>(modificationSuccessful, result);
	}
}
