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
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instantiation.testing.CharacterizationRun;
import org.osate.core.tests.instantiation.InstanceReport;
import org.osate.core.tests.instantiation.InstanceSnapshot;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.core.tests.instantiation.StrategyDifference;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Compares the two strategies over the corners of feature group pairing and endpoint
 * resolution, for issue #3037.
 *
 * <p>
 * Each case isolates one decision pairing has to make and that the rest of the matrix reaches
 * only in passing: renamed members that names cannot pair, a subset destination missing one of
 * the source's members, and a group with no type at all.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037ExpansionCornerTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3037/ExpansionCorners.aadl";
	private static final String DIRECTIONS = "org.osate.core.tests/models/issue3037/DirectionCombinations.aadl";
	private static final String DIRECTIONS_UNTYPED = MODEL;
	private static final String SHORT_ACCESS = "org.osate.core.tests/models/Issue2032/ShortAccessConnections.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private IsolatedInstantiation isolated;

	@Test
	public void theFixturesAreValid() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(MODEL));
		validationHelper.assertNoIssues(testHelper.parseFile(DIRECTIONS));
	}

	/**
	 * A group with an out member, an in member, and an in out member, met across a pivot and
	 * against the root's own boundary group in both directions. Which member pairs with which is
	 * decided by direction, and what has to hold differs between a complete path and each
	 * direction of an incomplete one.
	 */
	@Test
	public void directionDecidesWhichMembersPair() throws Exception {
		StrategyDifference.assertSameModel(isolated, DIRECTIONS, "Peer.i");
		StrategyDifference.assertSameModel(isolated, DIRECTIONS, "InversePeer.i");
		StrategyDifference.assertSameModel(isolated, DIRECTIONS, "Top.peers");
		StrategyDifference.assertSameModel(isolated, DIRECTIONS, "Top.boundary");

		assertEquals(List.of("left.worker.bundle.both -> right.worker.bundle.both",
				"left.worker.bundle.outgoing -> right.worker.bundle.outgoing",
				"right.worker.bundle.both -> left.worker.bundle.both",
				"right.worker.bundle.incoming -> left.worker.bundle.incoming"),
				namesOf(DIRECTIONS, "Top.peers"));
		assertEquals(List.of("bundle.both -> inner.worker.bundle.both",
				"bundle.incoming -> inner.worker.bundle.incoming",
				"inner.worker.bundle.both -> bundle.both",
				"inner.worker.bundle.outgoing -> bundle.outgoing"),
				namesOf(DIRECTIONS, "Top.boundary"));
	}

	/** An inverse group whose members are renamed, so position is the only thing left to pair on. */
	@Test
	public void renamedMembersPairByPosition() throws Exception {
		assertSameModel("Top.renamed");

		assertEquals(List.of("producer.worker.bundle.first -> consumer.bundle.alpha",
				"producer.worker.bundle.second -> consumer.bundle.beta"), connectionNames("Top.renamed"));
	}

	/** A subset destination, where the source's other member pairs with nothing. */
	@Test
	public void aSubsetDestinationPairsByName() throws Exception {
		assertSameModel("Top.subset");

		assertEquals("only the member the destination has", List.of("producer.worker.bundle.second -> consumer.bundle.second"),
				connectionNames("Top.subset"));
	}

	/** A feature group with no type, which the other group pairs against as a whole. */
	@Test
	public void anUntypedGroupPairsAgainstEveryMember() throws Exception {
		assertSameModel("Top.untyped");

		assertEquals("each member against the untyped group itself",
				List.of("producer.worker.bundle.first -> consumer.bundle",
						"producer.worker.bundle.second -> consumer.bundle"),
				connectionNames("Top.untyped"));
	}

	/**
	 * A leaf source against a group with no type, which pairs the leaf with the group as a whole.
	 *
	 * <p>
	 * The connections agree. The diagnostics do not, and the difference is <em>not</em> an
	 * approved allowlist entry: source-first warns that the destination feature group has no
	 * type, from inside the {@code upFeature} narrowing that across-first replaces, and
	 * across-first has no such moment to report from. Both sides are recorded here so that the
	 * reviewer can decide, and so that neither side changes unnoticed while they do.
	 * </p>
	 */
	@Test
	public void aLeafAgainstAnUntypedGroupAgreesExceptForOneWarning() throws Exception {
		assertSameModel("LeafProducer.i");

		CharacterizationRun sourceFirst = isolated.run(DIRECTIONS_UNTYPED, "Top.leafToUntyped", "SOURCE_FIRST", false);
		CharacterizationRun acrossFirst = isolated.run(DIRECTIONS_UNTYPED, "Top.leafToUntyped", "ACROSS_FIRST", false);
		InstanceSnapshot expected = InstanceSnapshot.of(sourceFirst.instance(), sourceFirst.errorManager());
		InstanceSnapshot actual = InstanceSnapshot.of(acrossFirst.instance(), acrossFirst.errorManager());

		assertEquals(InstanceReport.connectionLines(expected), InstanceReport.connectionLines(actual));
		assertEquals(List.of("producer.worker.outp -> consumer.bundle"), connectionNames("Top.leafToUntyped"));
		assertEquals("source-first warns about the untyped group while narrowing",
				List.of("Warning | Expected feature 'consumer.bundle' to have classifier"
						+ " 'ExpansionCorners::D' | at Top_leafToUntyped_Instance.producer.worker.outp ->"
						+ " consumer.bundle|ConnectionInstance"
						+ " | in ExpansionCorners_Top_leafToUntyped_Instance.aaxl2",
						"Warning | In consumer (classifier UntypedHost) feature group bundle has no type"
								+ " | at Top_leafToUntyped_Instance.consumer|ComponentInstance"
								+ " | in ExpansionCorners_Top_leafToUntyped_Instance.aaxl2"),
				InstanceReport.diagnosticSet(expected));
		assertEquals("proposed allowlist entry 9, not yet approved: the untyped-group warning disappears",
				List.of("Warning | Expected feature 'consumer.bundle' to have classifier"
						+ " 'ExpansionCorners::D' | at Top_leafToUntyped_Instance.producer.worker.outp ->"
						+ " consumer.bundle|ConnectionInstance"
						+ " | in ExpansionCorners_Top_leafToUntyped_Instance.aaxl2"),
				InstanceReport.diagnosticSet(actual));
	}

	/**
	 * Short access, where a connection's destination is a shared component rather than a feature
	 * and a feature group has to be narrowed against something that has no members.
	 *
	 * <p>
	 * These are two of the four implementations that differed until issue #3044 was fixed, so
	 * this is also where across-first is held to that fix from its own side.
	 * </p>
	 */
	@Test
	public void shortAccessAgrees() throws Exception {
		StrategyDifference.assertSameModel(isolated, SHORT_ACCESS, "P.i");
		StrategyDifference.assertSameModel(isolated, SHORT_ACCESS, "Root.impl");
	}

	private void assertSameModel(String implementation) throws Exception {
		StrategyDifference.assertSameModel(isolated, MODEL, implementation);
	}

	private List<String> connectionNames(String implementation) throws Exception {
		return namesOf(MODEL, implementation);
	}

	private List<String> namesOf(String model, String implementation) throws Exception {
		return isolated.run(model, implementation, "ACROSS_FIRST", false)
				.instance()
				.getAllConnectionInstances()
				.stream()
				.map(ConnectionInstance::getName)
				.sorted()
				.toList();
	}
}
