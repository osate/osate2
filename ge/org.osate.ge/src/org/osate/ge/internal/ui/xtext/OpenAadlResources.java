/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.xtext;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.NamedElement;

/**
 * Data structure for tracking open AADL resources  and listening for changes. 
 * If multiple Xtext editors are open for a single AADL resource, it is treated as a single open document.
 * This structure actually tracks all xtext resources, not just AADL files.
 */
public class OpenAadlResources {
	private final Map<IResource, OpenAadlResource> resourceToOpenResourceMap = new HashMap<>();
	private final Map<IXtextDocument, OpenAadlResource> documentToOpenResourceMap = new HashMap<>();
	private final Map<String, List<OpenAadlResource>> qualifiedNameToOpenResourcesMap = new HashMap<>(); // List because qualified names are not unique. Qualified names will be stored in lowercase format
	private final Map<IXtextDocument, IXtextModelListener> documentToInternalModelListenerMap = new HashMap<>();
	private final List<IXtextModelListener> externalModelListeners = new CopyOnWriteArrayList<IXtextModelListener>();
	
	private static class OpenAadlResource {
		public final IResource file;
		public final LinkedList<IXtextDocument> documents = new LinkedList<>(); // Linked list of documents for the resource. More recently updated documents will be sorted before other documents
		public XtextResource xtextResource;
		public String rootQualifiedName; // May be null. Must be lowercase
		
		public OpenAadlResource(final IResource file, final IXtextDocument document) {
			this.file = file;
			this.documents.add(document);
		}
	}
	
	/**
	 * Finds the XtextResource which has a root object with the specified qualified name and has a URI that matches one of the specified resource descriptions
	 * @param qualifiedName
	 * @param resourceDescriptions
	 * @return
	 */
	public XtextResource getXtextResource(final String qualifiedName, final Collection<IResourceDescription> resourceDescriptions) {
		final List<OpenAadlResource> openResources = qualifiedNameToOpenResourcesMap.get(qualifiedName.toLowerCase());
		if(openResources == null) {
			return null;
		}
		
		for(final OpenAadlResource openResource : openResources) {
			if(openResource.xtextResource != null) {
				for(final IResourceDescription resDesc : resourceDescriptions) {
					final URI resourceUri = resDesc.getURI();		
					if(resourceUri.equals(openResource.xtextResource.getURI())) {
						return openResource.xtextResource;
					}
				}
			}
		}
		
		return null;
	}
	
	public IXtextDocument getDocument(final String qualifiedName, final Resource resource) {
		if(qualifiedName == null || resource == null) {
			return null;
		}
		
		final URI resourceUri = resource.getURI();
		if(resourceUri == null) {
			return null;
		}
		
		final List<OpenAadlResource> openAadlResources = qualifiedNameToOpenResourcesMap.get(qualifiedName);
		if(openAadlResources != null) {
			for(final OpenAadlResource openAadlResource : openAadlResources) {
				if(openAadlResource.xtextResource != null && openAadlResource.documents.size() > 0 && resourceUri.equals(openAadlResource.xtextResource.getURI())) {
					return openAadlResource.documents.getFirst();
				}
				
			}
		}
		
		return null;
	}
	
	public IXtextDocument getDocument(final IResource res) {
		final OpenAadlResource openResource = resourceToOpenResourceMap.get(res);
		return openResource == null || openResource.documents.size() == 0? null : openResource.documents.get(0);
	}
	
	public XtextResource getXtextResource(final IResource res) {
		final OpenAadlResource openResource = resourceToOpenResourceMap.get(res);
		return openResource == null ? null : openResource.xtextResource;
	}
	
	public void onXtextDocumentOpened(final IXtextDocument document) {
		// Get the file associated with the document
		final IFile file = document.readOnly(new IUnitOfWork<IFile, XtextResource>() {
			@Override
			public IFile exec(final XtextResource resource) throws Exception {
				return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(resource.getURI().toPlatformString(true)));
			}
		});
		
		// Create a new model listener
		final IXtextModelListener newModelListener = createModelListener(document);
		documentToInternalModelListenerMap.put(document, newModelListener);
		document.addModelListener(newModelListener);
		
		// Create a new open resource object
		OpenAadlResource openResource = resourceToOpenResourceMap.get(file);
		if(openResource == null) {			
			openResource = new OpenAadlResource(file, document);
			
			// Add to resourceToOpenResourceMap
			resourceToOpenResourceMap.put(file, openResource);
		} else {
			openResource.documents.addFirst(document);
		}		
		
		// Add the IXtextDocument -> OpenAadlResource mapping
		documentToOpenResourceMap.put(document, openResource);		
		
		// Trigger the initial model changed event.
		document.readOnly(new IUnitOfWork<String, XtextResource>() {
			@Override
			public String exec(final XtextResource resource) throws Exception {
				newModelListener.modelChanged(resource);
				return null;
			}
		});
	}	

	public void onXtextDocumentClosed(final IXtextDocument document) {
		// Remove the model listener
		final IXtextModelListener modelListener = documentToInternalModelListenerMap.get(document);
		if(modelListener != null) {
			// Execute one last model changed event
			document.readOnly(new IUnitOfWork<String, XtextResource>() {
				@Override
				public String exec(final XtextResource resource) throws Exception {
					modelListener.modelChanged(resource);
					return null;
				}
			});
			
			document.removeModelListener(modelListener);
			documentToInternalModelListenerMap.remove(document);
		}
		
		final OpenAadlResource openResource = documentToOpenResourceMap.get(document);
		if(openResource != null) {
			// Remove from maps
			openResource.documents.remove(document);
			documentToOpenResourceMap.remove(document);
			
			// handle the closing of the last document
			if(openResource.documents.size() == 0) {
				resourceToOpenResourceMap.remove(openResource.file);

				// Remove the resource from the qualifiedNameToOpenResourcesMap
				removeQualifiedNameMapping(openResource);
			}
		}
	}

	private IXtextModelListener createModelListener(final IXtextDocument document) {
		return new IXtextModelListener() {
			@Override
			public void modelChanged(final XtextResource resource) {
				final OpenAadlResource openResource = documentToOpenResourceMap.get(document);
				if(openResource != null) {
					openResource.xtextResource = resource;
							
					// Determine the new qualified name
					String newQualifiedName = null;
					if(resource != null && resource.getContents().size() > 0) {
						final EObject obj = resource.getContents().get(0);
						if(obj instanceof NamedElement) {		
							final String elementQualifiedName = ((NamedElement)obj).getQualifiedName();
							newQualifiedName = elementQualifiedName == null ? null : elementQualifiedName.toLowerCase();
						}
					}
					
					// If the qualified name has changed, update qualified name and mapping
					if((openResource.rootQualifiedName == null && newQualifiedName != null) || 
							(openResource.rootQualifiedName != null && !openResource.rootQualifiedName.equals(newQualifiedName))) {
						// Remove old name from mapping
						removeQualifiedNameMapping(openResource);
						
						// Update the qualified name
						openResource.rootQualifiedName = newQualifiedName;
						
						// Add new name to mapping
						if(newQualifiedName != null) {
							List<OpenAadlResource> openResources = qualifiedNameToOpenResourcesMap.get(openResource.rootQualifiedName);
							if(openResources == null) {
								openResources = new LinkedList<OpenAadlResource>();
								qualifiedNameToOpenResourcesMap.put(newQualifiedName, openResources);
							}
							
							// Add the resource to the open resource list
							openResources.add(openResource);
						}
					}

					// Notify others
					for(final IXtextModelListener l : externalModelListeners) {
						l.modelChanged(resource);
					}
				}
			}
		};
	}	
	
	public void addModelListener(final IXtextModelListener listener) {
		externalModelListeners.add(listener);
	}
	
	public void removeModelListener(final IXtextModelListener listener) {
		externalModelListeners.remove(listener);
	}
	
	private void removeQualifiedNameMapping(final OpenAadlResource openResource) {
		if(openResource.rootQualifiedName != null) {
			final List<OpenAadlResource> openResources = qualifiedNameToOpenResourcesMap.get(openResource.rootQualifiedName);
			if(openResources != null) {
				openResources.remove(openResource);
				
				if(openResources.size() == 0) {
					qualifiedNameToOpenResourcesMap.remove(openResource.rootQualifiedName);
				}
			}					
		}
	}
	
	/**
	 * Method for troubleshooting issues with the mappings
	 */
	@SuppressWarnings("unused")
	private void dumpStats() {
		int totalNumberOfDocumentsReferencesByOpenResources = 0;
		for(final OpenAadlResource openResource : resourceToOpenResourceMap.values()) {
			totalNumberOfDocumentsReferencesByOpenResources += openResource.documents.size();
		}
		
		System.out.println("Resources to Open Resource Mappings: " + resourceToOpenResourceMap.size());
		System.out.println("Document to Open Resource Mappings: " + documentToOpenResourceMap.size());
		System.out.println("Qualified Names to Open Resources Mappings: " + qualifiedNameToOpenResourcesMap.size());
		System.out.println("Document to Model Listener Mappings: " + documentToInternalModelListenerMap.size());
		System.out.println("Total Number of Documents References by Open Resources: " + totalNumberOfDocumentsReferencesByOpenResources);
	}
	
}
