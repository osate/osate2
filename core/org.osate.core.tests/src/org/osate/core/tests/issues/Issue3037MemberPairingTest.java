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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.core.tests.instantiation.InstanceCharacterization;
import org.osate.core.tests.instantiation.InstanceReport;
import org.osate.core.tests.instantiation.InstanceRun;
import org.osate.core.tests.instantiation.InstanceSnapshot;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.testsupport.Aadl2InjectorProvider;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Compares the two strategies where both sides of a feature group pivot route several members
 * onwards, for issue #3037.
 *
 * <p>
 * This is the shape the issue #3044 fixtures have, and it is the one that decides two rules
 * across-first needs and no other committed test reaches. Legs pair by the member of the pivot
 * they leave from, so a leg leaving one member joins only the leg leaving the member that pairs
 * with it; without that, every combination of members becomes a path. And a member the
 * declarations inside leave with nowhere to go ends the connection when it triggers a mode
 * transition and is reported as a dead end otherwise.
 * </p>
 *
 * <p>
 * The fixtures are the ones issue #3044 added, used here from the other strategy: the
 * regression test for that issue exercises the production path, so nothing held across-first to
 * the same model.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037MemberPairingTest extends XtextTest {
	private static final String UNCONTINUED = "org.osate.core.tests/models/issue3044/UncontinuedMembers.aadl";
	private static final String SHARED_GROUP = "org.osate.core.tests/models/issue3044/Issue3044.aadl";

	@Inject
	private IsolatedInstantiation isolated;

	/**
	 * A feature group of three ports between two processes, where one member reaches a thread
	 * inside the receiver, one triggers a mode transition of it, and one has nowhere to go.
	 *
	 * <p>
	 * Three source legs and two destination outcomes could give six connections; the model has
	 * two, because the members pair one to one. The third member is reported instead.
	 * </p>
	 */
	@Test
	public void membersOfAPivotPairOneToOne() throws Exception {
		InstanceCharacterization.assertConnections(isolated, UNCONTINUED, "TriggerTop.impl",
				"sender.emitter.alarm_out -> receiver.sensor_bundle.alarm_line",
				"sender.emitter.data_out -> receiver.consumer.data_in");
		InstanceCharacterization.assertConnections(isolated, UNCONTINUED, "Sender.impl",
				"emitter.alarm_out -> sensor_bundle.alarm_line", "emitter.data_out -> sensor_bundle.data_line",
				"emitter.spare_out -> sensor_bundle.spare_line");
		InstanceCharacterization.assertConnections(isolated, UNCONTINUED, "Receiver.impl",
				"sensor_bundle.data_line -> consumer.data_in");

		InstanceRun run = isolated.run(UNCONTINUED, "TriggerTop.impl");
		assertEquals(List.of("sender.emitter.alarm_out -> receiver.sensor_bundle.alarm_line",
				"sender.emitter.data_out -> receiver.consumer.data_in"), names(run));
		assertEquals(List.of("Warning | Could not continue connection from"
				+ " TriggerTop_impl_Instance.sender.emitter.spare_out through"
				+ " TriggerTop_impl_Instance.receiver.sensor_bundle.spare_line. No connection instance created."
				+ " | at TriggerTop_impl_Instance.receiver.sensor_bundle.spare_line|FeatureInstance|dataPort|0"
				+ " | in UncontinuedMembers_TriggerTop_impl_Instance.aaxl2"),
				InstanceReport.diagnosticSet(InstanceSnapshot.of(run.instance(), run.errorManager())));
	}

	/**
	 * The reported shape of issue #3044: a port and a connected access feature sharing a feature
	 * group between two connection ending components. The port connection is the one the fix
	 * restored, and across-first produced it before the fix, which is how the defect was found.
	 */
	@Test
	public void aPortSharingAGroupWithConnectedAccessAgrees() throws Exception {
		InstanceCharacterization.assertConnections(isolated, SHARED_GROUP, "DemoTop.impl",
				"provider_side.service_bundle.signal_line -> requester_side.service_bundle.signal_line",
				"provider_side.worker_unit -> requester_side.worker_unit.requested_call");

	}

	private static List<String> names(InstanceRun run) {
		return run.instance()
				.getAllConnectionInstances()
				.stream()
				.map(ConnectionInstance::getName)
				.sorted()
				.toList();
	}
}
