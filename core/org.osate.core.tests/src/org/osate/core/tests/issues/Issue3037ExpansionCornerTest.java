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
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterizes the corners of feature group pairing and endpoint resolution, for issue
 * #3037.
 *
 * <p>
 * Each case isolates one decision pairing has to make and that the rest of the corpus reaches
 * only in passing: renamed members that names cannot pair, a subset destination missing one of
 * the source's members, direction deciding which members pair, and short access, where a
 * connection's destination is a component rather than a feature.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037ExpansionCornerTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3037/ExpansionCorners.aadl";
	private static final String DIRECTIONS = "org.osate.core.tests/models/issue3037/DirectionCombinations.aadl";
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
		InstanceCharacterization.assertConnections(isolated, DIRECTIONS, "Peer.i",
				"bundle.both -> worker.bundle.both", "bundle.incoming -> worker.bundle.incoming",
				"worker.bundle.both -> bundle.both", "worker.bundle.outgoing -> bundle.outgoing");
		InstanceCharacterization.assertConnections(isolated, DIRECTIONS, "InversePeer.i",
				"bundle.both -> worker.bundle.both", "bundle.outgoing -> worker.bundle.outgoing",
				"worker.bundle.both -> bundle.both", "worker.bundle.incoming -> bundle.incoming");
		InstanceCharacterization.assertConnections(isolated, DIRECTIONS, "Top.peers",
				"left.worker.bundle.both -> right.worker.bundle.both",
				"left.worker.bundle.outgoing -> right.worker.bundle.outgoing",
				"right.worker.bundle.both -> left.worker.bundle.both",
				"right.worker.bundle.incoming -> left.worker.bundle.incoming");
		InstanceCharacterization.assertConnections(isolated, DIRECTIONS, "Top.boundary",
				"bundle.both -> inner.worker.bundle.both", "bundle.incoming -> inner.worker.bundle.incoming",
				"inner.worker.bundle.both -> bundle.both", "inner.worker.bundle.outgoing -> bundle.outgoing");

		assertEquals(List.of("left.worker.bundle.both -> right.worker.bundle.both",
				"left.worker.bundle.outgoing -> right.worker.bundle.outgoing",
				"right.worker.bundle.both -> left.worker.bundle.both",
				"right.worker.bundle.incoming -> left.worker.bundle.incoming"),
				InstanceCharacterization.names(isolated, DIRECTIONS, "Top.peers"));
		assertEquals(List.of("bundle.both -> inner.worker.bundle.both",
				"bundle.incoming -> inner.worker.bundle.incoming",
				"inner.worker.bundle.both -> bundle.both",
				"inner.worker.bundle.outgoing -> bundle.outgoing"),
				InstanceCharacterization.names(isolated, DIRECTIONS, "Top.boundary"));
	}

	/** An inverse group whose members are renamed, so position is the only thing left to pair on. */
	@Test
	public void renamedMembersPairByPosition() throws Exception {
		assertConnections("Top.renamed", "producer.worker.bundle.first -> consumer.bundle.alpha",
				"producer.worker.bundle.second -> consumer.bundle.beta");

	}

	/** A subset destination, where the source's other member pairs with nothing. */
	@Test
	public void aSubsetDestinationPairsByName() throws Exception {
		assertConnections("Top.subset", "producer.worker.bundle.second -> consumer.bundle.second");

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
		InstanceCharacterization.assertConnections(isolated, SHORT_ACCESS, "P.i", "t1.fg.p -> t2.fgi.p",
				"t1.s -> t2.s.rsa", "t2.s.rsa -> t1.s");
		InstanceCharacterization.assertConnections(isolated, SHORT_ACCESS, "Root.impl", "t1.fg.p -> t2.fgi.p",
				"t1.s -> t2.s.rsa", "t2.s.rsa -> t1.s");
	}

	private void assertConnections(String implementation, String... expected) throws Exception {
		InstanceCharacterization.assertConnections(isolated, MODEL, implementation, expected);
	}

}
