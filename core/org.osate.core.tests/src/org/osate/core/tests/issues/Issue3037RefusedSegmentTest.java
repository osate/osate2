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
 * Characterizes the segments the traversal refuses outright, for issue #3037.
 *
 * <p>
 * These are the rules that remove a connection the model declares, in
 * {@code PathAssembler.traversable} and {@code PathAssembler.arrivesAtUnreachableParameter}, and
 * the rule in {@code LegResolver} that decides whether a feature group stops a leg at a
 * connection ending component. All are required behavior carried over from 2.18.0. None had a
 * test: a rule whose whole effect is an absent connection instance leaves nothing for a
 * connection-set assertion elsewhere to notice, which is how they came to be documented only by
 * a comment.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037RefusedSegmentTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3037/RefusedSegments.aadl";

	/** The model whose {@code port input -> myData} the refusal in question was found on. */
	private static final String DATA_TEST = "org.osate.core.tests/models/Issue1987/DataTest.aadl";

	@Inject
	private IsolatedInstantiation isolated;

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/**
	 * A port connection from a thread's own port into a data subcomponent of that thread gets no
	 * connection instance.
	 *
	 * <p>
	 * A connection ending component ends a connection instance, so a path that leaves its port
	 * and arrives at something it contains would connect the component to its own insides. Issue
	 * #2032 added the rule for a port of an abstract subcomponent; a data subcomponent is
	 * contained in the component too, so the same rule refuses this. {@code TT.i} declares
	 * {@code c: port input -> myData} and has no connection instance at all.
	 * </p>
	 *
	 * <p>
	 * The opposite direction is not refused, because its source is the data subcomponent rather
	 * than a port: {@code T.i} declares {@code c: port myData -> output} and does get its
	 * connection instance. That asymmetry is the rule's actual shape, and it is what this test
	 * exists to hold.
	 * </p>
	 */
	@Test
	public void aPortIntoADataSubcomponentOfAThreadIsRefused() throws Exception {
		InstanceCharacterization.assertConnections(isolated, DATA_TEST, "TT.i");
		InstanceCharacterization.assertConnections(isolated, DATA_TEST, "T.i", "myData -> output");
	}

	/**
	 * A parameter connection arriving at a subprogram's own out parameter from a data subcomponent
	 * beside it gets no connection instance, whether the declaration sits in the instantiation root
	 * or below it.
	 *
	 * <p>
	 * Recorded as bug #220. This pins the data subcomponent condition, and only that one: the
	 * refusal's other two conditions cannot be reached on their own by any valid model, which the
	 * rule's own comment works through. Both placements of the same implementation are asserted
	 * anyway, since the rule also tests for the instantiation root and a reader will want to know
	 * that the placement makes no difference here.
	 * </p>
	 */
	@Test
	public void aParameterReachedFromADataSubcomponentIsRefused() throws Exception {
		InstanceCharacterization.assertConnections(isolated, MODEL, "Kernel.fromData");
		InstanceCharacterization.assertConnections(isolated, MODEL, "Host.i");
	}

	/**
	 * A feature group holding only an access member, between two threads: the connection reaches
	 * through to the subprogram inside and there is no second connection ending at the group.
	 *
	 * <p>
	 * A thread ends a connection instance at a port or a nested feature group, but not at an
	 * access feature, because shared access reaches through it into what it contains. The same
	 * shape with a port member added is {@code models/issue3044/Issue3044.aadl}, where the leg
	 * both stops and continues and there are two connections; {@code Issue3037MemberPairingTest}
	 * holds that one.
	 * </p>
	 *
	 * <p>
	 * This records the connection set, not the rule that decides the stop. Disabling
	 * {@code LegResolver.includesNestedFeatureGroup} does not change either of the two feature
	 * group models here, because inside a connection ending component only an access connection
	 * continues a leg, so a group with nothing to continue stops anyway. That is noted on the
	 * rule itself.
	 * </p>
	 */
	@Test
	public void aFeatureGroupWithoutPortOrNestedGroupDoesNotStopALeg() throws Exception {
		InstanceCharacterization.assertConnections(isolated, MODEL, "Pair.accessOnlyGroup",
				"provider.worker -> requester.user.requested_call");
	}

	/**
	 * A feature group whose only member is a nested feature group, at a thread that routes that
	 * group onwards internally: the connection still ends at the thread's own member rather than
	 * carrying on to the subcomponent inside.
	 *
	 * <p>
	 * The stop is what makes that so, but not the nested-group test: the internal declaration is a
	 * feature group connection, and inside a connection ending component only an access connection
	 * continues a leg, so the leg would stop here either way. Written to pin
	 * {@code LegResolver.includesNestedFeatureGroup} and kept as a record of the shape, which
	 * nothing else in the corpus has.
	 * </p>
	 */
	@Test
	public void aFeatureGroupHoldingANestedGroupStopsALeg() throws Exception {
		InstanceCharacterization.assertConnections(isolated, MODEL, "Pair.nestedGroup",
				"emitter.bundle.inner.p -> receiver.bundle.inner.p");
	}

	@Test
	public void theFixtureIsValid() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(MODEL));
	}
}
