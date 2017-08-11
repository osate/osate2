package org.osate.ge.internal;

/**
 * Describes a docking position. Intended to be part of the public API once stabilized. 
 *
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
