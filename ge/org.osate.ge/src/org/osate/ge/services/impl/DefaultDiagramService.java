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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.services.DiagramService;
import org.osate.ge.ui.editor.AgeDiagramBehavior;
import org.osate.ge.ui.editor.AgeDiagramEditor;
import org.osate.ge.ui.util.SelectionHelper;
import org.osate.ge.util.Log;

public class DefaultDiagramService implements DiagramService {
	public static class ContextFunction extends SimpleServiceContextFunction<DiagramService> {
		@Override
		public DiagramService createService() {
			return new DefaultDiagramService();
		}		
	}
	
	private static class ClosedDiagramReference implements DiagramReference {
		private final ResourceSet rs;
		private final URI uri;
		private Diagram diagram = null;
		
		public ClosedDiagramReference(final ResourceSet rs, final URI uri) {
			this.rs = rs;
			this.uri = uri;
		}
		
		@Override
		public boolean isOpen() {
			return false;
		}

		@Override
		public Diagram getDiagram() {
			if(diagram == null) {
				final Resource resource = rs.getResource(uri, true);
				if(resource != null) {
					for(final EObject obj : resource.getContents()) {
						if(obj instanceof Diagram) {
							diagram = (Diagram)obj;
							break;		
						}											
					}
				}
			}
			
			return diagram;
		}

		@Override
		public AgeDiagramEditor getEditor() {
			return null;
		}
		
	}
	
	
	private static class OpenDiagramReference implements DiagramReference {
		private final AgeDiagramEditor editor;
		
		public OpenDiagramReference(final AgeDiagramEditor editor) {
			this.editor = editor;
		}
		
		@Override
		public boolean isOpen() {
			return true;
		}

		@Override
		public Diagram getDiagram() {
			return editor.getDiagramBehavior().getDiagramTypeProvider().getDiagram();
		}

		@Override
		public AgeDiagramEditor getEditor() {
			return editor;
		}
	}
		
	@Override
	public DiagramReference findFirstDiagramByRootBusinessObject(final NamedElement ne) {
		final String aadlElementName = ne.getQualifiedName();
		final List<DiagramReference> diagramRefs = findDiagrams();
		final URI resourceUri = ne.eResource().getURI();
		
		// Check open diagrams first
		for(final DiagramReference diagramRef : diagramRefs) {
			if(diagramRef.isOpen()) {
				final IFeatureProvider featureProvider = diagramRef.getEditor().getDiagramTypeProvider().getFeatureProvider();
				if(featureProvider != null) {
					final Object bo = AadlElementWrapper.unwrap(featureProvider.getBusinessObjectForPictogramElement(diagramRef.getDiagram()));
					if(bo != null && bo instanceof NamedElement) {
						final NamedElement tmpEl = (NamedElement)bo;
						if(tmpEl.getQualifiedName().equalsIgnoreCase(aadlElementName) && resourceUri.equals(tmpEl.eResource().getURI())) {
							return diagramRef;
						}
					}
				}
			}
		}
		
		// Check closed diagrams
		for(final DiagramReference diagramRef : diagramRefs) {
			if(!diagramRef.isOpen()) {
				// Create a feature provider and check if it is linked to the aadl element
				final Diagram diagram = diagramRef.getDiagram();
				if(diagram != null) {
					final IFeatureProvider featureProvider = GraphitiUi.getExtensionManager().createFeatureProvider(diagram);
					if(featureProvider != null) {
						final Object bo = AadlElementWrapper.unwrap(featureProvider.getBusinessObjectForPictogramElement(diagram));
						if(bo != null && bo instanceof NamedElement) {
							final NamedElement tmpEl = (NamedElement)bo;
							if(tmpEl.getQualifiedName().equalsIgnoreCase(aadlElementName) && resourceUri.equals(tmpEl.eResource().getURI())) {
								return diagramRef;
							}
						}
					}
				}
			}
		}
		
		return null;
	}

	@Override
	public void openOrCreateDiagramForRootBusinessObject(final NamedElement element) {
		if(!openExistingDiagramForRootBusinessObject(element)) {
			// If a diagram can not be found, create a new diagram
			Log.info("Existing diagram not found.");
				
			// Create and open the new resource
			final Resource diagramResource = createNewDiagram(element);
			openEditor((Diagram)diagramResource.getContents().get(0));
		}
	}
	
	private boolean openExistingDiagramForRootBusinessObject(final NamedElement element) {
		// Look for an existing diagram
		final DiagramReference diagramRef = findFirstDiagramByRootBusinessObject(element);
		if(diagramRef != null) {
			if(diagramRef.isOpen()) {
				Log.info("Existing diagram found. Activating existing editor...");
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(diagramRef.getEditor());
				return true;
			} else {
				final Diagram diagram = diagramRef.getDiagram();
				if(diagram != null) {
					Log.info("Existing diagram found. Opening new editor...");
					openEditor(diagram);
					return true;
				}
			}
		}
		
		return false;
	}
	/**
	 * Opens a diagram editor for the specified resource.
	 * @param resource the resource to edit. Must contain a diagram object.
	 */
	private void openEditor(final Diagram diagram) {
		final String providerId = GraphitiUi.getExtensionManager().getDiagramTypeProviderId(diagram.getDiagramTypeId());	
		final DiagramEditorInput editorInput = DiagramEditorInput.createEditorInput(diagram, providerId);
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(editorInput, AgeDiagramEditor.DIAGRAM_EDITOR_ID);
		} catch (PartInitException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Determines the diagram type id for the type of diagram used to edit the specified element
	 * @param element the element for which to lookup the diagram type. AadlPackage, ComplementImplementation, ComponentClassifier, and FeatureGroupType objects are supported
	 * @return the diagram type id
	 */
	private String getDiagramTypeId(final NamedElement element) {
		if(element instanceof AadlPackage || element instanceof ComponentImplementation || element instanceof ComponentType || element instanceof FeatureGroupType) {
			return AgeDiagramBehavior.AADL_DIAGRAM_TYPE_ID;
		} else {
			throw new RuntimeException("Unexpected named element type: " + element.getClass().getSimpleName());
		}
	}
	
	/**
	 * Creates a new resource to hold a new diagram.  
	 * @param resourceSet the resource set that will contain the new resource.
	 * @param baseFilename the desired filename of the file that will store the resource. The method will adjust the filename to avoid overwriting an existing file.
	 * @return the resource containing the new diagram
	 */
	private Resource createDiagramResource(final ResourceSet resourceSet, final IProject project, final String baseFilename) { 
		boolean retry;
		String suffix = "";
		int tryCount = 1;
		Resource createdResource = null;
		
		do
		{
			retry = false;
			final IFolder diagramFolder = project.getFolder("diagrams/");
			final IFile diagramFile = diagramFolder.getFile(baseFilename + suffix + AgeDiagramEditor.EXTENSION);
			final URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
			
			// Try to get the resource in case it is already in the resource set, otherwise create a new one
			createdResource = resourceSet.getResource(uri, false);
			if(createdResource == null) {
				createdResource = resourceSet.createResource(uri);	
			} else {
				if(createdResource.isLoaded()) {
					if(resourceSet.getURIConverter().exists(uri, null)) {
						retry = true;
						tryCount++;
						suffix = Integer.toString(tryCount);
						continue;
					}
				}
				createdResource.unload();
			}
		} while(retry);
		
		return createdResource;
	}
	
	/**
	 * Builds a unique filename for a diagram. Does not include the extension.
	 */
	private String buildUniqueFilename() {
		return UUID.randomUUID().toString();
	}
	
	/**
	 * Creates a new diagram for the specified element
	 * @param namedElement the element for which to create the diagram 
	 * @return the new resource containing the created diagram
	 */
	private Resource createNewDiagram(final NamedElement namedElement) {
		// Determine the diagram type id
		final String diagramTypeId = getDiagramTypeId(namedElement);
		Log.info("Creating diagram of type '" + diagramTypeId + "' for model element '" + namedElement.getName() + "'");
		
		// Get the default resource set to hold the new resource
		final ResourceSet resourceSet = new ResourceSetImpl();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(resourceSet);
		boolean editingDomainCreated = false;
		try {
			if(editingDomain == null) {
				Log.info("Creating a editing domain");
				editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
				editingDomainCreated = true;
			}
	
			// Create the diagram and its file
			final IPeService peService = Graphiti.getPeService();
			final Diagram diagram = peService.createDiagram(diagramTypeId, namedElement.getQualifiedName(), true);
			
			GraphitiUi.getExtensionManager().createFeatureProvider(diagram).link(diagram, new AadlElementWrapper(namedElement));
			
			// Create a resource to hold the diagram
			final IProject project = SelectionHelper.getProject(namedElement.eResource());
			final Resource createdResource = createDiagramResource(editingDomain.getResourceSet(), project, buildUniqueFilename());
			
			// Store the diagram in the resource
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				@Override
				protected void doExecute() {
					createdResource.getContents().add(diagram);
				}			
			});		
			
			try {
				createdResource.save(null);
			} catch (IOException e) {
				throw new RuntimeException("Error saving new diagram", e);
			}
			
			return createdResource;
		} finally {		
			// Dispose of the editing domain if we created it
			if(editingDomainCreated) {
				editingDomain.dispose();
			}
		}
	}
	
	/**
	 * Returns all diagrams. If a diagram is open it returns the open diagram
	 * @return
	 */
	@Override
	public List<DiagramReference> findDiagrams() {
		final List<DiagramReference> diagramRefs = new ArrayList<DiagramReference>();
		final Map<URI, Diagram> openDiagrams = new HashMap<URI, Diagram>();		

		for(final IEditorReference editorRef : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences()) {
			final IEditorPart editor = editorRef.getEditor(false); // If restore is true then the editor is automatically updated
			if(editor instanceof AgeDiagramEditor) {
				final AgeDiagramEditor diagramEditor = (AgeDiagramEditor)editor;
				final AgeDiagramBehavior behavior = (AgeDiagramBehavior)diagramEditor.getDiagramBehavior();

				if(behavior != null && behavior.getDiagramTypeProvider() != null) {
					final Diagram diagram = behavior.getDiagramTypeProvider().getDiagram();
					if(diagram != null) {
						openDiagrams.put(diagram.eResource().getURI(), diagram);
						diagramRefs.add(new OpenDiagramReference(diagramEditor));
					}
				}
			}
		}
		
		final List<IFile> files = findDiagramFiles(ResourcesPlugin.getWorkspace().getRoot(), null);
		final ResourceSet resourceSet = new ResourceSetImpl();
		for(final IFile file : files) {
			// Load the EMF Resource
			final URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			
			// Check if the diagram is already open
			if(!openDiagrams.containsKey(uri)) {
				diagramRefs.add(new ClosedDiagramReference(resourceSet, uri));		
			}
		}
		
		return diagramRefs;
	}
	
	/**
	 * Finds all files with the diagram extension in the specified container and its children
	 * @param container the container in which to look for diagrams
	 * @param diagramFiles a list to which to add the results. Optional.
	 * @return diagramFiles if specified otherwise, a newly created list containing the results
	 */
	private List<IFile> findDiagramFiles(final IContainer container, List<IFile> diagramFiles) {
		if(diagramFiles == null) {
			diagramFiles = new ArrayList<IFile>();
		}
		
		try {
			if(container.isAccessible()) {
				for(final IResource resource : container.members()) {
					 if (resource instanceof IContainer) {
				         findDiagramFiles((IContainer)resource, diagramFiles);
				     } else if (resource instanceof IFile) {
				         final IFile file = (IFile) resource;
				         if (file.getName().endsWith(AgeDiagramEditor.EXTENSION)) {
				              diagramFiles.add(file);
				         }
				     }
				}
			}
		} catch (CoreException e) {
			Log.error("Error finding diagrams", e);
			throw new RuntimeException(e);
		}
		
		return diagramFiles;
	}

	@Override
	public String getName(final IFile diagramFile) {
		String name = null;
		try {
			// Check modification time stamp
			final String modStampPropValue = diagramFile.getPersistentProperty(this.diagramNameModificationStampPropertyName);
			if(modStampPropValue != null && modStampPropValue.equals(Long.toString(diagramFile.getModificationStamp()))) {
				name = diagramFile.getPersistentProperty(diagramNamePropertyName);				
			}			
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		if(name == null) {
			final ResourceSet resourceSet = new ResourceSetImpl();
			// Load the EMF Resource
			final URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
			try {
				final Resource resource = resourceSet.getResource(uri, true);
				if(resource.getContents().size() > 0 && resource.getContents().get(0) instanceof Diagram) {
					final Diagram diagram = (Diagram)resource.getContents().get(0);
					name = diagram.getName();
				}
			} catch(final RuntimeException e) {				
				e.printStackTrace();
			}
		}
		
		return name;
	}
	
	@Override
	public void savePersistentProperties(final Diagram diagram) {
		// Set the persistent properties
		final URI eUri = diagram.eResource().getURI();
		if (eUri.isPlatformResource()) {
			String platformString = eUri.toPlatformString(true);
			final IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
			
			try {
				fileResource.setPersistentProperty(diagramNamePropertyName, diagram.getName());
				fileResource.setPersistentProperty(diagramNameModificationStampPropertyName, Long.toString(fileResource.getModificationStamp()));
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}
	
	private final QualifiedName diagramNameModificationStampPropertyName = new QualifiedName("org.osate.ge", "diagram_name_modification_stamp");
	private final QualifiedName diagramNamePropertyName = new QualifiedName("org.osate.ge", "diagram_name");
}
