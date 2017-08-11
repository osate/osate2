package org.osate.ge.internal.graphics;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Objects;

public class Poly implements AgeShape {
	public enum Type {
		POLYGON,
		POLYLINE
	}
	
	private final Point2D.Double[] points;
	public final int lineWidth;
	public final LineStyle lineStyle;
	public final Type type;
	public final double right;
	
	public Poly(final Point2D.Double[] points, final int lineWidth, final LineStyle lineStyle, final Type type) {
		this.points = Objects.requireNonNull(points, "points must not be null").clone();
		this.lineWidth = lineWidth;
		this.lineStyle = Objects.requireNonNull(lineStyle, "lineStyle must not be null");
		this.type = Objects.requireNonNull(type, "type must not be null");
		
		// Calculate bounds
		double tmpRight = 0;
		for(final Point2D.Double p : points) {
			tmpRight = Math.max(tmpRight, p.x);
		}
		right = tmpRight;
	}
	
	public final Point2D.Double[] getPoints() {
		return this.points;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lineStyle == null) ? 0 : lineStyle.hashCode());
		result = prime * result + lineWidth;
		result = prime * result + Arrays.hashCode(points);
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
		if (lineStyle != other.lineStyle) {
			return false;
		}
		if (lineWidth != other.lineWidth) {
			return false;
		}
		if (!Arrays.equals(points, other.points)) {
			return false;
		}
		return true;
	}
}
