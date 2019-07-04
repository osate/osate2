package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.FlowSpecificationInstance

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1815Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue1815/"
	val static NO_FLOW_PROPS = "NoFlowProps.aadl"
	
	val static TOP_IMPL = "Top.impl"
	val static SYSTEM_NAME = "Top_impl_Instance"
	
	val static FS = "fs"
	val static FS1 = "fs1"
	
	val static A1 = "a1"
	val static M1 = "m1"
	
	val static LATENCY = "Latency"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testSubcomponents1() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + NO_FLOW_PROPS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOP_IMPL] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(SYSTEM_NAME, instance.name)

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(0, messages.size)
		
		// find subcomponent a1
		val a1 = instance.componentInstances.findFirst[name == A1] as ComponentInstance
		checkPropertiesOfFlowSpecs(a1)
		
		// find subcomponent m1
		val m1 = instance.componentInstances.findFirst[name == M1] as ComponentInstance
		checkPropertiesOfFlowSpecs(m1)
		
		/* Check the system instance itself.  This is where the error was that we fixed.  The property
		 * association was missing from the flow spec instance 'fs' on the system instance.
		 */
		 checkPropertiesOfFlowSpecs(instance)

	}
	
	private def void checkPropertiesOfFlowSpecs(ComponentInstance ci) {
		checkForPropertyAssociation(ci, FS)
		checkForPropertyAssociation(ci, FS1)
	}
	
	/*
	 * Check that the given component instance has a flow spec with the given name, and that flow spec 
	 * has a LATENCY property association.
	 */
	private def void checkForPropertyAssociation(ComponentInstance ci, String flowSpecName) {
		val fs = ci.flowSpecifications.findFirst[name == flowSpecName] as FlowSpecificationInstance
		
		val propAssocs = fs.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		
		val pa = propAssocs.get(0)
		assertEquals(LATENCY, pa.property.name)
	}
}

