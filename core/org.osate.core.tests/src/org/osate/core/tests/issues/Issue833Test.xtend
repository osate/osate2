package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue833Test {
	@Inject extension ValidationTestHelper
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue833() {
		val bindingProperties = '''
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
		'''
		testHelper.parseString(bindingProperties).assertNoIssues
	}
}