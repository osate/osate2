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
class Issue699Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue699() {

		val pkg = testHelper.parseString(aadlText, psText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation S.i not found', cls.exists[name == 'S.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'S.i'] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val reporter = errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter
		val messages = reporter.errors
		assertEquals('S_i_Instance', instance.name)

		assertEquals(messages.size, 1)
		assertEquals(messages.head.message, "Property ps699::p has cyclic value")
	}

	val aadlText = '''
		package issue699
		public
			with ps699;
			system S
			end S;
			
			system implementation S.i
				properties
					ps699::p => ps699::q;
					ps699::q => ps699::p;
			end S.i;
		
		end issue699;
	'''
	val psText = '''
		property set ps699 is
			p: aadlinteger applies to (all);
			q: aadlinteger applies to (all);
		end ps699;
	'''
}
