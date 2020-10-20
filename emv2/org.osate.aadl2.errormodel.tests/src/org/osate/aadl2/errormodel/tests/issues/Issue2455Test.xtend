package org.osate.aadl2.errormodel.tests.issues

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
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError


@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2455Test extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void issue2455Test(){

		val testFileResult = issues = testHelper.testFile("org.osate.aadl2.errormodel.tests/models/Issue2455/Cyclic_Error_Types.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"Cyclic_Error_Types".assertEquals(name)
			publicSection.ownedAnnexLibraries.get(0) as DefaultAnnexLibrary => [
				"EMV2".assertEquals(name)
				it.parsedAnnexLibrary as ErrorModelLibrary => [
					it.types.get(0).assertError(testFileResult.issues, issueCollection, "Cycle in supertype hierarchy of error type a at type b")
					it.types.get(1).assertError(testFileResult.issues, issueCollection, "Cycle in supertype hierarchy of error type b at type a")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
		}
}