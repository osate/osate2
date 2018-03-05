package org.osate.ge.internal.ui.handlers;

import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ge.internal.util.Log;

/**
 * Handler for the open diagram menu commands
 *
 */
public class OpenDiagramHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		try {
			Log.ok(getClass().getSimpleName() + " Started");

			// Determine the context BO
			final Object contextBo = Objects.requireNonNull(SelectionUtil
					.getDiagramContext(HandlerUtil.getCurrentSelection(event), HandlerUtil.getActiveEditor(event)),
					"Unable to determine context business object");

			final DiagramService diagramService = (DiagramService) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getService(DiagramService.class);
			diagramService.openOrCreateDiagramForBusinessObject(contextBo);

			Log.ok(getClass().getSimpleName() + " Finished");
		} catch(RuntimeException e) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					Activator.PLUGIN_ID, "Error creating diagram: " + e.getMessage());
			Log.error("Error creating diagram", e);
			throw e;
		}

		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		final Object contextBo = SelectionUtil.getDiagramContext(
				AgeHandlerUtil.getSelectionFromContext(evaluationContext),
				AgeHandlerUtil.getActiveEditorFromContext(evaluationContext));
		setBaseEnabled(contextBo != null);
	}
}
