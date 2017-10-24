package org.osate.ge.graphics;

import org.osate.ge.graphics.internal.LineStyle;

public class Style {
	public static final Style EMPTY = StyleBuilder.create().build();
	public final static Style DEFAULT = StyleBuilder.create().backgroundColor(Color.WHITE).foregroundColor(Color.BLACK)
			.fontSize(10.0).lineWidth(2.0)
			.lineStyle(LineStyle.SOLID).labelsHorizontalPosition(LabelPosition.GRAPHIC_BEGINNING)
			.primaryLabelVisible(true)
			.labelsVerticalPosition(LabelPosition.GRAPHIC_BEGINNING).build();

	private final Color background;
	private final Color outline;
	private final Color fontColor;
	private final Double fontSize;
	private final Double lineWidth;
	private final LineStyle lineStyle;
	private final LabelPosition horizontalLabelPosition;
	private final LabelPosition verticalLabelPosition;
	private final Boolean primaryLabelVisible;

	Style(final Color background, final Color fontColor, final Color outline, final Double fontSize,
			final Double lineWidth, final LineStyle lineStyle, final LabelPosition horizontalLabelPosition,
			final LabelPosition verticalLabelPosition, final Boolean primaryLabelVisible) {
		this.background = background;
		this.fontColor = fontColor;
		this.outline = outline;
		this.fontSize = fontSize;
		this.lineWidth = lineWidth;
		this.lineStyle = lineStyle;
		this.horizontalLabelPosition = horizontalLabelPosition;
		this.verticalLabelPosition = verticalLabelPosition;
		this.primaryLabelVisible = primaryLabelVisible;
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

	public final Double getFontSize() {
		return fontSize;
	}

	public final Double getLineWidth() {
		return lineWidth;
	}

	public final LineStyle getLineStyle() {
		return lineStyle;
	}

	public final LabelPosition getHorizontalLabelPosition() {
		return horizontalLabelPosition;
	}

	public final LabelPosition getVerticalLabelPosition() {
		return verticalLabelPosition;
	}

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
		if (verticalLabelPosition != other.verticalLabelPosition) {
			return false;
		}
		return true;
	}

}
