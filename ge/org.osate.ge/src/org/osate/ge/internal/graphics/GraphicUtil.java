package org.osate.ge.internal.graphics;

import org.osate.ge.graphics.Graphic;

public class GraphicUtil {
	public static boolean isMoveableShape(final Graphic graphic) {
		return graphic instanceof AgeShape && ((AgeShape)graphic).isMoveable();
	}
	
	public static boolean isResizableShape(final Graphic graphic) {
		return graphic instanceof AgeShape && ((AgeShape)graphic).isResizeable();
	}
}
