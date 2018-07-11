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
class Issue810Test {
	@Inject extension ValidationTestHelper
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue810() {
		val pkg1 = '''
			package pkg1
			public
				abstract a1
				end a1;
				
				abstract implementation a1.i
					subcomponents
						sub1: abstract a2;
						sub2: abstract a2;
					connections
						conn1: feature group sub1.fg1 -> sub2.fg2;
						conn3: feature group sub1.fg3.fg5 -> sub2.fg4.fg5;
				end a1.i;
				
				abstract a2
					features
						fg1: out feature group fgt1;
						fg2: in feature group inverse of fgt1;
						fg3: feature group fgt2;
						fg4: feature group inverse of fgt2;
				end a2;
				
				feature group fgt1
					features
						p1: out data port;
				end fgt1;
				
				feature group fgt2
					features
						fg5: out feature group fgt1;
				end fgt2;
			end pkg1;
		'''
		testHelper.parseString(pkg1).assertNoIssues
	}
}