/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.ui.xtext;

import java.util.Collection;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.osate.ge.services.CachingService;
import org.osate.ge.ui.editor.AgeDiagramEditor;

public class AgeXtextUtil {
	private static final XtextResourceSet defaultResourceSet = new XtextResourceSet(); // TOOD: Investigate usage. Especially in relationship with the referencing. 
	private static final OpenAadlResources openAadlResources = new OpenAadlResources();
	
	/**
	 * Registers listeners to listen to model changes from all Xtext editors and to be notified of newly opened xtext editors.
	 * @author philip.alldredge
	 *
	 */
	public static class Initializer implements IStartup {		
		public void earlyStartup() {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					// Listen for the opening of new windows
					PlatformUI.getWorkbench().addWindowListener(new IWindowListener() {
						@Override
						public void windowActivated(IWorkbenchWindow window) {
						}

						@Override
						public void windowDeactivated(IWorkbenchWindow window) {
						}

						@Override
						public void windowClosed(IWorkbenchWindow window) {
						}

						@Override
						public void windowOpened(IWorkbenchWindow window) {
							registerListenersForWindow(window);
						}						
					});
					
					// Register existing windows
					for(final IWorkbenchWindow window : PlatformUI.getWorkbench().getWorkbenchWindows()) {
						registerListenersForWindow(window);		
					}
					
					// Register a resource change listener
					final IWorkspace workspace = ResourcesPlugin.getWorkspace();
					workspace.addResourceChangeListener(resourceChangeListener);
				}
			});
		}
		
		/**
		 * Register listeners for the window
		 * @param window
		 */
		private void registerListenersForWindow(final IWorkbenchWindow window) {
			window.addPageListener(new IPageListener() {
				@Override
				public void pageActivated(IWorkbenchPage page) {
				}

				@Override
				public void pageClosed(IWorkbenchPage page) {
				}

				@Override
				public void pageOpened(IWorkbenchPage page) {
					registerListenerForPage(page);
				}				
			});
			
			for(final IWorkbenchPage page : window.getPages()) {
				registerListenerForPage(page);
			}
		}
		
		/**
		 * Register part listeners for a page
		 * @param page
		 */
		private void registerListenerForPage(final IWorkbenchPage page) {
			page.addPartListener(new EditorListener(page, openAadlResources));	
		}
	}
	
	/**
	 * Returns the resource which as a content whose qualified name matches the specified one and whose IResource is in the specified collection
	 * @param qualifiedName
	 * @return
	 */
	public static XtextResource getXtextResourceByRootQualifiedName(final String qualifiedName, final Collection<IResourceDescription> resourceDescriptions) {
		for(final IResourceDescription resDesc : resourceDescriptions) {
			final XtextResource xtextResource = openAadlResources.getXtextResource(qualifiedName, resDesc.getURI());
			if(xtextResource != null) {
				return xtextResource;
			}
		}
		
		// TODO: Return a resource from the default resource set if unable to find it?
		return null;
	}
	
	/**
	 * Returns the resource set used when the model element does not have one. In other words, the one used when there isn't an xtext editor for the package open.
	 * @return
	 */
	private static XtextResourceSet getDefaultResourceSet() {
		return defaultResourceSet;
	}
	
	/**
	 * Returns the Xtext document that contains the package with the specified name
	 * @param qualifiedName
	 * @return the last document updated for the qualified name or null if one does not exist
	 */
	public static IXtextDocument getDocumentByPackageName(final String qualifiedName) {
		// TODO: Rework. Need to be able to get the document.
		//return modelListener.getDocument(qualifiedName);
		return null;
	}
	
	// TODO: Rework. Needed to trigger an update to the diagram. Could be registered for a specific IResource?
	public static void addModelListener(final IXtextModelListener listener) {
		//modelListener.addListener(listener);
	}
	
	public static void removeModelListener(final IXtextModelListener listener) {
		//modelListener.removeListener(listener);
	}
	
	// TODO: Will need to consider effect of the default resource set and the referencing service..
	private static final IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {
		@Override
		public void resourceChanged(final IResourceChangeEvent event) {
			final IResourceDelta delta = event.getDelta();
			if(delta != null) {
				try {
					delta.accept(visitor);
				} catch (CoreException e) {
				}
			}
		}
		
		private IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
            public boolean visit(final IResourceDelta delta) {
               // If the resource's contents has changed changed
               if(delta.getKind() != IResourceDelta.CHANGED || (delta.getFlags() & IResourceDelta.CONTENT) == 0)
                  return true;

               // Check AADL files
               final IResource resource = delta.getResource();
               if (resource.getType() == IResource.FILE && "aadl".equalsIgnoreCase(resource.getFileExtension())) {
            	   final URI resourceUri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);

            	   // If the resource is loaded into our resource set, unload it.
            	   for(final Resource rsResource : getDefaultResourceSet().getResources()) {
            		   if(resourceUri.equals(rsResource.getURI())) {
            			   // Unload the resource
            			   rsResource.unload();
            		   }            		   
            	   }
            	   
            	   // Invalidate all caches
            	   for(final IWorkbenchWindow window : PlatformUI.getWorkbench().getWorkbenchWindows()) {
            		   for(final IWorkbenchPage page : window.getPages()) {
            			   for(final IEditorReference editorRef : page.getEditorReferences()) {
            				   final IEditorPart editor = editorRef.getEditor(false);
            				   if(editor instanceof AgeDiagramEditor) {
            					   final CachingService cachingService = (CachingService)editor.getAdapter(CachingService.class);
            					   cachingService.invalidate();
            				   }
            			   }
            		   }
            	   }
               }
               return true;
            }
         };
	};
}