package org.osate.ge.ui.util;

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
