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
package org.osate.core.tests.instantiation;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.osate.aadl2.instance.ConnectionInstance;

/**
 * Asserts what one implementation instantiates to, against the production traversal.
 *
 * <p>
 * The record is the sorted connection instance names, which name their endpoints relative to
 * the container and therefore pin expansion, array replication and feature group narrowing,
 * together with the structural invariants that hold for every instance model. It is weaker
 * than comparing every field of every descriptor, which is what these tests did while issue
 * #3037 had two traversals to compare; where a specific field matters, a test asserts it
 * directly through {@link InstanceReport} rather than relying on the name.
 * </p>
 *
 * <p>
 * The names were captured from the production traversal on 2026-08-18, while the comparison
 * still ran, so each of them is a value both traversals agreed on rather than whatever the
 * code happened to do afterwards.
 * </p>
 */
public final class InstanceCharacterization {

	private InstanceCharacterization() {
	}

	/**
	 * Instantiate {@code implementation} and assert its connection instances and its
	 * structural integrity.
	 *
	 * @param expected the connection instance names, sorted
	 * @return the run, for a test that asserts more about it
	 */
	public static InstanceRun assertConnections(IsolatedInstantiation isolated, String model, String implementation,
			String... expected) throws Exception {
		var run = isolated.run(model, implementation);
		assertEquals(implementation + " connections", List.of(expected), names(run));
		assertEquals(implementation + " integrity", List.of(), InstanceIntegrity.check(run.instance()));
		return run;
	}

	/**
	 * The same, for an implementation whose array replicas carry the stale reference chains
	 * that structural expansion leaves behind.
	 *
	 * <p>
	 * Expansion re-resolves a replicated connection's reference endpoints from the
	 * declaration, so for a nested feature group the chain names array element 1 whatever
	 * element the replica belongs to. Both traversals produced that identically, which is why
	 * it is recorded here rather than repaired: it is structural expansion's to answer, and it
	 * is item 3 of the follow-up work issue #3037 hands over.
	 * </p>
	 *
	 * @param staleReferences how many replicas have a source that does not match their first
	 *            reference
	 */
	public static InstanceRun assertConnectionsWithStaleArrayReferences(IsolatedInstantiation isolated, String model,
			String implementation, int staleReferences, String... expected) throws Exception {
		var run = isolated.run(model, implementation);
		assertEquals(implementation + " connections", List.of(expected), names(run));
		var violations = InstanceIntegrity.check(run.instance());
		assertEquals(implementation + " integrity " + violations, staleReferences, violations.size());
		for (var violation : violations) {
			assertEquals(implementation + " unexpected violation: " + violation, true,
					violation.contains("does not match first reference source"));
		}
		return run;
	}

	/** The connection instance names of the whole model, sorted. */
	public static List<String> names(InstanceRun run) {
		return run.instance()
				.getAllConnectionInstances()
				.stream()
				.map(ConnectionInstance::getName)
				.sorted()
				.toList();
	}
}
