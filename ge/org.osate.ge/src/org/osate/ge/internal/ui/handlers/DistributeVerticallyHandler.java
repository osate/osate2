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

public class DistributeVerticallyHandler extends AbstractHandler {

	/**
	 * Distributes shapes along the Y axis so each shape has an equal distance between them
	 */
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		// newVert(diagram, selectedDiagramElements);
		executeO(event);

//		diagram.modify("Distribute Horizontally", m -> {
//			// Distribute the shapes horizontally
//			final double xDistribution = getXDistribution(sortedDiagramElements);
//			for (int i = 1; i < sortedDiagramElements.size() - 1; i++) {
//				final RelativeDiagramElement rde = sortedDiagramElements.get(i);
//				final double newX = getXValue(sortedDiagramElements.get(i - 1), xDistribution);
//				// Drive up to find out if any parents need resizing
//				driveUp(rde, newX, m);
//			}
//		});

		return null;
	}

	private void newVert(final AgeDiagram diagram, final List<DiagramElement> selectedDiagramElements) {
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}
		// TODO de.hasposition?
		final List<RelativeDiagramElement> sortedDiagramElements = selectedDiagramElements.stream()
				.map(de -> new RelativeDiagramElement(de, getRelativeY(de)))
				.sorted((r1, r2) -> Double.compare(r1.x, r2.x))
				.collect(Collectors.toList());

		diagram.modify("Distribute Horizontally", m -> {

			// Distribute the shapes horizontally
			final double yDistribution = getYDistribution(sortedDiagramElements);
			for (int i = 1; i < sortedDiagramElements.size() - 1; i++) {
				final RelativeDiagramElement de = sortedDiagramElements.get(i);
				// final double x = de.de.getX();
				final double y = getYValue(sortedDiagramElements.get(i - 1), yDistribution);
				driveUp(de, y, m);
			}
		});
	}

	private void driveUp(RelativeDiagramElement rde, double newY, final DiagramModification m) {
		// Check if new shape location fits within parent(s)
		rde = getDiagramElementToMove(rde, newY, m);

		if (rde.de.getParent() instanceof DiagramElement) {
			newY = rde.de.getY() - (rde.x - newY);
		}
		rde.setRelative(newY);
		m.setPosition(rde.de, new Point(rde.de.getX(), newY));
	}

	public Object executeO(final ExecutionEvent event) throws ExecutionException {
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements(event);
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		diagram.modify("Distribute Horizontally", m -> {
			selectedDiagramElements.sort(YValueComparator);

			// Distribute the shapes horizontally
			final double yDistribution = getYDistributionO(selectedDiagramElements);
			for (int i = 1; i < selectedDiagramElements.size() - 1; i++) {
				final DiagramElement de = selectedDiagramElements.get(i);
				final double x = de.getX();
				final double y = getYValue(selectedDiagramElements.get(i - 1), yDistribution);

				m.setPosition(de, new Point(x, y));
			}
		});

		return null;
	}

	/**
	 * Calculate the Y-coordinate value for the shape being evaluated
	 * @param prevElement the GraphicsAlgorithm of the shape just before the current shape being evaluated
	 * @param yDistribution the Y-coordinate distance that needs to be between each shape
	 * @return the Y-coordinate value for the shape being evaluated
	 */
	private static double getYValue(final DiagramElement prevElement, final double yDistribution) {
		return prevElement.getY() + prevElement.getHeight() + yDistribution;
	}

	private static double getYDistributionO(final List<DiagramElement> diagramElements) {
		final int lastIndex = diagramElements.size() - 1;
		final double heightOfShapes = getHeightOfShapesO(diagramElements);
		final DiagramElement firstElement = diagramElements.get(0);
		final DiagramElement lastElement = diagramElements.get(lastIndex);
		return (lastElement.getY() + lastElement.getHeight() - firstElement.getY() - heightOfShapes) / lastIndex;
	}

	/**
	 * Calculate the height of the all shapes, used for distribution calculations
	 * @param shapes the selected shapes
	 * @return the height of the middle shapes
	 */
	private static double getHeightOfShapesO(final List<DiagramElement> diagramElements) {
		return diagramElements.stream().mapToDouble(de -> de.getHeight()).sum();
	}

	// TODO: fix name and comment
	// Check if new location can fit within the parent shape. Set child(s) to zero, and expand parent(s)
	private RelativeDiagramElement getDiagramElementToMove(RelativeDiagramElement rde, double newX,
			final DiagramModification m) {
		while (rde.de.getParent() instanceof DiagramElement) {
			final DiagramElement parentElement = (DiagramElement) rde.de.getParent();
			System.err.println(rde.x + " y");
			System.err.println(rde.de.getY() + " y");
			final double pRel = rde.x - rde.de.getY();
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
		System.err.println(rde.de.getBusinessObject() + " de set to zero");
		m.setPosition(rde.de, new Point(rde.de.getX(), 0));
		return new RelativeDiagramElement(parentElement, pRel);
	}

	private double getRelativeY(DiagramElement de) {
		System.err.println(de.getBusinessObject());
		double y = de.getY();
		while (de.getParent() instanceof DiagramElement) {
			de = (DiagramElement) de.getParent();
			y += de.getY();
		}

		System.err.println(" : bo : " + y);
		return y;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(AgeHandlerUtil.getSelectedDiagramElementsFromContext(evaluationContext).stream().filter(de -> {
			final DockArea dockArea = de.getDockArea();
			return dockArea == DockArea.TOP || dockArea == DockArea.BOTTOM;
		}).count() == 0);
	}

	/**
	 * Calculate the height of the all shapes, used for distribution calculations
	 * @param shapes the selected shapes
	 * @return the height of the middle shapes
	 */
	private static double getHeightOfShapes(final List<RelativeDiagramElement> diagramElements) {
		return diagramElements.stream().mapToDouble(rde -> rde.de.getHeight()).sum();
	}

	/**
	 * Calculate the Y-coordinate value for the shape being evaluated
	 * @param prevElement the GraphicsAlgorithm of the shape just before the current shape being evaluated
	 * @param yDistribution the Y-coordinate distance that needs to be between each shape
	 * @return the Y-coordinate value for the shape being evaluated
	 */
	private static double getYValue(final RelativeDiagramElement prevElement, final double yDistribution) {
		return prevElement.x + prevElement.de.getHeight() + yDistribution;
	}

	/**
	 * Calculate the distance between each selected shape after distribution
	 * @param shapes the selected shapes
	 * @return the distance between each shape after distribution
	 */
	private static double getYDistribution(final List<RelativeDiagramElement> diagramElements) {
		final int lastIndex = diagramElements.size() - 1;
		final double heightOfShapes = getHeightOfShapes(diagramElements);
		final RelativeDiagramElement firstElement = diagramElements.get(0);
		final RelativeDiagramElement lastElement = diagramElements.get(lastIndex);
		return (lastElement.x + lastElement.de.getHeight() - firstElement.x - heightOfShapes) / lastIndex;
	}

	/**
	 * Sort the selected shapes based on Y-coordinate value
	 */
	private static final Comparator<DiagramElement> YValueComparator = (de1, de2) -> Double.compare(de1.getY(),
			de2.getY());
}
