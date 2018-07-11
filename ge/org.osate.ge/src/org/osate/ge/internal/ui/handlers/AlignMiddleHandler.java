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

public class AlignMiddleHandler extends AbstractHandler {

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
				.map(de -> new RelativeDiagramElement(de, AlignmentHandlerHelper.getRelativeY(de)))
				.collect(Collectors.toList());


		diagram.modify("Align Middle", m -> {
			final RelativeDiagramElement primaryDiagramElement = getPrimaryDiagramElement(relativeDiagramElements);
			final double alignLocation = primaryDiagramElement.getRelativeCoordinate()
					+ primaryDiagramElement.getDiagramElement().getHeight() / 2;
			for (final RelativeDiagramElement rde : relativeDiagramElements) {
				AlignmentHandlerHelper.driveUp(rde, alignLocation, m, (alignmentLocation, middleOffset) -> {
					return alignmentLocation - middleOffset;
				}, (de) -> de.getHeight() / 2);
			}
		});

		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(AlignmentHandlerHelper.getEnabled());
	}

	private void driveUp(RelativeDiagramElement rde, double alignLocation, final DiagramModification m) {
		final double middleOffset = rde.getDiagramElement().getHeight() / 2;
		// Check if new shape location fits within parent(s)
		rde = getDiagramElementToMove(rde, alignLocation - middleOffset, m);
		if (rde.getDiagramElement().getParent() instanceof DiagramElement) {
			alignLocation = rde.getDiagramElement().getY() - (rde.getRelativeCoordinate() - alignLocation);
		}

		// rde.setRelative(alignLocation - middleOffset);
		m.setPosition(rde.getDiagramElement(), new Point(rde.getDiagramElement().getX(), alignLocation - middleOffset));
	}

	private RelativeDiagramElement getDiagramElementToMove(RelativeDiagramElement rde, double relativeLocation,
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

	private RelativeDiagramElement moveChild(final RelativeDiagramElement rde, final double pRel,
			final double relativeLocation, final DiagramElement parentDe, final DiagramModification m) {
		// shift all children
		final double childOffset = pRel - relativeLocation;
		for (final Queryable q : parentDe.getChildren()) {
			if (q instanceof DiagramElement) {
				final DiagramElement childDe = (DiagramElement) q;
				m.setPosition(childDe, new Point(childDe.getX(),
						childDe.getY() + childOffset));
			}
		}

		rde.setNewX(pRel);
		m.setPosition(rde.getDiagramElement(), new Point(rde.getDiagramElement().getX(), 0));

		AlignmentHandlerHelper.setParentSize(m, parentDe, childOffset);
		return new RelativeDiagramElement(parentDe, pRel);
	}

	private void moveChildren(final RelativeDiagramElement rde, final double pRel, final double relativeLocation,
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

	public static RelativeDiagramElement getPrimaryDiagramElement(final List<RelativeDiagramElement> elements) {
		if (elements.size() == 0) {
			return null;
		}

		return elements.get(elements.size() - 1);
	}
}
