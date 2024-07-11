package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.XtextRunner
import org.osate.testsupport.Aadl2InjectorProvider
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.InjectWith
import org.osate.testsupport.TestHelper
import org.osate.aadl2.AadlPackage
import org.junit.Test

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError
import org.osate.aadl2.SubprogramGroup
import org.osate.aadl2.FlowSpecification

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1563 extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue1563/"
	val static FILE = "subprogram_flows.aadl"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void test(){
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + FILE)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"subprogram_flows".assertEquals(name)
			publicSection.ownedClassifiers.get(0) as SubprogramGroup => [
				"sg".assertEquals(name)
				ownedElements.get(2) as FlowSpecification => [
					it.assertError(testFileResult.issues, issueCollection,"Flow specifications are not allowed within a Subprogram Group")
				]
				ownedElements.get(3) as FlowSpecification => [
					it.assertError(testFileResult.issues, issueCollection,"Flow specifications are not allowed within a Subprogram Group")
				]
				ownedElements.get(4) as FlowSpecification => [
					it.assertError(testFileResult.issues, issueCollection,"Flow specifications are not allowed within a Subprogram Group")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
		
}