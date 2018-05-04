package org.osate.aadl2.errormodel.tests.issues

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.errormodel.tests.ErrorModelUiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(ErrorModelUiInjectorProvider)
class Issue1002Test extends OsateTest {
	val static PROJECT_LOCATION = "org.osate.aadl2.errormodel.tests/models/issue1002/"
	
	@Test
	def void testPkg1() {
		val fileName = "issue1002.aadl"
		createFiles(fileName -> readFile(PROJECT_LOCATION + fileName))
		ignoreSerializationDifferences
		testFile(fileName).resource.contents.head as AadlPackage => [
			"issue1002".assertEquals(name)
		]
	}
	
}