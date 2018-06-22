package org.osate.ge.internal.ui.editor.actions;

import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;

public class UndoAction extends ActionStackAction {
	public UndoAction(final IWorkbenchPart part) {
		super(part);
		setId(ActionFactory.UNDO.getId());
	}

	@Override
	public void run() {
		actionService.undo();
	}

	@Override
	protected boolean calculateEnabled() {
		return actionService.canUndo();
	}

	@Override
	protected void refresh() {
		super.refresh();
		setText("Undo " + actionService.getUndoLabel());
	}
}
