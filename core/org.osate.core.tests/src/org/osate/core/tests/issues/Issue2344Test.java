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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.SystemImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2344Test extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue2344/";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	private SystemImplementation topImpl;

	@Test
	public void testRegular() throws Exception {
		load("Test.aadl", "Test");

		assertSourceWarning("none_to_d", "Expected feature 'f_none' to have classifier 'Test::D'");
		assertSourceWarning("none_to_di", "Expected feature 'f_none' to have classifier 'Test::D.i'");
		assertDestinationWarning("d_to_none", "Expected feature 'f_none' to have classifier 'Test::D'");
		assertConnectionError("d_to_di", "'f_d' and 'f_di' have incompatible classifiers.");
		assertConnectionError("d_to_x", "'f_d' and 'f_x' have incompatible classifiers.");
		assertDestinationWarning("di_to_none", "Expected feature 'f_none' to have classifier 'Test::D.i'");
		assertConnectionError("di_to_x", "The types of 'f_di' and 'f_x' do not match.");
		assertConnectionError("di_to_dj", "'f_di' and 'f_dj' have incompatible classifiers.");
		assertConnectionError("dj_to_di", "'f_dj' and 'f_di' have incompatible classifiers.");

		finish();
	}

	@Test
	public void testBidirectional() throws Exception {
		load("TestBidirectional.aadl", "TestBidirectional");

		assertSourceWarning("none_to_d", "Expected feature 'f_none' to have classifier 'TestBidirectional::D'");
		assertSourceWarning("none_to_di", "Expected feature 'f_none' to have classifier 'TestBidirectional::D.i'");
		assertDestinationWarning("d_to_none", "Expected feature 'f_none' to have classifier 'TestBidirectional::D'");
		assertDestinationWarning("di_to_none",
				"Expected feature 'f_none' to have classifier 'TestBidirectional::D.i'");
		assertConnectionError("d_to_di", "'f_d' and 'f_di' have incompatible classifiers.");
		assertConnectionError("di_to_d", "'f_di' and 'f_d' have incompatible classifiers.");
		assertConnectionError("d_to_x", "'f_d' and 'f_x' have incompatible classifiers.");
		assertConnectionError("di_to_x", "'f_di' and 'f_x' have incompatible classifiers.");
		assertConnectionError("di_to_dj", "'f_di' and 'f_dj' have incompatible classifiers.");

		finish();
	}

	private void load(String file, String expectedPackageName) throws Exception {
		testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + file);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals(expectedPackageName, pkg.getName());
		topImpl = (SystemImplementation) pkg.getPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> "top.i".equals(classifier.getName()))
				.findFirst()
				.orElse(null);
	}

	private void finish() {
		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private PortConnection connection(String name) {
		return topImpl.getOwnedPortConnections()
				.stream()
				.filter(portConnection -> name.equals(portConnection.getName()))
				.findFirst()
				.orElse(null);
	}

	private void assertSourceWarning(String connectionName, String expectedMessage) {
		AssertHelper.assertWarning((EObject) connection(connectionName).getSource(), testFileResult.getIssues(),
				issueCollection, expectedMessage);
	}

	private void assertDestinationWarning(String connectionName, String expectedMessage) {
		AssertHelper.assertWarning((EObject) connection(connectionName).getDestination(), testFileResult.getIssues(),
				issueCollection, expectedMessage);
	}

	private void assertConnectionError(String connectionName, String expectedMessage) {
		AssertHelper.assertError(connection(connectionName), testFileResult.getIssues(), issueCollection,
				expectedMessage);
	}
}
