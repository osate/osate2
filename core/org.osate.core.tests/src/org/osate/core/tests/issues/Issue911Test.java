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
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
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
public class Issue911Test extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/issue911/";

	private static final String FILE1 = "BadParameterConnection.aadl";

	private static final String FILE2 = "BadAccessConnections.aadl";

	private static final String ERROR_MESSAGE = "Connection must not be between two subcomponents; use provides/requires access features";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	@Test
	public void test1() throws Exception {
		AadlPackage pkg = testFile(FILE1);
		assertEquals("BadParameterConnection", pkg.getName());

		ComponentImplementation t1 = implementationNamed(pkg, "T1.impl");
		assertError(t1, "bad1");

		finish();
	}

	@Test
	public void test2() throws Exception {
		AadlPackage pkg = testFile(FILE2);
		assertEquals("BadAccessConnections", pkg.getName());

		ComponentImplementation sys1 = implementationNamed(pkg, "Sys1.impl");
		for (String bad : List.of("bad1", "bad2", "bad3", "bad4", "bad5")) {
			assertError(sys1, bad);
		}
		for (String ok : List.of("r1", "r2", "r3", "r4", "r5", "p1", "p2", "p3", "p4", "p5")) {
			assertNoIssues(sys1, ok);
		}

		ComponentImplementation sys3 = implementationNamed(pkg, "Sys3.impl");
		for (String ok : List.of("pToR1", "pToR2", "pToR3", "pToR4", "pToR5")) {
			assertNoIssues(sys3, ok);
		}

		finish();
	}

	private AadlPackage testFile(String file) throws Exception {
		testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + file);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		return (AadlPackage) testFileResult.getResource().getContents().get(0);
	}

	private void finish() {
		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private static ComponentImplementation implementationNamed(AadlPackage pkg, String name) {
		return (ComponentImplementation) pkg.getPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> name.equals(classifier.getName()))
				.findFirst()
				.orElse(null);
	}

	private static Connection connectionNamed(ComponentImplementation impl, String name) {
		return impl.getOwnedConnections()
				.stream()
				.filter(connection -> name.equals(connection.getName()))
				.findFirst()
				.orElse(null);
	}

	private void assertError(ComponentImplementation impl, String connectionName) {
		AssertHelper.assertError(connectionNamed(impl, connectionName), testFileResult.getIssues(), issueCollection,
				ERROR_MESSAGE);
	}

	private void assertNoIssues(ComponentImplementation impl, String connectionName) {
		assertNoIssues(connectionNamed(impl, connectionName), testFileResult.getIssues(), issueCollection);
	}

	protected static void assertNoIssues(EObject eObject, List<Issue> allIssues,
			FluentIssueCollection issueCollection) {
		var eObjectURI = EcoreUtil.getURI(eObject);
		assertTrue(allIssues.stream().noneMatch(issue -> Objects.equals(issue.getUriToProblem(), eObjectURI)));
	}
}
