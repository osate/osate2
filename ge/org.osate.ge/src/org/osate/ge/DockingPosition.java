package org.osate.ge;

import org.osate.ge.internal.diagram.runtime.DockArea;

/**
 * Describes a docking position.
 */
public enum DockingPosition {
	ANY(DockArea.LEFT),
	NOT_DOCKABLE(null),
	LEFT(DockArea.LEFT),
	RIGHT(DockArea.RIGHT),
	TOP(DockArea.TOP),
	BOTTOM(DockArea.BOTTOM);

	private final DockArea dockArea;

	DockingPosition(DockArea dockArea) {
		this.dockArea = dockArea;
	}

	public DockArea getDockArea() {
		return dockArea;
	}
}
