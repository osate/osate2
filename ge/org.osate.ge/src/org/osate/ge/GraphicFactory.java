package org.osate.ge;

import java.awt.geom.Point2D;

import org.osate.ge.internal.graphics.ConnectionStyle;
import org.osate.ge.internal.graphics.Ellipse;
import org.osate.ge.internal.graphics.FreeFormConnection;
import org.osate.ge.internal.graphics.Polygon;
import org.osate.ge.internal.graphics.Rectangle;
import org.osate.ge.internal.graphics.RoundedRectangle;

public class GraphicFactory {
	public static Graphic createEllipse() {
		return new Ellipse();
	}
	
	public static Graphic createRectangle() {
		return new Rectangle();
	}
	
	public static Graphic createRoundedRectangle() {
		return new RoundedRectangle();
	}
	
	// TODO: Rename? unfilledPolygon? The others don't have wording to indicate unfilled
	// TODO: could be createScaledPolygon() or similiar ?
	public static Graphic createPolygon(final Point2D.Double... points) {
		return new Polygon(points);
	}
	
	// TODO: Rework these methods
	public static Graphic createSolidFreeFormConnection(final ConnectionTerminator srcTerminator, final ConnectionTerminator dstTerminator) {
		return new FreeFormConnection(ConnectionStyle.SOLID, srcTerminator, dstTerminator);
	}
	
	public static Graphic createDashedFreeFormConnection(final ConnectionTerminator srcTerminator, final ConnectionTerminator dstTerminator) {
		return new FreeFormConnection(ConnectionStyle.DASHED, srcTerminator, dstTerminator);
	}
}
