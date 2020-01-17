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
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.validation.Issue
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.ThreadImplementation
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI
import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue911Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue911/"
	val static FILE1 = "BadParameterConnection.aadl"
	val static FILE2 = "BadAccessConnections.aadl"
	
	val static ERROR_MESSAGE = "Connection must not be between two subcomponents; use provides/requires access features"
	
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void test1() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + FILE1)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"BadParameterConnection".assertEquals(name)
			publicSection.ownedClassifiers.findFirst[name == "T1.impl"] as ThreadImplementation => [
				ownedConnections.findFirst[name == "bad1"] => [
					assertError(testFileResult.issues, issueCollection, ERROR_MESSAGE)
				]
			]			
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	@Test
	def void test2() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + FILE2)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"BadAccessConnections".assertEquals(name)
			publicSection.ownedClassifiers.findFirst[name == "Sys1.impl"] as SystemImplementation => [
				ownedConnections.findFirst[name == "bad1"] => [
					assertError(testFileResult.issues, issueCollection, ERROR_MESSAGE)
				]
				ownedConnections.findFirst[name == "bad2"] => [
					assertError(testFileResult.issues, issueCollection, ERROR_MESSAGE)
				]
				ownedConnections.findFirst[name == "bad3"] => [
					assertError(testFileResult.issues, issueCollection, ERROR_MESSAGE)
				]
				ownedConnections.findFirst[name == "bad4"] => [
					assertError(testFileResult.issues, issueCollection, ERROR_MESSAGE)
				]
				ownedConnections.findFirst[name == "bad5"] => [
					assertError(testFileResult.issues, issueCollection, ERROR_MESSAGE)
				]
				
				ownedConnections.findFirst[name == "r1"] => [
					assertNoIssues(testFileResult.issues, issueCollection)
				]
				ownedConnections.findFirst[name == "r2"] => [
					assertNoIssues(testFileResult.issues, issueCollection)
				]
				ownedConnections.findFirst[name == "r3"] => [
					assertNoIssues(testFileResult.issues, issueCollection)
				]
				ownedConnections.findFirst[name == "r4"] => [
					assertNoIssues(testFileResult.issues, issueCollection)
				]
				ownedConnections.findFirst[name == "r5"] => [
					assertNoIssues(testFileResult.issues, issueCollection)
				]
				
				ownedConnections.findFirst[name == "p1"] => [
					assertNoIssues(testFileResult.issues, issueCollection)
				]
				ownedConnections.findFirst[name == "p2"] => [
					assertNoIssues(testFileResult.issues, issueCollection)
				]
				ownedConnections.findFirst[name == "p3"] => [
					assertNoIssues(testFileResult.issues, issueCollection)
				]
				ownedConnections.findFirst[name == "p4"] => [
					assertNoIssues(testFileResult.issues, issueCollection)
				]
				ownedConnections.findFirst[name == "p5"] => [
					assertNoIssues(testFileResult.issues, issueCollection)
				]
			]			

			publicSection.ownedClassifiers.findFirst[name == "Sys3.impl"] as SystemImplementation => [
				ownedConnections.findFirst[name == "pToR1"] => [
					assertNoIssues(testFileResult.issues, issueCollection)
				]
				ownedConnections.findFirst[name == "pToR2"] => [
					assertNoIssues(testFileResult.issues, issueCollection)
				]
				ownedConnections.findFirst[name == "pToR3"] => [
					assertNoIssues(testFileResult.issues, issueCollection)
				]
				ownedConnections.findFirst[name == "pToR4"] => [
					assertNoIssues(testFileResult.issues, issueCollection)
				]
				ownedConnections.findFirst[name == "pToR5"] => [
					assertNoIssues(testFileResult.issues, issueCollection)
				]
			]
		]
		
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	def protected static assertNoIssues(EObject eObject, List<Issue> allIssues, FluentIssueCollection issueCollection) {
		val issuesForEObject = allIssues.filter[uriToProblem == eObject.URI]
		assertTrue(issuesForEObject.isEmpty)
	}
}
