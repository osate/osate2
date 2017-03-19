package org.osate.ge.internal.graphiti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Font;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.CurvedConnection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.util.IColorConstant;
import org.osate.aadl2.Element;
import org.osate.ge.di.GetName;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.DiagramElement;
import org.osate.ge.internal.DockArea;
import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.annotations.AgeAnnotation;
import org.osate.ge.internal.annotations.Annotation;
import org.osate.ge.internal.decorations.Decoration;
import org.osate.ge.internal.di.GetAnnotations;
import org.osate.ge.internal.di.GetDecorations;
import org.osate.ge.internal.di.GetDefaultDockingPosition;
import org.osate.ge.internal.diagram.AgeDiagram;
import org.osate.ge.internal.diagram.DiagramConfiguration;
import org.osate.ge.internal.diagram.DiagramElementContainer;
import org.osate.ge.internal.graphics.AgeConnection;
import org.osate.ge.internal.graphics.AgeShape;
import org.osate.ge.internal.graphiti.graphics.AgeGraphitiGraphicsUtil;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.ui.editor.AgeDiagramBehavior;

// TODO: Rework. Don't make copy. Listener/Synchronization paradigm.
public class GraphitiAgeDiagram {
	public final static String AADL_DIAGRAM_TYPE_ID = "AADL Diagram";
	
	private final Diagram graphitiDiagram;
	private final Map<PictogramElement, AgeDiagramElement> pictogramElementToDiagramElementMap = new HashMap<>();
	private final Map<AgeDiagramElement, PictogramElement> diagramElementToPictogramElementMap = new HashMap<>();
	
	/**
	 * GraphitiAgeDiagram constructor. Keeps and internal copy of the specified AgeDiagram.
	 * @param ageDiagram
	 */
	public GraphitiAgeDiagram(final AgeDiagram ageDiagram) {
		Objects.requireNonNull(ageDiagram, "ageDiagram must not be null");
		this.graphitiDiagram = Graphiti.getPeService().createDiagram(AADL_DIAGRAM_TYPE_ID, "Untitled Diagram", true); // TODO: Diagram title
		
		createUpdateChildren(ageDiagram, graphitiDiagram);
		
		// TODO: Initialize the age graphiti elements based on the AgeDiagram. 
		// TODO: Listeners to keep thigsg in sync after original update		
		// Internal copy. Nothing touches the AgeDiagram without going through this class.
		
		// First Step... Initialize the graphiti elements based on the AgeDiagram elements? Or should it update based on the BO providers?
		
		// TODO: Need to be able to create graphics
		
		// TODO: Update connection anchors too. Need all shapes to exist before doing that
		
	}
	
	private void createUpdateChildren(final DiagramElementContainer elementContainer, final ContainerShape containerShape) {
		for(final AgeDiagramElement e : elementContainer.getDiagramElements()) {			
			createUpdateDiagramElement(e, containerShape);
		}
	}
	
	private void createUpdateDiagramElement(final AgeDiagramElement de, final ContainerShape containerShape) {
		final Graphic g = de.getGraphic();
		
		final PictogramElement pe = createUpdatePictogramElementForGraphic(graphitiDiagram, g, containerShape, getPictogramElement(de));		

		// Configure PE if one exists
		if(pe instanceof Shape) {										
			final Shape shape = ((Shape) pe);
			
			// Remove all non-chopbox anchors that do not have an incoming or outgoing connection
			final Iterator<Anchor> it = shape.getAnchors().iterator();
			while(it.hasNext()) {
				final Anchor anchor = it.next();
				if(!(anchor instanceof ChopboxAnchor) && anchor.getIncomingConnections().size() + anchor.getOutgoingConnections().size() == 0) {
					it.remove();
				}
			}
			
			// Create/update the chopbox anchor
			// TODO: Create/Update 
			//anchorService.createOrUpdateChopboxAnchor(shape);
											
			if(de.getDockArea() != null) {
				// Create/update the flow specification anchor for all docked shapes
				// TODO //anchorService.createOrUpdateFixPointAnchor(shape, AnchorNames.FLOW_SPECIFICATION, 0, 0, false);
			}
		} else if(pe instanceof Connection) {
			final Connection connection = (Connection)pe;
			
			// Set Anchors
			// TODO: This needs to be performed after all anchors have been created. 
			// TODO: Need to have logic somewhere which determined which anchors to use.
	        /*
	        connection.setStart(srcAnchor);	        
	        connection.setEnd(dstAnchor);
	        */
	                
	        final GraphicsAlgorithm ga = connection.getGraphicsAlgorithm();
	        ga.setStyle(null);
	        ga.setLineStyle(AgeGraphitiGraphicsUtil.toGraphitiLineStyle(((AgeConnection)g).lineStyle));
	        ga.setLineWidth(2);
	        ga.setForeground(Graphiti.getGaService().manageColor(graphitiDiagram, IColorConstant.BLACK));
	        
	        if(pe instanceof CurvedConnection) {
	        	// TODO
				//updateControlPoints((CurvedConnection)pe);
			}
		}

		// Determine which shape to use for children
		final ContainerShape nextContainerShape;
		if(g instanceof AgeShape) {
			nextContainerShape = (ContainerShape)pe;
		} else if(g instanceof AgeConnection) {
			nextContainerShape = containerShape;
		} else {
			throw new RuntimeException("Unsupported graphic: " + g);
		}

		// Update Children
		// TODO: Decide whether this is appropriate
		createUpdateChildren(de, nextContainerShape);
		
		// TODO: Create graphics and layout the shape
		/*
		// Get the name
		//TODO: Migrate!eclipseCtx.set(InternalNames.DIAGRAM_ELEMENT_PROXY, new PictogramElementProxy(pe));
		final String name = (String)ContextInjectionFactory.invoke(handler, GetName.class, eclipseCtx, null);
					
		if(pe instanceof ContainerShape) {
			if(name != null) {
				final Shape labelShape = labelService.createLabelShape((ContainerShape)pe, BoHandlerFeatureHelper.nameShapeName, bo, name, true);
				labelShape.setActive(false);
			}

			final Annotation[] annotations = (Annotation[])ContextInjectionFactory.invoke(handler, GetAnnotations.class, eclipseCtx, null);
			if(annotations != null) {
				for(final Annotation annotation : annotations) {
					final AgeAnnotation ageAnnotation = (AgeAnnotation)annotation;
					final Shape annotationShape = labelService.createLabelShape((ContainerShape)pe, BoHandlerFeatureHelper.annotationsShapeName, bo, ageAnnotation.text, true);
					annotationShape.setActive(false);
				}
			}
		} else if(pe instanceof Connection) {
			final Connection connection = (Connection)pe;
		    final AgeConnection ageConnection = (AgeConnection)gr;
		    
			// Store position of all decorators which have ID's
			final Map<String, Point> decoratorNameToLocation = new HashMap<>();
			
			for(final ConnectionDecorator d : connection.getConnectionDecorators()) {
				if(d.getGraphicsAlgorithm() instanceof Text) {
					final String id = propertyService.getName(d);
					if(id != null) {
						final Text text = (Text)d.getGraphicsAlgorithm();
						decoratorNameToLocation.put(id, new Point(text.getX(), text.getY()));
					}
				}
			}
			
			// Clear decorators
			connection.getConnectionDecorators().clear();

			final IGaService gaService = Graphiti.getGaService();
			
			// Create label decorator
			int labelX = 0;
			int labelY = 0;
			if(name != null) {
				final ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, ageConnection.isFlowIndicator ? 1.0 : 0.5, true);
				final Text text = gaService.createDefaultText(getDiagram(), textDecorator);
				labelService.setStyle(text);
				propertyService.setName(textDecorator, BoHandlerFeatureHelper.nameShapeName);						
			    text.setValue(name);

			    final Point labelPosition = decoratorNameToLocation.get(BoHandlerFeatureHelper.nameShapeName);
			    if(labelPosition == null) {
			    	// Set default position
			    	final IDimension labelTextSize = GraphitiUi.getUiLayoutService().calculateTextSize(name, text.getFont());
			    	if(ageConnection.isFlowIndicator) { // Special default position for flow indicator labels
			    		labelX = -28; // Position the label such that it the default text does not intersect with the border when docked on the left or on the right
			    		labelY = 5;
			    	} else {
			    		labelX = -labelTextSize.getWidth()/2;
			    		labelY = -labelTextSize.getHeight()/2;
			    	}
			    } else {
			    	labelX = labelPosition.x;
			    	labelY = labelPosition.y;
			    }
			    gaService.setLocation(text, labelX, labelY);
				
			    featureProvider.link(textDecorator, bo instanceof Element ? new AadlElementWrapper((Element)bo) : bo);
			}
			
			// Create Graphiti decorators for annotations
			final Annotation[] annotations = (Annotation[])ContextInjectionFactory.invoke(handler, GetAnnotations.class, eclipseCtx, null);
			if(annotations != null) {
				final Font decoratorFont = GraphitiUi.getGaService().manageDefaultFont(getDiagram());
				int annotationY = labelY;
				for(final Annotation annotation : annotations) {
					annotationY += 30;
					final AgeAnnotation ageAnnotation = (AgeAnnotation)annotation;
					
					final ConnectionDecorator annotationDecorator = peCreateService.createConnectionDecorator(connection, true, 0.5, true);
					final Text annotationTxt = gaService.createDefaultText(getDiagram(), annotationDecorator);
					labelService.setStyle(annotationTxt);
					annotationTxt.setValue(ageAnnotation.text);

					if(ageAnnotation.name != null) {
						propertyService.setName(annotationDecorator, ageAnnotation.name);
					} 
					
					// Set the annotation position
					final Point annotationPosition = ageAnnotation.name == null ? null : decoratorNameToLocation.get(ageAnnotation.name);
					final int annotationX;
					if(annotationPosition == null) {
						int annotationWidth = GraphitiUi.getUiLayoutService().calculateTextSize(ageAnnotation.text, decoratorFont).getWidth();
						annotationX = -annotationWidth/2;									
					} else {
						annotationX = annotationPosition.x;
						annotationY = annotationPosition.y;
					}
					
					gaService.setLocation(annotationTxt, annotationX, annotationY);	

					featureProvider.link(annotationDecorator, bo instanceof Element ? new AadlElementWrapper((Element)bo) : bo);
				}
			}
			
			// Create Graphiti decorators for connection terminators
		    createDecorator(connection, ageConnection.srcTerminator, 0.0);
		    createDecorator(connection, ageConnection.dstTerminator, 1.0);
		    
		    // Create Graphiti decorators based on decorations
		    final Decoration[] decorations = (Decoration[])ContextInjectionFactory.invoke(handler, GetDecorations.class, eclipseCtx, null);
		    if(decorations != null) {
		    	createConnectionDecorators(connection, decorations);
		    }
		}
		
		// Refresh Graphics Algorithm. Connections do not have their graphics algorithms recreated because they all have the same type of GraphicsAlgorithm
		// and because there are issues when recreating the graphics algorithm of connections. Upon update, the connections may disappear.
		if(pe instanceof Shape) {
			final Shape shape = (Shape)pe;
			final GraphicsAlgorithm oldGa = shape.getGraphicsAlgorithm();
			final int width = Math.max(10, oldGa == null ? 0 : oldGa.getWidth());
			final int height = Math.max(10, oldGa == null ? 10 : oldGa.getHeight());

			// Set the position of the refreshed graphics algorithm
			final IGaService gaService = Graphiti.getGaService();
			final GraphicsAlgorithm newGa = gaService.createInvisibleRectangle(shape);
			gaService.setLocationAndSize(newGa, x, y, width, height);
		}
		
		// Layout the shape
		if(pe instanceof Shape) {
			final LayoutContext context = new LayoutContext(pe);
			featureProvider.layoutIfPossible(context);
		}
		*/
		
	}
	
	/**
	 * Creates or updates a pictogram element as appropriate to match the specified graphic.
	 * @param graphitiDiagram
	 * @param graphic
	 * @param shapeContainer is the container to use when creating shapes.
	 * @param pe is the current pictogram element for the graphic.
	 * @return
	 */
	private static PictogramElement createUpdatePictogramElementForGraphic(final Diagram graphitiDiagram, final Graphic graphic, final ContainerShape shapeContainer, PictogramElement pe) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		// Create/Change Pictogram Element Based on the Graphic
		if(graphic instanceof AgeConnection) {
			final AgeConnection ac = (AgeConnection)graphic;
			
			// Remove the PE If it is of the wrong type...
			if(pe != null) {
				if((ac.isCurved && !(pe instanceof CurvedConnection)) || (!ac.isCurved && !(pe instanceof FreeFormConnection))) {
					EcoreUtil.delete(pe, true);
					pe = null;
				}
			}
			
			if(pe == null) {
		        // Create the connection
				if(ac.isCurved) {
					pe = peCreateService.createCurvedConnection(new double[] {0.0, 0.0}, graphitiDiagram);
				} else {
					pe = peCreateService.createFreeFormConnection(graphitiDiagram);
				}					
				
				Graphiti.getGaService().createPlainPolyline(pe);
			}
		
		} else if(graphic instanceof AgeShape) {
			if(pe == null) {
		        // Create the container shape
				pe = peCreateService.createContainerShape(shapeContainer, true);
			}
		} else {
			throw new RuntimeException("Unsupported graphic: " + graphic);
		}
		
		return pe;
	}
	
	public final DiagramElement getDiagramElement(final PictogramElement pe) {
		return pictogramElementToDiagramElementMap.get(pe);
	}
	
	private PictogramElement getPictogramElement(final DiagramElement de) {
		return diagramElementToPictogramElementMap.get(de);
	}
	
	public Diagram getGraphitiDiagram() {
		return graphitiDiagram;
	}
}
