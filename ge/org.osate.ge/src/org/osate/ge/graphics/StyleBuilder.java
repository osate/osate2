package org.osate.ge.graphics;

import java.awt.Color;

import org.osate.ge.internal.graphics.LineStyle;

public class StyleBuilder {
	private Color background;
	private Color outline;
	private Color fontColor;
	private FontSize fontSize;
	private LineWidth lineWidth;
	private LineStyle lineStyle;

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

	public StyleBuilder fontSize(final FontSize fontSize) {
		this.fontSize = fontSize;
		return this;
	}

	public StyleBuilder lineWidth(final LineWidth lineWidth) {
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

	public Style build() {
		return new Style(background, fontColor, outline, fontSize, lineWidth, lineStyle);
	}
}
