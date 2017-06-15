package org.osate.ge.internal.graphiti;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.internal.AgeGraphicalConfiguration;
import org.osate.ge.internal.DockArea;
import org.osate.ge.internal.diagram.AgeDiagram;
import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.BuiltinContentsFilter;
import org.osate.ge.internal.diagram.DiagramConfigurationBuilder;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.diagram.DiagramModification;
import org.osate.ge.internal.diagram.DiagramModifier;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.diagram.DiagramSerialization;
import org.osate.ge.internal.diagram.Dimension;
import org.osate.ge.internal.diagram.Point;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.graphiti.diagram.PropertyUtil;
import org.osate.ge.internal.model.SubprogramCallOrder;
import org.osate.ge.internal.query.DefaultQuery;
import org.osate.ge.internal.query.QueryRunner;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.query.RootQuery;
import org.osate.ge.internal.services.CachingService;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.services.impl.DefaultCachingService;
import org.osate.ge.internal.services.impl.DefaultExtensionService;
import org.osate.ge.internal.services.impl.DefaultReferenceService;
import org.osate.ge.internal.ui.util.SelectionHelper;
import org.osate.ge.internal.util.DiagramUtil;
import org.osate.ge.query.Query;
import org.osate.ge.services.ReferenceResolutionService;
import org.osate.ge.services.impl.DefaultReferenceResolutionService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

// Handles converting legacy Graphiti diagrams to the native format.
public class LegacyGraphitiDiagramConverter {
	private static final Graphic unusedGraphic = RectangleBuilder.create().build(); // Graphic required for graphical configuration. Not actually used.
	private static final String isLogicalTreeNodePropertyName = "is_lt_node";
	private static final String showBindingPropertyKeyBase = "show_binding_type";
	private static final String connectionLabelDecoratorName = "label";

	private RootQuery srcRootQuery = new RootQuery(() -> this.srcElement);
	private DiagramElement srcElement;	
	private RootQuery dstRootQuery = new RootQuery(() -> this.dstElement);
	private DiagramElement dstElement;

	// Find the subcomponent or component classifier that owns the mode transition connection.
	private Query modeTransitionParentQuery = srcRootQuery.ancestor(1).filter((fa) -> fa.getBusinessObject() instanceof ComponentClassifier || fa.getBusinessObject() instanceof Subcomponent).first();	
	private Query connectionReferenceParentQuery = srcRootQuery.ancestors().filterByBusinessObjectRelativeReference((ConnectionReference cr) -> cr.getContainingComponentInstance());
	private Query connectionParentQuery = srcRootQuery.commonAncestors(dstRootQuery).filter((fa) -> fa.getBusinessObject() instanceof Subcomponent || fa.getBusinessObject() instanceof ComponentClassifier);
	private Query flowSpecificationParentQuery = srcRootQuery.ancestors().filter((fa) -> isFlowSpecParentType(fa.getBusinessObject())).first();	
	
	public IFile convertLegacyDiagram(final URI uri) {
		final IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(uri.toPlatformString(true)));
		if(!(resource instanceof IFile)) {
			throw new RuntimeException("Unable to retrieve file for resource.");
		}
		
		// Load the graphiti diagram
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Diagram tmpDiagram = (Diagram)resourceSet.getEObject(uri, true);
		if(tmpDiagram == null) {
			throw new RuntimeException("Unable to open legacy diagram");
		}	
		
		try(final ByteArrayOutputStream os = new ByteArrayOutputStream()) {
			convertLegacyDiagram(tmpDiagram, os);

			// Build name that doesn't currently exist
			final String baseName = tmpDiagram.getName().replaceAll("::|:|\\.", "_");
			IFile convertedFile = resource.getParent().getFile(new Path(baseName + ".aadl_diagram"));
			int nameCounter = 2;
			while(convertedFile.exists()) {
				convertedFile = resource.getParent().getFile(new Path(baseName + "(" + nameCounter + ").aadl_diagram"));
				nameCounter++;
			}
			
			try(final ByteArrayInputStream convertedStream = new ByteArrayInputStream(os.toByteArray())) {
				convertedFile.create(convertedStream, true, null);
				return convertedFile;
			} catch (final CoreException e) {
				throw new RuntimeException(e);
			}
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void convertLegacyDiagram(final Diagram legacyDiagram, final OutputStream os) {
		final CanonicalBusinessObjectReference contextBoRef = DiagramUtil.getLegacyReference(legacyDiagram);
		if(contextBoRef == null) {
			throw new RuntimeException("Unable to get context business object reference from legacy diagram.");
		}
		
		final IProject project = SelectionHelper.getProject(legacyDiagram.eResource());
		
		// Create objects for the context
		final Bundle bundle = FrameworkUtil.getBundle(getClass());	
		final IEclipseContext context =  EclipseContextFactory.getServiceContext(bundle.getBundleContext()).createChild();
		try {
			final InternalReferenceBuilderService refBuilder = Objects.requireNonNull(context.get(InternalReferenceBuilderService.class), "Unable to retrieve ReferenceBuilderService");
			final CachingService cachingService = new DefaultCachingService();
			final ExtensionService extensionService = new DefaultExtensionService(Objects.requireNonNull(context.get(ExtensionRegistryService.class), "Unable to retrieve ExtensionRegistryService"), context);
			final ReferenceService referenceService = new DefaultReferenceService(extensionService, cachingService, refBuilder);
			context.set(CachingService.class, cachingService);
			context.set(ExtensionService.class, extensionService);
			context.set(ProjectProvider.class, new ProjectProvider() { // Needed by declarative reference resolver
				@Override
				public IProject getProject() {
					return project;
				}				
			});
			context.set(ReferenceResolutionService.class, new DefaultReferenceResolutionService(referenceService));
						
			final QueryRunner queryRunner = new QueryRunner(refBuilder);
			
			// Convert to a AgeDiagram object. This object doesn't have to be completely valid. It just needs to be able to be written.
			final AgeDiagram diagram = new AgeDiagram();
			
			final Map<Shape, DiagramElement> shapeToDiagramElementMap = new HashMap<>();
			
			diagram.modify(new DiagramModifier() {
				@Override
				public void modify(final DiagramModification m) {
					DiagramNode container = diagram;
					
					if(contextBoRef != null) {
						final Object contextBo = referenceService.resolve(contextBoRef);
						
						// Special handling for package diagrams 
						if(contextBo instanceof AadlPackage) {
							final RelativeBusinessObjectReference contextRelRef = referenceService.getRelativeReference(contextBo);
							if(contextRelRef == null) {
								throw new RuntimeException("Unable to retrieve relative reference for context business object");
							}
							
							final DiagramElement newElement = new DiagramElement(container, contextBo, null, contextRelRef, null);
							m.addElement(newElement);
							m.setGraphicalConfiguration(newElement,(AgeGraphicalConfiguration)GraphicalConfigurationBuilder.create().graphic(unusedGraphic).build());
							m.setAutoContentsFilter(newElement, BuiltinContentsFilter.ALLOW_ALL);
							m.setManual(newElement, true);
							
							container = newElement;
						} 
						
						// Build diagram configuration
						final DiagramConfigurationBuilder configBuilder = new DiagramConfigurationBuilder().setContextBoReference(contextBoRef);						
						if(!(contextBo instanceof ComponentInstance)) {							
							// Add deployment properties based on whether they are enabled in the graphiti diagram
							addDeploymentBindingPropertyIfEnabled(configBuilder, legacyDiagram, "actual_connection");
							addDeploymentBindingPropertyIfEnabled(configBuilder, legacyDiagram, "actual_function");
							addDeploymentBindingPropertyIfEnabled(configBuilder, legacyDiagram, "actual_memory");
							addDeploymentBindingPropertyIfEnabled(configBuilder, legacyDiagram, "actual_processor");
							addDeploymentBindingPropertyIfEnabled(configBuilder, legacyDiagram, "allowed_connection");
							addDeploymentBindingPropertyIfEnabled(configBuilder, legacyDiagram, "allowed_memory");
							addDeploymentBindingPropertyIfEnabled(configBuilder, legacyDiagram, "allowed_processor");
						}						
						diagram.setDiagramConfiguration(configBuilder.build());
					}
					
					convertChildren(m, container, legacyDiagram, referenceService, shapeToDiagramElementMap);
						
					// Process connections
					for(final org.eclipse.graphiti.mm.pictograms.Connection c: legacyDiagram.getConnections()) {
						// Skip connections which are not logical nodes
						if(!isLogicalTreeNode(c)) {
							continue;
						}
						
						// Get canonical reference
						final CanonicalBusinessObjectReference canonicalRef = DiagramUtil.getLegacyReference(c);
						if(canonicalRef == null) {
							// Skip
							continue;
						}
						
						final Object bo = referenceService.resolve(canonicalRef);
						if(bo == null) {
							// Skip
							continue;
						}
						
						final RelativeBusinessObjectReference relRef = referenceService.getRelativeReference(bo);
						if(relRef == null) {
							// Skip
							continue;
						}
						
						final DiagramElement connectionParent = findParent(diagram, c, bo, shapeToDiagramElementMap, queryRunner);
						if(connectionParent != null) {
							final DiagramElement newElement = new DiagramElement(connectionParent, bo, null, relRef, null);
							m.addElement(newElement);
							
							// Graphical Configuration 
							m.setGraphicalConfiguration(newElement, (AgeGraphicalConfiguration)GraphicalConfigurationBuilder.create().graphic(unusedGraphic).build());			
							
							// Convert Bendpoints
							if(c instanceof FreeFormConnection) {
								final FreeFormConnection ffc = (FreeFormConnection)c;
								if(ffc.getBendpoints() != null && ffc.getBendpoints().size() > 0) {
									final List<Point> convertedBendpoints = new ArrayList<>(ffc.getBendpoints().size());
									for(final org.eclipse.graphiti.mm.algorithms.styles.Point legacyBendpoint : ffc.getBendpoints()) {
										convertedBendpoints.add(new Point(legacyBendpoint.getX(), legacyBendpoint.getY()));
									}
									m.setBendpoints(newElement, convertedBendpoints);
								}
							}
							
							// Set Connection Name Position
							for(final ConnectionDecorator cd : c.getConnectionDecorators()) {
								// Use the position of any text decorator as the position of the label decorator
								// Connections may have multiple text connection decorator check the decorator's name property
								if(cd.getGraphicsAlgorithm() instanceof Text &&
										(!(bo instanceof org.osate.aadl2.Connection) || connectionLabelDecoratorName.equalsIgnoreCase(PropertyUtil.getName(cd)
										))) {
									final GraphicsAlgorithm labelGa = cd.getGraphicsAlgorithm();
									m.setConnectionPrimaryLabelPosition(newElement, new Point(labelGa.getX(), labelGa.getY()));
									break;
								}
							}							
						}
					
					}					
				}
			});
	
			DiagramSerialization.write(diagram, os);
		} finally {
			context.dispose();
		}		
	}

	private DiagramElement findParent(final AgeDiagram diagram, 
			final org.eclipse.graphiti.mm.pictograms.Connection c, 
			final Object bo,
			final Map<Shape, DiagramElement> shapeToDiagramElementMap,
			final QueryRunner queryRunner) {
		try {
			AnchorContainer src = c.getStart().getParent();			
			AnchorContainer dst = c.getEnd().getParent();
			
			// Mode Transitions reference an inner shape inside the mode so convert those references to the actual mode shape
			if(bo instanceof ModeTransition) {
				if(src instanceof ContainerShape) {
					src = ((ContainerShape)src).getContainer();
				}
				
				if(dst instanceof ContainerShape) {
					dst = ((ContainerShape)dst).getContainer();
				}
			}
			
			// Get the elements from the anchor containers
			srcElement = shapeToDiagramElementMap.get(src);
			dstElement = shapeToDiagramElementMap.get(dst);
			
			if(bo instanceof Generalization) {
				if(srcElement != null) {
					return srcElement;
				}
			} else if(bo instanceof SubprogramCallOrder) {
				if(srcElement != null && srcElement.getParent() instanceof DiagramElement) {
					return (DiagramElement)srcElement.getParent();
				}
			} else {
				final Query parentQuery;
				if(bo instanceof org.osate.aadl2.Connection) {
					parentQuery = connectionParentQuery;
				} else if(bo instanceof FlowSpecification) {
					parentQuery = flowSpecificationParentQuery;
				} else if(bo instanceof ModeTransition) {
					parentQuery = modeTransitionParentQuery;
				} else if(bo instanceof ConnectionReference) {
					parentQuery = connectionReferenceParentQuery;
				} else {
					parentQuery = null;
				}
				
				if(parentQuery != null) {
					final Queryable parent = queryRunner.getFirstResult((DefaultQuery)parentQuery, bo);
					if(parent != null) {
						return (DiagramElement)parent;
					}
				}
			}
		} finally {
			srcElement = null;
			dstElement = null;
		}
		
		return null;
	}
	
	private static boolean isFlowSpecParentType(final Object tempBo) {
		return tempBo instanceof Subcomponent || tempBo instanceof ComponentType || tempBo instanceof ComponentImplementation || tempBo instanceof SubprogramCall;
	}

	private static boolean getShowConnectionBindingType(final Diagram diagram, final String bindingId) {
		return !"false".equals(Graphiti.getPeService().getPropertyValue(diagram, showBindingPropertyKeyBase + bindingId));
	}
	
	private static void addDeploymentBindingPropertyIfEnabled(final DiagramConfigurationBuilder configBuilder, final Diagram legacyDiagram, final String deploymentPropertyName) {
		if(getShowConnectionBindingType(legacyDiagram, deploymentPropertyName)) {
			configBuilder.addAadlProperty("deployment_properties::" + deploymentPropertyName + "_binding");
		}
	}	
	
	private static void convertChildren(final DiagramModification m, 
			final DiagramNode convertedContainer, 
			final ContainerShape containerShape, 
			final ReferenceService referenceService,
			final Map<Shape, DiagramElement> shapeToDiagramElementMap) {
		// Handle children
		for(final Shape child : containerShape.getChildren()) {
			// Ignore shapes that are transient
			if(PropertyUtil.isTransient(child)) {
				continue;								
			}

			// Get canonical reference
			final CanonicalBusinessObjectReference canonicalRef = DiagramUtil.getLegacyReference(child);
			if(canonicalRef == null) {
				// Ignore shapes for which a reference cannot be retrieved.
				continue;
			}
			
			final Object bo = referenceService.resolve(canonicalRef);
			if(bo == null) {
				// Ignore if the business object could not be retrieved.
				continue;
			}
			
			final RelativeBusinessObjectReference relRef = referenceService.getRelativeReference(bo);
			if(relRef == null) {
				// Ignore if a relative reference can't be built.
				continue;
			}
			
			// Ignore non-logical tree nodes which do not represent feature instances
			if(!isLogicalTreeNode(child) && !(bo instanceof FeatureInstance)) {
				continue;
			}
			
			final GraphicsAlgorithm ga = child.getGraphicsAlgorithm();
			
			// Create the new diagram element
			final DiagramElement newElement = new DiagramElement(convertedContainer, bo, null, relRef, null);
			m.addElement(newElement);
			
			// For top level classifiers, show all contents. Will be true for classifier diagrams
			if(convertedContainer instanceof AgeDiagram) {
				m.setAutoContentsFilter(newElement, BuiltinContentsFilter.ALLOW_ALL);
				m.setManual(newElement, true);				
			} else {
				// Otherwise, specify that the shape is manually shown.
				m.setManual(newElement, true);
				
				// Special handling of certain elements
				if(bo instanceof Subcomponent) {
					m.setAutoContentsFilter(newElement, BuiltinContentsFilter.ALLOW_TYPE);
				} else if(bo instanceof SubprogramCallSequence || bo instanceof SubprogramCall || bo instanceof ComponentInstance) {
					m.setAutoContentsFilter(newElement, BuiltinContentsFilter.ALLOW_ALL);
				}
			}
			
			// Position
			final int x = ga.getX();
			final int y = ga.getY();
			m.setPosition(newElement, new Point(x, y));
			
			// Set Size
			final int width = ga.getWidth();
			final int height = ga.getHeight();
			m.setSize(newElement, new Dimension(width, height));
			
			// Set Dock Area
			final DockArea dockArea = PropertyUtil.getDockArea(child);
			if(dockArea != null) {
				m.setDockArea(newElement, dockArea);
			}

			// Graphical Configuration 
			m.setGraphicalConfiguration(newElement, (AgeGraphicalConfiguration)GraphicalConfigurationBuilder.create().graphic(unusedGraphic).build());			
			shapeToDiagramElementMap.put(child, newElement);
			
			if(child instanceof ContainerShape) {
				// Convert Children
				convertChildren(m, newElement, (ContainerShape)child, referenceService, shapeToDiagramElementMap);
			}
		}
	}	
	
	private static boolean isLogicalTreeNode(final PictogramElement pe) {
		return "true".equals(Graphiti.getPeService().getPropertyValue(pe,isLogicalTreeNodePropertyName));
	}
}
