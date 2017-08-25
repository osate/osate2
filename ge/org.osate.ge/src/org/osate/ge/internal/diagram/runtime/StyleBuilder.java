package org.osate.ge.internal.diagram.runtime;

import java.awt.Color;

public class StyleBuilder {
	private Color background;
	private Color outline;
	private Color fontColor;
	private FontSize fontSize;
	private LineWidth lineWidth;

	private StyleBuilder() {}

	public static StyleBuilder create() {
		return new StyleBuilder();
	}

	public static StyleBuilder create(final Style style) {
		return new StyleBuilder().backgroundColor(style.getBackgroundColor()).fontColor(style.getFontColor())
				.outlineColor(style.getOutlineColor()).fontSize(style.getFontSize()).lineWidth(style.getLineWidth());
	}

	public StyleBuilder backgroundColor(final Color background) {
		this.background = background;
		return this;
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

	public Style build() {
		return new Style(background, fontColor, outline, fontSize, lineWidth);
	}
}
