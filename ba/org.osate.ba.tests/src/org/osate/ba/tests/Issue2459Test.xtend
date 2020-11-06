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
import org.osate.ba.unparser.AadlBaUnparser
import org.osate.ba.aadlba.BehaviorElement

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2459Test {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue2459() {
		// Not using FluentIssueCollection because the BA issues aren't associated with an EObject.
		val result = testHelper.testFile("org.osate.ba.tests/models/issue2459/issue2459.aadl")
		result.resource.contents.get(0) as AadlPackage => [
			"issue2459".assertEquals(name)
			publicSection.ownedClassifiers.head => [
				"top".assertEquals(name)
				ownedAnnexSubclauses.head as DefaultAnnexSubclause => [
					"behavior_specification".assertEquals(name)
					val unparser = new AadlBaUnparser();
					val unparsedText = unparser.process(parsedAnnexSubclause as BehaviorElement);
					InputOutput.<String>println(unparsedText);
					sourceText.assertEquals("{**"+unparsedText+"        **}");
				]
			]
		]
	}
}