package org.osate.core.tests

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemType
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class ParserTest extends XtextTest {

	@Inject 
	TestHelper<AadlPackage> testHelper

	@Test
	def void testParsing() {
		val model = '''
			package example
			public
			  system sys
			    subcomponents
			      none;
			    properties
			      none;
			end example;
		'''

		val pack = testHelper.parseString(model)
		Assert::assertEquals("example", pack.name)

		val sys = pack.publicSection.ownedClassifiers.get(0) as SystemType
		Assert::assertEquals("sys", sys.name)
	}
}
