/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.aadldiagram.draw2d;

import java.util.Arrays;

import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.RelativeBendpoint;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;

public class BendpointHelper {

	/**
	 *
	 * @param loc The location must be in relative coordinates.
	 * @param source
	 * @param target
	 * @param connection
	 * @return
	 */
	public static RelativeBendpoint calculateRelativeBendpoint(Point loc, Point source, Point target, Connection connection) {
		RelativeBendpoint bp = new RelativeBendpoint(connection);

		// Calculate the slope of the straight line between the connection end points.
		float m = (float)(target.y - source.y) / (float)(target.x - source.x);

		// Calculate y-intercept for line that between the connection end points.
		float b = source.y - (m * source.x);

		// The line that is perpendicular to the the line that connects the two end points.
		float m1 = 1 / m; // The reciprocal of the slope.
		float b1 = loc.y - (m1 * loc.x);

		// Calculate the point where the perpendicular line intersects the line connecting the connection end points.
		PrecisionPoint loc2 = new PrecisionPoint();
		loc2.setPreciseX( (b1 - b) / (m - m1));
		loc2.setPreciseY((m * loc2.preciseX()) + b);


		/* Calculate weight. */

		double dis = loc2.getDistance(source);
		float weight;
		Dimension offset;

		// Check if intersection point is between the two end points.
		float dotProduct = (loc2.x - source.x) * (target.x - source.x) + (loc2.y - source.y) * (target.y - source.y);

		if(dotProduct < 0) {
			weight = 0;
			offset = loc.getDifference(source);
		} else {
			// Calculate squared distance between points.
			float squaredLength = (target.x - source.x) * (target.x - source.x) + (target.y - source.y) * (target.y - source.y);
			if(dotProduct > squaredLength) {
				weight = 1;
				offset = loc.getDifference(target);
			} else {
				// The intersection point is between the source and target end points.
				weight = (float) (dis / target.getDistance(source));
				offset = loc.getDifference(loc2);
			}
		}

		bp.setRelativeDimensions(offset, offset);
		bp.setWeight((float)weight);

		return bp;
	}

	public static void setDefaultBendpoints(Connection figure) {
		RelativeBendpoint bp = new RelativeBendpoint(figure);
		bp.setRelativeDimensions(new Dimension(0, 0), new Dimension(0, 0));
		bp.setWeight(0.5f);
		figure.getConnectionRouter().setConstraint(figure, Arrays.asList(new Bendpoint[] {bp}));
	}
}
