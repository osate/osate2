package org.osate.ge.tests.endToEnd.util;

import com.google.common.collect.ImmutableList;

public class DiagramReference {
	private final ImmutableList<String> pathSegments;

	public DiagramReference(final String... diagramPathSegments) {
		this.pathSegments = ImmutableList.copyOf(diagramPathSegments);
	}

	// TODO: Rename? Should be immutable list?
	public String[] getWithExtension() {
		final String[] segments = pathSegments.toArray(c -> new String[c]);
		segments[segments.length - 1] = segments[segments.length - 1] + ".aadl_diagram";
		return segments;
	}

	// TODO: Rename? Should be immutable list?
	public String[] getWithoutExtension() {
		return pathSegments.toArray(c -> new String[c]);
	}
}
