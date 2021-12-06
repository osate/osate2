package org.osate.slicer;

import org.eclipse.emf.ecore.EObject;

/**
 * The vertex type used by the slicer. See the
 * <a href="https://jgrapht.org/guide/VertexAndEdgeTypes#vertices-as-pointers">
 * JGRaphT Docs</a> for additional explanation of the structure
 *
 * @author sprocter
 */
public class OsateSlicerVertex {

	/**
	 * A globally unique name for the vertex
	 */
	final private String name; // key

	/**
	 * The container for the port represented by this vertex
	 */
	private EObject container;

	/**
	 * Make a new vertex with the given name
	 * @param name The feature's name
	 * @param container The container for the feature
	 */
	public OsateSlicerVertex(String name, EObject container) {
		this.name = name;
		this.container = container;
	}

	public EObject getContainer() {
		return container;
	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof OsateSlicerVertex) && (toString().equals(o.toString()));
	}

	public String getName() {
		return name;
	}
}
