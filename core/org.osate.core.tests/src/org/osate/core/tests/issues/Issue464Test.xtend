package org.osate.core.tests.issues

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class Issue464Test extends OsateTest {
	override getProjectName() {
		"issue464"
	}

	@Test
	def void issue464() {
		val aadlFile = "issue464.aadl"
		createFiles(aadlFile -> aadlText)
		suppressSerialization
		val result = testFile(aadlFile)

		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "SensorProssessing.impl2" not found', cls.exists[name == 'SensorProcessing.impl2'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'SensorProcessing.impl2'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		assertEquals('SensorProcessing_impl2_Instance', instance.name)

		// check if e2e flows are instantiated exactly once
		val p1 = instance.componentInstances.findFirst[name == 'datasetProcessing']
		val e2e1 =	 p1.endToEndFlows
		assertTrue('In datasetProcessing: Expected one e2e flow but found ' + e2e1.size, e2e1.size == 1)
		assertTrue('In datasetProcessing: Expected flow processingFlow but found ' + e2e1.head.name, e2e1.head.name == 'processingflow')

		val p2 = instance.componentInstances.findFirst[name == 'datasetProcessing2']
		val e2e2 =	 p2.endToEndFlows
		assertTrue('In datasetProcessing2: Expected one e2e flow but found ' + e2e2.size, e2e2.size == 1)
		assertTrue('In datasetProcessing2: Expected flow processingFlow but found ' + e2e2.head.name, e2e2.head.name == 'processingflow')
	}

	val aadlText = '''
package issue464
public

	system SensorProcessing
	end SensorProcessing;

	system implementation SensorProcessing.impl
		subcomponents
			datasetProcessing: process processing.completeset;
	end SensorProcessing.impl;

	system implementation SensorProcessing.impl2
		subcomponents
			datasetProcessing: process processing.completeset;
			datasetProcessing2: process processing.completeset;
	end SensorProcessing.impl2;

	data samples
	end samples;

	thread threadA
		features
			samplesIn: in event data port samples;
			samplesOut: out event data port samples;
		flows
			flowThruThreadA: flow path samplesIn -> samplesOut;
	end threadA;

	thread group threadGroupA
		features
			SamplesIn: in event data port samples;
			samplesOut: out event data port samples;
		flows
			flowThruThreadGroupA: flow path samplesIn -> samplesOut;
	end threadGroupA;

	thread group implementation threadGroupA.signal
		subcomponents
			taskA: thread threadA;
		connections
			C1: port samplesIn -> taskA.samplesIn;
			C2: port taskA.samplesOut -> samplesOut;
		flows
			flowThruThreadGroupA: flow path samplesIn -> C1 ->
					taskA.flowThruThreadA -> C2 -> samplesOut;
	end threadGroupA.signal;

	process processing
	end processing;

	process implementation processing.completeset
		subcomponents
			dsrc: thread dataSource;
			dsnk: thread dataSink;
			tg: thread group threadGroupA.signal;
		connections
			incoming: port dsrc.SamplesOut -> tg.SamplesIn;
			outgoing: port tg.samplesOut -> dsnk.samplesIn;
		flows
			processingflow: end to end flow dsrc.fromSource -> incoming -> tg.flowThruThreadGroupA -> outgoing -> dsnk.toSink;
	end processing.completeset;

	thread dataSource
		features
			samplesOut: out event data port samples;
		flows
			fromSource: flow source samplesOut;
	end dataSource;

	thread dataSink
		features
			samplesIn: in event data port samples;
		flows
			toSink: flow sink samplesIn;
	end dataSink;

end issue464;
'''
}
