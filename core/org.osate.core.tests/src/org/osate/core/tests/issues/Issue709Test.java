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
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue709Test extends XtextTest {
	private static final String AADL_TEXT = """
			package pkg1
			public
			\tabstract a1
			\t	features
			\t		fg1: feature group fgt1;
			\t		fg2: feature group inverse of fgt1;
			\t		fg3: feature group fgt2;
			\t		fg4: feature group inverse of fgt3;
			\t		fg5: feature group fgt4;
			\tend a1;
			\t
			\tabstract implementation a1.i
			\t	subcomponents
			\t		sub1: abstract a1;
			\t		sub2: abstract a1;
			\t	connections
			\t		--Correct
			\t		conn1: feature group sub1.fg1 -> sub2.fg2;
			\t		conn2: feature group sub1.fg1 -> sub2.fg3;
			\t	\t
			\t		--Same classifier, not inverse
			\t		conn3: feature group sub1.fg1 -> sub2.fg1;
			\t		conn4: feature group sub1.fg2 -> sub2.fg2;
			\t		conn5: feature group sub1.fg3 -> sub2.fg3;
			\t	\t
			\t		--Inverses, but not same classifier
			\t		conn6: feature group sub1.fg1 -> sub2.fg4;
			\t		conn7: feature group sub1.fg1 -> sub2.fg5;
			\tend a1.i;
			\t
			\tfeature group fgt1
			\tend fgt1;
			\t
			\tfeature group fgt2
			\t	inverse of fgt1
			\tend fgt2;
			\t
			\tfeature group fgt3
			\tend fgt3;
			\t
			\tfeature group fgt4
			\t	inverse of fgt3
			\tend fgt4;
			end pkg1;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	@Test
	public void testConnections() throws Exception {
		testFileResult = issues = testHelper.testString(AADL_TEXT);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		/* The original parses the same text a second time and inspects that model. */
		AadlPackage pkg = testHelper.parseString(AADL_TEXT);
		assertEquals("pkg1", pkg.getName());

		AbstractImplementation impl = (AbstractImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.get(1);
		assertEquals("a1.i", impl.getName());
		var connections = impl.getOwnedFeatureGroupConnections();
		assertNotInverses(connections.get(2), "conn3", "fg1", "fg1");
		assertNotInverses(connections.get(3), "conn4", "fg2", "fg2");
		assertNotInverses(connections.get(4), "conn5", "fg3", "fg3");
		assertNotInverses(connections.get(5), "conn6", "fg1", "fg4");
		assertNotInverses(connections.get(6), "conn7", "fg1", "fg5");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private void assertNotInverses(FeatureGroupConnection connection, String expectedName, String source,
			String destination) {
		assertEquals(expectedName, connection.getName());
		AssertHelper.assertError(connection, testFileResult.getIssues(), issueCollection,
				"The feature groups '" + source + "' and '" + destination + "' are not inverses of each other.");
	}
}
