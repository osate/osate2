/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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

import static org.eclipse.xtext.xbase.lib.CollectionLiterals.newArrayList;
import static org.junit.Assert.assertEquals;

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
public class Issue2835Test extends XtextTest {

	private static final String PATH = "org.osate.core.tests/models/issue2835/";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void test1() throws Exception {
		FluentIssueCollection testFileResult = issues = testHelper.testFile(PATH + "Issue2835.aadl");
		FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(), newArrayList(),
				newArrayList());

		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals("Issue2835", pkg.getName());

		var flows = ((ComponentImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1))
				.getOwnedFlowImplementations();
		AssertHelper.assertError(flows.get(1).getOwnedFlowSegments().get(0), testFileResult.getIssues(),
				issueCollection,
				"A flow source implementation may not start with a flow sink");
		AssertHelper.assertError(flows.get(2).getOwnedFlowSegments().get(0), testFileResult.getIssues(),
				issueCollection,
				"A flow source implementation may not start with a flow path");
		AssertHelper.assertError(flows.get(4).getOwnedFlowSegments().get(1), testFileResult.getIssues(),
				issueCollection,
				"A flow sink implementation may not end in a flow source");
		AssertHelper.assertError(flows.get(5).getOwnedFlowSegments().get(1), testFileResult.getIssues(),
				issueCollection,
				"A flow sink implementation may not end in a flow path");
		issueCollection.sizeIs(4);
		assertConstraints(issueCollection);
	}

}
