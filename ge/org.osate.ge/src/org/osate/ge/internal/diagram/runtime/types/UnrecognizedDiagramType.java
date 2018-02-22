package org.osate.ge.internal.diagram.runtime.types;

import java.util.Objects;

/**
 * DiagramType implementation which will be used when the specified diagram type cannot be found. Behaves like the custom diagram type but will return the originally specified diagram type ID.
 * This allows diagrams created with diagram types which are not supported by the currently running version of OSATE to be viewable.
 * This is considered acceptable behavior since diagram types only control the default behavior for a diagram.
 */
public class UnrecognizedDiagramType extends CustomDiagramType {
	private String id;

	public UnrecognizedDiagramType(final String id) {
		this.id = Objects.requireNonNull(id, "id must not be null");
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return "Unrecognized Diagram Type";
	}
}
