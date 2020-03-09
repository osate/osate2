/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.core.tests.propertiesjavavalidator

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.PropertySet
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError
import org.osate.aadl2.ListValue
import org.osate.aadl2.RecordValue

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2222Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue2222/"
	val static PACKAGE = PROJECT_LOCATION + "P.aadl"
	val static PROPERTY_SET = PROJECT_LOCATION + "Props.aadl"

	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void testPackageContents() {
		val testFileResult = issues = testHelper.testFile(PACKAGE, PROPERTY_SET)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		testFileResult.resource.contents.head as AadlPackage => [
			publicSection.ownedClassifiers.findFirst[name == "A"] => [
				ownedPropertyAssociations.get(2).ownedValues.get(0).ownedValue => [
					assertError(testFileResult.issues, issueCollection,
						"Property value of type Props::RecordType2; expected type Props::RecordType1")
				]
				ownedPropertyAssociations.get(3).ownedValues.get(0).ownedValue => [
					assertError(testFileResult.issues, issueCollection,
						"Property value of type Props::RecordType1; expected type Props::RecordType2")
				]

				(ownedPropertyAssociations.get(6).ownedValues.get(0).ownedValue as ListValue).ownedListElements.get(1) => [
					assertError(testFileResult.issues, issueCollection,
						"Property value of type Props::RecordType2; expected type Props::RecordType1")
				]
				(ownedPropertyAssociations.get(7).ownedValues.get(0).ownedValue as ListValue).ownedListElements.get(0) => [
					assertError(testFileResult.issues, issueCollection,
						"Property value of type Props::RecordType1; expected type Props::RecordType2")
				]

				ownedPropertyAssociations.get(10).ownedValues.get(0).ownedValue as RecordValue => [
					ownedFieldValues.get(0).value => [
						assertError(testFileResult.issues, issueCollection,
							"Property value of type Props::RecordType2; expected type Props::RecordType1")
					]
					ownedFieldValues.get(1).value => [
						assertError(testFileResult.issues, issueCollection,
							"Property value of type Props::RecordType1; expected type Props::RecordType2")
					]
				]

				(ownedPropertyAssociations.get(11).ownedValues.get(0).ownedValue as ListValue).ownedListElements.get(0) as RecordValue => [
					ownedFieldValues.get(0).value => [
						assertError(testFileResult.issues, issueCollection,
							"Property value of type Props::RecordType2; expected type Props::RecordType1")
					]
					ownedFieldValues.get(1).value => [
						assertError(testFileResult.issues, issueCollection,
							"Property value of type Props::RecordType1; expected type Props::RecordType2")
					]
				]

				ownedPropertyAssociations.get(14).ownedValues.get(0).ownedValue => [
					assertError(testFileResult.issues, issueCollection,
						"Property value of type Props::RecordType2; expected type Props::RecordType1")
				]
				ownedPropertyAssociations.get(15).ownedValues.get(0).ownedValue => [
					assertError(testFileResult.issues, issueCollection,
						"Property value of type Props::RecordType1; expected type Props::RecordType2")
				]

				(ownedPropertyAssociations.get(18).ownedValues.get(0).ownedValue as ListValue).ownedListElements.get(1) => [
					assertError(testFileResult.issues, issueCollection,
						"Property value of type Props::RecordType2; expected type Props::RecordType1")
				]
				(ownedPropertyAssociations.get(19).ownedValues.get(0).ownedValue as ListValue).ownedListElements.get(0) => [
					assertError(testFileResult.issues, issueCollection,
						"Property value of type Props::RecordType1; expected type Props::RecordType2")
				]
				
				ownedPropertyAssociations.get(20).ownedValues.get(0).ownedValue => [
					assertError(testFileResult.issues, issueCollection,
						"Property value of type Props::RecordType1; expected type list of Props::RecordType1")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	@Test
	def void testPropertySet() {
		val testFileResult = issues = testHelper.testFile(PROPERTY_SET, PACKAGE)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		testFileResult.resource.contents.head as PropertySet => [
			ownedPropertyConstants.findFirst[name == "BadConstant1"].constantValue => [
				assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType2; expected type Props::RecordType1");
			]
			ownedPropertyConstants.findFirst[name == "BadConstant2"].constantValue => [
				assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType1; expected type Props::RecordType2");
			]
			
			ownedProperties.findFirst[name == "BadDefault1"].defaultValue => [
				assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType2; expected type Props::RecordType1");
			]
			ownedProperties.findFirst[name == "BadDefault2"].defaultValue => [
				assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType1; expected type Props::RecordType2");
			]
			
			(ownedPropertyConstants.findFirst[name == "BadListConstant1"].constantValue as ListValue).ownedListElements.get(1) => [
				assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType2; expected type Props::RecordType1");
			]
			(ownedPropertyConstants.findFirst[name == "BadListConstant2"].constantValue as ListValue).ownedListElements.get(0) => [
				assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType1; expected type Props::RecordType2");
			]
			
			(ownedProperties.findFirst[name == "BadListDefault1"].defaultValue as ListValue).ownedListElements.get(1) => [
				assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType2; expected type Props::RecordType1");
			]
			(ownedProperties.findFirst[name == "BadListDefault2"].defaultValue as ListValue).ownedListElements.get(0) => [
				assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType1; expected type Props::RecordType2");
			]
			
			ownedPropertyConstants.findFirst[name == "BadFieldsConstant1"].constantValue as RecordValue => [
				ownedFieldValues.get(0).value => [
					assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType2; expected type Props::RecordType1");
				]
				ownedFieldValues.get(1).value => [
					assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType1; expected type Props::RecordType2");
				]
			]
			
			(ownedPropertyConstants.findFirst[name == "BadFieldsListConstant1"].constantValue as ListValue).ownedListElements.get(0) as RecordValue => [
				ownedFieldValues.get(0).value => [
					assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType2; expected type Props::RecordType1");
				]
				ownedFieldValues.get(1).value => [
					assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType1; expected type Props::RecordType2");
				]
			]
			
			ownedProperties.findFirst[name == "BadFieldsDefault1"].defaultValue as RecordValue => [
				ownedFieldValues.get(0).value => [
					assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType2; expected type Props::RecordType1");
				]
				ownedFieldValues.get(1).value => [
					assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType1; expected type Props::RecordType2");
				]
			]

			(ownedProperties.findFirst[name == "BadFieldsListDefault1"].defaultValue as ListValue).ownedListElements.get(0) as RecordValue => [
				ownedFieldValues.get(0).value => [
					assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType2; expected type Props::RecordType1");
				]
				ownedFieldValues.get(1).value => [
					assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType1; expected type Props::RecordType2");
				]
			]

			ownedPropertyConstants.findFirst[name == "BadPropRefConstant1"].constantValue => [
				assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType2; expected type Props::RecordType1");
			]
			ownedPropertyConstants.findFirst[name == "BadPropRefConstant2"].constantValue => [
				assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType1; expected type Props::RecordType2");
			]

			ownedProperties.findFirst[name == "BadPropRefDefault1"].defaultValue => [
				assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType2; expected type Props::RecordType1");
			]
			ownedProperties.findFirst[name == "BadPropRefDefault2"].defaultValue => [
				assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType1; expected type Props::RecordType2");
			]

			(ownedPropertyConstants.findFirst[name == "BadListOfPropRefConstant1"].constantValue as ListValue).ownedListElements.get(1) => [
				assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType2; expected type Props::RecordType1");
			]
			(ownedPropertyConstants.findFirst[name == "BadListOfPropRefConstant2"].constantValue as ListValue).ownedListElements.get(0) => [
				assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType1; expected type Props::RecordType2");
			]
			
			(ownedProperties.findFirst[name == "BadListOfPropRefDefault1"].defaultValue as ListValue).ownedListElements.get(1) => [
				assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType2; expected type Props::RecordType1");
			]
			(ownedProperties.findFirst[name == "BadListOfPropRefDefault2"].defaultValue as ListValue).ownedListElements.get(0) => [
				assertError(testFileResult.issues, issueCollection, "Property value of type Props::RecordType1; expected type Props::RecordType2");
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

}
