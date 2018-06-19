package org.osate.ge.internal.ui.handlers;

import java.util.Comparator;
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
import org.osate.ge.internal.ui.util.UiUtil;

// TODO remove references to diagram elements and change to relative
public class DistributeHorizontallyHandler extends AbstractHandler {
	/**
	 * Distributes shapes along the X axis so each shape has an equal distance between them
	 */
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements(event);
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		// TODO de.hasposition?
		final List<RelativeDiagramElement> sortedDiagramElements = selectedDiagramElements.stream()
				.map(de -> new RelativeDiagramElement(de, getRelativeX(de)))
				.sorted((r1, r2) -> Double.compare(r1.x, r2.x))
				.collect(Collectors.toList());

		diagram.modify("Distribute Horizontally", m -> {
			// Distribute the shapes horizontally
			final double xDistribution = getXDistribution(sortedDiagramElements);
			for (int i = 1; i < sortedDiagramElements.size() - 1; i++) {
				final RelativeDiagramElement rde = sortedDiagramElements.get(i);
				final double newX = getXValue(sortedDiagramElements.get(i - 1), xDistribution);
				// Drive up to find out if any parents need resizing
				driveUp(rde, newX, m);
			}
		});

		return null;
	}

	private double getRelativeX(DiagramElement de) {
		double x = de.getX();
		while (de.getParent() instanceof DiagramElement) {
			de = (DiagramElement) de.getParent();
			x += de.getX();
		}

		return x;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(AgeHandlerUtil.getSelectedDiagramElementsFromContext(evaluationContext).stream().filter(de -> {
			final DockArea dockArea = de.getDockArea();
			return (dockArea == DockArea.LEFT || dockArea == DockArea.RIGHT);
		}).count() == 0);
	}

	private void driveUp(RelativeDiagramElement rde, double newX, final DiagramModification m) {
		// Check if new shape location fits within parent(s)
		rde = getDiagramElementToMove(rde, newX, m);

		if (rde.de.getParent() instanceof DiagramElement) {
			newX = rde.de.getX() - (rde.x - newX);
		}
		rde.setRelative(newX);
		m.setPosition(rde.de, new Point(newX, rde.de.getY()));
	}

	// TODO: fix name and comment
	// Check if new location can fit within the parent shape. Set child(s) to zero, and expand parent(s)
	private RelativeDiagramElement getDiagramElementToMove(RelativeDiagramElement rde, double newX,
			final DiagramModification m) {
		while (rde.de.getParent() instanceof DiagramElement) {
			final DiagramElement parentElement = (DiagramElement) rde.de.getParent();
			final double pRel = rde.x - rde.de.getX();
			// Check if new location will fit within container
			if (pRel > newX) {
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
		m.setPosition(rde.de, new Point(0, rde.de.getY()));
		return new RelativeDiagramElement(parentElement, pRel);
	}

	/**
	 * Calculate the width of all shapes, used for distribution calculations
	 * @param diagramElements the selected shapes
	 * @return the width of the middle shapes
	 */
	private static double getWidthOfShapes(final List<RelativeDiagramElement> diagramElements) {
		return diagramElements.stream().mapToDouble(de -> de.de.getWidth()).sum();
	}

	/**
	 * Calculate the distance between each selected shape after distribution
	 * @param diagramElements the selected shapes
	 * @return the distance between each shape after distribution
	 */
	private static double getXDistribution(final List<RelativeDiagramElement> diagramElements) {
		final int lastIndex = diagramElements.size() - 1;
		final double widthOfShapes = getWidthOfShapes(diagramElements);
		final RelativeDiagramElement firstElement = diagramElements.get(0);
		final RelativeDiagramElement lastElement = diagramElements.get(lastIndex);
		return (lastElement.x + lastElement.de.getWidth() - firstElement.x - widthOfShapes) / lastIndex;
	}

	/**
	 * Calculate the distance between each selected shape after distribution
	 * @param diagramElements the selected shapes
	 * @return the distance between each shape after distribution
	 */
	private static double getXDistributionO(final List<DiagramElement> diagramElements) {
		final int lastIndex = diagramElements.size() - 1;
		final double widthOfShapes = getWidthOfShapesO(diagramElements);
		final DiagramElement firstElement = diagramElements.get(0);
		final DiagramElement lastElement = diagramElements.get(lastIndex);
		return (lastElement.getX() + lastElement.getWidth() - firstElement.getX() - widthOfShapes) / lastIndex;
	}

	/**
	 * Calculate the width of all shapes, used for distribution calculations
	 * @param diagramElements the selected shapes
	 * @return the width of the middle shapes
	 */
	private static double getWidthOfShapesO(final List<DiagramElement> diagramElements) {
		return diagramElements.stream().mapToDouble(de -> de.getWidth()).sum();
	}

	/**
	 * Calculate the X-coordinate value for the shape being evaluated
	 * @param prevElement the element of the shape just before the current element being evaluated
	 * @param xDistribution the X-coordinate distance that needs to be between each shape
	 * @return the X-coordinate value for the shape being evaluated
	 */
	private static double getXValue(final RelativeDiagramElement prevElement, final double xDistribution) {
		return prevElement.x + prevElement.de.getWidth() + xDistribution;
	}



	/**
	 * Sort the selected shapes based on X-coordinate value
	 */
	private static final Comparator<DiagramElement> XValueComparatorO = (de1, de2) -> Double.compare(de1.getX(),
			de2.getX());
}
