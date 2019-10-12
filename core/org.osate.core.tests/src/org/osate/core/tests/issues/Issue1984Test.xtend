package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.aadl2.instantiation.InstantiateModel
import static org.junit.Assert.assertTrue

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1984Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue1984/"
	
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void doTest() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "FGConnections.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "top.specific"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// There should be no errors on the instance model.  Before the issue was fixed, we used to have errors
		assertTrue(messages.size == 0)
	}

}
