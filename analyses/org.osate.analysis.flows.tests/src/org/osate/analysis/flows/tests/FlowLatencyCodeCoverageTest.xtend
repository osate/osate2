package org.osate.analysis.flows.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.osate.testsupport.ResultHelper.*

import static extension org.junit.Assert.assertEquals
import static extension org.osate.aadl2.instantiation.InstantiateModel.instantiate

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class FlowLatencyCodeCoverageTest {
	val static DIR_NAME = "org.osate.analysis.flows.tests/models/FlowLatencyCodeCoverage/"
	
	val static boolean generateResults = false
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testFlowLatency() {
		val pkgNames = #[
			"empty",
			"component_instance_as_segment",
			"connect_to_subcomponent",
			"categories",
			"categories2",
			"dispatch",
			"dispatch2",
			"immediate",
			"partition1",
			"partition2",
			"partition3",
			"partition4",
			"partition5",
			"partition6",
			"partition7",
			"partition8",
			"partition9",
			"partition10",
			"partition11",
			"partition12",
			"partition13",
			"execution_time",
			"queuing",
			"data_port_connection",
			"bound_to_vb",
			"latency",
			"hardware",
			"partition_duration",
			"bound_to_processor",
			"required_vb1",
			"required_vb2",
			"transmission_time1",
			"transmission_time2",
			"not_in_schedule",
			"no_parition_latency",
			"negative_time",
			"other_parition_in_schedule"
		]
		pkgNames.forEach[pkgName |
			testHelper.parseFile(DIR_NAME + pkgName + ".aadl") => [
				pkgName.assertEquals(name)
				publicSection.ownedClassifiers.get(1) as SystemImplementation => [
					instantiate => [
						"s1_i1_Instance".assertEquals(name)
						
						val analysis = new FlowLatencyAnalysisSwitch()
						val actual = analysis.invoke(it, it.systemOperationModes.head,true,true,true,true)
						val resultPath = '''«DIR_NAME»results/testFlowLatency/«pkgName».result'''
						generateOrAssert(generateResults, resultPath,actual)
					]
				]
			]
		]
	}
	
	@Test
	def void testWithLatencyReport() {
		val emptyPkgName = "empty"
		testHelper.parseFile(DIR_NAME + emptyPkgName + ".aadl") => [
			emptyPkgName.assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				instantiate => [
					"s1_i1_Instance".assertEquals(name)
					
					val analysis = new FlowLatencyAnalysisSwitch()
					val actual = analysis.invoke(it, it.systemOperationModes.head,true,true,true,true)

					val resultPath = '''«DIR_NAME»results/testWithLatencyReport/«emptyPkgName».result'''
					generateOrAssert(generateResults, resultPath,actual)
				]
			]
		]
	}
	
	@Test
	def void testWorstCaseExecutionTime() {
		val executionTimePkgName = "execution_time"
		testHelper.parseFile(DIR_NAME + executionTimePkgName + ".aadl") => [
			executionTimePkgName.assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				instantiate => [
					"s1_i1_Instance".assertEquals(name)
					
					val analysis = new FlowLatencyAnalysisSwitch()
					val actual = analysis.invoke(it, it.systemOperationModes.head, true, true, false, true)

					val resultPath = '''«DIR_NAME»results/testWorstCaseExecutionTime/«executionTimePkgName».result'''
					generateOrAssert(generateResults, resultPath,actual)
				]
			]
		]
	}
	
	@Test
	def void testBestCaseFullQueue() {
		val queuingPkgName = "queuing"
		testHelper.parseFile(DIR_NAME + queuingPkgName + ".aadl") => [
			queuingPkgName.assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				instantiate => [
					"s1_i1_Instance".assertEquals(name)
					
					val analysis = new FlowLatencyAnalysisSwitch()
					val actual = analysis.invoke(it, it.systemOperationModes.head, true, true, true, false)
					val resultPath = '''«DIR_NAME»results/testBestCaseFullQueue/«queuingPkgName».result'''
					generateOrAssert(generateResults, resultPath,actual)
				]
			]
		]
	}
}