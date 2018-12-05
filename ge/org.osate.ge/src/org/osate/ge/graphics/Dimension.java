package org.osate.ge.graphics;

import java.util.Objects;

/**
 * Immutable dimension type.
 *
 */
public class Dimension {
	public final double width;
	public final double height;

	public Dimension(final double width, final double height) {
		this.width = width;
		this.height = height;
	}

	public Dimension(final Dimension d) {
		Objects.requireNonNull(d, "d must not be null");
		this.width = d.width;
		this.height = d.height;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Dimension other = (Dimension) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height)) {
			return false;
		}
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "(" + width + "," + height + ")";
	}

	public org.osate.ge.diagram.Dimension toMetamodel() {
		final org.osate.ge.diagram.Dimension newDimension = new org.osate.ge.diagram.Dimension();
		newDimension.setWidth(width);
		newDimension.setHeight(height);
		return newDimension;
	}
}
