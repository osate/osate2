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
import org.osate.core.tests.instantiation.InstanceCharacterization;
import org.osate.core.tests.instantiation.InstanceIntegrity;
import org.osate.core.tests.instantiation.InstanceReport;
import org.osate.core.tests.instantiation.InstanceRun;
import org.osate.core.tests.instantiation.InstanceSnapshot;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterizes what happens where component arrays, feature arrays, and feature groups
 * meet, for issue #3037.
 *
 * <p>
 * These combinations are the ones the rest of the core test corpus does not contain, and they
 * are the ones where a feature group has to be narrowed to a member at the same time as
 * structural expansion multiplies the result across the arrays. Narrowing happens during
 * expansion, from the endpoint chains resolved at the pivot, and structural expansion then
 * replicates whatever it produced.
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
		assertConnections("GroupArrays.i", "consumers[1].bundle.ack --> producers[1].bundle.ack",
				"consumers[2].bundle.ack --> producers[2].bundle.ack",
				"producers[1].bundle.signal --> consumers[1].bundle.signal",
				"producers[2].bundle.signal --> consumers[2].bundle.signal");
		assertConnections("Top.groupArrays", "consumers[1].bundle.ack --> producers[1].bundle.ack",
				"consumers[2].bundle.ack --> producers[2].bundle.ack",
				"producers[1].bundle.signal --> consumers[1].bundle.signal",
				"producers[2].bundle.signal --> consumers[2].bundle.signal");
		assertConnections("SourceArray.i", "consumer.bundle.ack -> producers[1].bundle.ack",
				"producers[1].bundle.signal -> consumer.bundle.signal");
		assertConnections("Top.sourceArray", "consumer.bundle.ack -> producers[1].bundle.ack",
				"producers[1].bundle.signal -> consumer.bundle.signal");
		assertConnections("DestinationArray.i", "consumers[1].bundle.ack -> producer.bundle.ack",
				"producer.bundle.signal -> consumers[1].bundle.signal");
		assertConnections("Top.destinationArray", "consumers[1].bundle.ack -> producer.bundle.ack",
				"producer.bundle.signal -> consumers[1].bundle.signal");
	}

	/** Whole nested feature groups between arrays, so pairing descends before it reaches a port. */
	@Test
	public void nestedFeatureGroupsBetweenArraysAgree() throws Exception {
		assertConnections("NestedGroupArrays.i", 2, "consumers[1].nest.inner.ack --> producers[1].nest.inner.ack",
				"consumers[2].nest.inner.ack --> producers[2].nest.inner.ack",
				"producers[1].nest.inner.signal --> consumers[1].nest.inner.signal",
				"producers[2].nest.inner.signal --> consumers[2].nest.inner.signal");
		assertConnections("Top.nestedGroupArrays", 2, "consumers[1].nest.inner.ack --> producers[1].nest.inner.ack",
				"consumers[2].nest.inner.ack --> producers[2].nest.inner.ack",
				"producers[1].nest.inner.signal --> consumers[1].nest.inner.signal",
				"producers[2].nest.inner.signal --> consumers[2].nest.inner.signal");
	}

	/**
	 * A connection whose endpoint is a member of the enclosing component's boundary feature
	 * group, fed from an array and from a single thread. Both are asserted to produce one
	 * connection per producer, so neither case can pass by producing nothing.
	 */
	@Test
	public void reachingIntoABoundaryGroupMemberAgrees() throws Exception {
		assertConnections("Reacher.i", "producers[1].outp --> bundle.signal", "producers[2].outp --> bundle.signal");
		assertConnections("SoloReacher.i", "producer.outp -> bundle.signal");

	}

	/**
	 * That member with a pivot across into an inverse group, descending on both sides. The
	 * connections and flows are what 2.18.0 produced; the one difference is the warning
	 * allowlist entry 5 covers.
	 *
	 * <p>
	 * That warning described the traversal's own difficulty rather than the model. It was
	 * emitted while descending into a component whose boundary feature group has no downward
	 * declaration, and the connection was then created anyway from the other direction.
	 * Nothing is missing from the model, which is why the warning was dropped rather than
	 * reproduced.
	 * </p>
	 */
	@Test
	public void aPivotOntoAReachedIntoMemberReportsNothing() throws Exception {
		InstanceRun run = InstanceCharacterization.assertConnections(isolated, MODEL, "Top.soloReachedInto",
				"collector.consumer.bundle.ack -> reacher.bundle.ack",
				"reacher.producer.outp -> collector.consumer.bundle.signal");

		/*
		 * Allowlist entry 5. Before issue #3037 this reported "No connection declaration from feature
		 * bundle of component reacher to subcomponents. Connection instance ends at reacher", against
		 * the system instance, and created both connections anyway.
		 */
		assertEquals("allowlist entry 5: the warning is gone", List.of(),
				InstanceReport.diagnosticSet(InstanceSnapshot.of(run.instance(), run.errorManager())));
	}

	/**
	 * The same pivot fed from an array, where all but the first element is lost.
	 *
	 * <p>
	 * Two producers feed the boundary group member, so there are two connection instances
	 * across the pivot. One is instantiated. Structural expansion rejects the replication with
	 * "Too few indices for connection destination" and leaves the un-replicated provisional
	 * attached, which is why the surviving name has a single arrow rather than the double
	 * arrow of a replica. {@code Reacher.i} replicates the very same declaration correctly
	 * when the connection ends at the boundary instead of crossing the pivot, so it is the
	 * pivot that changes the outcome.
	 * </p>
	 *
	 * <p>
	 * This is what 2.18.0 produced too, so it is structural expansion's defect and not the
	 * traversal's. It is pinned here so that fixing it shows up as a failure of this test
	 * rather than as an unexplained change; the fix itself is separate work.
	 * </p>
	 */
	@Test
	public void anArrayReachingIntoAMemberAcrossAPivotLosesAllButTheFirstElement() throws Exception {
		var run = isolated.run(MODEL, "Top.reachedInto");
		var actual = InstanceSnapshot.of(run.instance(), run.errorManager());

		assertEquals("producers[2] is missing, and the survivor is the provisional connection",
				List.of("collector.consumer.bundle.ack -> reacher.bundle.ack",
						"reacher.producers[1].outp -> collector.consumer.bundle.signal"),
				connectionNames("Top.reachedInto"));

		String expansionError = "Error | Too few indices for connection destination for reacher.producers[1].outp"
				+ " -> collector.consumer.bundle.signal"
				+ " | at Top_reachedInto_Instance.reacher.producers[1].outp -> collector.consumer.bundle.signal"
				+ "|ConnectionInstance | in ArraysAndFeatureGroups_Top_reachedInto_Instance.aaxl2";
		/*
		 * Allowlist entry 5 again: before issue #3037 "No connection declaration from feature bundle
		 * of component reacher to subcomponents. Connection instance ends at reacher" accompanied the
		 * expansion error, which is the report that actually describes the model.
		 */
		assertEquals("the expansion error is what remains", List.of(expansionError),
				InstanceReport.diagnosticSet(actual));
	}

	/** Arrays, nested inverse feature groups, and a structural pattern at once. */
	@Test
	public void arraysNestedGroupsAndAPatternAgree() throws Exception {
		assertConnections("Patterned.i", 4, "consumers[1].nest.inner.ack --> producers[1].nest.inner.ack",
				"consumers[1].nest.inner.ack --> producers[2].nest.inner.ack",
				"consumers[2].nest.inner.ack --> producers[1].nest.inner.ack",
				"consumers[2].nest.inner.ack --> producers[2].nest.inner.ack",
				"producers[1].nest.inner.signal --> consumers[1].nest.inner.signal",
				"producers[1].nest.inner.signal --> consumers[2].nest.inner.signal",
				"producers[2].nest.inner.signal --> consumers[1].nest.inner.signal",
				"producers[2].nest.inner.signal --> consumers[2].nest.inner.signal");
		assertConnections("Top.patterned", 4, "consumers[1].nest.inner.ack --> producers[1].nest.inner.ack",
				"consumers[1].nest.inner.ack --> producers[2].nest.inner.ack",
				"consumers[2].nest.inner.ack --> producers[1].nest.inner.ack",
				"consumers[2].nest.inner.ack --> producers[2].nest.inner.ack",
				"producers[1].nest.inner.signal --> consumers[1].nest.inner.signal",
				"producers[1].nest.inner.signal --> consumers[2].nest.inner.signal",
				"producers[2].nest.inner.signal --> consumers[1].nest.inner.signal",
				"producers[2].nest.inner.signal --> consumers[2].nest.inner.signal");
	}

	private void assertConnections(String implementation, String... expected) throws Exception {
		InstanceCharacterization.assertConnections(isolated, MODEL, implementation, expected);
	}

	private void assertConnections(String implementation, int staleReferences, String... expected) throws Exception {
		InstanceCharacterization.assertConnectionsWithStaleArrayReferences(isolated, MODEL, implementation,
				staleReferences, expected);
	}

	/** The across-first connection instance names, sorted, so a count cannot pass vacuously. */
	private List<String> connectionNames(String implementation) throws Exception {
		var run = isolated.run(MODEL, implementation);
		return run.instance()
				.getAllConnectionInstances()
				.stream()
				.map(connection -> connection.getName())
				.sorted()
				.toList();
	}
}
