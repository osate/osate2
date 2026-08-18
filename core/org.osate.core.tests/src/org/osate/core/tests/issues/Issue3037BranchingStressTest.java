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
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.instantiation.testing.CharacterizationRun;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.core.tests.instantiation.StrategyDifference;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * The gated part of the performance budget for issue #3037: the traversal state counts that
 * do not depend on the machine.
 *
 * <p>
 * Wall-clock and allocation budgets cannot be asserted in a reactor build, so they are
 * measured by {@code AcrossFirstBenchmark} and reported as evidence. What is asserted here is
 * the deterministic part: how much work each strategy does on the same branching shape at
 * three widths, and that the result is the number of connection instances the shape says it
 * should be, computed from the width rather than copied from a run.
 * </p>
 *
 * <p>
 * The state counts are frozen from the measured curve. They are an upper bound on across-first
 * work relative to source-first on the same model, which is what the plan's abort criterion
 * needs: growth that changes shape, rather than a number that drifts, is what has to fail.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037BranchingStressTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3037/AcrossFirstBranchingStress.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private IsolatedInstantiation isolated;

	@Test
	public void theFixtureIsValid() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(MODEL));
	}

	/**
	 * The shape produces one connection instance per pair of branches, and both strategies
	 * produce the same model at every width.
	 */
	@Test
	public void everyBranchPairBecomesOneConnection() throws Exception {
		for (int width : new int[] { 2, 4, 8 }) {
			String implementation = "Top.width" + width;
			StrategyDifference.assertSameModel(isolated, MODEL, implementation);
			assertEquals(implementation, width * width,
					isolated.run(MODEL, implementation, "ACROSS_FIRST", false)
							.instance()
							.getAllConnectionInstances()
							.size());
		}
	}

	/**
	 * The calibration curve, as gated numbers. Recorded from measurement and frozen: the
	 * traversal states each strategy spends, and the joins and paths across-first adds, at
	 * branch widths 2, 4, and 8.
	 */
	@Test
	public void theStateCountCurveIsFrozen() throws Exception {
		Map<String, Long> expected = new LinkedHashMap<>();
		for (int width : new int[] { 2, 4, 8 }) {
			String implementation = "Top.width" + width;
			CharacterizationRun sourceFirst = isolated.run(MODEL, implementation, "SOURCE_FIRST", false);
			CharacterizationRun acrossFirst = isolated.run(MODEL, implementation, "ACROSS_FIRST", false);
			expected.put(width + " sourceFirst TRAVERSAL_STATES", count(sourceFirst, "TRAVERSAL_STATES"));
			expected.put(width + " acrossFirst TRAVERSAL_STATES", count(acrossFirst, "TRAVERSAL_STATES"));
			expected.put(width + " acrossFirst JOIN_CANDIDATES", count(acrossFirst, "JOIN_CANDIDATES"));
			expected.put(width + " acrossFirst PATHS_ASSEMBLED", count(acrossFirst, "PATHS_ASSEMBLED"));
			expected.put(width + " acrossFirst FINAL_PATHS", count(acrossFirst, "FINAL_PATHS"));
		}
		assertEquals(FROZEN_CURVE, expected);

		/*
		 * The relations the frozen numbers stand for, asserted separately so that a change of
		 * shape fails even if someone re-freezes the numbers. Across-first may not spend more
		 * traversal states than source-first on the same model, its joins may not exceed the
		 * number of connections the shape has, and every joined pair must become a path.
		 */
		for (int width : new int[] { 2, 4, 8 }) {
			long paths = (long) width * width;
			assertTrue("across-first states at width " + width,
					expected.get(width + " acrossFirst TRAVERSAL_STATES") <= expected
							.get(width + " sourceFirst TRAVERSAL_STATES"));
			assertTrue("joins at width " + width, expected.get(width + " acrossFirst JOIN_CANDIDATES") <= paths);
			assertEquals("paths at width " + width, paths, (long) expected.get(width + " acrossFirst PATHS_ASSEMBLED"));
			assertEquals("final paths at width " + width, paths, (long) expected.get(width + " acrossFirst FINAL_PATHS"));
		}
	}

	/**
	 * Measured on 2026-08-18 and frozen. Across-first spends traversal states linearly in the
	 * width, 2w + 2, because each branch is walked once and the pairs are formed afterwards;
	 * source-first spends w<sup>2</sup> + 4w, because it re-walks the shared part of the path
	 * for every pair. The joins across-first adds are exactly w<sup>2</sup>, which is the
	 * number of connections the shape has, so the Cartesian product wastes nothing here.
	 */
	private static final Map<String, Long> FROZEN_CURVE = Map.ofEntries(
			Map.entry("2 sourceFirst TRAVERSAL_STATES", 12L), Map.entry("2 acrossFirst TRAVERSAL_STATES", 6L),
			Map.entry("2 acrossFirst JOIN_CANDIDATES", 4L), Map.entry("2 acrossFirst PATHS_ASSEMBLED", 4L),
			Map.entry("2 acrossFirst FINAL_PATHS", 4L), Map.entry("4 sourceFirst TRAVERSAL_STATES", 32L),
			Map.entry("4 acrossFirst TRAVERSAL_STATES", 10L), Map.entry("4 acrossFirst JOIN_CANDIDATES", 16L),
			Map.entry("4 acrossFirst PATHS_ASSEMBLED", 16L), Map.entry("4 acrossFirst FINAL_PATHS", 16L),
			Map.entry("8 sourceFirst TRAVERSAL_STATES", 96L), Map.entry("8 acrossFirst TRAVERSAL_STATES", 18L),
			Map.entry("8 acrossFirst JOIN_CANDIDATES", 64L), Map.entry("8 acrossFirst PATHS_ASSEMBLED", 64L),
			Map.entry("8 acrossFirst FINAL_PATHS", 64L));

	private static long count(CharacterizationRun run, String counter) {
		return run.counters().getOrDefault(counter, 0L);
	}
}
