/*******************************************************************************
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
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
