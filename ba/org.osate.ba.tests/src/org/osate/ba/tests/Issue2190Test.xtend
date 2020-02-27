package org.osate.ba.tests

import javax.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertTrue

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2190Test {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue2190_InitialValue() {
		// Not using FluentIssueCollection because the BA issues aren't associated with an EObject.
		val result = testHelper.testFile("org.osate.ba.tests/models/issue2190/issue2190_InitialValue.aadl")
		result.resource.contents.head as AadlPackage => [
			"issue2190_InitialValue".assertEquals(name)
			publicSection.ownedClassifiers.get(0) => [
				"top".assertEquals(name)
				ownedAnnexSubclauses.head as DefaultAnnexSubclause => [
					"behavior_specification".assertEquals(name)
					(parsedAnnexSubclause!==null).assertTrue
				]
			]
		]
		1.assertEquals(result.issues.size)
	}
	
	@Test
	def void testIssue2190_IntegerLiteral() {
		// Not using FluentIssueCollection because the BA issues aren't associated with an EObject.
		val result = testHelper.testFile("org.osate.ba.tests/models/issue2190/issue2190_IntegerLiteral.aadl")
		result.resource.contents.head as AadlPackage => [
			"issue2190_IntegerLiteral".assertEquals(name)
			publicSection.ownedClassifiers.get(0) => [
				"top".assertEquals(name)
				ownedAnnexSubclauses.head as DefaultAnnexSubclause => [
					"behavior_specification".assertEquals(name)
					(parsedAnnexSubclause!==null).assertTrue
				]
			]
		]
		0.assertEquals(result.issues.size)
	}
}