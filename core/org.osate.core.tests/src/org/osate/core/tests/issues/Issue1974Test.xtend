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
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*
import com.itemis.xtext.testing.XtextTest
import com.itemis.xtext.testing.FluentIssueCollection
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.EndToEndFlow
import org.osate.aadl2.Connection
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1974Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue1974/"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testPorts() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "ports.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		// no errors
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void testDataAccess() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "data_access.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		// no errors
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void testPortsUnidirectional() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "ports_unidirectional.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			assertEquals("ports_unidirectional", name)
			publicSection.ownedClassifiers.findFirst[name == "top.i"] as SystemImplementation => [
				ownedEndToEndFlows.findFirst[name == "e2e_2a"] as EndToEndFlow => [
					getOwnedEndToEndFlowSegments().get(1) => [
						val flowElement = getFlowElement
						assertTrue(flowElement instanceof Connection)
						assertEquals("c1", (flowElement as Connection).name)
						assertError(testFileResult.issues, issueCollection,
							"The source of connection 'c1' does not match the preceding subcomponent or out flow spec feature 'c'",
							"The destination of connection 'c1' does not match the succeeding subcomponent or in flow spec feature 'm'")
					]
					getOwnedEndToEndFlowSegments().get(3) => [
						val flowElement = getFlowElement
						assertTrue(flowElement instanceof Connection)
						assertEquals("c0", (flowElement as Connection).name)
						assertError(testFileResult.issues, issueCollection,
							"The source of connection 'c0' does not match the preceding subcomponent or out flow spec feature 'm'",
							"The destination of connection 'c0' does not match the succeeding subcomponent or in flow spec feature 'p'")
					]
				]
				ownedEndToEndFlows.findFirst[name == "e2e_3b"] as EndToEndFlow => [
					getOwnedEndToEndFlowSegments().get(1) => [
						val flowElement = getFlowElement
						assertTrue(flowElement instanceof Connection)
						assertEquals("c1", (flowElement as Connection).name)
						assertError(testFileResult.issues, issueCollection,
							"The source of connection 'c1' does not match the preceding subcomponent or out flow spec feature 'c.x'",
							"The destination of connection 'c1' does not match the succeeding subcomponent or in flow spec feature 'm.x'")
					]
					getOwnedEndToEndFlowSegments().get(3) => [
						val flowElement = getFlowElement
						assertTrue(flowElement instanceof Connection)
						assertEquals("c0", (flowElement as Connection).name)
						assertError(testFileResult.issues, issueCollection,
							"The source of connection 'c0' does not match the preceding subcomponent or out flow spec feature 'm.x'",
							"The destination of connection 'c0' does not match the succeeding subcomponent or in flow spec feature 'p.x'")
					]
				]
			]

			publicSection.ownedClassifiers.findFirst[name == "top.i2"] as SystemImplementation => [
				ownedEndToEndFlows.findFirst[name == "e2e_1a"] as EndToEndFlow => [
					getOwnedEndToEndFlowSegments().get(1) => [
						val flowElement = getFlowElement
						assertTrue(flowElement instanceof Connection)
						assertEquals("c0", (flowElement as Connection).name)
						assertError(testFileResult.issues, issueCollection,
							"The source of connection 'c0' does not match the preceding subcomponent or out flow spec feature 'p'",
							"The destination of connection 'c0' does not match the succeeding subcomponent or in flow spec feature 'm'")
					]
					getOwnedEndToEndFlowSegments().get(3) => [
						val flowElement = getFlowElement
						assertTrue(flowElement instanceof Connection)
						assertEquals("c1", (flowElement as Connection).name)
						assertError(testFileResult.issues, issueCollection,
							"The source of connection 'c1' does not match the preceding subcomponent or out flow spec feature 'm'",
							"The destination of connection 'c1' does not match the succeeding subcomponent or in flow spec feature 'c'")
					]
				]
				ownedEndToEndFlows.findFirst[name == "e2e_1b"] as EndToEndFlow => [
					getOwnedEndToEndFlowSegments().get(1) => [
						val flowElement = getFlowElement
						assertTrue(flowElement instanceof Connection)
						assertEquals("c0", (flowElement as Connection).name)
						assertError(testFileResult.issues, issueCollection,
							"The source of connection 'c0' does not match the preceding subcomponent or out flow spec feature 'p.x'",
							"The destination of connection 'c0' does not match the succeeding subcomponent or in flow spec feature 'm.x'")
					]
					getOwnedEndToEndFlowSegments().get(3) => [
						val flowElement = getFlowElement
						assertTrue(flowElement instanceof Connection)
						assertEquals("c1", (flowElement as Connection).name)
						assertError(testFileResult.issues, issueCollection,
							"The source of connection 'c1' does not match the preceding subcomponent or out flow spec feature 'm.x'",
							"The destination of connection 'c1' does not match the succeeding subcomponent or in flow spec feature 'c.x'")
					]
				]
			]
		]
		
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void testPortsBadEndpoints() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "ports_bad_endpoints.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			assertEquals("ports_bad_endpoints", name)
			publicSection.ownedClassifiers.findFirst[name == "top.i"] as SystemImplementation => [
				ownedEndToEndFlows.findFirst[name == "e2e_12_incorrect"] as EndToEndFlow => [
					getOwnedEndToEndFlowSegments().get(1) => [
						val flowElement = getFlowElement
						assertTrue(flowElement instanceof Connection)
						assertEquals("c12", (flowElement as Connection).name)
						assertError(testFileResult.issues, issueCollection,
							"The destination of connection 'c12' does not match the succeeding subcomponent or in flow spec feature 'c.ip1'")
					]
				]
				ownedEndToEndFlows.findFirst[name == "e2e_21_incorrect"] as EndToEndFlow => [
					getOwnedEndToEndFlowSegments().get(1) => [
						val flowElement = getFlowElement
						assertTrue(flowElement instanceof Connection)
						assertEquals("c21", (flowElement as Connection).name)
						assertError(testFileResult.issues, issueCollection,
							"The source of connection 'c21' does not match the preceding subcomponent or out flow spec feature 'p.op1'")
					]
				]
				ownedEndToEndFlows.findFirst[name == "e2e_22_incorrect"] as EndToEndFlow => [
					getOwnedEndToEndFlowSegments().get(1) => [
						val flowElement = getFlowElement
						assertTrue(flowElement instanceof Connection)
						assertEquals("c22", (flowElement as Connection).name)
						assertError(testFileResult.issues, issueCollection,
							"The source of connection 'c22' does not match the preceding subcomponent or out flow spec feature 'p.op1'",
							"The destination of connection 'c22' does not match the succeeding subcomponent or in flow spec feature 'c.ip1'")
					]
				]
			]

			publicSection.ownedClassifiers.findFirst[name == "top.i2"] as SystemImplementation => [
				ownedEndToEndFlows.findFirst[name == "e2e_12_incorrect"] as EndToEndFlow => [
					getOwnedEndToEndFlowSegments().get(1) => [
						val flowElement = getFlowElement
						assertTrue(flowElement instanceof Connection)
						assertEquals("c12", (flowElement as Connection).name)
						assertError(testFileResult.issues, issueCollection,
							"The destination of connection 'c12' does not match the succeeding subcomponent or in flow spec feature 'c1.ip1'")
					]
				]
				ownedEndToEndFlows.findFirst[name == "e2e_21_incorrect"] as EndToEndFlow => [
					getOwnedEndToEndFlowSegments().get(1) => [
						val flowElement = getFlowElement
						assertTrue(flowElement instanceof Connection)
						assertEquals("c21", (flowElement as Connection).name)
						assertError(testFileResult.issues, issueCollection,
							"The source of connection 'c21' does not match the preceding subcomponent or out flow spec feature 'p1.op1'")
					]
				]
				ownedEndToEndFlows.findFirst[name == "e2e_22_incorrect"] as EndToEndFlow => [
					getOwnedEndToEndFlowSegments().get(1) => [
						val flowElement = getFlowElement
						assertTrue(flowElement instanceof Connection)
						assertEquals("c22", (flowElement as Connection).name)
						assertError(testFileResult.issues, issueCollection,
							"The source of connection 'c22' does not match the preceding subcomponent or out flow spec feature 'p1.op1'",
							"The destination of connection 'c22' does not match the succeeding subcomponent or in flow spec feature 'c1.ip1'")
					]
				]

				ownedEndToEndFlows.findFirst[name == "e2e_12s_incorrect"] as EndToEndFlow => [
					getOwnedEndToEndFlowSegments().get(1) => [
						val flowElement = getFlowElement
						assertTrue(flowElement instanceof Connection)
						assertEquals("c12", (flowElement as Connection).name)
						assertError(testFileResult.issues, issueCollection,
							"The destination of connection 'c12' does not match the succeeding subcomponent or in flow spec feature 'c1'")
					]
				]
				ownedEndToEndFlows.findFirst[name == "e2e_21s_incorrect"] as EndToEndFlow => [
					getOwnedEndToEndFlowSegments().get(1) => [
						val flowElement = getFlowElement
						assertTrue(flowElement instanceof Connection)
						assertEquals("c21", (flowElement as Connection).name)
						assertError(testFileResult.issues, issueCollection,
							"The source of connection 'c21' does not match the preceding subcomponent or out flow spec feature 'p1'")
					]
				]
				ownedEndToEndFlows.findFirst[name == "e2e_22s_incorrect"] as EndToEndFlow => [
					getOwnedEndToEndFlowSegments().get(1) => [
						val flowElement = getFlowElement
						assertTrue(flowElement instanceof Connection)
						assertEquals("c22", (flowElement as Connection).name)
						assertError(testFileResult.issues, issueCollection,
							"The source of connection 'c22' does not match the preceding subcomponent or out flow spec feature 'p1'",
							"The destination of connection 'c22' does not match the succeeding subcomponent or in flow spec feature 'c1'")
					]
				]
			]
		]
		
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}
