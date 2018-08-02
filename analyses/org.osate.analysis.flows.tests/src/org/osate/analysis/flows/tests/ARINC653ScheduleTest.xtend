package org.osate.analysis.flows.tests

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.core.runtime.NullProgressMonitor
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
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.NamedElement

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class ARINC653ScheduleTest extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void VPLatencyContribution() {

		val pkg = testHelper.parseString(vplatencyText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 's1.i1'])

		// instantiate
		val sysImpl = cls.findFirst[name == 's1.i1'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals("s1_i1_Instance", instance.name)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch(new NullProgressMonitor,  instance)
		val latencyresult = checker.invoke(instance, som, true, true, true, true)
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
		val partnoschedule = subres.sourceReference as NamedElement
		assertTrue(partnoschedule instanceof ComponentInstance)
		assertEquals(partnoschedule.name,"sub3")
		assertEquals(subres.diagnostics.size, 4)
		val warn = subres.diagnostics.get(0)
		assertEquals(warn.message, "Partition not found in ARINC653 schedule of processor sub4")
	}

	val vplatencyText = '''
package partition2
public
  with ARINC653;

  system s1
  end s1;

  system implementation s1.i1
    subcomponents
      sub1: abstract a1;
      sub2: abstract a1;
      sub3: virtual processor {Period => 1 ms;};
      sub4: processor;
      sub5: virtual processor;
    connections
      conn1: feature sub1.f1 -> sub2.f1;
    flows
      etef1: end to end flow sub1 -> conn1 -> sub2;
    properties
      Actual_Processor_Binding => (reference (sub3)) applies to sub2;
      Actual_Processor_Binding => (reference (sub4)) applies to sub3;
      Actual_Processor_Binding => (reference (sub5)) applies to sub1;
      Actual_Processor_Binding => (reference (sub4)) applies to sub5;
      ARINC653::Module_Schedule => ([Partition => reference (sub5);]) applies to sub4;
  end s1.i1;

  abstract a1
    features
      f1: feature;
  end a1;
end partition2;
	'''

}
