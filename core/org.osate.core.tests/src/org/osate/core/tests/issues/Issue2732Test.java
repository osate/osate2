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

import static org.eclipse.xtext.xbase.lib.CollectionLiterals.newArrayList;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.RecordValue;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

/**
 * Tests the property-constant legality rules from issue #2732 and saeaadl/aadlv2.2#37. Property constants
 * have no model-element context, so their expressions must not directly or indirectly reference properties,
 * classifiers, or model elements, and their types must not contain classifier or reference types.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2732Test extends XtextTest {
	private static final String MODEL_DIR = "org.osate.core.tests/models/issue2732/";
	private static final String PROPERTY_REFERENCE_ERROR = "Property constant expressions may not directly or indirectly "
			+ "reference properties, classifiers, or model elements";
	private static final String TYPE_ERROR = "Property constants may not have classifier or reference property types, "
			+ "including within lists or records";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void propertyConstantLegalityIsValidated() throws Exception {
		var result = validate();
		var expected = emptyExpectedIssues(result);
		var propertySet = propertySet(result);

		assertPropertyReferences(propertySet, result, expected);
		assertIndirectReferences(propertySet, result, expected);
		assertClassifierReferences(propertySet, result, expected);
		assertProhibitedTypes(propertySet, result, expected);

		expected.sizeIs(result.getIssues().size());
		assertConstraints(expected);
	}

	private static void assertPropertyReferences(PropertySet propertySet, FluentIssueCollection result,
			FluentIssueCollection expected) {
		AssertHelper.assertError(constant(propertySet, "direct_property").getConstantValue(), result.getIssues(),
				expected, PROPERTY_REFERENCE_ERROR);

		var list = (ListValue) constant(propertySet, "list_property").getConstantValue();
		AssertHelper.assertError(list.getOwnedListElements().get(2), result.getIssues(), expected,
				PROPERTY_REFERENCE_ERROR);

		var record = (RecordValue) constant(propertySet, "record_property").getConstantValue();
		AssertHelper.assertError(record.getOwnedFieldValues().get(1).getOwnedValue(), result.getIssues(), expected,
				PROPERTY_REFERENCE_ERROR);
		var nestedList = (ListValue) record.getOwnedFieldValues().get(2).getOwnedValue();
		AssertHelper.assertError(nestedList.getOwnedListElements().get(2), result.getIssues(), expected,
				PROPERTY_REFERENCE_ERROR);
	}

	private static void assertIndirectReferences(PropertySet propertySet, FluentIssueCollection result,
			FluentIssueCollection expected) {
		AssertHelper.assertError(constant(propertySet, "property_source").getConstantValue(), result.getIssues(),
				expected, PROPERTY_REFERENCE_ERROR);
		AssertHelper.assertError(constant(propertySet, "indirect_property").getConstantValue(), result.getIssues(),
				expected, PROPERTY_REFERENCE_ERROR);
		AssertHelper.assertError(constant(propertySet, "double_indirect_property").getConstantValue(),
				result.getIssues(), expected, PROPERTY_REFERENCE_ERROR);
	}

	private static void assertClassifierReferences(PropertySet propertySet, FluentIssueCollection result,
			FluentIssueCollection expected) {
		var direct = constant(propertySet, "classifier_constant");
		AssertHelper.assertError(direct, result.getIssues(), expected, TYPE_ERROR);
		AssertHelper.assertError((ClassifierValue) direct.getConstantValue(), result.getIssues(), expected,
				PROPERTY_REFERENCE_ERROR);

		var listConstant = constant(propertySet, "classifier_list_constant");
		AssertHelper.assertError(listConstant, result.getIssues(), expected, TYPE_ERROR);
		var values = (ListValue) listConstant.getConstantValue();
		AssertHelper.assertError(values.getOwnedListElements().get(0), result.getIssues(), expected,
				PROPERTY_REFERENCE_ERROR);
		AssertHelper.assertError(values.getOwnedListElements().get(1), result.getIssues(), expected,
				PROPERTY_REFERENCE_ERROR);
	}

	private static void assertProhibitedTypes(PropertySet propertySet, FluentIssueCollection result,
			FluentIssueCollection expected) {
		var reference = constant(propertySet, "reference_type_constant");
		AssertHelper.assertError(reference, result.getIssues(), expected, TYPE_ERROR);
		AssertHelper.assertError((NamedValue) reference.getConstantValue(), result.getIssues(), expected,
				PROPERTY_REFERENCE_ERROR);

		var compound = constant(propertySet, "compound_type_constant");
		AssertHelper.assertError(compound, result.getIssues(), expected, TYPE_ERROR);
		AssertHelper.assertError((NamedValue) compound.getConstantValue(), result.getIssues(), expected,
				PROPERTY_REFERENCE_ERROR);
	}

	private FluentIssueCollection validate() throws Exception {
		return issues = testHelper.testFile(MODEL_DIR + "Issue2732.aadl",
				MODEL_DIR + "Issue2732Classifiers.aadl");
	}

	private static FluentIssueCollection emptyExpectedIssues(FluentIssueCollection result) {
		return new FluentIssueCollection(result.getResource(), newArrayList(), newArrayList());
	}

	private static PropertySet propertySet(FluentIssueCollection result) {
		return (PropertySet) result.getResource().getContents().get(0);
	}

	private static PropertyConstant constant(PropertySet propertySet, String name) {
		return propertySet.getOwnedPropertyConstants()
				.stream()
				.filter(constant -> name.equals(constant.getName()))
				.findFirst()
				.orElseThrow();
	}
}
