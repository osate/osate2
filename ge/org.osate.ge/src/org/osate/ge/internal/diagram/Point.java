package org.osate.ge.internal.diagram;

import java.util.Objects;

/**
 * Immutable point type
 *
 */
public class Point {
	public Point(final int x, final int y) {
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
		result = prime * result + x;
		result = prime * result + y;
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
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	public org.osate.ge.mm.diagram.Point toMetamodel() {
		final org.osate.ge.mm.diagram.Point newPoint = new org.osate.ge.mm.diagram.Point();
		newPoint.setX(x);
		newPoint.setY(y);
		return newPoint;
	}
	
	public final int x;
	public final int y;
}
