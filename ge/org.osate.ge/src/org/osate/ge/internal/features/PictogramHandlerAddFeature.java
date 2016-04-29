package org.osate.ge.internal.features;

import java.util.Objects;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.services.ExtensionService;

// IAddFeature implementation that delegates behavior to a pictogram handler
public class PictogramHandlerAddFeature extends AbstractAddFeature implements ICustomUndoRedoFeature{
	private final PictogramHandlerRefreshHelper refreshHelper;
	private final Object handler;
	
	public PictogramHandlerAddFeature(final ExtensionService extService, final PictogramHandlerRefreshHelper refreshHelper, 
			final IFeatureProvider fp, final Object pictogramHandler) {
		super(fp);
		this.refreshHelper = Objects.requireNonNull(refreshHelper, "refreshHelper must not be null");
		this.handler = Objects.requireNonNull(pictogramHandler, "pictogramHandler must not be null");
	}
	
	@Override
	public boolean canAdd(IAddContext context) {
		// Assumes that the feature was created after checking if the pictogram handler handles the context
		return true;
	}
	
	@Override
	public PictogramElement add(final IAddContext context) {
		final Object bo = AadlElementWrapper.unwrap(context.getNewObject());
		if(bo == null) {
			return null;
		}
		
		final Anchor srcAnchor, dstAnchor;
		if(context instanceof IAddConnectionContext) {
			final IAddConnectionContext addConContext = (IAddConnectionContext)context;
			srcAnchor = addConContext.getSourceAnchor();
			dstAnchor = addConContext.getTargetAnchor();
		} else {
			srcAnchor = null;
			dstAnchor = null;
		}
		
		return refreshHelper.refresh(bo, handler, null, 0, 0, context.getTargetContainer(), srcAnchor, dstAnchor);
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
