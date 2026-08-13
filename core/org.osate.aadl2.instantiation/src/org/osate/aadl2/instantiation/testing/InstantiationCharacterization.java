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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.instantiation.internal.ConnectionTraversalStrategy;
import org.osate.aadl2.instantiation.internal.TraversalObservations;
import org.osate.aadl2.instantiation.internal.TraversalObservations.Counter;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;

/**
 * Runs complete, isolated instantiations under a selected connection traversal
 * strategy, for characterization and differential testing.
 *
 * <p>
 * This is temporary migration support for the across-first connection traversal
 * work. Its package is exported only to {@code org.osate.core.tests}, and the
 * whole facade is removed once source-first traversal is gone.
 * </p>
 *
 * <p>
 * The run instantiates into the resource set that already owns the given
 * implementation, and the <em>caller</em> owns isolation, because loading an AADL
 * model needs the Xtext resource machinery and the plug-in contributed packages,
 * which belong to the test bundle. When two strategies are compared, each must be
 * given an implementation from its own freshly loaded resource set, so no EMF object
 * identity is shared and comparison relies on stable keys.
 * </p>
 *
 * <p>
 * {@code InstantiateModel.instantiate} would collide with itself on a repeated
 * run, because it always creates the instance resource at the same instance model
 * URI. This facade discards an existing resource at that URI first, so repeating a
 * run in one resource set is safe.
 * </p>
 *
 * <p>
 * Diagnostics are collected by a queuing in-memory error manager rather than
 * workspace markers, so that two runs report independently and comparably.
 * </p>
 */
public final class InstantiationCharacterization {

	private InstantiationCharacterization() {
	}

	/**
	 * Instantiate {@code implementation} with the given strategy, recording counters
	 * and timings but not individual duplicate-candidate observations.
	 *
	 * @param implementation the component implementation to instantiate, in the
	 *            resource set the caller wants the instance model created in
	 * @param strategyName {@code "SOURCE_FIRST"} or {@code "ACROSS_FIRST"}
	 */
	public static CharacterizationRun run(ComponentImplementation implementation, String strategyName)
			throws Exception {
		return run(implementation, strategyName, false);
	}

	/**
	 * Instantiate {@code implementation} with the given strategy.
	 *
	 * @param implementation the component implementation to instantiate, in the
	 *            resource set the caller wants the instance model created in
	 * @param strategyName {@code "SOURCE_FIRST"} or {@code "ACROSS_FIRST"}
	 * @param observeDuplicateCandidates whether to keep every candidate offered to
	 *            the duplicate check. Off by default, because the list costs memory
	 *            proportional to the number of candidates.
	 * @return the materialized model, its diagnostics, and the run's measurements
	 * @throws IllegalArgumentException if the strategy name is not a known strategy
	 */
	public static CharacterizationRun run(ComponentImplementation implementation, String strategyName,
			boolean observeDuplicateCandidates) throws Exception {
		ConnectionTraversalStrategy strategy = parse(strategyName);
		TraversalObservations observations = observeDuplicateCandidates ? TraversalObservations.recordingWithCandidates()
				: TraversalObservations.recording();

		ResourceSet resourceSet = implementation.eResource().getResourceSet();
		URI instanceURI = InstantiateModel.getInstanceModelURI(implementation);
		Resource previous = resourceSet.getResource(instanceURI, false);
		if (previous != null) {
			previous.unload();
			resourceSet.getResources().remove(previous);
		}
		Resource instanceResource = resourceSet.createResource(instanceURI);

		AnalysisErrorReporterManager errorManager = new AnalysisErrorReporterManager(
				QueuingAnalysisErrorReporter.factory);
		InstantiateModel instantiator = InstantiateModel.forCharacterization(new NullProgressMonitor(), errorManager,
				strategy, observations);
		SystemInstance instance = instantiator.createSystemInstanceInt(implementation, instanceResource, false);

		return new CharacterizationRun(instance, errorManager, strategy.name(), counters(observations),
				observations.connectionPhaseNanos(), observations.traversalNanos(),
				observations.duplicateCandidates(), observations.seedKeys(), observations.legKeys(), observations.pathKeys(), observations.expandedKeys());
	}

	private static ConnectionTraversalStrategy parse(String strategyName) {
		for (ConnectionTraversalStrategy candidate : ConnectionTraversalStrategy.values()) {
			if (candidate.name().equals(strategyName)) {
				return candidate;
			}
		}
		throw new IllegalArgumentException("Unknown connection traversal strategy: " + strategyName);
	}

	private static Map<String, Long> counters(TraversalObservations observations) {
		Map<String, Long> counters = new HashMap<>();
		for (Counter counter : Counter.values()) {
			counters.put(counter.name(), observations.count(counter));
		}
		return counters;
	}
}
