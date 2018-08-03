package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue766Test {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue766() {
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('Abstract implementation "a.impl" not found', cls.exists[name == 'a.impl'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'a.impl'] as AbstractImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals('a_impl_Instance', instance.name)

		// check if there is 1 connection
		val connections = instance.connectionInstances
		assertTrue('In a_impl_instance: Expected 1 connection but found ' + connections.size, connections.size == 1)
	}

	val aadlText = '''
		package issue766
		public
			abstract a
				features
					io1: in out data port;
			end a;
		
			abstract implementation a.impl
				subcomponents
					sc1: abstract a;
					sc2: abstract a;
				connections
					io_to_io: port sc1.io1 -> sc2.io1;
			end a.impl;
		end issue766;
	'''
}
