package org.osate.ba.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2525Test {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue2525() {
		// Not using FluentIssueCollection because the BA issues aren't associated with an EObject.
		val result = testHelper.testFile("org.osate.ba.tests/models/issue2525/issue2525.aadl")
		result.resource.contents.head as AadlPackage => [
			"issue2525".assertEquals(name)
			publicSection.ownedClassifiers.head => [
				"t".assertEquals(name)
				ownedAnnexSubclauses.head as DefaultAnnexSubclause => [
					"behavior_specification".assertEquals(name)
				]
			]
		]
		2.assertEquals(result.issues.size)
	}
}