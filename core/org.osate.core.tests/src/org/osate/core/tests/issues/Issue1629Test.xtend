package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1629Test extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue1629() {
		val pkg1 = '''
			package pkg1
			public
				system s1
					properties
						Mode_Transition_Response => Emergency;
				end s1;
			end pkg1;
		'''
		val testFileResult = issues = testHelper.testString(pkg1)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			publicSection.ownedClassifiers.head => [
				"s1".assertEquals(name)
				ownedPropertyAssociations.head => [
					"Mode_Transition_Response".assertEquals(property.name)
					assertError(testFileResult.issues, issueCollection, "Property Thread_Properties::Mode_Transition_Response does not apply to s1")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}