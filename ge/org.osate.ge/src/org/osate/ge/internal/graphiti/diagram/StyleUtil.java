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
package org.osate.ge.internal.graphiti.diagram;

import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.internal.AgeShape;
import org.osate.ge.graphics.internal.Label;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.styling.StyleProvider;
import org.osate.ge.internal.graphiti.ShapeNames;

class StyleUtil {
	// All items are static
	private StyleUtil() {
	}

	public static void refreshStyle(final Diagram graphitiDiagram, final PictogramElement pe,
			final DiagramElement element, final StyleProvider finalStyleProvider,
			final NodePictogramBiMap mapping) {
		final Style finalStyle = finalStyleProvider.getStyle(element);
		final org.osate.ge.graphics.Color finalOutline = finalStyle.getOutlineColor();
		final org.osate.ge.graphics.Color finalBackground = finalStyle.getBackgroundColor();
		final org.osate.ge.graphics.Color finalFontColor = finalStyle.getFontColor();

		final Color foreground = Graphiti.getGaService().manageColor(graphitiDiagram, finalOutline.getRed(),
				finalOutline.getGreen(), finalOutline.getBlue());
		final Color background = Graphiti.getGaService().manageColor(graphitiDiagram, finalBackground.getRed(),
				finalBackground.getGreen(), finalBackground.getBlue());
		final Color fontColor = Graphiti.getGaService().manageColor(graphitiDiagram, finalFontColor.getRed(),
				finalFontColor.getGreen(), finalFontColor.getBlue());

		// Background color is not supported for label diagram elements. Get the first containing diagram element that is represented by a shape
		final DiagramElement labelContainerShape = element.getGraphic() instanceof Label
				? getContainingUndockedShapeDiagramElement(element)
						: element;

				Color labelBackground = background;
				if (labelContainerShape != null) {
					final boolean labelsAreOutside = finalStyle.getHorizontalLabelPosition().isOutside()
							|| finalStyle.getVerticalLabelPosition().isOutside();

					// Get the diagram element which is behind the label.
					final DiagramElement labelBackgroundDiagramElement = labelsAreOutside
							? getContainingUndockedShapeDiagramElement(labelContainerShape)
									: labelContainerShape;

							if (labelBackgroundDiagramElement != null) {
								final org.osate.ge.graphics.Color geLabelBackground = finalStyleProvider
										.getStyle(labelBackgroundDiagramElement).getBackgroundColor();
								labelBackground = Graphiti.getGaService().manageColor(graphitiDiagram, geLabelBackground.getRed(),
										geLabelBackground.getGreen(), geLabelBackground.getBlue());
							}
				}

				overrideStyle(pe, background, foreground, labelBackground, fontColor,
						(int) Math.round(finalStyle.getLineWidth()), element.getGraphic() instanceof Label);
	}

	private static DiagramElement getContainingUndockedShapeDiagramElement(final DiagramElement de) {
		for (DiagramNode tmp = de.getParent(); tmp instanceof DiagramElement; tmp = tmp.getParent()) {
			final DiagramElement tmpElement = (DiagramElement) tmp;
			if (tmpElement.getGraphic() instanceof AgeShape && tmpElement.getDockArea() == null) {
				return tmpElement;
			}
		}

		return null;
	}

	private static void overrideStyle(final PictogramElement pe,
			final org.eclipse.graphiti.mm.algorithms.styles.Color background,
			final org.eclipse.graphiti.mm.algorithms.styles.Color outline,
			final org.eclipse.graphiti.mm.algorithms.styles.Color labelBackground,
			final org.eclipse.graphiti.mm.algorithms.styles.Color fontColor, final int lineWidth,
			final boolean inLabel) {
		if (pe.getGraphicsAlgorithm() != null) {
			final org.eclipse.graphiti.mm.algorithms.styles.Color childBackground = inLabel ? labelBackground
					: background;

			overrideStyle(pe.getGraphicsAlgorithm(), childBackground, outline, fontColor, lineWidth);
		}

		// Handle coloring containers
		if (pe instanceof ContainerShape) {
			for (final Shape childShape : ((ContainerShape) pe).getChildren()) {
				// Only update child shapes which are transient. Transient shapes are typically and inherent part of the shape rather than being an independent
				// object.
				if (inLabel || isPrimaryLabelOrAnnotation(childShape)) {
					overrideStyle(childShape, background, outline, labelBackground, fontColor, lineWidth, true);
				}
			}
		} else if (pe instanceof Connection) {
			// Color connection decorators
			for (final ConnectionDecorator cd : ((Connection) pe).getConnectionDecorators()) {
				if (inLabel || isPrimaryLabelOrAnnotation(cd) || PropertyUtil.isStylingContainer(cd)) {
					overrideStyle(cd, background, outline, labelBackground, fontColor, lineWidth, true);
				}
			}
		}
	}

	private static boolean isPrimaryLabelOrAnnotation(final PictogramElement pe) {
		final String name = PropertyUtil.getName(pe);
		return ShapeNames.primaryLabelShapeName.equals(name) || ShapeNames.annotationShapeName.equals(name);
	}

	private static void overrideStyle(final GraphicsAlgorithm ga,
			final org.eclipse.graphiti.mm.algorithms.styles.Color background,
			final org.eclipse.graphiti.mm.algorithms.styles.Color outline,
			final org.eclipse.graphiti.mm.algorithms.styles.Color fontColor, final int lineWidth) {
		final boolean isStylingContainer = PropertyUtil.isStylingContainer(ga);
		final boolean isStylingChild = PropertyUtil.isStylingChild(ga);
		final boolean isStylingOutlineEnabled = PropertyUtil.isStylingOutlineEnabled(ga);

		if (isStylingOutlineEnabled) {
			if (ga.getForeground() != null && !(ga instanceof AbstractText)) {
				if (outline != null) {
					ga.setForeground(outline);
				}
			}
		}

		if (isStylingChild) {
			if (ga.getForeground() != null) {
				if (ga instanceof AbstractText) {
					ga.setForeground(fontColor);
				}
			}

			// Also set background of label
			if (ga.getBackground() != null) {
				ga.setBackground(background);
			}

			if (ga.getLineWidth() != null) {
				ga.setLineWidth(lineWidth);
			}
		}

		if (isStylingContainer) {
			for (final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
				overrideStyle(childGa, background, outline, fontColor, lineWidth);
			}
		}
	}
}
