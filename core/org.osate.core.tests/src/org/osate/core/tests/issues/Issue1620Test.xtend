package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractType
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1620Test extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test(timeout = 30_000)
	def void issue1620() {
		val testFileResult = issues = testHelper.testFile("org.osate.core.tests/models/issue1620/pkg.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pkg".assertEquals(name)
			publicSection.ownedClassifiers.get(0) as AbstractType => [
				"a1".assertEquals(name)
				ownedExtension.assertError(testFileResult.issues, issueCollection, "The extends hierarchy of a1 has a cycle.")
			]
			publicSection.ownedClassifiers.get(1) as AbstractType => [
				"a2".assertEquals(name)
				ownedExtension.assertError(testFileResult.issues, issueCollection, "The extends hierarchy of a2 has a cycle.")
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}