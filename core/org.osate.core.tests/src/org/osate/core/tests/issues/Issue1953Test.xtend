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
import org.osate.aadl2.ProcessImplementation

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1953Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue1953/"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testSimple() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "SimpleConnections.aadl")
		testProcess(pkg, "top.simple", 1)
		testProcess(pkg, "top.withCall", 0)
	}
	
	@Test
	def void testFeatureGroups() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "FGConnections.aadl")
		testProcess(pkg, "top.simple", 4)
		testProcess(pkg, "top.specific", 1)
		testProcess(pkg, "top.withCall", 0)
	}
	
	def private void testProcess(AadlPackage pkg, String pname, int numFlows) {
		val process = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == pname] as ProcessImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(process, errorManager)
		assertEquals(numFlows, instance.endToEndFlows.size)
	}
}
