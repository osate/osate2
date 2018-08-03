package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue666Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue666() {
		
		val testFileResult = issues = testHelper.testString(aadlText)
		val pkg = testFileResult.resource.contents.head as AadlPackage
		pkg => [
			"pkg1".assertEquals(name)
			publicSection.ownedClassifiers.get(2) as ComponentImplementation => [
				"outer.ok".assertEquals(name)
				val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
				val instance = InstantiateModel.instantiate(it, errorManager)
				val reporter = errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter
				val messages = reporter.errors
				instance => [
					"outer_ok_Instance".assertEquals(name)
					assertEquals(512, systemOperationModes.size)
					assertTrue(messages.empty)
				]
			]
			publicSection.ownedClassifiers.get(3) as ComponentImplementation => [
				"outer.tooManySOMs".assertEquals(name)
				val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
				val instance = InstantiateModel.instantiate(it, errorManager)
				val reporter = errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter
				val messages = reporter.errors				
				instance => [
					"outer_tooManySOMs_Instance".assertEquals(name)
					assertEquals(1000, systemOperationModes.size)
					messages => [
						assertEquals(1, size)
						head => [
							assertEquals(QueuingAnalysisErrorReporter.WARNING, kind)
							assertEquals("List of system operation modes is incomplete (see project property 'Instantiation')", message)
						]
					]
				]
			]
		]
	}
	val aadlText = '''
			package pkg1
			public
				abstract inner
					modes
						m1: initial mode;
						m2: mode;
				end inner;
				
				abstract outer
				end outer;
				
				abstract implementation outer.ok
					subcomponents
						sub1: abstract inner[9];
				end outer.ok;
				
				abstract implementation outer.tooManySOMs
					subcomponents
						sub2: abstract inner[10];
				end outer.tooManySOMs;
			end pkg1;
		'''
}