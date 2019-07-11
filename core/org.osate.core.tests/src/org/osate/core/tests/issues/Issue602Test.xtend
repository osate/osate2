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
class Issue602Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue602/"
	
	val static UNCONNECTED = "Unconnected.aadl"
	val static UNCONNECTED_IMP = "Unconnected.Imp"

	val static INSTANCE_NAME = "Unconnected_Imp_Instance"

	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void test() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + UNCONNECTED)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == UNCONNECTED_IMP] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		/* The first test should have no errors. */		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		
		// Find s1.s2.s3
		val p1 = instance.componentInstances.get(0)
		val p1_msgOutC = p1.featureInstances.get(3)
		val p2 = instance.componentInstances.get(1)
		val p2_msgOutC = p2.featureInstances.get(3)
		
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(2, messages.size)
		messages.get(0) => [
			assertEquals(p1_msgOutC, where)
			assertEquals(QueuingAnalysisErrorReporter.WARNING, kind)
			assertEquals("Could not continue connection from Unconnected_Imp_Instance.p1.t.msgOutC  through Unconnected_Imp_Instance.p1.msgOutC. No connection instance created.", message)
		]
		messages.get(1) => [
			assertEquals(p2_msgOutC, where)
			assertEquals(QueuingAnalysisErrorReporter.WARNING, kind)
			assertEquals("Could not continue connection from Unconnected_Imp_Instance.p2.t.msgOutC  through Unconnected_Imp_Instance.p2.msgOutC. No connection instance created.", message)
		]
	}	
}

