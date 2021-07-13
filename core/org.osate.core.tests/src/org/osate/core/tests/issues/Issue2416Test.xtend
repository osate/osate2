/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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
import org.osate.aadl2.AbstractImplementation
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2416Test extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void issue2416Test(){
		val testFileResult = issues = testHelper.testFile("org.osate.core.tests/models/Issue2416/Issue2416.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"Issue2416".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"A.i".assertEquals(name)
				allFlowImplementations.get(1) => [
					it.ownedFlowSegments.get(2).assertError(testFileResult.issues, issueCollection, "The source of connection 'cml' does not match the out flow feature of the preceding subcomponent flow specification 'mm1.fpth'", "The destination of connection 'cml' does not match the in flow feature of the succeeding subcomponent flow specification 'mm2.fpth'")
				]
				allFlowImplementations.get(2) => [
					it.ownedFlowSegments.get(2).assertError(testFileResult.issues, issueCollection, "The source of connection 'cmr' does not match the out flow feature of the preceding subcomponent flow specification 'mm1.fpth'",
					"The destination of connection 'cmr' does not match the in flow feature of the succeeding subcomponent flow specification 'mm2.fpth'")
				]
				allFlowImplementations.get(2) => [
					it.ownedFlowSegments.get(4).assertError(testFileResult.issues, issueCollection, "The destination of connection 'cmm' does not match the out flow feature 'o'", "The source of connection 'cmm' does not match the out flow feature of the preceding subcomponent flow specification 'mm2.fpth'")
				]
				allFlowImplementations.get(3) => [
					it.ownedFlowSegments.get(2).assertError(testFileResult.issues, issueCollection, "The source of connection 'cmr' does not match the out flow feature of the preceding subcomponent flow specification 'mm1.fpth'")
				]
				allFlowImplementations.get(4) => [
					it.ownedFlowSegments.get(0).assertError(testFileResult.issues, issueCollection, "The destination of connection 'cml' does not match the in flow feature of the succeeding subcomponent flow specification 'mm2.fpth'")
				]
				allFlowImplementations.get(6) => [
					it.ownedFlowSegments.get(1).assertError(testFileResult.issues, issueCollection, "The source of connection 'cml' does not match the out flow feature of the preceding subcomponent flow specification 'mm1.fpth'", "The destination of connection 'cml' does not match the in flow feature of the succeeding subcomponent flow specification 'mm2.fpth'")
				]
				allFlowImplementations.get(7) => [
					it.ownedFlowSegments.get(1).assertError(testFileResult.issues, issueCollection, "The source of connection 'cmr' does not match the out flow feature of the preceding subcomponent flow specification 'mm1.fpth'")
				]
				allFlowImplementations.get(9) => [
					it.ownedFlowSegments.get(2).assertError(testFileResult.issues, issueCollection, "The source of connection 'cml' does not match the out flow feature of the preceding subcomponent flow specification 'mm1.fpth'", "The destination of connection 'cml' does not match the in flow feature of the succeeding subcomponent flow specification 'mm2.fpth'")
				]
				allFlowImplementations.get(10) => [
					it.ownedFlowSegments.get(0).assertError(testFileResult.issues, issueCollection, "The destination of connection 'cml' does not match the in flow feature of the succeeding subcomponent flow specification 'mm2.fpth'")
				]
				allFlowImplementations.get(11) => [
					it.ownedFlowSegments.get(0).assertError(testFileResult.issues, issueCollection, "The source of connection 'cmm' does not match the in flow feature 'i'")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}		
}