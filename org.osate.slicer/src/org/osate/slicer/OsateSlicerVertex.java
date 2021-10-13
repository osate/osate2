package org.osate.slicer;

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
	final String name; // key

	/**
	 * Make a new vertex with the given name
	 * @param name The vertex's name
	 */
	public OsateSlicerVertex(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof OsateSlicerVertex) && (toString().equals(o.toString()));
	}
}
