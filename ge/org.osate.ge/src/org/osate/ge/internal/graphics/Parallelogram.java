package org.osate.ge.internal.graphics;

public class Parallelogram implements AgeShape {
	public final int lineWidth;
	public final LineStyle lineStyle;
	public final int horizontalOffset;
	
	public Parallelogram(final int lineWidth, final LineStyle lineStyle, final int horizontalOffset) {
		this.lineWidth = lineWidth;
		this.lineStyle = lineStyle;
		this.horizontalOffset = horizontalOffset;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + horizontalOffset;
		result = prime * result + ((lineStyle == null) ? 0 : lineStyle.hashCode());
		result = prime * result + lineWidth;
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
		Parallelogram other = (Parallelogram) obj;
		if (horizontalOffset != other.horizontalOffset) {
			return false;
		}
		if (lineStyle != other.lineStyle) {
			return false;
		}
		if (lineWidth != other.lineWidth) {
			return false;
		}
		return true;
	}
}
