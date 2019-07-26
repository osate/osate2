package org.osate.ba.tests

import javax.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.ba.aadlba.BehaviorAnnex
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertTrue

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1884Test {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue1884() {
		// Not using FluentIssueCollection because the BA issues aren't associated with an EObject.
		val result = testHelper.testFile("org.osate.ba.tests/models/issue1884/issue1884.aadl")
		result.resource.contents.head as AadlPackage => [
			"issue1884".assertEquals(name)
			publicSection.ownedClassifiers.get(0) => [
				"parser_error".assertEquals(name)
				ownedAnnexSubclauses.head as DefaultAnnexSubclause => [
					"behavior_specification".assertEquals(name)
					(parsedAnnexSubclause instanceof BehaviorAnnex).assertTrue
				]
			]
		]
		5.assertEquals(result.issues.size)
		result.issues.get(0) => [
			"unterminated behavior state (missing ending ';')".assertEquals(message)
			7.assertEquals(lineNumber)
		]
		result.issues.get(1) => [
			"'bad_reference' is not found".assertEquals(message)
			17.assertEquals(lineNumber)
		]
		result.issues.get(2) => [
			"The dispatch relative timeout and catch statement must only be declared for timed thread: Behavior Annex D.4.(L1) legality rule failed.".assertEquals(message)
			27.assertEquals(lineNumber)
		]
		result.issues.get(3) => [
			message.startsWith("The required feature 'initialState'").assertTrue
			4.assertEquals(lineNumber)
		]
		result.issues.get(4) => [
			message.startsWith("The required feature 'initialState'").assertTrue
			4.assertEquals(lineNumber)
		]
	}
}