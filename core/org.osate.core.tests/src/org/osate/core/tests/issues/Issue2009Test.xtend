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
}
