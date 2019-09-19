package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*
import org.osate.aadl2.SystemImplementation

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue643Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue643/"
		
	val END_TO_END_FLOW_LENGTH = 5 
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void test1() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "issue643.aadl")
		testSystem(pkg, "top.i", 1, END_TO_END_FLOW_LENGTH)
	}
	
	@Test
	def void test2() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "issue643b.aadl")
		testSystem(pkg, "top.i", 1, END_TO_END_FLOW_LENGTH)
		testSystem(pkg, "top2.i", 1, END_TO_END_FLOW_LENGTH)
	}
	
	def private void testSystem(AadlPackage pkg, String sysName, int numFlows, int flowLength) {
		val system = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == sysName] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(system, errorManager)
		assertEquals(numFlows, instance.endToEndFlows.size)
		for (var i = 0; i < numFlows; i++) {
			assertEquals(flowLength, instance.endToEndFlows.get(i).flowElements.size)
		}
	}
}
