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
package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ReferenceValue
import org.osate.aadl2.SystemImplementation
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError
import static extension org.osate.testsupport.AssertHelper.assertWarning

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1769Test extends XtextTest {
	val static PATH = "org.osate.core.tests/models/issue1769/"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue1769() {
		val testFileResult = issues = testHelper.testFile(PATH + "reference_arrays.aadl", PATH + "ps1.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"reference_arrays".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i".assertEquals(name)
				ownedPropertyAssociations.get(2) => [
					"def3".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertWarning(testFileResult.issues, issueCollection,
							"Array ranges in reference values are not property instantiated"
						)
					]
				]
				ownedPropertyAssociations.get(3) => [
					"def4".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "'m1' is not an array")
					]
				]
				ownedPropertyAssociations.get(4) => [
					"def5".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "'sub2' is not an array")
					]
				]
				ownedPropertyAssociations.get(5) => [
					"def6".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "Too few array dimensions: 'sub1' has 2")
					]
				]
				ownedPropertyAssociations.get(6) => [
					"def7".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.get(2) => [
						assertError(testFileResult.issues, issueCollection, "Too many array dimensions: 'sub1' has 2")
					]
				]
				ownedPropertyAssociations.get(7) => [
					"def8".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "Array indices start at 1")
					]
				]
				ownedPropertyAssociations.get(8) => [
					"def9".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "Index is greater than array size 5")
					]
				]
				ownedPropertyAssociations.get(9) => [
					"def10".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "Array indices start at 1")
						assertWarning(testFileResult.issues, issueCollection,
							"Array ranges in reference values are not property instantiated"
						)
					]
				]
				ownedPropertyAssociations.get(10) => [
					"def11".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "Upper bound is greater than array size 5")
						assertWarning(testFileResult.issues, issueCollection,
							"Array ranges in reference values are not property instantiated"
						)
					]
				]
				ownedPropertyAssociations.get(11) => [
					"def12".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection,
							"Array indices start at 1",
							"Upper bound is greater than array size 5"
						)
						assertWarning(testFileResult.issues, issueCollection,
							"Array ranges in reference values are not property instantiated"
						)
					]
				]
				ownedPropertyAssociations.get(12) => [
					"def13".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "Range lower bound is greater than upper bound")
						assertWarning(testFileResult.issues, issueCollection,
							"Array ranges in reference values are not property instantiated"
						)
					]
				]
				ownedPropertyAssociations.get(13) => [
					"def14".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "Index is greater than array size 5")
					]
				]
				ownedPropertyAssociations.get(14) => [
					"def15".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "Upper bound is greater than array size 5")
						assertWarning(testFileResult.issues, issueCollection,
							"Array ranges in reference values are not property instantiated"
						)
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}