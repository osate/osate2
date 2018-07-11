package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.ui.handlers.AlignmentHandlerHelper.Function;
import org.osate.ge.internal.ui.util.UiUtil;

public class AlignBottomHandler extends AbstractHandler {

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

		Function f = (alignLocation, bottomOffset) -> {
			return alignLocation - bottomOffset;
		};

		diagram.modify("Align Bottom", m -> {
			final RelativeDiagramElement primaryDiagramElement = getPrimaryDiagramElement(relativeDiagramElements);
			final double alignLocation = primaryDiagramElement.getRelativeCoordinate()
					+ primaryDiagramElement.getDiagramElement().getHeight();
			for (final RelativeDiagramElement rde : relativeDiagramElements) {
				AlignmentHandlerHelper.driveUp(rde, alignLocation, m, f, (de) -> (rde.getDiagramElement().getHeight()));
			}
		});

		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(AlignmentHandlerHelper.getEnabled());
	}


//
//	private void moveChildren(final RelativeDiagramElement rde, final double pRel, final double relativeLocation,
//			final DiagramElement parentDe, final DiagramModification m) {
//		// shift all children
//		final double childOffset = relativeLocation - rde.getRelativeCoordinate()
//				+ rde.getDiagramElement().getHeight() / 2;
//		for (final Queryable q : parentDe.getChildren()) {
//			if (q instanceof DiagramElement) {
//				final DiagramElement childDe = (DiagramElement) q;
//				if (childDe != rde.getDiagramElement()) {
//					m.setPosition(childDe, new Point(childDe.getX(), childDe.getY() + childOffset));
//				}
//			}
//		}
//
//		AlignmentHandlerHelper.setParentSize(m, parentDe, childOffset);
//	}

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
