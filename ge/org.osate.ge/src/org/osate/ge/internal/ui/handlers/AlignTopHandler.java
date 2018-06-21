package org.osate.ge.internal.ui.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.ui.util.UiUtil;

public class AlignTopHandler extends AbstractHandler {

	// This handler assumes that the selection contains diagram elements which are moveable, not docked, and all have the same container.
	// TODO: Loosen restrictions during future enhancements so that nesting and docked shapes are handled.
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		diagram.modify("Align Top", m -> {
			double top = AgeHandlerUtil.getPrimaryDiagramElement(selectedDiagramElements).getY();
			for (final DiagramElement de : selectedDiagramElements) {
				m.setPosition(de, new Point(de.getX(), top));
			}
		});

		return null;
	}

}
