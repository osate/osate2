package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
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
		val issues = testHelper.testFile("org.osate.core.tests/models/issue1884/issue1884.aadl").issues
		5.assertEquals(issues.size)
		issues.get(0) => [
			"unterminated behavior state (missing ending ';')".assertEquals(message)
			7.assertEquals(lineNumber)
		]
		issues.get(1) => [
			"'bad_reference' is not found".assertEquals(message)
			17.assertEquals(lineNumber)
		]
		issues.get(2) => [
			"The dispatch relative timeout and catch statement must only be declared for timed thread: Behavior Annex D.4.(L1) legality rule failed.".assertEquals(message)
			27.assertEquals(lineNumber)
		]
		issues.get(3) => [
			message.startsWith("The required feature 'initialState'").assertTrue
			4.assertEquals(lineNumber)
		]
		issues.get(4) => [
			message.startsWith("The required feature 'initialState'").assertTrue
			4.assertEquals(lineNumber)
		]
	}
}