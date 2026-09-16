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
package org.osate.core.tests.aadl2scopeprovider;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ConnectedElementsAndFlowEndsTest extends XtextTest {
	/*
	 * The lines commented out with '--' were rich string comments in the Xtend version of this test. They name the
	 * cases that the scope provider does not support yet.
	 */
	private static final String PACK = """
			package pack
			public
			  abstract a1
			  prototypes
			    fgproto1: feature group fgt1;
			    aproto1: abstract a2.i1;
			    subpproto1: subprogram subp1;
			    subpgproto1: subprogram group subpg1;
			  features
				ep1: in event port;
			    dp1: in data port a2.i1;
			    dp2: in data port aproto1;
			    edp1: in event data port;
			    fg1: feature group fgt1;
			    fg4: feature group fgproto1;
			    af1: feature;
			    ba1: provides bus access;
			    da1: provides data access;
			  flows
			    fsource1: flow source af1;
			    fsource2: flow source fg1.af2;
			    fsource3: flow source fg4.af2;
			    fsource4: flow source dp1.af3;
			    fsource5: flow source dp2.af3;
			  end a1;

			  abstract implementation a1.i1
			  subcomponents
			    asub1: abstract a2.i1;
			    asub2: abstract aproto1;
			    bsub1: bus;
			    dsub1: data;
			    subpgsub1: subprogram group subpg1;
			    subpgsub2: subprogram group subpg1 (subpproto4 => subprogram subp1.i2);
			    subpgsub3: subprogram group subpgproto1;
			    subpsub1: subprogram subp1;
			    subpsub2: subprogram subpproto1;
			  internal features
			    eds1: event data;
			  processor features
			    pp1: port;
			    sp1: subprogram;
			  calls sequence1: {
			    call1: subprogram subp1;
			    call13: subprogram subpgsub1.subpa5;
			    call14: subprogram subpgsub2.subpa6;
			  };
			  connections
			    conn1: feature group asub1.fg2 <-> asub1.fg2;
			    conn2: feature group asub2.fg2 <-> asub1.fg2;
			    conn3: feature group fg1 <-> asub1.fg2;
			    conn4: feature group fg1.fg3 <-> asub1.fg2;
			    conn5: feature group fg4.fg3 <-> asub1.fg2;
			    conn6: port dp1.dsub2 -> asub1.dp2;
			    conn7: port dp2.dsub2 -> asub1.dp2;
			    conn8: port processor.pp1 -> asub1.dp2;
			    conn9: port self.eds1 -> asub1.dp2;
			    conn10: feature subpsub1.param1 <-> asub1.af3;
			    conn11: feature subpsub2.param1 <-> asub1.af3;
			    conn12: subprogram access processor.sp1 <-> asub1.subpa1;
			    conn24: parameter dsub1 -> call13.param1;
			    conn25: parameter dsub1 -> call14.param1;
			  flows
			    fsource1: flow source af1;
			    fsource2: flow source fg1.af2;
			    fsource3: flow source fg4.af2;
			    fsource4: flow source dp1.af3;
			    fsource5: flow source dp2.af3;
			  end a1.i1;

			  abstract a2
			  features
			    fg2: feature group;
			    dp2: in data port;
			    af3: feature;
			    ba3: provides bus access;
			    da3: provides data access;
			    subpa1: requires subprogram access;
			    ep3: in event port;
			    edp3: in event data port;
			  end a2;

			  abstract implementation a2.i1
			  subcomponents
			    dsub2: data;
			    bsub2: bus;
			    subpgsub2: subprogram group;
			    subpsub2: subprogram;
			  internal features
			    eds1: event data;
			  processor features
			    pp1: port;
			    sp1: subprogram;
			  end a2.i1;

			  subprogram subp1
			  prototypes
			    subpproto2: subprogram subp1.i2;
			    fgproto1: feature group fgt2;
			    subpgproto1: subprogram group subpg1;
			  features
			    param1: in out parameter;
			    af4: feature;
			    fg4: feature group fgt2;
			    fg5: feature group fgproto1;
			    subpa2: requires subprogram access subp1.i2;
			    subpa3: requires subprogram access subpproto2;
			    subpga1: requires subprogram group access subpg1;
			    subpga2: requires subprogram group access subpgproto1;
			    da4: requires data access;
			    ep4: out event port;
			    edp4: out event data port;
			  end subp1;

			  subprogram implementation subp1.i1
			  subcomponents
			    subpsub3: subprogram subp1.i2;
			    subpsub4: subprogram subpproto2;
			  calls sequence2: {
			    call2: subprogram subp1.i2;
			    call3: subprogram subpsub3;
			    call4: subprogram subpsub4;
			    call5: subprogram subpproto2;
			    call6: subprogram subpa2;
			    call7: subprogram subpa3;
			    call8: subprogram subp1.subpa3;
			    call9: subprogram fg4.subpa4;
			    --call10: subprogram fg5.subpa4;
			    --call11: subprogram subpga1.subpa5;
			  };
			  connections
			    conn13: parameter param1 -> call2.param1;
			    conn14: parameter param1 -> call3.param1;
			    conn15: parameter param1 -> call4.param1;
			    conn16: parameter param1 -> call5.param1;
			    conn17: parameter param1 -> call6.param1;
			    conn18: parameter param1 -> call7.param1;
			    conn19: parameter param1 -> call8.param1;
			    conn20: parameter param1 -> call9.param1;
			    --conn21: parameter param1 -> call10.param1;
			    --conn22: parameter param1 -> call11.param1;
			  end subp1.i1;

			  subprogram implementation subp1.i2
			  subcomponents
			    dsub3: data;
			    subpsub3: subprogram;
			  internal features
			    eds2: event data;
			  processor features
			    pp2: port;
			    sp2: subprogram;
			  end subp1.i2;

			  feature group fgt1
			  features
			    fg3: feature group;
			    af2: feature;
			    param2: in parameter;
			    ba2: provides bus access;
			    da2: provides data access;
			    ep2: in event port;
			    dp2: in data port;
			    edp2: in event data port;
			  end fgt1;

			  feature group fgt2
			  prototypes
			    subpproto3: subprogram subp1.i2;
			  features
			    subpa4: requires subprogram access subpproto3;
			  end fgt2;

			  subprogram group subpg1
			  prototypes
			    subpproto3: subprogram subp1.i2;
			    subpproto4: subprogram;
			  features
			    subpa5: provides subprogram access subpproto3;
			    subpa6: provides subprogram access subpproto4;
			  end subpg1;
			end pack;
			""";

	/** The connection contexts of a1.i1. */
	private static final List<String> CONTEXT_A1_I1 = List.of("asub1", "asub2", "bsub1", "call1", "call13", "call14",
			"dp1", "dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2");

	/** The connection ends of a1.i1 itself. */
	private static final List<String> END_IN_A1_I1 = List.of("af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1",
			"edp1", "eds1", "ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
			"subpsub2");

	/** The connection ends in a subcomponent of type a2.i1. */
	private static final List<String> END_IN_A2_I1 = List.of("af3", "ba3", "bsub2", "da3", "dp2", "dsub2", "edp3",
			"eds1", "ep3", "fg2", "pp1", "sp1", "subpa1", "subpgsub2", "subpsub2");

	/** The connection ends in a feature group of type fgt1. */
	private static final List<String> END_IN_FGT1 = List.of("af2", "ba2", "da2", "dp2", "edp2", "ep2", "fg3", "param2");

	/** The connection ends in a subprogram of type subp1. */
	private static final List<String> END_IN_SUBP1 = List.of("af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1",
			"subpa2", "subpa3", "subpga1", "subpga2");

	/** The connection ends in a subprogram of type subp1.i2. */
	private static final List<String> END_IN_SUBP1_I2 = List.of("af4", "da4", "dsub3", "edp4", "eds2", "ep4", "fg4",
			"fg5", "param1", "pp2", "sp2", "subpa2", "subpa3", "subpga1", "subpga2", "subpsub3");

	/** The connection contexts of subp1.i1. */
	private static final List<String> CONTEXT_SUBP1_I1 = List.of("call2", "call3", "call4", "call5", "call6", "call7",
			"call8", "call9", "edp4", "fg4", "fg5", "param1", "subpa2", "subpa3", "subpsub3", "subpsub4");

	/** The connection ends of subp1.i1 itself. */
	private static final List<String> END_IN_SUBP1_I1 = List.of("af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1",
			"subpa2", "subpa3", "subpga1", "subpga2", "subpsub3", "subpsub4");

	private static final List<String> FLOW_END_A1 = List.of("af1", "ba1", "da1", "dp1", "dp2", "edp1", "ep1", "fg1",
			"fg4");

	private static final List<String> FLOW_END_FGT1 = List.of("af2", "ba2", "da2", "dp2", "edp2", "ep2", "fg3",
			"param2");

	private static final List<String> FLOW_END_A2 = List.of("af3", "ba3", "da3", "dp2", "edp3", "ep3", "fg2", "subpa1");

	private static final List<String> FLOW_NAMES = List.of("fsource1", "fsource2", "fsource3", "fsource4", "fsource5");

	private static final List<List<String>> FLOW_OUT_END_SCOPES = List.of(FLOW_END_A1, FLOW_END_FGT1, FLOW_END_FGT1,
			FLOW_END_A2, FLOW_END_A2);

	private static final String DATA_PORT_FLOW_ERROR = "Anything in a 'data port' is not a valid flow specification feature.";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Inject
	AssertHelper assertHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	// Tests scope_ConnectedElement_context, scope_ConnectedElement_connectionEnd, scope_FlowEnd_context, and
	// scope_FlowEnd_feature
	@Test
	public void testConnectedElementsAndFlowEnds() throws Exception {
		testFileResult = issues = testHelper.testString(PACK);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(), new ArrayList<>());

		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("pack", pkg.getName());
		var classifiers = pkg.getPublicSection().getOwnedClassifiers();

		var a1 = (AbstractType) classifiers.get(0);
		assertEquals("a1", a1.getName());
		for (var index = 0; index < FLOW_NAMES.size(); index++) {
			var flowSpecification = a1.getOwnedFlowSpecifications().get(index);
			assertEquals(FLOW_NAMES.get(index), flowSpecification.getName());
			// Tests scope_FlowEnd_feature(FlowSpecification, EReference)
			assertFlowEndScope(flowSpecification, FLOW_END_A1);
			// Tests scope_FlowEnd_feature(FlowEnd, EReference)
			assertFlowEndScope(flowSpecification.getOutEnd(), FLOW_OUT_END_SCOPES.get(index));
			if (index >= 3) {
				/*
				 * Not testing for this error, but the assert is here so that we can test the scope when the
				 * context is a data port.
				 */
				assertError(flowSpecification.getOutEnd(), DATA_PORT_FLOW_ERROR);
			}
		}

		var a1i1 = (AbstractImplementation) classifiers.get(1);
		assertEquals("a1.i1", a1i1.getName());

		var featureGroupConnections = a1i1.getOwnedFeatureGroupConnections();
		assertConnectionScopes(featureGroupConnections.get(0), "conn1", CONTEXT_A1_I1, END_IN_A2_I1, END_IN_A2_I1);
		assertConnectionScopes(featureGroupConnections.get(1), "conn2", CONTEXT_A1_I1, END_IN_A2_I1, END_IN_A2_I1);
		assertConnectionScopes(featureGroupConnections.get(2), "conn3", CONTEXT_A1_I1, END_IN_A1_I1, END_IN_A2_I1);
		assertConnectionScopes(featureGroupConnections.get(3), "conn4", CONTEXT_A1_I1, END_IN_FGT1, END_IN_A2_I1);
		assertConnectionScopes(featureGroupConnections.get(4), "conn5", CONTEXT_A1_I1, END_IN_FGT1, END_IN_A2_I1);

		var portConnections = a1i1.getOwnedPortConnections();
		assertWarning(portConnections.get(0).getSource(), "Aggregate data ports not supported by instantiator.");
		assertConnectionScopes(portConnections.get(0), "conn6", CONTEXT_A1_I1, END_IN_A2_I1, END_IN_A2_I1);
		assertWarning(portConnections.get(1).getSource(), "Aggregate data ports not supported by instantiator.");
		assertConnectionScopes(portConnections.get(1), "conn7", CONTEXT_A1_I1, END_IN_A2_I1, END_IN_A2_I1);
		assertConnectionScopes(portConnections.get(2), "conn8", CONTEXT_A1_I1, END_IN_A1_I1, END_IN_A2_I1);
		assertConnectionScopes(portConnections.get(3), "conn9", CONTEXT_A1_I1, END_IN_A1_I1, END_IN_A2_I1);

		var featureConnections = a1i1.getOwnedFeatureConnections();
		assertConnectionScopes(featureConnections.get(0), "conn10", CONTEXT_A1_I1, END_IN_SUBP1, END_IN_A2_I1);
		// From fixing issue 1954
		assertError(featureConnections.get(0).getSource(),
				"A 'parameter' in a 'subprogram subcomponent' is not a valid feature connection end.");
		assertConnectionScopes(featureConnections.get(1), "conn11", CONTEXT_A1_I1, END_IN_SUBP1, END_IN_A2_I1);
		// From fixing issue 1954
		assertError(featureConnections.get(1).getSource(),
				"A 'parameter' in a 'subprogram subcomponent' is not a valid feature connection end.");

		assertConnectionScopes(a1i1.getOwnedAccessConnections().getFirst(), "conn12", CONTEXT_A1_I1, END_IN_A1_I1,
				END_IN_A2_I1);

		var parameterConnections = a1i1.getOwnedParameterConnections();
		assertConnectionScopes(parameterConnections.get(0), "conn24", CONTEXT_A1_I1, END_IN_A1_I1, END_IN_SUBP1_I2);
		assertConnectionScopes(parameterConnections.get(1), "conn25", CONTEXT_A1_I1, END_IN_A1_I1, END_IN_SUBP1_I2);

		for (var index = 0; index < FLOW_NAMES.size(); index++) {
			var flowImplementation = a1i1.getOwnedFlowImplementations().get(index);
			assertEquals(FLOW_NAMES.get(index), flowImplementation.getName());
			assertWarning(flowImplementation, "Flow implementation is empty and does not add value to the model");
			// Tests scope_FlowEnd_feature(FlowSpecification, EReference)
			assertFlowEndScope(flowImplementation, FLOW_END_A1);
			// Tests scope_FlowEnd_feature(FlowEnd, EReference)
			assertFlowEndScope(flowImplementation.getOutEnd(), FLOW_OUT_END_SCOPES.get(index));
			if (index >= 3) {
				/*
				 * Not testing for this error, but the assert is here so that we can test the scope when the
				 * context is a data port.
				 */
				assertError(flowImplementation.getOutEnd(), DATA_PORT_FLOW_ERROR);
			}
		}

		var subp1i1 = (ComponentImplementation) classifiers.get(5);
		assertEquals("subp1.i1", subp1i1.getName());
		var subprogramConnections = subp1i1.getOwnedParameterConnections();
		var subprogramConnectionNames = List.of("conn13", "conn14", "conn15", "conn16", "conn17", "conn18", "conn19",
				"conn20");
		for (var index = 0; index < subprogramConnectionNames.size(); index++) {
			assertConnectionScopes(subprogramConnections.get(index), subprogramConnectionNames.get(index),
					CONTEXT_SUBP1_I1, END_IN_SUBP1_I1, END_IN_SUBP1_I2);
		}

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private void assertConnectionScopes(Connection connection, String name, List<String> contextScope,
			List<String> sourceEndScope, List<String> destinationEndScope) {
		assertEquals(name, connection.getName());
		// Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
		assertConnectionEndScope(connection, List.of());
		// Tests scope_ConnectedElement_context
		assertContextScope(connection.getSource(), contextScope);
		// Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
		assertConnectionEndScope(connection.getSource(), sourceEndScope);
		// Tests scope_ConnectedElement_context
		assertContextScope(connection.getDestination(), contextScope);
		// Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
		assertConnectionEndScope(connection.getDestination(), destinationEndScope);
	}

	private void assertContextScope(EObject object, List<String> expected) {
		assertHelper.assertScope(object, Aadl2Package.eINSTANCE.getConnectedElement_Context(), expected);
	}

	private void assertConnectionEndScope(EObject object, List<String> expected) {
		assertHelper.assertScope(object, Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd(), expected);
	}

	private void assertFlowEndScope(EObject object, List<String> expected) {
		assertHelper.assertScope(object, Aadl2Package.eINSTANCE.getFlowEnd_Feature(), expected);
	}

	private void assertError(EObject object, String... messages) {
		AssertHelper.assertError(object, testFileResult.getIssues(), issueCollection, messages);
	}

	private void assertWarning(EObject object, String... messages) {
		AssertHelper.assertWarning(object, testFileResult.getIssues(), issueCollection, messages);
	}
}
