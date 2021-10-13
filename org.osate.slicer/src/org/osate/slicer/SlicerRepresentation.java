package org.osate.slicer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.AbstractGraph;
import org.jgrapht.graph.AsSubgraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.EdgeReversedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

/**
 *
 * This API provides functionality for building the graph needed for slicing AADL models, as well as performing the slices.
 *
 * @author sprocter
 *
 */
public class SlicerRepresentation {

	/**
	 * The primary graph. All other graphs are subgraphs of this one.
	 */
	private final Graph<OsateSlicerVertex, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);

	/**
	 * A reversed-direction version of the main graph. Not created until {@link #freeze() freeze} method has been run
	 */
	private final Graph<OsateSlicerVertex, DefaultEdge> rg = new DefaultDirectedGraph<>(DefaultEdge.class);

	/**
	 * Maps vertex names to their objects
	 */
	private final Map<String, OsateSlicerVertex> vertexMap = new HashMap<>();

	/**
	 * Tracks if the representation has been frozen.
	 */
	private boolean frozen = false;

	/**
	 * Adds a new vertex by the given name to the graph.
	 *
	 * @param name The name of the new vertex
	 */
	public void addVertex(String name) {
		if (vertexMap.containsKey(name)) {
			return; // No duplicates allowed
		}
		OsateSlicerVertex v = new OsateSlicerVertex(name);
		g.addVertex(v);
		vertexMap.put(name, v);
	}

	/**
	 * Adds a new edge from the source to the target
	 *
	 * @param src Source vertex
	 * @param tgt Target vertex
	 */
	public void addEdge(String src, String tgt) {
		g.addEdge(vertexMap.get(src), vertexMap.get(tgt));
	}

	/**
	 * This method should be called once all vertices and edges have been added
	 */
	public void freeze() {
		if (frozen) {
			return;
		}
		// Create a separate graph, rather than a wrapper, saving CPU at the expense of memory
		Graphs.addGraphReversed(rg, g);
		frozen = true;
	}

	/**
	 * Builds a subgraph of vertices reachable from the source
	 *
	 * @param srcVert The vertex to start from
	 * @return The reachable subgraph
	 */
	public AbstractGraph<OsateSlicerVertex, DefaultEdge> forwardReachability(String srcVert) {
		return reach(g, srcVert);
	}

	/**
	 * Builds a subgraph of vertices which can reach the target.
	 *
	 * @param tgtVert The vertex to end at
	 * @return The subgraph of nodes which can reach this one.
	 */
	public AbstractGraph<OsateSlicerVertex, DefaultEdge> backwardReachability(String tgtVert) {
		return new EdgeReversedGraph<OsateSlicerVertex, DefaultEdge>(reach(rg, tgtVert));
	}

	/**
	 * Private method to actually do the slicing / reachability
	 *
	 * @param graph The graph to operate on
	 * @param origin The vertex to begin slicing from
	 * @return The subgraph reachable from the origin
	 */
	private AsSubgraph<OsateSlicerVertex, DefaultEdge> reach(Graph<OsateSlicerVertex, DefaultEdge> graph,
			String origin) {
		BreadthFirstIterator<OsateSlicerVertex, DefaultEdge> bfi = new BreadthFirstIterator<>(graph,
				vertexMap.get(origin));
		AsSubgraph<OsateSlicerVertex, DefaultEdge> reachableSubgraph = new AsSubgraph<>(graph,
				Collections.singleton(vertexMap.get(origin)));
		bfi.next(); // Disregard root node since we already added it
		bfi.forEachRemaining(v -> {
			reachableSubgraph.addVertex(v);
			reachableSubgraph.addEdge(bfi.getParent(v), v, bfi.getSpanningTreeEdge(v));
		});
		return reachableSubgraph;
	}

	@Override
	public String toString() {
		return g.toString();
	}
}