package org.osate.slicer;

import org.jgrapht.graph.MaskSubgraph;

/**
 *
 * @author sprocter
 * see https://jgrapht.org/guide/VertexAndEdgeTypes#vertices-as-pointers
 */
public class OsateSlicerVertex {
	private MaskSubgraph g;
	final String path; // key

	public OsateSlicerVertex(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return path;
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
