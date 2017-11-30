package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.diagram.runtime.layout.LayoutOptionsBuilder;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;

/**
 * Lays out the contents of selected shapes. Repositions top-level ports.
 *
 */
public class LayoutContentsHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart editorPart = Objects.requireNonNull(HandlerUtil.getActiveEditor(event),
				"unable to retrieve active editor");
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements(event);
		DiagramElementLayoutUtil.layout("Layout Contents", editorPart, selectedDiagramElements,
				new LayoutOptionsBuilder().build());
		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(AgeHandlerUtil.getSelectedDiagramElementsFromContext(evaluationContext).stream()
				.filter(DiagramElementPredicates::isShape).count() > 0);
	}
}
