package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue109Test {
	val static FILE = "org.osate.core.tests/models/issue109/issue109.aadl"

	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testInstantiation() {
		val pkg = testHelper.parseFile(FILE)
		val impl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == 'T.i'] as ComponentImplementation
		
		val instance = InstantiateModel.instantiate(impl)
		assertEquals('T_i_Instance', instance.name)
		
		val mt1 = instance.modeTransitionInstances.get(0)
		val compB = instance.componentInstances.findFirst[name == 'b']
		val mt2 = compB.modeTransitionInstances.get(0)
		val mt3 = compB.modeTransitionInstances.get(1)

		assertTrue(mt1.triggers.size == 1)
		assertTrue(mt1.triggers.get(0) == compB.featureInstances.findFirst[name == 'e'])
		
		assertTrue(mt2.triggers.size == 1)
		assertTrue(mt2.triggers.get(0) == compB.featureInstances.findFirst[name == 'e'])
		
		assertTrue(mt3.triggers.size == 1)
		assertTrue(mt3.triggers.get(0) == compB.featureInstances.findFirst[name == 'fg'].featureInstances.findFirst[name =='f'])
	}
}
