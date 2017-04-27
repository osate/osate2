package org.osate.ge.internal.graphics;

import java.awt.geom.Point2D;
import java.util.Objects;

public class Polygon implements AgeShape {
	private final Point2D.Double[] points;
	
	public Polygon(final Point2D.Double[] points) {
		this.points = Objects.requireNonNull(points, "points must not be null").clone();
	}
	
	public final Point2D.Double[] getPoints() {
		return this.points;
	}
}
