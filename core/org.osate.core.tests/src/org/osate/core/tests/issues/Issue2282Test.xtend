package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.PropertySet
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2282Test extends XtextTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testIssue2282() {
		val testFileResult = issues = testHelper.testFile("org.osate.core.tests/models/Issue2282/cycle.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as PropertySet => [
			"cycle".assertEquals(name)
			ownedPropertyConstants.get(0) => [
				"single_cycle".assertEquals(name)
				constantValue.assertError(testFileResult.issues, issueCollection,
					"Cyclic value discovered for 'cycle::single_cycle'"
				)
			]
			ownedPropertyConstants.get(1) => [
				"a".assertEquals(name)
				constantValue.assertError(testFileResult.issues, issueCollection,
					"Cyclic value discovered for 'cycle::a'"
				)
			]
			ownedPropertyConstants.get(2) => [
				"b".assertEquals(name)
				constantValue.assertError(testFileResult.issues, issueCollection,
					"Cyclic value discovered for 'cycle::b'"
				)
			]
			ownedPropertyConstants.get(3) => [
				"c".assertEquals(name)
				constantValue.assertError(testFileResult.issues, issueCollection,
					"Cyclic value discovered for 'cycle::c'"
				)
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}