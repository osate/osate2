package org.osate.ge.internal.services;

import java.util.function.Consumer;

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

	public interface ActionGroup {

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

	/**
	 * Recommended to use execute() instead. Exposed to allow better integration with Graphiti.
	 * @param label
	 * @param mode
	 * @return an object for referencing the action group. May return null if the action group is not a top level action group.
	 */
	ActionGroup beginExecuteGroup(final String label, ExecutionMode mode);

	boolean endExecuteGroup(final ActionGroup actionGroup);

	/**
	 * Adds a wrapper to the current action group that will be used when undo/redoing. If the wrapper has already been added
	 * to the current action group, this method is a no-op.
	 * @param wrapper
	 */
	void addUndoWrapper(final Consumer<Runnable> wrapper);
}
