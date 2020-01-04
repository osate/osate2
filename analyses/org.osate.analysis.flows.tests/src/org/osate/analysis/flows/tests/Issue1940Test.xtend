package org.osate.analysis.flows.tests

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch
import org.osate.result.RealValue
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

import static extension org.junit.Assert.assertEquals
import org.osate.result.Result

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class Issue1940Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper

	static val projectprefix = "org.osate.analysis.flows.tests/models/Issue1940/"
	
	@Test
	def void periodic() {
		val pkg = testHelper.parseFile(projectprefix + "Periodic.aadl")
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 's.impl'])

		// instantiate
		val sysImpl = cls.findFirst[name == 's.impl'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals("s_impl_Instance", instance.name)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true)
		checkMinMaxComputeExecutionTime(latencyresult.results.get(0), 5.0, 10.0)
		checkMinMaxComputeExecutionTime(latencyresult.results.get(1), 5.0, 10.0)
		checkMinMaxComputeExecutionTime(latencyresult.results.get(2), 5.0, 10.0)
		checkMinMaxComputeExecutionTime(latencyresult.results.get(3), 5.0, 10.0)
	}
	
	@Test
	def void periodic_reference_processor() {
		val pkg = testHelper.parseFile(projectprefix + "Periodic_RefProc.aadl")
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 's.impl'])

		// instantiate
		val sysImpl = cls.findFirst[name == 's.impl'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals("s_impl_Instance", instance.name)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true)
		checkMinMaxComputeExecutionTime(latencyresult.results.get(0), 1.25, 2.5)
		checkMinMaxComputeExecutionTime(latencyresult.results.get(1), 1.25, 2.5)
		checkMinMaxComputeExecutionTime(latencyresult.results.get(2), 1.25, 2.5)
		checkMinMaxComputeExecutionTime(latencyresult.results.get(3), 1.25, 2.5)
	}
	
	@Test
	def void aperiodic() {
		val pkg = testHelper.parseFile(projectprefix + "Aperiodic.aadl")
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 's.impl'])

		// instantiate
		val sysImpl = cls.findFirst[name == 's.impl'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals("s_impl_Instance", instance.name)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true)
		checkMinMaxComputeExecutionTime(latencyresult.results.get(0), 5.0, 10.0)
		checkMinMaxComputeExecutionTime(latencyresult.results.get(1), 15.0, 20.0)
		checkMinMaxComputeExecutionTime(latencyresult.results.get(2), 3.0, 6.0)
		checkMinMaxComputeExecutionTime(latencyresult.results.get(3), 20.0, 23.0)
	}
	
	@Test
	def void aperiodic_reference_processor() {
		val pkg = testHelper.parseFile(projectprefix + "Aperiodic_RefProc.aadl")
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 's.impl'])

		// instantiate
		val sysImpl = cls.findFirst[name == 's.impl'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals("s_impl_Instance", instance.name)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true)
		checkMinMaxComputeExecutionTime(latencyresult.results.get(0), 1.25, 2.5)
		checkMinMaxComputeExecutionTime(latencyresult.results.get(1), 3.75, 5.0)
		checkMinMaxComputeExecutionTime(latencyresult.results.get(2), 0.75, 1.5)
		checkMinMaxComputeExecutionTime(latencyresult.results.get(3), 5.0, 5.75)
	}


	def static void checkMinMaxComputeExecutionTime(Result result, double minExpected, double maxExpected) {
		val Result subResult = result.subResults.get(5)
		val min = (subResult.values.get(0) as RealValue).value
		val max = (subResult.values.get(1) as RealValue).value
		assertEquals(minExpected, min, 0.0)
		assertEquals(maxExpected, max, 0.0)
	}

}
