/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, MERCHANTABILITY, EXCLUSIVITY,
 * RESULTS OBTAINED FROM USE OF THE MATERIAL, OR FITNESS FOR A PARTICULAR PURPOSE.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 */
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

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

/**
 * An internal feature is allowed only at the source end of a connection. The model declares one connection into an
 * internal feature, one legal connection out of an internal feature, and one bidirectional connection whose source is
 * an internal feature.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3028Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3028/Issue3028.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void internalFeatureIsAllowedOnlyAtConnectionSource() throws Exception {
		FluentIssueCollection result = issues = testHelper.testFile(MODEL);
		FluentIssueCollection expectedIssues = new FluentIssueCollection(result.getResource(), new ArrayList<>(),
				new ArrayList<>());

		AadlPackage pkg = (AadlPackage) result.getResource().getContents().get(0);
		ComponentImplementation top = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals("Top.i"))
				.findFirst()
				.orElseThrow();

		Connection toInternal = findConnection(top, "to_internal");
		Connection fromInternal = findConnection(top, "from_internal");
		Connection bidirectionalInternal = findConnection(top, "bidirectional_internal");

		// A connection into an internal feature is illegal.
		AssertHelper.assertError(toInternal.getDestination(), result.getIssues(), expectedIssues,
				"Internal feature 'raised_event' is allowed only at the source end of a connection.");

		// A connection out of an internal feature is legal.
		AssertHelper.assertError(fromInternal.getSource(), result.getIssues(), expectedIssues);
		AssertHelper.assertWarning(fromInternal.getSource(), result.getIssues(), expectedIssues);

		// A bidirectional connection also uses its source end as a destination.
		AssertHelper.assertWarning(bidirectionalInternal.getSource(), result.getIssues(), expectedIssues,
				"Bidirectional connection makes internal feature 'shared_event' a connection destination.");

		expectedIssues.sizeIs(result.getIssues().size());
		assertConstraints(expectedIssues);
	}

	private static Connection findConnection(ComponentImplementation implementation, String name) {
		Connection connection = implementation.getOwnedConnections()
				.stream()
				.filter(candidate -> name.equals(candidate.getName()))
				.findFirst()
				.orElseThrow();
		assertEquals(name, connection.getName());
		return connection;
	}
}
