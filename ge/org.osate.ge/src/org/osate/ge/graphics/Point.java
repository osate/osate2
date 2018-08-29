package org.osate.ge.graphics;

import java.util.Objects;

/**
 * Immutable point type
 *
 */
public class Point {
	public final double x;
	public final double y;

	public Point(final double x, final double y) {
		this.x = x;
		this.y = y;
	}

	public Point(final Point p) {
		Objects.requireNonNull(p, "p must not be null");
		this.x = p.x;
		this.y = p.y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
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
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
			return false;
		}
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public org.osate.ge.diagram.Point toMetamodel() {
		final org.osate.ge.diagram.Point newPoint = new org.osate.ge.diagram.Point();
		newPoint.setX(x);
		newPoint.setY(y);
		return newPoint;
	}
}
