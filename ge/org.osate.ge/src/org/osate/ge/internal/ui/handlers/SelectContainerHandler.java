package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

public class SelectContainerHandler extends AbstractHandler {
	@Override
	public void setEnabled(final Object evaluationContext) {
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil
				.getSelectedDiagramElementsFromContext(evaluationContext);
		final boolean enabled = selectedDiagramElements.size() == 1
				&& selectedDiagramElements.get(0).getParent() != null;
		setBaseEnabled(enabled);
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		final AgeDiagramEditor ageEditor = (AgeDiagramEditor) activeEditor;

		// Get diagram and selected elements
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements(event);
		if (selectedDiagramElements.size() == 0) {
			throw new RuntimeException("No element selected");
		}

		final DiagramElement selectedElement = selectedDiagramElements.get(0);
		final DiagramNode parent = Objects.requireNonNull(selectedElement.getParent(), "parent is null");

		final GraphitiAgeDiagram gad = ageEditor.getGraphitiAgeDiagram();
		final PictogramElement parentPe = Objects.requireNonNull(gad.getPictogramElement(parent),
				"Unable to retrieve parent pictogram element");
		ageEditor.getDiagramBehavior().getDiagramContainer()
		.selectPictogramElements(new PictogramElement[] { parentPe });

		return null;
	}
}