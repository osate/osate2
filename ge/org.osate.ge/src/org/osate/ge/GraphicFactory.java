package org.osate.ge;

import org.osate.ge.internal.graphics.ConnectionStyle;
import org.osate.ge.internal.graphics.Ellipse;
import org.osate.ge.internal.graphics.FreeFormConnection;
import org.osate.ge.internal.graphics.Rectangle;

public class GraphicFactory {
	public static Graphic createEllipse() {
		return new Ellipse();
	}
	
	public static Graphic createRectangle() {
		return new Rectangle();
	}
	
	// TODO: Rework these methods
	public static Graphic createSolidFreeFormConnection(final ConnectionTerminator srcTerminator, final ConnectionTerminator dstTerminator) {
		return new FreeFormConnection(ConnectionStyle.SOLID, srcTerminator, dstTerminator);
	}
	
	public static Graphic createDashedFreeFormConnection(final ConnectionTerminator srcTerminator, final ConnectionTerminator dstTerminator) {
		return new FreeFormConnection(ConnectionStyle.DASHED, srcTerminator, dstTerminator);
	}
}
