package org.osate.ge.graphics.internal;

import java.util.Arrays;
import java.util.Objects;

import org.osate.ge.graphics.Point;

public class Poly implements AgeShape {
	public enum Type {
		POLYGON, POLYLINE
	}

	private final Point[] points;
	public final Type type;
	public final double right;

	public Poly(final Point[] points, final Type type) {
		this.points = Objects.requireNonNull(points, "points must not be null").clone();
		this.type = Objects.requireNonNull(type, "type must not be null");

		// Calculate bounds
		double tmpRight = 0;
		for (final Point p : points) {
			tmpRight = Math.max(tmpRight, p.x);
		}
		right = tmpRight;
	}

	public final Point[] getPoints() {
		return this.points;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(points);
		long temp;
		temp = Double.doubleToLongBits(right);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Poly other = (Poly) obj;
		if (!Arrays.equals(points, other.points)) {
			return false;
		}
		if (Double.doubleToLongBits(right) != Double.doubleToLongBits(other.right)) {
			return false;
		}
		if (type != other.type) {
			return false;
		}
		return true;
	}
}
