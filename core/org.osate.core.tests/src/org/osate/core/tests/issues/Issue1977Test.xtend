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
class Issue1977Test {
	val static FILE = "org.osate.core.tests/models/issue1977/Issue1977.aadl"

	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testInstantiation() {
		val pkg = testHelper.parseFile(FILE)
		val impl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == 's.i'] as ComponentImplementation
		
		val instance = InstantiateModel.instantiate(impl)
		assertEquals('s_i_Instance', instance.name)
		
		val conns = instance.connectionInstances 
		assertTrue(conns.size == 4)
		assertTrue(conns.findFirst[name == 'a1.da -> d1'] !== null)
		assertTrue(conns.findFirst[name == 'a2.da -> d2'] !== null)
		assertTrue(conns.findFirst[name == 'd1 -> a1.da'] !== null)
		assertTrue(conns.findFirst[name == 'd2 -> a2.da'] !== null)
	}

}
