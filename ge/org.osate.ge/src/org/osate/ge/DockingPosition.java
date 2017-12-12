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

	private final DockArea defaultDockArea;

	DockingPosition(DockArea defaultDockArea) {
		this.defaultDockArea = defaultDockArea;
	}

	public DockArea getDefaultDockArea() {
		return defaultDockArea;
	}
}
