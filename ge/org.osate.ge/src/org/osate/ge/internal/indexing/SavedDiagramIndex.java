package org.osate.ge.internal.indexing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.diagram.DiagramElement;
import org.osate.ge.diagram.DiagramNode;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.DiagramSerialization;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.types.CustomDiagramType;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.util.BusinessObjectProviderHelper;
import org.osate.ge.internal.util.DiagramUtil;
import org.osate.ge.internal.util.Log;

// Indexes saved diagram files
public class SavedDiagramIndex {
	public static interface DiagramIndexEntry {
		IFile getDiagramFile();

		String getDiagramTypeId();

		CanonicalBusinessObjectReference getContext();
	}

	public static class ElementIndexEntry {
		public final IFile diagramFile;
		public final CanonicalBusinessObjectReference reference;
		public final URI elementUri;

		protected ElementIndexEntry(final IFile diagramFile, final CanonicalBusinessObjectReference reference,
				final URI elementUri) {
			this.diagramFile = Objects.requireNonNull(diagramFile, "diagramFile must not be null");
			this.reference = Objects.requireNonNull(reference, "reference must not be null");
			this.elementUri = Objects.requireNonNull(elementUri, "elementUri must not be null");
		}
	}

	/**
	 * Used to store the structure of diagram files without keeping the entire diagram in memory. Used to allow partial-lazy creation
	 * of the reference to element URI mapping for diagram files without having to reload the diagram.
	 */
	private static class ReferenceNode {
		private RelativeBusinessObjectReference relativeReference;
		private URI uri;
		private List<ReferenceNode> children;

		public ReferenceNode(final RelativeBusinessObjectReference relativeReference, final URI uri,
				final List<ReferenceNode> children) {
			this.relativeReference = relativeReference;
			this.uri = Objects.requireNonNull(uri, "uri must not be null");
			this.children = Objects.requireNonNull(children, "children must not be null");
		}

		public final RelativeBusinessObjectReference getRelativeReference() {
			return relativeReference;
		}

		public final List<ReferenceNode> getChildren() {
			return children == null ? Collections.emptyList() : children;
		}

		public final URI getUri() {
			return uri;
		}
	}

	private class DiagramFileIndex implements DiagramIndexEntry {
		public final ProjectDiagramIndex projectDiagramIndex;
		public final IFile diagramFile;
		private boolean metadataLoaded = false;
		private String diagramTypeId;
		private CanonicalBusinessObjectReference context;
		private ReferenceNode rootReferenceNode;
		private Map<CanonicalBusinessObjectReference, URI> refToElementUriMap;

		public DiagramFileIndex(final ProjectDiagramIndex projectDiagramIndex, final IFile diagramFile) {
			this.projectDiagramIndex = Objects.requireNonNull(projectDiagramIndex, "projectDiagramIndex must not be null");
			this.diagramFile = Objects.requireNonNull(diagramFile, "diagramFile must not be null");
		}

		public final boolean isValid() {
			return getDiagramTypeId() != null;
		}

		@Override
		public IFile getDiagramFile() {
			return diagramFile;
		}

		/**
		 *
		 * @return may return null if diagram was invalid.
		 */
		@Override
		public String getDiagramTypeId() {
			ensureMetadataLoaded();
			return diagramTypeId;
		}

		@Override
		public CanonicalBusinessObjectReference getContext() {
			ensureMetadataLoaded();
			return context;
		}

		public Map<CanonicalBusinessObjectReference, URI> getReferenceToElementUriMap() {
			ensureRefToElementUriMapValid();
			return refToElementUriMap;
		}

		// Ensure valid. Populate fields as necessary
		private void ensureMetadataLoaded() {
			if(!metadataLoaded) {
				metadataLoaded = true;
				context = null;

				// Index the diagram file
				final ResourceSet rs = new ResourceSetImpl();
				final URI diagramUri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
				final Resource diagramResource = rs.createResource(diagramUri);
				try {
					diagramResource.load(Collections.singletonMap(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, true));
					if(diagramResource.getContents().size() == 1) {
						if(diagramResource.getContents().get(0) instanceof org.osate.ge.diagram.Diagram) {
							final org.osate.ge.diagram.Diagram mmDiagram = (org.osate.ge.diagram.Diagram)diagramResource.getContents().get(0);
							final org.osate.ge.diagram.DiagramConfiguration config = mmDiagram.getConfig();

							// Set the diagram type id
							diagramTypeId = config == null || config.getType() == null ? CustomDiagramType.ID
									: config.getType();

							// Get the context reference
							if(config != null) {
								context = DiagramSerialization.convert(config.getContext());
							}

							rootReferenceNode = createReferenceNode(mmDiagram, null);
						}
					}
				} catch (IOException e) {
					// Ignore.
				} finally {
					// Unload the resource
					if(diagramResource.isLoaded()) {
						diagramResource.unload();
					}
				}
			}
		}

		private ReferenceNode createReferenceNode(final DiagramElement element) {
			final RelativeBusinessObjectReference ref = DiagramSerialization.convert(element.getBo());
			if (ref == null) {
				return null;
			}

			return createReferenceNode(element, ref);
		}

		private ReferenceNode createReferenceNode(final DiagramNode node, final RelativeBusinessObjectReference relRef) {
			final URI uri = EcoreUtil.getURI(node);
			if (uri == null) {
				return null;
			}

			final List<ReferenceNode> childRefNodes = createChildReferenceNodes(node);

			return new ReferenceNode(relRef, uri, childRefNodes);
		}

		private List<ReferenceNode> createChildReferenceNodes(final DiagramNode node) {
			if (node.getElement().size() > 0) {
				final List<ReferenceNode> childRefNodes = new ArrayList<>(node.getElement().size());
				for (final DiagramElement child : node.getElement()) {
					final ReferenceNode childRefNode = createReferenceNode(child);
					if (childRefNode != null) {
						childRefNodes.add(childRefNode);
					}
				}
				return Collections.unmodifiableList(childRefNodes);
			} else {
				return Collections.emptyList();
			}
		}

		private void ensureRefToElementUriMapValid() {
			if (refToElementUriMap == null) {
				ensureMetadataLoaded();

				refToElementUriMap = new HashMap<>();

				final ProjectReferenceService projectReferenceService = referenceService
						.getProjectReferenceService(projectDiagramIndex.project);

				// Get the business object for the context reference.
				Object contextBo = null;
				if (context != null) {
					contextBo = projectReferenceService.resolve(context);
				}

				// Contextless diagrams are not supported
				if (contextBo != null && rootReferenceNode != null) {
					indexChildElements(this, rootReferenceNode, new SimpleUnqueryableBusinessObjectContext(null, null),
							Collections.singleton(contextBo), bopHelper, projectReferenceService);
				}
			}
		}

		private void indexChildElements(final DiagramFileIndex diagramFileIndex,
				final ReferenceNode referenceNode,
				final BusinessObjectContext parentBoc,
				final Collection<Object> potentialBusinessObjects,
				final BusinessObjectProviderHelper bopHelper,
				final ProjectReferenceService projectReferenceService) {

			// Build a mapping from relative business object references to business objects. Do not include null references.
			final Map<RelativeBusinessObjectReference, Object> relativeReferenceToPotentialBo = new HashMap<>();
			for (final Object bo : potentialBusinessObjects) {
				final RelativeBusinessObjectReference relRef = projectReferenceService.getRelativeReference(bo);
				if (relRef != null) {
					relativeReferenceToPotentialBo.put(relRef, bo);
				}
			}

			// Process children
			for (final ReferenceNode child : referenceNode.getChildren()) {
				final Object childBo = relativeReferenceToPotentialBo.get(child.getRelativeReference());
				if(childBo == null) {
					continue;
				}

				final CanonicalBusinessObjectReference childCanonicalRef = projectReferenceService.getCanonicalReference(childBo);
				if(childCanonicalRef == null) {
					continue;
				}

				// Store the element's URI in the map
				diagramFileIndex.refToElementUriMap.put(childCanonicalRef, child.getUri());

				final BusinessObjectContext childBoc = new SimpleUnqueryableBusinessObjectContext(parentBoc, childBo);
				final Collection<Object> potentialChildBusinessObjects = bopHelper.getChildBusinessObjects(childBoc);
				indexChildElements(diagramFileIndex, child, childBoc, potentialChildBusinessObjects, bopHelper, projectReferenceService);
			}
		}
	}

	private class ProjectDiagramIndex {
		public final IProject project;
		public Map<IFile, DiagramFileIndex> fileToIndexMap;

		public ProjectDiagramIndex(final IProject project) {
			this.project = Objects.requireNonNull(project, "project must not be null");
		}

		public Map<IFile, DiagramFileIndex> getOrCreateFileToIndexMap() {
			if(fileToIndexMap == null) {
				fileToIndexMap = new HashMap<>();

				// Create diagram references as appropriate
				for(final IFile diagramFile : findDiagramFiles(project, null)) {
					createDiagramFileIndex(this, diagramFile);
				}
			}

			return fileToIndexMap;
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
							if (DiagramUtil.isDiagram(file)) {
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
	}

	private final Map<IProject, ProjectDiagramIndex> projectToIndexMap = new HashMap<>();
	private final ReferenceService referenceService;
	private final BusinessObjectProviderHelper bopHelper;

	public SavedDiagramIndex(final ReferenceService referenceService,
			BusinessObjectProviderHelper bopHelper) {
		this.referenceService = Objects.requireNonNull(referenceService, "referenceService must not be null");
		this.bopHelper = Objects.requireNonNull(bopHelper, "bopHelper must not be null");
	}

	public synchronized List<DiagramIndexEntry> getDiagramsByProject(final Stream<IProject> projects) {
		Objects.requireNonNull(projects, "projects must not be null");

		return projects.flatMap(p -> getOrCreateProjectIndex(p).getOrCreateFileToIndexMap().entrySet().stream())
				.map(e -> e.getValue()).collect(Collectors.toList());
	}

	public synchronized List<DiagramIndexEntry> getDiagramsByContext(final Stream<IProject> projects,
			final CanonicalBusinessObjectReference context) {
		return getDiagramsByContexts(projects, Collections.singleton(context));
	}

	public synchronized List<DiagramIndexEntry> getDiagramsByContexts(final Stream<IProject> projects,
			final Set<CanonicalBusinessObjectReference> contexts) {
		Objects.requireNonNull(projects, "projects must not be null");
		Objects.requireNonNull(contexts, "contexts must not be null");

		return projects.flatMap(p -> getOrCreateProjectIndex(p).getOrCreateFileToIndexMap().entrySet().stream()).
				filter(e -> contexts.contains(e.getValue().getContext())).filter(e -> e.getValue().isValid())
				.map(e -> e.getValue()).collect(Collectors.toList());
	}

	public synchronized List<ElementIndexEntry> getElementUrisByReferences(final Stream<IProject> projects,
			final Set<CanonicalBusinessObjectReference> refs) {
		Objects.requireNonNull(projects, "projects must not be null");
		Objects.requireNonNull(refs, "refs must not be null");
		return projects.flatMap(p -> getOrCreateProjectIndex(p).getOrCreateFileToIndexMap().
				entrySet().
				stream().
				flatMap(i -> i.getValue().getReferenceToElementUriMap().
						entrySet().
						stream().
						filter(e -> refs.contains(e.getKey())).
						map(e -> new ElementIndexEntry(i.getKey(), e.getKey(), e.getValue()))
						)
				).collect(Collectors.toList());
	}

	public synchronized void remove(final IProject project) {
		projectToIndexMap.remove(project);
	}

	public synchronized void remove(final IFile file) {
		final ProjectDiagramIndex projectDiagramIndex = projectToIndexMap.get(file.getProject());
		if (projectDiagramIndex != null && projectDiagramIndex.fileToIndexMap != null) {
			projectDiagramIndex.fileToIndexMap.remove(file);

			if(file.exists()) {
				createDiagramFileIndex(projectDiagramIndex, file);
			}
		}
	}

	private ProjectDiagramIndex getOrCreateProjectIndex(final IProject project) {
		Objects.requireNonNull(project, "project must not be null");

		ProjectDiagramIndex projectDiagramIndex = projectToIndexMap.get(project);
		if(projectDiagramIndex == null) {
			projectDiagramIndex = new ProjectDiagramIndex(project);
			projectToIndexMap.put(project, projectDiagramIndex);
		}

		return projectDiagramIndex;
	}

	private DiagramFileIndex createDiagramFileIndex(final ProjectDiagramIndex projectDiagramIndex,
			final IFile diagramFile) {
		final DiagramFileIndex diagramFileIndex = new DiagramFileIndex(projectDiagramIndex, diagramFile);
		projectDiagramIndex.fileToIndexMap.put(diagramFile, diagramFileIndex);
		return diagramFileIndex;
	}

	private static class SimpleUnqueryableBusinessObjectContext implements BusinessObjectContext {
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
}
