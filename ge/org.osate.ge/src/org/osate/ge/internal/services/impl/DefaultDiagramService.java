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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.osate.aadl2.NamedElement;
import org.osate.ge.EmfContainerProvider;
import org.osate.ge.internal.diagram.AgeDiagram;
import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.DiagramConfigurationBuilder;
import org.osate.ge.internal.diagram.DiagramSerialization;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.ui.editor.AgeDiagramBehavior;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.util.EditorUtil;
import org.osate.ge.internal.ui.util.SelectionHelper;
import org.osate.ge.internal.util.DiagramUtil;
import org.osate.ge.internal.util.Log;

public class DefaultDiagramService implements DiagramService {
	private static final QualifiedName LEGACY_PROPERTY_NAME_MODIFICATION_TIMESTAMP = new QualifiedName("org.osate.ge", "diagram_name_modification_stamp");
	private static final QualifiedName LEGACY_PROPERTY_DIAGRAM_NAME = new QualifiedName("org.osate.ge", "diagram_name");
	private static final Pattern uuidFilenamePattern = Pattern.compile("[0-9a-f]{4,}-[0-9a-f]{2,}-[0-9a-f]{2,}-[0-9a-f]{2,}-[0-9a-f]{6,}\\.aadl_diagram");

	private final InternalReferenceBuilderService referenceBuilder;
	
	public static class ContextFunction extends SimpleServiceContextFunction<DiagramService> {
		@Override
		public DiagramService createService(final IEclipseContext context) {
			return new DefaultDiagramService(context.get(InternalReferenceBuilderService.class));
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
						final File file = fileResource.getLocation().toFile();
						try(final FileInputStream is = new FileInputStream(file)) {
							ref = DiagramSerialization.getCanonicalObjectReference(is);
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
	
	public DefaultDiagramService(final InternalReferenceBuilderService referenceBuilder) {
		this.referenceBuilder = Objects.requireNonNull(referenceBuilder, "unable to retrieve internal reference builder service");
	}
		
	@Override
	public List<InternalDiagramReference> findDiagramsByContextBusinessObject(final Object bo) {
		final CanonicalBusinessObjectReference boReference = referenceBuilder.getCanonicalReference(bo);
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
		relevantProjects.addAll(Arrays.asList(project.getReferencingProjects()));

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
		final CanonicalBusinessObjectReference contextBoRef = Objects.requireNonNull(referenceBuilder.getCanonicalReference(contextBo), "Unable to build canonical reference for business object: " + contextBo);
		diagram.setDiagramConfiguration(new DiagramConfigurationBuilder().setContextBoReference(contextBoRef).build());			
		
		final IProject project = Objects.requireNonNull(getProject(contextBo), "Unable to get project for business object: " + contextBo);
		
		// Determine the filename to use for the new diagram
		final String baseDiagramName = contextBo instanceof NamedElement ? ((NamedElement)contextBo).getQualifiedName().replaceAll("::|:|\\.", "_") : "untitled_diagram";
		final IFile newDiagramFile = getNewDiagramFile(project, baseDiagramName);

		try(final FileOutputStream os = new FileOutputStream(newDiagramFile.getLocation().toFile())) {
			DiagramSerialization.write(diagram, os);	
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
		
		try {
			newDiagramFile.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (final CoreException e) {
			throw new RuntimeException(e);
		}

		return newDiagramFile;
	}
	
	/**
	 * Returns all diagrams in the specified projects. If a diagram is open it returns the open diagram
	 * @return
	 */
	@Override
	public List<InternalDiagramReference> findDiagrams(final Set<IProject> projects) {
		final List<InternalDiagramReference> diagramRefs = new ArrayList<>();
		final Set<IFile> openDiagramFiles = new HashSet<>();		

		for(final IEditorReference editorRef : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences()) {
			final IEditorPart editor = editorRef.getEditor(false); // If restore is true then the editor is automatically updated
			if(editor instanceof AgeDiagramEditor) {
				final AgeDiagramEditor diagramEditor = (AgeDiagramEditor)editor;
				final AgeDiagramBehavior behavior = (AgeDiagramBehavior)diagramEditor.getDiagramBehavior();

				if(behavior != null) {
					if(projects.contains(behavior.getProject())) {
						final IFile file = behavior.getFile();
						if(file != null) {
							openDiagramFiles.add(file);
							diagramRefs.add(InternalDiagramReference.createOpen(file, diagramEditor));
						}
					}
				}
			}
		}
		
		// Build list of all files
		final List<IFile> files = new ArrayList<>();
		for(final IProject project : projects) {
			findDiagramFiles(project, files);			
		}
		
		// Create diagram references as appropriate
		for(final IFile file : files) {			
			// Check if the diagram is already open
			if(!openDiagramFiles.contains(file)) {
				diagramRefs.add(InternalDiagramReference.createClosed(file));		
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
}
