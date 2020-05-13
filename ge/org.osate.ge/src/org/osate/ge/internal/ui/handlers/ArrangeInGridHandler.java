/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.ui.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
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
			DiagramElementLayoutUtil.moveElement(m, selectedDiagramElements.get(0), new Point(x, y));

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

				DiagramElementLayoutUtil.moveElement(m, selectedDiagramElements.get(i2), new Point(x, y));
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
