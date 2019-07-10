package org.osate.ge.internal.ui.handlers;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ge.internal.ui.util.UiUtil;

public class AgeHandlerUtil {
	// Returns the current selection as diagram elements.
	// Any of the selected objects cannot be adapted to DiagramElement will be ignored.
	public static List<DiagramElement> getSelectedDiagramElements() {
		final ISelection selection = getCurrentSelection();
		return SelectionUtil.getSelectedDiagramElements(selection, true);
	}

	public static List<DiagramNode> getSelectedDiagramNodes() {
		return SelectionUtil.getSelectedDiagramNodes(getCurrentSelection(), true);
	}

	public static List<BusinessObjectContext> getSelectedBusinessObjectContexts() {
		return SelectionUtil.getSelectedBusinessObjectContexts(getCurrentSelection());
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

	public static ISelection getCurrentSelection() {
		final IWorkbenchWindow win = UiUtil.getActiveWorkbenchWindow();
		if (win == null) {
			return StructuredSelection.EMPTY;
		}

		return win.getSelectionService().getSelection();
	}

	public static IEditorPart getActiveEditorFromContext(final Object evaluationContext) {
		if (!(evaluationContext instanceof IEvaluationContext)) {
			return null;
		}

		final IEvaluationContext context = (IEvaluationContext) evaluationContext;
		final Object editorObj = context.getVariable(ISources.ACTIVE_EDITOR_NAME);
		return editorObj instanceof IEditorPart ? (IEditorPart) editorObj : null;
	}
}
