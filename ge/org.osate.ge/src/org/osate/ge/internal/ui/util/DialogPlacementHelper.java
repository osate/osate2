/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.util;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

public class DialogPlacementHelper {
	/**
	 * Calculates the offset point relative to the top left of a specified rectangle.
	 * @param rect to be offset
	 * @param xOffset the amount to offset the x coordinate 
	 * @param yOffset the amount to offset the y coordinate
	 * @return the new point to place the rectangle
	 */
	public static Point getOffsetRectangleLocation(final Rectangle rect, final int xOffset, final int yOffset) {
		return new Point(rect.x + xOffset, rect.y + yOffset);
	}
}
