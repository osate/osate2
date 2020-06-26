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
import org.osate.ba.aadlba.BehaviorActionCollection
import org.osate.ba.aadlba.SharedDataAction

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2372Test {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue2372() {
		// Not using FluentIssueCollection because the BA issues aren't associated with an EObject.
		val result = testHelper.testFile("org.osate.ba.tests/models/issue2372/issue2372.aadl")
		result.resource.contents.head as AadlPackage => [
			"test_lock_actions".assertEquals(name)
			publicSection.ownedClassifiers.get(0) => [
				ownedAnnexSubclauses.head as DefaultAnnexSubclause => [
					"behavior_specification".assertEquals(name)
					(parsedAnnexSubclause!==null).assertTrue
					parsedAnnexSubclause as BehaviorAnnex => [
						actions.get(0).content as BehaviorActionCollection => [
							actions.get(1) as SharedDataAction => [
								(dataAccess.dataAccess!==null).assertTrue
							]
						]
					]
				]
			]
		]
		0.assertEquals(result.issues.size)
	}
}