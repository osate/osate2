package org.osate.ge.internal.services.impl;

import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.AgeAction;

/**
 * Basic implementation of ActionExecutor that just executes the actions.
 *
 */
public class SimpleActionExecutor implements ActionExecutor {
	@Override
	public boolean execute(final String label, final ExecutionMode mode, final AgeAction action) {
		return action.execute() != null;
	}
}
