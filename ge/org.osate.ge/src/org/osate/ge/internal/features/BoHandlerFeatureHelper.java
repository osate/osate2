package org.osate.ge.internal.features;

import java.awt.geom.Point2D;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.ge.internal.graphics.Polygon;

/**
 * Helper class shared between business object handler featuers
 */
class BoHandlerFeatureHelper {
	public static final String nameShapeName = "name";
	
	public static GraphicsAlgorithm createPolygon(final Shape shape, final Polygon poly, final int width, final int height) {
		final int[] coords = new int[poly.getPoints().length * 2];
		int i = 0;

		// Build points based on the specified size
		for(final Point2D.Double p : poly.getPoints()) {
			coords[i++] = (int)(p.x * width);
			coords[i++] = (int)(p.y * height);
		}
		
		final GraphicsAlgorithm ga = Graphiti.getGaService().createPlainPolygon(shape, coords);
		ga.setFilled(false);
		
		return ga;
	}
}
