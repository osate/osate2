package org.osate.core.tests.issues

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class Issue448Test extends OsateTest {
	override getProjectName() {
		"issue448"
	}

	@Test
	def void issue448() {
		val aadlFile = "issue448.aadl"
		createFiles(aadlFile -> aadlText)
		suppressSerialization
		val result = testFile(aadlFile)

		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "test_sys.impl2" not found', cls.exists[name == 'test_sys.impl2'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'test_sys.impl2'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
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

end issue448;'''
}
