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
				AlignmentHandlerHelper.driveUp(rde, primaryDiagramElement.getRelativeCoordinate(), m,
						(alignLocation, topOffset) -> {
							return alignLocation;
						}, (de) -> (0));
			}
		});

		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(AlignmentHandlerHelper.getEnabled());
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

	private void driveUp(RelativeDiagramElement rde, double alignLocation, final DiagramModification m) {
		// Check if new shape location fits within parent(s)
		rde = getDiagramElementToMove(rde, alignLocation, m);

		if (rde.getDiagramElement().getParent() instanceof DiagramElement) {
			alignLocation = rde.getDiagramElement().getY() - (rde.getRelativeCoordinate() - alignLocation);
		}

		m.setPosition(rde.getDiagramElement(), new Point(rde.getDiagramElement().getX(), alignLocation));
	}

	private RelativeDiagramElement getDiagramElementToMove(RelativeDiagramElement rde, double relativeLocation,
			final DiagramModification m) {
		while (rde.getDiagramElement().getParent() instanceof DiagramElement) {
			final DiagramElement parentElement = (DiagramElement) rde.getDiagramElement().getParent();
			final double pRel = rde.getRelativeCoordinate() - rde.getDiagramElement().getY();

			// Check if new location will fit within container
			if (pRel > relativeLocation) {
				rde = moveChild(rde, pRel, relativeLocation, parentElement, m);
			} else {
				if ((pRel + parentElement.getHeight()) < relativeLocation) {
					moveChildren(rde, pRel, relativeLocation, parentElement, m);
				}

				break;
			}
		}

		return rde;
	}

	private RelativeDiagramElement moveChild(final RelativeDiagramElement rde, final double pRel,
			final double relativeLocation,
			final DiagramElement parentDe, final DiagramModification m) {
		// shift all children
		final double childOffset = pRel - relativeLocation;
		for (final Queryable q : parentDe.getChildren()) {
			if(q instanceof DiagramElement) {
				final DiagramElement childDe = (DiagramElement) q;
				m.setPosition(childDe, new Point(childDe.getX(), childDe.getY() + childOffset));
			}
		}

		rde.setNewX(pRel);
		m.setPosition(rde.getDiagramElement(), new Point(rde.getDiagramElement().getX(), 0));
		AlignmentHandlerHelper.setParentSize(m, parentDe, childOffset);
		return new RelativeDiagramElement(parentDe, pRel);
	}

	private void moveChildren(final RelativeDiagramElement rde, final double pRel,
			final double relativeLocation, final DiagramElement parentDe, final DiagramModification m) {
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
