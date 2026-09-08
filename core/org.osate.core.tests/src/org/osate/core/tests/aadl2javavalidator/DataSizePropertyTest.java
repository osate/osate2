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
package org.osate.core.tests.aadl2javavalidator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class DataSizePropertyTest extends XtextTest {
	private static final String DATA_TEST = """
			package dataTest
			public
			\tdata d1
			\tend d1;
			\t
			\tdata implementation d1.i1
			\t	properties
			\t		Data_Size => 2 Bytes;
			\tend d1.i1;
			\t
			\tdata implementation d1.i2
			\t	subcomponents
			\t		sub1: data;
			\t		sub2: data;
			\t	properties
			\t		Data_Size => 2 Bytes;
			\tend d1.i2;
			\t
			\tdata implementation d1.i3
			\t	subcomponents
			\t		sub1: data {Data_Size => 1 Bytes;};
			\t		sub2: data {Data_Size => 3 Bytes;};
			\t	properties
			\t		Data_Size => 4 Bytes;
			\tend d1.i3;
			\t
			\tdata implementation d1.i4
			\t	subcomponents
			\t		sub1: data {Data_Size => 1 KByte;};
			\t		sub2: data {Data_Size => 500 Bytes;};
			\t	properties
			\t		Data_Size => 1500 Bytes;
			\tend d1.i4;
			\t
			\tdata implementation d1.i5
			\t	subcomponents
			\t		sub1: data {Data_Size => 1 Bytes;};
			\t		sub2: data {Data_Size => 1 Bytes;};
			\t	properties
			\t		Data_Size => 4 Bytes;
			\tend d1.i5;
			\t
			\tdata implementation d1.i6
			\t	subcomponents
			\t		sub1: data {Data_Size => 1 Bytes;};
			\t		sub2: data;
			\t	properties
			\t		Data_Size => 4 Bytes;
			\tend d1.i6;
			\t
			\tdata implementation d1.i7
			\t	subcomponents
			\t		sub1: data {Data_Size => 5 Bytes;};
			\t		sub2: data;
			\t	properties
			\t		Data_Size => 4 Bytes;
			\tend d1.i7;
			\t
			\tdata implementation d1.i8
			\t	subcomponents
			\t		sub1: data {Data_Size => 1 Bytes;};
			\t		sub2: data d1.i9;
			\t	properties
			\t		Data_Size => 3 Bytes;
			\tend d1.i8;
			\t
			\tdata implementation d1.i9
			\t	subcomponents
			\t		sub1: data {Data_Size => 1 Bytes;};
			\t		sub2: data {Data_Size => 1 Bytes;};
			\tend d1.i9;
			\t
			\tdata implementation d1.i10
			\t	subcomponents
			\t		sub1: data {Data_Size => 1 Bytes;};
			\t		sub2: data d1.i9;
			\t	properties
			\t		Data_Size => 2 Bytes;
			\tend d1.i10;
			\t
			\tdata implementation d1.i11
			\t	subcomponents
			\t		sub1: data {Data_Size => 1 Bytes;};
			\t		sub2: data d1.i12;
			\t	properties
			\t		Data_Size => 3 Bytes;
			\tend d1.i11;
			\t
			\tdata implementation d1.i12
			\t	subcomponents
			\t		sub1: data {Data_Size => 1 Bytes;};
			\t		sub2: data;
			\tend d1.i12;
			\t
			\tdata implementation d1.i13
			\t	subcomponents
			\t		sub1: data {Data_Size => 1 Bytes;};
			\t		sub2: data d1.i12;
			\t	properties
			\t		Data_Size => 1 Bytes;
			\tend d1.i13;
			end dataTest;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	private AadlPackage pkg;

	@Test
	public void testDataSizeProperty() throws Exception {
		testFileResult = issues = testHelper.testString(DATA_TEST);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals("dataTest", pkg.getName());

		assertSizeError(5, "d1.i5", "larger", 4, 2);
		assertSizeError(6, "d1.i6", "larger", 4, 1);
		assertSizeError(7, "d1.i7", "smaller", 4, 5);
		assertSizeError(10, "d1.i10", "smaller", 2, 3);
		assertSizeError(11, "d1.i11", "larger", 3, 2);
		assertSizeError(13, "d1.i13", "smaller", 1, 2);

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private void assertSizeError(int classifierIndex, String expectedName, String comparison, int declaredBytes,
			int subcomponentBytes) {
		var classifier = pkg.getPublicSection().getOwnedClassifiers().get(classifierIndex);
		assertEquals(expectedName, classifier.getName());
		AssertHelper.assertError(classifier, testFileResult.getIssues(), issueCollection,
				"Data size of \"" + expectedName + "\" (" + declaredBytes + " Bytes) is " + comparison
						+ " than the sum of its subcomponents (" + subcomponentBytes + " Bytes).");
	}
}
