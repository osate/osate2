package org.osate.slicer;

import java.util.HashSet;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;

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
	private final String PATH_CONNECTOR = " -> ";

	public record AssumptionCheckResult(HashSet<OsateSlicerVertex> nonTerminatingSourceVertices,
			HashSet<OsateSlicerVertex> unreachableSinkVertices) {
	};

	private final AssumptionCheckResult result = new AssumptionCheckResult(new HashSet<>(), new HashSet<>());

	public UnusedElementDetector(Graph<OsateSlicerVertex, DefaultEdge> g, Graph<OsateSlicerVertex, DefaultEdge> rg) {
		this.g = g;
		this.rg = rg;
	}

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
			OsateSlicerVertex current;
			do {
				current = iterator.next();
				path.append(PATH_CONNECTOR);
				path.append(current.getName());
				if ((g.outDegreeOf(current) == 0) && !(current.getIObj() instanceof ErrorSinkInstance)) {
					result.nonTerminatingSourceVertices().add(v);
					System.err.println(path.toString());
				}
			} while (iterator.hasNext());
		}
		for (var v : sinkVertices) {
			var iterator = new DepthFirstIterator<>(rg, v);
			path.setLength(0);
			OsateSlicerVertex current;
			do {
				current = iterator.next();
				path.append(PATH_CONNECTOR);
				path.append(current.getName());
				if ((rg.outDegreeOf(current) == 0) && !(current.getIObj() instanceof ErrorSourceInstance)) {
					result.unreachableSinkVertices().add(v);
					System.err.println(path.toString());
				}
			} while (iterator.hasNext());
		}
	}

	public AssumptionCheckResult checkAssumptions() {
		calculateUnusedElements();
		return result;
	}
}
