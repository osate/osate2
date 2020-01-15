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
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ProcessImplementation
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue794Test extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue794_1() {
		val pkg1 = '''
			package pkg1
			public
				process ps1
					features
						in1: in data port;
						in2: in data port;
						out1: out data port;
						out2: out data port;
						fg1: feature group fgt1;
						fg2: feature group fgt1;
					flows
						flow1: flow path in1 -> out1;
						flow2: flow path in1 -> out1;
						flow3: flow path fg1.fg_in1 -> fg1.fg_out1;
						flow4: flow path fg1.fg_in1 -> fg1.fg_out1;
						flow5: flow path fg1.fg_in1 -> fg1.fg_out1;
						flow6: flow path fg1 -> fg2;
						flow7: flow path fg1 -> fg2;
						flow8: flow path fg1 -> fg2;
				end ps1;
				
				process implementation ps1.i
					subcomponents
						sub1: thread t1;
					connections
						conn1: port in1 -> sub1.t_in;
						conn2: port sub1.t_out -> out1;
						conn3: port in2 -> sub1.t_in;
						conn4: port sub1.t_out -> out2;
						conn5: port fg1.fg_in1 -> sub1.t_in;
						conn6: port sub1.t_out -> fg1.fg_out1;
						conn7: port fg1.fg_in2 -> sub1.t_in;
						conn8: port sub1.t_out -> fg1.fg_out2;
						conn9: port fg2.fg_in1 -> sub1.t_in;
						conn10: port sub1.t_out -> fg2.fg_out1;
					flows
						flow1: flow path in1 -> conn1 -> sub1.t_flow -> conn2 -> out1;
						flow2: flow path in2 -> conn3 -> sub1.t_flow -> conn4 -> out2;
						flow3: flow path fg1.fg_in1 -> conn5 -> sub1.t_flow -> conn6 -> fg1.fg_out1;
						flow4: flow path fg1.fg_in2 -> conn7 -> sub1.t_flow -> conn8 -> fg1.fg_out2;
						flow5: flow path fg2.fg_in1 -> conn9 -> sub1.t_flow -> conn10 -> fg2.fg_out1;
						flow6: flow path fg1 -> conn5 -> sub1.t_flow -> conn10 -> fg2;
						flow7: flow path fg1.fg_in1 -> conn5 -> sub1.t_flow -> conn10 -> fg2.fg_out1;
						flow8: flow path fg2.fg_in1 -> conn9 -> sub1.t_flow -> conn6 -> fg1.fg_out1;
				end ps1.i;
				
				thread t1
					features
						t_in: in data port;
						t_out: out data port;
					flows
						t_flow: flow path t_in -> t_out;
				end t1;
				
				feature group fgt1
					features
						fg_in1: in data port;
						fg_in2: in data port;
						fg_out1: out data port;
						fg_out2: out data port;
				end fgt1;
			end pkg1;
		'''
		val testFileResult = issues = testHelper.testString(pkg1)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as ProcessImplementation => [
				"ps1.i".assertEquals(name)
				ownedFlowImplementations.get(1) => [
					"flow2".assertEquals(specification.name)
					assertError(testFileResult.issues, issueCollection,
						"'in2' does not match the in flow feature identifier 'in1' in the flow specification.",
						"'out2' does not match the out flow feature identifier 'out1' in the flow specification."
					)
				]
				ownedFlowImplementations.get(3) => [
					"flow4".assertEquals(specification.name)
					assertError(testFileResult.issues, issueCollection,
						"'fg1.fg_in2' does not match the in flow feature identifier 'fg1.fg_in1' in the flow specification.",
						"'fg1.fg_out2' does not match the out flow feature identifier 'fg1.fg_out1' in the flow specification."
					)
				]
				ownedFlowImplementations.get(4) => [
					"flow5".assertEquals(specification.name)
					assertError(testFileResult.issues, issueCollection,
						"'fg2.fg_in1' does not match the in flow feature identifier 'fg1.fg_in1' in the flow specification.",
						"'fg2.fg_out1' does not match the out flow feature identifier 'fg1.fg_out1' in the flow specification."
					)
				]
				ownedFlowImplementations.get(7) => [
					"flow8".assertEquals(specification.name)
					assertError(testFileResult.issues, issueCollection,
						"'fg2.fg_in1' does not match the in flow feature identifier 'fg1' in the flow specification.",
						"'fg1.fg_out1' does not match the out flow feature identifier 'fg2' in the flow specification."
					)
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
		@Test
	def void issue794_2() {
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "topsystem.tier2" not found', cls.exists[name == 'topsystem.tier2'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'topsystem.tier2'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals('topsystem_tier2_Instance', instance.name)

		// check that there are two ETEI
		val eteis = instance.endToEndFlows
		assertTrue('Expected two end to end flow instances but found ' + eteis.size, eteis.size == 2)

		// instantiate		
		val sysImpl1 = cls.findFirst[name == 'topsystem.tier1'] as SystemImplementation
		val instance1 = InstantiateModel.instantiate(sysImpl1)
		assertEquals('topsystem_tier1_Instance', instance1.name)

		// check that there are two ETEI
		val eteis1 = instance1.endToEndFlows
		assertTrue('Expected three end to end flow instances but found ' + eteis1.size, eteis1.size == 4)
	}
	
	val aadlText = '''
		package FeatureGroupflows
		public
			feature group sensoroutput
				features
					speedreading: out data port;
					altitudereading: out data port;
			end sensoroutput;
		
			feature group commandinput
				features
					speedcmd: in data port;
					altitudecmd: in data port;
			end commandinput;
		
			abstract sensors
				features
					readings: feature group sensoroutput;
				flows
					sensesrc: flow source readings;
			end sensors;
		
			abstract actuators
				features
					commands: feature group commandinput;
				flows
					actuatedst: flow sink commands;
			end actuators;
		
			abstract controllers
				features
					readings: feature group inverse of sensoroutput;
					commands: feature group inverse of commandinput;
				flows
					through: flow path readings -> commands;
					--throughs: flow path readings.speedreading -> commands.speedcmd;
					--througha: flow path readings.altitudereading -> commands.altitudecmd;
			end controllers;
		
			system topsystem
			end topsystem;
		
			system implementation topsystem.tier1
				subcomponents
					sense: abstract sensors;
					actuate: abstract actuators;
					control: abstract controllers;
				connections
					stoc: feature group sense.readings -> control.readings;
					ctoa: feature group control.commands -> actuate.commands;
				flows
					etef1: end to end flow sense.sensesrc -> stoc -> control.through -> ctoa -> actuate.actuatedst;
			end topsystem.tier1;
		
			device speedsensor
				features
					speedreading: out data port;
				flows
					sensesrc: flow source speedreading;
			end speedsensor;
		
			device altitudesensor
				features
					altitudereading: out data port;
				flows
					sensesrc: flow source altitudereading;
			end altitudesensor;
		
			device speedactuator
				features
					speedcmd: in data port;
				flows
					actuatedst: flow sink speedcmd;
			end speedactuator;
		
			device altitudeactuator
				features
					altitudecmd: in data port;
				flows
					actuatedst: flow sink altitudecmd;
			end altitudeactuator;
		
			device speedcontroller
				features
					speedreading: in data port;
					speedcmd: out data port;
				flows
					speedcontrol: flow path speedreading -> speedcmd;
			end speedcontroller;
		
			device altitudecontroller
				features
					altitudereading: in data port;
					altitudecmd: out data port;
				flows
					altcontrol: flow path altitudereading -> altitudecmd;
			end altitudecontroller;
		
			abstract implementation sensors.impl
				subcomponents
					speed: device speedsensor;
					altitude: device altitudesensor;
				connections
					cs1: port speed.speedreading -> readings.speedreading;
					cs2: port altitude.altitudereading -> readings.altitudereading;
				flows
					sensesrc: flow source speed.sensesrc -> cs1 -> readings;
					sensesrc: flow source altitude.sensesrc -> cs2 -> readings;
			end sensors.impl;
		
			abstract implementation actuators.impl
				subcomponents
					speed: device speedactuator;
					altitude: device altitudeactuator;
				connections
					cs1: port commands.speedcmd -> speed.speedcmd;
					cs2: port commands.altitudecmd -> altitude.altitudecmd;
				flows
					actuatedst: flow sink commands -> cs1 -> speed.actuatedst;
					actuatedst: flow sink commands -> cs2 -> altitude.actuatedst;
			end actuators.impl;
		
			abstract implementation controllers.impl
				flows
						-- these flow path implementations map each incoming feature to one outgoing feature.
						-- This outgoing feature determines how the ETEF continues (instead of one-to-all).
					through: flow path readings.speedreading -> commands.speedcmd;
					through: flow path readings.altitudereading -> commands.altitudecmd;
			end controllers.impl;
		
			system implementation topsystem.tier2 extends topsystem.tier1
				subcomponents
					sense: refined to abstract sensors.impl;
					actuate: refined to abstract actuators.impl;
					control: refined to abstract controllers.impl;
			end topsystem.tier2;
		end FeatureGroupflows;		
	'''

}