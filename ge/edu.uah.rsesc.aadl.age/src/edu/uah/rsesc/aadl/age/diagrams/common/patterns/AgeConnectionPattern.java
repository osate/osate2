package edu.uah.rsesc.aadl.age.diagrams.common.patterns;

import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.func.IUpdate;
import org.eclipse.graphiti.pattern.AbstractConnectionPattern;
import org.eclipse.graphiti.pattern.IConnectionPattern;
import org.eclipse.graphiti.pattern.ICustomUndoablePattern;

/**
 * Base class for all connection Patterns for AGE. Contains logic shared between all connection patterns.
 * @author philip.alldredge
 *
 */
public abstract class AgeConnectionPattern extends AbstractConnectionPattern implements IConnectionPattern, ICustomUndoablePattern, IUpdate {
	public abstract boolean isMainBusinessObjectApplicable(final Object mainBusinessObject);
	
	@Override
	public boolean canAdd(IAddContext context) {
        return context instanceof IAddConnectionContext && isMainBusinessObjectApplicable(context.getNewObject());
	}
	
	@Override
	public boolean canUndo(final IFeature feature, final IContext context) {
		return false;
	}

	@Override
	public void undo(final IFeature feature, final IContext context) {
	}

	@Override
	public boolean canRedo(final IFeature feature, final IContext context) {
		return false;
	}

	@Override
	public void redo(final IFeature feature, final IContext context) {
	}
}
