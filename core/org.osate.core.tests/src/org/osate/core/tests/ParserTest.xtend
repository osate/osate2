package org.osate.core.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ModelUnit
import org.osate.aadl2.SystemType
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class ParserTest extends OsateTest {

	@Inject extension ParseHelper<ModelUnit>

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
		'''.parse

		val pack = model as AadlPackage
		Assert::assertEquals("example", pack.name)

		val sys = pack.publicSection.ownedClassifiers.get(0) as SystemType
		Assert::assertEquals("sys", sys.name)
	}
}
