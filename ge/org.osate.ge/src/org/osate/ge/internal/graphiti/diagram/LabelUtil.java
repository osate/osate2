/*******************************************************************************
 * Copyright (C) 2015 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.ge.internal.graphiti.diagram;

import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.util.IColorConstant;
import org.osate.ge.internal.graphiti.TextUtil;

public class LabelUtil {
	public static Shape createLabelShape(final Diagram diagram, final ContainerShape container, final String shapeName,
			final String labelValue, final double fontSize) {
		return createLabelShape(diagram, container, shapeName, labelValue, true, fontSize);
	}

	private static Shape createLabelShape(final Diagram diagram, final ContainerShape container, final String shapeName,
			final String labelValue, final boolean includeBackground, final double fontSize) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final Shape labelShape = peCreateService.createShape(container, true);
		PropertyUtil.setName(labelShape, shapeName);
		PropertyUtil.setIsManuallyPositioned(labelShape, true);
		PropertyUtil.setIsTransient(labelShape, true);

		final GraphicsAlgorithm labelBackground;
		final Text labelText;
		if(includeBackground) {
			labelBackground = createTextBackground(diagram, labelShape);
			labelText = createLabelGraphicsAlgorithm(diagram, labelBackground, labelValue, fontSize);
		} else {
			labelBackground = null;
			labelText = createLabelGraphicsAlgorithm(diagram, labelShape, labelValue, fontSize);
		}

		// Get sizes of text graphics algorithms
		final IDimension labelTextSize = GraphitiUi.getUiLayoutService().calculateTextSize(labelText.getValue(), labelText.getFont());

		// Add padding to the text size to account for rounding issues in GEF3/Graphiti
		final int paddedLabelTextWidth = labelTextSize.getWidth() + Math.max(15, labelText.getValue().length());
		final int paddedLabelTextHeight = labelTextSize.getHeight() + 5;
		final IGaService gaService = Graphiti.getGaService();
		if(labelBackground != null) {
			gaService.setSize(labelBackground, paddedLabelTextWidth, paddedLabelTextHeight);
		}
		gaService.setSize(labelText, paddedLabelTextWidth, paddedLabelTextHeight);

		return labelShape;
	}

	private static GraphicsAlgorithm createTextBackground(final Diagram diagram, final GraphicsAlgorithmContainer container) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm background = gaService.createPlainRectangle(container);
		background.setBackground(gaService.manageColor(diagram, IColorConstant.WHITE));
		background.setLineVisible(false);
		background.setFilled(true);
		background.setTransparency(0.2);
		PropertyUtil.setIsColoringContainer(background, true);

		return background;
	}

	private static Text createLabelGraphicsAlgorithm(final Diagram diagram, final GraphicsAlgorithmContainer container, final String labelTxt, final double fontSize) {
		final IGaService gaService = Graphiti.getGaService();
		final Text text = gaService.createPlainText(container, labelTxt);
		TextUtil.setStyle(diagram, text, fontSize);
		PropertyUtil.setIsColoringChild(text, true);

		return text;
	}
}
