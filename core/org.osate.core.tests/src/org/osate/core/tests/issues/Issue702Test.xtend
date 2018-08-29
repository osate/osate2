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

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue702Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue702() {
		
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		
		pkg => [
			assertEquals("fgpt", name)
			publicSection.ownedClassifiers.get(2) as SystemImplementation => [
				assertEquals("sys.root", name)
				val sysImpl = cls.findFirst[name == 'sys.root'] as SystemImplementation
				val instance = InstantiateModel.instantiate(sysImpl)
				instance => [
					"sys_root_Instance".assertEquals(name)
					assertEquals(3, connectionInstances.size)
				]
			]
		]
	}
	
	val aadlText = '''
package fgpt
public
	feature group Sense_Whole
		features
			D1: in data port;
			D2: in data port;
			D3: in data port;
			D4: in data port;
			D5: in data port;
	end Sense_Whole;
	
	system sys
	end sys;
	
	system implementation sys.root
		subcomponents
			External: system Ext.base;
			Container: system Container.base;
		connections
			sense: feature group External.Sense -> Container.Sense;
	end sys.root;
	
	system Container
		features
			Sense: feature group Sense_Whole;
	end Container;
	
	system implementation Container.base
		subcomponents
			S1: system Sub1.base;
		connections
			Sub1_D1: port Sense.D1 -> S1.D1;
			Sub1_D2: port Sense.D2 -> S1.D2;
			Sub1_D3: port Sense.D3 -> S1.D3;
	end Container.base;
	
	system Sub1
		features
			D1: in data port;
			D2: in data port;
			D3: in data port;
	end Sub1;
	
	system implementation Sub1.base
	end Sub1.base;
	
	system Ext
		features
			Sense: feature group inverse of Sense_Whole;
	end Ext;
	
	system implementation Ext.base
	end Ext.base;
end fgpt;
		'''
}