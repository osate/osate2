package org.osate.ge.internal.diagram.runtime;

import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.internal.AgeShape;

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
}
