package org.osate.ge.ba.handlers;

import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ge.DiagramCreationUtil;
import org.osate.ge.ba.diagram.diagramType.BehaviorAnnexDiagramType;
import org.osate.ge.ba.util.SelectionUtil;

public class OpenBehaviorAnnexDiagramHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		final Element annexSubclause = Objects.requireNonNull(BehaviorAnnexHandlerUtil.getAnnexSubclause(activeEditor),
				"AnnexSubclause cannot be null");
		final Classifier classifier = Objects.requireNonNull(annexSubclause.getContainingClassifier(),
				"Classifier cannot be null");
		final String fileName = getFileName(classifier, annexSubclause);
		DiagramCreationUtil.openOrCreateDiagram(annexSubclause, true, false, new BehaviorAnnexDiagramType(),
				fileName);
		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		// final Object diagramContext = SelectionUtil.getDiagramContext(SelectionUtil.getCurrentSelection(),
		// SelectionUtil.getActiveEditorFromContext(evaluationContext), findDiagramContextForSelectedObject);
		System.err.println(SelectionUtil.getActiveEditorFromContext(evaluationContext) + " activeEditor");
		final Element diagramContext = BehaviorAnnexHandlerUtil.getAnnexSubclause(
				SelectionUtil.getActiveEditorFromContext(evaluationContext));
		System.err.println(diagramContext + " diagramContextAAA");
		setBaseEnabled(diagramContext instanceof DefaultAnnexSubclause || diagramContext instanceof BehaviorAnnex);
	}



	private static String getFileName(final Classifier classifier, Element annexSubclause) {
		if (annexSubclause instanceof BehaviorAnnex) {
			annexSubclause = annexSubclause.getOwner();
		}

		final StringBuilder fileName = new StringBuilder(classifier.getQualifiedName().replaceAll("::|:|\\.", "_"));
		fileName.append("_behavior_");
		return fileName.append(classifier.getOwnedAnnexSubclauses().indexOf(annexSubclause)).toString();
	}
}
