package org.osate.analysis.flows.tests

import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.util.Files
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.analysis.flows.handlers.CheckFlowLatency
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertTrue
import org.osate.result.RealValue
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class CombinedETEFTest extends OsateTest {
	@Test
	def void flows_combinedETEFs() {
		val combinedETEFFile = "CombinedETEF.aadl"
		createFiles(combinedETEFFile -> combinedETEFText)
		suppressSerialization
		val result = testFile(combinedETEFFile)

		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 'Test.Impl'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'Test.Impl'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		assertEquals("Test_Impl_Instance", instance.name)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch(new NullProgressMonitor,  instance)
		val latencyresult = checker.invokeAndGetResult(instance, som)
		val resab = latencyresult.subResults.get(0)
		assertTrue((resab.values.get(1) as RealValue).value == (20.0))
		assertTrue((resab.values.get(2) as RealValue).value == (20.0))
		assertTrue((resab.values.get(3) as RealValue).value == (20.0))
		assertTrue((resab.values.get(4) as RealValue).value == (20.0))
		assertTrue((resab.values.get(5) as RealValue).value == (0.0))
		assertTrue((resab.values.get(6) as RealValue).value == (0.0))
		resab.contributors.size.assertEquals(3)
		resab.diagnostics.size.assertEquals(1)

		val rescd = latencyresult.subResults.get(1)
		assertTrue((rescd.values.get(1) as RealValue).value == (20.0))
		assertTrue((rescd.values.get(2) as RealValue).value == (20.0))
		assertTrue((rescd.values.get(3) as RealValue).value == (20.0))
		assertTrue((rescd.values.get(4) as RealValue).value == (20.0))
		assertTrue((rescd.values.get(5) as RealValue).value == (0.0))
		assertTrue((rescd.values.get(6) as RealValue).value == (0.0))
		rescd.contributors.size.assertEquals(3)
		rescd.diagnostics.size.assertEquals(1)

		val restotal = latencyresult.subResults.get(2)
		assertTrue((restotal.values.get(1) as RealValue).value == (40.0))
		assertTrue((restotal.values.get(2) as RealValue).value == (40.0))
		assertTrue((restotal.values.get(3) as RealValue).value == (40.0))
		assertTrue((restotal.values.get(4) as RealValue).value == (40.0))
		assertTrue((restotal.values.get(5) as RealValue).value == (20.0))
		assertTrue((restotal.values.get(6) as RealValue).value == (30.0))
		restotal.contributors.size.assertEquals(7)
		restotal.diagnostics.size.assertEquals(4)

	}

	val combinedETEFText = '''
package CombinedETEF
public
	system SubsystemA
		features
			a_in: in feature;
			a_out: out feature;
		flows
			a_flow: flow path a_in -> a_out {Latency => 10ms .. 10ms;};
	end SubsystemA;

	system SubsystemB
		features
			b_in: in feature;
			b_out: out feature;
		flows
			b_flow: flow path b_in -> b_out {Latency => 10ms .. 10ms;};
	end SubsystemB;

	system SubsystemC
		features
			c_in: in feature;
			c_out: out feature;
		flows
			c_flow: flow path c_in -> c_out {Latency => 10ms .. 10ms;};
	end SubsystemC;

	system SubsystemD
		features
			d_in: in feature;
			d_out: out feature;
		flows
			d_flow: flow path d_in -> d_out {Latency => 10ms .. 10ms;};
	end SubsystemD;

	system Test
	end Test;

	system implementation Test.Impl
		subcomponents
			a: system SubsystemA;
			b: system SubsystemB;
			c: system SubsystemC;
			d: system SubsystemD;
		connections
			a_to_b: feature a.a_out -> b.b_in;
			b_to_c: feature b.b_out -> c.c_in;
			c_to_d: feature c.c_out -> d.d_in;
		flows
			a_b: end to end flow a.a_flow -> a_to_b -> b.b_flow;
			c_d: end to end flow c.c_flow -> c_to_d -> d.d_flow;
			total: end to end flow a_b -> b_to_c -> c_d {Latency => 20ms .. 30ms;};
	end Test.Impl;
end CombinedETEF;
	'''

}
