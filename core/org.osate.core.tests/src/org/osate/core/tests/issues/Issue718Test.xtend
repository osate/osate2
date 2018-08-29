package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class Issue718Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
		
	@Test
	def void issue718() {
		
		val testFileResult = issues = testHelper.testString(aadlText, psText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
					
		assertTrue('Unexpected error', issueCollection.empty)
	}

	val psText = '''
		property set ps718 is
			cltype: type classifier;
			reftype: type reference;
			cl: ps718::cltype applies to (all);
			ref: ps718::reftype applies to (all);
		end ps718;
	'''
	val aadlText = '''
		package issue718
		public
			with ps718;
			
			system S	
			end S;
			
			system implementation S.i
				subcomponents
					s: system;
				properties
					ps718::cl => classifier(S);
					ps718::ref => reference(s);
			end S.i;
		
		end issue718;
	'''
}
