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

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue789Test {
	private static final String AADL_TEXT = """
			package FeatureGroupflows
			public
			\tfeature group sensoroutput
			\t\tfeatures
			\t\t\tspeedreading: out data port;
			\t\t\taltitudereading: out data port;
			\tend sensoroutput;
			\tfeature group commandinput
			\t\tfeatures
			\t\t\tspeedcmd: in data port;
			\t\t\taltitudecmd: in data port;
			\tend commandinput;
			\tabstract sensors
			\t\tfeatures
			\t\t\treadings: feature group sensoroutput;
			\t\tflows\s
			\t\t\tsensesrc: flow source readings;
			\tend sensors;
			\tabstract actuators
			\t\tfeatures
			\t\t\tcommands: feature group commandinput;
			\t\tflows\s
			\t\t\tactuatedst: flow sink commands;
			\tend actuators;
			\tabstract controllers
			\t\tfeatures
			\t\t\treadings: feature group inverse of sensoroutput;
			\t\t\tcommands: feature group inverse of commandinput;
			\t\tflows
			\t\t\tthrough: flow path readings -> commands;
			\t\t\tthroughs: flow path readings.speedreading -> commands.speedcmd;
			\t\t\tthrougha: flow path readings.altitudereading -> commands.altitudecmd;
			\tend controllers;
			\t
			\tsystem topsystem
			\t
			\tend topsystem;
			\t
			\tsystem implementation topsystem.tier1
			\t\tsubcomponents
			\t\t\tsense: abstract sensors;
			\t\t\tactuate: abstract actuators;
			\t\t\tcontrol: abstract controllers;
			\t\tconnections
			\t\t\tstoc: feature group sense.readings -> control.readings;
			\t\t\tctoa: feature group control.commands -> actuate.commands;
			\t\tflows
			\t\t\tetef1: end to end flow sense.sensesrc -> stoc -> control.through -> ctoa -> actuate.actuatedst;
			\tend topsystem.tier1;
			\t
			\tdevice speedsensor
			\t\tfeatures
			\t\t\tspeedreading: out data port;
			\t\tflows
			\t\t\tsensesrc: flow source speedreading;
			\tend speedsensor;
			\tdevice altitudesensor
			\t\tfeatures
			\t\t\taltitudereading: out data port;
			\t\tflows
			\t\t\tsensesrc: flow source altitudereading;
			\tend altitudesensor;
			\t
			\tdevice speedactuator
			\t\tfeatures
			\t\t\tspeedcmd: in data port;
			\t\tflows
			\t\t\tactuatedst: flow sink speedcmd;
			\tend speedactuator;
			\tdevice altitudeactuator
			\t\tfeatures
			\t\t\taltitudecmd: in data port;
			\t\tflows
			\t\t\tactuatedst: flow sink altitudecmd;
			\tend altitudeactuator;

			\t
			\tdevice speedcontroller
			\t\tfeatures
			\t\t\tspeedreading: in data port;
			\t\t\tspeedcmd: out data port;
			\t\tflows
			\t\t\tspeedcontrol: flow path speedreading -> speedcmd;
			\tend speedcontroller;
			\tdevice altitudecontroller
			\t\tfeatures
			\t\t\taltitudereading: in data port;
			\t\t\taltitudecmd: out data port;
			\t\tflows
			\t\t\taltcontrol: flow path altitudereading -> altitudecmd;
			\tend altitudecontroller;
			\t
			\tabstract implementation sensors.impl
			\t\tsubcomponents
			\t\t\tspeed: device speedsensor;
			\t\t\taltitude: device altitudesensor;
			\t\tconnections
			\t\t\tcs1: port speed.speedreading -> readings.speedreading;
			\t\t\tcs2: port altitude.altitudereading -> readings.altitudereading;
			\t\tflows
			\t\t\tsensesrc: flow source speed.sensesrc -> cs1 -> readings;
			\t\t\tsensesrc: flow source altitude.sensesrc -> cs2 -> readings;
			\tend sensors.impl;
			\t
			\tabstract implementation actuators.impl
			\t\tsubcomponents
			\t\t\tspeed: device speedactuator;
			\t\t\taltitude: device altitudeactuator;
			\t\tconnections
			\t\t\tcs1: port commands.speedcmd -> speed.speedcmd;
			\t\t\tcs2: port commands.altitudecmd -> altitude.altitudecmd;
			\t\tflows
			\t\t\tactuatedst: flow sink commands -> cs1 -> speed.actuatedst;
			\t\t\tactuatedst: flow sink commands -> cs2 -> altitude.actuatedst;
			\tend actuators.impl;
			\t
			\tabstract implementation controllers.impl
			\t\tsubcomponents
			\t\t\tspeed: device speedcontroller;
			\t\t\taltitude: device altitudecontroller;
			\t\tconnections
			\t\t\tcs1: port  speed.speedcmd -> commands.speedcmd ;
			\t\t\tcs2: port  altitude.altitudecmd -> commands.altitudecmd;
			\t\t\tcs3: port  readings.speedreading -> speed.speedreading ;
			\t\t\tcs4: port  readings.altitudereading -> altitude.altitudereading;
			\t\tflows
			\t\t\tthrough: flow path readings -> cs3 -> speed.speedcontrol -> cs1 -> commands;
			\t\t\tthrough: flow path readings -> cs4 -> altitude.altcontrol -> cs2 -> commands;
			\tend controllers.impl;
			\t
			\tsystem implementation topsystem.tier2 extends topsystem.tier1
			\t\tsubcomponents
			\t\t\tsense: refined to abstract sensors.impl;
			\t\t\tactuate: refined to abstract actuators.impl;
			\t\t\tcontrol: refined to abstract controllers.impl;
			\tend topsystem.tier2;
			\t
			end FeatureGroupflows;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue789() throws Exception {
		AadlPackage pkg = testHelper.parseString(AADL_TEXT);
		List<Classifier> cls = pkg.getOwnedPublicSection().getOwnedClassifiers();
		assertTrue("System implementation \"topsystem.tier2\" not found",
				cls.stream().anyMatch(classifier -> "topsystem.tier2".equals(classifier.getName())));

		// instantiate
		SystemImplementation sysImpl = (SystemImplementation) cls.stream()
				.filter(classifier -> "topsystem.tier2".equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		var instance = InstantiateModel.instantiate(sysImpl);
		assertEquals("topsystem_tier2_Instance", instance.getName());

		// check that there are two ETEI
		var eteis = instance.getEndToEndFlows();
		var names = eteis.stream().map(EndToEndFlowInstance::getName).toList();
		assertTrue("ETEF \"etef1_1\" not created", names.contains("etef1_1"));
		assertTrue("ETEF \"etef1_2\" not created", names.contains("etef1_2"));
		assertTrue("Expected two end to end flow instances but found " + eteis.size(), eteis.size() == 2);

		// instantiate
		SystemImplementation sysImpl1 = (SystemImplementation) cls.stream()
				.filter(classifier -> "topsystem.tier1".equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		var instance1 = InstantiateModel.instantiate(sysImpl1);
		assertEquals("topsystem_tier1_Instance", instance1.getName());

		// check that there are two ETEI
		var eteis1 = instance1.getEndToEndFlows();
		var names1 = eteis1.stream().map(EndToEndFlowInstance::getName).toList();
		assertTrue("ETEF \"etef1_1\" not created", names1.contains("etef1_1"));
		assertTrue("ETEF \"etef1_2\" not created", names1.contains("etef1_2"));
		assertTrue("ETEF \"etef1_3\" not created", names1.contains("etef1_3"));
		assertTrue("ETEF \"etef1_4\" not created", names1.contains("etef1_4"));
		assertTrue("Expected three end to end flow instances but found " + eteis1.size(), eteis1.size() == 4);
	}
}
