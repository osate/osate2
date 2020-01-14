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
class Issue2056Test {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue2056() {
		// Not using FluentIssueCollection because the BA issues aren't associated with an EObject.
		val result = testHelper.testFile("org.osate.ba.tests/models/issue2056/issue2056.aadl")
		result.resource.contents.head as AadlPackage => [
			"issue2056".assertEquals(name)
			publicSection.ownedClassifiers.get(1) => [
				"threadA.impl".assertEquals(name)
				ownedAnnexSubclauses.head as DefaultAnnexSubclause => [
					"behavior_specification".assertEquals(name)
					(parsedAnnexSubclause===null).assertTrue
				]
			]
		]
		3.assertEquals(result.issues.size)
		result.issues.get(0) => [
			"Wrong type in dispatch trigger condition; expected types are: in event port or in event data port or provides subprogram access".assertEquals(message)
			19.assertEquals(lineNumber)
		]
		result.issues.get(1) => [
			"Wrong type in assignment left hand side; expected types are: data subcomponent or data access or behavior variable or data access feature prototype or out parameter or out port or out port prototype".assertEquals(message)
			38.assertEquals(lineNumber)
		]
		result.issues.get(2) => [
			"Wrong type in dispatch trigger condition; expected types are: in event port or in event data port or provides subprogram access".assertEquals(message)
			39.assertEquals(lineNumber)
		]
	}
}