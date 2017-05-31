package org.osate.ge.internal.diagram;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum ContentsFilter {
	DEFAULT("default"), // Represents the default value for the content filter. The editor will decide which filter to use.
	ALLOW_FUNDAMENTAL("allow_fundamental"), // Only include business objects which are manually specified or which are an inherent/fundamental part of the parent.
	ALLOW_TYPE("allow_type"), // Include business objects which have been manually specified or which are related to a Classifier Type. For example, features.
	ALLOW_ALL("allow_all"); // Include all business objects
	
	private static final Map<String, ContentsFilter> idToContentsFilterMap;
	static {
		final Map<String, ContentsFilter> modifiableMap = new HashMap<>();
		for(final ContentsFilter value : ContentsFilter.values()) {
			modifiableMap.put(value.id, value);
		}
		idToContentsFilterMap = Collections.unmodifiableMap(modifiableMap);
	}		
	
	public static ContentsFilter getById(final String id) {
		return idToContentsFilterMap.get(id);
	}
	
	public final String id;// For serialization
	
	ContentsFilter(final String id) {
		this.id = id;
	}
}
