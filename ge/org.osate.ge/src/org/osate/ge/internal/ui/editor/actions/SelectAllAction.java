package org.osate.ge.internal.ui.editor.actions;

import java.util.Objects;

import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.ui.actions.ActionFactory;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

import com.google.common.base.Predicates;

/**
 * Action that selects all diagram elements.
 *
 */
public class SelectAllAction extends WorkbenchPartAction {
	private final AgeDiagramEditor editor;

	public SelectAllAction(final AgeDiagramEditor editor) {
		super(editor);
		this.editor = Objects.requireNonNull(editor);
		setId(ActionFactory.SELECT_ALL.getId());
	}

	@Override
	public void run() {
		final GraphitiAgeDiagram gad = editor.getGraphitiAgeDiagram();
		final PictogramElement[] pictogramElements = editor.getAgeDiagram().getAllDiagramNodes()
				.filter(DiagramElement.class::isInstance).map(DiagramElement.class::cast)
				.map(gad::getPictogramElement).filter(Predicates.notNull()).toArray(PictogramElement[]::new);

		editor.getDiagramBehavior().getDiagramContainer().selectPictogramElements(pictogramElements);
	}

	@Override
	protected boolean calculateEnabled() {
		return true;
	}

}
