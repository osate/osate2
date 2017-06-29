// Based on OSATE Graphical Editor. Modifications are: 
/*
Copyright (c) 2016, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.EmfContainerProvider;
import org.osate.ge.internal.AgeDiagramProvider;
import org.osate.ge.internal.diagram.AgeDiagram;
import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.DiagramConfiguration;
import org.osate.ge.internal.diagram.DiagramConfigurationBuilder;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.diagram.DiagramModification;
import org.osate.ge.internal.diagram.DiagramModifier;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.diagram.DiagramSerialization;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.SavedAadlResourceService;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.services.DiagramService.ReferenceCollection;
import org.osate.ge.internal.services.DiagramService.DiagramReference;
import org.osate.ge.internal.ui.editor.AgeDiagramBehavior;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.util.EditorUtil;
import org.osate.ge.internal.ui.util.SelectionHelper;
import org.osate.ge.internal.util.BusinessObjectProviderHelper;
import org.osate.ge.internal.util.DiagramUtil;
import org.osate.ge.internal.util.Log;
import org.osate.ge.internal.util.NonUndoableToolCommand;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class DefaultDiagramService implements DiagramService {
	private static final QualifiedName LEGACY_PROPERTY_NAME_MODIFICATION_TIMESTAMP = new QualifiedName("org.osate.ge", "diagram_name_modification_stamp");
	private static final QualifiedName LEGACY_PROPERTY_DIAGRAM_NAME = new QualifiedName("org.osate.ge", "diagram_name");
	private static final Pattern uuidFilenamePattern = Pattern.compile("[0-9a-f]{4,}-[0-9a-f]{2,}-[0-9a-f]{2,}-[0-9a-f]{2,}-[0-9a-f]{6,}\\.aadl_diagram");

	private final ReferenceService referenceService;
	private final ExtensionRegistryService extRegistry;
	
	private static class DiagramIndex {
		private final Map<IProject, ProjectDiagramIndex> projectToProjectDiagramIndexMap = new HashMap<>();
		
		public void rebuild(final IProject project) {
			projectToProjectDiagramIndexMap.remove(project);
			
			// TODO: Need to break this up into smaller portions to allow updating just part of the index
			// TODO: Need to allow indexing all the elements in the diagrams. Only for closed?
			// TODO: Need refreshing
			
			final ProjectDiagramIndex projectDiagramIndex = new ProjectDiagramIndex();
			
			// Get diagram references
			final List<InternalDiagramReference> newDiagramReferences = new ArrayList<>();
			
			// Get references for open diagrams
			final Set<IFile> openDiagramFiles = new HashSet<>();
			for(final IEditorReference editorRef : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences()) {
				final IEditorPart editor = editorRef.getEditor(false); // If restore is true then the editor is automatically updated
				if(editor instanceof AgeDiagramEditor) {
					final AgeDiagramEditor diagramEditor = (AgeDiagramEditor)editor;
					final AgeDiagramBehavior behavior = (AgeDiagramBehavior)diagramEditor.getDiagramBehavior();

					if(behavior != null) {
						if(project.equals(behavior.getProject())) {
							final IFile file = behavior.getFile();
							if(file != null) {
								openDiagramFiles.add(file);
								newDiagramReferences.add(InternalDiagramReference.createOpen(file, diagramEditor));
							}
						}
					}
				}
			}
			
			// Build list of all files
			final List<IFile> files = new ArrayList<>();
			findDiagramFiles(project, files);
			
			// Create diagram references as appropriate
			for(final IFile file : files) {			
				// Check if the diagram is already open
				if(!openDiagramFiles.contains(file)) {
					newDiagramReferences.add(InternalDiagramReference.createClosed(file));		
				}
			}
			
			// Add the new diagram references to the index
			for(final InternalDiagramReference diagramRef : newDiagramReferences) {
				final CanonicalBusinessObjectReference canonicalBusinessObjectReference = diagramRef.getCanonicalReference();
				if(canonicalBusinessObjectReference != null) {
					projectDiagramIndex.add(canonicalBusinessObjectReference, diagramRef);
				}
			}
			
			projectToProjectDiagramIndexMap.put(project,  projectDiagramIndex);
		}
		
		/**
		 * Finds all files with the diagram extension in the specified container and its children
		 * @param container the container in which to look for diagrams
		 * @param diagramFiles a list to which to add the results. Optional.
		 * @return diagramFiles if specified otherwise, a newly created list containing the results
		 */
		private static List<IFile> findDiagramFiles(final IContainer container, List<IFile> diagramFiles) {
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
		
		public List<InternalDiagramReference> findDiagrams(final IProject project) {
			final List<InternalDiagramReference> diagramRefs = new ArrayList<>();
			final ProjectDiagramIndex projectDiagramIndex = projectToProjectDiagramIndexMap.get(project);
			if(projectDiagramIndex != null) {
				for(final List<InternalDiagramReference> projectDiagrams : projectDiagramIndex.contextRefToDiagramMap.values()) {
					diagramRefs.addAll(projectDiagrams);
				}				
			}
			
			return diagramRefs;
		}
	}
	
	private static class ProjectDiagramIndex {
		private final Map<CanonicalBusinessObjectReference, List<InternalDiagramReference>> contextRefToDiagramMap = new HashMap<>();
		
		public void add(final CanonicalBusinessObjectReference contextRef, final InternalDiagramReference ref) {
			if(contextRef != null) {
				List<InternalDiagramReference> diagramReferences = contextRefToDiagramMap.get(contextRef);
				
				// Create the list of references for the specified context if necessary
				if(diagramReferences == null) {
					diagramReferences = new ArrayList<>();
					contextRefToDiagramMap.put(contextRef, diagramReferences);
				}
				
				diagramReferences.add(ref);
			}
		}
	}
	
	public static class ContextFunction extends SimpleServiceContextFunction<DiagramService> {
		@Override
		public DiagramService createService(final IEclipseContext context) {
			return new DefaultDiagramService(context.get(ReferenceService.class), context.get(ExtensionRegistryService.class));
		}		
	}
	
	// Implementation of DiagramReference
	private static class InternalDiagramReference implements DiagramReference {		
		private final IFile fileResource;
		private final AgeDiagramEditor editor;
		private final boolean isOpen;
		
		public static InternalDiagramReference createOpen(final IFile file,
				final AgeDiagramEditor editor) {
			return new InternalDiagramReference(file, editor, true);
		}
		
		public static InternalDiagramReference createClosed(final IFile file) {
			return new InternalDiagramReference(file, null, false);
		}
		
		private InternalDiagramReference(final IFile file, 
				final AgeDiagramEditor editor,
				final boolean isOpen) {
			this.fileResource = Objects.requireNonNull(file, "file must not be null");
			this.isOpen = isOpen;
			this.editor = editor;
			
			if(isOpen) {
				Objects.requireNonNull(editor, "editor must not be null if the diagram is open");
			}
		}

		public IFile getFile() {
			return fileResource;
		}
		
		@Override
		public AgeDiagramEditor getEditor() {
			return editor;
		}
		
		@Override
		public boolean isOpen() {
			return isOpen;
		}	
		
		public CanonicalBusinessObjectReference getCanonicalReference() {
			// Attempt to use the reference which is stored as a persistent property
			final MetadataValue contextRefSegsValue = MetadataValue.get(fileResource, MetadataValue.PROPERTY_DIAGRAM_CONTEXT_REFERENCE);
			if(contextRefSegsValue != null) {
				final String[] contextRefSegs = (String[])contextRefSegsValue.value;				
				if(contextRefSegs== null) {
					return null;
				} else {			
					return new CanonicalBusinessObjectReference(contextRefSegs);
				}
			}			

			// If the reference wasn't loaded from cache, read from file
			// Process canonical reference for both legacy and native diagrams
			CanonicalBusinessObjectReference ref = null;
			try {
				if(DiagramUtil.isLegacy(fileResource)) {
					// Load the graphiti diagram
					final ResourceSet resourceSet = new ResourceSetImpl();
					final URI uri = URI.createPlatformResourceURI(fileResource.getFullPath().toString(), true);
					final Resource resource = resourceSet.getResource(uri, true);
					if(resource != null && 
							resource.getContents().size() > 0 && 
							resource.getContents().get(0) instanceof Diagram) {
						final Diagram tmpDiagram = (Diagram)resource.getContents().get(0);
						ref = DiagramUtil.getLegacyReference(tmpDiagram);
					}
				} else {
					if(fileResource.getLocation() != null) {
						final ResourceSet rs = new ResourceSetImpl();
						final URI diagramUri = URI.createPlatformResourceURI(fileResource.getFullPath().toString(), true);
						final Resource resource = rs.createResource(diagramUri);
						resource.load(Collections.emptyMap());
						if(resource.getContents().size() != 0 && resource.getContents().get(0) instanceof org.osate.ge.mm.diagram.Diagram) {
							final org.osate.ge.mm.diagram.Diagram mmDiagram = (org.osate.ge.mm.diagram.Diagram)resource.getContents().get(0);
							if(mmDiagram.getConfig() != null) {
								ref = DiagramSerialization.convert(mmDiagram.getConfig().getContext());
							}
						}
					}
				}
			} catch (final IOException e) {
				// Ignore exception. Non-critical error. Print stack trace.
            	e.printStackTrace();
            	
            	// Return null so that the value will not be stored as a persistent property.
            	return null;
			}
				
			//  Serialize the reference segments
			MetadataValue.set(fileResource, MetadataValue.PROPERTY_DIAGRAM_CONTEXT_REFERENCE, ref == null ? null : ref.toSegmentArray());
			
			return ref;
		}
	}	
	
	// Wrapper class for metadata serialized to persistent properties. Allows distinguishing between an unspecified/unreadable value and a null value.
	private static class MetadataValue {
		private static final QualifiedName PROPERTY_METADATA_MODIFICATION_TIMESTAMP = new QualifiedName("org.osate.ge", "metadata_modification_timestamp");
		public static final QualifiedName PROPERTY_DIAGRAM_CONTEXT_REFERENCE = new QualifiedName("org.osate.ge", "context_reference");
		
		public final Object value;
		
		public MetadataValue(final Object value) {
			this.value = value;
		}
		
		/**
		 * Will return null if and only if the property could not be read or was not previously set.
		 */
		public static MetadataValue get(final IFile fileResource, final QualifiedName propertyName) {
			// Attempt to use the reference which is stored as a persistent property
			try {
				// Check modification time stamp
				final String metadataTimestampPropValue = fileResource.getPersistentProperty(PROPERTY_METADATA_MODIFICATION_TIMESTAMP);
				if(metadataTimestampPropValue != null && metadataTimestampPropValue.equals(Long.toString(fileResource.getModificationStamp()))) {
					final String cachedDiagramContextStr = fileResource.getPersistentProperty(propertyName);
					if(cachedDiagramContextStr != null) {
	                    try(final ByteArrayInputStream bi = new ByteArrayInputStream(Base64.getDecoder().decode(cachedDiagramContextStr))) {
	                    	final ObjectInputStream si = new ObjectInputStream(bi);
	                        return new MetadataValue(si.readObject());	
	                    }
					}
				}
			} catch (final Exception e) {
				// Ignore exception. Non-critical error. Print stack trace.
	        	e.printStackTrace();
			}
			
			return null;						
		}
		
		public static void set(final IFile fileResource, final QualifiedName propertyName, final Object value) {
			try {
				 try(final ByteArrayOutputStream bs = new ByteArrayOutputStream()) {
	                 final ObjectOutputStream so = new ObjectOutputStream(bs);
	                 so.writeObject(value);
	                 so.flush();
	                 final String encodedString = Base64.getEncoder().encodeToString(bs.toByteArray()); 	                 
	                 fileResource.setPersistentProperty(propertyName, encodedString);
				 }
				 
				 fileResource.setPersistentProperty(PROPERTY_METADATA_MODIFICATION_TIMESTAMP, Long.toString(fileResource.getModificationStamp()));
			} catch (Exception e) {
				// Ignore exception. Non-critical error. Print stack trace.
				e.printStackTrace();
			}
		}
	}
	
	public DefaultDiagramService(final ReferenceService referenceBuilder,
			final ExtensionRegistryService extRegistry) {
		this.referenceService = Objects.requireNonNull(referenceBuilder, "referenceBuilder must not be null");
		this.extRegistry = Objects.requireNonNull(extRegistry, "extRegistry must not be null");
	}
		
	@Override
	public List<InternalDiagramReference> findDiagramsByContextBusinessObject(final Object bo) {
		final CanonicalBusinessObjectReference boReference = referenceService.getCanonicalReference(bo);
		if(boReference == null) {
			throw new RuntimeException("Unable to get canonical reference for business object : " + bo);
		}
		
		final IProject project = getProject(bo);
		if(project == null) {
			throw new RuntimeException("Unable to get project for business object: " + bo);
		}

		// Build a set containing the project containing the business object and all projects which reference that project.
		final HashSet<IProject> relevantProjects = new HashSet<>();
		relevantProjects.add(project);
		for(final IProject referencingProject : project.getReferencingProjects()) {
			if(referencingProject.isAccessible()) {
				relevantProjects.add(referencingProject);
			}
		}

		// Return diagrams which have a root context matching the specified business object		
		return findDiagrams(relevantProjects).stream().filter((dr) -> boReference.equals(dr.getCanonicalReference())).collect(Collectors.toList());
	}

	@Override
	public AgeDiagramEditor openOrCreateDiagramForBusinessObject(final Object bo, final boolean promptForCreate, final boolean promptForConfigureAfterCreate) {
		// Look for an existing diagram
		final List<InternalDiagramReference> diagramRefs = findDiagramsByContextBusinessObject(bo);
		
		// If there is just one diagram, open it 
		if(diagramRefs.size() == 1) {
			final InternalDiagramReference diagramRef = diagramRefs.get(0);
			if(diagramRef.isOpen()) {
				Log.info("Existing diagram found. Activating existing editor...");
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(diagramRef.getEditor());
				return diagramRef.getEditor();
			} else {				
				Log.info("Existing diagram found. Opening new editor...");
				return EditorUtil.openEditor(diagramRef.getFile(), false);
			}
		} else if(diagramRefs.size() == 0) {
			// Prompt user to determine whether a new diagram should be created
			if(!promptForCreate || MessageDialog.openQuestion(null, "Create New Diagram?", "An existing diagram was not found for the specified model element.\nCreate new diagram?")) {
				// Create and open a new diagram
				final IFile diagramFile = createDiagram(bo);
				final AgeDiagramEditor editor = EditorUtil.openEditor(diagramFile, promptForConfigureAfterCreate);				
				return editor;				
			} else {
				return null;
			}
		} else {
			final InternalDiagramReference diagramRef = promptForDiagram(diagramRefs);
			return diagramRef == null ? null : EditorUtil.openEditor(diagramRef.getFile(), false);
		}				
	}
	
	private InternalDiagramReference promptForDiagram(final List<InternalDiagramReference> diagramRefs) {
		// Sort the diagram references
		final InternalDiagramReference[] sortedDiagramRefs = diagramRefs.stream().sorted((r1, r2) -> getName(r1.getFile()).compareToIgnoreCase(getName(r2.getFile()))).toArray(InternalDiagramReference[]::new);
		
		// Prompt user to select a single dialog reference
		final ListDialog dialog = new ListDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());				
		dialog.setAddCancelButton(true);
		dialog.setTitle("Select Diagram");
		dialog.setMessage("Select a Diagram to Open");
		dialog.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(final Object element) {
				if(element instanceof InternalDiagramReference) {
					final InternalDiagramReference diagramRef = (InternalDiagramReference)element;
					return getName(diagramRef.getFile());
				}
				
				return super.getText(element);
			}
		});
		dialog.setContentProvider(new ArrayContentProvider());
		dialog.setInput(sortedDiagramRefs);
		dialog.setInitialElementSelections(Collections.singletonList(sortedDiagramRefs[0]));
		dialog.open();
		
		final Object[] result = dialog.getResult();
		return (result != null && result.length > 0) ? (InternalDiagramReference)result[0] : null;
	}
	
	/**
	 * Gets a new IFile for a new diagram. 
	 * @param resourceSet the resource set that will contain the new resource.
	 * @param baseFilename the desired filename of the file that will store the resource. The method will adjust the filename to avoid returning an existing file resource
	 * @return the file resource for the new diagram. The file resource will be one which does not exist.
	 */
	private IFile getNewDiagramFile(final IProject project, final String baseFilename) { 
		int nameCount = 1;
		IFile diagramFile;
		do
		{
			final IFolder diagramFolder = project.getFolder("diagrams/");
			final String suffix = nameCount == 1 ? "" : "(" + nameCount + ")";
			diagramFile = diagramFolder.getFile(baseFilename + suffix + AgeDiagramEditor.EXTENSION);
			nameCount++;
		} while(diagramFile.exists());
		
		return diagramFile;
	}
		
	@Override
	public IFile createDiagram(final Object contextBo) {
		// Create an AgeDiagram object. This object doesn't have to be completely valid. It just needs to be able to be written.
		final AgeDiagram diagram = new AgeDiagram();
		
		// Build diagram configuration
		final CanonicalBusinessObjectReference contextBoRef = Objects.requireNonNull(referenceService.getCanonicalReference(contextBo), "Unable to build canonical reference for business object: " + contextBo);
		diagram.setDiagramConfiguration(new DiagramConfigurationBuilder().setContextBoReference(contextBoRef).build());			
		
		final IProject project = Objects.requireNonNull(getProject(contextBo), "Unable to get project for business object: " + contextBo);
		
		// Determine the filename to use for the new diagram
		final String baseDiagramName = contextBo instanceof NamedElement ? ((NamedElement)contextBo).getQualifiedName().replaceAll("::|:|\\.", "_") : "untitled_diagram";
		final IFile newDiagramFile = getNewDiagramFile(project, baseDiagramName);

		final URI newDiagramUri = URI.createPlatformResourceURI(newDiagramFile.getFullPath().toString(), true);
		DiagramSerialization.write(diagram, newDiagramUri);
				
		try {
			newDiagramFile.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (final CoreException e) {
			throw new RuntimeException(e);
		}

		return newDiagramFile;
	}
	
	/**
	 * Returns all diagrams in the specified projects.
	 * @return
	 */
	@Override
	public List<InternalDiagramReference> findDiagrams(final Set<IProject> projects) {
		// TODO: Use existing index after implementation
		final DiagramIndex index = new DiagramIndex();
		for(final IProject project : projects) {			
			index.rebuild(project);			
		}
		
		// Build list of references from the index
		final List<InternalDiagramReference> results = new ArrayList<>();
		for(final IProject project : projects) {			
			results.addAll(index.findDiagrams(project));
		}
		
		return results;
	}
	
	@Override
	public String getName(final IFile diagramFile) {
		String name = null;
		if(diagramFile.exists()) {
			// Handle legacy diagram files which have names based on UUIDs
			if(uuidFilenamePattern.matcher(diagramFile.getName()).matches()) {
				// Attempt to use the name from the persistent property
				try {
					// Check modification time stamp
					final String modStampPropValue = diagramFile.getPersistentProperty(LEGACY_PROPERTY_NAME_MODIFICATION_TIMESTAMP);
					if(modStampPropValue != null && modStampPropValue.equals(Long.toString(diagramFile.getModificationStamp()))) {
						name = diagramFile.getPersistentProperty(LEGACY_PROPERTY_DIAGRAM_NAME);
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
							name = diagram.getName() + " (Legacy)";
						}
					} catch(final RuntimeException e) {				
						// Ignore. Print to stderr
						e.printStackTrace();
					}
					
					// Use the diagram file's name if the name could not be determined for any reason
					if(name == null) {
						name = diagramFile.getName();
					}
					
					// Update persistent properties.
					try {
						diagramFile.setPersistentProperty(LEGACY_PROPERTY_DIAGRAM_NAME, name);
						diagramFile.setPersistentProperty(LEGACY_PROPERTY_NAME_MODIFICATION_TIMESTAMP, Long.toString(diagramFile.getModificationStamp()));
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}

			// Default to the diagram's filename
			if(name == null) {
				name = diagramFile.getName();
			}
		}
		
		return name;
	}
	
	@Override
	public void clearLegacyPersistentProperties(final IResource fileResource) {
		// Clear the persistent properties
		try {
			fileResource.setPersistentProperty(LEGACY_PROPERTY_DIAGRAM_NAME, null);
			fileResource.setPersistentProperty(LEGACY_PROPERTY_NAME_MODIFICATION_TIMESTAMP, null);
		} catch (final CoreException e) {
			// Ignore exceptions
		}
	}

	private IProject getProject(Object bo) {
		final Resource resource = getResource(bo);
		if(resource != null) {
			final URI uri = resource.getURI();
			if(uri != null) {
				return SelectionHelper.getProject(uri);
			}
		}
		
		return null;
	}
	
	private Resource getResource(Object bo) {		
		final EObject eObject;
		
		// Handle EObject instances without delegating to specialized handlers
		if(bo instanceof EObject) {
			eObject = (EObject)bo;
		} else if(bo instanceof EmfContainerProvider) { // Use the EMF Object container if the business object is not an EMF Object
			final EObject container = ((EmfContainerProvider)bo).getEmfContainer();
			if(container == null) {
				return null;
			}
			
			eObject = container;
		} else {
			return null;
		}

		return eObject.eResource();
	}
	
	// TODO: Will an open diagram reference have a separate closed diagram reference?
	class InternalReferencesToUpdate implements ReferenceCollection {
		// TODO: Rename. Mapping from internal diagram references to a mapping from original diagram reference to lists of references to update
		private final Map<InternalDiagramReference, Map<CanonicalBusinessObjectReference, Collection<ReferenceToUpdate>>> info = new HashMap<>();
		
		@Override
		// TODO: Decide how much needs to be in the service
		public void update(final Map<CanonicalBusinessObjectReference, Object> originalCanonicalReferenceToNewObjectMap) {
			// TODO: Rename variable
			for(final Entry<InternalDiagramReference, Map<CanonicalBusinessObjectReference, Collection<ReferenceToUpdate>>> a : info.entrySet()) {
				final InternalDiagramReference diagramRef = a.getKey();
				final Map<CanonicalBusinessObjectReference, Collection<ReferenceToUpdate>> originalCanonicalRefToReferenceMap = a.getValue();
				// TODO: Open resource to modify closed diagmras

				// Handle closed diagrams
				final ResourceSet rs = new ResourceSetImpl();
				final URI diagramUri = URI.createPlatformResourceURI(diagramRef.getFile().getFullPath().toString(), true);
				final Resource diagramResource = rs.createResource(diagramUri);
				try {
					if(diagramRef.isOpen()) {
						final AgeDiagramEditor editor = diagramRef.getEditor();
						final AgeDiagramProvider diagramProvider = (AgeDiagramProvider)editor.getAdapter(AgeDiagramProvider.class);
						// TODO: Check for null
						final AgeDiagram diagram = diagramProvider.getAgeDiagram();
						
						//NonUndoableToolCommand
						editor.getEditingDomain().getCommandStack().execute(new NonUndoableToolCommand() {	
							@Override
							public void execute() {
								diagram.modify(new DiagramModifier() {					
									@Override
									public void modify(final DiagramModification m) {
										updateReferences(originalCanonicalReferenceToNewObjectMap, originalCanonicalRefToReferenceMap, diagramResource, m);
									}
								});
							}
						});
					} else {
						updateReferences(originalCanonicalReferenceToNewObjectMap, originalCanonicalRefToReferenceMap, diagramResource, null);
					}
				} finally {
					// Save and unload the resource if it was loaded
					if(diagramResource.isLoaded()) {
						try {
							diagramResource.save(Collections.emptyMap());
						} catch (final IOException e) {
							// Ignore. Print stack trace so it will show in the console during development.
							e.printStackTrace();
						}
						diagramResource.unload();
					}
				}
			}		
		}
		
		private void updateReferences(final Map<CanonicalBusinessObjectReference, Object> originalCanonicalReferenceToNewObjectMap,
				final Map<CanonicalBusinessObjectReference, Collection<ReferenceToUpdate>> originalCanonicalRefToReferenceMap,
				final Resource diagramResource,
				final DiagramModification diagramModification) {
			try {
				referenceUpdateResource = diagramResource;
				referenceUpdateModification = diagramModification;
				for(final Entry<CanonicalBusinessObjectReference, Collection<ReferenceToUpdate>> originalCanonicalRefToReferencesToUpdateEntry : originalCanonicalRefToReferenceMap.entrySet()) {
					final CanonicalBusinessObjectReference originalCanonicalReference = originalCanonicalRefToReferencesToUpdateEntry.getKey();
					final Object newBo = originalCanonicalReferenceToNewObjectMap.get(originalCanonicalReference);
					if(newBo != null) {
						for(final ReferenceToUpdate referenceToUpdate : originalCanonicalRefToReferencesToUpdateEntry.getValue()) {
							referenceToUpdate.update(newBo);
						}
					}
				}
			} finally {
				referenceUpdateResource = null;
				referenceUpdateModification = null;
			}
		}
		
		public void addReference(final InternalDiagramReference diagramRef, 
				final CanonicalBusinessObjectReference originalCanonicalReference,
				final ReferenceToUpdate reference) {
			// TODO: Rename
			Map<CanonicalBusinessObjectReference, Collection<ReferenceToUpdate>> canonicalReferenceToUpdateableReferenceMap = info.get(diagramRef);
			if(canonicalReferenceToUpdateableReferenceMap == null) {
				canonicalReferenceToUpdateableReferenceMap = new HashMap<>();
				info.put(diagramRef, canonicalReferenceToUpdateableReferenceMap);
			}
			
			Collection<ReferenceToUpdate> updateableReferences = canonicalReferenceToUpdateableReferenceMap.get(originalCanonicalReference);
			if(updateableReferences == null) {
				updateableReferences = new ArrayList<>();
				canonicalReferenceToUpdateableReferenceMap.put(originalCanonicalReference, updateableReferences);
			}
			
			updateableReferences.add(reference);
		}
		
		public Collection<Entry<CanonicalBusinessObjectReference, Collection<ReferenceToUpdate>>> getReferences(final InternalDiagramReference ref) {
			final Map<CanonicalBusinessObjectReference, Collection<ReferenceToUpdate>> canonicalReferenceToUpdateableReferenceMap = info.get(ref); // TODO
			if(canonicalReferenceToUpdateableReferenceMap == null) {
				return Collections.emptyList();
			}
			
			return canonicalReferenceToUpdateableReferenceMap.entrySet();
		}
	}
	
	// Variables used during the update process
	private Resource referenceUpdateResource;
	private DiagramModification referenceUpdateModification;
	
	interface ReferenceToUpdate { // TODO: Rename?
		void update(Object newBo);
	}

	// Updateable Reference Implementations
	class OpenDiagramContextReference implements ReferenceToUpdate {
		private final AgeDiagram diagram;
		
		public OpenDiagramContextReference(final AgeDiagram diagram) {
			this.diagram = Objects.requireNonNull(diagram, "diagram must not be null");
		}
		
		@Override
		public void update(final Object newBo) {
			// TODO: Should update be passed in the canonical reference or something to avoid repeated lookups of the relative reference?
			final CanonicalBusinessObjectReference newContextRef = referenceService.getCanonicalReference(newBo);
			if(newContextRef != null) {
				diagram.setDiagramConfiguration(new DiagramConfigurationBuilder().setContextBoReference(newContextRef).build());
			}
		}		
	}
	
	class OpenDiagramElementReference implements ReferenceToUpdate {
		private final DiagramElement diagramElement;
		
		public OpenDiagramElementReference(final DiagramElement diagramElement) {
			this.diagramElement = Objects.requireNonNull(diagramElement, "diagramElement must not be null");
		}
		
		@Override
		public void update(final Object newBo) {
			// TODO: Should update be passed in the relative reference or something to avoid repeated lookups of the relative reference?
			final RelativeBusinessObjectReference newRelRef = referenceService.getRelativeReference(newBo);
			if(newRelRef != null) {
				referenceUpdateModification.updateBusinessObject(diagramElement, newBo, newRelRef);
			}
		}		
	}

	class ClosedDiagramContextReference implements ReferenceToUpdate {
		private final org.osate.ge.mm.diagram.DiagramConfiguration diagramConfig;
		
		public ClosedDiagramContextReference(final org.osate.ge.mm.diagram.DiagramConfiguration diagramConfig) {
			this.diagramConfig = Objects.requireNonNull(diagramConfig, "diagramConfig must not be null");
		}
		
		@Override
		public void update(final Object newBo) {
			// TODO: Should update be passed in the canonical reference or something to avoid repeated lookups of the relative reference?
			final CanonicalBusinessObjectReference newCanonicalRef = referenceService.getCanonicalReference(newBo);
			if(newCanonicalRef != null) {
				final org.osate.ge.mm.diagram.DiagramConfiguration resolvedConfig = diagramConfig.eIsProxy() ? (org.osate.ge.mm.diagram.DiagramConfiguration)EcoreUtil.resolve(diagramConfig, referenceUpdateResource) : diagramConfig;
				resolvedConfig.setContext(newCanonicalRef.toMetamodel());
			}
		}		
	}
	
	class ClosedDiagramElementReference implements ReferenceToUpdate {
		private final org.osate.ge.mm.diagram.DiagramElement diagramElement;
		
		public ClosedDiagramElementReference(final org.osate.ge.mm.diagram.DiagramElement diagramElement) {
			this.diagramElement = Objects.requireNonNull(diagramElement, "diagramElement must not be null");
		}
		
		@Override
		public void update(final Object newBo) {
			// TODO: Should update be passed in the relative reference or something to avoid repeated lookups of the relative reference?
			final RelativeBusinessObjectReference newRelRef = referenceService.getRelativeReference(newBo);
			if(newRelRef != null) {
				final org.osate.ge.mm.diagram.RelativeBusinessObjectReference mmRelRef = newRelRef.toMetamodel();
				if(mmRelRef != null) {
					final org.osate.ge.mm.diagram.DiagramElement resolvedElement = diagramElement.eIsProxy() ? (org.osate.ge.mm.diagram.DiagramElement)EcoreUtil.resolve(diagramElement, referenceUpdateResource) : diagramElement;
					resolvedElement.setBo(mmRelRef);
				}
			}
		}		
	}
	
	@Override
	public ReferenceCollection getReferences(final Set<IProject> relevantProjects, 
			final Collection<CanonicalBusinessObjectReference> originalCanonicalReferences) {
		final InternalReferencesToUpdate references = new InternalReferencesToUpdate();
		try(final BusinessObjectProviderHelper bopHelper = new BusinessObjectProviderHelper(extRegistry)) {
			// TODO: Need an indexing mechanism to improve performance
			
			final Collection<InternalDiagramReference> diagrams = findDiagrams(relevantProjects);
			for(final InternalDiagramReference diagramRef : diagrams) {
				if(diagramRef.isOpen()) {				
					// TODO
					// TODO: Check for null? 
					final AgeDiagramEditor editor = diagramRef.getEditor();
					final AgeDiagramProvider diagramProvider = (AgeDiagramProvider)editor.getAdapter(AgeDiagramProvider.class);
					// TODO: Check for null
					final AgeDiagram diagram = diagramProvider.getAgeDiagram();
	
					// TODO: Check context
					final CanonicalBusinessObjectReference diagramContextRef = diagram.getConfiguration().getContextBoReference();
					if(diagramContextRef != null && originalCanonicalReferences.contains(diagramContextRef)) {
						references.addReference(diagramRef, diagramContextRef, new OpenDiagramContextReference(diagram));
					}

					// Get references from the diagram elements
					getRuntimeReferencesFromChildren(diagramRef, diagram, originalCanonicalReferences, references);
				}
				
				// Handle closed diagrams
				final ResourceSet rs = new ResourceSetImpl();
				final URI diagramUri = URI.createPlatformResourceURI(diagramRef.getFile().getFullPath().toString(), true);
				final Resource diagramResource = rs.createResource(diagramUri);
				final IProject project = SelectionHelper.getProject(diagramUri);
				if(project == null) {
					continue;
				}
				
				final ProjectReferenceService projectReferenceService = referenceService.getProjectReferenceService(project);
				if(projectReferenceService == null) {
					continue;
				}
				
				try {
					diagramResource.load(Collections.emptyMap());
					if(diagramResource.getContents().size() == 1) {
						if(diagramResource.getContents().get(0) instanceof org.osate.ge.mm.diagram.Diagram) {
							final org.osate.ge.mm.diagram.Diagram mmDiagram = (org.osate.ge.mm.diagram.Diagram)diagramResource.getContents().get(0);

							// Get the Context Business Object
							final org.osate.ge.mm.diagram.DiagramConfiguration config = mmDiagram.getConfig();
							Object contextBo = null;
							if(config != null) {
								final CanonicalBusinessObjectReference contextRef = DiagramSerialization.convert(config.getContext());
								
								// TODO: Check if the context ref is something that will need to be updated
								if(contextRef != null) {									
									if(originalCanonicalReferences.contains(contextRef)) {
										references.addReference(diagramRef, contextRef, new ClosedDiagramContextReference(config));
									}
									
									contextBo = projectReferenceService.resolve(contextRef);
								}
							}
							
							// Contextless diagrams are not supported
							if(contextBo == null) {
								continue;
							}
							
							// TODO: Get references from the tree
							getStoredReferencesFromChildren(diagramRef, mmDiagram, originalCanonicalReferences, new SimpleUnqueryableBusinessObjectContext(null, null), Collections.singleton(contextBo), bopHelper, projectReferenceService, references);
						}		
					}
				} catch (IOException e) {
					// Ignore. Continue with next file
				} finally {
					// Unload the resource
					if(diagramResource.isLoaded()) {
						diagramResource.unload();
					}					
				}
			}
		}
				
		return references;
	}
		
	// TODO: Rename
	// TODO: Document parameters., In vs out
	// TODO: Rename... only for live version 
	private void getRuntimeReferencesFromChildren(final InternalDiagramReference diagramRef,
			final DiagramNode node, 
			final Collection<CanonicalBusinessObjectReference> originalCanonicalReferences,
			final InternalReferencesToUpdate references) {
		for(final DiagramElement child : node.getDiagramElements()) {
			final Object currentBo = child.getBusinessObject();
			
			// TODO: do more testing and determine if this is needed
			if(currentBo instanceof EObject) {
				final EObject test = (EObject)currentBo;
				//if(test != null && test.eContainer() != null && test.eContainer().eIsProxy() || test.eIsProxy()) {
				if(test != null && test.eIsProxy()) {
					final XtextResourceSet testResourceSet = OsateResourceUtil.createXtextResourceSet();
					final EObject test3 = EcoreUtil.resolve(test, testResourceSet);
					
				//	EcoreUtil.resolveAll(test);
				//	System.err.println("TADA");
				//	System.err.println(test.eContainer() + " : " + test3);
					// TODO: Technically resolving things this way works.. However, the updated object is retrieved and not the one before it was modified.
					// Could result in an incorrect reference being retrieved.
					// How to handle.. Could store canonical references at all times.. Either in index or in the model... 
					// Alternatively, would need a function that is called at the start of the renaming process...
				}
			}
						
			final CanonicalBusinessObjectReference currentCanonicalRef = currentBo == null ? null : referenceService.getCanonicalReference(currentBo);
			if(currentCanonicalRef != null) {
				if(originalCanonicalReferences.contains(currentCanonicalRef)) {
					references.addReference(diagramRef, currentCanonicalRef, new OpenDiagramElementReference(child));
				}
			}			
			
			getRuntimeReferencesFromChildren(diagramRef, child, originalCanonicalReferences, references);
		}
	}
	
	// TODO: Move/Rename
	private class SimpleUnqueryableBusinessObjectContext implements BusinessObjectContext {
		private final BusinessObjectContext parent;
		private final Object bo;
		
		public SimpleUnqueryableBusinessObjectContext(final BusinessObjectContext parent,
				final Object bo) {
			this.parent = parent;
			this.bo = bo;
		}
		
		@Override
		public Collection<? extends Queryable> getChildren() {
			// This should not be called since business object providers are not given access to the business object context's children
			throw new RuntimeException("Not supported");
		}

		@Override
		public BusinessObjectContext getParent() {
			return parent;
		}

		@Override
		public Object getBusinessObject() {
			return bo;
		}

	}
	
	private void getStoredReferencesFromChildren(final InternalDiagramReference diagramRef,
			final org.osate.ge.mm.diagram.DiagramNode node,
			final Collection<CanonicalBusinessObjectReference> originalCanonicalReferences,
			final BusinessObjectContext parentBoc,
			final Collection<Object> potentialBusinessObjects,
			final BusinessObjectProviderHelper bopHelper,
			final ProjectReferenceService projectReferenceService,
			final InternalReferencesToUpdate references) {
		
		final Map<RelativeBusinessObjectReference, Object> relativeReferencetToPotentialBo = potentialBusinessObjects.
				stream().
				collect(Collectors.toMap(bo -> referenceService.getRelativeReference(bo), Function.identity()));
		
		// TODO: Need to build a business object context for this...
		
		for(final org.osate.ge.mm.diagram.DiagramElement child : node.getElement()) {
			final RelativeBusinessObjectReference childRef = DiagramSerialization.convert(child.getBo());
			if(childRef == null) {
				continue;
			}
			
			final Object childBo = relativeReferencetToPotentialBo.get(childRef);
			if(childBo == null) {
				continue;
			}
			
			final CanonicalBusinessObjectReference childCanonicalRef = referenceService.getCanonicalReference(childBo);
			if(childCanonicalRef == null) {
				continue;
			}

			if(originalCanonicalReferences.contains(childCanonicalRef)) {
				references.addReference(diagramRef, childCanonicalRef, new ClosedDiagramElementReference(child));
			}

			final BusinessObjectContext childBoc = new SimpleUnqueryableBusinessObjectContext(parentBoc, childBo);
			final Collection<Object> potentialChildBusinessObjects = bopHelper.getChildBusinessObjects(childBoc);
			getStoredReferencesFromChildren(diagramRef, child, originalCanonicalReferences, childBoc, potentialChildBusinessObjects, bopHelper, projectReferenceService, references);
		}
	}
}
