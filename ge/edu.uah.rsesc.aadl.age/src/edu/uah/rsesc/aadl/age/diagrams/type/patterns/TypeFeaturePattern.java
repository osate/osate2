package edu.uah.rsesc.aadl.age.diagrams.type.patterns;

import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.MoveShapeContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.osate.aadl2.Feature;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgeLeafShapePattern;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreator;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.PropertyUtil;

/**
 * Pattern for controlling Feature shapes
 * Note: Child shapes are recreated during updates so they should not be referenced.
 * @author philip.alldredge
 */
public class TypeFeaturePattern extends AgeLeafShapePattern {
	private static final String featureShapeName = "feature";	
	public static final String connectorAnchorName = "connector";
	public static final String sourceAnchorName = "source";
	public static final String sinkAnchorName = "sink";
	
	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof Feature;
	}
	
	@Override
	public boolean canAdd(final IAddContext context) {
		if(isMainBusinessObjectApplicable(context.getNewObject())) {
			// TODO: Check if the target container is the root classifier
			return true;
			/*if(context.getTargetContainer() instanceof Diagram) {
				return true;
			}*/
		}
		
		return false;
	}
	
	@Override
	public boolean canResizeShape(final IResizeShapeContext ctx) {
		return false;
	}
	
	@Override
	protected void preMoveShape(final IMoveShapeContext context) {
		super.preMoveShape(context);
		
		final Shape shape = context.getShape();
		final int containerWidth = shape.getContainer().getGraphicsAlgorithm().getWidth();
		final boolean isLeft = context.getX() < containerWidth/2;
		final MoveShapeContext mutableContext = (MoveShapeContext)context;
		mutableContext.setX(isLeft ? 0 : containerWidth-shape.getGraphicsAlgorithm().getWidth());
	}

	@Override 
	protected void postMoveShape(final IMoveShapeContext context) {
		super.postMoveShape(context);
		final ContainerShape shape = (ContainerShape)context.getShape();
		
		// Recreate the graphics algorithm
		final IGaService gaService = Graphiti.getGaService();
		
		// Recreate the graphics algorithm
		final Object bo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(shape));
		final int x = shape.getGraphicsAlgorithm().getX();
		final int y = shape.getGraphicsAlgorithm().getY();
		createGaAndInnerShapes(shape, bo, x, y);
		
		layout(shape);
		updateAnchors(shape);
	}

	@Override
	public boolean canLayout(final ILayoutContext context) {
		return isPatternControlled(context.getPictogramElement());
	}
	
	@Override
	public boolean layout(final ILayoutContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();
		layout(shape);
		
		return false;
	}
	
	private void layout(final ContainerShape shape) {
		final GraphicsAlgorithm shapeGa = shape.getGraphicsAlgorithm();
		final Shape featureShape = getFeatureShape(shape);
		final GraphicsAlgorithm featureGa = featureShape.getGraphicsAlgorithm();
		final boolean isLeft = isLeft(shape);
		featureGa.setX(isLeft ? 0 : shapeGa.getWidth()-featureGa.getWidth());
	}
	
	@Override
	protected void createGaAndInnerShapes(final ContainerShape shape, final Object bo, int x, int y) {
		final Feature feature = (Feature)bo;
		final IGaService gaService = Graphiti.getGaService();
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		// Remove child shapes
		shape.getChildren().clear();
					
		// Set the graphics algorithm for the container to an invisible rectangle to set the bounds	of the child shapes			
        final GraphicsAlgorithm ga = gaService.createInvisibleRectangle(shape);
        gaService.setLocation(ga, x, y);
        final boolean isLeft = isLeft(shape);
        
		// Determine the label text
        final String labelTxt = getLabelText(feature);        
        
		// Create label
        final Shape labelShape = peCreateService.createShape(shape, false);
        final Text label = GraphicsAlgorithmCreator.createLabelGraphicsAlgorithm(labelShape, getDiagram(), labelTxt);
        
        // Set the size        
        final IDimension labelSize = GraphitiUi.getUiLayoutService().calculateTextSize(labelTxt, label.getStyle().getFont());
		gaService.setLocationAndSize(label, 0, 0, labelSize.getWidth(), labelSize.getHeight());		
        
		// Create symbol
        final Shape featureShape = peCreateService.createShape(shape, false);
        PropertyUtil.setName(featureShape, featureShapeName);
        final GraphicsAlgorithm featureGa = GraphicsAlgorithmCreator.createFeatureGraphicsAlgorithm(featureShape, getDiagram(), feature);
        if(!isLeft) {
    		GraphicsAlgorithmUtil.mirror(featureGa);
        }
        gaService.setLocation(featureGa, 0, labelSize.getHeight());
                
		

        // Set size as appropriate
        gaService.setSize(ga, Math.max(getWidth(label), getWidth(featureShape.getGraphicsAlgorithm())), 
        		Math.max(getHeight(label), getHeight(featureShape.getGraphicsAlgorithm())));

        layout(shape);
	}
	
	@Override
	protected void updateAnchors(final ContainerShape shape) {
		super.updateAnchors(shape);

		final GraphicsAlgorithm featureGa = getFeatureShape(shape).getGraphicsAlgorithm();		
		final boolean isLeft = isLeft(shape);
		final int connectorX = featureGa.getX() + (featureGa.getWidth() / 2);
		final int connectorY = featureGa.getY() + (featureGa.getHeight() / 2);
		final int sourceOffset = isLeft ? 50 : -50;
		final int sinkOffset = isLeft ? -50 : 50;
		
		// Create anchors
		// Connector
		AnchorUtil.createOrUpdateFixPointAnchor(shape, connectorAnchorName, connectorX, connectorY); 
		AnchorUtil.createOrUpdateFixPointAnchor(shape, sourceAnchorName, connectorX + sourceOffset, connectorY);
		AnchorUtil.createOrUpdateFixPointAnchor(shape, sinkAnchorName, connectorX + sinkOffset, connectorY);
	}

	public Shape getFeatureShape(final ContainerShape container) {
		return getChildShapeByName(container, featureShapeName);
	}
	
	private Shape getChildShapeByName(final ContainerShape container, final String name) {
		for(final Shape shape : container.getChildren()) {
			if(name.equals(PropertyUtil.getName(shape))) {
				return shape;
			}
		}
		
		return null;
	}
	
	private int getWidth(final GraphicsAlgorithm ga) {
		return ga.getX() + ga.getWidth();
	}
	
	private int getHeight(final GraphicsAlgorithm ga) {
		return ga.getY() + ga.getHeight();
	}
	
	public final String getLabelText(final Feature feature) {
		return feature.getName();
	}
		
	@Override
	public IReason updateNeeded(final IUpdateContext context) {
		return Reason.createFalseReason();
	}
	
	private boolean isLeft(final ContainerShape shape) {
		return shape.getGraphicsAlgorithm().getX() < shape.getContainer().getGraphicsAlgorithm().getWidth()/2;
	}
	
}
