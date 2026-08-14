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

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.instantiation.testing.CharacterizationRun;
import org.osate.core.tests.instantiation.InstanceIntegrity;
import org.osate.core.tests.instantiation.InstanceReport;
import org.osate.core.tests.instantiation.InstanceSnapshot;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.core.tests.instantiation.StrategyDifference;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Compares the two traversal strategies where component arrays, feature arrays, and
 * feature groups meet, for issue #3037.
 *
 * <p>
 * These combinations are the ones the rest of the core test corpus does not contain, and
 * they are where the two strategies differ most in what they know when: source-first
 * narrows a feature group after reaching a destination, using two shared stacks, while
 * across-first resolves both endpoint chains at the pivot and narrows during expansion.
 * Structural expansion then multiplies whatever either produced across the arrays.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037ArrayFeatureGroupTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3037/ArraysAndFeatureGroups.aadl";

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

	/** Whole feature groups connected between arrays, on both endpoints and on each alone. */
	@Test
	public void featureGroupsBetweenArraysAgree() throws Exception {
		assertSameModel("GroupArrays.i");
		assertSameModel("Top.groupArrays");
		assertSameModel("SourceArray.i");
		assertSameModel("Top.sourceArray");
		assertSameModel("DestinationArray.i");
		assertSameModel("Top.destinationArray");
	}

	/** Whole nested feature groups between arrays, so pairing descends before it reaches a port. */
	@Test
	public void nestedFeatureGroupsBetweenArraysAgree() throws Exception {
		assertSameModel("NestedGroupArrays.i");
		assertSameModel("Top.nestedGroupArrays");
	}

	/**
	 * A connection whose endpoint is a member of the enclosing component's boundary feature
	 * group, fed from an array and from a single thread. Both are asserted to produce one
	 * connection per producer, so neither case can pass by producing nothing.
	 */
	@Test
	public void reachingIntoABoundaryGroupMemberAgrees() throws Exception {
		assertSameModel("Reacher.i");
		assertSameModel("SoloReacher.i");

		assertEquals(List.of("producers[1].outp --> bundle.signal", "producers[2].outp --> bundle.signal"),
				connectionNames("Reacher.i"));
		assertEquals(List.of("producer.outp -> bundle.signal"), connectionNames("SoloReacher.i"));
	}

	/**
	 * That member with a pivot across into an inverse group, descending on both sides. The
	 * connections and flows agree; the only difference is the warning allowlist entry 5
	 * covers.
	 *
	 * <p>
	 * That warning disappearing was approved on 2026-08-14. It describes the traversal's own
	 * difficulty rather than the model: source-first emits it while descending into a
	 * component whose boundary feature group has no downward declaration, and then creates the
	 * connection anyway, from the other direction. Nothing is missing from the model, which is
	 * why the warning may be dropped rather than reproduced.
	 * </p>
	 */
	@Test
	public void aPivotOntoAReachedIntoMemberDropsOnlyTheSourceFirstWarning() throws Exception {
		CharacterizationRun sourceFirst = isolated.run(MODEL, "Top.soloReachedInto", "SOURCE_FIRST", false);
		CharacterizationRun acrossFirst = isolated.run(MODEL, "Top.soloReachedInto", "ACROSS_FIRST", false);
		InstanceSnapshot expected = InstanceSnapshot.of(sourceFirst.instance(), sourceFirst.errorManager());
		InstanceSnapshot actual = InstanceSnapshot.of(acrossFirst.instance(), acrossFirst.errorManager());

		assertEquals(InstanceReport.connectionLines(expected), InstanceReport.connectionLines(actual));
		assertEquals(InstanceReport.flowLines(expected), InstanceReport.flowLines(actual));
		assertEquals(InstanceIntegrity.check(sourceFirst.instance()), InstanceIntegrity.check(acrossFirst.instance()));
		assertEquals(List.of("collector.consumer.bundle.ack -> reacher.bundle.ack",
				"reacher.producer.outp -> collector.consumer.bundle.signal"),
				connectionNames("Top.soloReachedInto"));

		assertEquals(List.of("Warning | No connection declaration from feature bundle of component reacher to"
				+ " subcomponents. Connection instance ends at reacher"
				+ " | at Top_soloReachedInto_Instance|SystemInstance"
				+ " | in ArraysAndFeatureGroups_Top_soloReachedInto_Instance.aaxl2"),
				InstanceReport.diagnosticSet(expected));
		assertEquals("allowlist entry 5: the warning disappears", List.of(),
				InstanceReport.diagnosticSet(actual));
	}

	/**
	 * The same pivot fed from an array, where the baseline loses all but the first element.
	 *
	 * <p>
	 * Two producers feed the boundary group member, so there are two semantic connections
	 * across the pivot. One is instantiated. Structural expansion rejects the replication with
	 * "Too few indices for connection destination" and leaves the un-replicated provisional
	 * attached, which is why the surviving name has a single arrow rather than the double
	 * arrow of a replica. {@code Reacher.i} replicates the very same declaration correctly
	 * when the connection ends at the boundary instead of crossing the pivot, so it is the
	 * pivot that changes the outcome.
	 * </p>
	 *
	 * <p>
	 * Both strategies produce this identically, so it is baseline behavior and not
	 * across-first's to fix. It is pinned here so that a fix shows up as a failure of this
	 * test rather than as an unexplained change, and it is recorded in the plan as work to
	 * raise separately.
	 * </p>
	 */
	@Test
	public void anArrayReachingIntoAMemberAcrossAPivotLosesAllButTheFirstElement() throws Exception {
		CharacterizationRun sourceFirst = isolated.run(MODEL, "Top.reachedInto", "SOURCE_FIRST", false);
		CharacterizationRun acrossFirst = isolated.run(MODEL, "Top.reachedInto", "ACROSS_FIRST", false);
		InstanceSnapshot expected = InstanceSnapshot.of(sourceFirst.instance(), sourceFirst.errorManager());
		InstanceSnapshot actual = InstanceSnapshot.of(acrossFirst.instance(), acrossFirst.errorManager());

		assertEquals(InstanceReport.connectionLines(expected), InstanceReport.connectionLines(actual));
		assertEquals(InstanceIntegrity.check(sourceFirst.instance()), InstanceIntegrity.check(acrossFirst.instance()));

		assertEquals("producers[2] is missing, and the survivor is the provisional connection",
				List.of("collector.consumer.bundle.ack -> reacher.bundle.ack",
						"reacher.producers[1].outp -> collector.consumer.bundle.signal"),
				connectionNames("Top.reachedInto"));

		String expansionError = "Error | Too few indices for connection destination for reacher.producers[1].outp"
				+ " -> collector.consumer.bundle.signal"
				+ " | at Top_reachedInto_Instance.reacher.producers[1].outp -> collector.consumer.bundle.signal"
				+ "|ConnectionInstance | in ArraysAndFeatureGroups_Top_reachedInto_Instance.aaxl2";
		assertEquals(List.of(expansionError,
				"Warning | No connection declaration from feature bundle of component reacher to subcomponents."
						+ " Connection instance ends at reacher"
						+ " | at Top_reachedInto_Instance|SystemInstance"
						+ " | in ArraysAndFeatureGroups_Top_reachedInto_Instance.aaxl2"),
				InstanceReport.diagnosticSet(expected));
		assertEquals("allowlist entry 5, over the shared expansion error", List.of(expansionError),
				InstanceReport.diagnosticSet(actual));
	}

	/** Arrays, nested inverse feature groups, and a structural pattern at once. */
	@Test
	public void arraysNestedGroupsAndAPatternAgree() throws Exception {
		assertSameModel("Patterned.i");
		assertSameModel("Top.patterned");
	}

	private void assertSameModel(String implementation) throws Exception {
		StrategyDifference.assertSameModel(isolated, MODEL, implementation);
	}

	/** The across-first connection instance names, sorted, so a count cannot pass vacuously. */
	private List<String> connectionNames(String implementation) throws Exception {
		CharacterizationRun run = isolated.run(MODEL, implementation, "ACROSS_FIRST", false);
		return run.instance()
				.getAllConnectionInstances()
				.stream()
				.map(connection -> connection.getName())
				.sorted()
				.toList();
	}
}
