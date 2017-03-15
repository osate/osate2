package org.osate.core.tests.issues

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class Issue789Test extends OsateTest {
	override getProjectName() {
		"issue789"
	}

	@Test
	def void issue789() {
		val aadlFile = "myflows.aadl"
		createFiles(aadlFile -> aadlText)
		suppressSerialization
		val result = testFile(aadlFile)

		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "topsystem.tier2" not found', cls.exists[name == 'topsystem.tier2'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'topsystem.tier2'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		assertEquals('topsystem_tier2_Instance', instance.name)

		// check that there are two ETEI
		val eteis = instance.endToEndFlows
		val names = eteis.map[name]
		assertTrue('ETEF "etef1_1" not created', names.contains('etef1_1'))
		assertTrue('ETEF "etef1_2" not created', names.contains('etef1_2'))
		assertTrue('Expected two end to end flow instances but found ' + eteis.size, eteis.size == 2)
		// instantiate
		
		val sysImpl1 = cls.findFirst[name == 'topsystem.tier1'] as SystemImplementation
		val instance1 = InstantiateModel::buildInstanceModelFile(sysImpl1)
		assertEquals('topsystem_tier1_Instance', instance1.name)

		// check that there are two ETEI
		val eteis1 = instance1.endToEndFlows
		val names1 = eteis1.map[name]
		assertTrue('ETEF "etef1_1" not created', names1.contains('etef1_1'))
		assertTrue('ETEF "etef1_2" not created', names1.contains('etef1_2'))
		assertTrue('ETEF "etef1_3" not created', names1.contains('etef1_3'))
		assertTrue('ETEF "etef1_4" not created', names1.contains('etef1_4'))
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
					throughs: flow path readings.speedreading -> commands.speedcmd;
					througha: flow path readings.altitudereading -> commands.altitudecmd;
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
				subcomponents
					speed: device speedcontroller;
					altitude: device altitudecontroller;
				connections
					cs1: port  speed.speedcmd -> commands.speedcmd ;
					cs2: port  altitude.altitudecmd -> commands.altitudecmd;
					cs3: port  readings.speedreading -> speed.speedreading ;
					cs4: port  readings.altitudereading -> altitude.altitudereading;
				flows
					through: flow path readings -> cs3 -> speed.speedcontrol -> cs1 -> commands;
					through: flow path readings -> cs4 -> altitude.altcontrol -> cs2 -> commands;
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
