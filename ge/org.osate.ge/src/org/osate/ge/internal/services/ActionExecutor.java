package org.osate.ge.internal.services;

public interface ActionExecutor {
	/**
	 * Modes which affect how an action is executed.
	 *
	 */
	enum ExecutionMode {
		NORMAL,
		// The execution of the event should be treated as part of the previous action. Append to previous. If there isn't a previous. Hide.
		APPEND_ELSE_HIDE,
		HIDE,
	}

	/**
	 * Executes an action.
	 * @param label
	 * @param mode
	 * @param action
	 * @return true if a reversable modification was performed.
	 */
	boolean execute(String label, ExecutionMode mode, AgeAction action);
}
