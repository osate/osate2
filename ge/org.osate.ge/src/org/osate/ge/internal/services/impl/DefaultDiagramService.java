package org.osate.ge.internal.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.IDiagramEditorInput;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.osate.ge.DiagramType;
import org.osate.ge.internal.AgeDiagramProvider;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.DiagramConfigurationBuilder;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.DiagramSerialization;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.types.UnrecognizedDiagramType;
import org.osate.ge.internal.indexing.SavedDiagramIndex;
import org.osate.ge.internal.indexing.SavedDiagramIndexInvalidator;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.ui.dialogs.CreateDiagramDialog;
import org.osate.ge.internal.ui.dialogs.DefaultCreateDiagramModel;
import org.osate.ge.internal.ui.editor.AgeDiagramBehavior;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.util.EditorUtil;
import org.osate.ge.internal.util.BusinessObjectProviderHelper;
import org.osate.ge.internal.util.Log;
import org.osate.ge.internal.util.NonUndoableToolCommand;
import org.osate.ge.internal.util.ProjectUtil;

import com.google.common.collect.ImmutableSet;

public class DefaultDiagramService implements DiagramService {
	private static final QualifiedName LEGACY_PROPERTY_NAME_MODIFICATION_TIMESTAMP = new QualifiedName("org.osate.ge",
			"diagram_name_modification_stamp");
	private static final QualifiedName LEGACY_PROPERTY_DIAGRAM_NAME = new QualifiedName("org.osate.ge", "diagram_name");
	private static final Pattern uuidFilenamePattern = Pattern
			.compile("[0-9a-f]{4,}-[0-9a-f]{2,}-[0-9a-f]{2,}-[0-9a-f]{2,}-[0-9a-f]{6,}\\.aadl_diagram");

	private final ReferenceService referenceService;
	private final ExtensionRegistryService extRegistry;

	public static class ContextFunction extends SimpleServiceContextFunction<DiagramService> {
		@Override
		public DiagramService createService(final IEclipseContext context) {
			return new DefaultDiagramService(context.get(ReferenceService.class),
					context.get(ExtensionRegistryService.class));
		}

		@Override
		protected void deactivate() {
			// Dispose the service if it is valid
			final DiagramService service = getService();
			if (service instanceof DefaultDiagramService) {
				((DefaultDiagramService) service).dispose();
			}

			super.deactivate();
		}
	}

	// Implementation of DiagramReference
	private static class InternalDiagramReference implements DiagramReference {
		private final SavedDiagramIndex.DiagramIndexEntry indexEntry;
		private final AgeDiagramEditor editor;

		private InternalDiagramReference(final SavedDiagramIndex.DiagramIndexEntry indexEntry,
				final AgeDiagramEditor editor) {
			this.indexEntry = Objects.requireNonNull(indexEntry, "indexEntry must not be null");
			this.editor = editor;
		}

		@Override
		public boolean isValid() {
			return indexEntry.getDiagramTypeId() != null;
		}

		@Override
		public IFile getFile() {
			return indexEntry.getDiagramFile();
		}

		@Override
		public AgeDiagramEditor getEditor() {
			return editor;
		}

		@Override
		public boolean isOpen() {
			return editor != null;
		}

		@Override
		public String getDiagramTypeId() {
			return indexEntry.getDiagramTypeId();
		}

		@Override
		public CanonicalBusinessObjectReference getContextReference() {
			return indexEntry.getContext();
		}
	}

	private BusinessObjectProviderHelper bopHelper;
	private SavedDiagramIndex savedDiagramIndex;
	private SavedDiagramIndexInvalidator indexUpdater;

	public DefaultDiagramService(final ReferenceService referenceBuilder, final ExtensionRegistryService extRegistry) {
		this.referenceService = Objects.requireNonNull(referenceBuilder, "referenceBuilder must not be null");
		this.extRegistry = Objects.requireNonNull(extRegistry, "extRegistry must not be null");

		this.bopHelper = new BusinessObjectProviderHelper(extRegistry);
		this.savedDiagramIndex = new SavedDiagramIndex(referenceBuilder, bopHelper);
		this.indexUpdater = new SavedDiagramIndexInvalidator(savedDiagramIndex);

		// Register the index updater
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.addResourceChangeListener(indexUpdater);
	}

	public void dispose() {
		bopHelper.close();

		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.removeResourceChangeListener(indexUpdater);
	}

	@Override
	public List<DiagramReference> findDiagramsByContextBusinessObject(final Object bo) {
		final CanonicalBusinessObjectReference boReference = referenceService.getCanonicalReference(bo);
		if (boReference == null) {
			throw new RuntimeException("Unable to get canonical reference for business object : " + bo);
		}

		final IProject project = ProjectUtil.getProjectForBoOrThrow(bo);

		// Build a set containing the project containing the business object and all projects which reference that project.
		final HashSet<IProject> relevantProjects = new HashSet<>();
		relevantProjects.add(project);
		for (final IProject referencingProject : project.getReferencingProjects()) {
			if (referencingProject.isAccessible()) {
				relevantProjects.add(referencingProject);
			}
		}

		final Map<IFile, AgeDiagramEditor> fileToEditorMap = getOpenEditorsMap(relevantProjects);

		// Add saved diagram files if they are not open
		return savedDiagramIndex.getDiagramsByContext(relevantProjects.stream(), boReference).stream()
				.map(e -> new InternalDiagramReference(e, fileToEditorMap.get(e.getDiagramFile())))
				.collect(Collectors.toList());
	}

	@Override
	public AgeDiagramEditor openOrCreateDiagramForBusinessObject(final Object bo, final boolean promptForCreate,
			final boolean promptForConfigureAfterCreate) {
		// Look for an existing diagram
		final List<DiagramReference> diagramRefs = findDiagramsByContextBusinessObject(bo).stream()
				.filter(dr -> dr.isValid()).collect(Collectors.toList());

		// If there is just one diagram, open it
		if (diagramRefs.size() == 1) {
			final DiagramReference diagramRef = diagramRefs.get(0);
			if (diagramRef.isOpen()) {
				Log.info("Existing diagram found. Activating existing editor...");
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(diagramRef.getEditor());
				return diagramRef.getEditor();
			} else {
				Log.info("Existing diagram found. Opening new editor...");
				return EditorUtil.openEditor(diagramRef.getFile(), false);
			}
		} else if (diagramRefs.size() == 0) {
			// Prompt user to determine whether a new diagram should be created
			if (!promptForCreate || MessageDialog.openQuestion(null, "Create New Diagram?",
					"An existing diagram was not found for the specified model element.\nCreate new diagram?")) {
				// Create and open a new diagram
				final IFile diagramFile = createDiagram(bo);
				if (diagramFile == null) {
					return null;
				}

				final AgeDiagramEditor editor = EditorUtil.openEditor(diagramFile, promptForConfigureAfterCreate);
				return editor;
			} else {
				return null;
			}
		} else {
			final DiagramReference diagramRef = promptForDiagram(diagramRefs);
			return diagramRef == null ? null : EditorUtil.openEditor(diagramRef.getFile(), false);
		}
	}

	private DiagramReference promptForDiagram(final List<DiagramReference> diagramRefs) {
		// Sort the diagram references
		final InternalDiagramReference[] sortedDiagramRefs = diagramRefs.stream()
				.sorted((r1, r2) -> getName(r1.getFile()).compareToIgnoreCase(getName(r2.getFile())))
				.toArray(InternalDiagramReference[]::new);

		// Prompt user to select a single dialog reference
		final ListDialog dialog = new ListDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		dialog.setAddCancelButton(true);
		dialog.setTitle("Select Diagram");
		dialog.setMessage("Select a Diagram to Open");
		dialog.setWidthInChars(90);
		dialog.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(final Object element) {
				if (element instanceof InternalDiagramReference) {
					final InternalDiagramReference diagramRef = (InternalDiagramReference) element;
					final String diagramTypeName = extRegistry.getDiagramTypeById(diagramRef.getDiagramTypeId())
							.orElseGet(() -> new UnrecognizedDiagramType(diagramRef.getDiagramTypeId())).getName();
					return getName(diagramRef.getFile()) + " (" + diagramTypeName + ")";
				}

				return super.getText(element);
			}
		});
		dialog.setContentProvider(new ArrayContentProvider());
		dialog.setInput(sortedDiagramRefs);
		dialog.setInitialElementSelections(Collections.singletonList(sortedDiagramRefs[0]));
		dialog.open();

		final Object[] result = dialog.getResult();
		return (result != null && result.length > 0) ? (InternalDiagramReference) result[0] : null;
	}

	@Override
	public IFile createDiagram(final Object contextBo) {
		final IProject project = ProjectUtil.getProjectForBoOrThrow(contextBo);

		// Prompt to determine the filepath and diagram type.
		final CreateDiagramDialog.Model<DiagramType> createDiagramModel = new DefaultCreateDiagramModel(extRegistry,
				project, contextBo);
		final CreateDiagramDialog.Result<DiagramType> result = CreateDiagramDialog.show(null, createDiagramModel);
		if (result == null) {
			return null;
		}

		createDiagram(result.getDiagramFile(), result.getDiagramType(), contextBo);

		return result.getDiagramFile();
	}

	@Override
	public void createDiagram(final IFile diagramFile, final DiagramType diagramType, final Object contextBo) {
		// Create an AgeDiagram object. This object doesn't have to be completely valid. It just needs to be able to be written.
		final AgeDiagram diagram = new AgeDiagram();

		// Build diagram configuration
		final CanonicalBusinessObjectReference contextBoCanonicalRef = contextBo == null ? null
				: Objects.requireNonNull(referenceService.getCanonicalReference(contextBo),
						"Unable to build canonical reference for business object: " + contextBo);
		diagram.modify("Configure Diagram", m -> {
			m.setDiagramConfiguration(new DiagramConfigurationBuilder(diagramType, true)
					.setContextBoReference(contextBoCanonicalRef).connectionPrimaryLabelsVisible(false).build());

		});

		final URI newDiagramUri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
		DiagramSerialization.write(diagramFile.getProject(), diagram, newDiagramUri);

		try {
			diagramFile.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (final CoreException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns all diagrams in the specified projects.
	 * @return
	 */
	@Override
	public List<DiagramReference> findDiagrams(final Set<IProject> projects) {
		final Map<IFile, AgeDiagramEditor> fileToEditorMap = getOpenEditorsMap(projects);

		// Add saved diagram files if they are not open
		return savedDiagramIndex.getDiagramsByProject(projects.stream()).stream()
				.map(e -> new InternalDiagramReference(e, fileToEditorMap.get(e.getDiagramFile())))
				.collect(Collectors.toList());
	}

	private static Map<IFile, AgeDiagramEditor> getOpenEditorsMap(final Collection<IProject> projects) {
		final Map<IFile, AgeDiagramEditor> fileToEditorMap = new HashMap<>();
		for (final IEditorReference editorRef : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences()) {
			final IEditorPart editor = editorRef.getEditor(false); // If restore is true then the editor is automatically updated
			if (editor instanceof AgeDiagramEditor) {
				final AgeDiagramEditor diagramEditor = (AgeDiagramEditor) editor;
				final AgeDiagramBehavior behavior = (AgeDiagramBehavior) diagramEditor.getDiagramBehavior();

				if (behavior != null) {
					if (projects.contains(behavior.getProject())) {
						final IFile file = behavior.getFile();
						if (file != null) {
							fileToEditorMap.put(file, diagramEditor);
						}
					}
				}
			}
		}

		return fileToEditorMap;
	}

	@Override
	public String getName(final IFile diagramFile) {
		String name = null;
		if (diagramFile.exists()) {
			// Handle legacy diagram files which have names based on UUIDs
			if (uuidFilenamePattern.matcher(diagramFile.getName()).matches()) {
				// Attempt to use the name from the persistent property
				try {
					// Check modification time stamp
					final String modStampPropValue = diagramFile
							.getPersistentProperty(LEGACY_PROPERTY_NAME_MODIFICATION_TIMESTAMP);
					if (modStampPropValue != null
							&& modStampPropValue.equals(Long.toString(diagramFile.getModificationStamp()))) {
						name = diagramFile.getPersistentProperty(LEGACY_PROPERTY_DIAGRAM_NAME);
					}
				} catch (CoreException e) {
					e.printStackTrace();
				}

				if (name == null) {
					final ResourceSet resourceSet = new ResourceSetImpl();
					// Load the EMF Resource
					final URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
					try {
						final Resource resource = resourceSet.getResource(uri, true);
						if (resource.getContents().size() > 0 && resource.getContents().get(0) instanceof Diagram) {
							final Diagram diagram = (Diagram) resource.getContents().get(0);
							name = diagram.getName() + " (Legacy)";
						}
					} catch (final RuntimeException e) {
						// Ignore. Print to stderr
						e.printStackTrace();
					}

					// Use the diagram file's name if the name could not be determined for any reason
					if (name == null) {
						name = diagramFile.getName();
					}

					// Update persistent properties.
					try {
						diagramFile.setPersistentProperty(LEGACY_PROPERTY_DIAGRAM_NAME, name);
						diagramFile.setPersistentProperty(LEGACY_PROPERTY_NAME_MODIFICATION_TIMESTAMP,
								Long.toString(diagramFile.getModificationStamp()));
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}

			// Default to the diagram's filename
			if (name == null) {
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

	class InternalReferencesToUpdate implements ReferenceCollection {
		// Mapping from internal diagram references to a mapping from original diagram reference to lists of references to update
		// Key should be an IFile or and AgeDiagramEditor
		private final Map<Object, Map<CanonicalBusinessObjectReference, Collection<UpdateableReference>>> sourceToCanonicalReferenceToReferencesMap = new HashMap<>();

		@Override
		public void update(final UpdatedReferenceValueProvider updatedReferenceValues) {
			Display.getDefault().syncExec(() -> {
				for (final Entry<Object, Map<CanonicalBusinessObjectReference, Collection<UpdateableReference>>> sourceToCanonicalReferenceToReferencesEntry : sourceToCanonicalReferenceToReferencesMap
						.entrySet()) {
					final Object key = sourceToCanonicalReferenceToReferencesEntry.getKey();
					final Map<CanonicalBusinessObjectReference, Collection<UpdateableReference>> originalCanonicalRefToReferenceMap = sourceToCanonicalReferenceToReferencesEntry
							.getValue();

					if (key instanceof AgeDiagramEditor) {
						final AgeDiagramEditor editor = (AgeDiagramEditor) key;

						final AgeDiagramProvider diagramProvider = (AgeDiagramProvider) editor
								.getAdapter(AgeDiagramProvider.class);
						if (diagramProvider == null) {
							continue;
						}

						final AgeDiagram diagram = diagramProvider.getAgeDiagram();
						if (diagram == null) {
							continue;
						}

						// NonUndoableToolCommand
						editor.getEditingDomain().getCommandStack().execute(new NonUndoableToolCommand() {
							@Override
							public void execute() {
								diagram.modify("Update References", m -> updateReferences(updatedReferenceValues,
										originalCanonicalRefToReferenceMap, null, m));
							}
						});

						// Ensure that the editor is updated on the next model change
						editor.forceDiagramUpdateOnNextModelChange();
					} else if (key instanceof IFile) {
						final IFile diagramFile = (IFile) key;

						// Handle closed diagrams
						// Don't attempt to edit read only files.
						if (!diagramFile.isReadOnly()) {

							final ResourceSet rs = new ResourceSetImpl();
							final URI diagramUri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(),
									true);
							final Resource diagramResource = rs.createResource(diagramUri);
							try {
								diagramResource.load(Collections.emptyMap());
								if (diagramResource.getContents().size() == 1
										&& diagramResource.getContents().get(0) instanceof org.osate.ge.diagram.Diagram) {
									updateReferences(updatedReferenceValues, originalCanonicalRefToReferenceMap,
											diagramResource, null);
								}
							} catch (IOException e) {
								// Ignore. Continue with next file
							} finally {
								// Save and unload the resource if it was loaded
								if (diagramResource.isLoaded()) {
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
					} else {
						throw new RuntimeException("Unexpected key: " + key);
					}
				}
			});
		}

		@Override
		public ImmutableSet<IFile> getRelatedDiagramFiles() {
			final ImmutableSet.Builder<IFile> diagramFileSetsBuilder = ImmutableSet.builder();
			Display.getDefault().syncExec(() -> {
				for (final Entry<Object, Map<CanonicalBusinessObjectReference, Collection<UpdateableReference>>> sourceToCanonicalReferenceToReferencesEntry : sourceToCanonicalReferenceToReferencesMap
						.entrySet()) {
					final Object key = sourceToCanonicalReferenceToReferencesEntry.getKey();
					if (key instanceof AgeDiagramEditor) {
						final AgeDiagramEditor editor = (AgeDiagramEditor) key;
						final IDiagramEditorInput input = editor.getDiagramEditorInput();
						if(input != null) {
							final IResource diagramResource = ResourcesPlugin.getWorkspace().getRoot()
									.getFile(new Path(input.getUri().toPlatformString(true)));
							if (diagramResource instanceof IFile) {
								diagramFileSetsBuilder.add((IFile) diagramResource);
							}
						}

					} else if (key instanceof IFile) {
						final IFile diagramFile = (IFile) key;
						diagramFileSetsBuilder.add(diagramFile);
					} else {
						throw new RuntimeException("Unexpected key: " + key);
					}
				}
			});

			return diagramFileSetsBuilder.build();
		}

		private void updateReferences(final UpdatedReferenceValueProvider newBoReferences,
				final Map<CanonicalBusinessObjectReference, Collection<UpdateableReference>> originalCanonicalRefToReferenceMap,
				final Resource diagramResource, final DiagramModification diagramModification) {
			try {
				referenceUpdateResource = diagramResource;
				referenceUpdateModification = diagramModification;
				for (final Entry<CanonicalBusinessObjectReference, Collection<UpdateableReference>> originalCanonicalRefToReferencesToUpdateEntry : originalCanonicalRefToReferenceMap
						.entrySet()) {
					final CanonicalBusinessObjectReference originalCanonicalReference = originalCanonicalRefToReferencesToUpdateEntry
							.getKey();
					final CanonicalBusinessObjectReference newCanonicalReference = newBoReferences
							.getNewCanonicalReference(originalCanonicalReference);
					final RelativeBusinessObjectReference newRelativeReference = newBoReferences
							.getNewRelativeReference(originalCanonicalReference);
					if (newCanonicalReference != null && newRelativeReference != null) {
						for (final UpdateableReference referenceToUpdate : originalCanonicalRefToReferencesToUpdateEntry
								.getValue()) {
							referenceToUpdate.update(newCanonicalReference, newRelativeReference);
						}
					}
				}
			} finally {
				referenceUpdateResource = null;
				referenceUpdateModification = null;
			}
		}

		public void addReference(final Object source, final CanonicalBusinessObjectReference originalCanonicalReference,
				final UpdateableReference reference) {
			if (!(source instanceof AgeDiagramEditor || source instanceof IFile)) {
				throw new RuntimeException("source must be a diagram editor or a file");
			}

			// Add Reference to the collection
			Map<CanonicalBusinessObjectReference, Collection<UpdateableReference>> canonicalReferenceToUpdateableReferenceMap = sourceToCanonicalReferenceToReferencesMap
					.get(source);
			if (canonicalReferenceToUpdateableReferenceMap == null) {
				canonicalReferenceToUpdateableReferenceMap = new HashMap<>();
				sourceToCanonicalReferenceToReferencesMap.put(source, canonicalReferenceToUpdateableReferenceMap);
			}

			Collection<UpdateableReference> updateableReferences = canonicalReferenceToUpdateableReferenceMap
					.get(originalCanonicalReference);
			if (updateableReferences == null) {
				updateableReferences = new ArrayList<>();
				canonicalReferenceToUpdateableReferenceMap.put(originalCanonicalReference, updateableReferences);
			}

			updateableReferences.add(reference);
		}

		public Collection<Entry<CanonicalBusinessObjectReference, Collection<UpdateableReference>>> getReferences(
				final InternalDiagramReference ref) {
			final Map<CanonicalBusinessObjectReference, Collection<UpdateableReference>> canonicalReferenceToUpdateableReferenceMap = sourceToCanonicalReferenceToReferencesMap
					.get(ref);
			if (canonicalReferenceToUpdateableReferenceMap == null) {
				return Collections.emptyList();
			}

			return canonicalReferenceToUpdateableReferenceMap.entrySet();
		}
	}

// Variables used during the update process
	private Resource referenceUpdateResource;
	private DiagramModification referenceUpdateModification;

	interface UpdateableReference {
		void update(CanonicalBusinessObjectReference newCanonicalReference,
				RelativeBusinessObjectReference newRelativeReference);
	}

//
// Updateable Reference Implementations
//

// Reference to the context field in an open diagram's configuration
	class OpenDiagramContextReference implements UpdateableReference {
		private final AgeDiagram diagram;

		public OpenDiagramContextReference(final AgeDiagram diagram) {
			this.diagram = Objects.requireNonNull(diagram, "diagram must not be null");
		}

		@Override
		public void update(CanonicalBusinessObjectReference newCanonicalReference,
				RelativeBusinessObjectReference newRelativeReference) {
			diagram.modify("Configure Diagram", m -> {
				m.setDiagramConfiguration(new DiagramConfigurationBuilder(diagram.getConfiguration())
						.setContextBoReference(newCanonicalReference).build());
			});
		}
	}

// Reference to the reference of an open diagram element
	class OpenDiagramElementReference implements UpdateableReference {
		private final DiagramElement diagramElement;

		public OpenDiagramElementReference(final DiagramElement diagramElement) {
			this.diagramElement = Objects.requireNonNull(diagramElement, "diagramElement must not be null");
		}

		@Override
		public void update(final CanonicalBusinessObjectReference newCanonicalReference,
				final RelativeBusinessObjectReference newRelativeReference) {
			// The diagram element's business object is not updated because it is not available at this point.
			// In the case of a rename refactoring, the object would be available during the rename but not during undo.
			referenceUpdateModification.updateBusinessObject(diagramElement, diagramElement.getBusinessObject(),
					newRelativeReference);
		}
	}

// Reference to the context field in an saved diagram configuration
	class SavedDiagramContextReference implements UpdateableReference {
		@Override
		public void update(final CanonicalBusinessObjectReference newCanonicalReference,
				final RelativeBusinessObjectReference newRelativeReference) {
			final org.osate.ge.diagram.Diagram mmDiagram = (org.osate.ge.diagram.Diagram) referenceUpdateResource
					.getContents().get(0);

			// Get the Context Business Object
			final org.osate.ge.diagram.DiagramConfiguration config = mmDiagram.getConfig();
			if (config != null) {
				config.setContext(newCanonicalReference.toMetamodel());
			}
		}
	}

// Reference to the context field in an saved diagram element
	class SavedDiagramElementReference implements UpdateableReference {
		private final URI diagramElementUri;

		public SavedDiagramElementReference(final URI diagramElementUri) {
			this.diagramElementUri = Objects.requireNonNull(diagramElementUri, "diagramElementUri must not be null");
		}

		@Override
		public void update(final CanonicalBusinessObjectReference newCanonicalReference,
				final RelativeBusinessObjectReference newRelativeReference) {
			final org.osate.ge.diagram.RelativeBusinessObjectReference mmRelRef = newRelativeReference.toMetamodel();
			if (mmRelRef != null) {
				final org.osate.ge.diagram.DiagramElement diagramElement = (org.osate.ge.diagram.DiagramElement) referenceUpdateResource
						.getEObject(diagramElementUri.fragment());
				if (diagramElement == null) {
					throw new RuntimeException("Unable to retrieve diagram element");
				}

				if (diagramElement.eIsProxy()) {
					throw new RuntimeException("Retrieved diagram element is proxy");
				}

				diagramElement.setBo(mmRelRef);
			}
		}
	}

	@Override
	public ReferenceCollection getReferences(final Set<IProject> relevantProjects,
			final Set<CanonicalBusinessObjectReference> originalCanonicalReferences) {
		final InternalReferencesToUpdate references = new InternalReferencesToUpdate();
		Display.getDefault().syncExec(() -> {
			// Create updateable reference for open diagrams
			for (final AgeDiagramEditor editor : getOpenEditorsMap(relevantProjects).values()) {
				final AgeDiagramProvider diagramProvider = (AgeDiagramProvider) editor
						.getAdapter(AgeDiagramProvider.class);
				if (diagramProvider == null) {
					continue;
				}

				final AgeDiagram diagram = diagramProvider.getAgeDiagram();
				if (diagram == null) {
					continue;
				}

				// Update the diagram immediately. This is intended to ensure the diagram doesn't have any proxies
				editor.updateNowIfModelHasChanged();

				final CanonicalBusinessObjectReference diagramContextRef = diagram.getConfiguration()
						.getContextBoReference();
				if (diagramContextRef != null) {
					if (originalCanonicalReferences.contains(diagramContextRef)) {
						references.addReference(editor, diagramContextRef, new OpenDiagramContextReference(diagram));
					}
				}

				// Get references from the diagram elements
				getRuntimeReferencesFromChildren(editor, diagram, originalCanonicalReferences, references);
			}

			// Create updateable references for saved diagrams
			savedDiagramIndex.getDiagramsByContexts(relevantProjects.stream(), originalCanonicalReferences)
			.forEach(e -> {
				references.addReference(e.getDiagramFile(), e.getContext(), new SavedDiagramContextReference());
			});

			savedDiagramIndex.getElementUrisByReferences(relevantProjects.stream(), originalCanonicalReferences)
			.forEach(e -> {
				references.addReference(e.diagramFile, e.reference,
						new SavedDiagramElementReference(e.elementUri));
			});
		});
		return references;
	}

	/**
	 * Gets references from open editors.
	 * @param editor
	 * @param node
	 * @param originalCanonicalReferences
	 * @param references
	 */
	private void getRuntimeReferencesFromChildren(final AgeDiagramEditor editor, final DiagramNode node,
			final Collection<CanonicalBusinessObjectReference> originalCanonicalReferences,
			final InternalReferencesToUpdate references) {
		for (final DiagramElement child : node.getDiagramElements()) {
			final Object currentBo = child.getBusinessObject();
			final CanonicalBusinessObjectReference currentCanonicalRef = currentBo == null ? null
					: referenceService.getCanonicalReference(currentBo);
			if (currentCanonicalRef != null) {
				if (originalCanonicalReferences.contains(currentCanonicalRef)) {
					references.addReference(editor, currentCanonicalRef, new OpenDiagramElementReference(child));
				}
			}

			getRuntimeReferencesFromChildren(editor, child, originalCanonicalReferences, references);
		}
	}
}
