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
class Issue2154Test {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue2154() {
		// Not using FluentIssueCollection because the BA issues aren't associated with an EObject.
		val result = testHelper.testFile("org.osate.ba.tests/models/issue2154/issue2154.aadl")
		result.resource.contents.head as AadlPackage => [
			"issue2154".assertEquals(name)
			publicSection.ownedClassifiers.get(0) => [
				"abst".assertEquals(name)
				ownedAnnexSubclauses.head as DefaultAnnexSubclause => [
					"behavior_specification".assertEquals(name)
					(parsedAnnexSubclause!==null).assertTrue
				]
			]
		]
		2.assertEquals(result.issues.size)
		result.issues.get(1) => [
			"Using a dispatch condition in an abstract component means this component can only be refined into a component category on which the Dispatch_Protocol property can be applied.".assertEquals(message)
			11.assertEquals(lineNumber)
		]
		result.issues.get(0) => [
			"process components cannot contain a dispatch condition in any of their transitions: they cannot be dispatched (extension of Behavior Annex D.3.(L5) legality rule).".assertEquals(message)
			22.assertEquals(lineNumber)
		]
	}
}