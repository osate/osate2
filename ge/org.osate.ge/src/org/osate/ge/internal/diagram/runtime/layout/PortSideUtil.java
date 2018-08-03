package org.osate.ge.internal.diagram.runtime.layout;

import org.eclipse.elk.core.options.PortSide;
import org.osate.ge.internal.diagram.runtime.DockArea;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

public class PortSideUtil {
	private final static BiMap<DockArea, PortSide> dockAreaToPortSideMap = ImmutableBiMap.of(DockArea.TOP,
			PortSide.NORTH, DockArea.BOTTOM, PortSide.SOUTH, DockArea.LEFT, PortSide.WEST, DockArea.RIGHT,
			PortSide.EAST);

	public static PortSide getPortSideForNonGroupDockArea(final DockArea dockArea) {
		final PortSide portSide = dockAreaToPortSideMap.get(dockArea);
		if (portSide == null) {
			throw new RuntimeException("Unexpected dock area: " + dockArea);
		}

		return portSide;
	}

	public static DockArea getDockArea(final PortSide ps) {
		return dockAreaToPortSideMap.inverse().get(ps);
	}
}
