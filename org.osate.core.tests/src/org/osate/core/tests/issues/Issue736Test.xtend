package org.osate.core.tests.issues

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.Element
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals
import static extension org.osate.aadl2.instantiation.InstantiateModel.buildInstanceModelFile

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class Issue736Test extends OsateTest {
	@Test
	def void issue736() {
		val fileName = "issue736.aadl"
		createFiles(fileName -> '''
			package pkg
			public
				system s
					modes
						m1: initial mode;
						m2: mode;
				end s;
				
				system implementation s.i
					subcomponents
						sub1: system in modes (m1);
						sub2: system in modes (m2);
				end s.i;
			end pkg;
		''')
		suppressSerialization
		testFile(fileName).resource.contents.head as AadlPackage => [
			"pkg".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s.i".assertEquals(name)
				buildInstanceModelFile => [
					"s_i_Instance".assertEquals(name)
					2.assertEquals(new SubcomponentInstanceProcessor().defaultTraversal(it).size)
					currentSystemOperationMode = systemOperationModes.head
					1.assertEquals(new SubcomponentInstanceProcessor().defaultTraversal(it).size)
				]
			]
		]
	}
	
	private static class SubcomponentInstanceProcessor extends ForAllElement {
		override protected suchThat(Element obj) {
			obj instanceof ComponentInstance && !(obj instanceof SystemInstance)
		}
	}
}