package org.osate.ge.internal.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

import com.google.common.base.Predicates;

public class SelectAllConnectionsHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		final AgeDiagramEditor ageEditor = (AgeDiagramEditor) activeEditor;
		final GraphitiAgeDiagram gad = ageEditor.getGraphitiAgeDiagram();

		final PictogramElement[] connectionPictogramElements = ageEditor.getAgeDiagram().getAllDiagramNodes().filter(dn -> dn instanceof DiagramElement)
				.map(DiagramElement.class::cast).filter(DiagramElementPredicates::isConnection)
				.map(gad::getPictogramElement).filter(Predicates.notNull()).toArray(PictogramElement[]::new);

		ageEditor.getDiagramBehavior().getDiagramContainer().selectPictogramElements(connectionPictogramElements);

		return null;
	}
}
