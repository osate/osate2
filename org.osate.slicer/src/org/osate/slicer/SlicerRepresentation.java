package org.osate.slicer;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.graph.AsSubgraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.EdgeReversedGraph;
import org.jgrapht.graph.MaskSubgraph;
import org.jgrapht.traverse.BreadthFirstIterator;

public class SlicerRepresentation {
	private final Graph<OsateSlicerVertex, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);
	private final Graph<OsateSlicerVertex, DefaultEdge> rg = new EdgeReversedGraph<OsateSlicerVertex, DefaultEdge>(g);
	private final Set<MaskSubgraph<OsateSlicerVertex, DefaultEdge>> subGraphs = new HashSet<>(); // memoize me, capn
	private final String name;
	private final Map<String, OsateSlicerVertex> vertexMap = new HashMap<>();

	public SlicerRepresentation(String name) {
		this.name = name;
	}

	public void addVertex(String name) {
		OsateSlicerVertex v = new OsateSlicerVertex(name);
		vertexMap.put(name, v);
		g.addVertex(v);
	}

	public void addEdge(String src, String tgt) {
		g.addEdge(vertexMap.get(src), vertexMap.get(tgt));
	}

	public AsSubgraph<OsateSlicerVertex, DefaultEdge> forwardReachability(String srcVert) {
		BreadthFirstIterator<OsateSlicerVertex, DefaultEdge> bfi = new BreadthFirstIterator<>(g, vertexMap.get(srcVert));
		AsSubgraph<OsateSlicerVertex, DefaultEdge> reachableSubgraph = new AsSubgraph<>(g, Collections.singleton(vertexMap.get(srcVert)));
		bfi.next(); // Disregard root node since we already added it
		bfi.forEachRemaining(v -> {
			reachableSubgraph.addVertex(v);
			reachableSubgraph.addEdge(bfi.getParent(v), v, bfi.getSpanningTreeEdge(v));
		});
		return reachableSubgraph;
	}

	public AsSubgraph<OsateSlicerVertex, DefaultEdge> backwardReachability(String dstVert) {
		BreadthFirstIterator<OsateSlicerVertex, DefaultEdge> bfi = new BreadthFirstIterator<>(rg, vertexMap.get(dstVert));
		AsSubgraph<OsateSlicerVertex, DefaultEdge> reachableSubgraph = new AsSubgraph<>(rg, Collections.singleton(vertexMap.get(dstVert)));
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