package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.Element
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue736Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue736() {
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
	
		pkg => [
			assertEquals("pkg", name)
			cls.get(1) as SystemImplementation => [
				"s.i".assertEquals(name)
				val sysImpl = cls.findFirst[name == 's.i'] as SystemImplementation
				val instance = InstantiateModel.instantiate(sysImpl)
				instance => [
					"s_i_Instance".assertEquals(name)
					assertEquals(2, new SubcomponentInstanceProcessor().defaultTraversal(it).size)
					currentSystemOperationMode = systemOperationModes.head
					assertEquals(1, new SubcomponentInstanceProcessor().defaultTraversal(it).size)
				]
			]
		]
	}
	
	private static class SubcomponentInstanceProcessor extends ForAllElement {
		override protected suchThat(Element obj) {
			obj instanceof ComponentInstance && !(obj instanceof SystemInstance)
		}
	}
	
	val aadlText = '''
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
'''
}