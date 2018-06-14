package org.osate.ge.internal.ui.handlers;

import java.util.ArrayList;
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
import org.osate.ge.internal.ui.util.UiUtil;

// TODO remove references to diagram elements and change to relative
public class DistributeHorizontallyHandler extends AbstractHandler {
	/**
	 * Distributes shapes along the X axis so each shape has an equal distance between them
	 */
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		// executeO(event);
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements(event);
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		// TODO de.hasposition?
		final List<RelativeDiagramElement> sortedDiagramElements = selectedDiagramElements.stream()
				.map(de -> new RelativeDiagramElement(de)).sorted((r1, r2) -> Double.compare(r1.x, r2.x))
				.collect(Collectors.toList());

		sortedDiagramElements.forEach(rde -> System.err
				.println(rde.de.getBusinessObject() + " : x :  " + rde.de.getX() + " : Relx : " + rde.x));

		diagram.modify("Distribute Horizontally", m -> {
			// selectedDiagramElements.sort(XValueComparator);

			// Distribute the shapes horizontally
			final double xDistribution = getXDistribution(sortedDiagramElements);
			for (int i = 1; i < sortedDiagramElements.size() - 1; i++) {
				final RelativeDiagramElement rde = sortedDiagramElements.get(i);
				final double newX = getXValue(sortedDiagramElements.get(i - 1), xDistribution);
				System.err.println(newX + " newX");
				// final double t = rde.x - (rde.x - newX);
				// Drive up to find out if any parents need resizing
				final List<DiagramElement> diagramElements = driveUp(rde, newX, m);
			}
		});

		return null;
	}

	public Object executeO(final ExecutionEvent event) throws ExecutionException {
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements(event);
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		diagram.modify("Distribute Horizontally", m -> {
			selectedDiagramElements.sort(XValueComparatorO);

			// Distribute the shapes horizontally
			final double xDistribution = getXDistributionO(selectedDiagramElements);
			for (int i = 1; i < selectedDiagramElements.size() - 1; i++) {
				final DiagramElement de = selectedDiagramElements.get(i);
				final double x = getXValue(selectedDiagramElements.get(i - 1), xDistribution);
				final double y = de.getY();

				m.setPosition(de, new Point(x, y));
			}
		});

		return null;
	}

	private List<DiagramElement> driveUp(final RelativeDiagramElement rde, final double newX,
			final DiagramModification m) {
		final List<DiagramElement> diagramElementsToMove = new ArrayList<>();

		DiagramElement de = rde.de;
		diagramElementsToMove.add(de);
		if (de.getParent() instanceof DiagramElement) {
			System.err.println(de.getBusinessObject() + " the one moving");
			double difference = de.getX() - newX;
			while (de.getParent() instanceof DiagramElement) {
				de = (DiagramElement) de.getParent();
				double x = de.getPosition().x;

				difference = x - newX;
				if (difference > 0) {
					// Add for move
					diagramElementsToMove.add(de);
				}
			}

			final int lastIndex = diagramElementsToMove.size() - 1;
			for (int i = 0; i < lastIndex; i++) {
				final DiagramElement dem = diagramElementsToMove.get(i);
				rde.setNewX(0);
				m.setPosition(dem, new Point(0, dem.getY()));
			}

			final DiagramElement lastElement = diagramElementsToMove.get(lastIndex);
			if (lastElement.getParent() instanceof DiagramElement) {
				rde.setRelative((difference * -1));
				m.setPosition(lastElement, new Point((difference * -1), lastElement.getY()));
			} else {
				rde.setNewX(newX);
				m.setPosition(lastElement, new Point(newX, lastElement.getY()));
			}
		} else {
			rde.setNewX(newX);
			m.setPosition(de, new Point(newX, de.getY()));
		}

		return diagramElementsToMove;
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
	private static double getXValue(final DiagramElement prevElement, final double xDistribution) {
		return prevElement.getX() + prevElement.getWidth() + xDistribution;
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
	private static final Comparator<RelativeDiagramElement> XValueComparatorDE = (de1, de2) -> Double.compare(de1.x,
			de2.x);;

			/**
			 * Sort the selected shapes based on X-coordinate value
			 */
			private static final Comparator<Double> XValueComparator = (de1, de2) -> {
				return Double.compare(de1, de2);
			};

			// TODO store xSum to top? would remove need for bubbling up twice
			private class RelativeDiagramElement {
				final DiagramElement de;
				double x;

				private RelativeDiagramElement(final DiagramElement de) {
					this.de = de;
					this.x = getRelativeX(de);
				}

				private double getRelativeX(DiagramElement de) {
					double x = de.getX();
					while (de.getParent() instanceof DiagramElement) {
						de = (DiagramElement) de.getParent();
						x += de.getX();
					}

					return x;
				}

				private void setNewX(final double x) {
					this.x = x;
				}

				private void setRelative(final double newX) {
					double x = 0;
					DiagramElement de = this.de;
					while (de.getParent() instanceof DiagramElement) {
						de = (DiagramElement) de.getParent();
						x += de.getX();
					}

					this.x = newX + x;
				}
			}

			/**
			 * Sort the selected shapes based on X-coordinate value
			 */
			private static final Comparator<DiagramElement> XValueComparatorO = (de1, de2) -> Double.compare(de1.getX(),
					de2.getX());
}
