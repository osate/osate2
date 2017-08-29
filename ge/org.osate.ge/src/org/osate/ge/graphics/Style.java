package org.osate.ge.graphics;

import java.awt.Color;

import org.osate.ge.internal.graphics.LineStyle;

public class Style {
	public static final Style EMPTY = StyleBuilder.create().build();
	public final static Style DEFAULT = StyleBuilder.create().backgroundColor(java.awt.Color.WHITE)
			.foregroundColor(java.awt.Color.BLACK).fontSize(FontSize.Medium).lineWidth(LineWidth.Small)
			.lineStyle(LineStyle.SOLID).build();

	private final Color background;
	private final Color outline;
	private final Color fontColor;
	private final FontSize fontSize;
	private final LineWidth lineWidth;
	private final LineStyle lineStyle;

	Style(final Color background, final Color fontColor, final Color outline, final FontSize fontSize,
			final LineWidth lineWidth, final LineStyle lineStyle) {
		this.background = background;
		this.fontColor = fontColor;
		this.outline = outline;
		this.fontSize = fontSize;
		this.lineWidth = lineWidth;
		this.lineStyle = lineStyle;
	}

	public final Color getBackgroundColor() {
		return background;
	}

	public final Color getOutlineColor() {
		return outline;
	}

	public final Color getFontColor() {
		return fontColor;
	}

	public final FontSize getFontSize() {
		return fontSize;
	}

	public final LineWidth getLineWidth() {
		return lineWidth;
	}

	public final LineStyle getLineStyle() {
		return lineStyle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((background == null) ? 0 : background.hashCode());
		result = prime * result + ((fontColor == null) ? 0 : fontColor.hashCode());
		result = prime * result + ((fontSize == null) ? 0 : fontSize.hashCode());
		result = prime * result + ((lineStyle == null) ? 0 : lineStyle.hashCode());
		result = prime * result + ((lineWidth == null) ? 0 : lineWidth.hashCode());
		result = prime * result + ((outline == null) ? 0 : outline.hashCode());
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
		if (fontSize != other.fontSize) {
			return false;
		}
		if (lineStyle != other.lineStyle) {
			return false;
		}
		if (lineWidth != other.lineWidth) {
			return false;
		}
		if (outline == null) {
			if (other.outline != null) {
				return false;
			}
		} else if (!outline.equals(other.outline)) {
			return false;
		}
		return true;
	}
}
