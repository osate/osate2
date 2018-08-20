package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.PropertySet
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1366Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue1366/"
	val static PACKAGE = PROJECT_LOCATION + "Issue1366.aadl"
	val static PROPERTY_SET = PROJECT_LOCATION + "PS1.aadl"

	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void test1() {
		val testFileResult = issues = testHelper.testFile(PACKAGE, PROPERTY_SET)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		testFileResult.resource.contents.head as AadlPackage => [
			"Issue1366".assertEquals(name)
			publicSection.ownedClassifiers.findFirst[name == "a"] => [
				ownedPropertyAssociations.get(0).ownedValues.get(0).ownedValue => [
					assertError(testFileResult.issues, issueCollection,
						"Assigning Record value to property 'PS1::def1' of type 'ListType'")
				]
				ownedPropertyAssociations.get(1).ownedValues.get(0).ownedValue => [
					assertError(testFileResult.issues, issueCollection,
						"Assigning incorrect Classifier value to property 'PS1::def2' of type 'RecordType'")
				]
				ownedPropertyAssociations.get(2).ownedValues.get(0).ownedValue => [
					assertError(testFileResult.issues, issueCollection, "Number value is missing a unit")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	@Test
	def void test2() {
		val testFileResult = issues = testHelper.testFile(PROPERTY_SET, PACKAGE)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		testFileResult.resource.contents.head as PropertySet => [
			"PS1".assertEquals(name)
			ownedPropertyConstants.get(2).constantValue => [
				assertError(testFileResult.issues, issueCollection, "Number value is missing a unit")
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

}
