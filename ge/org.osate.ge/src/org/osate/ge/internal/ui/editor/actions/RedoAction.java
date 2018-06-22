package org.osate.ge.internal.ui.editor.actions;

import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;

public class RedoAction extends ActionStackAction {
	public RedoAction(final IWorkbenchPart part) {
		super(part);
		setId(ActionFactory.REDO.getId());
	}

	@Override
	public void run() {
		actionService.redo();
	}

	@Override
	protected boolean calculateEnabled() {
		return actionService.canRedo();
	}

	@Override
	protected void refresh() {
		super.refresh();
		setText("Redo " + actionService.getRedoLabel());
	}
}
