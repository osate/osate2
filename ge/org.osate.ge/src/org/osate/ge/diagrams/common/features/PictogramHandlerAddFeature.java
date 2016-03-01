package org.osate.ge.diagrams.common.features;

import java.util.Objects;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.RefreshShape;
import org.osate.ge.ext.annotations.RefreshGraphics;
import org.osate.ge.services.ExtensionService;
import org.osate.ge.services.GhostingService;

// IAddFeature implementation that delegates behavior to a pictogram handler
public class PictogramHandlerAddFeature extends AbstractAddFeature implements ICustomUndoRedoFeature{
	private final ExtensionService extService;
	private final GhostingService ghostingService; 
	private final Object handler;
	
	public PictogramHandlerAddFeature(final ExtensionService extService, final GhostingService ghostingService, final IFeatureProvider fp, final Object pictogramHandler) {
		super(fp);
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.ghostingService = Objects.requireNonNull(ghostingService, "ghostingService must not be null");
		this.handler = Objects.requireNonNull(pictogramHandler, "pictogramHandler must not be null");
	}
	
	@Override
	public boolean canAdd(IAddContext context) {
		// Assumes that the feature was created after checking if the pictogram handler handles the context
		return true;
	}
	
	@Override
	public PictogramElement add(final IAddContext context) {
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.CONTAINER, context.getTargetContainer());
			eclipseCtx.set(Names.PICTOGRAM_ELEMENT, null);
			eclipseCtx.set(Names.BUSINESS_OBJECT, AadlElementWrapper.unwrap(context.getNewObject()));
			
			final PictogramElement pe = (PictogramElement)ContextInjectionFactory.invoke(handler, RefreshShape.class, eclipseCtx, null);
			if(pe != null) {
				eclipseCtx.set(Names.PICTOGRAM_ELEMENT, pe);
				getFeatureProvider().link(pe, context.getNewObject());
				ghostingService.setIsGhost(pe, false);
				
				// Refresh Graphics Algorithm
				ContextInjectionFactory.invoke(handler, RefreshGraphics.class, eclipseCtx, null);
			}
			
			return pe;
		} finally {
			eclipseCtx.dispose();
		}
	}
	
	// ICustomUndoRedoFeature
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
	@Override
	public void preUndo(IContext context) {
	}

	@Override
	public void postUndo(IContext context) {
	}

	@Override
	public boolean canRedo(IContext context) {
		return false;
	}

	@Override
	public void preRedo(IContext context) {
	}

	@Override
	public void postRedo(IContext context) {
	}
}
