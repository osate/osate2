package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.patterns;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Feature;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgePattern;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorUtil;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierHelper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreator;
import edu.uah.rsesc.aadl.age.diagrams.common.util.UpdateHelper;

/**
 * A pattern that controls the component implementation shape that contains all the other shapes in the type diagram
 * @author philip.alldredge
 */
public class ComponentImplementationPattern extends AgePattern {
	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof ComponentImplementation;
	}

	@Override
	public boolean canAdd(final IAddContext context) {
		if(isMainBusinessObjectApplicable(context.getNewObject())) {
			if(context.getTargetContainer() instanceof Diagram) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean canMoveShape(final IMoveShapeContext context) {
		return false;
	}
	
	@Override
	public boolean canResizeShape(final IResizeShapeContext context) {
		return false;
	}
	
	@Override
	public final PictogramElement add(final IAddContext context) {
		final ComponentImplementation ci = (ComponentImplementation)AadlElementWrapper.unwrap(context.getNewObject());
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
        // Create the container shape
        final ContainerShape shape = peCreateService.createContainerShape(context.getTargetContainer(), true);
        link(shape, new AadlElementWrapper(ci));  
			
        // Finish creation
        refresh(shape, ci, context.getX(), context.getY());
        
        return shape;
	}
	
	@Override
	public final boolean update(final IUpdateContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final ComponentImplementation ci = (ComponentImplementation)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pe));
		
		if(pe instanceof ContainerShape) {
			final GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			final int x, y;
			if(ga == null) {
				x = 25;
				y = 25;
			} else {
				x = ga.getX();
				y = ga.getY();
			}
			this.refresh((ContainerShape)pe, ci, x, y);
		}
		return true;
	}
	
	private void refresh(final ContainerShape shape, final ComponentImplementation ci, final int x, final int y) {
		// Remove invalid connections from the diagram
		UpdateHelper.removeInvalidConnections(getDiagram(), getFeatureProvider());
				
		// Remove invalid features
		UpdateHelper.removeModeSpecificOrInvalidShapes(shape, this.getFeatureProvider());		
				
		// Create/Update Shapes
		ClassifierHelper.createUpdateFeatureShapes(shape, ci.getAllFeatures(), getFeatureProvider());
		createUpdateSubcomponents(shape, ci);
		
		// Create/Update Modes and Mode Transitions
		ClassifierHelper.createUpdateModeShapes(shape, ci.getAllModes(), getFeatureProvider());
		ClassifierHelper.createUpdateModeTransitions(ci.getAllModeTransitions(), getFeatureProvider());	
		
		// Create/Update Connections
		for(final Connection connection : ci.getAllConnections()) {
			// Only show flow specifications that re not in any modes
			if(connection.getAllInModes().size() == 0) {				
				final PictogramElement pictogramElement = this.getFeatureProvider().getPictogramElementForBusinessObject(connection);
				if(pictogramElement == null) {			
					final Anchor[] anchors = AnchorUtil.getAnchorsForConnection(ci, connection, getFeatureProvider());
					
					if(anchors != null) {
						final AddConnectionContext addContext = new AddConnectionContext(anchors[0], anchors[1]);
						addContext.setNewObject(new AadlElementWrapper(connection));
						addContext.setTargetContainer(shape);
						
						final IAddFeature addFeature = getFeatureProvider().getAddFeature(addContext);
						if(addFeature != null && addFeature.canAdd(addContext)) {
							addFeature.add(addContext);
						}
					}
				} else {
					final UpdateContext updateContext = new UpdateContext(pictogramElement);
					final IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(updateContext);
					
					// Update the connection regardless of whether it is "needed" or not.
					if(updateFeature != null && updateFeature.canUpdate(updateContext)) {
						updateFeature.update(updateContext);
					}
				}
			}
		}
		
		// Adjust size. Width and height
		final IGaService gaService = Graphiti.getGaService();
		
		// Determine how much to shift the X and Y of the children by
		int shiftX = 0;
		int shiftY = 0;
		for(final Shape childShape : shape.getChildren()) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			shiftX = Math.min(shiftX, childGa.getX());
			shiftY = Math.min(shiftY, childGa.getY());
		}
		
		// Determine the extra width needed to hold AADL features
		int featureWidth = 80;
		for(final Shape childShape : shape.getChildren()) {
			if(AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(childShape)) instanceof Feature) {
				featureWidth = Math.max(featureWidth, childShape.getGraphicsAlgorithm().getWidth());
			}
		}		
		
		// Calculate max width and height
		int maxWidth = 300;
		int maxHeight = 300;
		for(final Shape childShape : shape.getChildren()) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			
			// Determine the needed width and height of the classifier shape
			// Do not consider features when calculating needed width. Otherwise, features on the right side of the shape would prevent the width from shrinking
			if(!(AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(childShape)) instanceof Feature)) {				
				maxWidth = Math.max(maxWidth, childGa.getX() + childGa.getWidth() - shiftX + featureWidth);
			}			
			maxHeight = Math.max(maxHeight, childGa.getY() + childGa.getHeight() - shiftY);
			
			// Update the position of the child
			childGa.setX(childGa.getX()-shiftX);
			childGa.setY(childGa.getY()-shiftY);
		}
		
		// Create a new graphics Algorithm
		final GraphicsAlgorithm ga = GraphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(shape, getDiagram(), ci, maxWidth, maxHeight+25);
		gaService.setLocation(ga, x, y);	

		UpdateHelper.layoutChildren(shape, getFeatureProvider());
	}
	
	private void createUpdateSubcomponents(final ContainerShape shape, final ComponentImplementation ci) {
		ClassifierHelper.createUpdateShapesForElements(shape, ci.getAllSubcomponents(), getFeatureProvider(), 25, true, 30, 25, true, 20);
	}
}
