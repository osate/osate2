package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.AgeAction;

/**
 * Custom feature for wrapping an AgeAction into a Graphiti feature. This is needed to avoid accessing Graphiti's command stack directly.
 *
 */
public class AgeActionCustomFeature extends AbstractCustomFeature
{
	private final ActionExecutor actionExecutor;
	private final String label;
	private final AgeAction action;
	private boolean executeResult;

	public AgeActionCustomFeature(final ActionExecutor actionExecutor, final String label, final AgeAction action,
			final IFeatureProvider fp) {
		super(fp);
		this.actionExecutor = Objects.requireNonNull(actionExecutor, "actionExecutor must not be null");
		this.label = Objects.requireNonNull(label, "label must not be null");
		this.action = Objects.requireNonNull(action, "action must not be null");
	}


	@Override
	public String getName() {
		return label;
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
		executeResult = actionExecutor.execute(label, ActionExecutor.ExecutionMode.NORMAL, action);
	}

	/**
	 *
	 * @return the return value of the ActionExecutor.execute() call.
	 */
	public boolean getExecuteResult() {
		return executeResult;
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
