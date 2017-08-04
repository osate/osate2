package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class Issue833Test extends OsateTest {
	@Inject extension ValidationTestHelper
	
	@Test
	def void issue833() {
		val bindingPropertiesFileName = "binding_properties.aadl"
		createFiles(bindingPropertiesFileName -> '''
			package binding_properties
			public
				processor cpu1
				end cpu1;
				
				processor cpu2
				end cpu2;
				
				process a
					properties
						Period => 10ms in binding(cpu1);
						Period => 20ms in binding(cpu2);
				end a;
			end binding_properties;
		''')
		suppressSerialization
		testFile(bindingPropertiesFileName).resource.contents.head.assertNoIssues
	}
}