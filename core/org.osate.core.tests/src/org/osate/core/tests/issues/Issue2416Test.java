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
public class Issue2416Test extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	@Test
	public void issue2416Test() throws Exception {
		testFileResult = issues = testHelper.testFile("org.osate.core.tests/models/Issue2416/Issue2416.aadl");
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals("Issue2416", pkg.getName());

		AbstractImplementation impl = (AbstractImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals("A.i", impl.getName());
		var flows = impl.getAllFlowImplementations();

		assertSegmentErrors(flows.get(1).getOwnedFlowSegments().get(2),
				sourceMismatch("cml", "mm1.fpth"), destinationMismatch("cml", "mm2.fpth"));
		assertSegmentErrors(flows.get(2).getOwnedFlowSegments().get(2),
				sourceMismatch("cmr", "mm1.fpth"), destinationMismatch("cmr", "mm2.fpth"));
		assertSegmentErrors(flows.get(2).getOwnedFlowSegments().get(4),
				"The destination of connection 'cmm' does not match the out flow feature 'o'",
				sourceMismatch("cmm", "mm2.fpth"));
		assertSegmentErrors(flows.get(3).getOwnedFlowSegments().get(2), sourceMismatch("cmr", "mm1.fpth"));
		assertSegmentErrors(flows.get(4).getOwnedFlowSegments().get(0), destinationMismatch("cml", "mm2.fpth"));
		assertSegmentErrors(flows.get(6).getOwnedFlowSegments().get(1),
				sourceMismatch("cml", "mm1.fsrc"), destinationMismatch("cml", "mm2.fpth"));
		assertSegmentErrors(flows.get(7).getOwnedFlowSegments().get(1), sourceMismatch("cmr", "mm1.fsrc"));
		assertSegmentErrors(flows.get(9).getOwnedFlowSegments().get(2),
				sourceMismatch("cml", "mm1.fpth"), destinationMismatch("cml", "mm2.fsnk"));
		assertSegmentErrors(flows.get(10).getOwnedFlowSegments().get(0), destinationMismatch("cml", "mm2.fsnk"));
		assertSegmentErrors(flows.get(11).getOwnedFlowSegments().get(0),
				"The source of connection 'cmm' does not match the in flow feature 'i'");

		issueCollection.sizeIs(17);
		assertConstraints(issueCollection);
	}

	private void assertSegmentErrors(FlowSegment segment, String... expectedMessages) {
		AssertHelper.assertError(segment, testFileResult.getIssues(), issueCollection, expectedMessages);
	}

	private static String sourceMismatch(String connection, String flowSpec) {
		return "The source of connection '" + connection
				+ "' does not match the out flow feature of the preceding subcomponent flow specification '" + flowSpec
				+ "'";
	}

	private static String destinationMismatch(String connection, String flowSpec) {
		return "The destination of connection '" + connection
				+ "' does not match the in flow feature of the succeeding subcomponent flow specification '" + flowSpec
				+ "'";
	}
}
