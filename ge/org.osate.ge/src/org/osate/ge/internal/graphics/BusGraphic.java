package org.osate.ge.internal.graphics;

public class BusGraphic implements AgeShape {
	public final int lineWidth;
	public final LineStyle lineStyle;
	
	public BusGraphic(final int lineWidth, final LineStyle lineStyle) {
		this.lineWidth = lineWidth;
		this.lineStyle = lineStyle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		BusGraphic other = (BusGraphic) obj;
		if (lineStyle != other.lineStyle) {
			return false;
		}
		if (lineWidth != other.lineWidth) {
			return false;
		}
		return true;
	}
	
	
}
