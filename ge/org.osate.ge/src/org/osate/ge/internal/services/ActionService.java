package org.osate.ge.internal.services;

public interface ActionService extends ActionExecutor {
	public interface ActionStackChangeListener {
		void actionStackChanged();
	}

	void addChangeListener(ActionStackChangeListener listener);
	void removeChangeListener(ActionStackChangeListener listener);

	String getUndoLabel();
	boolean canUndo();
	void undo();

	String getRedoLabel();
	boolean canRedo();
	void redo();

	void removeInvalidActions();
}
