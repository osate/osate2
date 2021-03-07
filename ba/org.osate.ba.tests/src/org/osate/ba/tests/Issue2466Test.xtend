package org.osate.ba.tests

import javax.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.ba.aadlba.BehaviorElement
import org.osate.ba.unparser.AadlBaUnparser
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2466Test {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue2466() {
		// Not using FluentIssueCollection because the BA issues aren't associated with an EObject.
		val result = testHelper.testFile("org.osate.ba.tests/models/issue2466/issue2466.aadl")
		result.resource.contents.get(0) as AadlPackage => [
			"issue2466".assertEquals(name)
			publicSection.ownedClassifiers.get(5) => [
				"s2".assertEquals(name)
				ownedAnnexSubclauses.head as DefaultAnnexSubclause => [
					"behavior_specification".assertEquals(name)
					val unparser = new AadlBaUnparser();
					val unparsedText = unparser.process(parsedAnnexSubclause as BehaviorElement);
					InputOutput.<String>println(unparsedText);
					sourceText.assertEquals("{**"+unparsedText+"        **}");
				]
			]
			
			3.assertEquals(result.issues.size)
		]
	}
}