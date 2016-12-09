package org.osate.ge.internal;

import org.osate.ge.internal.services.LayoutService;

public enum DockingPosition {
	ANY(LayoutService.DockArea.LEFT),
	NOT_DOCKED(null),
	LEFT(LayoutService.DockArea.LEFT),
	RIGHT(LayoutService.DockArea.RIGHT),
	TOP(LayoutService.DockArea.TOP),
	BOTTOM(LayoutService.DockArea.BOTTOM);
	
	private final LayoutService.DockArea dockArea;
	
	DockingPosition(LayoutService.DockArea dockArea) {
		this.dockArea = dockArea;
	}
	
	public LayoutService.DockArea getDockArea() {
		return dockArea;
	}
}
