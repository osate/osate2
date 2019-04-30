package org.osate.aadl2.errormodel.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.testsupport.TestHelper

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue1735 {
	val static PROJECT_LOCATION = "org.osate.aadl2.errormodel.tests/models/Issue1735/"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Inject
	extension ValidationTestHelper
	
	@Test
	def void testIssue1735() {
		testHelper.parseFile(PROJECT_LOCATION + "inverse_bug.aadl").assertNoIssues
	}
}