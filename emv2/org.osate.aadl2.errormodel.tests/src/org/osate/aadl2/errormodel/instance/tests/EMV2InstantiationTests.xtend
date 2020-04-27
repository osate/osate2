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
package org.osate.aadl2.errormodel.instance.tests

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.TestHelper
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(ErrorModelInjectorProvider)
class EMV2InstantiationTests {

	@Inject
	TestHelper<AadlPackage> testHelper

	var primaryroot = null

	var static SystemInstance GPSBasicInstance


	val modelroot = "org.osate.aadl2.errormodel.tests/models/instantiation/"
	val GPSErrorLibraryFile = "GPSErrorLibrary.aadl"
	val GPSPartsFile = "GPSParts.aadl"
	val GPSSystemFile = "GPSSystem.aadl"
	val HardwarePartsFile = "HardwareParts.aadl"

	@Before
	def void initWorkspace() {
		primaryroot = testHelper.parseFile(
			modelroot + GPSErrorLibraryFile,
			modelroot + HardwarePartsFile,
			modelroot + GPSPartsFile,
			modelroot + GPSSystemFile
		)
		GPSBasicInstance = instanceGenerator(modelroot + GPSSystemFile, "GPS.basic")
	}

	def SystemInstance instanceGenerator(String filename, String rootclassifier) {
		val ac = primaryroot as AadlPackage
		val rs = ac.eResource.resourceSet
		val targetsrc = rs.getResource(URI.createURI(filename), true)

		// get the correct package
		val pkg = targetsrc.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == rootclassifier])
		// instantiate
		val sysImpl = cls.findFirst[name == rootclassifier] as ComponentImplementation
		return InstantiateModel::instantiate(sysImpl)
	}

	/**
	 * example of simple composite error state with an AND operator.
	 * The subcomponents have two states and a transition triggered by an error event.
	 * The error event is a Basic Event.
	 */
	@Test
	def void testGPSBasic() {
		val system = GPSBasicInstance
		val GPSEMV2 = system.annexInstances.get(0) as EMV2AnnexInstance
		GPSEMV2 => [
			assertTrue(3 == errorFlows.size() )
			assertTrue(9 == propagationPaths.size() )
			assertTrue(1 == errorPropagationConditions.size() )
			assertTrue(null !== stateMachine )
			assertTrue(1 == transitions.size())
		]
		val sensor1 = findComponent(system,"SatelliteSignalReceiver1")
		val sensor1EMV2 = sensor1.annexInstances.get(0) as EMV2AnnexInstance
		sensor1EMV2 => [
			assertTrue(1 == errorFlows.size() )
			assertTrue(4 == (inPropagations+outPropagations).size() )
			assertTrue(null !== stateMachine )
			assertTrue(1 == transitions.size())
			assertTrue(1 == events.size() )
			val eventInstance = events.get(0)
			assertTrue(eventInstance.ownedPropertyAssociations.size == 1)
		]
	}
	
	def ComponentInstance findComponent(ComponentInstance parent,String name){
		for (subci: parent.componentInstances){
			if (subci.name.equalsIgnoreCase(name)){
				return subci
			}
		}
		return null
	}
	
}
