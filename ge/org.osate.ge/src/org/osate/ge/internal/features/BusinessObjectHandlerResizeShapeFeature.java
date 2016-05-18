package org.osate.ge.internal.features;

import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ExtensionService;

public class BusinessObjectHandlerResizeShapeFeature extends DefaultResizeShapeFeature {
	private final BusinessObjectResolutionService bor;
	private final ExtensionService extService;
	private final Object handler;
	
	@Inject
	public BusinessObjectHandlerResizeShapeFeature(final BusinessObjectResolutionService bor, final ExtensionService extService, final IFeatureProvider fp, final Object boHandler) {
		super(fp);
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.handler = Objects.requireNonNull(boHandler, "boHandler must not be null");
	}

	@Override
	public void resizeShape(final IResizeShapeContext context) {
		Shape shape = context.getShape();
		int x = context.getX();
		int y = context.getY();
		int width = context.getWidth();
		int height = context.getHeight();
	
		if (shape.getGraphicsAlgorithm() != null) {			
			// Refresh the polygon
			if(shape.getGraphicsAlgorithm() instanceof org.eclipse.graphiti.mm.algorithms.Polygon) {
				final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
				if(bo != null) {
					final IEclipseContext eclipseCtx = extService.createChildContext();
					try {
						eclipseCtx.set(Names.BUSINESS_OBJECT, bo);			
						final Object gr = ContextInjectionFactory.invoke(handler, GetGraphic.class, eclipseCtx, null);
						if(gr instanceof org.osate.ge.internal.graphics.Polygon) {
							final org.osate.ge.internal.graphics.Polygon agePoly = (org.osate.ge.internal.graphics.Polygon)gr; 							
							BoRefreshHelper.createPolygon(shape, agePoly, width, height);
						}
					} finally {
						eclipseCtx.dispose();
					}
				}
			}
			
			Graphiti.getGaService().setLocationAndSize(shape.getGraphicsAlgorithm(), x, y, width, height);
		}

		layoutPictogramElement(shape);
	}
}
