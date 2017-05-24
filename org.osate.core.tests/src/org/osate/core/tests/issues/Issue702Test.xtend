package org.osate.core.tests.issues

import com.itemis.xtext.testing.XtextRunner2
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals
import static extension org.osate.aadl2.instantiation.InstantiateModel.buildInstanceModelFile

@RunWith(XtextRunner2)
@InjectWith(Aadl2UiInjectorProvider)
class Issue702Test extends OsateTest {
	override getProjectName() {
		"issue702"
	}
	
	@Test
	def void issue702() {
		val fileName = "issue702.aadl"
		createFiles(fileName -> '''
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
		''')
		suppressSerialization
		testFile(fileName).resource.contents.head as AadlPackage => [
			"fgpt".assertEquals(name)
			publicSection.ownedClassifiers.get(2) as SystemImplementation => [
				"sys.root".assertEquals(name)
				buildInstanceModelFile => [
					"sys_root_Instance".assertEquals(name)
					3.assertEquals(connectionInstances.size)
				]
			]
		]
	}
}