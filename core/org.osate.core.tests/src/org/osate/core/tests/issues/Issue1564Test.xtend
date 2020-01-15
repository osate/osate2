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
import org.osate.aadl2.ThreadImplementation
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1564Test extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue1564() {
		val testFileResult = issues = testHelper.testFile("org.osate.core.tests/models/issue1564/issue1564.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"issue1564".assertEquals(name)
			publicSection.ownedClassifiers.get(3) as ThreadImplementation => [
				"not_modal.i2".assertEquals(name)
				ownedSubprogramCallSequences.get(0) => [
					"sequence2".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Multiple sequences declared for non-modal implementation")
				]
				ownedSubprogramCallSequences.get(1) => [
					"sequence3".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Multiple sequences declared for non-modal implementation")
				]
			]
			publicSection.ownedClassifiers.get(7) as ThreadImplementation => [
				"modal.i5".assertEquals(name)
				ownedSubprogramCallSequences.get(0) => [
					"sequence7".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Multiple sequences declared for modes: m1")
				]
				ownedSubprogramCallSequences.get(1) => [
					"sequence8".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Multiple sequences declared for modes: m1")
				]
			]
			publicSection.ownedClassifiers.get(8) as ThreadImplementation => [
				"modal.i6".assertEquals(name)
				ownedSubprogramCallSequences.get(0) => [
					"sequence9".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Multiple sequences declared for modes: m1")
				]
				ownedSubprogramCallSequences.get(1) => [
					"sequence10".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Multiple sequences declared for modes: m1")
				]
			]
			publicSection.ownedClassifiers.get(9) as ThreadImplementation => [
				"modal.i7".assertEquals(name)
				ownedSubprogramCallSequences.get(0) => [
					"sequence11".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Multiple sequences declared for modes: m1, m2")
				]
				ownedSubprogramCallSequences.get(1) => [
					"sequence12".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Multiple sequences declared for modes: m1, m2")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}