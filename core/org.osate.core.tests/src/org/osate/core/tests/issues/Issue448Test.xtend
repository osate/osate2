package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue448Test extends XtextTest {
	
	@Inject
	TestHelper testHelper;
	
	@Test
	def void issue448() {
		val pkg = testHelper.parseString(aadlText) as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "test_sys.impl2" not found', cls.exists[name == 'test_sys.impl2'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'test_sys.impl2'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl, pkg.eResource.resourceSet)
		assertEquals('test_sys_impl2_Instance', instance.name)

		// check if there are 5 connections in test_sys
		val connections = instance.connectionInstances
		assertTrue('In test_sys_impl2_Instance: Expected 5 connections but found ' + connections.size, connections.size == 5)
	}

	val aadlText = '''
		package issue448
		public
			system test_sys
			end test_sys;

			system implementation test_sys.impl
				subcomponents
					sc1: system example;
					sca: system example [5];
				connections
					c1: port sc1.odps -> sca.idps;
				properties
					Connection_Pattern => ((One_To_All)) applies to c1;
			end test_sys.impl;

			system implementation test_sys.impl2 extends test_sys.impl
				connections
					c1: refined to port;
			end test_sys.impl2;

			system example
				features
					idps: in data port;
					odps: out data port;
			end example;

		end issue448;
	'''
}
