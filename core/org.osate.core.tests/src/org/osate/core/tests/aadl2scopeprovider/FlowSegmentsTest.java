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
import static org.junit.Assert.assertNull;

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
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Context;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class FlowSegmentsTest extends XtextTest {
	private static final String FLOW_SEGMENT_SCOPE_TEST = """
			package flowSegmentScopeTest
			public
				abstract a1
				prototypes
					fgproto1: feature group fgt1;
					aproto1: abstract a2.i;
					subpproto1: subprogram subp1.i;
					subpgproto1: subprogram group subpg1;
				features
					af1: feature;
					da1: provides data access;
					subpa1: provides subprogram access subp1.i;
					subpa2: provides subprogram access subpproto1;
					subpga1: provides subprogram group access subpg1;
					subpga2: provides subprogram group access subpgproto1;
					dp1: in data port;
					edp1: in event data port;
					fg1: feature group fgt1;
					fg2: feature group fgproto1;
				flows
					fsource1: flow source af1;
					fsource2: flow source af1;
					fsource3: flow source af1;
					fsource4: flow source af1;
					fsource5: flow source af1;
					fsource6: flow source af1;
					fsource7: flow source af1;
					fsource8: flow source af1;
					fsource9: flow source af1;
					fsource10: flow source af1;
					fsource11: flow source af1;
					fsource12: flow source af1;
					fsource13: flow source af1;
					fsource14: flow source af1;
					fsource15: flow source af1;
					fsource16: flow source af1;
					fsource17: flow source af1;
					fsource18: flow source af1;
					fsource19: flow source af1;
				end a1;

				abstract implementation a1.i
				subcomponents
					asub1: abstract a2.i;
					asub2: abstract aproto1;
					subpsub1: subprogram subp1.i;
					subpsub2: subprogram subpproto1;
					subpgsub1: subprogram group subpg1;
					subpgsub2: subprogram group subpg1 (subpproto5 => subprogram subp1.i);
					subpgsub3: subprogram group subpgproto1;
				calls sequence1: {
					call1: subprogram subp1.i;
					call2: subprogram subpsub1;
					call3: subprogram subpsub2;
					call4: subprogram subpproto1;
					call5: subprogram subpa1;
					call6: subprogram subpa2;
					call7: subprogram subp1.subpa4;
					call8: subprogram fg1.subpa3;
					call12: subprogram subpgsub1.subpa5;
					call13: subprogram subpgsub2.subpa6;
				};
				connections
					fconn1: feature asub1.af2 -> af1;
					fconn2: feature asub1.af2 -> asub1.af2;
				flows
					fsource1: flow source asub1 -> fconn1 -> af1;
					fsource2: flow source fg1.da3 -> fconn1 -> af1;
					fsource3: flow source fg2.da3 -> fconn1 -> af1;
					fsource4: flow source asub1.fsource20 -> fconn1 -> af1;
					fsource5: flow source asub2.fsource20 -> fconn1 -> af1;
					fsource6: flow source call1.da4 -> fconn1 -> af1;
					fsource7: flow source call2.da4 -> fconn1 -> af1;
					fsource8: flow source call3.da4 -> fconn1 -> af1;
					fsource9: flow source call4.da4 -> fconn1 -> af1;
					fsource10: flow source call5.da4 -> fconn1 -> af1;
					fsource11: flow source call6.da4 -> fconn1 -> af1;
					fsource12: flow source call7.da4 -> fconn1 -> af1;
					fsource13: flow source call8.da4 -> fconn1 -> af1;
					fsource17: flow source call12.da4 -> fconn1 -> af1;
					fsource18: flow source call13.da4 -> fconn1 -> af1;

					etef1: end to end flow asub1.fsource20 -> fconn2 -> asub2.fsink1;
					etef2: end to end flow fg1.da3 -> fconn2 -> asub1.fsink1;
					etef3: end to end flow fg2.da3 -> fconn2 -> asub1.fsink1;
					etef4: end to end flow call1.da4 -> fconn2 -> asub1.fsink1;
					etef5: end to end flow call2.da4 -> fconn2 -> asub1.fsink1;
					etef6: end to end flow call3.da4 -> fconn2 -> asub1.fsink1;
					etef7: end to end flow call4.da4 -> fconn2 -> asub1.fsink1;
					etef8: end to end flow call5.da4 -> fconn2 -> asub1.fsink1;
					etef9: end to end flow call6.da4 -> fconn2 -> asub1.fsink1;
					etef10: end to end flow call7.da4 -> fconn2 -> asub1.fsink1;
					etef11: end to end flow call8.da4 -> fconn2 -> asub1.fsink1;
					etef15: end to end flow call12.da4 -> fconn2 -> asub1.fsink1;
					etef16: end to end flow call13.da4 -> fconn2 -> asub1.fsink1;
				end a1.i;

				abstract a2
				features
					af2: feature;
					da2: provides data access;
				flows
					fsource20: flow source af2;
					fsink1: flow sink af2;
				end a2;

				abstract implementation a2.i
				subcomponents
					asub3: abstract a2;
				connections
					fconn3: feature af2 -> asub3.af2;
					fconn4: feature asub3.af2 -> asub3.af2;
				flows
					etef18: end to end flow asub3.fsource20 -> fconn4 -> asub3.fsink1;
				end a2.i;

				feature group fgt1
				prototypes
					subpproto2: subprogram subp1.i;
				features
					da3: provides data access;
					subpa3: provides subprogram access subpproto2;
				end fgt1;

				subprogram subp1
				prototypes
					aproto2: abstract a2.i;
					subpproto3: subprogram subp1.i;
				features
					af3: feature;
					da4: requires data access;
					subpa4: requires subprogram access subpproto3;
					param1: in parameter a2.i;
					param2: in parameter aproto2;
				flows
					fsource21: flow source af3;
					fsource22: flow source af3;
				end subp1;

				subprogram implementation subp1.i
				subcomponents
					asub4: abstract a2.i;
				connections
					fconn5: feature asub4.af2 -> af3;
					fconn6: feature asub4.af2 -> asub4.af2;
				flows
					fsource21: flow source param1.da2 -> fconn5 -> af3;
					fsource22: flow source param2.da2 -> fconn5 -> af3;

					etef19: end to end flow param1.da2 -> fconn6 -> asub4.fsink1;
					etef20: end to end flow param2.da2 -> fconn6 -> asub4.fsink1;
				end subp1.i;

				subprogram group subpg1
				prototypes
					subpproto4: subprogram subp1.i;
					subpproto5: subprogram;
				features
					subpa5: provides subprogram access subpproto4;
					subpa6: provides subprogram access subpproto5;
				end subpg1;
			end flowSegmentScopeTest;
			""";

	private static final List<String> ETE_ELEMENTS_A1_I1 = List.of("asub1", "asub2", "da1", "etef1", "etef10",
			"etef11", "etef15", "etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9",
			"fconn1", "fconn2", "fsource1", "fsource10", "fsource11", "fsource12", "fsource13", "fsource14",
			"fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2", "fsource3", "fsource4",
			"fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpa1", "subpa2", "subpgsub1", "subpgsub2",
			"subpgsub3", "subpsub1", "subpsub2");

	private static final List<String> FLOW_ELEMENTS_A1_I1 = List.of("asub1", "asub2", "da1", "fconn1", "fconn2",
			"fsource1", "fsource10", "fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16",
			"fsource17", "fsource18", "fsource19", "fsource2", "fsource3", "fsource4", "fsource5", "fsource6",
			"fsource7", "fsource8", "fsource9", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
			"subpsub2");

	private static final List<String> CONTEXTS_A1_I1 = List.of("asub1", "asub2", "call1", "call12", "call13", "call2",
			"call3", "call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2",
			"subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2");

	private static final List<String> ETE_ELEMENTS_SUBP1_I1 = List.of("asub4", "da4", "etef19", "etef20", "fconn5",
			"fconn6", "fsource21", "fsource22", "subpa4");

	private static final List<String> FLOW_ELEMENTS_SUBP1_I1 = List.of("asub4", "da4", "fconn5", "fconn6", "fsource21",
			"fsource22", "subpa4");

	private static final List<String> ETE_ELEMENTS_A2_I = List.of("asub3", "da2", "etef18", "fconn3", "fconn4",
			"fsink1", "fsource20");

	private static final List<String> FLOW_ELEMENTS_A2_I = List.of("asub3", "da2", "fconn3", "fconn4", "fsink1",
			"fsource20");

	private static final List<String> CONTEXTS_SUBP1_I1 = List.of("asub4", "param1", "param2", "subpa4");

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Inject
	AssertHelper assertHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	// Tests scope_FlowSegment_context, scope_FlowSegment_flowElement, scope_EndToEndFlowSegment_context, and
	// scope_EndToEndFlowSegment_flowElement
	@Test
	public void testFlowSegments() throws Exception {
		testFileResult = issues = testHelper.testString(FLOW_SEGMENT_SCOPE_TEST);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(), new ArrayList<>());

		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("flowSegmentScopeTest", pkg.getName());
		var classifiers = pkg.getPublicSection().getOwnedClassifiers();
		var a1_i = (AbstractImplementation) classifiers.get(1);
		assertEquals("a1.i", a1_i.getName());

		var flow = flowImplementation(a1_i, 0, "fsource1");
		assertFlowElementScope(flow, FLOW_ELEMENTS_A1_I1);
		assertFlowSegment(flow, 0, null, "asub1", CONTEXTS_A1_I1, FLOW_ELEMENTS_A1_I1,
				"Connection 'fconn1' continues inside subcomponent 'asub1'");
		assertFlowSegment(flow, 1, null, "fconn1", CONTEXTS_A1_I1, FLOW_ELEMENTS_A1_I1);

		flow = flowImplementation(a1_i, 1, "fsource2");
		assertFlowElementScope(flow, FLOW_ELEMENTS_A1_I1);
		assertFlowSegment(flow, 0, "fg1", "da3", CONTEXTS_A1_I1, List.of("da3", "subpa3"),
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Feature Group.Data Access 'fg1.da3'");
		assertFlowSegment(flow, 1, null, "fconn1", CONTEXTS_A1_I1, FLOW_ELEMENTS_A1_I1);

		flow = flowImplementation(a1_i, 2, "fsource3");
		assertFlowElementScope(flow, FLOW_ELEMENTS_A1_I1);
		assertFlowSegment(flow, 0, "fg2", "da3", CONTEXTS_A1_I1, List.of("da3", "subpa3"),
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Feature Group.Data Access 'fg2.da3'");
		assertFlowSegment(flow, 1, null, "fconn1", CONTEXTS_A1_I1, FLOW_ELEMENTS_A1_I1);

		flow = flowImplementation(a1_i, 3, "fsource4");
		assertFlowElementScope(flow, FLOW_ELEMENTS_A1_I1);
		assertFlowSegment(flow, 0, "asub1", "fsource20", CONTEXTS_A1_I1, FLOW_ELEMENTS_A2_I);
		assertFlowSegment(flow, 1, null, "fconn1", CONTEXTS_A1_I1, FLOW_ELEMENTS_A1_I1);

		flow = flowImplementation(a1_i, 4, "fsource5");
		assertFlowElementScope(flow, FLOW_ELEMENTS_A1_I1);
		assertFlowSegment(flow, 0, "asub2", "fsource20", CONTEXTS_A1_I1, FLOW_ELEMENTS_A2_I);
		assertFlowSegment(flow, 1, null, "fconn1", CONTEXTS_A1_I1, FLOW_ELEMENTS_A1_I1);

		flow = flowImplementation(a1_i, 5, "fsource6");
		assertFlowElementScope(flow, FLOW_ELEMENTS_A1_I1);
		assertFlowSegment(flow, 0, "call1", "da4", CONTEXTS_A1_I1, FLOW_ELEMENTS_SUBP1_I1,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call1.da4'");
		assertFlowSegment(flow, 1, null, "fconn1", CONTEXTS_A1_I1, FLOW_ELEMENTS_A1_I1);

		flow = flowImplementation(a1_i, 6, "fsource7");
		assertFlowElementScope(flow, FLOW_ELEMENTS_A1_I1);
		assertFlowSegment(flow, 0, "call2", "da4", CONTEXTS_A1_I1, FLOW_ELEMENTS_SUBP1_I1,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call2.da4'");
		assertFlowSegment(flow, 1, null, "fconn1", CONTEXTS_A1_I1, FLOW_ELEMENTS_A1_I1);

		flow = flowImplementation(a1_i, 7, "fsource8");
		assertFlowElementScope(flow, FLOW_ELEMENTS_A1_I1);
		assertFlowSegment(flow, 0, "call3", "da4", CONTEXTS_A1_I1, FLOW_ELEMENTS_SUBP1_I1,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call3.da4'");
		assertFlowSegment(flow, 1, null, "fconn1", CONTEXTS_A1_I1, FLOW_ELEMENTS_A1_I1);

		flow = flowImplementation(a1_i, 8, "fsource9");
		assertFlowElementScope(flow, FLOW_ELEMENTS_A1_I1);
		assertFlowSegment(flow, 0, "call4", "da4", CONTEXTS_A1_I1, FLOW_ELEMENTS_SUBP1_I1,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call4.da4'");
		assertFlowSegment(flow, 1, null, "fconn1", CONTEXTS_A1_I1, FLOW_ELEMENTS_A1_I1);

		flow = flowImplementation(a1_i, 9, "fsource10");
		assertFlowElementScope(flow, FLOW_ELEMENTS_A1_I1);
		assertFlowSegment(flow, 0, "call5", "da4", CONTEXTS_A1_I1, FLOW_ELEMENTS_SUBP1_I1,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call5.da4'");
		assertFlowSegment(flow, 1, null, "fconn1", CONTEXTS_A1_I1, FLOW_ELEMENTS_A1_I1);

		flow = flowImplementation(a1_i, 10, "fsource11");
		assertFlowElementScope(flow, FLOW_ELEMENTS_A1_I1);
		assertFlowSegment(flow, 0, "call6", "da4", CONTEXTS_A1_I1, FLOW_ELEMENTS_SUBP1_I1,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call6.da4'");
		assertFlowSegment(flow, 1, null, "fconn1", CONTEXTS_A1_I1, FLOW_ELEMENTS_A1_I1);

		flow = flowImplementation(a1_i, 11, "fsource12");
		assertFlowElementScope(flow, FLOW_ELEMENTS_A1_I1);
		assertFlowSegment(flow, 0, "call7", "da4", CONTEXTS_A1_I1, FLOW_ELEMENTS_SUBP1_I1,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call7.da4'");
		assertFlowSegment(flow, 1, null, "fconn1", CONTEXTS_A1_I1, FLOW_ELEMENTS_A1_I1);

		flow = flowImplementation(a1_i, 12, "fsource13");
		assertFlowElementScope(flow, FLOW_ELEMENTS_A1_I1);
		assertFlowSegment(flow, 0, "call8", "da4", CONTEXTS_A1_I1, FLOW_ELEMENTS_SUBP1_I1,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call8.da4'");
		assertFlowSegment(flow, 1, null, "fconn1", CONTEXTS_A1_I1, FLOW_ELEMENTS_A1_I1);

		flow = flowImplementation(a1_i, 13, "fsource17");
		assertFlowElementScope(flow, FLOW_ELEMENTS_A1_I1);
		assertFlowSegment(flow, 0, "call12", "da4", CONTEXTS_A1_I1, FLOW_ELEMENTS_SUBP1_I1,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call12.da4'");
		assertFlowSegment(flow, 1, null, "fconn1", CONTEXTS_A1_I1, FLOW_ELEMENTS_A1_I1);

		flow = flowImplementation(a1_i, 14, "fsource18");
		assertFlowElementScope(flow, FLOW_ELEMENTS_A1_I1);
		assertFlowSegment(flow, 0, "call13", "da4", CONTEXTS_A1_I1, FLOW_ELEMENTS_SUBP1_I1,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call13.da4'");
		assertFlowSegment(flow, 1, null, "fconn1", CONTEXTS_A1_I1, FLOW_ELEMENTS_A1_I1);

		var eteFlow = endToEndFlow(a1_i, 0, "etef1");
		assertEndToEndFlowElementScope(eteFlow, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 0, "asub1", "fsource20", CONTEXTS_A1_I1, ETE_ELEMENTS_A2_I);
		// connection end does not match
		assertEndToEndFlowSegment(eteFlow, 1, null, "fconn2", CONTEXTS_A1_I1, ETE_ELEMENTS_A1_I1,
				"The destination of connection 'fconn2' does not match the succeeding subcomponent or in flow spec feature 'asub2.af2'");
		assertEndToEndFlowSegment(eteFlow, 2, "asub2", "fsink1", CONTEXTS_A1_I1, ETE_ELEMENTS_A2_I);

		eteFlow = endToEndFlow(a1_i, 1, "etef2");
		assertEndToEndFlowElementScope(eteFlow, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 0, "fg1", "da3", CONTEXTS_A1_I1, List.of("da3", "subpa3"),
				"Anything in a 'feature group' is not a valid subcomponent flow.");
		assertEndToEndFlowSegment(eteFlow, 1, null, "fconn2", CONTEXTS_A1_I1, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 2, "asub1", "fsink1", CONTEXTS_A1_I1, ETE_ELEMENTS_A2_I);

		eteFlow = endToEndFlow(a1_i, 2, "etef3");
		assertEndToEndFlowElementScope(eteFlow, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 0, "fg2", "da3", CONTEXTS_A1_I1, List.of("da3", "subpa3"),
				"Anything in a 'feature group' is not a valid subcomponent flow.");
		assertEndToEndFlowSegment(eteFlow, 1, null, "fconn2", CONTEXTS_A1_I1, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 2, "asub1", "fsink1", CONTEXTS_A1_I1, ETE_ELEMENTS_A2_I);

		eteFlow = endToEndFlow(a1_i, 3, "etef4");
		assertEndToEndFlowElementScope(eteFlow, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 0, "call1", "da4", CONTEXTS_A1_I1, ETE_ELEMENTS_SUBP1_I1,
				"Anything in a 'subprogram call' is not a valid subcomponent flow.");
		assertEndToEndFlowSegment(eteFlow, 1, null, "fconn2", CONTEXTS_A1_I1, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 2, "asub1", "fsink1", CONTEXTS_A1_I1, ETE_ELEMENTS_A2_I);

		eteFlow = endToEndFlow(a1_i, 4, "etef5");
		assertEndToEndFlowElementScope(eteFlow, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 0, "call2", "da4", CONTEXTS_A1_I1, ETE_ELEMENTS_SUBP1_I1,
				"Anything in a 'subprogram call' is not a valid subcomponent flow.");
		assertEndToEndFlowSegment(eteFlow, 1, null, "fconn2", CONTEXTS_A1_I1, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 2, "asub1", "fsink1", CONTEXTS_A1_I1, ETE_ELEMENTS_A2_I);

		eteFlow = endToEndFlow(a1_i, 5, "etef6");
		assertEndToEndFlowElementScope(eteFlow, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 0, "call3", "da4", CONTEXTS_A1_I1, ETE_ELEMENTS_SUBP1_I1,
				"Anything in a 'subprogram call' is not a valid subcomponent flow.");
		assertEndToEndFlowSegment(eteFlow, 1, null, "fconn2", CONTEXTS_A1_I1, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 2, "asub1", "fsink1", CONTEXTS_A1_I1, ETE_ELEMENTS_A2_I);

		eteFlow = endToEndFlow(a1_i, 6, "etef7");
		assertEndToEndFlowElementScope(eteFlow, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 0, "call4", "da4", CONTEXTS_A1_I1, ETE_ELEMENTS_SUBP1_I1,
				"Anything in a 'subprogram call' is not a valid subcomponent flow.");
		assertEndToEndFlowSegment(eteFlow, 1, null, "fconn2", CONTEXTS_A1_I1, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 2, "asub1", "fsink1", CONTEXTS_A1_I1, ETE_ELEMENTS_A2_I);

		eteFlow = endToEndFlow(a1_i, 7, "etef8");
		assertEndToEndFlowElementScope(eteFlow, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 0, "call5", "da4", CONTEXTS_A1_I1, ETE_ELEMENTS_SUBP1_I1,
				"Anything in a 'subprogram call' is not a valid subcomponent flow.");
		assertEndToEndFlowSegment(eteFlow, 1, null, "fconn2", CONTEXTS_A1_I1, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 2, "asub1", "fsink1", CONTEXTS_A1_I1, ETE_ELEMENTS_A2_I);

		eteFlow = endToEndFlow(a1_i, 8, "etef9");
		assertEndToEndFlowElementScope(eteFlow, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 0, "call6", "da4", CONTEXTS_A1_I1, ETE_ELEMENTS_SUBP1_I1,
				"Anything in a 'subprogram call' is not a valid subcomponent flow.");
		assertEndToEndFlowSegment(eteFlow, 1, null, "fconn2", CONTEXTS_A1_I1, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 2, "asub1", "fsink1", CONTEXTS_A1_I1, ETE_ELEMENTS_A2_I);

		eteFlow = endToEndFlow(a1_i, 9, "etef10");
		assertEndToEndFlowElementScope(eteFlow, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 0, "call7", "da4", CONTEXTS_A1_I1, ETE_ELEMENTS_SUBP1_I1,
				"Anything in a 'subprogram call' is not a valid subcomponent flow.");
		assertEndToEndFlowSegment(eteFlow, 1, null, "fconn2", CONTEXTS_A1_I1, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 2, "asub1", "fsink1", CONTEXTS_A1_I1, ETE_ELEMENTS_A2_I);

		eteFlow = endToEndFlow(a1_i, 10, "etef11");
		assertEndToEndFlowElementScope(eteFlow, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 0, "call8", "da4", CONTEXTS_A1_I1, ETE_ELEMENTS_SUBP1_I1,
				"Anything in a 'subprogram call' is not a valid subcomponent flow.");
		assertEndToEndFlowSegment(eteFlow, 1, null, "fconn2", CONTEXTS_A1_I1, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 2, "asub1", "fsink1", CONTEXTS_A1_I1, ETE_ELEMENTS_A2_I);

		eteFlow = endToEndFlow(a1_i, 11, "etef15");
		assertEndToEndFlowElementScope(eteFlow, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 0, "call12", "da4", CONTEXTS_A1_I1, ETE_ELEMENTS_SUBP1_I1,
				"Anything in a 'subprogram call' is not a valid subcomponent flow.");
		assertEndToEndFlowSegment(eteFlow, 1, null, "fconn2", CONTEXTS_A1_I1, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 2, "asub1", "fsink1", CONTEXTS_A1_I1, ETE_ELEMENTS_A2_I);

		eteFlow = endToEndFlow(a1_i, 12, "etef16");
		assertEndToEndFlowElementScope(eteFlow, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 0, "call13", "da4", CONTEXTS_A1_I1, ETE_ELEMENTS_SUBP1_I1,
				"Anything in a 'subprogram call' is not a valid subcomponent flow.");
		assertEndToEndFlowSegment(eteFlow, 1, null, "fconn2", CONTEXTS_A1_I1, ETE_ELEMENTS_A1_I1);
		assertEndToEndFlowSegment(eteFlow, 2, "asub1", "fsink1", CONTEXTS_A1_I1, ETE_ELEMENTS_A2_I);

		var a2_i = (AbstractImplementation) classifiers.get(3);
		assertEquals("a2.i", a2_i.getName());

		eteFlow = endToEndFlow(a2_i, 0, "etef18");
		assertEndToEndFlowElementScope(eteFlow, ETE_ELEMENTS_A2_I);
		assertEndToEndFlowSegment(eteFlow, 0, "asub3", "fsource20", List.of("asub3"),
				List.of("da2", "fsink1", "fsource20"));
		assertEndToEndFlowSegment(eteFlow, 1, null, "fconn4", List.of("asub3"), ETE_ELEMENTS_A2_I);
		assertEndToEndFlowSegment(eteFlow, 2, "asub3", "fsink1", List.of("asub3"),
				List.of("da2", "fsink1", "fsource20"));

		var subp1_i = (SubprogramImplementation) classifiers.get(6);
		assertEquals("subp1.i", subp1_i.getName());

		flow = flowImplementation(subp1_i, 0, "fsource21");
		assertFlowElementScope(flow, FLOW_ELEMENTS_SUBP1_I1);
		assertFlowSegment(flow, 0, "param1", "da2", CONTEXTS_SUBP1_I1, FLOW_ELEMENTS_A2_I,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Parameter.Data Access 'param1.da2'");
		assertFlowSegment(flow, 1, null, "fconn5", CONTEXTS_SUBP1_I1, FLOW_ELEMENTS_SUBP1_I1);

		flow = flowImplementation(subp1_i, 1, "fsource22");
		assertFlowElementScope(flow, FLOW_ELEMENTS_SUBP1_I1);
		assertFlowSegment(flow, 0, "param2", "da2", CONTEXTS_SUBP1_I1, FLOW_ELEMENTS_A2_I,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Parameter.Data Access 'param2.da2'");
		assertFlowSegment(flow, 1, null, "fconn5", CONTEXTS_SUBP1_I1, FLOW_ELEMENTS_SUBP1_I1);

		eteFlow = endToEndFlow(subp1_i, 0, "etef19");
		assertEndToEndFlowElementScope(eteFlow, ETE_ELEMENTS_SUBP1_I1);
		assertEndToEndFlowSegment(eteFlow, 0, "param1", "da2", CONTEXTS_SUBP1_I1, ETE_ELEMENTS_A2_I,
				"Anything in a 'parameter' is not a valid subcomponent flow.");
		assertEndToEndFlowSegment(eteFlow, 1, null, "fconn6", CONTEXTS_SUBP1_I1, ETE_ELEMENTS_SUBP1_I1);
		assertEndToEndFlowSegment(eteFlow, 2, "asub4", "fsink1", CONTEXTS_SUBP1_I1, ETE_ELEMENTS_A2_I);

		eteFlow = endToEndFlow(subp1_i, 1, "etef20");
		assertEndToEndFlowElementScope(eteFlow, ETE_ELEMENTS_SUBP1_I1);
		assertEndToEndFlowSegment(eteFlow, 0, "param2", "da2", CONTEXTS_SUBP1_I1, ETE_ELEMENTS_A2_I,
				"Anything in a 'parameter' is not a valid subcomponent flow.");
		assertEndToEndFlowSegment(eteFlow, 1, null, "fconn6", CONTEXTS_SUBP1_I1, ETE_ELEMENTS_SUBP1_I1);
		assertEndToEndFlowSegment(eteFlow, 2, "asub4", "fsink1", CONTEXTS_SUBP1_I1, ETE_ELEMENTS_A2_I);

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private static FlowImplementation flowImplementation(ComponentImplementation implementation, int index,
			String specificationName) {
		var flow = implementation.getOwnedFlowImplementations().get(index);
		assertEquals(specificationName, flow.getSpecification().getName());
		return flow;
	}

	private static EndToEndFlow endToEndFlow(ComponentImplementation implementation, int index, String name) {
		var flow = implementation.getOwnedEndToEndFlows().get(index);
		assertEquals(name, flow.getName());
		return flow;
	}

	/**
	 * @param contextName the expected name of the segment's context, or null if the segment has no context
	 * @param errors the errors expected on the segment
	 */
	private void assertFlowSegment(FlowImplementation flow, int index, String contextName, String elementName,
			List<String> contextScope, List<String> flowElementScope, String... errors) {
		var segment = flow.getOwnedFlowSegments().get(index);
		assertContext(contextName, segment.getContext());
		assertEquals(elementName, segment.getFlowElement().getName());
		if (errors.length > 0) {
			AssertHelper.assertError(segment, testFileResult.getIssues(), issueCollection, errors);
		}
		assertHelper.assertScope(segment, Aadl2Package.eINSTANCE.getFlowSegment_Context(), contextScope);
		assertFlowElementScope(segment, flowElementScope);
	}

	/**
	 * @param contextName the expected name of the segment's context, or null if the segment has no context
	 * @param errors the errors expected on the segment
	 */
	private void assertEndToEndFlowSegment(EndToEndFlow flow, int index, String contextName, String elementName,
			List<String> contextScope, List<String> flowElementScope, String... errors) {
		var segment = flow.getOwnedEndToEndFlowSegments().get(index);
		assertContext(contextName, segment.getContext());
		assertEquals(elementName, segment.getFlowElement().getName());
		if (errors.length > 0) {
			AssertHelper.assertError(segment, testFileResult.getIssues(), issueCollection, errors);
		}
		assertHelper.assertScope(segment, Aadl2Package.eINSTANCE.getEndToEndFlowSegment_Context(), contextScope);
		assertEndToEndFlowElementScope(segment, flowElementScope);
	}

	private static void assertContext(String expectedName, Context context) {
		if (expectedName == null) {
			assertNull(context);
		} else {
			assertEquals(expectedName, context.getName());
		}
	}

	private void assertFlowElementScope(EObject object, List<String> expected) {
		assertHelper.assertScope(object, Aadl2Package.eINSTANCE.getFlowSegment_FlowElement(), expected);
	}

	private void assertEndToEndFlowElementScope(EObject object, List<String> expected) {
		assertHelper.assertScope(object, Aadl2Package.eINSTANCE.getEndToEndFlowSegment_FlowElement(), expected);
	}
}
