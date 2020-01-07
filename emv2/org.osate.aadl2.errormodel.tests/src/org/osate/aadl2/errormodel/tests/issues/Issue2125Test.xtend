package org.osate.aadl2.errormodel.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.testsupport.TestHelper
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.emf.common.util.URI
import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.*
import org.osate.testsupport.AssertHelper
import org.osate.aadl2.DeviceImplementation
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue2125Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.aadl2.errormodel.tests/models/Issue2125/"
	
	@Inject
	TestHelper<AadlPackage> testHelper

	
	extension AssertHelper assertHelper = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(
		URI.createFileURI("dummy.emv2")).get(AssertHelper)
	
	@Test
	def void testPkg1() {
		val pkg1FileName = "ErrorStateWithTypes.aadl"
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + pkg1FileName)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"ErrorStateWithTypes".assertEquals(name)
			publicSection.ownedClassifiers.get(3) as DeviceImplementation => [
				"iPCA_Error_Detector.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					transitions.get(1) as ErrorBehaviorTransition => [
						assertError(testFileResult.issues, issueCollection, "Target state failed_undetected requires type but the triggering error event post_not_detect_failure or source state working does not have a type")
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}