package org.osate.ge.gef.ui.editor;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Handler for the zoom in command.
 * Increases the zoom level by calling {@link AgeEditor#zoomIn()} when the command is activated.
 */
public class ZoomInHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if (editor instanceof AgeEditor) {
			((AgeEditor) editor).zoomIn();
		}

		return null;
	}
}
