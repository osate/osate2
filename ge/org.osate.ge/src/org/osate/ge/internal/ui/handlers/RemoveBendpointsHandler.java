package org.osate.ge.internal.ui.handlers;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ge.internal.ui.util.UiUtil;

public class RemoveBendpointsHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		diagram.modify("Remove Bendpoints", m -> {
			for (final DiagramElement de : selectedDiagramElements) {
				if (DiagramElementPredicates.isConnection(de)) {
					m.setBendpoints(de, Collections.emptyList());
				}
			}
		});

		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final boolean enabled;
		if (window == null) {
			enabled = false;
		} else {
			enabled = SelectionUtil.getSelectedDiagramElements(window.getActivePage().getSelection(), true).stream()
					.anyMatch(DiagramElementPredicates::isConnection);
		}

		setBaseEnabled(enabled);
	}

}
