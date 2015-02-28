package org.osate.ge.diagrams.common;

public interface Categorized {
	public static enum Category {
		CLASSIFIERS,
		CONNECTIONS,
		FEATURES,
		FLOWS,
		MODES,
		RELATIONSHIPS,
		SUBCOMPONENTS,
		SUBPROGRAM_CALLS
	}
	
	Category getCategory();
}
