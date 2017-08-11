package org.osate.ge.internal.graphics;

public class Rectangle implements AgeShape {
	public final int lineWidth;
	public final LineStyle lineStyle;
	public final boolean rounded;
	
	public Rectangle(final int lineWidth, final LineStyle lineStyle, final boolean rounded) {
		this.lineWidth = lineWidth;
		this.lineStyle = lineStyle;
		this.rounded = rounded;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lineStyle == null) ? 0 : lineStyle.hashCode());
		result = prime * result + lineWidth;
		result = prime * result + (rounded ? 1231 : 1237);
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
		Rectangle other = (Rectangle) obj;
		if (lineStyle != other.lineStyle) {
			return false;
		}
		if (lineWidth != other.lineWidth) {
			return false;
		}
		if (rounded != other.rounded) {
			return false;
		}
		return true;
	}	
}
