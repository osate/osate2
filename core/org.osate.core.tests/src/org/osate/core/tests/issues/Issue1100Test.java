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
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.ThreadType;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1100Test extends XtextTest {
	private static final String PATH = "org.osate.core.tests/models/issue1100/";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testIssue1100() throws Exception {
		FluentIssueCollection testFileResult = issues = testHelper.testFile(PATH + "pkg1.aadl", PATH + "ps1.aadl");
		FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals("pkg1", pkg.getName());

		ThreadType threadType = (ThreadType) pkg.getPublicSection().getOwnedClassifiers().get(0);
		assertEquals("t", threadType.getName());
		var associations = threadType.getOwnedPropertyAssociations();

		AssertHelper.assertError(firstOwnedValue(associations.get(0)), testFileResult.getIssues(), issueCollection,
				"Value must be between 1 and 10");
		AssertHelper.assertError(firstOwnedValue(associations.get(1)), testFileResult.getIssues(), issueCollection,
				"Value must be between 11 sec and 20 sec");
		AssertHelper.assertError(firstOwnedValue(associations.get(2)), testFileResult.getIssues(), issueCollection,
				"Value must be between 21.1 and 30.0");
		AssertHelper.assertError(firstOwnedValue(associations.get(3)), testFileResult.getIssues(), issueCollection,
				"Value must be between 31.1 sec and 40.0 sec");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private static PropertyExpression firstOwnedValue(PropertyAssociation association) {
		return association.getOwnedValues().get(0).getOwnedValue();
	}
}
