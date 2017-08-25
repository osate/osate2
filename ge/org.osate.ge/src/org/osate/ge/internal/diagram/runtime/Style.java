package org.osate.ge.internal.diagram.runtime;

import java.awt.Color;

public class Style {
	public static final Style defaultStyle = StyleBuilder.create().build();
	private final Color background;
	private final Color outline;
	private final Color fontColor;
	private final FontSize fontSize;
	private final LineWidth lineWidth;

	Style(final Color background, final Color fontColor, final Color outline, final FontSize fontSize,
			final LineWidth lineWidth) {
		this.background = background;
		this.fontColor = fontColor;
		this.outline = outline;
		this.fontSize = fontSize;
		this.lineWidth = lineWidth;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((background == null) ? 0 : background.hashCode());
		result = prime * result + ((fontColor == null) ? 0 : fontColor.hashCode());
		result = prime * result + ((fontSize == null) ? 0 : fontSize.hashCode());
		result = prime * result + ((lineWidth == null) ? 0 : lineWidth.hashCode());
		result = prime * result + ((outline == null) ? 0 : outline.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Style)) {
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
