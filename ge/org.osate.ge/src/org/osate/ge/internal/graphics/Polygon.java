package org.osate.ge.internal.graphics;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Objects;

public class Polygon implements AgeShape {
	private final Point2D.Double[] points;
	public final int lineWidth;
	public final LineStyle lineStyle;
	
	public Polygon(final Point2D.Double[] points, final int lineWidth, final LineStyle lineStyle) {
		this.points = Objects.requireNonNull(points, "points must not be null").clone();
		this.lineWidth = lineWidth;
		this.lineStyle = Objects.requireNonNull(lineStyle, "lineStyle must not be null");
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
		Polygon other = (Polygon) obj;
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
