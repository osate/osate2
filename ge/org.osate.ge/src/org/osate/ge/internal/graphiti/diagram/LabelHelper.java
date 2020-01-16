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

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.xtext.util.Strings;

public class LabelHelper {
	private final Map<Integer, Font> sizeToWrappingFontMap = new HashMap<>();
	private final FontRenderContext fontRenderContext = new FontRenderContext(new AffineTransform(), true, false);

	public Shape createLabelShape(final Diagram diagram, final ContainerShape container, final String shapeName,
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
		final AbstractText labelText;
		if(includeBackground) {
			labelBackground = createTextBackground(diagram, labelShape);
			labelText = createLabelGraphicsAlgorithm(diagram, labelBackground, labelValue, fontSize);
		} else {
			labelBackground = null;
			labelText = createLabelGraphicsAlgorithm(diagram, labelShape, labelValue, fontSize);
		}

		final IGaService gaService = Graphiti.getGaService();
		if(labelBackground != null) {
			gaService.setSize(labelBackground, labelText.getWidth(), labelText.getHeight());
		}

		return labelShape;
	}

	/**
	 * Creates a shape and graphical algorithm for wrapping labels. Wrapping labels are multiline labels.
	 */
	public Shape createWrappingLabelShape(final Diagram diagram, final ContainerShape container,
			final String shapeName, final String labelValue, final double fontSize,
			final int width, final int innerPaddingX) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final Shape labelShape = peCreateService.createShape(container, true);
		PropertyUtil.setName(labelShape, shapeName);
		PropertyUtil.setIsManuallyPositioned(labelShape, true);
		PropertyUtil.setIsTransient(labelShape, true);

		// The "background" is a containing graphics algorithm with a width of the requested size. Having a separate
		// graphics algorithm allows customizing the width of the text label without requiring adjustments to the size
		// of the overall label shape. This allows the addition of padding to the label.
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm background = gaService.createPlainRectangle(labelShape);
		background.setLineVisible(false);
		background.setFilled(false);
		PropertyUtil.setIsStylingContainer(background, true);

		background.setWidth(width);

		final int textWidth = width - innerPaddingX;
		if (textWidth <= 0) {
			throw new RuntimeException("Invalid text width. Width and/or inner padding X is invalid");
		}

		final AbstractText label = createWrappingLabelGraphicsAlgorithm(diagram, background, labelValue, fontSize,
				textWidth);

		// Update background height based on the label height
		background.setHeight(label.getHeight());

		return labelShape;
	}

	private static GraphicsAlgorithm createTextBackground(final Diagram diagram, final GraphicsAlgorithmContainer container) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm background = gaService.createPlainRectangle(container);
		background.setBackground(gaService.manageColor(diagram, IColorConstant.WHITE));
		background.setLineVisible(false);
		background.setFilled(true);
		background.setTransparency(0.2);
		PropertyUtil.setIsStylingContainer(background, true);
		PropertyUtil.setIsStylingChild(background, true);

		return background;
	}

	private static AbstractText createLabelGraphicsAlgorithm(final Diagram diagram,
			final GraphicsAlgorithmContainer container, final String labelTxt, final double fontSize) {
		final IGaService gaService = Graphiti.getGaService();
		final AbstractText text = gaService.createPlainText(container, labelTxt);
		TextUtil.setStyleAndSize(diagram, text, fontSize);
		PropertyUtil.setIsStylingChild(text, true);

		return text;
	}

	private AbstractText createWrappingLabelGraphicsAlgorithm(final Diagram diagram,
			final GraphicsAlgorithmContainer container, String labelTxt, final double fontSize,
			final int width) {
		final IGaService gaService = Graphiti.getGaService();
		final AbstractText text = gaService.createPlainMultiText(container, labelTxt);
		TextUtil.setStyle(diagram, text, fontSize);
		PropertyUtil.setIsStylingChild(text, true);

		// Override styling fields specific to wrapping labels
		text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		text.setVerticalAlignment(Orientation.ALIGNMENT_TOP);

		setWrappingLabelSize(text, labelTxt, fontSize, width);

		return text;
	}

	private Font getWrappingFont(final double fontSize) {
		// Get the font to use for determining the size of wrapping test.
		// AWT uses a DPI of 72. Scale based on a DPI of 96.0.
		final int fontSizeInPoints = (int) Math.ceil(fontSize * 96.0 / 72.0);
		return sizeToWrappingFontMap.computeIfAbsent(fontSizeInPoints, s -> new Font("Arial", Font.BOLD, s));
	}

	private void setWrappingLabelSize(final AbstractText text, String labelTxt, final double fontSize,
			final int width) {
		text.setWidth(width);

		// Use a smaller width as the wrapping with to handle error in determining how many lines will actually be rendered.
		final int wrapWidth = Math.max(width - 10, 1);

		// Don't allow empty labels
		if (Strings.isEmpty(labelTxt)) {
			labelTxt = "  ";
		}

		// Determine height
		final Font font = getWrappingFont(fontSize);
		final AttributedString attributedText = new AttributedString(labelTxt);
		attributedText.addAttribute(TextAttribute.FONT, font);

		final AttributedCharacterIterator textIt = attributedText.getIterator();
		final LineBreakMeasurer measurer = new LineBreakMeasurer(textIt, fontRenderContext);

		double totalHeight = 3; // Initialized to non-zero to handle padding introduced when rendering.
		while (measurer.getPosition() < textIt.getEndIndex()) {
			// Determine the position of the next new line and use it as a limit because LineBreakMeasurer does not handle new lines
			final int nextNewLine = labelTxt.indexOf('\n', measurer.getPosition() + 1);
			final int limit = nextNewLine == -1 ? labelTxt.length() : nextNewLine;

			final TextLayout layout = measurer.nextLayout(wrapWidth, limit, false);
			totalHeight += Math.ceil(layout.getAscent() + layout.getDescent() + layout.getLeading());
		}
		text.setHeight((int) Math.ceil(totalHeight));
	}
}