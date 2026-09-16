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
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Connection;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.SystemImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1974Test extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue1974/";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	@Test
	public void testPorts() throws Exception {
		parse("ports.aadl");
		// no errors
		assertAllIssuesReported();
	}

	@Test
	public void testDataAccess() throws Exception {
		parse("data_access.aadl");
		// no errors
		assertAllIssuesReported();
	}

	@Test
	public void testPortsUnidirectional() throws Exception {
		var pkg = parse("ports_unidirectional.aadl");
		assertEquals("ports_unidirectional", pkg.getName());

		var topI = systemImplementation(pkg, "top.i");
		var e2e2a = endToEndFlow(topI, "e2e_2a");
		assertConnectionSegmentErrors(e2e2a, 1, "c1",
				"The source of connection 'c1' does not match the preceding subcomponent or out flow spec feature 'c'",
				"The destination of connection 'c1' does not match the succeeding subcomponent or in flow spec feature 'm'");
		assertConnectionSegmentErrors(e2e2a, 3, "c0",
				"The source of connection 'c0' does not match the preceding subcomponent or out flow spec feature 'm'",
				"The destination of connection 'c0' does not match the succeeding subcomponent or in flow spec feature 'p'");
		var e2e3b = endToEndFlow(topI, "e2e_3b");
		assertConnectionSegmentErrors(e2e3b, 1, "c1",
				"The source of connection 'c1' does not match the preceding subcomponent or out flow spec feature 'c.x'",
				"The destination of connection 'c1' does not match the succeeding subcomponent or in flow spec feature 'm.x'");
		assertConnectionSegmentErrors(e2e3b, 3, "c0",
				"The source of connection 'c0' does not match the preceding subcomponent or out flow spec feature 'm.x'",
				"The destination of connection 'c0' does not match the succeeding subcomponent or in flow spec feature 'p.x'");

		var topI2 = systemImplementation(pkg, "top.i2");
		var e2e1a = endToEndFlow(topI2, "e2e_1a");
		assertConnectionSegmentErrors(e2e1a, 1, "c0",
				"The source of connection 'c0' does not match the preceding subcomponent or out flow spec feature 'p'",
				"The destination of connection 'c0' does not match the succeeding subcomponent or in flow spec feature 'm'");
		assertConnectionSegmentErrors(e2e1a, 3, "c1",
				"The source of connection 'c1' does not match the preceding subcomponent or out flow spec feature 'm'",
				"The destination of connection 'c1' does not match the succeeding subcomponent or in flow spec feature 'c'");
		var e2e1b = endToEndFlow(topI2, "e2e_1b");
		assertConnectionSegmentErrors(e2e1b, 1, "c0",
				"The source of connection 'c0' does not match the preceding subcomponent or out flow spec feature 'p.x'",
				"The destination of connection 'c0' does not match the succeeding subcomponent or in flow spec feature 'm.x'");
		assertConnectionSegmentErrors(e2e1b, 3, "c1",
				"The source of connection 'c1' does not match the preceding subcomponent or out flow spec feature 'm.x'",
				"The destination of connection 'c1' does not match the succeeding subcomponent or in flow spec feature 'c.x'");

		assertAllIssuesReported();
	}

	@Test
	public void testPortsBadEndpoints() throws Exception {
		var pkg = parse("ports_bad_endpoints.aadl");
		assertEquals("ports_bad_endpoints", pkg.getName());

		var topI = systemImplementation(pkg, "top.i");
		assertConnectionSegmentErrors(endToEndFlow(topI, "e2e_12_incorrect"), 1, "c12",
				"The destination of connection 'c12' does not match the succeeding subcomponent or in flow spec feature 'c.ip1'");
		assertConnectionSegmentErrors(endToEndFlow(topI, "e2e_21_incorrect"), 1, "c21",
				"The source of connection 'c21' does not match the preceding subcomponent or out flow spec feature 'p.op1'");
		assertConnectionSegmentErrors(endToEndFlow(topI, "e2e_22_incorrect"), 1, "c22",
				"The source of connection 'c22' does not match the preceding subcomponent or out flow spec feature 'p.op1'",
				"The destination of connection 'c22' does not match the succeeding subcomponent or in flow spec feature 'c.ip1'");

		var topI2 = systemImplementation(pkg, "top.i2");
		assertConnectionSegmentErrors(endToEndFlow(topI2, "e2e_12_incorrect"), 1, "c12",
				"The destination of connection 'c12' does not match the succeeding subcomponent or in flow spec feature 'c1.ip1'");
		assertConnectionSegmentErrors(endToEndFlow(topI2, "e2e_21_incorrect"), 1, "c21",
				"The source of connection 'c21' does not match the preceding subcomponent or out flow spec feature 'p1.op1'");
		assertConnectionSegmentErrors(endToEndFlow(topI2, "e2e_22_incorrect"), 1, "c22",
				"The source of connection 'c22' does not match the preceding subcomponent or out flow spec feature 'p1.op1'",
				"The destination of connection 'c22' does not match the succeeding subcomponent or in flow spec feature 'c1.ip1'");
		assertConnectionSegmentErrors(endToEndFlow(topI2, "e2e_12s_incorrect"), 1, "c12",
				"The destination of connection 'c12' does not match the succeeding subcomponent or in flow spec feature 'c1'");
		assertConnectionSegmentErrors(endToEndFlow(topI2, "e2e_21s_incorrect"), 1, "c21",
				"The source of connection 'c21' does not match the preceding subcomponent or out flow spec feature 'p1'");
		assertConnectionSegmentErrors(endToEndFlow(topI2, "e2e_22s_incorrect"), 1, "c22",
				"The source of connection 'c22' does not match the preceding subcomponent or out flow spec feature 'p1'",
				"The destination of connection 'c22' does not match the succeeding subcomponent or in flow spec feature 'c1'");

		assertAllIssuesReported();
	}

	private AadlPackage parse(String fileName) throws Exception {
		testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + fileName);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(), new ArrayList<>());
		return (AadlPackage) testFileResult.getResource().getContents().getFirst();
	}

	private void assertAllIssuesReported() {
		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private static SystemImplementation systemImplementation(AadlPackage pkg, String name) {
		return (SystemImplementation) pkg.getPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> name.equals(classifier.getName()))
				.findFirst()
				.orElseThrow();
	}

	private static EndToEndFlow endToEndFlow(SystemImplementation implementation, String name) {
		return implementation.getOwnedEndToEndFlows()
				.stream()
				.filter(flow -> name.equals(flow.getName()))
				.findFirst()
				.orElseThrow();
	}

	private void assertConnectionSegmentErrors(EndToEndFlow flow, int segmentIndex, String connectionName,
			String... messages) {
		var segment = flow.getOwnedEndToEndFlowSegments().get(segmentIndex);
		var flowElement = segment.getFlowElement();
		assertTrue(flowElement instanceof Connection);
		assertEquals(connectionName, flowElement.getName());
		AssertHelper.assertError(segment, testFileResult.getIssues(), issueCollection, messages);
	}
}
