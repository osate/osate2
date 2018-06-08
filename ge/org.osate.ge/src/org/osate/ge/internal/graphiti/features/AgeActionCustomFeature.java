package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.AgeAction;

/**
 * Custom feature for wrapping an AgeAction into a Graphiti feature. This is needed to avoid accessing Graphiti's command stack directly.
 *
 */
public class AgeActionCustomFeature extends AbstractCustomFeature
{
	private final ActionService actionService;
	private final AgeAction action;

	public AgeActionCustomFeature(final ActionService actionService, final AgeAction action,
			final IFeatureProvider fp) {
		super(fp);
		this.actionService = Objects.requireNonNull(actionService, "actionService must not be null");
		this.action = Objects.requireNonNull(action, "action must not be null");
	}


	@Override
	public String getName() {
		return action.getLabel();
	}

	@Override
	public boolean isAvailable(final IContext context) {
		return true;
	}

	@Override
	public boolean canExecute(final ICustomContext context) {
		return action.canExecute();
	}

	@Override
	public void execute(final ICustomContext context) {
		actionService.execute(action);
	}

	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}

	@Override
	public boolean hasDoneChanges() {
		return true;
	}
}
