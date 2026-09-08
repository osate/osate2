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
import java.util.List;

import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.SystemImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2362DeclarativeTest extends XtextTest {
	private static final String FILE_LOCATION = "org.osate.core.tests/models/Issue2362/DeclarativeTests.aadl";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testDeclarative() throws Exception {
		FluentIssueCollection testFileResult = issues = testHelper.testFile(FILE_LOCATION);
		FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		PublicPackageSection section = pkg.getPublicSection();
		List<Issue> found = testFileResult.getIssues();

		doTests(section, found, issueCollection, "Sub_to_provides", "comp_outgoing", "comp_incoming", "comp_bidir",
				"comp_bidir2", "", "p_");
		doTests(section, found, issueCollection, "Sub_FG_to_provides", "comp_outgoing", "comp_incoming", "comp_bidir",
				"comp_bidir2", "", "p_");
		doTests(section, found, issueCollection, "Sub_FG_inverse_to_provides", "comp_outgoing", "comp_incoming",
				"comp_bidir", "comp_bidir2", "", "p_");
		doTests(section, found, issueCollection, "Sub_FG_inverse_to_provides2", "comp_outgoing", "comp_incoming",
				"comp_bidir", "comp_bidir2", "", "p_");
		doTests(section, found, issueCollection, "Sub_FG_inverse_to_provides3", "comp_outgoing", "comp_incoming",
				"comp_bidir", "comp_bidir2", "", "p_");
		doTests(section, found, issueCollection, "Sub_to_peer_requires", "toPeer", "fromPeer", "bidir", "bidir2", "",
				"r_");
		doTests(section, found, issueCollection, "Sub_to_provides", "sub_outgoing", "sub_incoming", "sub_bidir",
				"sub_bidir2", "p_", "p_");
		doTests(section, found, issueCollection, "Sub_FG_to_provides", "sub_outgoing", "sub_incoming", "sub_bidir",
				"sub_bidir2", "p_", "p_");
		doTests(section, found, issueCollection, "Sub_FG_inverse_to_provides", "sub_outgoing", "sub_incoming",
				"sub_bidir", "sub_bidir2", "p_", "p_");
		doTests(section, found, issueCollection, "Sub_FG_inverse_to_provides2", "sub_outgoing", "sub_incoming",
				"sub_bidir", "sub_bidir2", "p_", "p_");
		doTests(section, found, issueCollection, "Sub_FG_inverse_to_provides3", "sub_outgoing", "sub_incoming",
				"sub_bidir", "sub_bidir2", "p_", "p_");
		doTests(section, found, issueCollection, "Peer_to_peer", "toPeer", "fromPeer", "bidir", "bidir2", "p_", "r_");
		doTests(section, found, issueCollection, "To_sub_requires", "incoming", "outgoing", "bidir", "bidir2", "r_d_",
				"r_");
		doTests(section, found, issueCollection, "FG_To_sub_requires", "incoming", "outgoing", "bidir", "bidir2",
				"r_d_", "r_");
		doTests(section, found, issueCollection, "FG_inverse_To_sub_requires", "incoming", "outgoing", "bidir",
				"bidir2", "r_d_", "r_");
		doTests(section, found, issueCollection, "FG_inverse_To_sub_requires2", "incoming", "outgoing", "bidir",
				"bidir2", "r_d_", "r_");
		doTests(section, found, issueCollection, "FG_inverse_To_sub_requires3", "incoming", "outgoing", "bidir",
				"bidir2", "r_d_", "r_");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private static void doTests(PublicPackageSection publicSection, List<Issue> issues,
			FluentIssueCollection issueCollection, String base, String outgoing, String incoming, String bidir,
			String bidir2, String prefix1, String prefix2) {
		for (String suffix : List.of(outgoing, incoming, bidir, bidir2)) {
			testCompImpl(implementationNamed(publicSection, base + "." + suffix), issues, issueCollection, prefix1,
					prefix2);
		}
	}

	private static SystemImplementation implementationNamed(PublicPackageSection publicSection, String name) {
		return (SystemImplementation) publicSection.getOwnedClassifiers()
				.stream()
				.filter(classifier -> name.equals(classifier.getName()))
				.findFirst()
				.orElse(null);
	}

	private static void testCompImpl(SystemImplementation systemImpl, List<Issue> issues,
			FluentIssueCollection issueCollection, String prefix1, String prefix2) {
		var connections = systemImpl.getOwnedAccessConnections();
		AssertHelper.assertError(connections.get(1), issues, issueCollection,
				"'" + prefix1 + "dd' and '" + prefix2 + "d_dd' have incompatible classifiers.");
		AssertHelper.assertError(connections.get(4), issues, issueCollection,
				"'" + prefix1 + "e' and '" + prefix2 + "d_e' have incompatible classifiers.");
		AssertHelper.assertError(connections.get(5), issues, issueCollection,
				"'" + prefix1 + "d' and '" + prefix2 + "e_d' have incompatible classifiers.");
		AssertHelper.assertError(connections.get(6), issues, issueCollection,
				"'" + prefix1 + "dd' and '" + prefix2 + "e_dd' have incompatible classifiers.");
		AssertHelper.assertError(connections.get(7), issues, issueCollection,
				"The types of '" + prefix1 + "di' and '" + prefix2 + "e_di' do not match.");
		AssertHelper.assertError(connections.get(8), issues, issueCollection,
				"The types of '" + prefix1 + "dj' and '" + prefix2 + "e_dj' do not match.");
	}
}
