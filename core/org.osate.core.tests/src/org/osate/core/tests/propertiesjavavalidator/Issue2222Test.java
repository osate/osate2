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
package org.osate.core.tests.propertiesjavavalidator;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.RecordValue;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2222Test extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue2222/";
	private static final String PACKAGE = PROJECT_LOCATION + "P.aadl";
	private static final String PROPERTY_SET = PROJECT_LOCATION + "Props.aadl";
	private static final String PROPERTY_REFERENCE_ERROR = "Property constant expressions may not directly or "
			+ "indirectly reference properties, classifiers, or model elements";
	private static final String EXPECTED_RECORD_TYPE_1 = "Property value of type Props::RecordType2; expected type Props::RecordType1";
	private static final String EXPECTED_RECORD_TYPE_2 = "Property value of type Props::RecordType1; expected type Props::RecordType2";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	@Test
	public void testPackageContents() throws Exception {
		testFileResult = issues = testHelper.testFile(PACKAGE, PROPERTY_SET);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(), new ArrayList<>());

		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		var classifierA = classifier(pkg, "A");
		assertError(assignedValue(classifierA, 2), EXPECTED_RECORD_TYPE_1);
		assertError(assignedValue(classifierA, 3), EXPECTED_RECORD_TYPE_2);

		assertError(listElement(assignedValue(classifierA, 6), 1), EXPECTED_RECORD_TYPE_1);
		assertError(listElement(assignedValue(classifierA, 7), 0), EXPECTED_RECORD_TYPE_2);

		assertError(fieldValue(assignedValue(classifierA, 10), 0), EXPECTED_RECORD_TYPE_1);
		assertError(fieldValue(assignedValue(classifierA, 10), 1), EXPECTED_RECORD_TYPE_2);

		var listOfRecords = listElement(assignedValue(classifierA, 11), 0);
		assertError(fieldValue(listOfRecords, 0), EXPECTED_RECORD_TYPE_1);
		assertError(fieldValue(listOfRecords, 1), EXPECTED_RECORD_TYPE_2);

		assertError(assignedValue(classifierA, 14), EXPECTED_RECORD_TYPE_1);
		assertError(assignedValue(classifierA, 15), EXPECTED_RECORD_TYPE_2);

		assertError(listElement(assignedValue(classifierA, 18), 1), EXPECTED_RECORD_TYPE_1);
		assertError(listElement(assignedValue(classifierA, 19), 0), EXPECTED_RECORD_TYPE_2);

		assertError(assignedValue(classifierA, 20),
				"Property value of type Props::RecordType1; expected type list of Props::RecordType1");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	@Test
	public void testPropertySet() throws Exception {
		testFileResult = issues = testHelper.testFile(PROPERTY_SET, PACKAGE);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(), new ArrayList<>());

		var propertySet = (PropertySet) testFileResult.getResource().getContents().getFirst();
		assertError(constantValue(propertySet, "BadConstant1"), EXPECTED_RECORD_TYPE_1);
		assertError(constantValue(propertySet, "BadConstant2"), EXPECTED_RECORD_TYPE_2);

		assertError(defaultValue(propertySet, "BadDefault1"), EXPECTED_RECORD_TYPE_1);
		assertError(defaultValue(propertySet, "BadDefault2"), EXPECTED_RECORD_TYPE_2);

		assertError(listElement(constantValue(propertySet, "BadListConstant1"), 1), EXPECTED_RECORD_TYPE_1);
		assertError(listElement(constantValue(propertySet, "BadListConstant2"), 0), EXPECTED_RECORD_TYPE_2);

		assertError(listElement(defaultValue(propertySet, "BadListDefault1"), 1), EXPECTED_RECORD_TYPE_1);
		assertError(listElement(defaultValue(propertySet, "BadListDefault2"), 0), EXPECTED_RECORD_TYPE_2);

		var badFieldsConstant = constantValue(propertySet, "BadFieldsConstant1");
		assertError(fieldValue(badFieldsConstant, 0), EXPECTED_RECORD_TYPE_1);
		assertError(fieldValue(badFieldsConstant, 1), EXPECTED_RECORD_TYPE_2);

		var badFieldsListConstant = listElement(constantValue(propertySet, "BadFieldsListConstant1"), 0);
		assertError(fieldValue(badFieldsListConstant, 0), EXPECTED_RECORD_TYPE_1);
		assertError(fieldValue(badFieldsListConstant, 1), EXPECTED_RECORD_TYPE_2);

		var badFieldsDefault = defaultValue(propertySet, "BadFieldsDefault1");
		assertError(fieldValue(badFieldsDefault, 0), EXPECTED_RECORD_TYPE_1);
		assertError(fieldValue(badFieldsDefault, 1), EXPECTED_RECORD_TYPE_2);

		var badFieldsListDefault = listElement(defaultValue(propertySet, "BadFieldsListDefault1"), 0);
		assertError(fieldValue(badFieldsListDefault, 0), EXPECTED_RECORD_TYPE_1);
		assertError(fieldValue(badFieldsListDefault, 1), EXPECTED_RECORD_TYPE_2);

		assertError(constantValue(propertySet, "GoodPropRefConstant1"), PROPERTY_REFERENCE_ERROR);
		assertError(constantValue(propertySet, "GoodPropRefConstant2"), PROPERTY_REFERENCE_ERROR);
		assertError(constantValue(propertySet, "BadPropRefConstant1"), EXPECTED_RECORD_TYPE_1,
				PROPERTY_REFERENCE_ERROR);
		assertError(constantValue(propertySet, "BadPropRefConstant2"), EXPECTED_RECORD_TYPE_2,
				PROPERTY_REFERENCE_ERROR);

		assertError(defaultValue(propertySet, "BadPropRefDefault1"), EXPECTED_RECORD_TYPE_1);
		assertError(defaultValue(propertySet, "BadPropRefDefault2"), EXPECTED_RECORD_TYPE_2);

		assertError(listElement(constantValue(propertySet, "GoodListOfPropRefConstant1"), 0),
				PROPERTY_REFERENCE_ERROR);
		assertError(listElement(constantValue(propertySet, "GoodListOfPropRefConstant2"), 0),
				PROPERTY_REFERENCE_ERROR);

		var badListConstant1 = constantValue(propertySet, "BadListOfPropRefConstant1");
		assertError(listElement(badListConstant1, 0), PROPERTY_REFERENCE_ERROR);
		assertError(listElement(badListConstant1, 1), EXPECTED_RECORD_TYPE_1, PROPERTY_REFERENCE_ERROR);

		var badListConstant2 = constantValue(propertySet, "BadListOfPropRefConstant2");
		assertError(listElement(badListConstant2, 0), EXPECTED_RECORD_TYPE_2, PROPERTY_REFERENCE_ERROR);
		assertError(listElement(badListConstant2, 1), PROPERTY_REFERENCE_ERROR);

		assertError(listElement(defaultValue(propertySet, "BadListOfPropRefDefault1"), 1), EXPECTED_RECORD_TYPE_1);
		assertError(listElement(defaultValue(propertySet, "BadListOfPropRefDefault2"), 0), EXPECTED_RECORD_TYPE_2);

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private static Classifier classifier(AadlPackage pkg, String name) {
		return pkg.getPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> name.equals(classifier.getName()))
				.findFirst()
				.orElseThrow();
	}

	private static PropertyExpression assignedValue(Classifier classifier, int associationIndex) {
		return classifier.getOwnedPropertyAssociations()
				.get(associationIndex)
				.getOwnedValues()
				.getFirst()
				.getOwnedValue();
	}

	private static PropertyExpression constantValue(PropertySet propertySet, String name) {
		return propertySet.getOwnedPropertyConstants()
				.stream()
				.filter(constant -> name.equals(constant.getName()))
				.findFirst()
				.orElseThrow()
				.getConstantValue();
	}

	private static PropertyExpression defaultValue(PropertySet propertySet, String name) {
		return propertySet.getOwnedProperties()
				.stream()
				.filter(property -> name.equals(property.getName()))
				.findFirst()
				.orElseThrow()
				.getDefaultValue();
	}

	private static PropertyExpression listElement(PropertyExpression list, int index) {
		return ((ListValue) list).getOwnedListElements().get(index);
	}

	private static PropertyExpression fieldValue(PropertyExpression record, int index) {
		return ((RecordValue) record).getOwnedFieldValues().get(index).getValue();
	}

	private void assertError(EObject object, String... messages) {
		AssertHelper.assertError(object, testFileResult.getIssues(), issueCollection, messages);
	}
}
