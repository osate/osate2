package org.osate.core.tests.issues

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class Issue635Test extends OsateTest {
	override getProjectName() {
		"issue635"
	}

	@Test
	def void issue635() {
		val psFile = "ps635.aadl"
		val aadlFile = "issue635.aadl"
		createFiles(psFile -> psText, aadlFile -> aadlText)
		suppressSerialization
		val result = testFile(aadlFile, psFile)
		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "top.i" not found', cls.exists[name == 'top.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'top.i'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		assertEquals('top_i_Instance', instance.name)

		// check if there are 21 connections
		var pas = instance.ownedPropertyAssociations
		var names = pas.map[it.property.name]
		assertEquals('In top_i_Instance: Did not find expected properties', names, #['p0', 'p2'])

		pas = instance.featureInstances.get(0).ownedPropertyAssociations
		names = pas.map[it.property.name]
		assertEquals('In feature group fg: Did not find expected properties', names, #['q0', 'q3'])

		pas = instance.featureInstances.get(0).featureInstances.get(0).ownedPropertyAssociations
		names = pas.map[it.property.name]
		assertEquals('In feature fg.f2: Did not find expected properties', names, #['q0', 'q1'])

		pas = instance.featureInstances.get(0).featureInstances.get(1).ownedPropertyAssociations
		names = pas.map[it.property.name]
		assertEquals('In feature fg.f1: Did not find expected properties', names, #['q0', 'q2', 'r1'])

		pas = instance.featureInstances.get(0).featureInstances.get(2).ownedPropertyAssociations
		names = pas.map[it.property.name]
		assertEquals('In feature fg.f0: Did not find expected properties', names, #['q0'])
		
		pas = instance.componentInstances.get(0).ownedPropertyAssociations
		names = pas.map[it.property.name]
		assertEquals('In component sub: Did not find expected properties', names, #['p2', 'p1'])

		pas = instance.componentInstances.get(1).ownedPropertyAssociations
		names = pas.map[it.property.name]
		assertEquals('In component sub1: Did not find expected properties', names, #['p2', 'p3'])

	}

	val psText = '''
		property set ps635 is
			p0: aadlboolean applies to (data, system implementation);
			p1: aadlboolean applies to (system type);
			p2: aadlboolean applies to (memory, system);
			p3: aadlboolean applies to (system subcomponent);
			q0: aadlboolean applies to (feature);
			q1: aadlboolean applies to (access);
			q2: aadlboolean applies to (port);
			q3: aadlboolean applies to (feature group);
			q4: aadlboolean applies to (feature group type);
			r1: aadlboolean applies to (all);
		end ps635;
	'''
	val aadlText = '''
		package issue635
		public
			with ps635;
		
			feature group fg
				features
					f0: feature {
						ps635::q0 => true;	
					};
					f1: in data port {
						ps635::q0 => true;	
						ps635::q2 => true;	
						ps635::r1 => true;
					};
					f2: provides bus access {
						ps635::q0 => true;	
						ps635::q1 => true;	
					};
			end fg;
			
			system top
				features
					fg: feature group fg;
				properties
					ps635::p1 => false;
					ps635::p2 => false;
					
					ps635::q0 => true applies to fg;
					ps635::q3 => false applies to fg;
			end top;
		
			system implementation top.i
				subcomponents
					sub: system top;
					sub1: system;
				properties
					ps635::p0 => true;
					ps635::p2 => true;
					ps635::p2 => true applies to sub1;
					ps635::p3 => true applies to sub1;
			end top.i;
			
		end issue635;
	'''
}
