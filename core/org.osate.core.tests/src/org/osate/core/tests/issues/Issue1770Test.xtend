package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ThreadType
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1770Test extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue1770() {
		val testFileResult = issues = testHelper.testFile("org.osate.core.tests/models/issue1770/issue1770.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"issue1770".assertEquals(name)
			publicSection.ownedClassifiers.head as ThreadType => [
				"t1".assertEquals(name)
				ownedFeatures.head => [
					"p1".assertEquals(name)
					ownedPropertyAssociations.head.ownedValues.head.ownedValue => [
						assertError(testFileResult.issues, issueCollection,
							"Property Deployment_Properties::Runtime_Protection_Support does not apply to p1"
						)
					]
				]
				ownedPropertyAssociations.get(0).ownedValues.head.ownedValue => [
					assertError(testFileResult.issues, issueCollection,
						"Property Timing_Properties::Clock_Jitter does not apply to t1"
					)
				]
				ownedPropertyAssociations.get(1).ownedValues.head.ownedValue => [
					assertError(testFileResult.issues, issueCollection,
						"Property Deployment_Properties::Runtime_Protection_Support does not apply to p1"
					)
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}