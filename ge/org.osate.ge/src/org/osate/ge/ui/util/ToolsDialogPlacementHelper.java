package org.osate.ge.ui.util;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

public class ToolsDialogPlacementHelper {
	/**
	 * Sets a dialog's location relative to the active shell's bounds
	 * @param activeShellBounds the active shell's bounds
	 * @param xOffset the amount to offset the x coordinate 
	 * @param yOffset the amount to offset the y coordinate
	 * @return the new point to place the dialog
	 */
	public static Point getOffsetDialogLocation(final Rectangle activeShellBounds, final int xOffset, final int yOffset) {
		return new Point(activeShellBounds.x + xOffset, activeShellBounds.y + yOffset);
	}
}
