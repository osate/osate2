package org.osate.xtext.aadl2.errormodel.util;

public enum PropagationPathLevel {
	LEAF, // only the lowest component instances with Error Propagations
	TOP, // only the highest component instances with error propagations
	ALL // all levels are included.
}
