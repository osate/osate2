package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.internal.services.LayoutService;
import org.osate.ge.internal.services.PropertyService;

/**
 * A resize shape feature that is used by default for the AADL Graphical Editor
 *
 */
public class AgeResizeShapeFeature extends DefaultResizeShapeFeature {
	private final PropertyService propertyService;
	private final LayoutService layoutService;
	
	@Inject
	public AgeResizeShapeFeature(final PropertyService propertyService, final LayoutService layoutService, final IFeatureProvider fp) {
		super(fp);
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");		
		this.layoutService = Objects.requireNonNull(layoutService, "layoutService must not be null");
	}
	
	@Override
	public boolean canResizeShape(final IResizeShapeContext ctx) {
		final Shape shape = ctx.getShape();
		
		// Don't allow resizing of transient shapes
		if(propertyService.isTransient(shape)) {
			return false;
		}
		
		// Don't allow resizing of docked shapes
		if(propertyService.getDockArea(shape) != null) {
			return false;
		}
		
		// TODO: Error checking
		final Shape container = shape.getContainer();
		if(!(container instanceof Diagram) && ctx.getDirection() != IResizeShapeContext.DIRECTION_UNSPECIFIED) {
			final GraphicsAlgorithm containerInnerGa = container.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0);
			if(ctx.getX() < containerInnerGa.getX() || 
					ctx.getY() < containerInnerGa.getY() ||
					ctx.getX() >= containerInnerGa.getX() + containerInnerGa.getWidth() ||
					ctx.getY() >= containerInnerGa.getY() + containerInnerGa.getHeight()) {
				return false;
			}
		}
		
		return super.canResizeShape(ctx);
	}
	
	@Override
	public void resizeShape(final IResizeShapeContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();			
		super.resizeShape(context);
		layoutService.checkShapeBoundsWithAncestors(shape);
		
		// TODO: Update Connection Anchors
		//updateConnectionAnchors(shape);	
	}
}
