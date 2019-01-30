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
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch
import org.osate.result.RealValue
import org.osate.result.StringValue
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

import static extension org.junit.Assert.assertEquals
import static extension org.osate.xtext.aadl2.properties.util.InstanceModelUtil.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class TransmissionTimeTest extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper

	val projectprefix = "org.osate.analysis.flows.tests/models/latencytest/"

	val queuingText = "transmission_time.aadl"
	
	@Test
	def void RequiredVBTest() {

		val pkg = testHelper.parseFile(projectprefix+queuingText)
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
		val resab = latencyresult.results.get(1)
		assertTrue((resab.values.get(1) as RealValue).value == (3.0))
		assertTrue((resab.values.get(2) as RealValue).value == (6.0))
		assertTrue((resab.values.get(3) as RealValue).value == (2.0))
		assertTrue((resab.values.get(4) as RealValue).value == (4.0))
		assertTrue((resab.values.get(5) as RealValue).value == (3.0))
		assertTrue((resab.values.get(6) as RealValue).value == (4.0))
		resab.subResults.size.assertEquals(3)
		resab.diagnostics.size.assertEquals(5)
		val subres = resab.subResults.get(1)
		val myprotocol = subres.subResults.get(0)
		val subpart1 = myprotocol.modelElement as NamedElement
		assertTrue(subpart1 instanceof ComponentInstance)
		assertEquals(subpart1.name,"sub3")
		assertTrue(subpart1.isBus)
		assertEquals((myprotocol.values.get(4) as StringValue).value, "transmission time")
	}

}
