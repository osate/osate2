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
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ThreadImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1954Test extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue1954/";

	private static final String NOT_A_PORT_END = "A 'parameter' in a 'subprogram subcomponent' is not a valid port connection end.";

	private static final String NOT_A_PARAMETER_END = "Anything in a 'subprogram subcomponent' is not a valid parameter connection end.";

	private static final String NOT_AN_ACCESS_END = "A 'parameter' in a 'subprogram subcomponent' is not a valid access connection end.";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	@Test
	public void testConnections() throws Exception {
		testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "test.aadl");
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals("test", pkg.getName());

		ThreadImplementation threadImpl = (ThreadImplementation) pkg.getPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> "th.i".equals(classifier.getName()))
				.findFirst()
				.orElse(null);

		assertDestinationError(threadImpl.getOwnedPortConnections(), "bad1", NOT_A_PORT_END);
		assertSourceError(threadImpl.getOwnedPortConnections(), "bad2", NOT_A_PORT_END);
		assertDestinationError(threadImpl.getOwnedParameterConnections(), "bad10", NOT_A_PARAMETER_END);
		assertSourceError(threadImpl.getOwnedParameterConnections(), "bad11", NOT_A_PARAMETER_END);
		assertDestinationError(threadImpl.getOwnedAccessConnections(), "bad20", NOT_AN_ACCESS_END);
		assertSourceError(threadImpl.getOwnedAccessConnections(), "bad21", NOT_AN_ACCESS_END);
		assertDestinationError(threadImpl.getOwnedFeatureConnections(), "f1", NOT_A_PARAMETER_END);
		assertSourceError(threadImpl.getOwnedFeatureConnections(), "f2", NOT_A_PARAMETER_END);
		assertDestinationError(threadImpl.getOwnedFeatureConnections(), "f5", NOT_A_PARAMETER_END);
		assertSourceError(threadImpl.getOwnedFeatureConnections(), "f6", NOT_A_PARAMETER_END);

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private void assertSourceError(List<? extends Connection> connections, String name, String expectedMessage) {
		AssertHelper.assertError((EObject) named(connections, name).getSource(), testFileResult.getIssues(),
				issueCollection, expectedMessage);
	}

	private void assertDestinationError(List<? extends Connection> connections, String name, String expectedMessage) {
		AssertHelper.assertError((EObject) named(connections, name).getDestination(), testFileResult.getIssues(),
				issueCollection, expectedMessage);
	}

	private static Connection named(List<? extends Connection> connections, String name) {
		return connections.stream().filter(connection -> name.equals(connection.getName())).findFirst().orElse(null);
	}
}
