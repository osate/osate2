package org.osate.ge.internal.graphiti.diagram;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
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
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.util.IColorConstant;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramModificationListener;
import org.osate.ge.internal.diagram.runtime.DiagramModifier;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.ElementAddedEvent;
import org.osate.ge.internal.diagram.runtime.ElementRemovedEvent;
import org.osate.ge.internal.diagram.runtime.ElementUpdatedEvent;
import org.osate.ge.internal.diagram.runtime.ModificationsCompletedEvent;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;
import org.osate.ge.internal.graphics.AgeConnection;
import org.osate.ge.internal.graphics.AgeConnectionTerminator;
import org.osate.ge.internal.graphics.AgeShape;
import org.osate.ge.internal.graphics.ConnectionTerminatorSize;
import org.osate.ge.internal.graphics.Label;
import org.osate.ge.internal.graphics.Poly;
import org.osate.ge.internal.graphiti.AnchorNames;
import org.osate.ge.internal.graphiti.ShapeNames;
import org.osate.ge.internal.graphiti.graphics.AgeGraphitiGraphicsUtil;

/**
 * Class that integrates AgeDiagram with Graphiti. 
 * Handles updating the Graphiti diagram to reflect changes in the AgeDiagram.
 * The Graphiti diagram must not be modified directly.
 *
 */
public class GraphitiAgeDiagram implements NodePictogramBiMap, AutoCloseable {
	public final static String AADL_DIAGRAM_TYPE_ID = "AADL Diagram";
	public final static String incompleteIndicator = "*";
	
	private final UpdaterListener updateListener;
	private final AgeDiagram ageDiagram;
	private final Diagram graphitiDiagram;
	private final ColoringProvider coloringProvider;
	private final Map<PictogramElement, DiagramNode> pictogramElementToDiagramNodeMap = new HashMap<>();
	private final Map<DiagramNode, PictogramElement> diagramNodeToPictogramElementMap = new HashMap<>();
	private final GraphitiDiagramModificationListener modificationListener = new GraphitiDiagramModificationListener();
	
	public interface UpdaterListener {
		// Called when an update is finished
		void onUpdateFinished();
	}
	
	/**
	 * 
	 * @param ageDiagram is the AgeDiagram that will be associated with the Graphiti Diagram
	 * @param graphitiDiagram is the internal graphiti diagram to associated with the Grpahiti Age Diagram. 
	 * It is a parameter rather than creating it in the constructor to work around initializing sequence issues.
	 * @param editingDomain is the editing domain to use to make modifications to the diagram. It must not contain any other diagrams.
	 */
	public GraphitiAgeDiagram(final AgeDiagram ageDiagram, 
			final Diagram graphitiDiagram,
			final EditingDomain editingDomain,
			final ColoringProvider coloringProvider,
			final UpdaterListener updateListener) {
		this.ageDiagram = Objects.requireNonNull(ageDiagram, "ageDiagram must not be null");
		Objects.requireNonNull(editingDomain, "editingDomain must not be null");
		this.coloringProvider = Objects.requireNonNull(coloringProvider, "coloringProvider must not be null");
		this.updateListener = Objects.requireNonNull(updateListener, "updateListener must not be null");		
		this.graphitiDiagram = Objects.requireNonNull(graphitiDiagram, "graphitiDiagram must not be null");
		addMapping(ageDiagram, graphitiDiagram);
		
		// Create a URI to use for the resource. This resource uses a scheme which does not have a registered handler.
		// A handler is not needed the resource's save() should not be called. The URI just serves as a unique identifier in the resource set.
		final URI ignoredUri = URI.createHierarchicalURI("osate_ge_ignore",
				null,
				null,
				new String[] { "internal.aadl_diagram" },
				null,
				null);
		
		// Create the diagram resource and add the diagram to it.
		final Resource diagramResource = editingDomain.getResourceSet().createResource(ignoredUri);				
		editingDomain.getCommandStack().execute(new AbstractCommand() {
			@Override
			protected boolean prepare() {
				return true;
			}

			@Override
			public void execute() {
				diagramResource.getContents().add(graphitiDiagram);		
				createUpdateElementsFromAgeDiagram();
			}

			@Override
			public boolean canUndo() {
				return false;
			}
			
			@Override
			public void redo() {
			}						
		});
		
		ageDiagram.addModificationListener(modificationListener); // Listen for updates
	}
	
	/**
	 * Creates/Updates and lays out graphiti elements for all diagram elements. Does not remove elements which are no longer in the graphiti diagram.
	 */
	private void createUpdateElementsFromAgeDiagram() {
		ensureCreatedChildren(ageDiagram, graphitiDiagram);
		updateChildren(ageDiagram, true);
		LayoutUtil.layoutDepthFirst(graphitiDiagram, ageDiagram, GraphitiAgeDiagram.this, coloringProvider); // Layout
		finishUpdating(ageDiagram);
	}
	
	@Override
	public void close() {
		ageDiagram.removeModificationListener(modificationListener);		
	};
	
	public void modify(final DiagramModifier modifier) {
		this.ageDiagram.modify(modifier); 
	}
	
	/**
	 * Modify method that disabled the modification listener if updateGraphitiDiaram is false. This is used to allow updating the diagram to reflect the state of the
	 * Grpahiti diagram without triggering modification of the Graphiti diagram.
	 * @param modifier
	 * @param updateGraphitiDiagram
	 */
	public void modify(final DiagramModifier modifier, final boolean updateGraphitiDiagram) {
		try {
			if(!updateGraphitiDiagram){ 
				modificationListener.disable();
			}
		
			this.ageDiagram.modify(modifier);
		} finally {
			if(!updateGraphitiDiagram) {
				modificationListener.enable();
			}
		}
	}
	
	/**
	 * Stores mapping between the diagram node and the pictogram element
	 * @param dn
	 * @param pe
	 */
	private void addMapping(final DiagramNode dn, final PictogramElement pe) {
		diagramNodeToPictogramElementMap.put(dn, pe);
		pictogramElementToDiagramNodeMap.put(pe, dn);
	}
	
	/**
	 * Removes the mapping for the specified diagram node and all children
	 * @param dn
	 */
	private void removeMappingForBranch(final DiagramNode dn) {
		// Remove mapping for children
		for(final DiagramNode child : dn.getDiagramElements()) {
			removeMappingForBranch(child);
		}
		
		// Remove mapping for the element itself
		final PictogramElement pe = getPictogramElement(dn);
		pictogramElementToDiagramNodeMap.remove(pe);
		diagramNodeToPictogramElementMap.remove(dn);
	}
	
	/**
	 * Ensures graphiti elements for children of the specified node have been created
	 * @param dn
	 * @param containerShape
	 */
	private void ensureCreatedChildren(final DiagramNode dn, final PictogramElement containerPe) {
		for(final DiagramElement e : dn.getDiagramElements()) {			
			ensureCreatedDiagramElement(e, containerPe);
		}
	}

	/**
	 * Creates/updates the pictogram element. Also creates most anchors. Connection anchors are not created. They are lazily created. 
	 * @param de
	 * @param containerShape
	 */
	private void ensureCreatedDiagramElement(final DiagramElement de, final PictogramElement containerPe) {
		final Graphic g = de.getGraphic();

		// Create/Update the pictogram Element
		final PictogramElement pe = createUpdatePictogramElementForGraphic(graphitiDiagram, g, containerPe, getPictogramElement(de));		
		Objects.requireNonNull(pe, "pe must not be null");
		
		// Set whether the pictogram element is active based if the graphic is a decoration
		if(de.getGraphicalConfiguration().isDecoration) {
			pe.setActive(!(containerPe instanceof Connection) || g instanceof Label);

			if(containerPe instanceof Connection) {
				if(!(g instanceof Label || g instanceof Poly)) {
					throw new RuntimeException("Unsupported connection decoration graphic: " + g);
				}
			} else {
				if(!(g instanceof Label)) {
					throw new RuntimeException("Unsupported shape decoration graphic: " + g);
				}
			}
		}		

		addMapping(de, pe);
		
		// Configure PE if one exists
		if(pe instanceof Shape) {										
			final Shape shape = ((Shape)pe);			
			AnchorUtil.createOrUpdateChopboxAnchor(shape);
											
			if(de.getDockArea() != null) {
				// Create/update the flow specification anchor for all docked shapes
				AnchorUtil.createOrUpdateFixPointAnchor(shape, AnchorNames.FLOW_SPECIFICATION, 0, 0, false);
			}
		}
		
		// Update Children
		ensureCreatedChildren(de, pe);
	}
	
	private void updateChildren(final DiagramNode elementContainer, final boolean recursive) {
		for(final DiagramElement e : elementContainer.getDiagramElements()) {			
			updateDiagramElement(e, recursive);
		}
	}

	/**
	 * Refreshes transient shapes and updates pictogram element properties based on the diagram element.
	 * @param de
	 * @param recursive
	 */
	private void updateDiagramElement(final DiagramElement de, final boolean recursive) {
		final Graphic g = de.getGraphic();
		
		final PictogramElement pe = getPictogramElement(de);
		if(pe == null) {
			return;
		}

		// Configure PE if one exists
		if(pe instanceof Shape) {										
			final Shape shape = ((Shape) pe);
			
			// Remove all unnamed non-chopbox anchors that do not have an incoming or outgoing connection
			final Iterator<Anchor> it = shape.getAnchors().iterator();
			while(it.hasNext()) {
				final Anchor anchor = it.next();
				if(!(anchor instanceof ChopboxAnchor) && 
						(anchor.getIncomingConnections().size() + anchor.getOutgoingConnections().size()) == 0 &&
						PropertyUtil.getName(anchor) == null) {
					it.remove();
				}
			}

			PropertyUtil.setDockArea(pe, de.getDockArea());		
			
			// Delete Transient Shapes
			if(shape instanceof ContainerShape) {
				List<Shape> shapesToDelete = null; // Shapes that should be deleted
				final ContainerShape containerShape = (ContainerShape)shape;
				for(final Shape childShape : containerShape.getChildren()) {
					if(PropertyUtil.isTransient(childShape)) {
						if(shapesToDelete == null) {
							shapesToDelete = new ArrayList<Shape>();
						}
						
						shapesToDelete.add(childShape);
					}
				}
				
				// Delete all shapes that were marked for deletion
				if(shapesToDelete != null) {
					for(final Shape s : shapesToDelete) {
						EcoreUtil.delete(s, true);
					}
				}
			}
		} else if(pe instanceof Connection) {
			final Connection connection = (Connection)pe;
			final AgeConnection ac = ((AgeConnection)g);
			// Set Anchors
			connection.setStart(getAnchor(de.getStartElement()));
			
			if(ac.isFlowIndicator) {
				// If it is a flow indicator, get the appropriate anchor from the start element
				final PictogramElement startPe = diagramNodeToPictogramElementMap.get(de.getStartElement());
				connection.setEnd(AnchorUtil.getAnchorByName(startPe, AnchorNames.FLOW_SPECIFICATION));
			} else {
				connection.setEnd(getAnchor(de.getEndElement()));
			}

	        final GraphicsAlgorithm ga = connection.getGraphicsAlgorithm();
	        ga.setStyle(null);
	        ga.setLineStyle(AgeGraphitiGraphicsUtil.toGraphitiLineStyle(ac.lineStyle));
	        ga.setLineWidth(2);
	        ga.setForeground(Graphiti.getGaService().manageColor(graphitiDiagram, IColorConstant.BLACK));
	        
	        if(pe instanceof CurvedConnection) {
	        	ConnectionUtil.updateControlPoints((CurvedConnection)pe);
			}
	        
	        if(pe instanceof FreeFormConnection) {
	        	final FreeFormConnection ffc = (FreeFormConnection)pe;
	        	final List<org.eclipse.graphiti.mm.algorithms.styles.Point> graphitiBendpoints = ffc.getBendpoints();
	        	graphitiBendpoints.clear();
	        	for(final org.osate.ge.internal.diagram.runtime.Point bendpoint : de.getBendpoints()) {
	        		graphitiBendpoints.add(Graphiti.getGaService().createPoint(bendpoint.x, bendpoint.y));
	        	}
	        }
		}

		// Update Children
		if(recursive) {
			updateChildren(de, recursive);
		}
		
		// Build the primary label which includes the element's name
		final String completenessSuffix = de.getCompleteness() == Completeness.INCOMPLETE ? incompleteIndicator : "";
		final String primaryLabelStr = de.getName() == null ? null : (de.getName() + completenessSuffix);
		
		if(pe instanceof ContainerShape) {
			// Create Labels
			if(primaryLabelStr != null) {
				final Shape labelShape = LabelUtil.createLabelShape(graphitiDiagram, (ContainerShape)pe, ShapeNames.primaryLabelShapeName, primaryLabelStr, true);
				labelShape.setActive(false);
			}

			final AgeShape ageShape = (AgeShape)de.getGraphic();
			final String annotation = ageShape.getAnnotation();
			if(annotation != null) {
				final Shape annotationShape = LabelUtil.createLabelShape(graphitiDiagram, (ContainerShape)pe, ShapeNames.annotationShapeName, annotation, true);
				annotationShape.setActive(false);
			}
		} else if(pe instanceof Connection) {
			final Connection connection = (Connection)pe;
		    final AgeConnection ageConnection = (AgeConnection)de.getGraphic();
		    
			// Clear all decorators which are not associated with a diagram node
			connection.getConnectionDecorators().removeIf((cd) -> getDiagramNode(cd) == null);
			
			final IGaService gaService = Graphiti.getGaService();
			
			// Create label decorator
			int labelX = 0;
			int labelY = 0;
			if(primaryLabelStr != null) {
				final IPeCreateService peCreateService = Graphiti.getPeCreateService();
				final ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, ageConnection.isFlowIndicator ? 1.0 : 0.5, true);
				final Text text = gaService.createDefaultText(graphitiDiagram, textDecorator);
				PropertyUtil.setIsColoringChild(text, true);
				LabelUtil.setStyle(graphitiDiagram, text);
				PropertyUtil.setName(textDecorator, ShapeNames.primaryLabelShapeName);						
			    text.setValue(primaryLabelStr);

			    final org.osate.ge.internal.diagram.runtime.Point primaryLabelPosition = de.getConnectionPrimaryLabelPosition();
			    if(primaryLabelPosition == null) {
			    	// Set default position
			    	final IDimension labelTextSize = GraphitiUi.getUiLayoutService().calculateTextSize(primaryLabelStr, text.getFont());
			    	if(ageConnection.isFlowIndicator) { // Special default position for flow indicator labels
			    		labelX = -28; // Position the label such that it the default text does not intersect with the border when docked on the left or on the right
			    		labelY = 5;
			    	} else {
			    		labelX = -labelTextSize.getWidth()/2;
			    		labelY = -labelTextSize.getHeight() - 2;
			    	}
			    } else {
			    	labelX = primaryLabelPosition.x;
			    	labelY = primaryLabelPosition.y;
			    }
			    gaService.setLocation(text, labelX, labelY);
			}
			
			// Create Graphiti decorators for connection terminators
		    createDecorator(connection, ageConnection.srcTerminator, 0.0);
		    createDecorator(connection, ageConnection.dstTerminator, 1.0);
		}

		// Refresh the Top Level Graphics Algorithm. Connections do not have their graphics algorithms recreated because they all have the same type of GraphicsAlgorithm
		// and because there are issues when recreating the graphics algorithm of connections. Upon update, the connections may disappear.
		if(pe instanceof Shape) {
			final Shape shape = (Shape)pe;
			final int width = Math.max(10, de.getWidth());
			final int height = Math.max(10, de.getHeight());

			// Set the position of the refreshed graphics algorithm
			final IGaService gaService = Graphiti.getGaService();
			final GraphicsAlgorithm newGa = gaService.createInvisibleRectangle(shape);
			PropertyUtil.setIsColoringContainer(newGa, true);
			
			// Set Size
			gaService.setSize(newGa, width, height);
			
			// Set Position
			final org.osate.ge.internal.diagram.runtime.Point position = de.getPosition();
			if(position != null) {
				gaService.setLocation(newGa, position.x, position.y);
				PropertyUtil.setIsLayedOut(pe, true);
			}
		}
	}
	
	/**
	 * Finishes updating all elements contained in the diagram.
	 */
	private void finishUpdating(final AgeDiagram diagram) {
		for(final DiagramElement element : diagram.getDiagramElements()) {							
			finishUpdating(element);
		}	
	}
	
	/**
	 * Finishes updating a diagram element.
	 * Refreshes the control points and anchors of connections related to the specified element.
	 * This function depends on the position of connection anchors so it should be executed after layout has been performed for all relevant elements.
	 * Applies any colors provided by the coloring provider.
	 */
	private void finishUpdating(final DiagramElement element) {
		final PictogramElement pe = getPictogramElement(element);
		if(pe instanceof Shape) {
			final Shape shape = ((Shape)pe);
			
			// Update control points of curved connections which are connected to the shape.
			for(final Anchor anchor : shape.getAnchors()) {
				ConnectionUtil.updateControlPoints(anchor.getIncomingConnections());
				ConnectionUtil.updateControlPoints(anchor.getOutgoingConnections());
			}
			
			AnchorUtil.updateConnectionAnchors(shape, GraphitiAgeDiagram.this);
		} else if(pe instanceof Connection) {
			AnchorUtil.updateConnectionAnchor(element, (Connection)pe, GraphitiAgeDiagram.this);
		}
		
		for(final DiagramElement child : element.getDiagramElements()) {
			finishUpdating(child);
		}
	}
		
	/**
	 * Creates or updates a pictogram element as appropriate to match the specified graphic.
	 * @param graphitiDiagram
	 * @param graphic
	 * @param shapeContainer is the container to use when creating shapes.
	 * @param pe is the current pictogram element for the graphic.
	 * @return
	 */
	private static PictogramElement createUpdatePictogramElementForGraphic(final Diagram graphitiDiagram, final Graphic graphic, final PictogramElement containerPe, PictogramElement pe) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		// Create/Change Pictogram Element Based on the Graphic
		if(graphic instanceof AgeConnection) {
			final AgeConnection ac = (AgeConnection)graphic;
			
			// Remove the PE If it is of the wrong type...
			if(pe != null) {
				if(!(pe instanceof Connection) || (ac.isCurved && !(pe instanceof CurvedConnection)) || (!ac.isCurved && !(pe instanceof FreeFormConnection))) {
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
				
				final GraphicsAlgorithm ga = Graphiti.getGaService().createPlainPolyline(pe);
				PropertyUtil.setIsColoringContainer(ga, true);
				PropertyUtil.setIsColoringChild(ga, true);
			}
		
		} else if(graphic instanceof AgeShape) {
			// Remove the PE If it is of the wrong type...
			if(pe != null) {
				if(!(pe instanceof Shape)) {
					EcoreUtil.delete(pe, true);
					pe = null;
				}
			}
			
			if(pe == null) {
				if(containerPe instanceof ContainerShape) {
					// Create the container shape
					pe = peCreateService.createContainerShape((ContainerShape)containerPe, true);
				} else if(containerPe instanceof Connection) {
					pe = peCreateService.createConnectionDecorator((Connection)containerPe, true, 0.5, true);
				} else {
					throw new RuntimeException("Unsupported container: " + containerPe);
				}
		        
			}
		} else {
			throw new RuntimeException("Unsupported graphic: " + graphic);
		}
		
		return pe;
	}
	
	public final DiagramNode getDiagramNode(final PictogramElement pe) {
		return pictogramElementToDiagramNodeMap.get(pe);
	}
	
	public final DiagramElement getDiagramElement(final PictogramElement pe) {
		final DiagramNode dn = getDiagramNode(pe);
		return dn instanceof DiagramElement ? (DiagramElement)dn : null;
	}
	
	@Override
	public PictogramElement getPictogramElement(final DiagramNode dn) {
		return diagramNodeToPictogramElementMap.get(dn);
	}
	
	/**
	 * Same as getClosestDiagramNode, but returns null if result is not a DiagramElement.
	 * @param pe
	 * @return
	 */
	public DiagramElement getClosestDiagramElement(final PictogramElement pe) {
		final DiagramNode dn = getClosestDiagramNode(pe);
		return dn instanceof DiagramElement ? (DiagramElement)dn : null;
	}
	
	/**
	 * Looks for a diagram node associated for the pictogram element. 
	 * If one is not available, it looks in the pictogram element ancestors until there are no more ancestors to check.
	 * @param pe
	 * @return
	 */
	public DiagramNode getClosestDiagramNode(PictogramElement pe) {
		DiagramNode result = getDiagramNode(pe);
		while(result == null) {
			if(pe instanceof ConnectionDecorator) {
				pe = ((ConnectionDecorator) pe).getConnection();
			} else if(pe instanceof Shape) {
				pe = ((Shape) pe).getContainer();
			} else {
				break;
			}
			
			result = getDiagramNode(pe);
		}
		
		return result;
	}
	
	public Diagram getGraphitiDiagram() {
		return graphitiDiagram;
	}
	
	public AgeDiagram getAgeDiagram() {
		return ageDiagram;
	}
	
	// This function assumes that the foreground color of all applicable graphics algorithms is black by default. 
	// When the coloring is disabled, the foreground colors are reverted to black.
	// Must be called within a transaction
	public final void refreshGraphicColoring(final DiagramElement de) {
		final PictogramElement pe = getPictogramElement(de);
		if(pe != null) {
			LayoutUtil.refreshGraphicColoring(graphitiDiagram, pe, LayoutUtil.getFinalColor(de, coloringProvider));
		}
	}
	
	private Anchor getAnchor(final DiagramElement de) {
		final PictogramElement pe = diagramNodeToPictogramElementMap.get(de);
		if(pe == null) {
			return null;
		}
		
		if(pe instanceof Connection) {
			return AnchorUtil.getOrCreateConnectionAnchor(de, (Connection)pe, this);
		} else if(pe instanceof AnchorContainer) {
			final AnchorContainer anchorContainer = (AnchorContainer)pe;
			return Graphiti.getPeService().getChopboxAnchor(anchorContainer);
		} else {		
			return null;
		}
	}	
	
	private void createDecorator(final Connection connection, final AgeConnectionTerminator terminator, final double position) {
		if(terminator != null) {
			final IPeCreateService peCreateService = Graphiti.getPeCreateService();
			final ConnectionDecorator cd = peCreateService.createConnectionDecorator(connection, false, position, true);
			final Diagram diagram = connection.getParent();
			final Color black = Graphiti.getGaService().manageColor(diagram, IColorConstant.BLACK);
			final Color white = Graphiti.getGaService().manageColor(diagram, IColorConstant.WHITE);

			final GraphicsAlgorithm ga;
			switch(terminator.type) {
			case FILLED_ARROW:
				ga = createPolygonArrow(cd, terminator.size);
			    ga.setForeground(black);
			    ga.setBackground(black);
				break;

			case OPEN_ARROW:
				ga = createPolygonArrow(cd, terminator.size);
			    ga.setForeground(black);
			    ga.setBackground(white);
				break;
			
			case LINE_ARROW:
				ga = createLineArrow(cd, terminator.size);
			    ga.setForeground(black);
			    ga.setBackground(white);
				break;
				
			case ORTHOGONAL_LINE:
				ga = createOrthogonalLine(cd);
			    ga.setForeground(black);
			    ga.setBackground(white);
				break;

			default:
				throw new RuntimeException("Unsupported terminator type: " + terminator.type);
			}
			
	        PropertyUtil.setIsColoringChild(ga, true);
	        
			if(terminator.reversed) {
				AgeGraphitiGraphicsUtil.mirrorX(ga);
			}				
		}
	}
	
	private GraphicsAlgorithm createOrthogonalLine(final GraphicsAlgorithmContainer gaContainer) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolyline(gaContainer, new int[] {
	    		0, 8,
	    		0, -8});
	    ga.setLineWidth(2);

	    return ga;
	}
	
	private GraphicsAlgorithm createLineArrow(final GraphicsAlgorithmContainer gaContainer, final ConnectionTerminatorSize size) {
		final IGaService gaService = Graphiti.getGaService();
		switch(size) {
		case REGULAR:
			return gaService.createPlainPolyline(gaContainer, new int[] {
	    		-14, 8, 
	    		2, 0, 
	    		-14, -8});
		case SMALL:
	    	return gaService.createPlainPolyline(gaContainer, new int[] {
	    		-6, 5, 
	    		2, 0, 
	    		-6, -5});
		}		
	
		throw new RuntimeException("Unsupported connection terminator size: " + size);
	}
	
	private GraphicsAlgorithm createPolygonArrow(final GraphicsAlgorithmContainer gaContainer, final ConnectionTerminatorSize size) {
		final IGaService gaService = Graphiti.getGaService();
		switch(size) {
		case REGULAR:
			return gaService.createPlainPolygon(gaContainer, new int[] {
		    		-14, 8, 
		    		2, 0, 
		    		-14, -8});
		case SMALL:
			return gaService.createPlainPolygon(gaContainer, new int[] {
		    		-6, 4, 
		    		2, 0, 
		    		-6, -4});	
		}		
		
		throw new RuntimeException("Unsupported connection terminator size: " + size);
	}
	
	private DiagramNode getUndockedDiagramNode(DiagramNode n) {
		while(n instanceof DiagramElement) {
			final DiagramElement e = ((DiagramElement) n);
			if(e.getDockArea() == null) {
				return e;
			}
			
			n = e.getContainer();
		}
		return n;
		
	}
	
	// OPTIMIZE: This uses a simple algorithm where a diagram update is performed when a new item is added. Ideally, it would only update the affected items.
	private class GraphitiDiagramModificationListener implements DiagramModificationListener {
		private boolean enabled = true;
		
		boolean elementAdded = false;
		final Set<DiagramElement> elementsToUpdate = new LinkedHashSet<>();
		final Set<DiagramElement> elementsToRemove = new LinkedHashSet<>();
		
		@Override
		public void elementAdded(final ElementAddedEvent e) {
			if(enabled) {
				onElementAdded(e.element);
			}
		}
		
		private void onElementAdded(final DiagramElement element) {
			elementsToRemove.remove(element);
			elementAdded = true;
			elementsToUpdate.clear(); // Clear all elements to update. They will not be processed if an element has been added.
		}

		@Override
		public void elementRemoved(final ElementRemovedEvent e) {
			if(enabled) {
				elementsToRemove.add(e.element);
				//elementsToAdd.remove(e.element);
				elementsToUpdate.remove(e.element);
			}
		}

		@Override
		public void elementUpdated(final ElementUpdatedEvent e) {
			// Don't store updated elements when an element has been added. The add will trigger a complete update.
			if(enabled && !elementAdded) {
				// If the pictogram element type and the graphic type do not agree on whether the element is a connection, treat the update as an addition.
				// This ensures the the pictogram element is recreated.
				final boolean peIsConnection = getPictogramElement(e.element) instanceof Connection;
				final boolean graphicIsConnection = e.element.getGraphic() instanceof AgeConnection; 
				if(peIsConnection == graphicIsConnection) {
					// All updates are treated the same at this point. Each element is updated and containers are layed out.
					if(!elementsToRemove.contains(e.element)) {
						// If the element is already in the elements to update set, remove it so that it will be inserted at the end of the set
						if(elementsToUpdate.contains(e.element)) {
							elementsToUpdate.remove(e.element);
						}
						
						elementsToUpdate.add(e.element);
					}
				} else {
					onElementAdded(e.element);
				}
			}
		}

		@Override
		public void modificationsCompleted(final ModificationsCompletedEvent event) {			
			if(enabled) {
				try {				
					// Remove elements
					for(final DiagramElement element : elementsToRemove) {						
						// Remove any contained connections first. Connections are stored at the diagram level in the Graphiti model so they need to be deleted individually.
						removeContainedConnections(element);
						
						final PictogramElement pe = getPictogramElement(element);
						if(pe != null) {
							EcoreUtil.delete(pe, true);
						}
						
						// Remove the mapping
						removeMappingForBranch(element);
					}
					
					if(elementAdded) {
						createUpdateElementsFromAgeDiagram();
					} else {					
						final Set<DiagramNode> nodesToLayout = new HashSet<>();
						
						// Update modified elements 
						for(final DiagramElement element : elementsToUpdate) {
							final PictogramElement pe = getPictogramElement(element);
							updateDiagramElement(element, false);
	
							if(pe instanceof ContainerShape || pe instanceof ConnectionDecorator) {
								final DiagramNode undockedContainer = getUndockedDiagramNode(element.getContainer());
								nodesToLayout.add(undockedContainer);
							}
						}
								
						// Layout Nodes
						// OPTIMIZE: It would be more efficient to only layout the nodes that need to be layed out instead of laying out all descendants of the container.
						nodesToLayout.removeIf((n) -> collectionContainsAnyAncestor(nodesToLayout, n)); // Filter out elements whose parents are in the collection of nodes to layout
						
						Set<DiagramElement> elementsToCheckParentsForLayout = new HashSet<>(); // Contains the set of diagram elements whose parents need to be checked to see if they should be layed out
						for(final DiagramNode n : nodesToLayout) {
							if(n instanceof AgeDiagram) {
								LayoutUtil.layoutDepthFirst(graphitiDiagram, (AgeDiagram)n, GraphitiAgeDiagram.this, coloringProvider);	
							} else if(n instanceof DiagramElement) {
								LayoutUtil.layoutDepthFirst(graphitiDiagram, (DiagramElement)n, GraphitiAgeDiagram.this, coloringProvider);
								elementsToCheckParentsForLayout.add((DiagramElement)n);
							}
						}
						
						// Check the elements to see if their parents need to be layed out
						while(elementsToCheckParentsForLayout.size() > 0) {
							final HashSet<DiagramElement> parentsToLayout = new HashSet<>();
							for(final DiagramElement e : elementsToCheckParentsForLayout) {
								// Check if the element's parent needs to be layed out.
								if(parentNeedsLayout(e)) {
									parentsToLayout.add((DiagramElement)e.getParent());
								}													
							}
							
							// Layout the parents
							for(final DiagramElement parentToLayout : parentsToLayout) {								
								// Get the pictogram element and lay it out if it is a shape
								final PictogramElement parentPe = getPictogramElement(parentToLayout);
								if(parentPe instanceof ContainerShape) {
									LayoutUtil.layout(graphitiDiagram, parentToLayout, (ContainerShape)parentPe, GraphitiAgeDiagram.this, coloringProvider);
								}
							}
							
							// Check the parents next
							elementsToCheckParentsForLayout = parentsToLayout; // Check the parents next
						}

						// Update affected connections
						for(final DiagramElement element : elementsToUpdate) {							
							finishUpdating(element);
						}			
					}
				} finally {
					elementAdded = false;
					//elementsToAdd.clear();
					elementsToRemove.clear();
					elementsToUpdate.clear();
					
					updateListener.onUpdateFinished();
				}
			}
		}
		
		/**
		 * Returns true if the parent of the specified diagram elements needs to be layed out.
		 * @param de
		 * @return
		 */
		private boolean parentNeedsLayout(final DiagramElement de) {
			// Check if the element's parent needs to be layed out.
			if(de.getContainer() instanceof DiagramElement) { 
				final DiagramElement parent = (DiagramElement)de.getContainer();
				if(!(parent.getGraphic() instanceof AgeConnection) && 
						(de.getX() < 0 ||
						de.getY() < 0 ||
						parent.getWidth() < de.getX() + de.getWidth() ||
						parent.getHeight() < de.getY() + de.getHeight())) {
					return true;
				}
			}
			
			return false;
		}
		
		private boolean collectionContainsAnyAncestor(final Collection<?> collection, final DiagramNode n) {
			DiagramNode t = n.getContainer();
			while(t != null) {
				if(collection.contains(t)) {
					return true;
				}
				t = t.getContainer();
			}
			return false;
		}		
		
		/**
		 * Removes all connections contained in the specified element or its descendants.
		 */
		private void removeContainedConnections(final DiagramElement e) {
			for(final DiagramElement element : e.getDiagramElements()) {
				final PictogramElement pe = getPictogramElement(element);
				removeContainedConnections(element);
				
				if(pe instanceof Connection) {
					EcoreUtil.delete(pe, true);
				}
			}
		}
		
		public void enable() {
			this.enabled = true;
		}
		
		public void disable() {
			this.enabled = false;
		}
	}
}
