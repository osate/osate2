package org.osate.ge.internal.ui.handlers;

import java.util.Comparator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.Point;
import org.osate.ge.internal.ui.util.UiUtil;

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

		diagram.modify("Distribute Horizontally", m -> {
			selectedDiagramElements.sort(XValueComparator);

			// Distribute the shapes horizontally
			final int xDistribution = getXDistribution(selectedDiagramElements);
			for (int i = 1; i < selectedDiagramElements.size() - 1; i++) {
				final DiagramElement de = selectedDiagramElements.get(i);
				final int x = getXValue(selectedDiagramElements.get(i - 1), xDistribution);
				final int y = de.getY();

				m.setPosition(de, new Point(x, y));
			}
		});

		return null;
	}

	/**
	 * Calculate the width of all shapes, used for distribution calculations
	 * @param diagramElements the selected shapes
	 * @return the width of the middle shapes
	 */
	private static int getWidthOfShapes(final List<DiagramElement> diagramElements) {
		return (int) diagramElements.stream().mapToDouble(de -> de.getWidth()).sum();
	}

	/**
	 * Calculate the distance between each selected shape after distribution
	 * @param diagramElements the selected shapes
	 * @return the distance between each shape after distribution
	 */
	private static int getXDistribution(final List<DiagramElement> diagramElements) {
		final int lastIndex = diagramElements.size() - 1;
		final int widthOfShapes = getWidthOfShapes(diagramElements);
		final DiagramElement firstElement = diagramElements.get(0);
		final DiagramElement lastElement = diagramElements.get(lastIndex);
		return (lastElement.getX() + lastElement.getWidth() - firstElement.getX() - widthOfShapes) / lastIndex;
	}

	/**
	 * Calculate the X-coordinate value for the shape being evaluated
	 * @param prevElement the element of the shape just before the current element being evaluated
	 * @param xDistribution the X-coordinate distance that needs to be between each shape
	 * @return the X-coordinate value for the shape being evaluated
	 */
	private static int getXValue(final DiagramElement prevElement, final int xDistribution) {
		return prevElement.getX() + prevElement.getWidth() + xDistribution;
	}

	/**
	 * Sort the selected shapes based on X-coordinate value
	 */
	private static final Comparator<DiagramElement> XValueComparator = (de1, de2) -> Integer.valueOf(de1.getX())
			.compareTo(de2.getX());
}
