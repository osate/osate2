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
import org.osate.aadl2.SubprogramImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1564Test extends XtextTest {
	private static final String NON_MODAL = "Multiple sequences declared for non-modal implementation";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	@Test
	public void testIssue1564() throws Exception {
		testFileResult = issues = testHelper.testFile("org.osate.core.tests/models/issue1564/issue1564.aadl");
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals("issue1564", pkg.getName());
		var classifiers = pkg.getPublicSection().getOwnedClassifiers();

		assertSequenceErrors((SubprogramImplementation) classifiers.get(4), "sp_not_modal.i2", "sequence2",
				"sequence3", NON_MODAL);
		assertSequenceErrors((SubprogramImplementation) classifiers.get(8), "sp_modal.i5", "sequence7", "sequence8",
				"Multiple sequences declared for modes: m1");
		assertSequenceErrors((SubprogramImplementation) classifiers.get(9), "sp_modal.i6", "sequence9", "sequence10",
				"Multiple sequences declared for modes: m1");
		assertSequenceErrors((SubprogramImplementation) classifiers.get(10), "sp_modal.i7", "sequence11", "sequence12",
				"Multiple sequences declared for modes: m1, m2");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private void assertSequenceErrors(SubprogramImplementation impl, String expectedImplName, String firstSequence,
			String secondSequence, String expectedMessage) {
		assertEquals(expectedImplName, impl.getName());
		var sequences = impl.getOwnedSubprogramCallSequences();
		assertEquals(firstSequence, sequences.get(0).getName());
		AssertHelper.assertError(sequences.get(0), testFileResult.getIssues(), issueCollection, expectedMessage);
		assertEquals(secondSequence, sequences.get(1).getName());
		AssertHelper.assertError(sequences.get(1), testFileResult.getIssues(), issueCollection, expectedMessage);
	}
}
