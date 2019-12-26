package org.osate.aadl2.errormodel.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.errormodel.analysis.handlers.UnhandledFaultsHandler
import org.osate.testsupport.TestHelper

import static org.junit.Assert.assertTrue

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue2092Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.aadl2.errormodel.tests/models/Issue2092/"
	
	@Inject
	TestHelper<AadlPackage> testHelper

	def SystemInstance instanceGenerator(AadlPackage pkg, String rootclassifier) {
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == rootclassifier])
		// instantiate
		val sysImpl = cls.findFirst[name == rootclassifier] as ComponentImplementation
		return InstantiateModel::instantiate(sysImpl)
	}
	
	@Test
	def void testPkg1() {
		val pkg1FileName = "unhandled.aadl"
		val pkg = testHelper.parseFile(PROJECT_LOCATION + pkg1FileName)
		val instance1 = instanceGenerator(pkg, "top.i")
		val ufh = new UnhandledFaultsHandler();
		ufh.checkUnhandledFaults(instance1)
		assertTrue(instance1.eResource.errors.empty)
	}
}