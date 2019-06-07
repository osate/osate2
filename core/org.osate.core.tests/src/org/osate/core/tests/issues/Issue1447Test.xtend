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

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1447Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue1447/"
	val static TEST_PS = "TestPS.aadl"
	val static SUBCOMPONENTS1 = "subcomponents1.aadl"
	val static SUBCOMPONENTS2 = "subcomponents2.aadl"
	val static SUBCOMPONENTS3 = "subcomponents3.aadl"
	val static SUBCOMPONENTS4 = "subcomponents4.aadl"
	val static SUBCOMPONENTS5 = "subcomponents5.aadl"
	val static SUBCOMPONENTS6 = "subcomponents6.aadl"

	val static A_I = "A.i"

	val static INSTANCE_NAME = "A_i_Instance"

	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void test1() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + SUBCOMPONENTS1, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		/* The first test should have no errors. */		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(0, messages.size)
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		assertEquals("s3", s3.name)
		
		val propAssocs = s3.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(400L, (value as IntegerLiteral).value)
		
		
//		messages.get(0) => [
//			SUB_B.assertEquals((where as ComponentInstance).name)
//			QueuingAnalysisErrorReporter.WARNING.assertEquals(kind)
//			WARNING_NO_CLASSIFIER.assertEquals(message)
//		]
//		
//		messages.get(1) => [
//			SUB_B1.assertEquals((where as ComponentInstance).name)
//			QueuingAnalysisErrorReporter.WARNING.assertEquals(kind)
//			WARNING_NO_CLASSIFIER.assertEquals(message)
//		]
	}
	
	@Test
	def void test2() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + SUBCOMPONENTS2, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		/* The first test should have no errors. */		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		assertEquals("s3", s3.name)
		
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(3, messages.size)
		messages.get(0) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents2::C.i\" tries to replace it.", message)
		]
		messages.get(1) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents2::B.i\" tries to replace it.", message)
		]
		messages.get(2) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents2::A.i\" tries to replace it.", message)
		]

		val propAssocs = s3.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		/* Ideally the value should be -200L, but because the declarative model is actually erroneous (by containing
		 * associations that try to replace constant associations) the behavior cannot be trusted.  In this case,
		 * the instantiation process still picks up the contained association in C_i because it is in the same
		 * classifier that declares subcomponent s3.
		 */
		assertEquals(200L, (value as IntegerLiteral).value)
	}
	
	// basically the same as test2
	@Test
	def void test3() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + SUBCOMPONENTS3, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		/* The first test should have no errors. */		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		assertEquals("s3", s3.name)
		
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(3, messages.size)
		messages.get(0) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents3::C.i\" tries to replace it.", message)
		]
		messages.get(1) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents3::B.i\" tries to replace it.", message)
		]
		messages.get(2) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents3::A.i\" tries to replace it.", message)
		]

		val propAssocs = s3.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		/* Ideally the value should be -200L, but because the declarative model is actually erroneous (by containing
		 * associations that try to replace constant associations) the behavior cannot be trusted.  In this case,
		 * the instantiation process still picks up the contained association in C_i because it is in the same
		 * classifier that declares subcomponent s3.
		 */
		assertEquals(200L, (value as IntegerLiteral).value)
	}
	
	// basically the same as test2
	@Test
	def void test4() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + SUBCOMPONENTS4, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		/* The first test should have no errors. */		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		assertEquals("s3", s3.name)
		
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(3, messages.size)
		messages.get(0) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents4::C.i\" tries to replace it.", message)
		]
		messages.get(1) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents4::B.i\" tries to replace it.", message)
		]
		messages.get(2) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents4::A.i\" tries to replace it.", message)
		]

		val propAssocs = s3.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		/* Ideally the value should be -200L, but because the declarative model is actually erroneous (by containing
		 * associations that try to replace constant associations) the behavior cannot be trusted.  In this case,
		 * the instantiation process still picks up the contained association in C_i because it is in the same
		 * classifier that declares subcomponent s3.
		 */
		assertEquals(200L, (value as IntegerLiteral).value)
	}
	
	@Test
	def void test5() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + SUBCOMPONENTS5, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		/* The first test should have no errors. */		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		assertEquals("s3", s3.name)
		
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(2, messages.size)
		messages.get(0) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents5::B.i\" tries to replace it.", message)
		]
		messages.get(1) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents5::A.i\" tries to replace it.", message)
		]

		val propAssocs = s3.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(200L, (value as IntegerLiteral).value)
	}
	
	@Test
	def void test6() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + SUBCOMPONENTS6, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		/* The first test should have no errors. */		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		assertEquals("s3", s3.name)
		
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(1, messages.size)
		messages.get(0) => [
			assertEquals(s3, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"subcomponents6::A.i\" tries to replace it.", message)
		]

		val propAssocs = s3.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(300L, (value as IntegerLiteral).value)
	}
}
