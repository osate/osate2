package org.osate.ge.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Internal description of the area of the container to which the shape is docked.
 *
 */
public enum DockArea {
	LEFT("left"),
	RIGHT("right"),
	TOP("top"),
	BOTTOM("bottom"),
	GROUP("feature_group"); // Container is a group of docked shapes. String "feature_group" is for backwards compatibility purposes
	
	private static final Map<String, DockArea> idToDockAreaMap;
	static {
		final Map<String, DockArea> modifiableMap = new HashMap<String, DockArea>();
		for(final DockArea area : DockArea.values()) {
			modifiableMap.put(area.id, area);
		}
		idToDockAreaMap = Collections.unmodifiableMap(modifiableMap);
	}		
	
	public static DockArea getById(final String dockAreaId) {
		return idToDockAreaMap.get(dockAreaId);
	}
	
	public final String id;
	
	DockArea(final String id) {
		this.id = id;
	}		
}

