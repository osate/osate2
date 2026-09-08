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
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue744Test extends XtextTest {
	private static final String AADL_TEXT = """
			package pkg1
			public
			\tabstract a1
			\t\tfeatures
			\t\t\tp1: in data port d1.i;
			\tend a1;
			\t
			\tabstract implementation a1.i
			\t\tsubcomponents
			\t\t\tasub1: abstract a2;
			\t\tconnections
			\t\t\tconn1: port p1.dsub1 -> asub1.p2;
			\tend a1.i;
			\t
			\tdata d1
			\tend d1;
			\t
			\tdata implementation d1.i
			\t\tsubcomponents
			\t\t\tdsub1: data;
			\tend d1.i;
			\t
			\tabstract a2
			\t\tfeatures
			\t\t\tp2: in data port;
			\tend a2;
			end pkg1;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue744() throws Exception {
		FluentIssueCollection testFileResult = issues = testHelper.testString(AADL_TEXT);
		FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals("pkg1", pkg.getName());

		AbstractImplementation impl = (AbstractImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.get(1);
		assertEquals("a1.i", impl.getName());
		var connection = impl.getOwnedPortConnections().get(0);
		assertEquals("conn1", connection.getName());
		AssertHelper.assertWarning(connection.getSource(), testFileResult.getIssues(), issueCollection,
				"Aggregate data ports not supported by instantiator.");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}
}
