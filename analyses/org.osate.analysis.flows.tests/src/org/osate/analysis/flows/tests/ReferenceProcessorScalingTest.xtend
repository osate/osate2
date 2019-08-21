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
class ReferenceProcessorScalingTest extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper

	val projectprefix = "org.osate.analysis.flows.tests/models/latencytest/"

	val refprocText = "refproc.aadl"
	
	@Test
	def void flows_refprocessor() {

		val pkg = testHelper.parseFile(projectprefix+refprocText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 'top.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'top.i'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check flow latency
		var som = instance.systemOperationModes.head
		var checker = new FlowLatencyAnalysisSwitch()
		var latencyresult = checker.invoke(instance, som,true,true,false,true)
		val resab = latencyresult.results.get(0)
		assertTrue((resab.values.get(1) as RealValue).value == (200.0))
		assertTrue((resab.values.get(2) as RealValue).value == (400.0))

		// instantiate
		val sysImplu = cls.findFirst[name == 'top.iu'] as SystemImplementation
		val instanceu = InstantiateModel.instantiate(sysImplu)


		som = instanceu.systemOperationModes.head
		latencyresult = checker.invoke(instanceu, som,true,true,false,true)
		val rescd = latencyresult.results.get(0)
		assertTrue((rescd.values.get(1) as RealValue).value == (50.0))
		assertTrue((rescd.values.get(2) as RealValue).value == (100.0))

	}

}
