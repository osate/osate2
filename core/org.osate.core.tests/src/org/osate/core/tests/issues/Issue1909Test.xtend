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
class Issue1909Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue1909/"
	val static FILE = "issue1909.aadl"
		
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Inject
	ValidationTestHelper validationHelper;
	
	@Test
	def void testIssue1909() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE)
		validationHelper.assertNoIssues(pkg)
	}
	
}

