package edu.uah.rsesc.aadl.age.diagrams.common.patterns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.services.AnchorService;
import edu.uah.rsesc.aadl.age.services.GraphicsAlgorithmCreationService;
import edu.uah.rsesc.aadl.age.services.LayoutService;
import edu.uah.rsesc.aadl.age.services.PropertyService;
import edu.uah.rsesc.aadl.age.services.ShapeService;
import edu.uah.rsesc.aadl.age.services.StyleService;
import edu.uah.rsesc.aadl.age.services.VisibilityService;

public class ModePattern extends AgeLeafShapePattern {
	public static String innerModeShapeName = "inner_mode";
	public static String initialModeShapeName = "initial_mode";
	private final AnchorService anchorService;
	private final LayoutService resizeHelper;
	private final ShapeService shapeHelper;
	private final PropertyService propertyUtil;
	private final GraphicsAlgorithmCreationService graphicsAlgorithmCreator;
	private final StyleService styleUtil;
	
	@Inject
	public ModePattern(final AnchorService anchorUtil, final VisibilityService visibilityHelper, final LayoutService resizeHelper, final ShapeService shapeHelper, 
			final PropertyService propertyUtil, final GraphicsAlgorithmCreationService graphicsAlgorithmCreator, final StyleService styleUtil) {
		super(anchorUtil, visibilityHelper);
		this.anchorService = anchorUtil;
		this.resizeHelper = resizeHelper;
		this.shapeHelper = shapeHelper;
		this.propertyUtil = propertyUtil;
		this.graphicsAlgorithmCreator = graphicsAlgorithmCreator;
		this.styleUtil = styleUtil;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof Mode;
	}	
	
	@Override
	public boolean canAdd(final IAddContext context) {
		if(isMainBusinessObjectApplicable(context.getNewObject())) {
			if(AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(context.getTargetContainer())) instanceof ComponentClassifier) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean canResizeShape(final IResizeShapeContext ctx) {
		return false;
	}
	
	@Override 
	protected void postMoveShape(final IMoveShapeContext context) {
		final Anchor anchor = anchorService.getAnchorByName(getInnerModeShape((ContainerShape)context.getPictogramElement()), chopboxAnchorName);
		if(anchor != null) {
			updateModeTransition(anchor.getIncomingConnections());
			updateModeTransition(anchor.getOutgoingConnections());
		}
		
		resizeHelper.checkContainerSize((ContainerShape)context.getPictogramElement());
	}
	
	// Updates the control points for mode transition connections. Also update the mode transition triggers. 
	// It does not update all aspects of the connection because doing so will cause problems due to issues
	// caused by creating graphics algorithms during postMoveShape()
	public void updateModeTransition(final List<Connection> connections) {
		for(Connection connection : connections) {
			final Object connectionBo = AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(connection));
			if(connectionBo instanceof ModeTransition) {
				final ModeTransition mt = (ModeTransition)connectionBo;
				ModeTransitionPattern.updateControlPoints(connection);
				ModeTransitionPattern.updateAnchors(connection, mt, anchorService);
			}
		}
	}
	
	@Override
	protected void createGaAndInnerShapes(final ContainerShape shape, final Object bo, final int x, final int y) {
		final Mode mode = (Mode)bo;
		final IGaService gaService = Graphiti.getGaService();
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
        
        // Remove connections related to the initial shape
		{
	        final Shape initialModeShape = shapeHelper.getChildShapeByName(shape, initialModeShapeName);
	        if(initialModeShape != null) {
	        	removeConnectionsByAnchorParent(initialModeShape);
	        }
		}
        
		// Remove child shapes
		// Clear all shapes except for the inner mode shape
		final Iterator<Shape> it = shape.getChildren().iterator();
		while(it.hasNext()) {
			final Shape child = it.next();
			if(!innerModeShapeName.equals(propertyUtil.getName(child))) {
				it.remove();
			}
		}		
		
		final GraphicsAlgorithm ga = gaService.createInvisibleRectangle(shape);		
		final int initialModeHeight = 20;
		final int innerModeHeight = 50;
		final int totalHeight = mode.isInitial() ? innerModeHeight + initialModeHeight : innerModeHeight;
		
		// Get/create inner mode shape
		ContainerShape innerModeShape = getInnerModeShape(shape);
		if(innerModeShape == null) {
			innerModeShape = peCreateService.createContainerShape(shape, true);
			propertyUtil.setName(innerModeShape, innerModeShapeName);
			anchorService.createOrUpdateChopboxAnchor(innerModeShape, chopboxAnchorName);
		}
		
		// Clear the inner mode shape's children
		innerModeShape.getChildren().clear();
		
		// Determine the label text
        final String labelTxt = mode.getName();
        
		// Create label
        final Shape labelShape = peCreateService.createShape(innerModeShape, false);
        final Text text = graphicsAlgorithmCreator.createLabelGraphicsAlgorithm(labelShape, labelTxt);
        
        // Set the size        
        final IDimension textSize = GraphitiUi.getUiLayoutService().calculateTextSize(labelTxt, text.getStyle().getFont());
		final int width = Math.max(100, textSize == null ? 0 : textSize.getWidth() + 30); 
		gaService.setLocationAndSize(text, 0, 0, width, innerModeHeight);
				
		// Create the graphics algorithm
        final GraphicsAlgorithm modeGa = graphicsAlgorithmCreator.createModeGraphicsAlgorithm(innerModeShape, width, innerModeHeight);        
        gaService.setLocation(modeGa, 0, totalHeight - innerModeHeight);
        gaService.setLocationAndSize(ga, x, y, width, totalHeight);

        if(mode.isInitial()) {
			// Create the shape for the initial mode
			final ContainerShape initialModeShape = peCreateService.createContainerShape(shape, true);
			propertyUtil.setName(initialModeShape, initialModeShapeName);
			graphicsAlgorithmCreator.createInitialModeGraphicsAlgorithm(initialModeShape, 10);			
			final Anchor initialModeAnchor = peCreateService.createChopboxAnchor(initialModeShape);
			
			// Create a line between the initial mode symbol and the actual mode symbol
			final Connection initialModeConnection = peCreateService.createCurvedConnection(new double[] {0.0, -10.0}, getDiagram());
			initialModeConnection.setStart(initialModeAnchor);
			initialModeConnection.setEnd(anchorService.getAnchorByName(innerModeShape, chopboxAnchorName));
			
			// Create the line
			final Polyline polyline = gaService.createPlainPolyline(initialModeConnection);
			final Style style = styleUtil.getDecoratorStyle();
			polyline.setStyle(style);
			
			// Create the arrow decorator
			final ConnectionDecorator arrowDecorator = peCreateService.createConnectionDecorator(initialModeConnection, false, 1.0, true);    
	        createArrow(arrowDecorator, styleUtil.getDecoratorStyle());		
		}
	}
	
	private ContainerShape getInnerModeShape(final ContainerShape shape) {
		return (ContainerShape)shapeHelper.getChildShapeByName(shape, innerModeShapeName);
	}
	
	private GraphicsAlgorithm createArrow(final GraphicsAlgorithmContainer gaContainer, final Style style) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolygon(gaContainer, new int[] {
	    		-6, 4, 
	    		2, 0, 
	    		-6, -4});
	    ga.setStyle(style);
	    return ga;
	}
	
	protected void updateAnchors(final ContainerShape shape) {
		// Remove orphan anchors. Usually created by mode transition triggers
		anchorService.removeAnchorsWithoutConnections(shape);
		
		super.updateAnchors(shape);
	}
	
	private void removeConnectionsByAnchorParent(final PictogramElement anchorParent) {
		final List<Connection> connectionsToRemove = new ArrayList<Connection>();
		
		for(final Connection connection : this.getDiagram().getConnections()) {
			boolean remove = false;
			
			if((connection.getStart() != null && connection.getStart().getParent() == anchorParent) ||
					(connection.getEnd() != null && connection.getEnd().getParent() == anchorParent)) {
				remove = true;
				break;
			}

			if(remove) {
				connectionsToRemove.add(connection);
			}
		}
		
		// Remove the connections
		for(final Connection connection : connectionsToRemove) {
			EcoreUtil.delete(connection, true);
		}		
	}
}
