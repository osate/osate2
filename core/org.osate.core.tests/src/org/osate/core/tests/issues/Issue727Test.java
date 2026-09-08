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
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue727Test extends XtextTest {
	private static final String AADL_TEXT = """
			package pkg1
			public
			\tabstract a
			\t	features
			\t		p1: in data port;
			\t		p2: out data port;
			\t		af1: feature;
			\t		af2: feature;
			\t		fg1: feature group;
			\t		fg2: feature group;
			\t		da1: provides data access;
			\t		da2: requires data access;
			\tend a;
			\t
			\tabstract implementation a.i
			\t	connections
			\t		conn1: port p1 -> p2;
			\t		conn2: feature af1 -> af2;
			\t		conn3: feature group fg1 -> fg2;
			\t		conn4: data access da1 -> da2;
			\tend a.i;
			\t
			\tsubprogram subp
			\t	features
			\t		param1: in parameter;
			\t		param2: out parameter;
			\tend subp;
			\t
			\tsubprogram implementation subp.i
			\t	connections
			\t		conn5: parameter param1 -> param2;
			\tend subp.i;
			end pkg1;
			""";

	private static final String DIRECT_CONNECTION = "Illegal connection: Cannot directly connect two features of the containing component.";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	@Test
	public void testConnections() throws Exception {
		testFileResult = issues = testHelper.testString(AADL_TEXT);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals("pkg1", pkg.getName());
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();

		AbstractImplementation abstractImpl = (AbstractImplementation) classifiers.get(1);
		assertEquals("a.i", abstractImpl.getName());
		assertDirectConnection(abstractImpl.getOwnedPortConnections().get(0), "conn1");
		assertDirectConnection(abstractImpl.getOwnedFeatureConnections().get(0), "conn2");
		assertDirectConnection(abstractImpl.getOwnedFeatureGroupConnections().get(0), "conn3");
		assertDirectConnection(abstractImpl.getOwnedAccessConnections().get(0), "conn4");

		SubprogramImplementation subprogramImpl = (SubprogramImplementation) classifiers.get(3);
		assertEquals("subp.i", subprogramImpl.getName());
		assertDirectConnection(subprogramImpl.getOwnedParameterConnections().get(0), "conn5");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private void assertDirectConnection(NamedElement connection, String expectedName) {
		assertEquals(expectedName, connection.getName());
		AssertHelper.assertError((EObject) connection, testFileResult.getIssues(), issueCollection,
				DIRECT_CONNECTION);
	}
}
