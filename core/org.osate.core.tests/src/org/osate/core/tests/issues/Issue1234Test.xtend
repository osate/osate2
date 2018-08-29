package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemType
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1234Test extends XtextTest {

	@Inject
	TestHelper<AadlPackage> testHelper

	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue1234/"
	val static ISSUE_1234_AADL = "issue1234.aadl"

	@Test
	def void issue1234() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + ISSUE_1234_AADL)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		testFileResult.resource.contents.head as AadlPackage => [
			"Issue1234".assertEquals(name)
			ownedPublicSection => [
				ownedClassifiers.get(2) as SystemType => [
					"Sys".assertEquals(name)
					ownedFeatureGroups.get(0) => [
						"fg".assertEquals(name)
						assertError(testFileResult.issues, issueCollection,
							"A feature group cannot be the inverse of a feature group type with an 'inverse of' declaration.")
					]
				]
			]
		]

		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

}
