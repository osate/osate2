package org.osate.analysis.flows.tests

import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch
import org.osate.analysis.flows.FlowanalysisPlugin
import org.osate.analysis.flows.model.LatencyReport
import org.osate.analysis.flows.preferences.Constants
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals
import static extension org.osate.aadl2.instantiation.InstantiateModel.buildInstanceModelFile

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class FlowLatencyCodeCoverageTest extends OsateTest {
	val static DIR_NAME = "org.osate.analysis.flows.tests/models/FlowLatencyCodeCoverage/"
	
	@Before
	def void resetPreferences() {
		FlowanalysisPlugin.^default.preferenceStore.toDefault = Constants.WORST_CASE_DEADLINE
		FlowanalysisPlugin.^default.preferenceStore.toDefault = Constants.BESTCASE_EMPTY_QUEUE
	}
	
	@Test
	def void testFlowLatency() {
		val fileNames = #[
			"empty",
			"component_instance_as_segment",
			"categories",
			"dispatch",
			"immediate",
			"partition",
			"execution_time",
			"queuing",
			"data_port_connection",
			"bound_to_vb",
			"latency",
			"hardware"
		].map[it + ".aadl"]
		createFiles(fileNames.map[it -> readFile(DIR_NAME + it)])
		suppressSerialization
		fileNames.forEach[fileName | testFile(fileName).resource.contents.head as AadlPackage => [
			fileName.subSequence(0, fileName.lastIndexOf(".")).assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				buildInstanceModelFile => [
					"s1_i1_Instance".assertEquals(name)
					new FlowLatencyAnalysisSwitch(new NullProgressMonitor, it).processPreOrderAll(it)
				]
			]
		]]
	}
	
	@Test
	def void testWithLatencyReport() {
		val emptyFileName = "empty.aadl"
		createFiles(emptyFileName -> readFile(DIR_NAME + emptyFileName))
		suppressSerialization
		testFile(emptyFileName).resource.contents.head as AadlPackage => [
			"empty".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				buildInstanceModelFile => [
					"s1_i1_Instance".assertEquals(name)
					new FlowLatencyAnalysisSwitch(new NullProgressMonitor, it, new LatencyReport(it)).processPreOrderAll(it)
				]
			]
		]
	}
	
	@Test
	def void testWorstCaseExecutionTime() {
		FlowanalysisPlugin.^default.preferenceStore.setValue(Constants.WORST_CASE_DEADLINE, Constants.WORST_CASE_DEADLINE_NO)
		val executionTimeFileName = "execution_time.aadl"
		createFiles(executionTimeFileName -> readFile(DIR_NAME + executionTimeFileName))
		suppressSerialization
		testFile(executionTimeFileName).resource.contents.head as AadlPackage => [
			"execution_time".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				buildInstanceModelFile => [
					"s1_i1_Instance".assertEquals(name)
					new FlowLatencyAnalysisSwitch(new NullProgressMonitor, it).processPreOrderAll(it)
				]
			]
		]
	}
	
	@Test
	def void testBestCaseFullQueue() {
		FlowanalysisPlugin.^default.preferenceStore.setValue(Constants.BESTCASE_EMPTY_QUEUE, Constants.BESTCASE_EMPTY_QUEUE_NO)
		val queuingFileName = "queuing.aadl"
		createFiles(queuingFileName -> readFile(DIR_NAME + queuingFileName))
		suppressSerialization
		testFile(queuingFileName).resource.contents.head as AadlPackage => [
			"queuing".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				buildInstanceModelFile => [
					"s1_i1_Instance".assertEquals(name)
					new FlowLatencyAnalysisSwitch(new NullProgressMonitor, it).processPreOrderAll(it)
				]
			]
		]
	}
}