package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.Aadl2Factory
import org.osate.testsupport.Aadl2InjectorProvider

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1972Test {
	@Inject
	ISerializer serializer
	
	@Test
	def void testIssue1972() {
		val resource = new XtextResource
		val propertySet = Aadl2Factory.eINSTANCE.createPropertySet => [
			it.name = "test_ps"
		]
		resource.contents += propertySet
		val expected = '''
			property set test_ps is
			end test_ps;'''
		expected.assertEquals(serializer.serialize(propertySet))
	}
}