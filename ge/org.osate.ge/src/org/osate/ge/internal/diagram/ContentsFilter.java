package org.osate.ge.internal.diagram;

public enum ContentsFilter {
	ALLOW_FUNDAMENTAL, // Only include business objects which are manually specified or which are an inherent/fundamental part of the parent.
	ALLOW_TYPE, // Include business objects which have been manually specified or which are related to a Classifier Type. For example, features.
	ALLOW_ALL // Include all business objects.
}
