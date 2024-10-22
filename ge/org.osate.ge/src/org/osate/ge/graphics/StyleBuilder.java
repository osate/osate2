/**
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file).
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

/**
 * Builder for the {@link Style} class.
 * @since 2.0
 * @see Style
 */
public final class StyleBuilder {
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

	/**
	 * Private constructor to prevent direct instantiation.
	 * @see #create()
	 */
	private StyleBuilder() {
	}

	/**
	 * Creates a new instance of the builder.
	 * @return a new builder
	 */
	public static StyleBuilder create() {
		return new StyleBuilder();
	}

	/**
	 * Create a new instance configured using specified styles. The first non-null value for each field is used to configure the builder.
	 * In other words, styles specified earlier override later styles. Null styles or null values within a style are ignored.
	 * @param styles the styles to use to configure the instance
	 * @return the new builder
	 */
	public static StyleBuilder create(final Style... styles) {
		final StyleBuilder sb = new StyleBuilder();

		for (int i = styles.length - 1; i >= 0; i--) {
			final Style s = styles[i];
			if (s == null) {
				continue;
			}

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

	/**
	 * Configures the builder to build an instance with the specified background color.
	 * @param value the background color
	 * @return this builder to allow method chaining.
	 * @see Style#getBackgroundColor()
	 */
	public StyleBuilder backgroundColor(final Color value) {
		this.background = value;
		return this;
	}

	/**
	 * Configures the builder to build an instance with the specified show as image value.
	 * @param value the value for the show as image field
	 * @return this builder to allow method chaining.
	 * @see Style#getShowAsImage()
	 */
	public StyleBuilder showAsImage(final Boolean value) {
		this.showAsImage = value;
		return this;
	}

	/**
	 * Configures the builder to build an instance with the specified image path.
	 * @param value the image path
	 * @return this builder to allow method chaining.
	 * @see Style#getImagePath()
	 */
	public StyleBuilder imagePath(final IPath value) {
		this.image = value;
		return this;
	}

	/**
	 * Configures the builder to build an instance with the specified outline and font color.
	 * @param value the outline and font color.
	 * @return this builder to allow method chaining.
	 * @see #outlineColor(Color)
	 * @see #fontColor(Color)
	 * @see Style#getOutlineColor()
	 * @see Style#getFontColor()
	 */
	public StyleBuilder foregroundColor(final Color value) {
		return outlineColor(value).fontColor(value);
	}

	/**
	 * Configures the builder to build an instance with the specified outline color.
	 * @param value the outline color
	 * @return this builder to allow method chaining.
	 * @see Style#getOutlineColor()
	 */
	public StyleBuilder outlineColor(final Color value) {
		this.outline = value;
		return this;
	}

	/**
	 * Configures the builder to build an instance with the specified font color.
	 * @param value the font color
	 * @return this builder to allow method chaining.
	 * @see Style#getFontColor()
	 */
	public StyleBuilder fontColor(final Color value) {
		this.fontColor = value;
		return this;
	}

	/**
	 * Configures the builder to build an instance with the specified font size.
	 * @param value the font size
	 * @return this builder to allow method chaining.
	 * @see Style#getFontSize()
	 */
	public StyleBuilder fontSize(final Double value) {
		this.fontSize = value;
		return this;
	}

	/**
	 * Configures the builder to build an instance with the specified line width.
	 * @param value the line width
	 * @return this builder to allow method chaining.
	 * @see Style#getLineWidth()
	 */
	public StyleBuilder lineWidth(final Double value) {
		this.lineWidth = value;
		return this;
	}

	/**
	 * Configures the style builder to create a dashed lines.
	 * @return this builder to allow method chaining.
	 * @see LineStyle
	 * @see Style#getLineStyle()
	 */
	public StyleBuilder dashed() {
		this.lineStyle = LineStyle.DASHED;
		return this;
	}

	/**
	 * Configures the style builder to create a dotted lines.
	 * @return this builder to allow method chaining.
	 * @see LineStyle
	 * @see Style#getLineStyle()
	 */
	public StyleBuilder dotted() {
		this.lineStyle = LineStyle.DOTTED;
		return this;
	}

	/**
	 * Configures the builder to build an instance with the specified line style.
	 * @param value the line style
	 * @return this builder to allow method chaining.
	 * @since 1.1
	 */
	public StyleBuilder lineStyle(final LineStyle value) {
		this.lineStyle = value;
		return this;
	}

	/**
	 * Configures the builder to build an instance with the specified horizontal label position.
	 * @param value the horizontal label position
	 * @return this builder to allow method chaining.
	 * @see Style#getHorizontalLabelPosition()
	 */
	public StyleBuilder labelsHorizontalPosition(final LabelPosition value) {
		this.horizontalLabelPosition = value;
		return this;
	}

	/**
	 * Configures the builder to build an instance with the specified vertical label position
	 * @param value the vertical label position
	 * @return this builder to allow method chaining.
	 * @see Style#getVerticalLabelPosition()
	 */
	public StyleBuilder labelsVerticalPosition(final LabelPosition value) {
		this.verticalLabelPosition = value;
		return this;
	}

	/**
	 * Configures the builder to build an instance with the specified primary label visible value
	 * @param value the value for the primary label visible field
	 * @return this builder to allow method chaining.
	 * @see Style#getPrimaryLabelVisible()
	 */
	public StyleBuilder primaryLabelVisible(final Boolean value) {
		this.primaryLabelVisible = value;
		return this;
	}

	/**
	 * Configures labels to be left aligned.
	 * @return this builder to allow method chaining.
	 * @see #labelsHorizontalPosition(LabelPosition)
	 * @see Style#getHorizontalLabelPosition()
	 */
	public StyleBuilder labelsLeft() {
		this.horizontalLabelPosition = LabelPosition.GRAPHIC_BEGINNING;
		return this;
	}

	/**
	 * Configures labels to be centered horizontally.
	 * @return this builder to allow method chaining.
	 * @see #labelsHorizontalPosition(LabelPosition)
	 * @see Style#getHorizontalLabelPosition()
	 */
	public StyleBuilder labelsHorizontalCenter() {
		this.horizontalLabelPosition = LabelPosition.GRAPHIC_CENTER;
		return this;
	}

	/**
	 * Configures labels to be right aligned.
	 * @return this builder to allow method chaining.
	 * @see #labelsHorizontalPosition(LabelPosition)
	 * @see Style#getHorizontalLabelPosition()
	 */
	public StyleBuilder labelsRight() {
		this.horizontalLabelPosition = LabelPosition.GRAPHIC_END;
		return this;
	}

	/**
	 * Configures labels to be positioned above the top of the graphic. Only supported for docked shapes.
	 * @return this builder to allow method chaining.
	 * @see #labelsVerticalPosition(LabelPosition)
	 * @see Style#getVerticalLabelPosition()
	 */
	public StyleBuilder labelsAboveTop() {
		this.verticalLabelPosition = LabelPosition.BEFORE_GRAPHIC;
		return this;
	}

	/**
	 * Configures labels to be top aligned.
	 * @return this builder to allow method chaining.
	 * @see #labelsVerticalPosition(LabelPosition)
	 * @see Style#getVerticalLabelPosition()
	 */
	public StyleBuilder labelsTop() {
		this.verticalLabelPosition = LabelPosition.GRAPHIC_BEGINNING;
		return this;
	}

	/**
	 * Configures labels to be centered vertically.
	 * @return this builder to allow method chaining.
	 * @see #labelsVerticalPosition(LabelPosition)
	 * @see Style#getVerticalLabelPosition()
	 */
	public StyleBuilder labelsVerticalCenter() {
		this.verticalLabelPosition = LabelPosition.GRAPHIC_CENTER;
		return this;
	}

	/**
	 * Configures labels to be bottom aligned.
	 * @return this builder to allow method chaining.
	 * @see #labelsVerticalPosition(LabelPosition)
	 * @see Style#getVerticalLabelPosition()
	 */
	public StyleBuilder labelsBottom() {
		this.verticalLabelPosition = LabelPosition.GRAPHIC_END;
		return this;
	}

	/**
	 * Configures labels to be centered horizontally and vertically
	 * @return this builder to allow method chaining.
	 * @see #labelsHorizontalCenter()
	 * @see #labelsVerticalCenter()
	 */
	public StyleBuilder labelsCenter() {
		this.horizontalLabelPosition = LabelPosition.GRAPHIC_CENTER;
		this.verticalLabelPosition = LabelPosition.GRAPHIC_CENTER;
		return this;
	}

	/**
	 * Creates a new style with the configured values.
	 * @return a new style with the configured values.
	 */
	public Style build() {
		return new Style(background, fontColor, outline, fontSize, showAsImage, image, lineWidth, lineStyle,
				horizontalLabelPosition,
				verticalLabelPosition, primaryLabelVisible);
	}
}
