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

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError
import org.osate.aadl2.ThreadImplementation

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1954Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue1954/"
	
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void testConnections() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "test.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			assertEquals("test", name)
			publicSection.ownedClassifiers.findFirst[name == "th.i"] as ThreadImplementation => [
				ownedPortConnections.findFirst[name == "bad1"] => [
					destination.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'subprogram subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.findFirst[name == "bad2"] => [
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'subprogram subcomponent' is not a valid port connection end.")
				]
				
				ownedParameterConnections.findFirst[name == "bad10"] => [
					destination.assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.findFirst[name == "bad11"] => [
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram subcomponent' is not a valid parameter connection end.")
				]

				ownedAccessConnections.findFirst[name == "bad20"] => [
					destination.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'subprogram subcomponent' is not a valid access connection end.")
				]
				ownedAccessConnections.findFirst[name == "bad21"] => [
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'subprogram subcomponent' is not a valid access connection end.")
				]

				ownedFeatureConnections.findFirst[name == "f1"] => [
					destination.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'subprogram subcomponent' is not a valid feature connection end.")
				]
				ownedFeatureConnections.findFirst[name == "f2"] => [
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'subprogram subcomponent' is not a valid feature connection end.")
				]

				ownedFeatureConnections.findFirst[name == "f5"] => [
					destination.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'subprogram subcomponent' is not a valid feature connection end.")
				]
				ownedFeatureConnections.findFirst[name == "f6"] => [
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'subprogram subcomponent' is not a valid feature connection end.")
				]
			]
		]
		
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

}
