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
class Issue2147Test {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue2147() {
		// Not using FluentIssueCollection because the BA issues aren't associated with an EObject.
		val result = testHelper.testFile("org.osate.ba.tests/models/issue2147/issue2147.aadl")
		result.resource.contents.head as AadlPackage => [
			"issue2147".assertEquals(name)
			publicSection.ownedClassifiers.get(2) => [
				"threadA.impl".assertEquals(name)
				ownedAnnexSubclauses.head as DefaultAnnexSubclause => [
					"behavior_specification".assertEquals(name)
					(parsedAnnexSubclause!==null).assertTrue
				]
			]
		]
		0.assertEquals(result.issues.size)
	}
}