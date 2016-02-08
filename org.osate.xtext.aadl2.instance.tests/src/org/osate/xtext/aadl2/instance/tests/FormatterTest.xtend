package org.osate.xtext.aadl2.instance.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.formatter.FormatterTester
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.xtext.aadl2.instance.InstanceInjectorProvider

@RunWith(XtextRunner)
@InjectWith(InstanceInjectorProvider)
class FormatterTest {
	@Inject
	extension FormatterTester
	
	@Test
	def void testEmptyInstance() {
		assertFormatted[
			expectation = '''
				system sInstance : pkg1::s.i {
					som "No Modes"
				}'''
			toBeFormatted = 'system sInstance:pkg1::s.i{som"No Modes"}'
		]
	}
}