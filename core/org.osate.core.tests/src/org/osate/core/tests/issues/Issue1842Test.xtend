package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*
import org.osate.aadl2.IntegerLiteral
import java.text.MessageFormat

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1842Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue1842/"
	val static TEST_PS = "test_ps.aadl"
	val static CYCLE_EXAMPLE = "cycle_example.aadl"
		
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testForCycles() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + CYCLE_EXAMPLE, PROJECT_LOCATION + TEST_PS)
		
		// get the property reference
		val dummyProperty = pkg.ownedPublicSection.ownedClassifiers.get(0).ownedPropertyAssociations.get(0).property
		assertEquals("dummy", dummyProperty.name);
		
		// get the first type
		val system_a = pkg.ownedPublicSection.ownedClassifiers.get(1)
		assertEquals("A", system_a.name)
		
		// get the first implementation
		val system_c_i = pkg.ownedPublicSection.ownedClassifiers.get(4)
		assertEquals("C.i", system_c_i.name)
		
		system_a.getPropertyValue(dummyProperty)
		assertTrue(true) // won't get here if we get stuck in a cycle
		
		system_c_i.getPropertyValue(dummyProperty)
		assertTrue(true) // won't get here if we get stuck in a cycle
	}
	
}

