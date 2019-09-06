package org.osate.ge.tests.endToEnd.util;

import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;

import com.google.common.collect.ImmutableList;

public class DiagramReference {
	public final ImmutableList<String> pathSegments;

	/**
	 * Final segment is expected to contain diagram extension.
	 */
	public DiagramReference(final String... diagramPathSegments) {
		this.pathSegments = ImmutableList.copyOf(diagramPathSegments);
	}

	public String getUri() {
		return URI.createPlatformResourceURI(String.join("/", pathSegments), false).toString() + "#/0";
	}

	@Override
	public String toString() {
		return "[" + pathSegments.stream().map(r -> r.toString()).collect(Collectors.joining(",")) + "]";
	}
}
