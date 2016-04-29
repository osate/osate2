package org.osate.ge.internal.features;

import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;
import org.osate.aadl2.Element;
import org.osate.ge.ConnectionTerminator;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetGraphicalRepresentation;
import org.osate.ge.di.GetName;
import org.osate.ge.di.Names;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.graphics.AgeConnection;
import org.osate.ge.internal.graphics.AgeShape;
import org.osate.ge.internal.graphics.Ellipse;
import org.osate.ge.internal.graphics.FreeFormConnection;
import org.osate.ge.internal.graphics.Rectangle;
import org.osate.ge.internal.patterns.AgePattern;
import org.osate.ge.internal.services.AnchorService;
import org.osate.ge.internal.services.ConnectionCreationService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.LabelService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.ShapeCreationService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.StyleService;
import org.osate.ge.internal.styles.StyleConstants;

public class PictogramHandlerRefreshHelper {
	private final ExtensionService extService;
	private final GhostingService ghostingService;
	private final LabelService labelService;
	private final ShapeCreationService shapeCreationService;
	private final ConnectionCreationService connectionCreationService;
	private final AnchorService anchorService;
	private final ShapeService shapeService;
	private final PropertyService propertyService;
	private final StyleService styleService;
	private final IFeatureProvider featureProvider;
	
	public PictogramHandlerRefreshHelper(final ExtensionService extService,
		final GhostingService ghostingService,
		final LabelService labelService,
		final ShapeCreationService shapeCreationService,
		final ConnectionCreationService connectionCreationService,
		final AnchorService anchorService,
		final ShapeService shapeService,
		final PropertyService propertyService,
		final StyleService styleService,
		final IFeatureProvider featureProvider) {
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.ghostingService = Objects.requireNonNull(ghostingService, "ghostingService must not be null");
		this.labelService = Objects.requireNonNull(labelService, "labelService must not be null");
		this.shapeCreationService = Objects.requireNonNull(shapeCreationService, "shapeCreationService must not be null");
		this.connectionCreationService = Objects.requireNonNull(connectionCreationService, "connectionCreationService must not be null");
		this.anchorService = Objects.requireNonNull(anchorService, "anchorService must not be null");
		this.shapeService = Objects.requireNonNull(shapeService, "shapeService must not be null");
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
		this.styleService = Objects.requireNonNull(styleService, "styleService must not be null");
		this.featureProvider = Objects.requireNonNull(featureProvider, "featureProvider must not be null");
	}
	
	public PictogramElement refresh(final Object bo, final Object handler, PictogramElement pe, final int x, final int y, 
			final ContainerShape addTargetContainer, final Anchor srcAnchor, final Anchor dstAnchor) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {			
			eclipseCtx.set(Names.BUSINESS_OBJECT, bo);			
			final Object gr = ContextInjectionFactory.invoke(handler, GetGraphicalRepresentation.class, eclipseCtx, null);
			
			final ContainerShape childContainer; // Container for any children
			
			// Source and destination anchors must be set for connections
			if(gr instanceof FreeFormConnection && (srcAnchor == null || dstAnchor == null)) {
				return null;
			}
				
			// Create PE if it doesn't exist
			if(pe == null) {
				if(gr == null) {
					pe = null;
					childContainer = addTargetContainer;
				} else {
					if(gr instanceof AgeShape) {
				        // Create the container shape
						pe = childContainer = peCreateService.createContainerShape(addTargetContainer, true);
					} else if(gr instanceof FreeFormConnection) {						
				        // Create the connection
						pe = peCreateService.createFreeFormConnection(getDiagram());
						Graphiti.getGaService().createPlainPolyline(pe);
						childContainer = null;
					} else {
						throw new RuntimeException("Unsupported object: " + gr);
					}
				}
			} else if(pe instanceof ContainerShape) {
				childContainer = (ContainerShape)pe;
			} else {
				childContainer = null;
			}
			
			// Configure PE if one exists
			if(pe != null) {
				featureProvider.link(pe, bo instanceof Element ? new AadlElementWrapper((Element)bo) : bo);
				ghostingService.setIsGhost(pe, false);
				propertyService.setIsLogicalTreeNode(pe, true);
				
				if(pe instanceof Shape) {
					if(!(pe instanceof Diagram)) {
						anchorService.createOrUpdateChopboxAnchor((Shape)pe, AgePattern.chopboxAnchorName);
					}
				} else if(pe instanceof Connection) {
					final Connection connection = (Connection)pe;
					// Set Anchors
			        connection.setStart(srcAnchor);
			        connection.setEnd(dstAnchor);
			        
					// Set Connection Style
			        if(!(gr instanceof AgeConnection)) {
			        	return null;
			        }
			        
			        connection.getGraphicsAlgorithm().setStyle(styleService.getStyle(((AgeConnection)gr).getConnectionStyle().getStyleId()));				
				}
			}
			
			// Create children
			if(childContainer != null) {
				// Ghost children if the PE being added or updated is the child container
				if(childContainer == pe) {
					ghostingService.ghostChildren(childContainer);
				}
				
				// Determine whether children should be shown
				final int depthLevel = shapeService.getDepthLevel(childContainer);
				final boolean showContents = depthLevel <= propertyService.getNestingDepth(getDiagram());
				if(showContents) {
					// Refresh Children
					// It is up to the pictogram handler to provide children in an appropriate order(objects represented by connections should be last)
					final Stream<?> childBos = (Stream<?>)ContextInjectionFactory.invoke(handler, GetChildren.class, eclipseCtx, null);
					if(childBos != null) {
						final Iterator<?> childIt = childBos.iterator();
					    if (childIt.hasNext()) {
					    	final IEclipseContext childEclipseCtx = extService.createChildContext();
							try {
								while(childIt.hasNext()) {
									createUpdateChild(childEclipseCtx, childContainer, childIt.next());
								}
							} finally {
								childEclipseCtx.dispose();
							}					    	
					    }					    
					}
				}
			}
			
			if(pe != null) {
				// Don't create labels and graphics for diagrams
				if(!(pe instanceof Diagram)) {
					if(pe instanceof Connection) {
						final Connection connection = (Connection)pe;
						connection.getConnectionDecorators().clear();
						
					    final AgeConnection ageConnection = (AgeConnection)gr;
					    createDecorator(connection, ageConnection.getSourceTerminator(), 0.0);
					    createDecorator(connection, ageConnection.getDestinationTerminator(), 1.0);
					}

					// Create name label
					final String name = (String)ContextInjectionFactory.invoke(handler, GetName.class, eclipseCtx, null);				
					if(name != null) {
						if(pe instanceof ContainerShape) {
							labelService.createLabelShape((ContainerShape)pe, PictogramHandlerUpdateFeature.nameShapeName, bo, name);
						} else if(pe instanceof Connection) {
							final Connection connection = (Connection)pe;
							
							// Before removing all the decorators, get position of the label(if one exists)
							int labelX = 0;
							int labelY = 0;
							for(final ConnectionDecorator d : connection.getConnectionDecorators()) {
								if(PictogramHandlerUpdateFeature.nameShapeName.equals(propertyService.getName(d))) {
									if(d.getGraphicsAlgorithm() != null) {
										final Text text = (Text)d.getGraphicsAlgorithm();
										labelX = text.getX();
										labelY = text.getY();
									}
								}
							}

							// Create label
					        final IGaService gaService = Graphiti.getGaService();
							final ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.5, true);
							final Text text = gaService.createDefaultText(getDiagram(), textDecorator);
							text.setStyle(styleService.getStyle(StyleConstants.LABEL_STYLE));
							propertyService.setName(textDecorator, PictogramHandlerUpdateFeature.nameShapeName);
							gaService.setLocation(text, labelX, labelY);					 		
						    text.setValue(name);
						    featureProvider.link(textDecorator, bo instanceof Element ? new AadlElementWrapper((Element)bo) : bo);			    
						}
					}
					
					// Refresh Graphics Algorithm. Connections do not have their graphics algorithms recreated because they all have the same type of GraphicsAlgorithm
					// and because there are issues when recreating the graphics algorithm of connections. Upon update, the connecitons may disappear.
					if(pe instanceof Shape) {
						refreshShapeGraphicsFromRepresentation((Shape)pe, gr);
						
						// Set the position of the refreshed graphics algorithm
						final GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
						if(ga != null) {
							ga.setX(x);
							ga.setY(y);
						}
					}
					
					// Layout the shape
					if(pe instanceof Shape) {
						final LayoutContext context = new LayoutContext(pe);
						featureProvider.layoutIfPossible(context);
					}
				}
			}
			
		} finally {
			eclipseCtx.dispose();
		}	
	
		return pe;
	}	
	
	private void createDecorator(final Connection connection, final ConnectionTerminator terminator, final double position) {
		if(terminator != null) {
			final IPeCreateService peCreateService = Graphiti.getPeCreateService();
			final ConnectionDecorator cd = peCreateService.createConnectionDecorator(connection, false, position, true);
			final Diagram diagram = connection.getParent();
			final Color black = Graphiti.getGaService().manageColor(diagram, IColorConstant.BLACK);
			final Color white = Graphiti.getGaService().manageColor(diagram, IColorConstant.WHITE);

			switch(terminator) {
			case FILLED_ARROW: {
				final GraphicsAlgorithm ga = createPolygonArrow(cd);
			    ga.setForeground(black);
			    ga.setBackground(black);
				break;
			}
				
			case OPEN_ARROW: {
				final GraphicsAlgorithm ga = createPolygonArrow(cd);
			    ga.setForeground(black);
			    ga.setBackground(white);
				break;
			}
				
			default:
				throw new RuntimeException("Unhandled case: " + terminator);
			}
		}
	}
	
	private GraphicsAlgorithm createPolygonArrow(final GraphicsAlgorithmContainer gaContainer) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolygon(gaContainer, new int[] {
	    		-14, 8, 
	    		2, 0, 
	    		-14, -8});
	    return ga;
	}
	
	private void refreshShapeGraphicsFromRepresentation(final Shape shape, final Object gr) {
		final GraphicsAlgorithm oldGa = shape.getGraphicsAlgorithm();			
		final GraphicsAlgorithm ga;
		if(gr == null) {
			return; 
		} else if(gr instanceof Rectangle) {
			ga = Graphiti.getGaService().createPlainRectangle(shape);
			ga.setFilled(false);
		} else if(gr instanceof Ellipse) {
	        ga = Graphiti.getGaService().createPlainEllipse(shape);
	        ga.setFilled(false);
		} else {
			throw new RuntimeException("Unsupported object: " + gr);
		}
		
		// Set to appropriate size. If just recreating the graphics algorithm, retain previous size
		ga.setWidth(Math.max(50, oldGa == null ? 0 : oldGa.getWidth()));
        ga.setHeight(Math.max(50, oldGa == null ? 50 : oldGa.getHeight()));
	}
	
	private void createUpdateChild(final IEclipseContext eclipseCtx, final ContainerShape containerShape, final Object childBo) {
		final Object childPictogramHandler = extService.getApplicablePictogramHandler(childBo);
		eclipseCtx.set(Names.BUSINESS_OBJECT, childBo);			
		final Object gr = ContextInjectionFactory.invoke(childPictogramHandler, GetGraphicalRepresentation.class, eclipseCtx, null);
		if(gr instanceof AgeShape) {
			shapeCreationService.createUpdateShape(containerShape, childBo);
		} else if(gr instanceof AgeConnection) {
			connectionCreationService.createUpdateConnection(containerShape, childBo);
		} else {
			throw new RuntimeException("Unsupported graphical representation: " + gr);
		}
	}
	
	private Diagram getDiagram() {
		return featureProvider.getDiagramTypeProvider().getDiagram();
	}
}
