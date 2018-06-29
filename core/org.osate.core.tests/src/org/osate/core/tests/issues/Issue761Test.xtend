package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
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

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class Issue761Test extends XtextTest {
		
	@Inject
	TestHelper<AadlPackage> testHelper
		
	@Test
	def void issue761() {
		
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation S.i not found', cls.exists[name == 'S.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'S.i'] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val reporter = errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter
		val messages = reporter.errors
		assertEquals('S_i_Instance', instance.name)

		// check for cyclicity error
		assertEquals(1, messages.size)
		assertEquals("Cyclic containment dependency: Feature 'f' has already been instantiated as enclosing feature group.", messages.head.message)
	}

	val aadlText = '''
		package issue761
		public
			feature group F
				features
					f: feature group F;
			end F;
			
			system S
				features
					f: feature group F;
			end S;
		
			system implementation S.i
			end S.i;
		
		end issue761;
	'''
}
