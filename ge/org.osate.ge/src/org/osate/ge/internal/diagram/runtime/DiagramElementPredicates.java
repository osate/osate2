package org.osate.ge.internal.diagram.runtime;

import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.internal.AgeConnection;
import org.osate.ge.graphics.internal.AgeShape;
import org.osate.ge.graphics.internal.Label;

public class DiagramElementPredicates {
	public static boolean isResizeable(final DiagramElement de) {
		final Graphic graphic = de.getGraphic();
		return graphic instanceof AgeShape && ((AgeShape)graphic).isResizeable();
	}

	public static boolean isMoveable(final DiagramElement de) {
		final Graphic graphic = de.getGraphic();
		return graphic instanceof AgeShape && ((AgeShape)graphic).isMoveable();
	}

	public static boolean isUndocked(final DiagramElement de) {
		return de.getDockArea() == null;
	}

	public static boolean isShape(final DiagramElement de) {
		return de.getGraphic() instanceof AgeShape;
	}

	public static boolean isConnection(final DiagramElement de) {
		return de.getGraphic() instanceof AgeConnection;
	}

	public static boolean supportsImage(final DiagramElement de) {
		return !(de.getGraphic() instanceof Label) && de.getGraphic() instanceof AgeShape && isUndocked(de);
	}
}
