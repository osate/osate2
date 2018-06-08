package org.osate.ge.internal.services;

public interface AgeAction {
	String getLabel();

	boolean canExecute();

	/**
	 *
	 * @return an action that will reverse the action or null if there is nothing to reverse.
	 */
	AgeAction execute();

	/**
	 * Returns false if the action is no longer valid and all references to it should be removed. For example if the action references an editor
	 * which has been closed.
	 * @return
	 */
	default boolean isValid() {
		return true;
	}
}
