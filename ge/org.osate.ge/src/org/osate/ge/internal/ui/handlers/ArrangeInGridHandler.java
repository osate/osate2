package org.osate.ge.internal.ui.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.ui.util.UiUtil;

public class ArrangeInGridHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		diagram.modify("Arrange in Grid", m -> {
			// Calculate and sets the selected diagram elements into a grid layout.
			final int padding = 25;

			final int numOfCols = (int)Math.ceil(Math.sqrt(selectedDiagramElements.size()));
			final int numOfRows = (int)Math.ceil(selectedDiagramElements.size()/(double)numOfCols);

			final double[] colSizes = new double[numOfCols - 1];
			final double[] rowSizes = new double[numOfRows - 1];

			// Assign column and row width for grid
			for(int i1 = 0 ; i1 < selectedDiagramElements.size() ; i1++) {
				final DiagramElement de = selectedDiagramElements.get(i1);
				int col = i1 % numOfCols;
				int row = i1 / numOfCols;

				if(col < colSizes.length) {
					colSizes[col] = Math.max(colSizes[col], de.getWidth() + padding);
				}

				if(row < rowSizes.length) {
					rowSizes[row] = Math.max(rowSizes[row], de.getHeight() + padding);
				}
			}

			// Calculate grid position and place first shape
			final Point gridPosition = getGridPosition(selectedDiagramElements);
			double x = gridPosition.x;
			double y = gridPosition.y;

			// Position the elements
			m.setPosition(selectedDiagramElements.get(0), new Point(x, y));

			// Place the rest of the shapes
			for(int i2 = 1 ; i2 < selectedDiagramElements.size(); i2++) {
				if(i2 % numOfCols == 0) {
					x = gridPosition.x;
					if(rowSizes.length != 0) {
						y += rowSizes[i2 / numOfCols - 1];
					}
				} else {
					x += colSizes[i2 % numOfCols - 1];
				}

				m.setPosition(selectedDiagramElements.get(i2), new Point(x,y));
			}
		});

		return null;
	}

	/**
	 * Get grid placement coordinate
	 */
	private static Point getGridPosition(final List<DiagramElement> diagramElements) {
		double xMin = Double.MAX_VALUE, yMin = Double.MAX_VALUE;

		// Get min values for x and y axis.
		for (final DiagramElement e : diagramElements) {
			final double x = e.getX();
			final double y = e.getY();

			if (x < xMin) {
				xMin = x;
			}

			if (y < yMin) {
				yMin = y;
			}
		}

		return new Point(xMin, yMin);
	}
}
