package org.osate.slicer.assumptions;

import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;
import org.osate.slicer.OsateSlicerVertex;

/**
 * This class calculates elements in the graph that are not used, but possibly should be.
 *
 * These elements include:
 * * Error sources which propagate along paths that do not terminate in sinks
 * * Error sinks which terminate paths that do not begin at sources
 *
 * @author sprocter
 *
 */
public class UnusedElementDetector {

	private Graph<OsateSlicerVertex, DefaultEdge> g, rg;
	private boolean calculationsComplete = false;
//	private UnusedElementListener uel = new UnusedElementListener();
	private final String PATH_CONNECTOR = " -> ";
	private final AssumptionCheckResult result = new AssumptionCheckResult();

	public UnusedElementDetector(Graph<OsateSlicerVertex, DefaultEdge> g, Graph<OsateSlicerVertex, DefaultEdge> rg) {
		this.g = g;
		this.rg = rg;
	}

//	public Collection<DefaultEdge> getUnusedEdges() {
//		if (!calculationsComplete) {
//			calculateUnusedElements();
//		}
//		Set<DefaultEdge> ret = new HashSet<>(g.edgeSet());
//		ret.removeAll(uel.getTraversedEdges());
//		return ret;
//	}
//
//	public Collection<OsateSlicerVertex> getUnusedVertices() {
//		if (!calculationsComplete) {
//			calculateUnusedElements();
//		}
//		Set<OsateSlicerVertex> ret = new HashSet<>(g.vertexSet());
//		ret.removeAll(uel.getTraversedVertices());
//		return ret;
//	}

	private void calculateUnusedElements() {
		var path = new StringBuilder();
		var sourceVertices = g.vertexSet()
				.stream()
				.filter(v -> v.getIObj() instanceof ErrorSourceInstance)
				.collect(Collectors.toSet());
		var sinkVertices = g.vertexSet()
				.stream()
				.filter(v -> v.getIObj() instanceof ErrorSinkInstance)
				.collect(Collectors.toSet());
		for (var v : sourceVertices) {
			var iterator = new DepthFirstIterator<>(g, v);
			path.setLength(0);
//			iterator.addTraversalListener(uel);
			var current = iterator.next();
			path.append(current.getName());
			while (iterator.hasNext()) {
				current = iterator.next();
				path.append(PATH_CONNECTOR);
				path.append(current.getName());
			}
			if (!(current.getIObj() instanceof ErrorSinkInstance)) {
				result.addNonTerminatingSourceVertex(v);
				System.err.println(path.toString());
			}
		}
		for (var v : sinkVertices) {
			var iterator = new DepthFirstIterator<>(rg, v);
			path.setLength(0);
//			iterator.addTraversalListener(uel);
			var current = iterator.next();
			path.append(current.getName());
			while (iterator.hasNext()) {
				current = iterator.next();
				path.append(PATH_CONNECTOR);
				path.append(current.getName());
			}
			if (!(current.getIObj() instanceof ErrorSourceInstance)) {
				result.addUnreachableSinkVertex(v);
				System.err.println(path.toString());
			}
		}
		calculationsComplete = true;
	}

//	private class UnusedElementListener extends TraversalListenerAdapter<OsateSlicerVertex, DefaultEdge> {
//
//		private Set<DefaultEdge> traversedEdges = new HashSet<>();
//		private Set<OsateSlicerVertex> traversedVertices = new HashSet<>();
//
//		@Override
//		public void edgeTraversed(EdgeTraversalEvent<DefaultEdge> e) {
//			traversedEdges.add(e.getEdge());
//		}
//
//		@Override
//		public void vertexTraversed(VertexTraversalEvent<OsateSlicerVertex> e) {
//			traversedVertices.add(e.getVertex());
//		}
//
//		public Set<DefaultEdge> getTraversedEdges() {
//			return traversedEdges;
//		}
//
//		public Set<OsateSlicerVertex> getTraversedVertices() {
//			return traversedVertices;
//		}
//	}

	public AssumptionCheckResult checkAssumptions() {
		calculateUnusedElements();
		return result;
	}
}
