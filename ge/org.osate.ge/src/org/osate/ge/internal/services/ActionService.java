package org.osate.ge.internal.services;

/**
 * ActionExecutor that manages an action stack. The action stack allows undoing and redoing actions.
 * It also provides notifications of changes to the action stack.
 *
 * ActionService implementations must handle the execution of actions while another action is running.
 *
 */
public interface ActionService extends ActionExecutor {
	public interface ActionStackChangeListener {
		void actionStackChanged();
	}

	void addChangeListener(ActionStackChangeListener listener);
	void removeChangeListener(ActionStackChangeListener listener);

	/**
	 *
	 * @return true if an action is currently being executed.
	 */
	boolean isActionExecuting();

	String getUndoLabel();
	boolean canUndo();
	void undo();

	String getRedoLabel();
	boolean canRedo();
	void redo();

	/**
	 * Clears the action stack
	 */
	void clearActionStack();
	void removeInvalidActions();
}
