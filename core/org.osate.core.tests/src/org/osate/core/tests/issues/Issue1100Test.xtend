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
class Issue1100Test extends XtextTest {
	val static PATH = "org.osate.core.tests/models/issue1100/"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue1100() {
		val testFileResult = issues = testHelper.testFile(PATH + "pkg1.aadl", PATH + "ps1.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			publicSection.ownedClassifiers.head as ThreadType => [
				"t".assertEquals(name)
				ownedPropertyAssociations.get(0).ownedValues.head.ownedValue => [
					assertError(testFileResult.issues, issueCollection, "Value must be between 1 and 10")
				]
				ownedPropertyAssociations.get(1).ownedValues.head.ownedValue => [
					assertError(testFileResult.issues, issueCollection, "Value must be between 11 sec and 20 sec")
				]
				ownedPropertyAssociations.get(2).ownedValues.head.ownedValue => [
					assertError(testFileResult.issues, issueCollection, "Value must be between 21.1 and 30.0")
				]
				ownedPropertyAssociations.get(3).ownedValues.head.ownedValue => [
					assertError(testFileResult.issues, issueCollection, "Value must be between 31.1 sec and 40.0 sec")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}