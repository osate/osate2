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
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*
import static extension org.osate.testsupport.AssertHelper.*
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.aadl2.instantiation.InstantiateModel

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue582NestedAbstractDirection_OutToComponentTest extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue582/"
		

	@Test
	def void testAllExplicit() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.allExplicit"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 6)
		
		assertNotNull(messages.findFirst[where == instance && kind == QueuingAnalysisErrorReporter.ERROR && message == "Connection from Top_allExplicit_Instance.srcSys.s.blank_feature to Top_allExplicit_Instance.destSys.out_feature has no valid direction. Connection instance not created."])
		assertNotNull(messages.findFirst[where == instance && kind == QueuingAnalysisErrorReporter.ERROR && message == "Connection from Top_allExplicit_Instance.srcSys.s.blank_feature to Top_allExplicit_Instance.destSys.out_feature has no valid direction. Connection instance not created."])
		assertNotNull(messages.findFirst[where == instance && kind == QueuingAnalysisErrorReporter.ERROR && message == "Connection from Top_allExplicit_Instance.srcSys.s.out_feature to Top_allExplicit_Instance.destSys.out_feature has no valid direction. Connection instance not created."])
		assertNotNull(messages.findFirst[where == instance && kind == QueuingAnalysisErrorReporter.ERROR && message == "Connection from Top_allExplicit_Instance.srcSys.s.out_feature to Top_allExplicit_Instance.destSys.out_feature has no valid direction. Connection instance not created."])
		
		val srcSys = instance.componentInstances.findFirst[name == "srcSys"]
		assertNotNull(messages.findFirst[where == srcSys && kind == QueuingAnalysisErrorReporter.ERROR && message == "Connection from Top_allExplicit_Instance.srcSys.s.blank_feature to Top_allExplicit_Instance.srcSys.blank_to_in_feature has no valid direction. Connection instance not created."])
		assertNotNull(messages.findFirst[where == srcSys && kind == QueuingAnalysisErrorReporter.ERROR && message == "Connection from Top_allExplicit_Instance.srcSys.s.out_feature to Top_allExplicit_Instance.srcSys.out_to_in_feature has no valid direction. Connection instance not created."])

		assertEquals(8, instance.connectionInstances.size)
	}

	@Test
	def void test_blank_to_blank_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_blank_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_blank_to_blank_to_in() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_blank_to_in"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_blank_to_blank_to_out() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_blank_to_out"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			assertEquals("Connection from Top_blank_to_blank_to_out_Instance.srcSys.s.f0 to Top_blank_to_blank_to_out_Instance.destSys.f0 has no valid direction. Connection instance not created.", message)
		]
	}

	@Test
	def void test_blank_to_in_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_in_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			assertEquals("Connection from Top_blank_to_in_to_blank_Instance.srcSys.s.f0 to Top_blank_to_in_to_blank_Instance.srcSys.f0 has no valid direction. Connection instance not created.", message)
		]
	}

	@Test
	def void test_blank_to_in_to_in() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_in_to_in"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_blank_to_in_to_out() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_in_to_out"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			assertEquals("Connection from Top_blank_to_in_to_out_Instance.srcSys.s.f0 to Top_blank_to_in_to_out_Instance.destSys.f0 has no valid direction. Connection instance not created.", message)
		]
	}

	@Test
	def void test_blank_to_out_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_out_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_blank_to_out_to_in() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_out_to_in"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_blank_to_out_to_out() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_out_to_out"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			assertEquals("Connection from Top_blank_to_out_to_out_Instance.srcSys.s.f0 to Top_blank_to_out_to_out_Instance.destSys.f0 has no valid direction. Connection instance not created.", message)
		]
	}

	@Test
	def void test_in_to_blank_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.in_to_blank_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_in_to_blank_to_in() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.in_to_blank_to_in"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_in_to_blank_to_out() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.in_to_blank_to_out"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_in_to_in_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.in_to_in_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}
	
	@Test
	def void test_in_to_in_to_in() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.in_to_in_to_in"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_in_to_in_to_out() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.in_to_in_to_out"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_in_to_out_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.in_to_out_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_in_to_out_to_in() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.in_to_out_to_in"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_in_to_out_to_out() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.in_to_out_to_out"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_out_to_blank_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.out_to_blank_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_out_to_blank_to_in() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.out_to_blank_to_in"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_out_to_blank_to_out() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.out_to_blank_to_out"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			assertEquals("Connection from Top_out_to_blank_to_out_Instance.srcSys.s.f0 to Top_out_to_blank_to_out_Instance.destSys.f0 has no valid direction. Connection instance not created.", message)
		]
	}

	@Test
	def void test_out_to_in_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.out_to_in_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			assertEquals("Connection from Top_out_to_in_to_blank_Instance.srcSys.s.f0 to Top_out_to_in_to_blank_Instance.srcSys.f0 has no valid direction. Connection instance not created.", message)
		]
	}

	@Test
	def void test_out_to_in_to_in() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.out_to_in_to_in"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			assertEquals("Connection from Top_out_to_in_to_in_Instance.srcSys.s.f0 to Top_out_to_in_to_in_Instance.srcSys.f0 has no valid direction. Connection instance not created.", message)
		]
	}

	@Test
	def void test_out_to_in_to_out() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.out_to_in_to_out"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			assertEquals("Connection from Top_out_to_in_to_out_Instance.srcSys.s.f0 to Top_out_to_in_to_out_Instance.srcSys.f0 has no valid direction. Connection instance not created.", message)
		]
	}

	@Test
	def void test_out_to_out_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.out_to_out_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_out_to_out_to_in() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.out_to_out_to_in"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_out_to_out_to_out() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.out_to_out_to_out"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			assertEquals("Connection from Top_out_to_out_to_out_Instance.srcSys.s.f0 to Top_out_to_out_to_out_Instance.destSys.f0 has no valid direction. Connection instance not created.", message)
		]
	}




//	@Test
//	def void test_in_nt_to_in_nt() {
//		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
//		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.in_nt_to_in_nt"] as SystemImplementation
//		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
//		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
//		
//		assertNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])
//
//		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
//		assertTrue(messages.size == 1)
//		messages.get(0) => [
//			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
//			assertEquals("Connection from Top_in_nt_to_in_nt_Instance.srcSys.f0 to Top_in_nt_to_in_nt_Instance.destSys.f0 has no valid direction. Connection instance not created.", message)
//		]
//	}

}
