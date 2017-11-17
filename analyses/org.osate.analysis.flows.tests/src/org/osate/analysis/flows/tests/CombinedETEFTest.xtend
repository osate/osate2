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

import static org.junit.Assert.*

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
		val errorManager = AnalysisErrorReporterManager.NULL_ERROR_MANANGER
		val checker = new CheckFlowLatency()
		val som = instance.systemOperationModes.head
		checker.invoke(new NullProgressMonitor, errorManager, instance, som)

		// read csv
		val uri = URI.createURI(
			resourceRoot + "/instances/reports/latency/CombinedETEF_Test_Impl_Instance__latency_AS-MF-DL-EQ.csv")
		val file = workspaceRoot.getFile(new Path(uri.toPlatformString(true)))
		val actual = Files.readStreamIntoString(file.contents)
		assertEquals('error', expected.trim, actual.trim)
		// read result
		val uriresult = URI.createURI(
			resourceRoot + "/instances/reports/latency/CombinedETEF_Test_Impl_Instance__latency_AS-MF-DL-EQ.result")
		val fileresult = workspaceRoot.getFile(new Path(uriresult.toPlatformString(true)))
		val actualresult = Files.readStreamIntoString(fileresult.contents)
		assertEquals('error', expectedresult.trim, actualresult.trim)
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

	val expected = '''
Latency analysis for end-to-end flow 'a_b' of system 'Test.Impl' with preference settings AS-MF-DL-EQ,

Contributor,Min Specified,Min Actual,Min Method,Max Specified,Max Actual,Max Method,Comments,
system a,10.0ms,10.0ms,specified,10.0ms,10.0ms,specified,
Connection ,,0.0ms,no latency,,0.0ms,no latency,
system b,10.0ms,10.0ms,specified,10.0ms,10.0ms,specified,
Latency Total,20.0ms,20.0ms,,20.0ms,20.0ms,,
Specified End To End Latency,,0.0ms,,,0.0ms,,
End to end Latency Summary,
WARNING,Expected end to end latency is not specified,



Latency analysis for end-to-end flow 'c_d' of system 'Test.Impl' with preference settings AS-MF-DL-EQ,

Contributor,Min Specified,Min Actual,Min Method,Max Specified,Max Actual,Max Method,Comments,
system c,10.0ms,10.0ms,specified,10.0ms,10.0ms,specified,
Connection ,,0.0ms,no latency,,0.0ms,no latency,
system d,10.0ms,10.0ms,specified,10.0ms,10.0ms,specified,
Latency Total,20.0ms,20.0ms,,20.0ms,20.0ms,,
Specified End To End Latency,,0.0ms,,,0.0ms,,
End to end Latency Summary,
WARNING,Expected end to end latency is not specified,



Latency analysis for end-to-end flow 'total' of system 'Test.Impl' with preference settings AS-MF-DL-EQ,

Contributor,Min Specified,Min Actual,Min Method,Max Specified,Max Actual,Max Method,Comments,
system a,10.0ms,10.0ms,specified,10.0ms,10.0ms,specified,
Connection ,,0.0ms,no latency,,0.0ms,no latency,
system b,10.0ms,10.0ms,specified,10.0ms,10.0ms,specified,
Connection ,,0.0ms,no latency,,0.0ms,no latency,
system c,10.0ms,10.0ms,specified,10.0ms,10.0ms,specified,
Connection ,,0.0ms,no latency,,0.0ms,no latency,
system d,10.0ms,10.0ms,specified,10.0ms,10.0ms,specified,
Latency Total,40.0ms,40.0ms,,40.0ms,40.0ms,,
Specified End To End Latency,,20.0ms,,,30.0ms,,
End to end Latency Summary,
ERROR,Minimum specified flow latency total 40.0ms exceeds expected maximum latency 30.0ms,
ERROR,Minimum actual latency total 40.0ms exceeds expected maximum end to end latency 30.0ms,
ERROR,Maximum specified flow latency total 40.0ms exceeds expected maximum end to end latency 30.0ms,
ERROR,Maximum actual latency total 40.0ms exceeds expected maximum end to end latency 30.0ms,

	'''

	val expectedresult = '''
<?xml version="1.0" encoding="ASCII"?>
<result:Result xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:result="http://www.osate.org/result/Result" analysis="latencyreport">
  <sourceReference href="../../CombinedETEF_Test_Impl_Instance.aaxl2#/"/>
  <subResults analysis="a_b">
    <sourceReference href="../../CombinedETEF_Test_Impl_Instance.aaxl2#//@endToEndFlow.0"/>
    <values xsi:type="result:StringValue" value="Latency analysis for end-to-end flow 'a_b' of system 'Test.Impl' with preference settings AS-MF-DL-EQ"/>
    <values xsi:type="result:RealValue" value="20.0"/>
    <values xsi:type="result:RealValue" value="20.0"/>
    <values xsi:type="result:RealValue" value="20.0"/>
    <values xsi:type="result:RealValue" value="20.0"/>
    <values xsi:type="result:RealValue"/>
    <values xsi:type="result:RealValue"/>
    <contributors>
      <sourceReference href="../../CombinedETEF_Test_Impl_Instance.aaxl2#//@componentInstance.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:StringValue" value="SPECIFIED"/>
      <values xsi:type="result:StringValue" value="SPECIFIED"/>
      <values xsi:type="result:StringValue" value="SYNCUNKNOWN"/>
    </contributors>
    <contributors>
      <sourceReference href="../../CombinedETEF_Test_Impl_Instance.aaxl2#//@connectionInstance.0"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:StringValue" value="UNKNOWN"/>
      <values xsi:type="result:StringValue" value="UNKNOWN"/>
      <values xsi:type="result:StringValue" value="SYNCUNKNOWN"/>
    </contributors>
    <contributors>
      <sourceReference href="../../CombinedETEF_Test_Impl_Instance.aaxl2#//@componentInstance.1"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue" value="20.0"/>
      <values xsi:type="result:RealValue" value="20.0"/>
      <values xsi:type="result:RealValue" value="20.0"/>
      <values xsi:type="result:StringValue" value="SPECIFIED"/>
      <values xsi:type="result:StringValue" value="SPECIFIED"/>
      <values xsi:type="result:StringValue" value="SYNCUNKNOWN"/>
    </contributors>
  </subResults>
  <subResults analysis="c_d">
    <sourceReference href="../../CombinedETEF_Test_Impl_Instance.aaxl2#//@endToEndFlow.1"/>
    <values xsi:type="result:StringValue" value="Latency analysis for end-to-end flow 'c_d' of system 'Test.Impl' with preference settings AS-MF-DL-EQ"/>
    <values xsi:type="result:RealValue" value="20.0"/>
    <values xsi:type="result:RealValue" value="20.0"/>
    <values xsi:type="result:RealValue" value="20.0"/>
    <values xsi:type="result:RealValue" value="20.0"/>
    <values xsi:type="result:RealValue"/>
    <values xsi:type="result:RealValue"/>
    <contributors>
      <sourceReference href="../../CombinedETEF_Test_Impl_Instance.aaxl2#//@componentInstance.2"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:StringValue" value="SPECIFIED"/>
      <values xsi:type="result:StringValue" value="SPECIFIED"/>
      <values xsi:type="result:StringValue" value="SYNCUNKNOWN"/>
    </contributors>
    <contributors>
      <sourceReference href="../../CombinedETEF_Test_Impl_Instance.aaxl2#//@connectionInstance.2"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:StringValue" value="UNKNOWN"/>
      <values xsi:type="result:StringValue" value="UNKNOWN"/>
      <values xsi:type="result:StringValue" value="SYNCUNKNOWN"/>
    </contributors>
    <contributors>
      <sourceReference href="../../CombinedETEF_Test_Impl_Instance.aaxl2#//@componentInstance.3"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue" value="20.0"/>
      <values xsi:type="result:RealValue" value="20.0"/>
      <values xsi:type="result:RealValue" value="20.0"/>
      <values xsi:type="result:StringValue" value="SPECIFIED"/>
      <values xsi:type="result:StringValue" value="SPECIFIED"/>
      <values xsi:type="result:StringValue" value="SYNCUNKNOWN"/>
    </contributors>
  </subResults>
  <subResults analysis="total">
    <sourceReference href="../../CombinedETEF_Test_Impl_Instance.aaxl2#//@endToEndFlow.2"/>
    <values xsi:type="result:StringValue" value="Latency analysis for end-to-end flow 'total' of system 'Test.Impl' with preference settings AS-MF-DL-EQ"/>
    <values xsi:type="result:RealValue" value="40.0"/>
    <values xsi:type="result:RealValue" value="40.0"/>
    <values xsi:type="result:RealValue" value="40.0"/>
    <values xsi:type="result:RealValue" value="40.0"/>
    <values xsi:type="result:RealValue" value="20.0"/>
    <values xsi:type="result:RealValue" value="30.0"/>
    <contributors>
      <sourceReference href="../../CombinedETEF_Test_Impl_Instance.aaxl2#//@componentInstance.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:StringValue" value="SPECIFIED"/>
      <values xsi:type="result:StringValue" value="SPECIFIED"/>
      <values xsi:type="result:StringValue" value="SYNCUNKNOWN"/>
    </contributors>
    <contributors>
      <sourceReference href="../../CombinedETEF_Test_Impl_Instance.aaxl2#//@connectionInstance.0"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:StringValue" value="UNKNOWN"/>
      <values xsi:type="result:StringValue" value="UNKNOWN"/>
      <values xsi:type="result:StringValue" value="SYNCUNKNOWN"/>
    </contributors>
    <contributors>
      <sourceReference href="../../CombinedETEF_Test_Impl_Instance.aaxl2#//@componentInstance.1"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue" value="20.0"/>
      <values xsi:type="result:RealValue" value="20.0"/>
      <values xsi:type="result:RealValue" value="20.0"/>
      <values xsi:type="result:StringValue" value="SPECIFIED"/>
      <values xsi:type="result:StringValue" value="SPECIFIED"/>
      <values xsi:type="result:StringValue" value="SYNCUNKNOWN"/>
    </contributors>
    <contributors>
      <sourceReference href="../../CombinedETEF_Test_Impl_Instance.aaxl2#//@connectionInstance.1"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue" value="20.0"/>
      <values xsi:type="result:RealValue" value="20.0"/>
      <values xsi:type="result:RealValue" value="20.0"/>
      <values xsi:type="result:StringValue" value="UNKNOWN"/>
      <values xsi:type="result:StringValue" value="UNKNOWN"/>
      <values xsi:type="result:StringValue" value="SYNCUNKNOWN"/>
    </contributors>
    <contributors>
      <sourceReference href="../../CombinedETEF_Test_Impl_Instance.aaxl2#//@componentInstance.2"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue" value="30.0"/>
      <values xsi:type="result:RealValue" value="30.0"/>
      <values xsi:type="result:RealValue" value="30.0"/>
      <values xsi:type="result:StringValue" value="SPECIFIED"/>
      <values xsi:type="result:StringValue" value="SPECIFIED"/>
      <values xsi:type="result:StringValue" value="SYNCUNKNOWN"/>
    </contributors>
    <contributors>
      <sourceReference href="../../CombinedETEF_Test_Impl_Instance.aaxl2#//@connectionInstance.2"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue" value="30.0"/>
      <values xsi:type="result:RealValue" value="30.0"/>
      <values xsi:type="result:RealValue" value="30.0"/>
      <values xsi:type="result:StringValue" value="UNKNOWN"/>
      <values xsi:type="result:StringValue" value="UNKNOWN"/>
      <values xsi:type="result:StringValue" value="SYNCUNKNOWN"/>
    </contributors>
    <contributors>
      <sourceReference href="../../CombinedETEF_Test_Impl_Instance.aaxl2#//@componentInstance.3"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue" value="10.0"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue"/>
      <values xsi:type="result:RealValue" value="40.0"/>
      <values xsi:type="result:RealValue" value="40.0"/>
      <values xsi:type="result:RealValue" value="40.0"/>
      <values xsi:type="result:StringValue" value="SPECIFIED"/>
      <values xsi:type="result:StringValue" value="SPECIFIED"/>
      <values xsi:type="result:StringValue" value="SYNCUNKNOWN"/>
    </contributors>
  </subResults>
</result:Result>


	'''

}
