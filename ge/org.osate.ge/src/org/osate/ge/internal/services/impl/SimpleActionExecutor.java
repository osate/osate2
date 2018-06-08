package org.osate.ge.internal.services.impl;

import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.AgeAction;

/**
 * Basic implementation of ActionExecutor that just executes the actions.
 *
 */
public class SimpleActionExecutor implements ActionExecutor {

	@Override
	public void execute(final AgeAction action) {
		action.execute();
	}

	@Override
	public void executeGroup(final String label, final Runnable runnable) {
		runnable.run();
	}
}
