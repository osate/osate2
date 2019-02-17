package org.osate.analysis.flows.tests

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.NamedElement
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.result.RealValue
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

import static extension org.junit.Assert.assertEquals
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class ARINC653ScheduleTest extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper

	val projectprefix = "org.osate.analysis.flows.tests/models/latencytest/"

	val vplatencyText = "arinc653schedule.aadl"
	
	@Test
	def void ARINC653Schedule() {

		val pkg = testHelper.parseFile(projectprefix+vplatencyText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 's1.i1'])

		// instantiate
		val sysImpl = cls.findFirst[name == 's1.i1'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals("s1_i1_Instance", instance.name)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true)
		val resab = latencyresult.results.get(0)
		assertTrue((resab.values.get(1) as RealValue).value == (1.0))
		assertTrue((resab.values.get(2) as RealValue).value == (1.0))
		assertTrue((resab.values.get(3) as RealValue).value == (0.0))
		assertTrue((resab.values.get(4) as RealValue).value == (0.0))
		assertTrue((resab.values.get(5) as RealValue).value == (0.0))
		assertTrue((resab.values.get(6) as RealValue).value == (0.0))
		resab.subResults.size.assertEquals(5)
		resab.diagnostics.size.assertEquals(1)
		val subres = resab.subResults.get(3)
		val partnoschedule = subres.modelElement as NamedElement
		assertTrue(partnoschedule instanceof ComponentInstance)
		assertEquals(partnoschedule.name,"sub3")
		assertEquals(subres.diagnostics.size, 4)
		val warn = subres.diagnostics.get(0)
		assertEquals(warn.message, "Partition not found in ARINC653 schedule of processor sub4")
	}


}
