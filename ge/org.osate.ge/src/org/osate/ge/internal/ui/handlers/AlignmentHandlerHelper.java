package org.osate.ge.internal.ui.handlers;

import java.util.List;

import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.Dimension;
import org.osate.ge.internal.diagram.runtime.DockArea;
import org.osate.ge.internal.query.Queryable;

public class AlignmentHandlerHelper {
	static boolean isDockedTopOrBottom(final DockArea dockArea) {
		return dockArea == DockArea.TOP || dockArea == DockArea.BOTTOM;
	}

	static boolean isAncestorSelected(final DiagramElement q1, final List<DiagramElement> selectedElements) {
		Queryable temp1 = q1.getParent();

		while (temp1 != null) {
			if (selectedElements.contains(temp1)) {
				return true;
			}
			temp1 = temp1.getParent();
		}

		return false;
	}

	interface Function {
		double apply(final double alignLocation, final double offset);
	}

	interface UpdateOffset {
		double apply(final DiagramElement de);
	}

	static void driveUp(RelativeDiagramElement rde, double alignLocation, DiagramModification m, Function f,
			UpdateOffset updateOffset) {
		final double offset = updateOffset.apply(rde.getDiagramElement());

		// Check if new shape location fits within parent(s)
		rde = getDiagramElementToMove(rde,f.apply(alignLocation, offset), m);

		final DiagramElement de = rde.getDiagramElement();

		if (de.getParent() instanceof DiagramElement) {
			alignLocation = de.getY() - (rde.getRelativeCoordinate() - alignLocation);
		}

		m.setPosition(rde.getDiagramElement(), new Point(rde.getDiagramElement().getX(),f.apply(alignLocation, offset)));
	}

	private static RelativeDiagramElement getDiagramElementToMove(RelativeDiagramElement rde, double relativeLocation,
			final DiagramModification m) {
		while (rde.getDiagramElement().getParent() instanceof DiagramElement) {
			final DiagramElement parentElement = (DiagramElement) rde.getDiagramElement().getParent();
			final double pRel = rde.getRelativeCoordinate() - rde.getDiagramElement().getY();

			// Check if new location will fit within container
			if (pRel > relativeLocation) {
				rde = moveChild(rde, pRel, relativeLocation, parentElement, m);
			} else if ((pRel + parentElement.getHeight()) < relativeLocation) {
				moveChildren(rde, pRel, relativeLocation, parentElement, m);
				break;
			} else {
				break;
			}
		}

		return rde;
	}

	private static RelativeDiagramElement moveChild(final RelativeDiagramElement rde, final double pRel,
			final double relativeLocation, final DiagramElement parentDe, final DiagramModification m) {
		// shift all children
		final double childOffset = pRel - relativeLocation;
		for (final Queryable q : parentDe.getChildren()) {
			if (q instanceof DiagramElement) {
				final DiagramElement childDe = (DiagramElement) q;
				m.setPosition(childDe, new Point(childDe.getX(), childDe.getY() + childOffset));
			}
		}

		m.setPosition(rde.getDiagramElement(), new Point(rde.getDiagramElement().getX(), 0));
		AlignmentHandlerHelper.setParentSize(m, parentDe, childOffset);
		return new RelativeDiagramElement(parentDe, pRel);
	}

	private static void moveChildren(final RelativeDiagramElement rde, final double pRel, final double relativeLocation,
			final DiagramElement parentDe, final DiagramModification m) {
		// shift all children
		final double childOffset = relativeLocation - rde.getRelativeCoordinate();
		for (final Queryable q : parentDe.getChildren()) {
			if (q instanceof DiagramElement) {
				final DiagramElement childDe = (DiagramElement) q;
				if (childDe != rde.getDiagramElement()) {
					m.setPosition(childDe, new Point(childDe.getX(), childDe.getY() + childOffset));
				}
			}
		}

		AlignmentHandlerHelper.setParentSize(m, parentDe, childOffset);
	}

	static void setParentSize(final DiagramModification m, final DiagramElement parentDe, final double childOffset) {
		m.setSize(parentDe, new Dimension(parentDe.getWidth(), parentDe.getHeight() + childOffset));
	}

	static boolean getEnabled() {
		// If common ancestor is a selected element
		final List<DiagramElement> selectedElements = AgeHandlerUtil.getSelectedDiagramElements();

		// currently primary can't be a docked element?
		if (selectedElements.size() < 2
				|| AgeHandlerUtil.getPrimaryDiagramElement(selectedElements).getDockArea() != null) {
			return false;
		}

		boolean enabled = true;
		for (final DiagramElement de : selectedElements) {
			if (isDockedTopOrBottom(de.getDockArea()) || isAncestorSelected(de, selectedElements)) {
				enabled = false;
				break;
			}
		}

		return enabled;
	}

	static double getRelativeY(DiagramElement de) {
		double y = de.getY();
		while (de.getParent() instanceof DiagramElement) {
			de = (DiagramElement) de.getParent();
			y += de.getY();
		}

		return y;
	}
}
