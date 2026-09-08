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
import org.osate.aadl2.PropertySet;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1366Test extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/issue1366/";

	private static final String PACKAGE = PROJECT_LOCATION + "Issue1366.aadl";

	private static final String PROPERTY_SET = PROJECT_LOCATION + "PS1.aadl";

	private static final String PROPERTY_REFERENCE_ERROR = "Property constant expressions may not directly or indirectly reference "
			+ "properties, classifiers, or model elements";

	private static final String TYPE_ERROR = "Property constants may not have classifier or reference property types, including within "
			+ "lists or records";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void test1() throws Exception {
		FluentIssueCollection testFileResult = issues = testHelper.testFile(PACKAGE, PROPERTY_SET);
		FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals("Issue1366", pkg.getName());

		var abstractType = pkg.getPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> "a".equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		var associations = abstractType.getOwnedPropertyAssociations();

		AssertHelper.assertError(firstOwnedValue(associations.get(0)), testFileResult.getIssues(), issueCollection,
				"Property value of type PS1::type1; expected type list of PS1::type1");
		AssertHelper.assertError(firstOwnedValue(associations.get(1)), testFileResult.getIssues(), issueCollection,
				"Property value is not of expected type PS1::type1");
		AssertHelper.assertError(firstOwnedValue(associations.get(2)), testFileResult.getIssues(), issueCollection,
				"Number value is missing a unit");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	@Test
	public void test2() throws Exception {
		FluentIssueCollection testFileResult = issues = testHelper.testFile(PROPERTY_SET, PACKAGE);
		FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		PropertySet propertySet = (PropertySet) testFileResult.getResource().getContents().get(0);
		assertEquals("PS1", propertySet.getName());

		var constant1 = propertySet.getOwnedPropertyConstants().get(1);
		AssertHelper.assertError(constant1, testFileResult.getIssues(), issueCollection, TYPE_ERROR);
		AssertHelper.assertError(constant1.getConstantValue(), testFileResult.getIssues(), issueCollection,
				PROPERTY_REFERENCE_ERROR);

		AssertHelper.assertError(propertySet.getOwnedPropertyConstants().get(2).getConstantValue(),
				testFileResult.getIssues(), issueCollection, "Number value is missing a unit");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private static PropertyExpression firstOwnedValue(PropertyAssociation association) {
		return association.getOwnedValues().get(0).getOwnedValue();
	}
}
