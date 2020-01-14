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
	
	val static SIMPLE = "top.simple"
	val static SPECIFIC = "top.specific"
	val static WITH_CALLS_NO_FLOW_IMPL = "top.withCall_noFlowImpl"
	val static WITH_CALLS_FLOW_IMPL = "top.withCall_flowImpl"
	
	val END_TO_END_FLOW_LENGTH = 5 
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testSimplePath() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "SimpleConnectionsPath.aadl")
		testProcess(pkg, SIMPLE, 1, END_TO_END_FLOW_LENGTH)
		testProcess(pkg, WITH_CALLS_NO_FLOW_IMPL, 1, END_TO_END_FLOW_LENGTH)
		testProcess(pkg, WITH_CALLS_FLOW_IMPL, 1, END_TO_END_FLOW_LENGTH)
	}
	
	@Test
	def void testSimpleSrc() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "SimpleConnectionsSrc.aadl")
		testProcess(pkg, SIMPLE, 1, END_TO_END_FLOW_LENGTH)
		testProcess(pkg, WITH_CALLS_NO_FLOW_IMPL, 1, END_TO_END_FLOW_LENGTH)
		testProcess(pkg, WITH_CALLS_FLOW_IMPL, 1, END_TO_END_FLOW_LENGTH)
	}
	
	@Test
	def void testSimpleSnk() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "SimpleConnectionsSnk.aadl")
		testProcess(pkg, SIMPLE, 1, END_TO_END_FLOW_LENGTH)
		testProcess(pkg, WITH_CALLS_NO_FLOW_IMPL, 1, END_TO_END_FLOW_LENGTH)
		testProcess(pkg, WITH_CALLS_FLOW_IMPL, 1, END_TO_END_FLOW_LENGTH)
	}
	
	@Test
	def void testFeatureGroupPath() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "FGConnectionsPath.aadl")
		testProcess(pkg, SIMPLE, 4, END_TO_END_FLOW_LENGTH)
		testProcess(pkg, SPECIFIC, 1, END_TO_END_FLOW_LENGTH)
		testProcess(pkg, WITH_CALLS_NO_FLOW_IMPL, 4, END_TO_END_FLOW_LENGTH)
		testProcess(pkg, WITH_CALLS_FLOW_IMPL, 4, END_TO_END_FLOW_LENGTH)
	}
	
	@Test
	def void testFeatureGroupSrc() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "FGConnectionsSrc.aadl")
		testProcess(pkg, SIMPLE, 4, END_TO_END_FLOW_LENGTH)
		testProcess(pkg, SPECIFIC, 2, END_TO_END_FLOW_LENGTH)
		testProcess(pkg, WITH_CALLS_NO_FLOW_IMPL, 4, END_TO_END_FLOW_LENGTH)
		testProcess(pkg, WITH_CALLS_FLOW_IMPL, 4, END_TO_END_FLOW_LENGTH)
	}
	
	@Test
	def void testFeatureGroupSnk() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "FGConnectionsSnk.aadl")
		testProcess(pkg, SIMPLE, 4, END_TO_END_FLOW_LENGTH)
		testProcess(pkg, SPECIFIC, 2, END_TO_END_FLOW_LENGTH)
		testProcess(pkg, WITH_CALLS_NO_FLOW_IMPL, 4, END_TO_END_FLOW_LENGTH)
		testProcess(pkg, WITH_CALLS_FLOW_IMPL, 4, END_TO_END_FLOW_LENGTH)
	}
	
	def private void testProcess(AadlPackage pkg, String pname, int numFlows, int flowLength) {
		val process = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == pname] as ProcessImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(process, errorManager)
		assertEquals(numFlows, instance.endToEndFlows.size)
		for (var i = 0; i < numFlows; i++) {
			assertEquals(flowLength, instance.endToEndFlows.get(i).flowElements.size)
		}
	}
}
