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
