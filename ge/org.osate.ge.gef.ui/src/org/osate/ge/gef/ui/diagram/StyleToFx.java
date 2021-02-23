/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.gef.ui.diagram;

import java.util.Objects;

import org.eclipse.core.runtime.IPath;
import org.osate.ge.gef.FxStyle;
import org.osate.ge.gef.ImageManager;
import org.osate.ge.gef.ui.AgeGefRuntimeException;
import org.osate.ge.graphics.LabelPosition;
import org.osate.ge.graphics.LineStyle;
import org.osate.ge.graphics.Style;

import com.google.common.collect.ImmutableList;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Factory for creating a {@link FxStyle} instance from a {@link Style} instance.
 */
public class StyleToFx {
	private static ImmutableList<Double> dashedStrokeDashArray = ImmutableList.of(6.0, 2.0);
	private static ImmutableList<Double> dottedStrokeDashArray = ImmutableList.of(2.0, 2.0);

	private final ImageManager imageManager;

	/**
	 * Creates a new instance.
	 * @param imageManager the image manager to use when creating image references when converting styles.
	 */
	public StyleToFx(final ImageManager imageManager) {
		this.imageManager = Objects.requireNonNull(imageManager, "imageManager must not be null");
	}

	/**
	 * Creates an {@link FxStyle} instance from a {@link Style} instance.
	 * @param style the style for which to create an {@link FxStyle}.
	 * @return the Java FX implementation specific style.
	 */
	public FxStyle createStyle(final Style style) {
		if (!style.isComplete()) {
			throw new AgeGefRuntimeException("Specified style must be complete");
		}

		final IPath imagePath = style.getShowAsImage() ? style.getImagePath() : null;

		final double fontSizeInPoints = style.getFontSize() * 96.0 / 72.0; // Convert from pixels to points
		return new FxStyle.Builder().backgroundColor(convert(style.getBackgroundColor()))
				.outlineColor(convert(style.getOutlineColor())).fontColor(convert(style.getFontColor()))
				.font(Font.font("Arial", FontWeight.NORMAL, fontSizeInPoints))
				.strokeDashArray(getStrokeDashArray(style.getLineStyle())).lineWidth(style.getLineWidth())
				.horizontalLabelPosition(convert(style.getHorizontalLabelPosition()))
				.verticalLabelPosition(convert(style.getVerticalLabelPosition()))
				.primaryLabelsVisible(style.getPrimaryLabelVisible())
				.image(imagePath == null ? null : imageManager.getImageReference(imagePath.toFile().toPath())).build();
	}

	private static ImmutableList<Double> getStrokeDashArray(final LineStyle lineStyle) {
		switch (lineStyle) {
		case DASHED:
			return dashedStrokeDashArray;

		case DOTTED:
			return dottedStrokeDashArray;

		case SOLID:
		default:
			return ImmutableList.of();
		}
	}

	private static org.osate.ge.gef.LabelPosition convert(final LabelPosition value) {
		switch (value) {
		case BEFORE_GRAPHIC:
			// The output type doesn't have a matching value. Use beginning.
			return org.osate.ge.gef.LabelPosition.BEGINNING;
		case GRAPHIC_BEGINNING:
			return org.osate.ge.gef.LabelPosition.BEGINNING;
		case GRAPHIC_CENTER:
			return org.osate.ge.gef.LabelPosition.CENTER;
		case GRAPHIC_END:
			return org.osate.ge.gef.LabelPosition.END;
		case AFTER_GRAPHIC:
			// The output type doesn't have a matching value. Use end.
			return org.osate.ge.gef.LabelPosition.END;
		default:
			throw new IllegalArgumentException("Unexpected value: " + value);
		}
	}

	private static Color convert(final org.osate.ge.graphics.Color color) {
		return Color.rgb(color.getRed(), color.getGreen(), color.getBlue());
	}
}
