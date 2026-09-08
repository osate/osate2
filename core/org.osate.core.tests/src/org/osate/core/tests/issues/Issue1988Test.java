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

import java.util.ArrayList;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1988Test extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue1988/";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	private AadlPackage pkg;

	@Test
	public void testPortSrc() throws Exception {
		load("PortSrc.aadl");
		assertSourceWarning("p.i", 0, "Expected feature 'p1' to have classifier 'PortSrc::D'");
		finish();
	}

	@Test
	public void testPortDst() throws Exception {
		load("PortDst.aadl");
		assertDestinationWarning("p.i", 0, "Expected feature 'ip2' to have classifier 'PortDst::D'");
		finish();
	}

	@Test
	public void testPortEmpty() throws Exception {
		load("PortEmpty.aadl");
		finish();
	}

	@Test
	public void testPortOkay() throws Exception {
		load("PortOkay.aadl");
		finish();
	}

	@Test
	public void testAccessSrc() throws Exception {
		load("AccessSrc.aadl");
		assertSourceWarning("p.i", 0, "Expected feature 'p1' to have classifier 'AccessSrc::D'");
		assertSourceWarning("t1.i", 0, "Expected subcomponent 'd' to have classifier 'AccessSrc::D'");
		finish();
	}

	@Test
	public void testAccessDst() throws Exception {
		load("AccessDst.aadl");
		assertDestinationWarning("p.i", 0, "Expected feature 'ip2' to have classifier 'AccessDst::D'");
		assertDestinationWarning("t1.i", 0, "Expected feature 'p2' to have classifier 'AccessDst::D'");
		finish();
	}

	@Test
	public void testAccessEmpty() throws Exception {
		load("AccessEmpty.aadl");
		finish();
	}

	@Test
	public void testAccessOkay() throws Exception {
		load("AccessOkay.aadl");
		finish();
	}

	@Test
	public void testParameterSrc() throws Exception {
		load("ParameterSrc.aadl");
		assertSourceWarning("th2.bad", 0, "Expected feature 'ip2' to have classifier 'ParameterSrc::D'");
		assertSourceWarning("th2.bad", 1, "Expected feature 'p2' to have classifier 'ParameterSrc::D'");
		finish();
	}

	@Test
	public void testParameterDst() throws Exception {
		load("ParameterDst.aadl");
		assertDestinationWarning("th2.bad", 0, "Expected feature 'p1' to have classifier 'ParameterDst::D'");
		assertDestinationWarning("th2.bad", 1,
				"Expected subcomponent 'myData' to have classifier 'ParameterDst::D'");
		finish();
	}

	@Test
	public void testParameterEmpty() throws Exception {
		load("ParameterEmpty.aadl");
		finish();
	}

	@Test
	public void testParameterOkay() throws Exception {
		load("ParameterOkay.aadl");
		finish();
	}

	private void load(String file) throws Exception {
		testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + file);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
	}

	private void finish() {
		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private ComponentImplementation implementationNamed(String name) {
		return (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> name.equals(classifier.getName()))
				.findFirst()
				.orElse(null);
	}

	private void assertSourceWarning(String implName, int connectionIndex, String expectedMessage) {
		var source = implementationNamed(implName).getOwnedConnections().get(connectionIndex).getSource();
		AssertHelper.assertWarning(source, testFileResult.getIssues(), issueCollection, expectedMessage);
	}

	private void assertDestinationWarning(String implName, int connectionIndex, String expectedMessage) {
		var destination = implementationNamed(implName).getOwnedConnections().get(connectionIndex).getDestination();
		AssertHelper.assertWarning(destination, testFileResult.getIssues(), issueCollection, expectedMessage);
	}
}
