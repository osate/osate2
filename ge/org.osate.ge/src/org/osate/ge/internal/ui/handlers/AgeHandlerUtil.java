package org.osate.ge.internal.ui.handlers;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.ui.util.SelectionUtil;

public class AgeHandlerUtil {
	// Returns the current selection as diagram elements.
	// If one or more of the selected objects cannot be adapted to DiagramElement then an empty list is returned.
	public static List<DiagramElement> getSelectedDiagramElements(final ExecutionEvent event) {
		final ISelection selection = HandlerUtil.getCurrentSelection(event);
		return SelectionUtil.getSelectedDiagramElements(selection);
	}

	public static DiagramElement getPrimaryDiagramElement(final List<DiagramElement> elements) {
		if (elements.size() == 0) {
			return null;
		}

		return elements.get(elements.size() - 1);
	}

	public static void activateTool(final ExecutionEvent event, final Object tool) {
		final IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
		final UiService uiService = Adapters.adapt(editorPart, UiService.class);
		if (uiService == null) {
			throw new RuntimeException("Unable to get UiService");
		}

		uiService.activateTool(tool);
	}
}
