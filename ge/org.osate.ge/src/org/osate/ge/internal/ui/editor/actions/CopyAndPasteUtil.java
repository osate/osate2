package org.osate.ge.internal.ui.editor.actions;

import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;

public class CopyAndPasteUtil {
	public static Point getPositionToCopy(final DiagramElement de) {
		return CopyAndPasteUtil.shouldCopyPosition(de) ? DiagramElementLayoutUtil.getAbsolutePosition(de) : null;
	}

	/**
	 * Returns true if the element is not docked, is moveable, has a position.
	 * @param de
	 * @return
	 */
	private static boolean shouldCopyPosition(final DiagramElement de) {
		return de.getDockArea() == null && DiagramElementPredicates.isMoveable(de) && de.hasPosition();
	}
}
