package org.osate.ge.internal.ui.editor.actions;

import java.util.Objects;

import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ActionService.ActionStackChangeListener;

public abstract class ActionStackAction extends WorkbenchPartAction {
	protected final ActionService actionService;
	private final ActionStackChangeListener actionStackChangeListener = () -> refresh();

	public ActionStackAction(final IWorkbenchPart part) {
		super(part);
		this.actionService = Objects.requireNonNull(PlatformUI.getWorkbench().getService(ActionService.class),
				"Unable to retrieve action service");

		refresh();

		// Add a listener to undo service which refreshes the state
		actionService.addChangeListener(actionStackChangeListener);
	}

	@Override
	public void dispose() {
		actionService.removeChangeListener(actionStackChangeListener);
	}
}
