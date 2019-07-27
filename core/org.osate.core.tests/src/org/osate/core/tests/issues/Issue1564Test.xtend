package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ThreadImplementation
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1564Test extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue1564() {
		val testFileResult = issues = testHelper.testFile("org.osate.core.tests/models/issue1564/issue1564.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"issue1564".assertEquals(name)
			publicSection.ownedClassifiers.get(3) as ThreadImplementation => [
				"not_modal.i2".assertEquals(name)
				ownedSubprogramCallSequences.get(0) => [
					"sequence2".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Multiple sequences declared for non-modal implementation")
				]
				ownedSubprogramCallSequences.get(1) => [
					"sequence3".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Multiple sequences declared for non-modal implementation")
				]
			]
			publicSection.ownedClassifiers.get(7) as ThreadImplementation => [
				"modal.i5".assertEquals(name)
				ownedSubprogramCallSequences.get(0) => [
					"sequence7".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Multiple sequences declared for modes: m1")
				]
				ownedSubprogramCallSequences.get(1) => [
					"sequence8".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Multiple sequences declared for modes: m1")
				]
			]
			publicSection.ownedClassifiers.get(8) as ThreadImplementation => [
				"modal.i6".assertEquals(name)
				ownedSubprogramCallSequences.get(0) => [
					"sequence9".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Multiple sequences declared for modes: m1")
				]
				ownedSubprogramCallSequences.get(1) => [
					"sequence10".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Multiple sequences declared for modes: m1")
				]
			]
			publicSection.ownedClassifiers.get(9) as ThreadImplementation => [
				"modal.i7".assertEquals(name)
				ownedSubprogramCallSequences.get(0) => [
					"sequence11".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Multiple sequences declared for modes: m1, m2")
				]
				ownedSubprogramCallSequences.get(1) => [
					"sequence12".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Multiple sequences declared for modes: m1, m2")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}