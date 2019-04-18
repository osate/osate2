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
class Issue815Test {
	@Inject extension ValidationTestHelper
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue815() {
		val pkg1 = '''
			package pkg1
			public
				feature group fgt1
					features
						in1: in feature;
				end fgt1;
				
				feature group ifgt1
					features
						out1: out feature;
				inverse of fgt1
				end ifgt1;
				
				feature group efgt1 extends fgt1
					features
						in2: in feature;
				end efgt1;
				
				feature group iefgt1 extends ifgt1
					features
						out2: out feature;
				inverse of efgt1
				end iefgt1;
				
				feature group fgt2
					features
						out1: out feature;
						out2: out feature;
				end fgt2;
				
				abstract a1
					features
						fg1: feature group iefgt1;
				end a1;
				
				abstract implementation a1.i
					subcomponents
						sub1: abstract a2;
					connections
						conn1: feature sub1.out3 -> fg1.out1;
						conn2: feature sub1.out3 -> fg1.out2;
						conn3: feature group sub1.fg2 -> fg1 {Classifier_Matching_Rule => Subset;};
				end a1.i;
				
				abstract a2
					features
						out3: out feature;
						fg2: feature group fgt2;
				end a2;
			end pkg1;
		'''
		testHelper.parseString(pkg1).assertNoIssues
	}
}