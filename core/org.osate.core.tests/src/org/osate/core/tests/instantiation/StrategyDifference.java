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

import org.osate.aadl2.instantiation.testing.CharacterizationRun;

/**
 * Compares the instance models the two connection traversal strategies produce.
 *
 * <p>
 * Each strategy runs in its own resource set, so nothing rests on EMF object identity.
 * Connections, flows, and diagnostics are compared as normalized descriptors keyed on
 * structured identity, with names part of the descriptor and compared exactly.
 * </p>
 *
 * <p>
 * The structural invariants are compared rather than required to be empty. Structural
 * expansion re-resolves a replicated connection's reference endpoints from the
 * declaration, which leaves them naming the feature group, and the first array element,
 * where the connection itself names the member and the element it was replicated to. Both
 * strategies produce that identically, so requiring an empty list would fail every
 * feature group connection replicated across an array while telling us nothing about
 * across-first. What matters is that across-first introduces no violation the baseline
 * does not already have.
 * </p>
 *
 * <p>
 * Temporary migration support for the across-first work, removed with the rest of the
 * dual-strategy scaffolding.
 * </p>
 */
public final class StrategyDifference {

	private StrategyDifference() {
	}

	/**
	 * Assert that both strategies produce the same connections, flows, names, and
	 * diagnostics for one implementation, and that the across-first model is sound.
	 *
	 * @param isolated the runner that owns a fresh resource set per run
	 * @param model the fixture, as a path relative to the test workspace
	 * @param implementation the component implementation to instantiate
	 */
	public static void assertSameModel(IsolatedInstantiation isolated, String model, String implementation)
			throws Exception {
		CharacterizationRun sourceFirst = isolated.run(model, implementation, "SOURCE_FIRST", false);
		CharacterizationRun acrossFirst = isolated.run(model, implementation, "ACROSS_FIRST", false);

		InstanceSnapshot expected = InstanceSnapshot.of(sourceFirst.instance(), sourceFirst.errorManager());
		InstanceSnapshot actual = InstanceSnapshot.of(acrossFirst.instance(), acrossFirst.errorManager());

		assertEquals(implementation + " connections", InstanceReport.connectionLines(expected),
				InstanceReport.connectionLines(actual));
		assertEquals(implementation + " flows", InstanceReport.flowLines(expected), InstanceReport.flowLines(actual));
		assertEquals(implementation + " diagnostics", InstanceReport.diagnosticSet(expected),
				InstanceReport.diagnosticSet(actual));
		assertEquals(implementation + " integrity", InstanceIntegrity.check(sourceFirst.instance()),
				InstanceIntegrity.check(acrossFirst.instance()));
	}
}
