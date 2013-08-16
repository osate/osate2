package edu.uah.rsesc.aadl.age.diagrams.common.patterns;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.Subcomponent;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierHelper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreator;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.PropertyUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeHelper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateHelper;

/**
 * Pattern for controlling Feature shapes
 * Note: Child shapes are recreated during updates so they should not be referenced.
 * @author philip.alldredge
 */
public class FeaturePattern extends AgeLeafShapePattern {
	private static final String featureShapeName = "feature";
	private static final String labelShapeName = "label";	
	public static final String innerConnectorAnchorName = "innerConnector";
	public static final String flowSpecificationAnchorName = "flowSpecification";
	private static final int featureGroupSymbolWidth = 30;
	private static final int labelPadding = 5;
	
	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof Feature;
	}
	
	@Override
	public boolean canMoveShape(final IMoveShapeContext ctx) {
		if(ctx.getPictogramElement() instanceof Shape){
			final Shape shape = (Shape)ctx.getPictogramElement();
			// TODO: Add support for moving features within a feature group
			final ContainerShape container = shape.getContainer();
			final Object containerBo = AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(container));
			if(containerBo instanceof Classifier || containerBo instanceof Subcomponent) {
				return super.canMoveShape(ctx);
			}
		}
		
		return false;
	}

	@Override
	public boolean canAdd(final IAddContext context) {
		if(isMainBusinessObjectApplicable(context.getNewObject())) {
			return true;
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

		layoutAll(shape);
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
		final ContainerShape featureShape = getFeatureShape(shape);
		final GraphicsAlgorithm featureGa = featureShape.getGraphicsAlgorithm();
		final Feature feature = (Feature)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(shape));
		
		final boolean wasLeft = PropertyUtil.getIsLeft(shape);
		final boolean isLeft = isLeft(shape);
		PropertyUtil.setIsLeft(shape, isLeft);
		
		// Feature groups
		if(feature instanceof FeatureGroup) {
			if(isLeft != wasLeft) {
				GraphicsAlgorithmUtil.mirror(featureGa);
			}
			
			if(isLeft) {
				featureGa.setX(0);
				// Set Position of All Children
				for(final Shape child : featureShape.getChildren()) {
					child.getGraphicsAlgorithm().setX(featureGroupSymbolWidth);
				}
			} else {
				// Set Position of the Graphics Algorithm
				featureGa.setX(featureGa.getWidth()-featureGroupSymbolWidth);
				
				// Set Position of All Children
				for(final Shape child : featureShape.getChildren()) {
					child.getGraphicsAlgorithm().setX(featureGa.getWidth()-child.getGraphicsAlgorithm().getWidth()-featureGroupSymbolWidth);
				}
			}
		} else {
			// Features
	        if(isLeft != wasLeft) {
	    		GraphicsAlgorithmUtil.mirror(featureGa);
	        }
		}
		
		// All
		featureGa.setX(isLeft ? 0 : shapeGa.getWidth()-featureGa.getWidth());
		final Shape labelShape = getLabelShape(shape);
		
		if(labelShape != null) {
			final GraphicsAlgorithm labelGa = labelShape.getGraphicsAlgorithm();
			labelGa.setX(isLeft ? labelPadding : shapeGa.getWidth()-labelGa.getWidth()-labelPadding);
		}	
		
		// Handle positioning of the shape in cases where the shape container has a fully initialized container
		final GraphicsAlgorithm containerGa = shape.getContainer().getGraphicsAlgorithm();
		if(containerGa != null) {
			final int containerWidth = containerGa.getWidth();
			shapeGa.setX(isLeft ? 0 : containerWidth-shape.getGraphicsAlgorithm().getWidth());
		}
	}
	
	private void layoutAll(final ContainerShape shape) {
		// Layout the children first
		for(final Shape child : getFeatureShape(shape).getChildren()) {
			layoutAll((ContainerShape)child);
		}
		
		layout(shape);
	}
	

	@Override
	protected void createGaAndInnerShapes(final ContainerShape shape, final Object bo, final int x, final int y) {
		createGaAndInnerShapes(shape, bo, x, y, 0);
	}

	/**
	 * Version of createGaAndInnerShapes that limits recursion
	 * @param shape
	 * @param bo
	 * @param x
	 * @param y
	 * @param callDepth
	 */
	private void createGaAndInnerShapes(final ContainerShape shape, final Object bo, final int x, final int y, final int callDepth) {
		final Feature feature = (Feature)bo;
		final IGaService gaService = Graphiti.getGaService();
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();		

		// Remove all children except for the feature shape
		final Iterator<Shape> childIt = shape.getChildren().iterator();
		ContainerShape featureShape = getFeatureShape(shape);
		while(childIt.hasNext()) {
			if(featureShape != childIt.next()) {
				childIt.remove();
			}
		}

		// Set the graphics algorithm for the container to an invisible rectangle to set the bounds	of the child shapes			
        final GraphicsAlgorithm ga = gaService.createInvisibleRectangle(shape);
        gaService.setLocation(ga, x, y);
        PropertyUtil.setIsLeft(shape, true);
        
		if(callDepth > 2) {
			return;
		}

		// Create the feature shape if there wasn't one
        if(featureShape == null) {
        	featureShape = peCreateService.createContainerShape(shape, true);
        	PropertyUtil.setName(featureShape, featureShapeName);
        } else {
        	gaService.createInvisibleRectangle(featureShape);
        	UpdateHelper.removeInvalidShapes(featureShape, getFeatureProvider());
        }

		// Determine the label text
        final String labelTxt = getLabelText(feature);        
        
		// Create label
        final Shape labelShape = peCreateService.createShape(shape, false);
        PropertyUtil.setName(labelShape, labelShapeName);
        final Text label = GraphicsAlgorithmCreator.createLabelGraphicsAlgorithm(labelShape, getDiagram(), labelTxt);
        
        // Set the size        
        final IDimension labelSize = GraphitiUi.getUiLayoutService().calculateTextSize(labelTxt, label.getStyle().getFont());
		gaService.setLocationAndSize(label, 0, 0, labelSize.getWidth(), labelSize.getHeight());		
		
		// Special case for feature groups
		if(feature instanceof FeatureGroup) {
			final FeatureGroup fg = (FeatureGroup)feature;
			
			int childY = 0;
			int maxChildWidth = 0;
			if(fg.getAllFeatureGroupType() == null) {
				featureShape.getChildren().clear();
			} else {				
		        // Create a set of child shapes for deletion. We will remove shapes from this list as they are updated. If a shape isn't updated, it should be removed even though
		        // it has a valid business object associated with it.
		        final Set<Shape> featureShapeChildrenToDelete = new HashSet<Shape>();
		        featureShapeChildrenToDelete.addAll(featureShape.getChildren());
		        
		        // Create/Update shapes for the child features
				for(final Feature childFeature : ClassifierHelper.getAllFeatures(fg.getAllFeatureGroupType())) {
					ContainerShape childFeatureContainer = ShapeHelper.getChildShapeByElement(featureShape, childFeature, getFeatureProvider());
					
					// Get existing shape instead of always creating
					if(childFeatureContainer == null) {
			        	// Create the container shape
			        	childFeatureContainer = peCreateService.createContainerShape(featureShape, true);
			        	link(childFeatureContainer, new AadlElementWrapper(childFeature));
			        } else {
						// Remove the shape from the list of shapes to remove
						featureShapeChildrenToDelete.remove(childFeatureContainer);
			        }
					
			        createGaAndInnerShapes(childFeatureContainer, childFeature, 50, childY, callDepth + 1);
			        final GraphicsAlgorithm childFeatureGa = childFeatureContainer.getGraphicsAlgorithm();
			        childY += childFeatureGa.getHeight() + 5;
			        maxChildWidth = Math.max(maxChildWidth, childFeatureGa.getWidth());
				}
				
				// Remove children of the feature shape that were not updated
				for(final Shape featureShapeChild : featureShapeChildrenToDelete) {
					EcoreUtil.delete(featureShapeChild, true);	
				}
			}
			
			// Create the feature group graphics algorithm
			final GraphicsAlgorithm fgGa = GraphicsAlgorithmCreator.createFeatureGroupGraphicsAlgorithm(featureShape, getDiagram(), featureGroupSymbolWidth, childY + 25);
			GraphicsAlgorithmUtil.shrink(fgGa);
			final int fgWidth = maxChildWidth+featureGroupSymbolWidth;

			// CLEAN-UP: Consider changing how symbol is created to assume left like the other symbols...
			GraphicsAlgorithmUtil.mirror(fgGa);					

			featureShape.getGraphicsAlgorithm().setWidth(fgWidth);
		} else {
			featureShape.getChildren().clear();
			
			// Create symbol
			GraphicsAlgorithmCreator.createFeatureGraphicsAlgorithm(featureShape, getDiagram(), feature, getFeatureProvider());
		}
		
		// Position the feature shape
		gaService.setLocation(featureShape.getGraphicsAlgorithm(), 0, labelSize.getHeight());  
		
        // Set size as appropriate
        gaService.setSize(ga, Math.max(getWidth(label)+labelPadding, getWidth(featureShape.getGraphicsAlgorithm())), 
        		Math.max(getHeight(label), getHeight(featureShape.getGraphicsAlgorithm())));

        layoutAll(shape); // CLEAN-UP: Ideally would only layout each shape one.. This will cause it to happen multiple times        
	}

	@Override
	protected void updateAnchors(final ContainerShape shape) {
		super.updateAnchors(shape);

		final Feature feature = (Feature)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(shape));		
		final GraphicsAlgorithm featureGa = getFeatureShape(shape).getGraphicsAlgorithm();
		final boolean isLeft = isLeft(shape);
		
		final int featureWidth = feature instanceof FeatureGroup ? featureGroupSymbolWidth : featureGa.getWidth();
		final int innerConnectorX = featureGa.getX() + (isLeft ? featureWidth : featureGa.getWidth() - featureWidth);
		final int connectorY = feature instanceof FeatureGroup ? featureGa.getHeight() - 5 : featureGa.getY() + (featureGa.getHeight() / 2);
		final int offset = isLeft ? 50 : -50;

		// Create anchors
		// Connector
		AnchorUtil.createOrUpdateFixPointAnchor(shape, innerConnectorAnchorName, innerConnectorX, connectorY);
		AnchorUtil.createOrUpdateFixPointAnchor(shape, flowSpecificationAnchorName, innerConnectorX + offset, connectorY);
		
		// Update the anchors of the children
		for(final Shape child : getFeatureShape(shape).getChildren()) {
			updateAnchors((ContainerShape)child);
		}
	}
	
	public static ContainerShape getFeatureShape(final ContainerShape container) {
		return (ContainerShape)getChildShapeByName(container, featureShapeName);
	}
	
	public static Shape getLabelShape(final ContainerShape container) {
		return getChildShapeByName(container, labelShapeName);
	}
	
	// TODO: Move to helper class?	
	private static Shape getChildShapeByName(final ContainerShape container, final String name) {
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
	
	private boolean isLeft(ContainerShape shape) {
		// Determine the feature that is an immediate child of the classifier
		while(true) {
			final ContainerShape container = shape.getContainer();
			if(container == null) {
				break;
			}
			
			final Object containerBo = AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(container));
			if(containerBo instanceof Classifier || containerBo instanceof Subcomponent) {
				break;
			}
			shape = container;
		}

		// Check if it is on the left or the right of the classifier
		final GraphicsAlgorithm shapeGa = shape.getGraphicsAlgorithm();
		final int x = shapeGa.getX() + shapeGa.getWidth()/2;
		final GraphicsAlgorithm containerGa = shape.getContainer().getGraphicsAlgorithm();
		
		// Handle the case that isLeft is caused before the container is initialized
		if(containerGa == null) {
			return true;
		}
		
		final boolean result = x < containerGa.getWidth()/2;
		return result;
	}	
}
