package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.LayoutService;
import org.osate.ge.internal.services.PropertyService;

public class AgeMoveShapeFeature extends DefaultMoveShapeFeature {
	private final BusinessObjectResolutionService bor;
	private final PropertyService propertyService;
	private final LayoutService layoutService;
	
	@Inject
	public AgeMoveShapeFeature(final BusinessObjectResolutionService bor, final PropertyService propertyService, final LayoutService layoutService, final IFeatureProvider fp) {
		super(fp);
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");		
		this.layoutService = Objects.requireNonNull(layoutService, "layoutService must not be null");
	}
	
	@Override
	protected boolean avoidNegativeCoordinates() {
		return true;
	}
	
	@Override
	public boolean canMoveShape(final IMoveShapeContext ctx) {
		final Shape shape = ctx.getShape();
		
		// Don't allow moving of transient shapes
		if(propertyService.isTransient(shape)) {
			return false;
		}
		
		final String dockArea = propertyService.getDockArea(ctx.getShape());
		final Shape container = shape.getContainer();
		if(container instanceof Diagram) {
			if(bor.getBusinessObjectForPictogramElement(shape) == bor.getBusinessObjectForPictogramElement(shape.getContainer())) {
				return false;
			}
		} else {
			if(dockArea == null) {
				// TODO: Error checking
				final GraphicsAlgorithm containerInnerGa = container.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0);
				if(ctx.getX() < containerInnerGa.getX() || 
						ctx.getY() < containerInnerGa.getY() ||
						ctx.getX() >= containerInnerGa.getX() + containerInnerGa.getWidth() ||
						ctx.getY() >= containerInnerGa.getY() + containerInnerGa.getHeight()) {
					return false;
				}
			}
		}
		
		// Don't allow moving of nested docked shapes..
		if(LayoutService.DockArea.GROUP.id.equals(dockArea)) {
			return false;
		}
		
		return super.canMoveShape(ctx);
	}
	
	@Override 
	protected void postMoveShape(final IMoveShapeContext context) {	
		super.postMoveShape(context);
		
		final ContainerShape shape = (ContainerShape)context.getShape();
		final String currentDockArea = propertyService.getDockArea(shape);
		if(currentDockArea != null && shape.getContainer() != null) {
	        propertyService.setDockArea(shape, getDockArea(shape).id);
	        
	        // Layout the shape
	        layoutPictogramElement(shape);
	        
	        // Layout Parent
        	layoutPictogramElement(shape.getContainer());
		}		
				
		layoutService.checkShapeBoundsWithAncestors(shape);

        // TODO: Update connection anchors when they are supported in business object handlers
		//connectionService.updateConnectionAnchors(shape);
	}
	
	private LayoutService.DockArea getDockArea(final ContainerShape shape) {
		// TODO: Cleanup. Error checking, etc..
		final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
		final ContainerShape container = shape.getContainer();
		final GraphicsAlgorithm containerInnerGa = container.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0); // TODO
		
		// Relative to the inner area of the container
		final int centerX = Math.min(Math.max(0, ga.getX() + ga.getWidth()/2 - containerInnerGa.getX()), containerInnerGa.getWidth());
		final int centerY = Math.min(Math.max(0, ga.getY() + ga.getHeight()/2 - containerInnerGa.getY()), containerInnerGa.getHeight());
		final int distanceToLeft = centerX;
		final int distanceToRight = containerInnerGa.getWidth()-centerX;
		final int distanceToTop = centerY;
		final int distanceToBottom = containerInnerGa.getHeight()-centerY;
		
		// Find the closest dock area while giving priority to the left, right, top, and bottom.
		if(distanceToLeft <= distanceToRight && distanceToLeft <= distanceToTop && distanceToLeft <= distanceToBottom) {
			return LayoutService.DockArea.LEFT;
		} else if(distanceToRight <= distanceToTop && distanceToRight <= distanceToBottom) {
			return LayoutService.DockArea.RIGHT;
		} else if(distanceToTop <= distanceToBottom) {
			return LayoutService.DockArea.TOP;
		} else {
			return LayoutService.DockArea.BOTTOM;
		}
	}
}
