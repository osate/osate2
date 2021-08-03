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
package org.osate.ge.graphics;

import java.util.Objects;

import org.eclipse.core.runtime.IPath;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;

/**
 * Immutable data type containing members which controls the appearance of the diagram element's graphic and labels.
 *
 * Styles may be partially specified. If a style has one or more required fields with null values, it is considered incomplete.
 * The graphical editor will calculate a final style which is complete before the style is applied. Because the default style
 * can change between versions of the graphical editor, it is recommended to only specify style values that are necessary
 * when implementing a {@link BusinessObjectHandler}
 *
 * @see StyleBuilder
 */
public class Style {
	/**
	 * A style instance which does not have any members set.
	 */
	public static final Style EMPTY = StyleBuilder.create().build();

	/**
	 * Style containing default values. When determining the final styles, values in this style will be used when another value
	 * is not specified.
	 */
	public static final Style DEFAULT = StyleBuilder.create().backgroundColor(Color.WHITE).foregroundColor(Color.BLACK)
			.fontSize(10.0).lineWidth(1.0).showAsImage(false)
			.lineStyle(LineStyle.SOLID).labelsHorizontalPosition(LabelPosition.GRAPHIC_BEGINNING)
			.primaryLabelVisible(true)
			.labelsVerticalPosition(LabelPosition.GRAPHIC_BEGINNING).build();

	private final Color background;
	private final Color fontColor;
	private final Color outline;
	private final Double fontSize;
	private final Double lineWidth;
	private final IPath image;
	private final Boolean showAsImage; // If this is true, then image must not be null.
	private final LineStyle lineStyle;
	private final LabelPosition horizontalLabelPosition;
	private final LabelPosition verticalLabelPosition;
	private final Boolean primaryLabelVisible;

	/**
	 * Creates a new instance. {@link StyleBuilder} should be used to create styles.
	 * @param background the value of the background color field
	 * @param fontColor the value of the font color field
	 * @param outline the value of the outline color field
	 * @param fontSize the value of the font size field
	 * @param showAsImage whether to show the diagram element as an image. If true, then the image field must be non-null.
	 * @param image the path to the image to use when show as image is true.
	 * @param lineWidth the value of the line width field.
	 * @param lineStyle the value of the line style field
	 * @param horizontalLabelPosition the values of the horizontal label position field
	 * @param verticalLabelPosition the value of the vertical label position field
	 * @param primaryLabelVisible the value of the primary label visible field.
	 * @throws IllegalArgumentException if showAsImage is true and image is null.
	 * @see StyleBuilder
	 **/
	Style(final Color background, final Color fontColor, final Color outline, final Double fontSize,
			final Boolean showAsImage, final IPath image,
			final Double lineWidth, final LineStyle lineStyle, final LabelPosition horizontalLabelPosition,
			final LabelPosition verticalLabelPosition, final Boolean primaryLabelVisible) {
		this.background = background;
		this.fontColor = fontColor;
		this.outline = outline;
		this.fontSize = fontSize;
		this.showAsImage = showAsImage;
		this.image = image;
		this.lineWidth = lineWidth;
		this.lineStyle = lineStyle;
		this.horizontalLabelPosition = horizontalLabelPosition;
		this.verticalLabelPosition = verticalLabelPosition;
		this.primaryLabelVisible = primaryLabelVisible;

		if (Objects.equals(showAsImage, Boolean.TRUE) && image == null) {
			throw new IllegalArgumentException("showAsImage must be false if image is not set.");
		}
	}

	/**
	 * Returns whether all of the style's required fields are non-null.
	 * @return whether all the style's required fields are non-null.
	 * @since 3.0
	 */
	public boolean isComplete() {
		return background != null && fontColor != null && outline != null && fontSize != null && lineWidth != null
				&& showAsImage != null && lineStyle != null
				&& horizontalLabelPosition != null
				&& verticalLabelPosition != null && primaryLabelVisible != null;
	}

	/**
	 * Return the background color to use for the diagram element's graphic.
	 * @return the background color
	 */
	public final Color getBackgroundColor() {
		return background;
	}

	/**
	 * Returns the text color.
	 * @return the text color
	 */
	public final Color getFontColor() {
		return fontColor;
	}

	/**
	 * Returns the color to use for graphic lines.
	 * @return the outline color
	 */
	public final Color getOutlineColor() {
		return outline;
	}

	/**
	 * Returns the text size.
	 * @return the text size
	 */
	public final Double getFontSize() {
		return fontSize;
	}

	/**
	 * Returns the size of of the graphic lines.
	 * @return the line width
	 */
	public final Double getLineWidth() {
		return lineWidth;
	}

	/**
	 * Returns whether to show the diagram element as an image. If true then {@link #getImagePath()} will return non-null.
	 * @return whether to show the diagram element as an image
	 * @see #getImagePath()
	 */
	public final Boolean getShowAsImage() {
		return showAsImage;
	}

	/**
	 * Returns the image to use to represent the diagram element. Will return a non-null value when {@link #getShowAsImage()} returns true.
	 * However, this function may return a valid value when {@link #getShowAsImage()} returns true.
	 * @return the path to the image to use to represent the diagram element when {@link #getShowAsImage()} is true
	 */
	public final IPath getImagePath() {
		return image;
	}

	/**
	 * Return the type of graphic lines to use.
	 * @return the type of graphic lines to use
	 * @since 1.1
	 */
	public final LineStyle getLineStyle() {
		return lineStyle;
	}

	/**
	 * Returns the positioning of labels along the horizontal axis.
	 * @return the positioning of labels along the horizontal axis
	 */
	public final LabelPosition getHorizontalLabelPosition() {
		return horizontalLabelPosition;
	}

	/**
	 * Returns the positioning of labels along the vertical axis.
	 * @return the positioning of labels along the vertical axis
	 */
	public final LabelPosition getVerticalLabelPosition() {
		return verticalLabelPosition;
	}

	/**
	 * Returns whether the diagram element's primary label should be shown.
	 * @return whether the diagram element's primary label should be shown
	 */
	public final Boolean getPrimaryLabelVisible() {
		return primaryLabelVisible;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((background == null) ? 0 : background.hashCode());
		result = prime * result + ((fontColor == null) ? 0 : fontColor.hashCode());
		result = prime * result + ((fontSize == null) ? 0 : fontSize.hashCode());
		result = prime * result + ((horizontalLabelPosition == null) ? 0 : horizontalLabelPosition.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((showAsImage == null) ? 0 : showAsImage.hashCode());
		result = prime * result + ((lineStyle == null) ? 0 : lineStyle.hashCode());
		result = prime * result + ((lineWidth == null) ? 0 : lineWidth.hashCode());
		result = prime * result + ((outline == null) ? 0 : outline.hashCode());
		result = prime * result + ((primaryLabelVisible == null) ? 0 : primaryLabelVisible.hashCode());
		result = prime * result + ((verticalLabelPosition == null) ? 0 : verticalLabelPosition.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Style other = (Style) obj;
		if (background == null) {
			if (other.background != null) {
				return false;
			}
		} else if (!background.equals(other.background)) {
			return false;
		}
		if (fontColor == null) {
			if (other.fontColor != null) {
				return false;
			}
		} else if (!fontColor.equals(other.fontColor)) {
			return false;
		}
		if (fontSize == null) {
			if (other.fontSize != null) {
				return false;
			}
		} else if (!fontSize.equals(other.fontSize)) {
			return false;
		}
		if (horizontalLabelPosition != other.horizontalLabelPosition) {
			return false;
		}
		if (image == null) {
			if (other.image != null) {
				return false;
			}
		} else if (!image.equals(other.image)) {
			return false;
		}
		if (showAsImage == null) {
			if (other.showAsImage != null) {
				return false;
			}
		} else if (!showAsImage.equals(other.showAsImage)) {
			return false;
		}
		if (lineStyle != other.lineStyle) {
			return false;
		}
		if (lineWidth == null) {
			if (other.lineWidth != null) {
				return false;
			}
		} else if (!lineWidth.equals(other.lineWidth)) {
			return false;
		}
		if (outline == null) {
			if (other.outline != null) {
				return false;
			}
		} else if (!outline.equals(other.outline)) {
			return false;
		}
		if (primaryLabelVisible == null) {
			if (other.primaryLabelVisible != null) {
				return false;
			}
		} else if (!primaryLabelVisible.equals(other.primaryLabelVisible)) {
			return false;
		}
		return verticalLabelPosition == other.verticalLabelPosition;
	}
}
