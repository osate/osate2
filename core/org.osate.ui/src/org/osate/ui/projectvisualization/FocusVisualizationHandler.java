package org.osate.ui.projectvisualization;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.ui.OsateUiPlugin;

public class FocusVisualizationHandler extends AbstractHandler {
	/*
	 * Handler is only enabled when the selection is one IWorkingSet.
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			ProjectVisualizationView view = (ProjectVisualizationView) HandlerUtil.getActiveWorkbenchWindow(event)
					.getActivePage().showView(ProjectVisualizationView.ID);
			view.setScope((IWorkingSet) HandlerUtil.getCurrentStructuredSelection(event).getFirstElement());
		} catch (PartInitException e) {
			Status status = new Status(e.getStatus().getSeverity(), OsateUiPlugin.PLUGIN_ID, e.getLocalizedMessage(),
					e);
			StatusManager.getManager().handle(status, StatusManager.SHOW | StatusManager.LOG);
		}
		return null;
	}
}