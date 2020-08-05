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
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2356InstanceTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue2356/"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void noModes_good() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "P2.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "S.no_modes_good"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(0, messages.size)
	}
	
	@Test
	def void noModes_bad() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "P2.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "S.no_modes_bad"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(3, messages.size)
		
		messages.findFirst[where == instance.componentInstances.get(2).featureInstances.get(0)] => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("More than one connection instance ends at data port", message)
		]
		
		messages.findFirst[where == instance.connectionInstances.get(0)] => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("More than one connection instance ends at data port S_no_modes_bad_Instance.b.bin", message)
		]
		
		messages.findFirst[where == instance.connectionInstances.get(1)] => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("More than one connection instance ends at data port S_no_modes_bad_Instance.b.bin", message)
		]
	}		
	
	@Test
	def void simple_modes_bad() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "P2.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "SS.simple_modes_bad"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(3, instance.systemOperationModes.size)
		
		
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(3, messages.size)
		
		messages.findFirst[where == instance.componentInstances.get(2).featureInstances.get(0)] => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("More than one connection instance ends at data port in system operation mode som_2", message)
		]
		
		messages.findFirst[where == instance.connectionInstances.get(0)] => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("More than one connection instance ends at data port SS_simple_modes_bad_Instance.b.bin in system operation mode som_2", message)
		]
		
		messages.findFirst[where == instance.connectionInstances.get(1)] => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("More than one connection instance ends at data port SS_simple_modes_bad_Instance.b.bin in system operation mode som_2", message)
		]
	}		

	
	@Test
	def void modal_subcomponent_bad() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "P3.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "S.i"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(3, instance.systemOperationModes.size)
		
		
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(3, messages.size)
		
		messages.findFirst[where == instance.componentInstances.get(0).featureInstances.get(0)] => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("More than one connection instance ends at data port in system operation mode som_2", message)
		]
		
		messages.findFirst[where == instance.connectionInstances.get(0)] => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("More than one connection instance ends at data port S_i_Instance.b.bin in system operation mode som_2", message)
		]
		
		messages.findFirst[where == instance.connectionInstances.get(1)] => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("More than one connection instance ends at data port S_i_Instance.b.bin in system operation mode som_2", message)
		]
	}	
	
			
	@Test
	def void connections_in_different_components_bad() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "P4.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "S.i"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)		
		
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(3, messages.size)
		
		messages.findFirst[where == instance.componentInstances.get(1).componentInstances.get(1).featureInstances.get(0)] => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("More than one connection instance ends at data port", message)
		]
		
		messages.findFirst[where == instance.connectionInstances.get(0)] => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("More than one connection instance ends at data port S_i_Instance.m.b.bin", message)
		]
		
		messages.findFirst[where == instance.componentInstances.get(1).connectionInstances.get(0)] => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("More than one connection instance ends at data port S_i_Instance.m.b.bin", message)
		]
	}	
		
}
