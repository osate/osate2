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
package org.osate.ge.gef;

import java.util.Objects;

import org.osate.ge.gef.graphics.ImageReference;

import com.google.common.collect.ImmutableList;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Style which is implemented using JavaFX specific types.
 */
public class FxStyle {
	public static class Builder {
		private Color backgroundColor = Color.WHITE;
		private Color outlineColor = Color.BLACK;
		private Color fontColor = Color.BLACK;
		private Font font = Font.getDefault();
		private double strokeDashOffset = 0.0;
		private ImmutableList<Double> strokeDashArray = ImmutableList.of();
		private double lineWidth = 1.0;
		private LabelPosition horzontalLabelPosition = LabelPosition.CENTER;
		private LabelPosition verticalLabelPosition = LabelPosition.BEGINNING;
		private boolean primaryLabelVisible = true;
		private ImageReference image;

		/**
		 * Sets the background color
		 * @param value the new background color.
		 * @return this builder object
		 */
		public Builder backgroundColor(final Color value) {
			this.backgroundColor = Objects.requireNonNull(value, "value must not be null");
			return this;
		}

		/**
		 * Sets the outline color
		 * @param value the new outline color.
		 * @return this builder object
		 */
		public Builder outlineColor(final Color value) {
			this.outlineColor = Objects.requireNonNull(value, "value must not be null");
			return this;
		}

		/**
		 * Sets the font color
		 * @param value the new font color.
		 * @return this builder object
		 */
		public Builder fontColor(final Color value) {
			this.fontColor = Objects.requireNonNull(value, "value must not be null");
			return this;
		}

		/**
		 * Sets the font
		 * @param value the new font.
		 * @return this builder object
		 */
		public Builder font(final Font value) {
			this.font = Objects.requireNonNull(value, "value must not be null");
			return this;
		}

		/**
		 * Sets the stroke dash offset
		 * @param value the new stroke dash offset.
		 * @return this builder object
		 */
		public Builder strokeDashOffset(final double value) {
			this.strokeDashOffset = value;
			return this;
		}

		/**
		 * Sets the stroke dash array
		 * @param value the new stroke dash array.
		 * @return this builder object
		 */
		public Builder strokeDashArray(final ImmutableList<Double> value) {
			this.strokeDashArray = Objects.requireNonNull(value, "value must not be null");
			return this;
		}

		/**
		 * Sets the line width
		 * @param value the new line width.
		 * @return this builder object
		 */
		public Builder lineWidth(final double value) {
			this.lineWidth = Objects.requireNonNull(value, "value must not be null");
			return this;
		}

		/**
		 * Sets the horizontal label position
		 * @param value the new horizontal label position.
		 * @return this builder object
		 */
		public Builder horizontalLabelPosition(final LabelPosition value) {
			this.horzontalLabelPosition = Objects.requireNonNull(value, "value must not be null");
			return this;
		}

		/**
		 * Sets the vertical label position
		 * @param value the new vertical label position.
		 * @return this builder object
		 */
		public Builder verticalLabelPosition(final LabelPosition value) {
			this.verticalLabelPosition = Objects.requireNonNull(value, "value must not be null");
			return this;
		}

		/**
		 * Sets whether to show the primary label
		 * @param value whether to show the primary label
		 * @return this builder object
		 */
		public Builder primaryLabelVisible(final boolean value) {
			this.primaryLabelVisible = value;
			return this;
		}

		/**
		 * Sets the image that should replace the node's graphic.
		 * @param value the image to use for the node. If null, then the node will not be shown as an image.
		 * @return this builder object
		 */
		public Builder image(final ImageReference value) {
			this.image = value;
			return this;
		}

		public FxStyle build() {
			return new FxStyle(backgroundColor, outlineColor, fontColor, font, strokeDashOffset, strokeDashArray,
					lineWidth, horzontalLabelPosition, verticalLabelPosition, primaryLabelVisible, image);
		}
	}

	private final Color backgroundColor;
	private final Color outlineColor;
	private final Color fontColor;
	private final Font font;
	private final double strokeDashOffset;
	private final ImmutableList<Double> strokeDashArray;
	private final double lineWidth;
	private final LabelPosition horzontalLabelPosition;
	private final LabelPosition verticalLabelPosition;
	private final boolean primaryLabelVisible;
	private final ImageReference image;

	private FxStyle(final Color backgroundColor, final Color outlineColor, final Color fontColor, final Font font,
			final double strokeDashOffset, final ImmutableList<Double> strokeDashArray, final double lineWidth,
			final LabelPosition horzontalLabelPosition, final LabelPosition verticalLabelPosition,
			final boolean primaryLabelVisible, final ImageReference image) {
		this.backgroundColor = backgroundColor;
		this.outlineColor = outlineColor;
		this.fontColor = fontColor;
		this.font = font;
		this.strokeDashOffset = strokeDashOffset;
		this.strokeDashArray = strokeDashArray;
		this.lineWidth = lineWidth;
		this.horzontalLabelPosition = horzontalLabelPosition;
		this.verticalLabelPosition = verticalLabelPosition;
		this.primaryLabelVisible = primaryLabelVisible;
		this.image = image;
	}

	/**
	 * Returns the background color
	 * @return the backgroundColor
	 */
	public final Color getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * Returns the outline color
	 * @return the outlineColor
	 */
	public final Color getOutlineColor() {
		return outlineColor;
	}

	/**
	 * Returns the font color
	 * @return the fontColor
	 */
	public final Color getFontColor() {
		return fontColor;
	}

	/**
	 * Returns the font
	 * @return the font
	 */
	public final Font getFont() {
		return font;
	}

	/**
	 * Returns the stroke dash offset
	 * @return the strokeDashOffset
	 */
	public final double getStrokeDashOffset() {
		return strokeDashOffset;
	}

	/**
	 * Returns the stroke dash array
	 * @return the strokeDashArray
	 */
	public final ImmutableList<Double> getStrokeDashArray() {
		return strokeDashArray;
	}

	/**
	 * Returns the line width
	 * @return the line width
	 */
	public final double getLineWidth() {
		return lineWidth;
	}

	/**
	 * Returns the horizontal label position
	 * @return the horizontal label position
	 */
	public final LabelPosition getHorizontalLabelPosition() {
		return horzontalLabelPosition;
	}

	/**
	 * Returns the vertical label position
	 * @return the vertical label position
	 */
	public final LabelPosition getVerticalLabelPosition() {
		return verticalLabelPosition;
	}

	/**
	 * Returns whether to show the primary label.
	 * @return whether to show the primary label.
	 */
	public final boolean isPrimaryLabelVisible() {
		return primaryLabelVisible;
	}

	/**
	 * Returns a reference to the image to display instead of using the node's graphic.
	 * If null, the node's graphic should be displayed.
	 * @return the image to display in place of the node's graphic.
	 */
	public final ImageReference image() {
		return image;
	}
}
