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

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class Issue2003Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	

	val projectprefix = "org.osate.analysis.flows.tests/models/latencytest/"

	val issue2003Text = "issue2003.aadl"
	
	@Test
	def void issue2003etef() {
		val pkg = testHelper.parseFile(projectprefix+issue2003Text)
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
		val res = latencyresult.results.get(0)
		assertTrue((res.values.get(1) as RealValue).value == (5.0))
		assertTrue((res.values.get(2) as RealValue).value == (36.0))
		assertTrue((res.values.get(3) as RealValue).value == (0.0))
		assertTrue((res.values.get(4) as RealValue).value == (0.0))
		assertTrue((res.values.get(5) as RealValue).value == (0.0))
		assertTrue((res.values.get(6) as RealValue).value == (100.0))
		assertTrue(latencyresult.message == "AS-MF-DL-EQ")
	}


}
