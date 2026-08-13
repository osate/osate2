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
package org.osate.aadl2.instantiation.internal;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.instantiation.testing.DuplicateCandidateObservation;

/**
 * Measurements and observations collected from one instantiation run's connection
 * phase.
 *
 * <p>
 * This exists so that source-first and across-first traversal can be compared on
 * comparable numbers, and so that the candidates suppressed by the reverse-order
 * duplicate check can be inspected at all. It is temporary migration support and
 * is removed once across-first traversal is the only strategy.
 * </p>
 *
 * <p>
 * Recording is off unless a caller explicitly asks for it, so production
 * instantiation pays only a field read per counter. An instance belongs to one
 * instantiation run and is not thread safe; runs never share one.
 * </p>
 */
public final class TraversalObservations {
	/** What the connection phase counts. */
	public enum Counter {
		/** Connection declarations examined as possible path continuations. */
		DECLARATIONS_EXAMINED,

		/**
		 * Attempts to extend a partial semantic connection by one oriented
		 * declarative segment. This is the unit that has to mean the same thing for
		 * both strategies, so that their state counts can be compared: source-first
		 * counts it when appending a segment, across-first when extending a leg.
		 */
		TRAVERSAL_STATES,

		/** Attempts to join a source leg with a destination leg. Across-first only. */
		JOIN_CANDIDATES,

		/** Complete semantic paths handed to materialization. */
		FINAL_PATHS,

		/** Candidates offered to the duplicate check, whether accepted or suppressed. */
		DUPLICATE_CANDIDATES,

		/** Traversal seeds discovered: across declarations and boundary features. */
		SEEDS_DISCOVERED,

		/** Legs resolved from a seed endpoint, counting every branch separately. */
		LEGS_RESOLVED,

		/** Whole paths assembled by joining legs, after identity deduplication. */
		PATHS_ASSEMBLED
	}

	private static final TraversalObservations DISABLED = new TraversalObservations(false, false);

	private final boolean recording;
	private final boolean collectingCandidates;
	private final Map<Counter, Long> counters = new EnumMap<>(Counter.class);
	private final List<DuplicateCandidateObservation> duplicateCandidates = new ArrayList<>();
	private final List<String> seedKeys = new ArrayList<>();
	private final List<String> legKeys = new ArrayList<>();
	private final List<String> pathKeys = new ArrayList<>();

	private long connectionPhaseNanos;
	private long connectionPhaseStart = -1;
	private long traversalNanos;
	private long traversalStart = -1;

	private TraversalObservations(boolean recording, boolean collectingCandidates) {
		this.recording = recording;
		this.collectingCandidates = collectingCandidates;
	}

	/**
	 * The shared do-nothing instance used by production instantiation. Every
	 * mutator returns immediately, so the instance can be shared across concurrent
	 * runs.
	 */
	public static TraversalObservations disabled() {
		return DISABLED;
	}

	/** A fresh instance recording counters and timings for one instantiation run. */
	public static TraversalObservations recording() {
		return new TraversalObservations(true, false);
	}

	/**
	 * A fresh instance that also keeps every duplicate-candidate observation.
	 * Separate from {@link #recording()} because the candidate list costs memory
	 * proportional to the number of candidates a model produces.
	 */
	public static TraversalObservations recordingWithCandidates() {
		return new TraversalObservations(true, true);
	}

	public boolean isRecording() {
		return recording;
	}

	/** Whether individual candidate observations are kept, not just counted. */
	public boolean isCollectingCandidates() {
		return collectingCandidates;
	}

	public void increment(Counter counter) {
		if (recording) {
			counters.merge(counter, 1L, Long::sum);
		}
	}

	public long count(Counter counter) {
		return counters.getOrDefault(counter, 0L);
	}

	/**
	 * Record a candidate connection and the duplicate check's decision about it.
	 * The candidate is built by the traversal, which is the only code that can see
	 * its intermediate state; nothing here touches EMF.
	 */
	public void addDuplicateCandidate(DuplicateCandidateObservation candidate) {
		increment(Counter.DUPLICATE_CANDIDATES);
		if (collectingCandidates) {
			duplicateCandidates.add(candidate);
		}
	}

	/**
	 * Record a discovered traversal seed by its stable key.
	 *
	 * <p>
	 * Across-first seed discovery is run under either strategy while it is being
	 * developed, so that it can be checked against real models before legs and joining
	 * exist. Only the keys are kept, never the seeds themselves, so no internal type
	 * escapes and nothing observes EMF state after its resource set is gone.
	 * </p>
	 */
	public void addSeed(String key) {
		increment(Counter.SEEDS_DISCOVERED);
		if (recording) {
			seedKeys.add(key);
		}
	}

	/** The discovered seed keys, in discovery order. */
	public List<String> seedKeys() {
		return List.copyOf(seedKeys);
	}

	/**
	 * Record a resolved leg by its stable key. Temporary, for the same reason as
	 * {@link #addSeed(String)}: legs can be checked against real models before joining
	 * exists.
	 */
	public void addLeg(String key) {
		increment(Counter.LEGS_RESOLVED);
		if (recording) {
			legKeys.add(key);
		}
	}

	/** The resolved leg keys, in resolution order. */
	public List<String> legKeys() {
		return List.copyOf(legKeys);
	}

	/**
	 * Record an assembled path by its rendered identity. Temporary, for the same reason
	 * as {@link #addSeed(String)}.
	 */
	public void addPath(String key) {
		increment(Counter.PATHS_ASSEMBLED);
		if (recording) {
			pathKeys.add(key);
		}
	}

	/** The assembled path keys, in assembly order. */
	public List<String> pathKeys() {
		return List.copyOf(pathKeys);
	}

	/** The observed candidates, in the order the traversal offered them. */
	public List<DuplicateCandidateObservation> duplicateCandidates() {
		return List.copyOf(duplicateCandidates);
	}

	/**
	 * Start the connection-phase measurement. The phase covers path enumeration,
	 * structural expansion, final materialization, mode and SOM assignment,
	 * deletion of inactive connections, and connection validation, and stops before
	 * end-to-end flow creation.
	 */
	public void startConnectionPhase() {
		if (recording) {
			connectionPhaseStart = System.nanoTime();
		}
	}

	public void stopConnectionPhase() {
		if (recording && connectionPhaseStart >= 0) {
			connectionPhaseNanos += System.nanoTime() - connectionPhaseStart;
			connectionPhaseStart = -1;
		}
	}

	/**
	 * Start the traversal-only measurement, which covers path enumeration alone.
	 * Expansion, modes, and validation are shared by both strategies and would mask
	 * a traversal regression inside a passing phase-level ratio.
	 */
	public void startTraversal() {
		if (recording) {
			traversalStart = System.nanoTime();
		}
	}

	public void stopTraversal() {
		if (recording && traversalStart >= 0) {
			traversalNanos += System.nanoTime() - traversalStart;
			traversalStart = -1;
		}
	}

	public long connectionPhaseNanos() {
		return connectionPhaseNanos;
	}

	public long traversalNanos() {
		return traversalNanos;
	}
}
