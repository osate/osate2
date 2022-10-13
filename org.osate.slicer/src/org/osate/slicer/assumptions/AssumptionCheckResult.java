package org.osate.slicer.assumptions;

import java.util.Collection;
import java.util.HashSet;

import org.osate.slicer.OsateSlicerVertex;

/**
 * This class stores the results of checking various assumptions about the graph
 *
 * @author sprocter
 *
 */
public class AssumptionCheckResult {
	/**
	 * Error sources which can propagate into paths that do not terminate in sinks.
	 */
	private Collection<OsateSlicerVertex> nonTerminatingSourceVertices = new HashSet<>();

	/**
	 * Error sinks which are not reachable from error sources.
	 */
	private Collection<OsateSlicerVertex> unreachableSinkVertices = new HashSet<>();

	public void addNonTerminatingSourceVertex(OsateSlicerVertex v) {
		nonTerminatingSourceVertices.add(v);
	}

	public void addUnreachableSinkVertex(OsateSlicerVertex v) {
		unreachableSinkVertices.add(v);
	}

	/**
	 * Gets error sources which can propagate into paths that do not terminate in sinks.
	 *
	 * @return Error source vertices which propagate tokens into paths that do not terminate in error sinks
	 */
	public Collection<OsateSlicerVertex> getNonTerminatingSourceVertices() {
		return nonTerminatingSourceVertices;
	}

	/**
	 * Gets error sinks which are not reachable from error sources.
	 *
	 * @return Error sink vertices which consume tokens via paths that do not begin in error sources
	 */
	public Collection<OsateSlicerVertex> getUnreachableSinkVertices() {
		return unreachableSinkVertices;
	}
}
