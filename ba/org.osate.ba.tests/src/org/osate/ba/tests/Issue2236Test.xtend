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
import org.osate.ba.aadlba.BehaviorAnnex
import org.osate.ba.AadlBaUnParserAction

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2236Test {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue2236() {
		// Not using FluentIssueCollection because the BA issues aren't associated with an EObject.
		val result = testHelper.testFile("org.osate.ba.tests/models/issue2236/issue2236.aadl")
		result.resource.contents.head as AadlPackage => [
			"issue2236".assertEquals(name)
			publicSection.ownedClassifiers.get(1) => [
				"function1".assertEquals(name)
				ownedAnnexSubclauses.head as DefaultAnnexSubclause => [
					"behavior_specification".assertEquals(name)
					(parsedAnnexSubclause!==null).assertTrue
					val unparser = new AadlBaUnParserAction();
					val res = unparser.unparseAnnexSubclause(parsedAnnexSubclause," ");
					val text = sourceText.substring(3).substring(0, sourceText.length-8); // remove {** and **}
					res.assertEquals(text);
				]
			]
		]
		0.assertEquals(result.issues.size)
		
		
	}
}