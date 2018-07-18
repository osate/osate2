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

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class Issue662Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue662() {
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "S.top" not found', cls.exists[name == 'S.top'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'S.top'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals('S_top_Instance', instance.name)

		// check if there are 2 connections
		val connections = instance.connectionInstances
		assertTrue('In S_top_instance: Expected 2 connections but found ' + connections.size, connections.size == 2)
	}

	val aadlText = '''
		package issue662
		public

			system AbstractWorkload
				features
				groupOut: feature;
					groupIn: feature;
			end AbstractWorkload;

			system S
			end S;

			system implementation S.AbstractFeatures
				subcomponents
					work1: system AbstractWorkload;
					work2: system AbstractWorkload;
				connections
					con1: feature work1.groupOut <-> work2.groupIn;
			end S.AbstractFeatures;

			system implementation S.top extends S.AbstractFeatures
				connections
					con1: refined to feature;
			end S.top;

		end issue662;
	'''
}
