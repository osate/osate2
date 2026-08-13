/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.instantiation.testing;

import java.util.List;
import java.util.Map;

import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

/**
 * The result of one isolated instantiation run performed for characterization.
 *
 * <p>
 * The run returns the normal materialized instance model and its diagnostics.
 * Internal traversal types are deliberately not exposed: source-first traversal
 * never builds a path list, so there is nothing equivalent to compare, and
 * comparing complete materialized models is both possible and stronger.
 * </p>
 *
 * @param instance the instantiated model, in its own resource set
 * @param errorManager the queuing in-memory error manager the run reported to
 * @param strategy the name of the strategy that produced the model
 * @param counters connection-phase counters, keyed by counter name
 * @param connectionPhaseNanos elapsed time of the whole connection phase
 * @param traversalNanos elapsed time of path enumeration alone
 * @param duplicateCandidates candidates seen by the duplicate check, in the order
 *            the traversal offered them; empty unless candidate observation was
 *            requested
 * @param seedKeys the across-first traversal seeds discovered for this model, by
 *            stable key. Temporary: seed discovery is exercised under either
 *            strategy while the across-first builder is incomplete
 */
public record CharacterizationRun(SystemInstance instance, AnalysisErrorReporterManager errorManager, String strategy,
		Map<String, Long> counters, long connectionPhaseNanos, long traversalNanos,
		List<DuplicateCandidateObservation> duplicateCandidates, List<String> seedKeys) {

	public CharacterizationRun {
		counters = Map.copyOf(counters);
		duplicateCandidates = List.copyOf(duplicateCandidates);
		seedKeys = List.copyOf(seedKeys);
	}

	/** The candidates the duplicate check let through. */
	public List<DuplicateCandidateObservation> acceptedCandidates() {
		return duplicateCandidates.stream().filter(DuplicateCandidateObservation::accepted).toList();
	}

	/**
	 * The candidates the duplicate check removed. Whether these differ from the
	 * accepted ones in any field that could reach a materialized descriptor is what
	 * decides whether across-first traversal needs a survivor rule at all.
	 */
	public List<DuplicateCandidateObservation> suppressedCandidates() {
		return duplicateCandidates.stream().filter(candidate -> !candidate.accepted()).toList();
	}
}
