/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue464Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper;
	
	@Test
	def void issue464() {
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "SensorProssessing.impl2" not found', cls.exists[name == 'SensorProcessing.impl2'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'SensorProcessing.impl2'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
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
