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
import org.osate.aadl2.IntegerLiteral
import java.text.MessageFormat

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1809Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue1809/"
	
	val static TEST1 = "Flow_Demo.aadl"
	val static TEST2 = "Flow_Demo_System.aadl"
	
	val static TOP_IMPL = "Top.impl"
	
	val static INSTANCE_NAME = "Top_impl_Instance"

	val static WARNING_MSG = "End-to-end flow ETE contains component three with subcomponents, but no flow implementation Thing_new_flow_spec3 to them"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testAbstractSubcomponent() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + TEST1)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOP_IMPL] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		
		// There should be no End To End Flow Instance
		assertEquals(instance.endToEndFlows.size, 0)

		// Should be 1 warning
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(1, messages.size)
		messages.get(0) => [
			/* Error is reported on an actual ETEI object, but we don't have a way to get a reference to it because the 
			 * system instance doesn't refer to it, and it isn't supposed to.
			 */
			assertEquals(QueuingAnalysisErrorReporter.WARNING, kind)
			assertEquals(WARNING_MSG, message)
		]
	}
	
	@Test
	def void testSystemSubcomponent() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + TEST2)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOP_IMPL] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		
		// There should be no End To End Flow Instance
		assertEquals(instance.endToEndFlows.size, 0)

		// Should be 1 warning
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(1, messages.size)
		messages.get(0) => [
			/* Error is reported on an actual ETEI object, but we don't have a way to get a reference to it because the 
			 * system instance doesn't refer to it, and it isn't supposed to.
			 */
			assertEquals(QueuingAnalysisErrorReporter.WARNING, kind)
			assertEquals(WARNING_MSG, message)
		]
	}
}

