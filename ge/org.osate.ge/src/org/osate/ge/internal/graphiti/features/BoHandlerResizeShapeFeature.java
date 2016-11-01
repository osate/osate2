package org.osate.ge.internal.graphiti.features;

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
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.graphiti.graphics.AgeGraphitiGraphicsUtil;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ExtensionService;

public class BoHandlerResizeShapeFeature extends DefaultResizeShapeFeature {
	private final BusinessObjectResolutionService bor;
	private final ExtensionService extService;
	private final Object handler;
	
	@Inject
	public BoHandlerResizeShapeFeature(final BusinessObjectResolutionService bor, final ExtensionService extService, final IFeatureProvider fp, final Object boHandler) {
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
	
		// Handle rebuild the graphics algorithm as appropriate
		if (shape.getGraphicsAlgorithm() != null) {			
			final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
			if(bo != null) {
				final IEclipseContext eclipseCtx = extService.createChildContext();
				try {
					eclipseCtx.set(Names.BUSINESS_OBJECT, bo);			
					final Object gr = (Graphic)ContextInjectionFactory.invoke(handler, GetGraphic.class, eclipseCtx, null);
					AgeGraphitiGraphicsUtil.resizeGraphicsAlgorithm(getDiagram(), shape, gr, width, height);
				} finally {
					eclipseCtx.dispose();
				}
			}
			
			Graphiti.getGaService().setLocation(shape.getGraphicsAlgorithm(), x, y);
		}

		layoutPictogramElement(shape);
	}
}
