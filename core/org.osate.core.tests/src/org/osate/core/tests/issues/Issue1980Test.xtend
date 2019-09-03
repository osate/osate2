package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ThreadImplementation
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper
import org.osate.xtext.aadl2.properties.util.GetProperties

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1980Test {
	val static FILE = "org.osate.core.tests/models/issue1980/Issue1980.aadl"

	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void testInstantiation() {
		val pkg = testHelper.parseFile(FILE)
		val impl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == 'T.i'] as ThreadImplementation
		assertNotNull(impl)
		val contextToUse = impl.getType();
		val dispatchProtocol = GetProperties.getDispatchProtocol(contextToUse);
		assertNotNull(dispatchProtocol)
	}
}
