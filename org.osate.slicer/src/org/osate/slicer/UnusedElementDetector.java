package org.osate.slicer;

import java.util.HashSet;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;
import org.osate.aadl2.Property;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

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
				}
			} while (iterator.hasNext());
		}
	}

	/**
	 * Checks to make sure every error sink has a label saying it is acceptable using the fault impact property set.
	 *
	 * @return boolean Returns true if each error sink is labeled correctly, otherwise returns false.
	 */
	public boolean checkSinkLabel() {
		Property sinkAcceptability;
		var sinkVertices = g.vertexSet()
				.stream()
				.filter(v -> v.getIObj() instanceof ErrorSinkInstance)
				.collect(Collectors.toSet());
		for (var v : sinkVertices) {
			ErrorSinkInstance esi = (ErrorSinkInstance) v.getIObj();
			sinkAcceptability = Faultimpactanalysisproperties.getAcceptable_Property(esi);

			if (!PropertyUtils.getBooleanValue(esi, sinkAcceptability)) {
				return false;
			}

//			TODO: Once slicer is merged into master, change to the code below
//			if (!Faultimpactanalysisproperties.getAcceptable(esi).orElse(false)) {
//				return false;
//			}

		}

		return true;
	}

	/**
	 * Returns the results for whether each sink is reachable and whether all sources terminate.
	 * @return AssumptionCheckResult
	 */
	public AssumptionCheckResult getResult() {
		return this.result;
	}

	public AssumptionCheckResult checkAssumptions() {
		calculateUnusedElements();
		return result;
	}
}
