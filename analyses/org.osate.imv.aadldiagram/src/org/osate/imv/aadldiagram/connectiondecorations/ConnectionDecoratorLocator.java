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

package org.osate.imv.aadldiagram.connectiondecorations;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

public class ConnectionDecoratorLocator extends ConnectionLocator {

	public ConnectionDecoratorLocator(Connection connection, int location) {
		super(connection, location);
	}

	/**
	 * Relocates the passed in figure (which must be a
	 * {@link RotatableDecoration}) at either the start or end of the
	 * connection.
	 *
	 * @param target
	 *            The RotatableDecoration to relocate
	 */
	public void relocate(IFigure target) {
		PointList points = getConnection().getPoints();
		RotatableDecoration decorator = (RotatableDecoration) target;
		decorator.setLocation(getLocation(points));

		if(getAlignment() == MIDDLE) {
			Connection connection = getConnection();
			Point refPoint = connection.getTargetAnchor().getLocation(null);
			connection.translateToRelative(refPoint);
			decorator.setReferencePoint(refPoint);
		}else if (getAlignment() == SOURCE) {
			decorator.setReferencePoint(points.getPoint(1));
		}else if (getAlignment() == TARGET) {
			decorator.setReferencePoint(points.getPoint(points.size() - 2));
		}
	}
}
