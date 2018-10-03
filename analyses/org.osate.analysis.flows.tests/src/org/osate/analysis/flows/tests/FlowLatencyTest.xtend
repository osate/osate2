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
import org.osate.analysis.flows.LatencyAnalysisService
import org.osate.result.RealValue
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

import static extension org.junit.Assert.assertEquals

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class FlowLatencyTest extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	

	val projectprefix = "org.osate.analysis.flows.tests/models/latencytest/"

	val pullprotocolsText = "PullProtocol.aadl"
	
	@Test
	def void flows_pullprotocols() {
		val pkg = testHelper.parseFile(projectprefix+pullprotocolsText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 'stub.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'stub.i'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals("stub_i_Instance", instance.name)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new LatencyAnalysisService()
		val latencyresult = checker.invoke(instance, som)
		val res = latencyresult.results.get(0)
		assertTrue((res.values.get(1) as RealValue).value == (304.0))
		assertTrue((res.values.get(2) as RealValue).value == (504.0))
		assertTrue((res.values.get(3) as RealValue).value == (4.0))
		assertTrue((res.values.get(4) as RealValue).value == (4.0))
		assertTrue((res.values.get(5) as RealValue).value == (300.0))
		assertTrue((res.values.get(6) as RealValue).value == (300.0))
		assertTrue(latencyresult.message == "AS-MF-DL-EQ")
		17.assertEquals(res.subResults.size)
	}


}
