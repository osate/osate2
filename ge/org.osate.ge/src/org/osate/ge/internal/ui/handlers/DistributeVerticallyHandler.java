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

import java.util.Comparator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.ui.util.UiUtil;

public class DistributeVerticallyHandler extends AbstractHandler {

	/**
	 * Distributes shapes along the Y axis so each shape has an equal distance between them
	 */
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		diagram.modify("Distribute Vertically", m -> {
			selectedDiagramElements.sort(YValueComparator);

			// Distribute the shapes horizontally
			final double yDistribution = getYDistribution(selectedDiagramElements);
			for (int i = 1; i < selectedDiagramElements.size() - 1; i++) {
				final DiagramElement de = selectedDiagramElements.get(i);
				final double x = de.getX();
				final double y = getYValue(selectedDiagramElements.get(i - 1), yDistribution);

				DiagramElementLayoutUtil.moveElement(m, de, new Point(x, y));
			}
		});

		return null;
	}

	/**
	 * Calculate the height of the all shapes, used for distribution calculations
	 * @param shapes the selected shapes
	 * @return the height of the middle shapes
	 */
	private static double getHeightOfShapes(final List<DiagramElement> diagramElements) {
		return diagramElements.stream().mapToDouble(de -> de.getHeight()).sum();
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

	/**
	 * Calculate the distance between each selected shape after distribution
	 * @param shapes the selected shapes
	 * @return the distance between each shape after distribution
	 */
	private static double getYDistribution(final List<DiagramElement> diagramElements) {
		final int lastIndex = diagramElements.size() - 1;
		final double heightOfShapes = getHeightOfShapes(diagramElements);
		final DiagramElement firstElement = diagramElements.get(0);
		final DiagramElement lastElement = diagramElements.get(lastIndex);
		return (lastElement.getY() + lastElement.getHeight() - firstElement.getY() - heightOfShapes) / lastIndex;
	}

	/**
	 * Sort the selected shapes based on Y-coordinate value
	 */
	private static final Comparator<DiagramElement> YValueComparator = (de1, de2) -> Double.compare(de1.getY(),
			de2.getY());
}
