package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue986Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue986/"
	val static FILE1 = "package1.aadl"

	val static WARNING_NO_CLASSIFIER = "Instantiated subcomponent doesn't have a component classifier"
	
	val static S_I = "S.i"

	val static INSTANCE_NAME = "S_i_Instance"
	
	val static SUB_B = "b"
	val static SUB_B1 = "b1"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void test1() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE1)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == S_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		/* Original problem was that instantiation would crash.  So simply completing this step 
		 * indicates success.
		 */
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 2)
		
		messages.get(0) => [
			SUB_B.assertEquals((where as ComponentInstance).name)
			QueuingAnalysisErrorReporter.WARNING.assertEquals(kind)
			WARNING_NO_CLASSIFIER.assertEquals(message)
		]
		
		messages.get(1) => [
			SUB_B1.assertEquals((where as ComponentInstance).name)
			QueuingAnalysisErrorReporter.WARNING.assertEquals(kind)
			WARNING_NO_CLASSIFIER.assertEquals(message)
		]
	}
}
