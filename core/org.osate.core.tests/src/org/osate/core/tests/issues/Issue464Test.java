/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Objects;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue464Test extends XtextTest {
	private static final String AADL_TEXT = """
			package issue464
			public
			
			\tsystem SensorProcessing
			\tend SensorProcessing;
			
			\tsystem implementation SensorProcessing.impl
			\t	subcomponents
			\t		datasetProcessing: process processing.completeset;
			\tend SensorProcessing.impl;
			
			\tsystem implementation SensorProcessing.impl2
			\t	subcomponents
			\t		datasetProcessing: process processing.completeset;
			\t		datasetProcessing2: process processing.completeset;
			\tend SensorProcessing.impl2;
			
			\tdata samples
			\tend samples;
			
			\tthread threadA
			\t	features
			\t		samplesIn: in event data port samples;
			\t		samplesOut: out event data port samples;
			\t	flows
			\t		flowThruThreadA: flow path samplesIn -> samplesOut;
			\tend threadA;
			
			\tthread group threadGroupA
			\t	features
			\t		SamplesIn: in event data port samples;
			\t		samplesOut: out event data port samples;
			\t	flows
			\t		flowThruThreadGroupA: flow path samplesIn -> samplesOut;
			\tend threadGroupA;
			
			\tthread group implementation threadGroupA.signal
			\t	subcomponents
			\t		taskA: thread threadA;
			\t	connections
			\t		C1: port samplesIn -> taskA.samplesIn;
			\t		C2: port taskA.samplesOut -> samplesOut;
			\t	flows
			\t		flowThruThreadGroupA: flow path samplesIn -> C1 ->
			\t				taskA.flowThruThreadA -> C2 -> samplesOut;
			\tend threadGroupA.signal;
			
			\tprocess processing
			\tend processing;
			
			\tprocess implementation processing.completeset
			\t	subcomponents
			\t		dsrc: thread dataSource;
			\t		dsnk: thread dataSink;
			\t		tg: thread group threadGroupA.signal;
			\t	connections
			\t		incoming: port dsrc.SamplesOut -> tg.SamplesIn;
			\t		outgoing: port tg.samplesOut -> dsnk.samplesIn;
			\t	flows
			\t		processingflow: end to end flow dsrc.fromSource -> incoming -> tg.flowThruThreadGroupA -> outgoing -> dsnk.toSink;
			\tend processing.completeset;
			
			\tthread dataSource
			\t	features
			\t		samplesOut: out event data port samples;
			\t	flows
			\t		fromSource: flow source samplesOut;
			\tend dataSource;
			
			\tthread dataSink
			\t	features
			\t		samplesIn: in event data port samples;
			\t	flows
			\t		toSink: flow sink samplesIn;
			\tend dataSink;
			
			end issue464;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue464() throws Exception {
		AadlPackage pkg = testHelper.parseString(AADL_TEXT);
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();
		assertTrue("System implementation \"SensorProssessing.impl2\" not found",
				classifiers.stream().anyMatch(classifier -> "SensorProcessing.impl2".equals(classifier.getName())));
		SystemImplementation sysImpl = (SystemImplementation) classifiers.stream()
				.filter(classifier -> "SensorProcessing.impl2".equals(classifier.getName()))
				.findFirst()
				.get();
		SystemInstance instance = InstantiateModel.instantiate(sysImpl);
		assertEquals("SensorProcessing_impl2_Instance", instance.getName());

		assertSingleProcessingFlow(instance, "datasetProcessing");
		assertSingleProcessingFlow(instance, "datasetProcessing2");
	}

	private static void assertSingleProcessingFlow(SystemInstance instance, String processName) {
		ComponentInstance process = instance.getComponentInstances()
				.stream()
				.filter(component -> processName.equals(component.getName()))
				.findFirst()
				.orElse(null);
		var flows = process.getEndToEndFlows();
		assertTrue("In " + processName + ": Expected one e2e flow but found " + flows.size(), flows.size() == 1);
		assertTrue("In " + processName + ": Expected flow processingFlow but found " + flows.get(0).getName(),
				Objects.equals(flows.get(0).getName(), "processingflow"));
	}
}
