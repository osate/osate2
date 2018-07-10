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
