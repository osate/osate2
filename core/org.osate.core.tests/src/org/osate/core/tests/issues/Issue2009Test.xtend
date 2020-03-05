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
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.aadl2.instantiation.InstantiateModel
import static extension org.junit.Assert.*
import com.itemis.xtext.testing.XtextTest
import org.osate.aadl2.ProcessImplementation
import org.osate.aadl2.SystemImplementation

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2009Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue2009/"

	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void wasGood() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "WasGood.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "top.specific"] as ProcessImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// There should be 1 error
		assertTrue(messages.size == 1)
		messages.get(0) => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Cannot create end to end flow 'e2e' because there are no semantic connections that connect to the start of the flow 'fpath' at feature 'i'", message)			
		]
		
		// There should be no end to end flow instance
		assertEquals(0, instance.endToEndFlows.size)
	}

	@Test
	def void wasBad() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "WasBad.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "top.specific"] as ProcessImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// There should be 1 error
		assertTrue(messages.size == 1)
		messages.get(0) => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Cannot create end to end flow 'e2e' because there are no semantic connections that connect to the start of the flow 'fpath' at feature 'i'", message)			
		]
		
		// There should be no end to end flow instance
		assertEquals(0, instance.endToEndFlows.size)
	}
	
	@Test
	def void typeOnly() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "test.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "top.typeOnly"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// There should be 1 error
		assertTrue(messages.size == 1)
		messages.get(0) => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Cannot create end to end flow 'etef1_wrong' because there are no semantic connections that connect to the start of the flow 'snk' at feature 'i'", message)			
		]
		
		// There should be one end to end flow instance
		assertEquals(1, instance.endToEndFlows.size)
		assertEquals("etef1", instance.endToEndFlows.get(0).name)
	}	
	
	@Test
	def void withImpl_implFlow() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "test.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "top.withImpl_implFlow"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// There should be no errors
		assertTrue(messages.size == 0)
		
		// There should be one end to end flow instance
		assertEquals(1, instance.endToEndFlows.size)
		assertEquals("etef1", instance.endToEndFlows.get(0).name)
	}	
	
	@Test
	def void withImpl_implNoFlow() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "test.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "top.withImpl_implNoFlow"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// There should be 1 error and 2 warnings
		assertTrue(messages.size == 3)
		
		// There should be one end to end flow instance
		assertEquals(1, instance.endToEndFlows.size)
		assertEquals("etef1", instance.endToEndFlows.get(0).name)
	}	
	
	@Test
	def void fgTypeOnly() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "test_fg.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "top.typeOnly"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// There should be 2 errors
		assertTrue(messages.size == 2)
		messages.get(0) => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Cannot create end to end flow 'etef1F_wrong' because there are no semantic connections that connect to the start of the flow 'snkF' at feature 'i'", message)			
		]
		messages.get(1) => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Cannot create end to end flow 'etef1_wrong' because there are no semantic connections that connect to the start of the flow 'snk' at feature 'fg'", message)			
		]
		
		// There should be 2 end to end flow instances
		assertEquals(2, instance.endToEndFlows.size)
		assertEquals("etef1F", instance.endToEndFlows.get(0).name)
		assertEquals("etef1", instance.endToEndFlows.get(1).name)
	}	
	
	@Test
	def void fg2TypeOnly() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "test_fg2.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "top.typeOnly"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// There should be 3 errors
		assertTrue(messages.size == 3)
		messages.get(0) => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Cannot create end to end flow 'etef1F_wrong1' because there are no semantic connections that connect to the start of the flow 'snkF' at feature 'i'", message)			
		]
		messages.get(1) => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Cannot create end to end flow 'etef1F_wrong2' because there are no semantic connections that connect to the start of the flow 'snkF' at feature 'i'", message)			
		]
		messages.get(2) => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Cannot create end to end flow 'etef1_wrong2' because there are no semantic connections that connect to the start of the flow 'snk' at feature 'fg'", message)			
		]
		
		// There should be 3 end to end flow instances
		assertEquals(3, instance.endToEndFlows.size)
		assertEquals("etef1F", instance.endToEndFlows.get(0).name)
		assertEquals("etef1", instance.endToEndFlows.get(1).name)
		assertEquals("etef1_wrong1", instance.endToEndFlows.get(2).name)
	}	
	
	@Test
	def void fgWithImpl_implFlow() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "test_fg.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "top.withImpl_implFlow"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// There should be no errors
		assertTrue(messages.size == 0)
		
		// There should be 2 end to end flow instances
		assertEquals(2, instance.endToEndFlows.size)
		assertEquals("etef1F", instance.endToEndFlows.get(0).name)
		assertEquals("etef1", instance.endToEndFlows.get(1).name)
	}	
	
	@Test
	def void fg2WithImpl_implFlow() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "test_fg2.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "top.withImpl_implFlow"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// There should be no errors
		assertTrue(messages.size == 0)
		
		// There should be 4 end to end flow instances
		assertEquals(4, instance.endToEndFlows.size)
		assertEquals("etef1F", instance.endToEndFlows.get(0).name)
		assertEquals("etef1", instance.endToEndFlows.get(1).name)
		assertEquals("etef1F_wrong1", instance.endToEndFlows.get(2).name)
		assertEquals("etef1_wrong1", instance.endToEndFlows.get(3).name)
	}	
	
	@Test
	def void fgWithImpl_implNoFlow() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "test_fg.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "top.typeOnly"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// There should be 2 errors
		assertTrue(messages.size == 2)
		messages.get(0) => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Cannot create end to end flow 'etef1F_wrong' because there are no semantic connections that connect to the start of the flow 'snkF' at feature 'i'", message)			
		]
		messages.get(1) => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Cannot create end to end flow 'etef1_wrong' because there are no semantic connections that connect to the start of the flow 'snk' at feature 'fg'", message)			
		]
		
		// There should be 2 end to end flow instances
		assertEquals(2, instance.endToEndFlows.size)
		assertEquals("etef1F", instance.endToEndFlows.get(0).name)
		assertEquals("etef1", instance.endToEndFlows.get(1).name)
	}	
	
	@Test
	def void fg2WithImpl_implNoFlow() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "test_fg2.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "top.typeOnly"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// There should be 3 errors
		assertTrue(messages.size == 3)
		messages.get(0) => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Cannot create end to end flow 'etef1F_wrong1' because there are no semantic connections that connect to the start of the flow 'snkF' at feature 'i'", message)			
		]
		messages.get(1) => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Cannot create end to end flow 'etef1F_wrong2' because there are no semantic connections that connect to the start of the flow 'snkF' at feature 'i'", message)			
		]
		messages.get(2) => [
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Cannot create end to end flow 'etef1_wrong2' because there are no semantic connections that connect to the start of the flow 'snk' at feature 'fg'", message)			
		]
		
		// There should be 3 end to end flow instances
		assertEquals(3, instance.endToEndFlows.size)
		assertEquals("etef1F", instance.endToEndFlows.get(0).name)
		assertEquals("etef1", instance.endToEndFlows.get(1).name)
		assertEquals("etef1_wrong1", instance.endToEndFlows.get(2).name)
	}	
}
