package org.osate.aadl2.errormodel.tests.issues

import com.itemis.xtext.testing.XtextTest
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import com.google.inject.Inject
import org.osate.testsupport.TestHelper
import org.osate.aadl2.AadlPackage
import org.junit.Test
import com.itemis.xtext.testing.FluentIssueCollection
import org.osate.aadl2.SystemType
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
import org.osate.aadl2.DefaultAnnexSubclause

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue2579 extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.aadl2.errormodel.tests/models/Issue2579/"
	val static FILE = "emv-transition.aadl"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void test(){
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + FILE)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"emv::transition".assertEquals(name)
			publicSection.ownedClassifiers.get(0) as SystemType=> [
				"S".assertEquals(name)
				ownedAnnexSubclauses.get(0) as DefaultAnnexSubclause => [
					it.parsedAnnexSubclause as ErrorModelSubclause => [
						transitions.get(1) => [
							it.assertError(testFileResult.issues, issueCollection, "Target state s may only have a single error type")
						]
						transitions.get(2) => [
							it.assertError(testFileResult.issues, issueCollection, "Target state s may only have a single error type")
						]
					]
					
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}
