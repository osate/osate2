package org.osate.analysis.flows.tests

import com.itemis.xtext.testing.FluentIssueCollection
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
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
import org.osate.result.AnalysisResult
import org.osate.result.BooleanValue
import org.osate.result.Diagnostic
import org.osate.result.IntegerValue
import org.osate.result.RealValue
import org.osate.result.Result
import org.osate.result.StringValue
import org.osate.result.Value

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
		val pkgNames = #[
			"empty",
			"component_instance_as_segment",
			"categories",
			"dispatch",
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
			"transmission_time2"
		]
		createFiles(pkgNames.map[it + ".aadl"].map[it -> readFile(DIR_NAME + it)])
		suppressSerialization
		pkgNames.forEach[pkgName | testFile(pkgName + ".aadl").resource.contents.head as AadlPackage => [
			pkgName.assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				buildInstanceModelFile => [
					"s1_i1_Instance".assertEquals(name)
					
					val resultURI = URI.createPlatformPluginURI('''«DIR_NAME»/results/testFlowLatency/«pkgName».result''', true)
					val expected = it.eResource.resourceSet.getResource(resultURI, true).contents.head as AnalysisResult
					
					val analysis = new FlowLatencyAnalysisSwitch(new NullProgressMonitor, it)
					val actual = analysis.invokeAndGetResult(it, it.systemOperationModes.head)
					
					expected.assertAnalysisResult(actual)
				]
			]
		]]
	}
	
	@Test
	def void testWithLatencyReport() {
		val emptyPkgName = "empty"
		val emptyFileName = emptyPkgName + ".aadl"
		createFiles(emptyFileName -> readFile(DIR_NAME + emptyFileName))
		suppressSerialization
		testFile(emptyFileName).resource.contents.head as AadlPackage => [
			emptyPkgName.assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				buildInstanceModelFile => [
					"s1_i1_Instance".assertEquals(name)
					val resultURI = URI.createPlatformPluginURI('''«DIR_NAME»/results/testWithLatencyReport/«emptyPkgName».result''', true)
					val expected = it.eResource.resourceSet.getResource(resultURI, true).contents.head as AnalysisResult
					
					val analysis = new FlowLatencyAnalysisSwitch(new NullProgressMonitor, it, new LatencyReport(it))
					val actual = analysis.invokeAndGetResult(it, it.systemOperationModes.head)
					
					expected.assertAnalysisResult(actual)
				]
			]
		]
	}
	
	@Test
	def void testWorstCaseExecutionTime() {
		FlowanalysisPlugin.^default.preferenceStore.setValue(Constants.WORST_CASE_DEADLINE, Constants.WORST_CASE_DEADLINE_NO)
		val executionTimePkgName = "execution_time"
		val executionTimeFileName = executionTimePkgName + ".aadl"
		createFiles(executionTimeFileName -> readFile(DIR_NAME + executionTimeFileName))
		suppressSerialization
		testFile(executionTimeFileName).resource.contents.head as AadlPackage => [
			executionTimePkgName.assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				buildInstanceModelFile => [
					"s1_i1_Instance".assertEquals(name)
					val resultURI = URI.createPlatformPluginURI('''«DIR_NAME»/results/testWorstCaseExecutionTime/«executionTimePkgName».result''', true)
					val expected = it.eResource.resourceSet.getResource(resultURI, true).contents.head as AnalysisResult
					
					val analysis = new FlowLatencyAnalysisSwitch(new NullProgressMonitor, it)
					val actual = analysis.invokeAndGetResult(it, it.systemOperationModes.head)
					
					expected.assertAnalysisResult(actual)
				]
			]
		]
	}
	
	@Test
	def void testBestCaseFullQueue() {
		FlowanalysisPlugin.^default.preferenceStore.setValue(Constants.BESTCASE_EMPTY_QUEUE, Constants.BESTCASE_EMPTY_QUEUE_NO)
		val queuingPkgName = "queuing"
		val queuingFileName = queuingPkgName + ".aadl"
		createFiles(queuingFileName -> readFile(DIR_NAME + queuingFileName))
		suppressSerialization
		testFile(queuingFileName).resource.contents.head as AadlPackage => [
			queuingPkgName.assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				buildInstanceModelFile => [
					"s1_i1_Instance".assertEquals(name)
					val resultURI = URI.createPlatformPluginURI('''«DIR_NAME»/results/testBestCaseFullQueue/«queuingPkgName».result''', true)
					val expected = it.eResource.resourceSet.getResource(resultURI, true).contents.head as AnalysisResult
					
					val analysis = new FlowLatencyAnalysisSwitch(new NullProgressMonitor, it)
					val actual = analysis.invokeAndGetResult(it, it.systemOperationModes.head)
					
					expected.assertAnalysisResult(actual)
				]
			]
		]
	}
	
	/**
	 * This method is only for testing a file which has a validation error. After issue #1124 is fixed,
	 * connect_to_subcomponent should be moved into testFlowLatency().
	 * See https://github.com/osate/osate2-core/issues/1124
	 */
	@Test
	def void testConnectToSubcomponent() {
		val connectToSubcomponentPkgName = "connect_to_subcomponent"
		val connectToSubcomponentFileName = "connect_to_subcomponent.aadl"
		createFiles(connectToSubcomponentFileName -> readFile(DIR_NAME + connectToSubcomponentFileName))
		suppressSerialization
		val testFileResult = testFile(connectToSubcomponentFileName)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			connectToSubcomponentPkgName.assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				buildInstanceModelFile => [
					"s1_i1_Instance".assertEquals(name)
					val resultURI = URI.createPlatformPluginURI('''«DIR_NAME»/results/testConnectToSubcomponent/«connectToSubcomponentPkgName».result''', true)
					val expected = it.eResource.resourceSet.getResource(resultURI, true).contents.head as AnalysisResult
					
					val analysis = new FlowLatencyAnalysisSwitch(new NullProgressMonitor, it)
					val actual = analysis.invokeAndGetResult(it, it.systemOperationModes.head)
					
					expected.assertAnalysisResult(actual)
				]
			]
			publicSection.ownedClassifiers.get(3) as SystemImplementation => [
				"s2.i1".assertEquals(name)
				ownedEndToEndFlows.head => [
					"etef1".assertEquals(name)
					ownedEndToEndFlowSegments.get(2) => [
						"f1".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Illegal reference to 'f1'.  Cannot refer to a data access except for the first and last segment of an end-to-end flow.")
					]
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
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