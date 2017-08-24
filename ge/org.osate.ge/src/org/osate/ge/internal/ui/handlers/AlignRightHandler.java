package org.osate.ge.internal.ui.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.Point;
import org.osate.ge.internal.ui.util.UiUtil;

public class AlignRightHandler extends AbstractHandler {

	// This handler assumes that the selection contains diagram elements which are moveable, not docked, and all have the same container.
	// TODO: Loosen restrictions during future enhancements so that nesting and docked shapes are handled.
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements(event);
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		diagram.modify("Align Right", m -> {
			final DiagramElement primaryElement = AgeHandlerUtil.getPrimaryDiagramElement(selectedDiagramElements);
			final int right = primaryElement.getX() + primaryElement.getWidth();
			for (final DiagramElement de : selectedDiagramElements) {
				m.setPosition(de, new Point(right - de.getWidth(), de.getY()));
			}
		});

		return null;
	}

}
