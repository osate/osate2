package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.FeatureGroupType
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1233Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue1233/"
	val static ISSUE_1233_AADL = "issue1233.aadl"

	@Test
	def void issue1233() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + ISSUE_1233_AADL)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		testFileResult.resource.contents.head as AadlPackage => [
			"Issue1233".assertEquals(name)
			ownedPublicSection => [
				ownedClassifiers.get(4) as FeatureGroupType => [
					"FG21".assertEquals(name)
					ownedFeatureGroups.get(1) => [
						"fg2".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "All ports, parameters, feature groups, and abstract features in the referenced feature group type must satisfy the direction specified in the feature group.")
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

}
