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
import org.osate.ge.internal.diagram.runtime.DockArea;
import org.osate.ge.internal.query.Queryable;
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

		final List<RelativeDiagramElement> relativeDiagramElements = selectedDiagramElements.stream()
				.map(de -> new RelativeDiagramElement(de, getRelativeY(de))).collect(Collectors.toList());

		diagram.modify("Align Top", m -> {
			final RelativeDiagramElement primaryDiagramElement = getPrimaryDiagramElement(relativeDiagramElements);
			for (final RelativeDiagramElement rde : relativeDiagramElements) {
				driveUp(rde, primaryDiagramElement.x, m);
			}
		});

		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		// If common ancestor is a selected element
		final List<DiagramElement> selectedElements = AgeHandlerUtil
				.getSelectedDiagramElementsFromContext(evaluationContext);

		// currently primary can't be a docked element?
		if (selectedElements.size() < 2
				|| AgeHandlerUtil.getPrimaryDiagramElement(selectedElements).getDockArea() != null) {
			setBaseEnabled(false);
			return;
		}


		boolean enabled = true;
		for (final DiagramElement de : selectedElements) {
			if (isDockedTopOrBottom(de.getDockArea()) || isAncestorSelected(de, selectedElements)) {
				enabled = false;
				break;
			}
		}

		setBaseEnabled(enabled);
	}

	private boolean isDockedTopOrBottom(final DockArea dockArea) {
		return dockArea == DockArea.TOP || dockArea == DockArea.BOTTOM;
	}

	static boolean isAncestorSelected(final DiagramElement q1, final List<DiagramElement> selectedElements) {
		Queryable temp1 = q1.getParent();

		while (temp1 != null) {
//			Queryable temp2 = q2;
//			while (temp2 != null) {
//				if (temp1 == temp2) {
//					return Optional.of(temp1);
//				}
//				temp2 = temp2.getParent();
//			}

			if (selectedElements.contains(temp1)) {
				return true;
			}
			temp1 = temp1.getParent();
		}

		return false;
	}

	private void driveUp(RelativeDiagramElement rde, double top, DiagramModification m) {
		// Check if new shape location fits within parent(s)
		rde = getDiagramElementToMove(rde, top, m);

		if (rde.de.getParent() instanceof DiagramElement) {
			top = rde.de.getY() - (rde.x - top);
		}

		rde.setRelative(top);
		m.setPosition(rde.de, new Point(rde.de.getX(), top));
	}

	private RelativeDiagramElement getDiagramElementToMove(RelativeDiagramElement rde, double relativeLocation,
			final DiagramModification m) {
		while (rde.de.getParent() instanceof DiagramElement) {
			final DiagramElement parentElement = (DiagramElement) rde.de.getParent();
			final double pRel = rde.x - rde.de.getY();
			// Check if new location will fit within container
			if (pRel > relativeLocation) {
				rde = moveChild(rde, pRel, relativeLocation, parentElement, m);
			} else {
				break;
			}
		}

		return rde;
	}

	private RelativeDiagramElement moveChild(final RelativeDiagramElement rde, final double pRel,
			final double relativeLocation,
			final DiagramElement parentElement, final DiagramModification m) {
		// shift all children
		final double childOffset = pRel - relativeLocation;
		final DiagramElement parentDe = (DiagramElement) rde.de.getParent();
		for (final Queryable q : parentDe.getChildren()) {
			// m.setPosition(q, new Point());
		}
		// rde.de.getY()

		rde.setNewX(pRel);
		m.setPosition(rde.de, new Point(rde.de.getX(), 0));
		return new RelativeDiagramElement(parentElement, pRel);
	}

	public static RelativeDiagramElement getPrimaryDiagramElement(final List<RelativeDiagramElement> elements) {
		if (elements.size() == 0) {
			return null;
		}

		return elements.get(elements.size() - 1);
	}

	private double getRelativeY(DiagramElement de) {
		double y = de.getY();
		while (de.getParent() instanceof DiagramElement) {
			de = (DiagramElement) de.getParent();
			y += de.getY();
		}

		return y;
	}
}
