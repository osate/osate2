package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.aadl2.instantiation.InstantiateModel
import static extension org.junit.Assert.*
import com.itemis.xtext.testing.XtextTest
import com.itemis.xtext.testing.FluentIssueCollection
import org.osate.aadl2.AbstractImplementation
import static extension org.osate.testsupport.AssertHelper.assertWarning

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1984Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue1984/"

	val static FILE2 = "pkg1.aadl"
	
	val static WARNING_FLOW_EMPTY = "Flow implementation is empty and does not add value to the model"
		
	val static A1_I = "a1.i"
	val static A2_I = "a2.i"
	
	val static INSTANCE_NAME = "a1_i_Instance"
	
	val static FPATH1 = "fpath1"
	
	val static ERROR_NO_END_TO_END_FLOW1 = "Cannot create end to end flow 'etef1' because there are no semantic connections that connect to the start of the flow 'fpath1' at feature 'af1'"
	
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void doTest() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "FGConnections.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "top.specific"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// There should be no errors on the instance model.  Before the issue was fixed, we used to have errors
		assertTrue(messages.size == 0)
	}

	/* Taken from Issue879 */
	@Test
	def void test2() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + FILE2)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		val pkg = testFileResult.resource.contents.head as AadlPackage;
		pkg => [
			"pkg1".assertEquals(name)
			
			publicSection.ownedClassifiers.findFirst[name == A2_I] as AbstractImplementation => [
				ownedFlowImplementations.findFirst[specification.name == FPATH1] => [
					assertWarning(testFileResult.issues, issueCollection, WARNING_FLOW_EMPTY)
				]
			]			
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
		
		// instantiate and test
		
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A1_I] as AbstractImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.length == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			ERROR_NO_END_TO_END_FLOW1.assertEquals(message)			
		]
	}
}
