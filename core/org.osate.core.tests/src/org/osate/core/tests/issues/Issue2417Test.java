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
import org.osate.aadl2.SystemImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.properties.util.ModelingProperties;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2417Test extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testIssue2417() throws Exception {
		String pkg1 = """
				package pkg1
				public
				  system s
				    modes
				      m1: initial mode;
				      m2: mode;
				  end s;

				  system implementation s.i
				    subcomponents
				      sub1: abstract a;
				      sub2: abstract a;
				    connections
				      conn1: port sub1.p -> sub2.p {
				        Classifier_Matching_Rule => Classifier_Match in modes (m1), Subset in modes (m2);
				      };
				  end s.i;

				  abstract a
				    features
				      p: in out data port d;
				  end a;

				  data d
				  end d;
				end pkg1;
				""";
		FluentIssueCollection testFileResult = issues = testHelper.testString(pkg1);

		FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals("pkg1", pkg.getName());
		SystemImplementation systemImpl = (SystemImplementation) pkg.getPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals("s.i"))
				.findFirst()
				.get();
		assertEquals("s.i", systemImpl.getName());

		var connection = systemImpl.getOwnedPortConnections()
				.stream()
				.filter(portConnection -> portConnection.getName().equals("conn1"))
				.findFirst()
				.get();
		assertEquals("conn1", connection.getName());

		/* The modal property association is declared on the connection, not on the implementation. */
		AssertHelper.assertError(connection.getOwnedPropertyAssociations().get(0), testFileResult.getIssues(),
				issueCollection, ModelingProperties.CLASSIFIER_MATCHING_RULE + ": Property can not be modal");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	@Test
	public void testIssue2417_propertyAssociation() throws Exception {
		String pkg1 = """
				package pkg1
				public
				  system s
				    modes
				      m1: initial mode;
				      m2: mode;
				  end s;

				  system implementation s.i
				    subcomponents
				      sub1: abstract a;
				      sub2: abstract a;
				    connections
				      conn1: port sub1.p -> sub2.p;
				    properties
				      Classifier_Matching_Rule => Classifier_Match in modes (m1), Subset in modes (m2);
				  end s.i;

				  abstract a
				    features
				      p: in out data port d;
				  end a;

				  data d
				  end d;
				end pkg1;
				""";
		FluentIssueCollection testFileResult = issues = testHelper.testString(pkg1);

		FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals("pkg1", pkg.getName());
		SystemImplementation systemImpl = (SystemImplementation) pkg.getPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals("s.i"))
				.findFirst()
				.get();
		assertEquals("s.i", systemImpl.getName());

		AssertHelper.assertError(systemImpl.getOwnedPropertyAssociations().get(0), testFileResult.getIssues(),
				issueCollection, ModelingProperties.CLASSIFIER_MATCHING_RULE + ": Property can not be modal");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}
}
