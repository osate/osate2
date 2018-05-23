package org.osate.core.tests.issues

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2UiInjectorProvider
import org.osate.testsupport.OsateTest

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class Issue539Test extends OsateTest {
	@Test
	def void issue539() {
		val aadlFile = "issue539.aadl"
		createFiles(aadlFile -> aadlText)
		suppressSerialization
		val result = testFile(aadlFile)

		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "top.impl" not found', cls.exists[name == 'top.impl'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'top.impl'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		assertEquals('top_impl_Instance', instance.name)

		// check if there are 2 connections in top
		val connections = instance.connectionInstances
		assertTrue('In top_impl_instance: Expected 2 connections but found ' + connections.size, connections.size == 2)
	}

	val aadlText = '''
package issue539
public
	
	system top
	end top;

	system implementation top.impl
		subcomponents
			proc1: process test_process_type;
			proc2: process test_process_type;
		connections
			fg_con: feature group proc1.tfg <-> proc2.tfg_inv;
	end top.impl;

	process test_process_type
		features
			tfg: feature group test_feature_group_type;
			tfg_inv: feature group inverse of test_feature_group_type;
	end test_process_type;

	feature group test_feature_group_type
		features
			in1: in data port;
			out1: out data port;
	end test_feature_group_type;

end issue539;
'''
}
