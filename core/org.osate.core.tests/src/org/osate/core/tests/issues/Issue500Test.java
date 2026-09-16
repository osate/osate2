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

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue500Test extends XtextTest {
	private static final String FEATURE_GROUP_CONNECTIONS = """
			package issue500
			public

				feature group Ofg
					features
						of1: feature group Mfg;
						of2: feature group Mfg;
				end Ofg;

				feature group Mfg
					features
						mf1: feature;
						mf2: feature;
				end Mfg;

				abstract O
					features
						ofg: feature group Ofg;
						ofgi: feature group inverse of Ofg;
				end O;

				abstract implementation O.i
					subcomponents
						m1: abstract M.i;
					connections
						co: feature group m1.mfg <-> ofg.of1;
						coi: feature group m1.mfgi <-> ofgi.of1;
				end O.i;

				abstract M
					features
						mfg: feature group Mfg;
						mfgi: feature group inverse of Mfg;
				end M;

				abstract implementation M.i
					subcomponents
						l1: abstract L;
						l2: abstract L;
					connections
						cm1: feature l1.f <-> mfg.mf1;
						cm2: feature l2.f <-> mfg.mf2;
						cmi1: feature l1.f <-> mfgi.mf1;
						cmi2: feature l2.f <-> mfgi.mf2;
				end M.i;

				abstract L
					features
						f: feature;
				end L;

				system S
				end S;

				system implementation S.i0
					subcomponents
						o1: abstract O.i;
						o2: abstract O.i;
					connections
						cs: feature group o1.ofg <-> o2.ofgi;
				end S.i0;

				system implementation S.i1
					subcomponents
						o1: abstract O.i;
						o2: abstract O.i;
					connections
						cs: feature o1.ofg.of1.mf1 <-> o2.ofgi.of1.mf2;
				end S.i1;

				system implementation S.i2
					subcomponents
						o1: abstract O.i;
						o2: abstract O.i;
					connections
						cs: feature o1.ofg.of1.mf2 <-> o2.ofgi.of1.mf2;
				end S.i2;

				system implementation S.i3
					subcomponents
						o: abstract O.i;
						m: abstract M.i;
					connections
						cs: feature o.ofg.of1.mf2 <-> m.mfgi.mf1;
				end S.i3;

				system implementation S.i4
					subcomponents
						o: abstract O.i;
						m: abstract M.i;
					connections
						cs: feature o.ofg.of1 <-> m.mfgi;
				end S.i4;

				system implementation S.i5
					subcomponents
						l: system L;
						m: system M;
					connections
						cs1: feature l.f -> m.mfg.mf1;
						cs2: feature m.mfg.mf2 -> l.f;
				end S.i5;

			end issue500;
			""";

	private static final String END_TO_END_FLOWS = """
			package pkg1
			public
				system top
				end top;

				system implementation top.i
					subcomponents
						sub1: system s1;
						sub2: system s2;
					connections
						conn1: feature sub1.fg1 -> sub2.fg2;
						conn2: feature sub1.p1 -> sub2.fg2.p2;
						conn3: feature sub1.fg1 -> sub2.fg3;
						conn4: feature sub1.p1 -> sub2.fg3.p2;
						conn5: feature sub1.p1 -> sub2.fg4.fg5.p2;
					flows
						etef1: end to end flow sub1 -> conn1 -> sub2.sink1;
						etef2: end to end flow sub1 -> conn1 -> sub2.sink2;
						etef3: end to end flow sub1 -> conn2 -> sub2.sink1;
						etef4: end to end flow sub1 -> conn2 -> sub2.sink2;
						etef5: end to end flow sub1 -> conn1 -> sub2.sink3;

						etef6: end to end flow sub1 -> conn2 -> sub2.sink3;
						etef7: end to end flow sub1 -> conn3 -> sub2.sink3;
						etef8: end to end flow sub1 -> conn4 -> sub2.sink3;
						etef9: end to end flow sub1 -> conn5 -> sub2.sink2;
				end top.i;

				system s1
					features
						p1: out data port;
						fg1: feature group;
				end s1;

				system s2
					features
						fg2: feature group fgt1;
						fg3: feature group fgt1;
						fg4: feature group fgt2;
					flows
						sink1: flow sink fg2;
						sink2: flow sink fg2.p2;
						sink3: flow sink fg2.p3;
				end s2;

				feature group fgt1
					features
						p2: in data port;
						p3: in data port;
				end fgt1;

				feature group fgt2
					features
						fg5: feature group fgt1;
				end fgt2;
			end pkg1;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	@Test
	public void issue500() throws Exception {
		var pkg = testHelper.parseString(FEATURE_GROUP_CONNECTIONS);
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();
		for (var k = 0; k <= 5; k++) {
			var name = "S.i" + k;
			var implementation = (SystemImplementation) classifiers.stream()
					.filter(classifier -> name.equals(classifier.getName()))
					.findFirst()
					.orElse(null);
			assertNotNull("System implementation \"" + name + "\" not found", implementation);

			// instantiate
			var instance = InstantiateModel.instantiate(implementation);
			var connections = instance.getConnectionInstances();

			var expected = switch (k) {
				case 0 -> new ExpectedConnections(4,
						"o1.m1.l1.f -> o2.m1.l1.f, o1.m1.l2.f -> o2.m1.l2.f, o2.m1.l1.f -> o1.m1.l1.f, o2.m1.l2.f -> o1.m1.l2.f");
				case 1 -> new ExpectedConnections(2, "o1.m1.l1.f -> o2.m1.l2.f, o2.m1.l2.f -> o1.m1.l1.f");
				case 2 -> new ExpectedConnections(2, "o1.m1.l2.f -> o2.m1.l2.f, o2.m1.l2.f -> o1.m1.l2.f");
				case 3 -> new ExpectedConnections(2, "m.l1.f -> o.m1.l2.f, o.m1.l2.f -> m.l1.f");
				/*
				 * Allowlist entry 9 of issue #3037, for the defect recorded as issue #3046. The pivot names the feature
				 * group member ofg.of1, and before that release the end resolved to the enclosing group ofg, which cost
				 * it the member: mf1 was paired with mf2 as well as with mf1, and nothing was created in the o to m
				 * direction. The whole connection end is now resolved, so these are the two semantic connections the
				 * model has, each in both directions because every feature here is directionless.
				 */
				case 4 -> new ExpectedConnections(4,
						"m.l1.f -> o.m1.l1.f, m.l2.f -> o.m1.l2.f, o.m1.l1.f -> m.l1.f, o.m1.l2.f -> m.l2.f");
				case 5 -> new ExpectedConnections(2, "l.f -> m.mfg.mf1, m.mfg.mf2 -> l.f");
				default -> throw new AssertionError("Unexpected system implementation index " + k);
			};
			assertEquals(instance.getName() + ": must have " + expected.count() + " connections", expected.count(),
					connections.size());
			assertEquals(instance.getName() + ": connection names do not match", expected.names(),
					sortedNames(connections));
		}
	}

	// Tests the method Aadl2JavaValidator.isMatchingConnectionPoint(Feature, Context, ConnectedElement)
	@Test
	public void testFlowValidation() throws Exception {
		testFileResult = issues = testHelper.testString(END_TO_END_FLOWS);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(), new ArrayList<>());

		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("pkg1", pkg.getName());
		var topImplementation = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals("top.i", topImplementation.getName());
		assertConnectionDestinationError(topImplementation, 5, "etef6", "conn2",
				"The destination of connection 'conn2' does not match the succeeding subcomponent or in flow spec feature 'sub2.p3'");
		assertConnectionDestinationError(topImplementation, 6, "etef7", "conn3",
				"The destination of connection 'conn3' does not match the succeeding subcomponent or in flow spec feature 'sub2.p3'");
		assertConnectionDestinationError(topImplementation, 7, "etef8", "conn4",
				"The destination of connection 'conn4' does not match the succeeding subcomponent or in flow spec feature 'sub2.p3'");
		assertConnectionDestinationError(topImplementation, 8, "etef9", "conn5",
				"The destination of connection 'conn5' does not match the succeeding subcomponent or in flow spec feature 'sub2.p2'");

		issueCollection.sizeIs(issueCollection.getIssues().size());
		assertConstraints(issueCollection);
	}

	private void assertConnectionDestinationError(SystemImplementation implementation, int flowIndex, String flowName,
			String connectionName, String message) {
		var flow = implementation.getOwnedEndToEndFlows().get(flowIndex);
		assertEquals(flowName, flow.getName());
		var segment = flow.getOwnedEndToEndFlowSegments().get(1);
		assertEquals(connectionName, segment.getFlowElement().getName());
		AssertHelper.assertError(segment, testFileResult.getIssues(), issueCollection, message);
	}

	private static String sortedNames(List<ConnectionInstance> connections) {
		return connections.stream().map(ConnectionInstance::getName).sorted().collect(joining(", "));
	}

	private record ExpectedConnections(int count, String names) {
	}
}
