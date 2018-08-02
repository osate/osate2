package org.osate.analysis.flows.tests

import com.google.inject.Inject
import java.net.URL
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch
import org.osate.analysis.flows.model.LatencyReport
import org.osate.result.AnalysisResult
import org.osate.result.BooleanValue
import org.osate.result.Diagnostic
import org.osate.result.IntegerValue
import org.osate.result.RealValue
import org.osate.result.Result
import org.osate.result.StringValue
import org.osate.result.Value
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper
import org.osate.testsupport.TestResourceSetHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.aadl2.instantiation.InstantiateModel.instantiate

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class FlowLatencyCodeCoverageTest {
	val static DIR_NAME = "org.osate.analysis.flows.tests/models/FlowLatencyCodeCoverage/"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	@Inject
	TestResourceSetHelper resourceSetHelper
	@Inject
	ParseHelper<AadlPackage> parseHelper
	
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
			"no_prior_contributor"
		]
		val resourceSet = resourceSetHelper.resourceSet
		pkgNames.forEach[pkgName |
			val fileName = pkgName + ".aadl"
			parseHelper.parse(testHelper.readFile(DIR_NAME + fileName), URI.createURI(fileName), resourceSet) => [
				pkgName.assertEquals(name)
				publicSection.ownedClassifiers.get(1) as SystemImplementation => [
					instantiate => [
						"s1_i1_Instance".assertEquals(name)
						val expected = loadResult(resourceSet, '''testFlowLatency/«pkgName».result''')
						
						val analysis = new FlowLatencyAnalysisSwitch(new NullProgressMonitor, it)
						val actual = analysis.invoke(it, it.systemOperationModes.head)
						
						expected.assertAnalysisResult(actual)
					]
				]
			]
		]
	}
	
	@Test
	def void testWithLatencyReport() {
		val emptyPkgName = "empty"
		val emptyFileName = emptyPkgName + ".aadl"
		val resourceSet = resourceSetHelper.resourceSet
		parseHelper.parse(testHelper.readFile(DIR_NAME + emptyFileName), URI.createURI(emptyFileName), resourceSet) => [
			emptyPkgName.assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				instantiate => [
					"s1_i1_Instance".assertEquals(name)
					val expected = loadResult(resourceSet, '''testWithLatencyReport/«emptyPkgName».result''')
					
					val analysis = new FlowLatencyAnalysisSwitch(new NullProgressMonitor, it, new LatencyReport(it))
					val actual = analysis.invoke(it, it.systemOperationModes.head)
					
					expected.assertAnalysisResult(actual)
				]
			]
		]
	}
	
	@Test
	def void testWorstCaseExecutionTime() {
		val executionTimePkgName = "execution_time"
		val executionTimeFileName = executionTimePkgName + ".aadl"
		val resourceSet = resourceSetHelper.resourceSet
		parseHelper.parse(testHelper.readFile(DIR_NAME + executionTimeFileName), URI.createURI(executionTimeFileName), resourceSet) => [
			executionTimePkgName.assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				instantiate => [
					"s1_i1_Instance".assertEquals(name)
					val expected = loadResult(resourceSet, '''testWorstCaseExecutionTime/«executionTimePkgName».result''')
					
					val analysis = new FlowLatencyAnalysisSwitch(new NullProgressMonitor, it)
					val actual = analysis.invoke(it, it.systemOperationModes.head, true, true, false, true)
					
					expected.assertAnalysisResult(actual)
				]
			]
		]
	}
	
	@Test
	def void testBestCaseFullQueue() {
		val queuingPkgName = "queuing"
		val queuingFileName = queuingPkgName + ".aadl"
		val resourceSet = resourceSetHelper.resourceSet
		parseHelper.parse(testHelper.readFile(DIR_NAME + queuingFileName), URI.createURI(queuingFileName), resourceSet) => [
			queuingPkgName.assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				instantiate => [
					"s1_i1_Instance".assertEquals(name)
					val expected = loadResult(resourceSet, '''testBestCaseFullQueue/«queuingPkgName».result''')
					
					val analysis = new FlowLatencyAnalysisSwitch(new NullProgressMonitor, it)
					val actual = analysis.invoke(it, it.systemOperationModes.head, true, true, true, false)
					
					expected.assertAnalysisResult(actual)
				]
			]
		]
	}
	
	def private static AnalysisResult loadResult(ResourceSet resourceSet, String path) {
		val resource = resourceSet.createResource(URI.createURI(path))
		val url = new URL('''file:«System.getProperty("user.dir")»/../«DIR_NAME»/results/«path»''')
		val inputStream = url.openConnection.inputStream
		resource.load(inputStream, null)
		inputStream.close
		resource.contents.head as AnalysisResult
	}
	
	def private static assertAnalysisResult(AnalysisResult expected, AnalysisResult actual) {
		expected.analysis.assertEquals(actual.analysis)
		expected.info.assertEquals(actual.info)
		expected.sourceReference.assertEObject(actual.sourceReference)
		expected.results.size.assertEquals(actual.results.size)
		(0 ..< expected.results.size).forEach[expected.results.get(it).assertResult(actual.results.get(it))]
	}
	
	def private static void assertResult(Result expected, Result actual) {
		expected.info.assertEquals(actual.info)
		expected.sourceReference.assertEObject(actual.sourceReference)
		expected.values.size.assertEquals(actual.values.size)
		(0 ..< expected.values.size).forEach[expected.values.get(it).assertValue(actual.values.get(it))]
		expected.diagnostics.size.assertEquals(actual.diagnostics.size)
		(0 ..< expected.diagnostics.size).forEach[expected.diagnostics.get(it).assertDiagnostic(actual.diagnostics.get(it))]
		expected.subResults.size.assertEquals(actual.subResults.size)
		(0 ..< expected.subResults.size).forEach[expected.subResults.get(it).assertResult(actual.subResults.get(it))]
	}
	
	def private static void assertValue(Value expected, Value actual) {
		expected.eClass.name.assertEquals(actual.eClass.name)
		switch expected {
			BooleanValue: expected.value.assertEquals((actual as BooleanValue).value)
			IntegerValue: {
				expected.value.assertEquals((actual as IntegerValue).value)
				expected.unit.assertEquals((actual as IntegerValue).unit)
			}
			RealValue: {
				expected.value.assertEquals((actual as RealValue).value, 0.000_001)
				expected.unit.assertEquals((actual as RealValue).unit)
			}
			StringValue: expected.value.assertEquals((actual as StringValue).value)
		}
	}
	
	def private static void assertDiagnostic(Diagnostic expected, Diagnostic actual) {
		expected.type.assertEquals(actual.type)
		expected.exceptionType.assertEquals(actual.exceptionType)
		expected.source.assertEquals(actual.source)
	}
	
	def private static void assertEObject(EObject expected, EObject actual) {
		val expectedURI = if (expected !== null) {
			EcoreUtil.getURI(expected)
		}
		val actualURI = if (actual !== null) {
			EcoreUtil.getURI(actual)
		}
		expectedURI.assertEquals(actualURI)
	}
}