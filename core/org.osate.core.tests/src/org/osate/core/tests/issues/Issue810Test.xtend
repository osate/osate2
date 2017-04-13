package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

@RunWith(XtextRunner2)
@InjectWith(Aadl2UiInjectorProvider)
class Issue810Test extends OsateTest {
	@Inject extension ValidationTestHelper
	
	override getProjectName() {
		"issue810"
	}
	
	@Test
	def void issue810() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> '''
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
		''')
		suppressSerialization
		testFile(pkg1FileName).resource.contents.head.assertNoIssues
	}
}