package org.osate.ge.internal.graphiti.features;

import java.util.Objects;
import org.eclipse.graphiti.features.ICustomUndoRedoFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.services.ExtensionService;

// IAddFeature implementation that delegates behavior to a business object handler
public class BoHandlerAddFeature extends AbstractAddFeature implements ICustomUndoRedoFeature{
	private final Object handler;
	
	public BoHandlerAddFeature(final ExtensionService extService, 
			final IFeatureProvider fp, 
			final Object boHandler) {
		super(fp);
		this.handler = Objects.requireNonNull(boHandler, "boHandler must not be null");
	}
	
	@Override
	public boolean canAdd(IAddContext context) {
		// Assumes that the feature was created after checking if the business object handler handles the context
		return true;
	}
	
	@Override
	public PictogramElement add(final IAddContext context) {
		final Object bo = AadlElementWrapper.unwrap(context.getNewObject());
		if(bo == null) {
			return null;
		}
		
		final Anchor srcAnchor, dstAnchor;
		final PictogramElement targetContainer;
		if(context instanceof AgeAddConnectionContext) {
			final AgeAddConnectionContext addConContext = (AgeAddConnectionContext)context;
			targetContainer = addConContext.getOwner();
			srcAnchor = addConContext.getSourceAnchor();
			dstAnchor = addConContext.getTargetAnchor();
		} else {
			targetContainer = context.getTargetContainer();
			srcAnchor = null;
			dstAnchor = null;
		}
		
		//return refreshHelper.refresh(bo, handler, null, 0, 0, targetContainer, srcAnchor, dstAnchor);
		//TODO: Migrate!
		throw new RuntimeException("TODO: Migrate");
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
