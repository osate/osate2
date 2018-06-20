package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.ui.util.UiUtil;

public class AlignMiddleHandler extends AbstractHandler {

	// This handler assumes that the selection contains diagram elements which are moveable, not docked, and all have the same container.
	// TODO: Loosen restrictions during future enhancements so that nesting and docked shapes are handled.
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements(event);
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		final List<RelativeDiagramElement> relativeDiagramElements = selectedDiagramElements.stream()
				.map(de -> new RelativeDiagramElement(de, getRelativeY(de))).collect(Collectors.toList());

		diagram.modify("Align Middle", m -> {
			final RelativeDiagramElement primaryElement = getPrimaryDiagramElement(relativeDiagramElements);
			final double middle = primaryElement.de.getY() + primaryElement.de.getHeight() / 2;

			for (final RelativeDiagramElement rde : relativeDiagramElements) {
				driveUp(rde, middle, m);
			}
		});

		return null;
	}

	private void driveUp(RelativeDiagramElement rde, double top, final DiagramModification m) {
		final double middleOffset = rde.de.getHeight() / 2;
		// Check if new shape location fits within parent(s)
		rde = getDiagramElementToMove(rde, top, m);

		if (rde.de.getParent() instanceof DiagramElement) {
			top = rde.de.getY() - (rde.x - top);
		}

		rde.setRelative(top - middleOffset);
		m.setPosition(rde.de, new Point(rde.de.getX(), top - middleOffset));
	}

	private RelativeDiagramElement getDiagramElementToMove(RelativeDiagramElement rde, double relativeLocation,
			final DiagramModification m) {
		while (rde.de.getParent() instanceof DiagramElement) {
			final DiagramElement parentElement = (DiagramElement) rde.de.getParent();
			final double pRel = rde.x - rde.de.getY();
			// Check if new location will fit within container
			if (pRel > relativeLocation) {
				rde = moveChild(rde, pRel, parentElement, m);
			} else {
				break;
			}
		}

		return rde;
	}

	private RelativeDiagramElement moveChild(final RelativeDiagramElement rde, final double pRel,
			final DiagramElement parentElement, final DiagramModification m) {
		rde.setNewX(pRel);
		m.setPosition(rde.de, new Point(rde.de.getX(), 0));
		return new RelativeDiagramElement(parentElement, pRel);
	}

	private double getRelativeY(DiagramElement de) {
		double y = de.getY();
		while (de.getParent() instanceof DiagramElement) {
			de = (DiagramElement) de.getParent();
			y += de.getY();
		}

		return y;
	}

	public static RelativeDiagramElement getPrimaryDiagramElement(final List<RelativeDiagramElement> elements) {
		if (elements.size() == 0) {
			return null;
		}

		return elements.get(elements.size() - 1);
	}
}
