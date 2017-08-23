package org.osate.ge.internal;

import java.awt.Color;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Style {
	private Style() {}
	
	public static Style create() {
		return new Style();
	}
	
	private Style(final Color background, final Color fontColor, final Color outline, final FontSize fontSize, final LineWidth lineWidth) {
		this.background = background;
		this.fontColor = fontColor;
		this.outline = outline;
		this.fontSize = fontSize;
		this.lineWidth = lineWidth;
	}

	public Color getBackground() {
		return background;
	}
	
	public Style styleBackground(final Color background) {
		this.background = background;
		return this;
	}

	public Color getOutline() {
		return outline;
	}

	public Style styleOutline(final Color outline) {
		this.outline = outline;
		return this;
	}

	public Color getFontColor() {
		return fontColor;
	}

	public Style styleFontColor(final Color fontColor) {
		this.fontColor = fontColor;
		return this;
	}
	
	public FontSize getFontSize() {
		return fontSize;
	}
	
	public Style styleFontSize(final FontSize fontSize) {
		this.fontSize = fontSize;
		return this;
	}

	public LineWidth getLineWidth() {
		return lineWidth;
	}

	public Style styleLineWidth(final LineWidth lineWidth) {
		this.lineWidth = lineWidth;
		return this;
	}
	
	public Style build() {
		return new Style(background, fontColor, outline, fontSize, lineWidth);
	}

	public enum FontSize {
		Small(8.0),
		Default(10.0),
		Large(12.0);

		private static final Map<Double, FontSize> valueToFontSize;
		static {
			final Map<Double, FontSize> modifiableMap = new HashMap<Double, FontSize>();
			for(final FontSize fontSize : FontSize.values()) {
				modifiableMap.put(fontSize.getValue(), fontSize);
			}
			valueToFontSize = Collections.unmodifiableMap(modifiableMap);
		}

		private FontSize(final double value) {
			this.value = value;
		}

		public double getValue() {
			return value;
		}

		public static FontSize getByValue(final Double fontSizeId) {
			return valueToFontSize.get(fontSizeId);
		}

		private final Double value;
	}

	public enum LineWidth {
		Small(1),
		Default(2),
		Large(3);

		private static final Map<Integer, LineWidth> valueToLineWidth;
		static {
			final Map<Integer, LineWidth> modifiableMap = new HashMap<Integer, LineWidth>();
			for(final LineWidth lineWidth : LineWidth.values()) {
				modifiableMap.put(lineWidth.getValue(), lineWidth);
			}
			valueToLineWidth = Collections.unmodifiableMap(modifiableMap);
		}

		private LineWidth(final int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public static LineWidth getByValue(final int lineWidthId) {
			return valueToLineWidth.get(lineWidthId);
		}

		private final int value;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Style))
			return false;
		Style other = (Style) obj;
		if (background == null) {
			if (other.background != null)
				return false;
		} else if (!background.equals(other.background))
			return false;
		if (fontColor == null) {
			if (other.fontColor != null)
				return false;
		} else if (!fontColor.equals(other.fontColor))
			return false;
		if (fontSize != other.fontSize)
			return false;
		if (lineWidth != other.lineWidth)
			return false;
		if (outline == null) {
			if (other.outline != null)
				return false;
		} else if (!outline.equals(other.outline))
			return false;
		return true;
	}

	public static final Style defaultStyle = create();
	private Color background;
	private Color outline;
	private Color fontColor;
	private FontSize fontSize;
	private LineWidth lineWidth;
}
