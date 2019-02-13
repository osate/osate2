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
import org.osate.result.RealValue
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

import static extension org.junit.Assert.assertEquals
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class CombinedETEFTest extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper

	val projectprefix = "org.osate.analysis.flows.tests/models/latencytest/"

	val combinedETEFText = "CombinedETEF.aadl"
	
	@Test
	def void flows_combinedETEFs() {

		val pkg = testHelper.parseFile(projectprefix+combinedETEFText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 'Test.Impl'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'Test.Impl'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals("Test_Impl_Instance", instance.name)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true)
		val resab = latencyresult.results.get(0)
		assertTrue((resab.values.get(1) as RealValue).value == (20.0))
		assertTrue((resab.values.get(2) as RealValue).value == (20.0))
		assertTrue((resab.values.get(3) as RealValue).value == (20.0))
		assertTrue((resab.values.get(4) as RealValue).value == (20.0))
		assertTrue((resab.values.get(5) as RealValue).value == (0.0))
		assertTrue((resab.values.get(6) as RealValue).value == (0.0))
		resab.subResults.size.assertEquals(3)
		resab.diagnostics.size.assertEquals(1)

		val rescd = latencyresult.results.get(1)
		assertTrue((rescd.values.get(1) as RealValue).value == (20.0))
		assertTrue((rescd.values.get(2) as RealValue).value == (20.0))
		assertTrue((rescd.values.get(3) as RealValue).value == (20.0))
		assertTrue((rescd.values.get(4) as RealValue).value == (20.0))
		assertTrue((rescd.values.get(5) as RealValue).value == (0.0))
		assertTrue((rescd.values.get(6) as RealValue).value == (0.0))
		rescd.subResults.size.assertEquals(3)
		rescd.diagnostics.size.assertEquals(1)

		val restotal = latencyresult.results.get(2)
		assertTrue((restotal.values.get(1) as RealValue).value == (40.0))
		assertTrue((restotal.values.get(2) as RealValue).value == (40.0))
		assertTrue((restotal.values.get(3) as RealValue).value == (40.0))
		assertTrue((restotal.values.get(4) as RealValue).value == (40.0))
		assertTrue((restotal.values.get(5) as RealValue).value == (20.0))
		assertTrue((restotal.values.get(6) as RealValue).value == (30.0))
		restotal.subResults.size.assertEquals(7)
		restotal.diagnostics.size.assertEquals(4)

	}

}
