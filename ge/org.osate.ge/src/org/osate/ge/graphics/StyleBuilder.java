package org.osate.ge.graphics;

import org.osate.ge.internal.graphics.LineStyle;

public class StyleBuilder {
	private Color background;
	private Color outline;
	private Color fontColor;
	private Double fontSize;
	private Double lineWidth;
	private LineStyle lineStyle;
	private LabelPosition horizontalLabelPosition;
	private LabelPosition verticalLabelPosition;

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
				sb.horizontalLabelPosition(s.getHorizontalLabelPosition());
			}

			if (s.getVerticalLabelPosition() != null) {
				sb.verticalLabelPosition(s.getVerticalLabelPosition());
			}
		}

		return sb;
	}

	public StyleBuilder backgroundColor(final Color background) {
		this.background = background;
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

	public StyleBuilder lineStyle(final LineStyle lineStyle) {
		this.lineStyle = lineStyle;
		return this;
	}

	public StyleBuilder horizontalLabelPosition(final LabelPosition value) {
		this.horizontalLabelPosition = value;
		return this;
	}

	public StyleBuilder verticalLabelPosition(final LabelPosition value) {
		this.verticalLabelPosition = value;
		return this;
	}

	/**
	 * Configures labels to be positioned before the left side of the graphic.
	 * @return this builder to allow method chaining.
	 */
	public StyleBuilder labelsBeforeLeft() {
		this.horizontalLabelPosition = LabelPosition.BEFORE_GRAPHIC;
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
	 * Configures labels to be positioned after the right side of the graphic.
	 * @return this builder to allow method chaining.
	 */
	public StyleBuilder labelsAfterRight() {
		this.horizontalLabelPosition = LabelPosition.AFTER_GRAPHIC;
		return this;
	}

	/**
	 * Configures labels to be positioned above the top of the graphic
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
	 * Configures labels to be positioned below the bottom of the graphic
	 * @return this builder to allow method chaining.
	 */
	public StyleBuilder labelsBelowBottom() {
		this.verticalLabelPosition = LabelPosition.AFTER_GRAPHIC;
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
		return new Style(background, fontColor, outline, fontSize, lineWidth, lineStyle, horizontalLabelPosition,
				verticalLabelPosition);
	}
}
