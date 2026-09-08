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

import java.util.ArrayList;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2415Test extends XtextTest {
	private static final String FLOW_SOURCE_IN_PATH = "Flow sources are not allowed in a flow path implementation";

	private static final String FLOW_SINK_IN_PATH = "Flow sinks are not allowed in a flow path implementation";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue2415Test() throws Exception {
		FluentIssueCollection testFileResult = issues = testHelper
				.testFile("org.osate.core.tests/models/Issue2415/Issue2415.aadl");
		FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals("Issue2415", pkg.getName());

		AbstractImplementation impl = (AbstractImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals("A.impl", impl.getName());
		var flows = impl.getAllFlowImplementations();

		assertSegmentError(testFileResult, issueCollection, flows.get(1).getOwnedFlowSegments().get(1),
				FLOW_SOURCE_IN_PATH);
		assertSegmentError(testFileResult, issueCollection, flows.get(2).getOwnedFlowSegments().get(1),
				FLOW_SINK_IN_PATH);
		assertSegmentError(testFileResult, issueCollection, flows.get(3).getOwnedFlowSegments().get(1),
				FLOW_SOURCE_IN_PATH);
		assertSegmentError(testFileResult, issueCollection, flows.get(4).getOwnedFlowSegments().get(0),
				"The destination of connection 'cml' does not match the in flow feature of the succeeding"
						+ " subcomponent flow specification 'mm2.fsnk'");
		assertSegmentError(testFileResult, issueCollection, flows.get(4).getOwnedFlowSegments().get(1),
				FLOW_SINK_IN_PATH);
		assertSegmentError(testFileResult, issueCollection, flows.get(7).getOwnedFlowSegments().get(2),
				"Flow source is only allowed as the first element of a flow source implementation");
		assertSegmentError(testFileResult, issueCollection, flows.get(8).getOwnedFlowSegments().get(2),
				"Flow sink is only allowed as the last element of a flow sink implementation");
		assertSegmentError(testFileResult, issueCollection, flows.get(11).getOwnedFlowSegments().get(1),
				"Flow source is only allowed as the first element of a flow source implementation");
		assertSegmentError(testFileResult, issueCollection, flows.get(12).getOwnedFlowSegments().get(1),
				"Flow sink is only allowed as the last element of a flow sink implementation");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private static void assertSegmentError(FluentIssueCollection testFileResult, FluentIssueCollection issueCollection,
			FlowSegment segment, String expectedMessage) {
		AssertHelper.assertError(segment, testFileResult.getIssues(), issueCollection, expectedMessage);
	}
}
