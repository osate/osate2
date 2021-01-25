package org.osate.aadl2.errormodel.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError
@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue2408Test extends XtextTest {
	val static FILE = "org.osate.aadl2.errormodel.tests/models/Issue2408/Issue2408.aadl"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue2408() {
		val testFileResult = issues = testHelper.testFile(FILE)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"Issue2408".assertEquals(name)
			publicSection.ownedClassifiers.head => [
				"fgt".assertEquals(name)
				ownedAnnexSubclauses.head => [
					"EMV2".assertEquals(name)
					assertError(testFileResult.issues, issueCollection,
						"Error model subclauses are not permitted in feature group types.")
				]
			]
		]
		issueCollection.sizeIs(1)
		assertConstraints(issueCollection)
	}
}