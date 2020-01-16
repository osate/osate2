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
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*
import org.osate.aadl2.ProcessImplementation
import org.osate.aadl2.Connection

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2057Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue2057/"

	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void testPortToPort() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "port_to_port.aadl")
		val system = getSystemInstance(pkg, "top.impl", "top_impl_Instance")
		val conns = system.componentInstances.get(0).connectionInstances
		assertEquals(16, conns.size)

		// Get the declarative connection
		val declarativeConnection = (pkg.publicSection.ownedClassifiers.findFirst[name == "process1.impl"] as ProcessImplementation).ownedConnections.findFirst[name == "xxx"] as Connection
		
		// Test all the connection instances
		for (var i = 0; i < conns.size; i++) {
			val connRef = conns.get(i).connectionReferences
			assertEquals(1, connRef.size)
			assertEquals(declarativeConnection, connRef.get(0).connection)
		}
	}

	@Test
	def void testDataToDataPort() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "data_to_data_port.aadl")
		val system = getSystemInstance(pkg, "top.impl", "top_impl_Instance")
		val conns = system.componentInstances.get(0).connectionInstances
		assertEquals(16, conns.size)

		// Get the declarative connection
		val declarativeConnection = (pkg.publicSection.ownedClassifiers.findFirst[name == "process1.impl"] as ProcessImplementation).ownedConnections.findFirst[name == "yyy"] as Connection
		
		// Test all the connection instances
		for (var i = 0; i < conns.size; i++) {
			val connRef = conns.get(i).connectionReferences
			assertEquals(1, connRef.size)
			assertEquals(declarativeConnection, connRef.get(0).connection)
		}
	}

	@Test
	def void testDataToAccess() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "data_to_access.aadl")
		val system = getSystemInstance(pkg, "top.impl", "top_impl_Instance")
		val conns = system.componentInstances.get(0).connectionInstances
		assertEquals(16, conns.size)

		// Get the declarative connection
		val declarativeConnection = (pkg.publicSection.ownedClassifiers.findFirst[name == "process1.impl"] as ProcessImplementation).ownedConnections.findFirst[name == "ccc"] as Connection
		
		// Test all the connection instances
		for (var i = 0; i < conns.size; i++) {
			val connRef = conns.get(i).connectionReferences
			assertEquals(1, connRef.size)
			assertEquals(declarativeConnection, connRef.get(0).connection)
		}
	}

	@Test
	def void testDataPortToData() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "data_port_to_data.aadl")
		val system = getSystemInstance(pkg, "top.impl", "top_impl_Instance")
		val conns = system.componentInstances.get(0).connectionInstances
		assertEquals(16, conns.size)

		// Get the declarative connection
		val declarativeConnection = (pkg.publicSection.ownedClassifiers.findFirst[name == "process1.impl"] as ProcessImplementation).ownedConnections.findFirst[name == "yyy"] as Connection
		
		// Test all the connection instances
		for (var i = 0; i < conns.size; i++) {
			val connRef = conns.get(i).connectionReferences
			assertEquals(1, connRef.size)
			assertEquals(declarativeConnection, connRef.get(0).connection)
		}
	}

	@Test
	def void testAccessToData() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "access_to_data.aadl")
		val system = getSystemInstance(pkg, "top.impl", "top_impl_Instance")
		val conns = system.componentInstances.get(0).connectionInstances
		assertEquals(16, conns.size)

		// Get the declarative connection
		val declarativeConnection = (pkg.publicSection.ownedClassifiers.findFirst[name == "process1.impl"] as ProcessImplementation).ownedConnections.findFirst[name == "ccc"] as Connection
		
		// Test all the connection instances
		for (var i = 0; i < conns.size; i++) {
			val connRef = conns.get(i).connectionReferences
			assertEquals(1, connRef.size)
			assertEquals(declarativeConnection, connRef.get(0).connection)
		}
	}

	private def static SystemInstance getSystemInstance(AadlPackage pkg, String systemImplName,
		String expectedInstanceName) {
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "' + systemImplName + '" not found', cls.exists[name == systemImplName])

		// Instantiate system
		val sysImpl = cls.findFirst[name == systemImplName] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(expectedInstanceName, instance.name)
		instance
	}
}
