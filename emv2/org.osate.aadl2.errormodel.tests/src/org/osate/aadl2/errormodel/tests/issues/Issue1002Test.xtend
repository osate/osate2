package org.osate.aadl2.errormodel.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue1002Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.aadl2.errormodel.tests/models/issue1002/"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testPkg1() {
		ignoreSerializationDifferences
		testHelper.testFile(PROJECT_LOCATION + "issue1002.aadl").resource.contents.head as AadlPackage => [
			"issue1002".assertEquals(name)
		]
	}
	
}