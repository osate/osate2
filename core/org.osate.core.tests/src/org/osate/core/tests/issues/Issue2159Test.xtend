package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ReferenceValue
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError
import static extension org.osate.testsupport.AssertHelper.assertWarning

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2159Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue2159/"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue2159() {
		val testFileResult = issues = testHelper.testFile(
			PROJECT_LOCATION + "Issue2159.aadl",
			PROJECT_LOCATION + "ps1.aadl"
		)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"Issue2159".assertEquals(name)
			publicSection.ownedClassifiers.head => [
				"a1".assertEquals(name)
				ownedPropertyAssociations.get(0) => [
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "'f1' does not have an array size")
					]
				]
				ownedPropertyAssociations.get(1) => [
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertWarning(testFileResult.issues, issueCollection,
							"Array ranges in reference values are not property instantiated"
						)
					]
				]
				ownedPropertyAssociations.get(2) => [
					appliesTos.head.path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "'f1' does not have an array size")
					]
				]
			]
		]
		
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}