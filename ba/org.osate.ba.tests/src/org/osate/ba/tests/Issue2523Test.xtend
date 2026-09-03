package org.osate.ba.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.annexsupport.AnnexRegistry
import org.osate.annexsupport.AnnexUnparserRegistry
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertFalse

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2523Test {
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void testIssue2523() {
		// Not using FluentIssueCollection because the BA issues aren't associated with an EObject.
		val result = testHelper.testFile("org.osate.ba.tests/models/issue2523/issue2523.aadl")
		result.resource.contents.get(0) as AadlPackage => [
			"issue2523".assertEquals(name)
			publicSection.ownedClassifiers.head => [
				"t".assertEquals(name)
				ownedAnnexSubclauses.head as DefaultAnnexSubclause => [
					"behavior_specification".assertEquals(name)
					val unparser = (AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID)
						as AnnexUnparserRegistry).getAnnexUnparser("behavior_specification")
					val unparsedText = unparser.unparseAnnexSubclause(parsedAnnexSubclause, "");
					InputOutput.<String>println(unparsedText);
					unparsedText.trim.empty.assertFalse
				]
			]
		]
	}
}
