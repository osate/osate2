package org.osate.ge.internal.diagram.runtime.layout;

import org.eclipse.elk.graph.properties.Property;

public class AgeLayoutOptions {
	// Used by ElkGraphBuilder to store whether there were nested ports in the AgeDiagram which have been omitted from the layout graph.
	public static final Property<Boolean> NESTED_PORTS_WERE_OMITTED = new Property<>(
			"org.osate.ge.internal.nestedPortsWereOmitted",
			false);
}
