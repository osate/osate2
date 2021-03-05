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
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*
import static extension org.osate.testsupport.AssertHelper.*
import org.osate.aadl2.ThreadImplementation
import org.osate.aadl2.FlowImplementation
import org.osate.aadl2.ProcessImplementation
import org.osate.aadl2.EndToEndFlow

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1987Test extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue1987/"
	val static FILE1 = "DataTest.aadl"
	val static FILE2 = "DataTestBad.aadl"
	val static FILE3 = "EndToEndFlowData.aadl"
	val static FILE4 = "SubprogramCallTest.aadl"
		
	@Test
	def void testDataAsFlowSourceSink_good() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + FILE1)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"DataTest".assertEquals(name)			
		]
		
		// There should be no errors or warnings
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void testDataAsFlowSourceSink_bad() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + FILE2)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"DataTestBad".assertEquals(name)	
			
			publicSection.ownedClassifiers.findFirst[name == "T.i"] as ThreadImplementation => [
				ownedFlowImplementations.findFirst[specification.name == "fsrc"] as FlowImplementation => [
					ownedFlowSegments.get(1).assertError(testFileResult.issues, issueCollection,
						"The source component 'myData' of connection 'c' does not match the preceding subcomponent 'myData2'")
				]
			]			

			publicSection.ownedClassifiers.findFirst[name == "TT.i"] as ThreadImplementation => [
				ownedFlowImplementations.findFirst[specification.name == "fsnk"] as FlowImplementation => [
					ownedFlowSegments.get(0).assertError(testFileResult.issues, issueCollection,
						"The destination component 'myData' of connection 'c' does not match the succeeding subcomponent  'myData2'")
				]
			]			
		]

		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void testEndToEndFlowData() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + FILE3)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"EndToEndFlowData".assertEquals(name)	
			
			publicSection.ownedClassifiers.findFirst[name == "P.top"] as ProcessImplementation => [
				ownedEndToEndFlows.findFirst[name == "e2e_bad"] as EndToEndFlow => [
					ownedEndToEndFlowSegments.get(1).assertError(testFileResult.issues, issueCollection,
						"The source of connection 'c1' does not match the preceding subcomponent or out flow spec feature 'dataD2'")
					ownedEndToEndFlowSegments.get(3).assertError(testFileResult.issues, issueCollection,
						"The destination of connection 'c2' does not match the succeeding subcomponent or in flow spec feature 'dataE2'")
				]
			]			
		]

		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void testSubprogramCalls() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + FILE4)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"SubprogramCallTest".assertEquals(name)	
			
			publicSection.ownedClassifiers.findFirst[name == "T.i"] as ThreadImplementation => [
				ownedFlowImplementations.findFirst[specification.name == "fsrc"] as FlowImplementation => [
					ownedFlowSegments.get(1).assertError(testFileResult.issues, issueCollection,
						"The destination component 'call1' of connection 'b' does not match the succeeding subcomponent  'dummy'")
					ownedFlowSegments.get(3).assertError(testFileResult.issues, issueCollection,
						"The source of connection 'c' does not match the preceding subcomponent 'dummy'")
				]
				ownedFlowImplementations.findFirst[specification.name == "fsnk"] as FlowImplementation => [
					ownedFlowSegments.get(0).assertError(testFileResult.issues, issueCollection,
						"The destination component 'call2' of connection 'e' does not match the succeeding subcomponent  'dummy'")
					ownedFlowSegments.get(2).assertError(testFileResult.issues, issueCollection,
						"The source of connection 'f' does not match the preceding subcomponent 'dummy'")
				]
			]			
		]

		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}
