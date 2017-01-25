package org.osate.ge.internal.graphics;

import java.awt.geom.Point2D;
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
}
