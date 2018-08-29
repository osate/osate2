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
class Issue1465Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue1465/"
	
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void testOverridingConstantProperty() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "Issue1465.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"Issue1465".assertEquals(name)
			publicSection.ownedClassifiers.findFirst[name == "main_memory"] => [
				ownedPropertyAssociations.get(0) => [
					assertError(testFileResult.issues, issueCollection, "Property association overrides constant property value from Issue1465::main_memory")
				]
			]			
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

}
