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
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.SystemImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1769Test extends XtextTest {
	private static final String PATH = "org.osate.core.tests/models/issue1769/";

	private static final String INDICES_START_AT_1 = "Array indices start at 1";

	private static final String UPPER_BOUND_TOO_BIG = "Upper bound is greater than array size 5";

	private static final String INDEX_TOO_BIG = "Index is greater than array size 5";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	private SystemImplementation systemImpl;

	@Test
	public void testIssue1769() throws Exception {
		testFileResult = issues = testHelper.testFile(PATH + "reference_arrays.aadl", PATH + "ps1.aadl");
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals("reference_arrays", pkg.getName());

		systemImpl = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals("s1.i", systemImpl.getName());

		/* Index 2 has no error of its own; only its property name is checked. */
		assertEquals("def3", association(2).getProperty().getName());
		assertRangeError(3, "def4", 0, "'m1' is not an array");
		assertRangeError(4, "def5", 0, "'sub2' is not an array");
		assertRangeError(5, "def6", 0, "Too few array dimensions: 'sub1' has 2");
		assertRangeError(6, "def7", 2, "Too many array dimensions: 'sub1' has 2");
		assertRangeError(7, "def8", 0, INDICES_START_AT_1);
		assertRangeError(8, "def9", 0, INDEX_TOO_BIG);
		assertRangeError(9, "def10", 0, INDICES_START_AT_1);
		assertRangeError(10, "def11", 0, UPPER_BOUND_TOO_BIG);
		assertRangeError(11, "def12", 0, INDICES_START_AT_1, UPPER_BOUND_TOO_BIG);
		assertRangeError(12, "def13", 0, "Range lower bound is greater than upper bound");
		assertRangeError(13, "def14", 0, INDEX_TOO_BIG);
		assertRangeError(14, "def15", 0, UPPER_BOUND_TOO_BIG);

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private PropertyAssociation association(int index) {
		return systemImpl.getOwnedPropertyAssociations().get(index);
	}

	private void assertRangeError(int associationIndex, String expectedPropertyName, int rangeIndex,
			String... expectedMessages) {
		PropertyAssociation association = association(associationIndex);
		assertEquals(expectedPropertyName, association.getProperty().getName());
		ReferenceValue value = (ReferenceValue) association.getOwnedValues().get(0).getOwnedValue();
		ArrayRange range = value.getPath().getArrayRanges().get(rangeIndex);
		AssertHelper.assertError(range, testFileResult.getIssues(), issueCollection, expectedMessages);
	}
}
