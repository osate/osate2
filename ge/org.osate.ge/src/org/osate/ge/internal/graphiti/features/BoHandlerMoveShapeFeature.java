package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.internal.services.BusinessObjectResolutionService;

public class BoHandlerMoveShapeFeature extends DefaultMoveShapeFeature {
	private final Object handler;
	private final BusinessObjectResolutionService bor;
	
	public BoHandlerMoveShapeFeature(final Object handler, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.handler = Objects.requireNonNull(bor, "handler must not be null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		
	}
	
	@Override
	protected boolean avoidNegativeCoordinates() {
		return true;
	}
	
	@Override
	public boolean canMoveShape(final IMoveShapeContext ctx) {
		final Shape shape = ctx.getShape();
		if(shape.getContainer() instanceof Diagram) {
			if(bor.getBusinessObjectForPictogramElement(shape) == bor.getBusinessObjectForPictogramElement(shape.getContainer())) {
				return false;
			}
		}
		
		return super.canMoveShape(ctx);
	}
}
