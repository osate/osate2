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
import org.osate.aadl2.PropertySet
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1366Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue1366/"
	val static PACKAGE = PROJECT_LOCATION + "Issue1366.aadl"
	val static PROPERTY_SET = PROJECT_LOCATION + "PS1.aadl"

	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void test1() {
		val testFileResult = issues = testHelper.testFile(PACKAGE, PROPERTY_SET)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		testFileResult.resource.contents.head as AadlPackage => [
			"Issue1366".assertEquals(name)
			publicSection.ownedClassifiers.findFirst[name == "a"] => [
				ownedPropertyAssociations.get(0).ownedValues.get(0).ownedValue => [
					assertError(testFileResult.issues, issueCollection,
						"Assigning Record value to property 'PS1::def1' of type 'ListType'")
				]
				ownedPropertyAssociations.get(1).ownedValues.get(0).ownedValue => [
					assertError(testFileResult.issues, issueCollection,
						"Assigning incorrect Classifier value to property 'PS1::def2' of type 'RecordType'")
				]
				ownedPropertyAssociations.get(2).ownedValues.get(0).ownedValue => [
					assertError(testFileResult.issues, issueCollection, "Number value is missing a unit")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	@Test
	def void test2() {
		val testFileResult = issues = testHelper.testFile(PROPERTY_SET, PACKAGE)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		testFileResult.resource.contents.head as PropertySet => [
			"PS1".assertEquals(name)
			ownedPropertyConstants.get(2).constantValue => [
				assertError(testFileResult.issues, issueCollection, "Number value is missing a unit")
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

}
