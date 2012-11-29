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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.osate.imv.aadldiagram.draw2d.ResizableMevFigure.ResizeType;


public class SubcomponentFigureResizeDelegate implements IResizableFigureDelegate {

	private static final Dimension MINIMUM_SIZE = new Dimension(50, 50);

	@Override
	public Rectangle getNewBounds(ResizeType resizeType, Point location, Rectangle bounds) {
		Point origin = Point.SINGLETON;
		Dimension dimension = Dimension.SINGLETON;

		switch(resizeType) {
		case NW:
			origin.x = location.x;
			origin.y = location.y;
			dimension.width = bounds.getRight().x - location.x;
			dimension.height = bounds.getBottom().y - location.y;
			break;
		case NE:
			origin.x = bounds.x;
			origin.y = location.y;
			dimension.width = location.x - bounds.x;
			dimension.height = bounds.getBottom().y - location.y;
			break;
		case SE:
			origin.x = bounds.x;
			origin.y = bounds.y;
			dimension.width = location.x - bounds.x;
			dimension.height = location.y - bounds.y;
			break;
		case SW:
			origin.x = location.x;
			origin.y = bounds.y;
			dimension.width = bounds.getRight().x - location.x;
			dimension.height = location.y - bounds.y;
			break;
		}

		if(dimension.width < MINIMUM_SIZE.width)
			dimension.width = MINIMUM_SIZE.width;

		if(dimension.height < MINIMUM_SIZE.height)
			dimension.height = MINIMUM_SIZE.height;


		return new Rectangle(origin, dimension);
	}

}
