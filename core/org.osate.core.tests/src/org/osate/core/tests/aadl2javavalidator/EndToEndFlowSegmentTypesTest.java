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
package org.osate.core.tests.aadl2javavalidator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class EndToEndFlowSegmentTypesTest extends XtextTest {
	private static final String LEGAL_ETE_FLOW_SEGMENTS_TYPE_TEST = """
			package legalETEFlowSegmentsTypeTest
			public
				abstract a1
				features
					da1: provides data access;
					af1: feature;
					dp1: in data port a3.i;
					edp1: in event data port a3.i;
					fg1: feature group fgt1;
				flows
					fpath1: flow path af1 -> af1;
				end a1;

				abstract implementation a1.i
				subcomponents
					asub1: abstract a2.i;
				calls sequence1: {
					call1: subprogram subp1.i;
				};
				connections
					fconn1: feature asub1.af2 -> asub1.af2;
				flows
					--EndToEndFlow (at ETEConnectionFlow)
					etef1: end to end flow asub1.fpath2 -> etef2 -> asub1.fpath2;
					--Connection (at ETEConnectionFlow)
					etef2: end to end flow asub1.fpath2 -> fconn1 -> asub1.fpath2;
					--DataAccess (at ETEConnectionFlow)
					etef3: end to end flow asub1.fpath2 -> da1 -> asub1.fpath2;
					--FlowSpecification (at ETEConnectionFlow)
					etef4: end to end flow asub1.fpath2 -> fpath1 -> asub1.fpath2;
					--Subcomponent (at ETEConnectionFlow)
					etef5: end to end flow asub1.fpath2 -> asub1 -> asub1.fpath2;

					--EndToEndFlow (at ETESubcomponentFlow)
					etef6: end to end flow etef2 -> fconn1 -> asub1.fpath2;
					--Connection (at ETESubcomponentFlow)
					etef7: end to end flow fconn1 -> fconn1 -> asub1.fpath2;
					--DataAccess (at ETESubcomponentFlow, first and last segments)
					etef8: end to end flow da1 -> fconn1 -> da1;
					--DataAccess (at ETESubcomponentFlow, intermediate segment)
					etef9: end to end flow asub1.fpath2 -> fconn1 -> da1 -> fconn1 -> asub1.fpath2;
					--FlowSpecification (at ETESubcomponentFlow)
					etef10: end to end flow fpath1 -> fconn1 -> asub1.fpath2;
					--Subcomponent (at ETESubcomponentFlow)
					etef11: end to end flow asub1 -> fconn1 -> asub1.fpath2;

					--DataPort.EndToEndFlow
					etef12: end to end flow dp1.etef34 -> fconn1 -> asub1.fpath2;
					--DataPort.Connection
					etef13: end to end flow dp1.fconn3 -> fconn1 -> asub1.fpath2;
					--DataPort.DataAccess
					etef14: end to end flow dp1.da3 -> fconn1 -> asub1.fpath2;
					--DataPort.FlowSpecification
					etef15: end to end flow dp1.fpath3 -> fconn1 -> asub1.fpath2;
					--DataPort.Subcomponent
					etef16: end to end flow dp1.asub3 -> fconn1 -> asub1.fpath2;

					--EventDataPort.EndToEndFlow
					etef17: end to end flow edp1.etef34 -> fconn1 -> asub1.fpath2;
					--EventDataPort.Connection
					etef18: end to end flow edp1.fconn3 -> fconn1 -> asub1.fpath2;
					--EventDataPort.DataAccess
					etef19: end to end flow edp1.da3 -> fconn1 -> asub1.fpath2;
					--EventDataPort.FlowSpecification
					etef20: end to end flow edp1.fpath3 -> fconn1 -> asub1.fpath2;
					--EventDataPort.Subcomponent
					etef21: end to end flow edp1.asub3 -> fconn1 -> asub1.fpath2;

					--FeatureGroup.DataAccess
					etef22: end to end flow fg1.da4 -> fconn1 -> asub1.fpath2;

					--Subcomponent.EndToEndFlow
					etef23: end to end flow asub1.etef33 -> fconn1 -> asub1.fpath2;
					--Subcomponent.Connection
					etef24: end to end flow asub1.fconn2 -> fconn1 -> asub1.fpath2;
					--Subcomponent.DataAccess
					etef25: end to end flow asub1.da2 -> fconn1 -> asub1.fpath2;
					--Subcomponent.FlowSpecification
					etef26: end to end flow asub1.fpath2 -> fconn1 -> asub1.fpath2;
					--Subcomponent.Subcomponent
					etef27: end to end flow asub1.asub2 -> fconn1 -> asub1.fpath2;

					--SubprogramCall.EndToEndFlow
					etef28: end to end flow call1.etef35 -> fconn1 -> asub1.fpath2;
					--SubprogramCall.Connection
					etef29: end to end flow call1.fconn4 -> fconn1 -> asub1.fpath2;
					--SubprogramCall.DataAccess
					etef30: end to end flow call1.da5 -> fconn1 -> asub1.fpath2;
					--SubprogramCall.FlowSpecification
					etef31: end to end flow call1.fpath4 -> fconn1 -> asub1.fpath2;
					--SubprogramCall.Subcomponent
					etef32: end to end flow call1.asub4 -> fconn1 -> asub1.fpath2;
				end a1.i;

				abstract a2
				features
					af2: feature;
					da2: provides data access;
				flows
					fpath2: flow path af2 -> af2;
				end a2;

				abstract implementation a2.i
				subcomponents
					asub2: abstract a2;
				connections
					fconn2: feature asub2.af2 -> asub2.af2;
				flows
					etef33: end to end flow asub2.fpath2 -> fconn2 -> asub2.fpath2;
				end a2.i;

				abstract a3
				features
					da3: provides data access;
					af3: feature;
				flows
					fpath3: flow path af3 -> af3;
				end a3;

				abstract implementation a3.i
				subcomponents
					asub3: abstract a2;
				connections
					fconn3: feature asub3.af2 -> asub3.af2;
				flows
					etef34: end to end flow asub3.fpath2 -> fconn3 -> asub3.fpath2;
				end a3.i;

				feature group fgt1
				features
					da4: provides data access;
				end fgt1;

				subprogram subp1
				features
					param1: in parameter a3.i;
					da5: requires data access;
					af4: feature;
				flows
					fpath4: flow path af4 -> af4;
				end subp1;

				subprogram implementation subp1.i
				subcomponents
					asub4: abstract a3.i;
				connections
					fconn4: feature asub4.af3 -> asub4.af3;
				flows
					--Parameter.EndToEndFlow
					etef35: end to end flow param1.etef34 -> fconn4 -> asub4.fpath3;
					--Parameter.Connection
					etef36: end to end flow param1.fconn3 -> fconn4 -> asub4.fpath3;
					--Parameter.DataAccess
					etef37: end to end flow param1.da3 -> fconn4 -> asub4.fpath3;
					--Parameter.FlowSpecification
					etef38: end to end flow param1.fpath3 -> fconn4 -> asub4.fpath3;
					--Parameter.Subcomponent
					etef39: end to end flow param1.asub3 -> fconn4 -> asub4.fpath3;
				end subp1.i;
			end legalETEFlowSegmentsTypeTest;
			""";

	private static final String NOT_VALID_IN_DATA_PORT = "Anything in a 'data port' is not a valid subcomponent flow.";
	private static final String NOT_VALID_IN_EVENT_DATA_PORT = "Anything in an 'event data port' is not a valid subcomponent flow.";
	private static final String NOT_VALID_IN_SUBPROGRAM_CALL = "Anything in a 'subprogram call' is not a valid subcomponent flow.";
	private static final String NOT_VALID_IN_PARAMETER = "Anything in a 'parameter' is not a valid subcomponent flow.";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	/** Tests typeCheckEndToEndFlowSegments. All assertions below check that validation. */
	@Test
	public void testEndToEndFlowSegmentTypes() throws Exception {
		testFileResult = issues = testHelper.testString(LEGAL_ETE_FLOW_SEGMENTS_TYPE_TEST);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(), new ArrayList<>());

		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("legalETEFlowSegmentsTypeTest", pkg.getName());
		var classifiers = pkg.getPublicSection().getOwnedClassifiers();

		var a1Implementation = (AbstractImplementation) classifiers.get(1);
		assertEquals("a1.i", a1Implementation.getName());
		assertSegmentError(flow(a1Implementation, 0, "etef1"), 1, null, "etef2",
				"Expected Connection, found End To End Flow.");
		assertSegmentError(flow(a1Implementation, 2, "etef3"), 1, null, "da1",
				"Expected Connection, found Data Access.");
		assertSegmentError(flow(a1Implementation, 3, "etef4"), 1, null, "fpath1",
				"Expected Connection, found Flow Specification.");
		assertSegmentError(flow(a1Implementation, 4, "etef5"), 1, null, "asub1",
				"Expected Connection, found Abstract Subcomponent.");
		assertSegmentError(flow(a1Implementation, 6, "etef7"), 0, null, "fconn1",
				"Illegal reference to connection 'fconn1'.  Expecting subcomponent flow or end-to-end flow reference.");
		assertSegmentError(flow(a1Implementation, 9, "etef10"), 0, null, "fpath1",
				"Illegal reference to 'fpath1'.  Cannot refer to a flow specification in the local classifier's namespace.");

		assertSegmentError(flow(a1Implementation, 11, "etef12"), 0, "dp1", "etef34", NOT_VALID_IN_DATA_PORT);
		assertSegmentError(flow(a1Implementation, 12, "etef13"), 0, "dp1", "fconn3", NOT_VALID_IN_DATA_PORT);
		assertSegmentError(flow(a1Implementation, 13, "etef14"), 0, "dp1", "da3", NOT_VALID_IN_DATA_PORT);
		var etef15 = flow(a1Implementation, 14, "etef15");
		assertSegmentError(etef15, 0, "dp1", "fpath3", NOT_VALID_IN_DATA_PORT);
		assertSegmentError(etef15, 1, null, "fconn1", precedingFeatureMismatch("fconn1", "dp1.af3"));
		var etef16 = flow(a1Implementation, 15, "etef16");
		assertSegmentError(etef16, 0, "dp1", "asub3", NOT_VALID_IN_DATA_PORT);
		assertSegmentError(etef16, 1, null, "fconn1", precedingFeatureMismatch("fconn1", "asub3"));

		assertSegmentError(flow(a1Implementation, 16, "etef17"), 0, "edp1", "etef34", NOT_VALID_IN_EVENT_DATA_PORT);
		assertSegmentError(flow(a1Implementation, 17, "etef18"), 0, "edp1", "fconn3", NOT_VALID_IN_EVENT_DATA_PORT);
		assertSegmentError(flow(a1Implementation, 18, "etef19"), 0, "edp1", "da3", NOT_VALID_IN_EVENT_DATA_PORT);
		var etef20 = flow(a1Implementation, 19, "etef20");
		assertSegmentError(etef20, 0, "edp1", "fpath3", NOT_VALID_IN_EVENT_DATA_PORT);
		assertSegmentError(etef20, 1, null, "fconn1", precedingFeatureMismatch("fconn1", "edp1.af3"));
		var etef21 = flow(a1Implementation, 20, "etef21");
		assertSegmentError(etef21, 0, "edp1", "asub3", NOT_VALID_IN_EVENT_DATA_PORT);
		assertSegmentError(etef21, 1, null, "fconn1", precedingFeatureMismatch("fconn1", "asub3"));

		assertSegmentError(flow(a1Implementation, 21, "etef22"), 0, "fg1", "da4",
				"Anything in a 'feature group' is not a valid subcomponent flow.");

		assertSegmentError(flow(a1Implementation, 22, "etef23"), 0, "asub1", "etef33",
				"An 'end to end flow' in an 'abstract subcomponent' is not a valid subcomponent flow.");
		assertSegmentError(flow(a1Implementation, 23, "etef24"), 0, "asub1", "fconn2",
				"A 'feature connection' in an 'abstract subcomponent' is not a valid subcomponent flow.");
		assertSegmentError(flow(a1Implementation, 24, "etef25"), 0, "asub1", "da2",
				"A 'data access' in an 'abstract subcomponent' is not a valid subcomponent flow.");
		var etef27 = flow(a1Implementation, 26, "etef27");
		assertSegmentError(etef27, 0, "asub1", "asub2",
				"An 'abstract subcomponent' in an 'abstract subcomponent' is not a valid subcomponent flow.");
		assertSegmentError(etef27, 1, null, "fconn1", precedingFeatureMismatch("fconn1", "asub2"));

		assertSegmentError(flow(a1Implementation, 27, "etef28"), 0, "call1", "etef35", NOT_VALID_IN_SUBPROGRAM_CALL);
		assertSegmentError(flow(a1Implementation, 28, "etef29"), 0, "call1", "fconn4", NOT_VALID_IN_SUBPROGRAM_CALL);
		assertSegmentError(flow(a1Implementation, 29, "etef30"), 0, "call1", "da5", NOT_VALID_IN_SUBPROGRAM_CALL);
		var etef31 = flow(a1Implementation, 30, "etef31");
		assertSegmentError(etef31, 0, "call1", "fpath4", NOT_VALID_IN_SUBPROGRAM_CALL);
		assertSegmentError(etef31, 1, null, "fconn1", precedingFeatureMismatch("fconn1", "call1.af4"));
		var etef32 = flow(a1Implementation, 31, "etef32");
		assertSegmentError(etef32, 0, "call1", "asub4", NOT_VALID_IN_SUBPROGRAM_CALL);
		assertSegmentError(etef32, 1, null, "fconn1", precedingFeatureMismatch("fconn1", "asub4"));

		var subprogramImplementation = (SubprogramImplementation) classifiers.get(8);
		assertEquals("subp1.i", subprogramImplementation.getName());
		assertSegmentError(flow(subprogramImplementation, 0, "etef35"), 0, "param1", "etef34", NOT_VALID_IN_PARAMETER);
		assertSegmentError(flow(subprogramImplementation, 1, "etef36"), 0, "param1", "fconn3", NOT_VALID_IN_PARAMETER);
		assertSegmentError(flow(subprogramImplementation, 2, "etef37"), 0, "param1", "da3", NOT_VALID_IN_PARAMETER);
		var etef38 = flow(subprogramImplementation, 3, "etef38");
		assertSegmentError(etef38, 0, "param1", "fpath3", NOT_VALID_IN_PARAMETER);
		assertSegmentError(etef38, 1, null, "fconn4", precedingFeatureMismatch("fconn4", "param1.af3"));
		var etef39 = flow(subprogramImplementation, 4, "etef39");
		assertSegmentError(etef39, 0, "param1", "asub3", NOT_VALID_IN_PARAMETER);
		assertSegmentError(etef39, 1, null, "fconn4", precedingFeatureMismatch("fconn4", "asub3"));

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private static EndToEndFlow flow(ComponentImplementation implementation, int index, String name) {
		var flow = implementation.getOwnedEndToEndFlows().get(index);
		assertEquals(name, flow.getName());
		return flow;
	}

	/**
	 * @param contextName the expected name of the segment's context, or null if the segment has no context
	 */
	private void assertSegmentError(EndToEndFlow flow, int segmentIndex, String contextName, String elementName,
			String message) {
		var segment = flow.getOwnedEndToEndFlowSegments().get(segmentIndex);
		if (contextName != null) {
			assertEquals(contextName, segment.getContext().getName());
		}
		assertEquals(elementName, segment.getFlowElement().getName());
		AssertHelper.assertError(segment, testFileResult.getIssues(), issueCollection, message);
	}

	/** The connection end does not match the preceding segment. */
	private static String precedingFeatureMismatch(String connectionName, String feature) {
		return "The source of connection '" + connectionName
				+ "' does not match the preceding subcomponent or out flow spec feature '" + feature + "'";
	}
}
