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
package org.osate.ge.graphics;

import org.eclipse.core.runtime.IPath;

public class StyleBuilder {
	private Color background;
	private IPath image;
	private Boolean showAsImage;
	private Color outline;
	private Color fontColor;
	private Double fontSize;
	private Double lineWidth;
	private LineStyle lineStyle;
	private LabelPosition horizontalLabelPosition;
	private LabelPosition verticalLabelPosition;
	private Boolean primaryLabelVisible;

	private StyleBuilder() {}

	public static StyleBuilder create() {
		return new StyleBuilder();
	}

	/**
	 * Returns a style builder initialized by the specified styles. Styles specified earlier override later styles. Null values are ignored.
	 * @param styles
	 * @return
	 */
	public static StyleBuilder create(final Style... styles) {
		final StyleBuilder sb = new StyleBuilder();

		for (int i = styles.length - 1; i >= 0; i--) {
			final Style s = styles[i];
			if(s.getBackgroundColor() != null) {
				sb.backgroundColor(s.getBackgroundColor());
			}

			if(s.getOutlineColor() != null) {
				sb.outlineColor(s.getOutlineColor());
			}

			if(s.getFontColor() != null) {
				sb.fontColor(s.getFontColor());
			}

			if(s.getFontSize() != null) {
				sb.fontSize(s.getFontSize());
			}

			if(s.getLineWidth() != null) {
				sb.lineWidth(s.getLineWidth());
			}

			if(s.getLineStyle() != null) {
				sb.lineStyle(s.getLineStyle());
			}

			if (s.getHorizontalLabelPosition() != null) {
				sb.labelsHorizontalPosition(s.getHorizontalLabelPosition());
			}

			if (s.getVerticalLabelPosition() != null) {
				sb.labelsVerticalPosition(s.getVerticalLabelPosition());
			}

			if (s.getPrimaryLabelVisible() != null) {
				sb.primaryLabelVisible(s.getPrimaryLabelVisible());
			}

			if(s.getShowAsImage() != null) {
				sb.showAsImage(s.getShowAsImage());
			}

			if (s.getImagePath() != null) {
				sb.imagePath(s.getImagePath());
			}
		}

		return sb;
	}

	public StyleBuilder backgroundColor(final Color background) {
		this.background = background;
		return this;
	}

	public StyleBuilder showAsImage(final Boolean showAsImage) {
		this.showAsImage = showAsImage;
		return this;
	}

	public StyleBuilder imagePath(final IPath image) {
		this.image = image;
		return this;
	}

	// Sets both the font and outline colors
	public StyleBuilder foregroundColor(final Color value) {
		return outlineColor(value).fontColor(value);
	}

	public StyleBuilder outlineColor(final Color outline) {
		this.outline = outline;
		return this;
	}

	public StyleBuilder fontColor(final Color fontColor) {
		this.fontColor = fontColor;
		return this;
	}

	public StyleBuilder fontSize(final Double fontSize) {
		this.fontSize = fontSize;
		return this;
	}

	public StyleBuilder lineWidth(final Double lineWidth) {
		this.lineWidth = lineWidth;
		return this;
	}

	/**
	 * Configures the style builder to create a dashed lines.
	 * @return this builder to allow method chaining.
	 */
	public StyleBuilder dashed() {
		this.lineStyle = LineStyle.DASHED;
		return this;
	}

	/**
	 * Configures the style builder to create a dotted lines.
	 * @return this builder to allow method chaining.
	 */
	public StyleBuilder dotted() {
		this.lineStyle = LineStyle.DOTTED;
		return this;
	}

	/**
	 * @since 1.1
	 */
	public StyleBuilder lineStyle(final LineStyle lineStyle) {
		this.lineStyle = lineStyle;
		return this;
	}

	public StyleBuilder labelsHorizontalPosition(final LabelPosition value) {
		this.horizontalLabelPosition = value;
		return this;
	}

	public StyleBuilder labelsVerticalPosition(final LabelPosition value) {
		this.verticalLabelPosition = value;
		return this;
	}

	public StyleBuilder primaryLabelVisible(final Boolean value) {
		this.primaryLabelVisible = value;
		return this;
	}

	/**
	 * Configures labels to be left aligned.
	 * @return this builder to allow method chaining.
	 */
	public StyleBuilder labelsLeft() {
		this.horizontalLabelPosition = LabelPosition.GRAPHIC_BEGINNING;
		return this;
	}

	/**
	 * Configures labels to be centered horizontally.
	 * @return this builder to allow method chaining.
	 */
	public StyleBuilder labelsHorizontalCenter() {
		this.horizontalLabelPosition = LabelPosition.GRAPHIC_CENTER;
		return this;
	}

	/**
	 * Configures labels to be right aligned.
	 * @return this builder to allow method chaining.
	 */
	public StyleBuilder labelsRight() {
		this.horizontalLabelPosition = LabelPosition.GRAPHIC_END;
		return this;
	}

	/**
	 * Configures labels to be positioned above the top of the graphic. Only supported for docked shapes.
	 * @return this builder to allow method chaining.
	 */
	public StyleBuilder labelsAboveTop() {
		this.verticalLabelPosition = LabelPosition.BEFORE_GRAPHIC;
		return this;
	}

	/**
	 * Configures labels to be top aligned.
	 * @return this builder to allow method chaining.
	 */
	public StyleBuilder labelsTop() {
		this.verticalLabelPosition = LabelPosition.GRAPHIC_BEGINNING;
		return this;
	}

	/**
	 * Configures labels to be centered vertically.
	 * @return this builder to allow method chaining.
	 */
	public StyleBuilder labelsVerticalCenter() {
		this.verticalLabelPosition = LabelPosition.GRAPHIC_CENTER;
		return this;
	}

	/**
	 * Configures labels to be bottom aligned.
	 * @return this builder to allow method chaining.
	 */
	public StyleBuilder labelsBottom() {
		this.verticalLabelPosition = LabelPosition.GRAPHIC_END;
		return this;
	}

	/**
	 * Configures labels to be centered horizontally and vertically
	 * @return this builder to allow method chaining.
	 */
	public StyleBuilder labelsCenter() {
		this.horizontalLabelPosition = LabelPosition.GRAPHIC_CENTER;
		this.verticalLabelPosition = LabelPosition.GRAPHIC_CENTER;
		return this;
	}

	public Style build() {
		return new Style(background, fontColor, outline, fontSize, showAsImage, image, lineWidth, lineStyle,
				horizontalLabelPosition,
				verticalLabelPosition, primaryLabelVisible);
	}
}
