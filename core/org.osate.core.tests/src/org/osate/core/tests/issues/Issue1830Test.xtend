package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1830Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue1830/"
	val static FILE = "issue_flow_instantiation.aadl"

	val static TEST_BASIC = "Test.basic"
	val static INSTANCE_NAME = "Test_basic_Instance";
	
	val static PROCESSING_FLOW = "processing_flow"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testForEndToEndFlow() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TEST_BASIC] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		/* The test should have no errors. */		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(0, messages.size)

		/* The orignal problem was that the end to end flow wasn't being created.  The system instance
		 * should have 1 end to end flow named `processing_flow`.
		 */
		val end2end = instance.endToEndFlows
		assertEquals(1, end2end.size())
		assertEquals(PROCESSING_FLOW, end2end.get(0).name)
	}

}

