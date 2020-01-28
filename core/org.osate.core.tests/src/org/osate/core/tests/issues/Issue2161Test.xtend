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
import org.eclipse.emf.common.util.EList
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.Classifier
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*
import org.osate.aadl2.instance.ConnectionReference
import java.util.List
import org.osate.aadl2.instance.ComponentInstance

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2161Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue2161/"
	
	val static ROOT_IMPL = "root.impl"
	
	val static ROOT_BIDIRECTIONAL = "Root.bidirectional"
	val static ROOT_FROM_SHARED = "Root.fromSharedComponent"
	val static ROOT_TO_SHARED = "Root.toSharedComponent"
		
	val static ROOT_BIDIRECTIONAL_INSTANCE = "Root_bidirectional_Instance"
	val static ROOT_FROM_SHARED_INSTANCE = "Root_fromSharedComponent_Instance"
	val static ROOT_TO_SHARED_INSTANCE = "Root_toSharedComponent_Instance"
		
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void testIssue222() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "test2.aadl")

		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "' + ROOT_IMPL + '" not found', cls.exists[name == ROOT_IMPL])

		val sysImpl = cls.findFirst[name == ROOT_IMPL] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		
		// There should be no connection instances
		assertEquals(0, instance.connectionInstances.size)
	}

	@Test
	def void testSharedData_toData_asPeers() {
		testAsPeers("SharedData_to_Data_Peers.aadl")
	}

	@Test
	def void testSharedData_toSubprogram_asPeers() {
		testAsPeers("SharedData_to_Subprogram_Peers.aadl")
	}

	@Test
	def void testSharedSubprogram_toData_asPeers() {
		testAsPeers("SharedSubprogram_to_Data_Peers.aadl")
	}

	@Test
	def void testSharedSubprogram_toSubprogram_asPeers() {
		testAsPeers("SharedSubprogram_to_Subprogram_Peers.aadl")
	}

	def void testAsPeers(String aadlFile) {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + aadlFile)

		val cls = pkg.ownedPublicSection.ownedClassifiers
		intantiateBidirectionalPeers(cls)
		val connRefs1 = instantiateFromSharedPeers(cls)
		val connRefs2 = instantiateToSharedPeers(cls)
		
		// The two connection instances from "to shared" and "from shared" should follow opposite paths
		assertEquals(connRefs1.get(0).connection.name, connRefs2.get(0).connection.name)
	}
	
	protected def void intantiateBidirectionalPeers(EList<Classifier> cls) {
		val sysImpl = cls.findFirst[name == ROOT_BIDIRECTIONAL] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(ROOT_BIDIRECTIONAL_INSTANCE, instance.name)
		
		// There should be exactly 2 connection instances
		assertEquals(2, instance.connectionInstances.size)
		
		val ci1 = instance.connectionInstances.get(0)
		val ci2 = instance.connectionInstances.get(1)
		
		// Each connection instance should have 1 connection reference
		val connRefs1 = ci1.connectionReferences
		val connRefs2 = ci2.connectionReferences
		assertEquals(1, connRefs1.size)
		assertEquals(1, connRefs2.size)
		
		// The two connection instances should follow opposite paths
		assertEquals(connRefs1.get(0).connection, connRefs2.get(0).connection)
	}
	
	protected def List<ConnectionReference> instantiateFromSharedPeers(EList<Classifier> cls) {
		val sysImpl = cls.findFirst[name == ROOT_FROM_SHARED] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(ROOT_FROM_SHARED_INSTANCE, instance.name)
		
		// There should be exactly 1 connection instances
		assertEquals(1, instance.connectionInstances.size)
		
		val ci = instance.connectionInstances.get(0)
		
		// Each connection instance should have 1 connection reference
		val connRefs = ci.connectionReferences
		assertEquals(1, connRefs.size)
		
		return connRefs
	}
	
	protected def List<ConnectionReference> instantiateToSharedPeers(EList<Classifier> cls) {
		val sysImpl = cls.findFirst[name == ROOT_TO_SHARED] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(ROOT_TO_SHARED_INSTANCE, instance.name)
		
		// There should be exactly 1 connection instances
		assertEquals(1, instance.connectionInstances.size)
		
		val ci = instance.connectionInstances.get(0)
		
		// Each connection instance should have 1 connection reference
		val connRefs = ci.connectionReferences
		assertEquals(1, connRefs.size)

		return connRefs
	}


	@Test
	def void testSharedData_toData_inData() {
		testInData("SharedData_to_Data_Nested_in_Data.aadl")
	}

	@Test
	def void testSharedData_toSubprogram_inData() {
		testInData("SharedData_to_Subprogram_Nested_in_Data.aadl")
	}

	@Test
	def void testSharedSubprogram_toData_inData() {
		testInData("SharedSubprogram_to_Data_Nested_in_Data.aadl")
	}

	@Test
	def void testSharedSubprogram_toSubprogram_inData() {
		testInData("SharedSubprogram_to_Subprogram_Nested_in_Data.aadl")
	}

	def void testInData(String aadlFile) {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + aadlFile)

		val cls = pkg.ownedPublicSection.ownedClassifiers
		intantiateBidirectionalInData(cls)
		val connRefs1 = instantiateFromSharedInData(cls)
		val connRefs2 = instantiateToSharedInData(cls)
		
		// The connection instances from "to shared" and "from shared" should follow opposite paths
		assertEquals(connRefs1.get(0).connection.name, connRefs2.get(1).connection.name)
		assertEquals(connRefs1.get(1).connection.name, connRefs2.get(0).connection.name)
	}
	
	protected def void intantiateBidirectionalInData(EList<Classifier> cls) {
		val sysImpl = cls.findFirst[name == ROOT_BIDIRECTIONAL] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(ROOT_BIDIRECTIONAL_INSTANCE, instance.name)
		
		// There should be exactly 2 connection instances
		assertEquals(2, instance.connectionInstances.size)
		
		val ci1 = instance.connectionInstances.get(0)
		val ci2 = instance.connectionInstances.get(1)
		
		// Each connection instance should have 2 connection reference
		val connRefs1 = ci1.connectionReferences
		val connRefs2 = ci2.connectionReferences
		assertEquals(2, connRefs1.size)
		assertEquals(2, connRefs2.size)
		
		// The two connection instances should follow opposite paths
		assertEquals(connRefs1.get(0).connection, connRefs2.get(1).connection)
		assertEquals(connRefs1.get(1).connection, connRefs2.get(0).connection)
	}
	
	protected def List<ConnectionReference> instantiateFromSharedInData(EList<Classifier> cls) {
		val sysImpl = cls.findFirst[name == ROOT_FROM_SHARED] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(ROOT_FROM_SHARED_INSTANCE, instance.name)
		
		// There should be exactly 1 connection instances
		assertEquals(1, instance.connectionInstances.size)
		
		val ci = instance.connectionInstances.get(0)
		
		// Each connection instance should have 2 connection reference
		val connRefs = ci.connectionReferences
		assertEquals(2, connRefs.size)
		
		return connRefs
	}
	
	protected def List<ConnectionReference> instantiateToSharedInData(EList<Classifier> cls) {
		val sysImpl = cls.findFirst[name == ROOT_TO_SHARED] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(ROOT_TO_SHARED_INSTANCE, instance.name)
		
		// There should be exactly 1 connection instances
		assertEquals(1, instance.connectionInstances.size)
		
		val ci = instance.connectionInstances.get(0)
		
		// Each connection instance should have 1 connection reference
		val connRefs = ci.connectionReferences
		assertEquals(2, connRefs.size)
		
		return connRefs
	}


	@Test
	def void testSharedData_toData_inThread() {
		testInThread("SharedData_to_Data_Nested_in_Thread.aadl")
	}

	@Test
	def void testSharedData_toSubprogram_inThread() {
		testInThread("SharedData_to_Subprogram_Nested_in_Thread.aadl")
	}

	@Test
	def void testSharedSubprogram_toData_inThread() {
		testInThread("SharedSubprogram_to_Data_Nested_in_Thread.aadl")
	}

	@Test
	def void testSharedSubprogram_toSubprogram_inThread() {
		testInThread("SharedSubprogram_to_Subprogram_Nested_in_Thread.aadl")
	}

	def void testInThread(String aadlFile) {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + aadlFile)

		val cls = pkg.ownedPublicSection.ownedClassifiers
		intantiateBidirectionalInThread(cls)
		val connRefs1 = instantiateFromSharedInThread(cls)
		val connRefs2 = instantiateToSharedInThread(cls)
		
		// The connection instances from "to shared" and "from shared" should follow opposite paths
		assertEquals(connRefs1.get(0).connection.name, connRefs2.get(1).connection.name)
		assertEquals(connRefs1.get(1).connection.name, connRefs2.get(0).connection.name)
	}
	
	protected def void intantiateBidirectionalInThread(EList<Classifier> cls) {
		val sysImpl = cls.findFirst[name == ROOT_BIDIRECTIONAL] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(ROOT_BIDIRECTIONAL_INSTANCE, instance.name)
		val process = instance.componentInstances.get(0) as ComponentInstance
		
		// There should be exactly 2 connection instances
		assertEquals(2, process.connectionInstances.size)
		
		val ci1 = process.connectionInstances.get(0)
		val ci2 = process.connectionInstances.get(1)
		
		// Each connection instance should have 2 connection reference
		val connRefs1 = ci1.connectionReferences
		val connRefs2 = ci2.connectionReferences
		assertEquals(2, connRefs1.size)
		assertEquals(2, connRefs2.size)
		
		// The two connection instances should follow opposite paths
		assertEquals(connRefs1.get(0).connection, connRefs2.get(1).connection)
		assertEquals(connRefs1.get(1).connection, connRefs2.get(0).connection)
	}
	
	protected def List<ConnectionReference> instantiateFromSharedInThread(EList<Classifier> cls) {
		val sysImpl = cls.findFirst[name == ROOT_FROM_SHARED] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(ROOT_FROM_SHARED_INSTANCE, instance.name)
		val process = instance.componentInstances.get(0) as ComponentInstance
		
		// There should be exactly 1 connection instances
		assertEquals(1, process.connectionInstances.size)
		
		val ci = process.connectionInstances.get(0)
		
		// Each connection instance should have 2 connection reference
		val connRefs = ci.connectionReferences
		assertEquals(2, connRefs.size)
		
		return connRefs
	}
	
	protected def List<ConnectionReference> instantiateToSharedInThread(EList<Classifier> cls) {
		val sysImpl = cls.findFirst[name == ROOT_TO_SHARED] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(ROOT_TO_SHARED_INSTANCE, instance.name)
		val process = instance.componentInstances.get(0) as ComponentInstance
		
		// There should be exactly 1 connection instances
		assertEquals(1, process.connectionInstances.size)
		
		val ci = process.connectionInstances.get(0)
		
		// Each connection instance should have 1 connection reference
		val connRefs = ci.connectionReferences
		assertEquals(2, connRefs.size)
		
		return connRefs
	}
}
