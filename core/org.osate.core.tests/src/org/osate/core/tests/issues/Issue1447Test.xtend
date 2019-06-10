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

	val static FEATURES1 = "features1.aadl";
	val static FEATURES2 = "features2.aadl";
	val static FEATURES3 = "features3.aadl";
	val static FEATURES4 = "features4.aadl";
	val static FEATURES5 = "features5.aadl";
	val static FEATURES6 = "features6.aadl";
	val static FEATURES7 = "features7.aadl";
	val static FEATURES8 = "features8.aadl";
	val static FEATURES9 = "features9.aadl";
	val static FEATURES10 = "features10.aadl";
	val static FEATURES11 = "features11.aadl";

	val static A_I = "A.i"

	val static INSTANCE_NAME = "A_i_Instance"

	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testSubcomponents1() {
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
	}
	
	@Test
	def void testSubcomponents2() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + SUBCOMPONENTS2, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

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
	def void testSubcomponents3() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + SUBCOMPONENTS3, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

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
	def void testSubcomponents4() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + SUBCOMPONENTS4, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

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
	def void testSubcomponents5() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + SUBCOMPONENTS5, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

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
	def void testSubcomponents6() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + SUBCOMPONENTS6, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

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
	
	@Test
	def void testFeatures1() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FEATURES1, PROJECT_LOCATION + TEST_PS)
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
		val f1 = s3.featureInstances.get(0)
		assertEquals("f1", f1.name)

		val propAssocs = f1.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(90L, (value as IntegerLiteral).value)
	}
	
	@Test
	def void testFeatures2() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FEATURES2, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		val f1 = s3.featureInstances.get(0)
		assertEquals("f1", f1.name)

		assertEquals(4, messages.size)
		messages.get(0) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features2::D2.i\" tries to replace it.", message)
		]
		messages.get(1) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features2::C.i\" tries to replace it.", message)
		]
		messages.get(2) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features2::B.i\" tries to replace it.", message)
		]
		messages.get(3) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features2::A.i\" tries to replace it.", message)
		]

		val propAssocs = f1.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(0L, (value as IntegerLiteral).value)
	}
	
	@Test
	def void testFeatures3() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FEATURES3, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		val f1 = s3.featureInstances.get(0)
		assertEquals("f1", f1.name)

		assertEquals(4, messages.size)
		messages.get(0) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features3::D2.i\" tries to replace it.", message)
		]
		messages.get(1) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features3::C.i\" tries to replace it.", message)
		]
		messages.get(2) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features3::B.i\" tries to replace it.", message)
		]
		messages.get(3) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features3::A.i\" tries to replace it.", message)
		]

		val propAssocs = f1.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(10L, (value as IntegerLiteral).value)
	}	
	
	@Test
	def void testFeatures4() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FEATURES4, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		val f1 = s3.featureInstances.get(0)
		assertEquals("f1", f1.name)

		assertEquals(4, messages.size)
		messages.get(0) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features4::D2.i\" tries to replace it.", message)
		]
		messages.get(1) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features4::C.i\" tries to replace it.", message)
		]
		messages.get(2) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features4::B.i\" tries to replace it.", message)
		]
		messages.get(3) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features4::A.i\" tries to replace it.", message)
		]

		val propAssocs = f1.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(20L, (value as IntegerLiteral).value)
	}	
	
	@Test
	def void testFeatures5() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FEATURES5, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		val f1 = s3.featureInstances.get(0)
		assertEquals("f1", f1.name)

		assertEquals(4, messages.size)
		messages.get(0) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features5::D2.i\" tries to replace it.", message)
		]
		messages.get(1) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features5::C.i\" tries to replace it.", message)
		]
		messages.get(2) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features5::B.i\" tries to replace it.", message)
		]
		messages.get(3) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features5::A.i\" tries to replace it.", message)
		]

		val propAssocs = f1.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(30L, (value as IntegerLiteral).value)
	}	
	
	@Test
	def void testFeatures6() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FEATURES6, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		val f1 = s3.featureInstances.get(0)
		assertEquals("f1", f1.name)

		assertEquals(4, messages.size)
		messages.get(0) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features6::D2.i\" tries to replace it.", message)
		]
		messages.get(1) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features6::C.i\" tries to replace it.", message)
		]
		messages.get(2) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features6::B.i\" tries to replace it.", message)
		]
		messages.get(3) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features6::A.i\" tries to replace it.", message)
		]

		val propAssocs = f1.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(40L, (value as IntegerLiteral).value)
	}
	
	@Test
	def void testFeatures7() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FEATURES7, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		val f1 = s3.featureInstances.get(0)
		assertEquals("f1", f1.name)

		assertEquals(4, messages.size)
		messages.get(0) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features7::D2.i\" tries to replace it.", message)
		]
		messages.get(1) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features7::C.i\" tries to replace it.", message)
		]
		messages.get(2) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features7::B.i\" tries to replace it.", message)
		]
		messages.get(3) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features7::A.i\" tries to replace it.", message)
		]

		val propAssocs = f1.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(50L, (value as IntegerLiteral).value)
	}
	
	@Test
	def void testFeatures8() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FEATURES8, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		val f1 = s3.featureInstances.get(0)
		assertEquals("f1", f1.name)

		assertEquals(3, messages.size)
		messages.get(0) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features8::C.i\" tries to replace it.", message)
		]
		messages.get(1) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features8::B.i\" tries to replace it.", message)
		]
		messages.get(2) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features8::A.i\" tries to replace it.", message)
		]

		val propAssocs = f1.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(60L, (value as IntegerLiteral).value)
	}
	
	@Test
	def void testFeatures9() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FEATURES9, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		val f1 = s3.featureInstances.get(0)
		assertEquals("f1", f1.name)

		assertEquals(2, messages.size)
		messages.get(0) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features9::B.i\" tries to replace it.", message)
		]
		messages.get(1) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features9::A.i\" tries to replace it.", message)
		]

		val propAssocs = f1.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(70L, (value as IntegerLiteral).value)
	}
	
	@Test
	def void testFeatures10() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FEATURES10, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		val f1 = s3.featureInstances.get(0)
		assertEquals("f1", f1.name)

		assertEquals(1, messages.size)
		messages.get(0) => [
			assertEquals(f1, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features10::A.i\" tries to replace it.", message)
		]

		val propAssocs = f1.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(80L, (value as IntegerLiteral).value)
	}
	
	@Test
	def void testFeatures11() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FEATURES11, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// Find s1.s2.s3
		val s1 = instance.componentInstances.get(0)
		val s2 = s1.componentInstances.get(0)
		val s3 = s2.componentInstances.get(0)
		val f1 = s3.featureInstances.get(0)
		assertEquals("f1", f1.name)

		assertEquals(0, messages.size)

		val propAssocs = f1.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		val values = propAssocs.get(0).ownedValues
		assertEquals(1, values.size)
		val value = values.get(0).ownedValue
		assertTrue(value instanceof IntegerLiteral)
		assertEquals(90L, (value as IntegerLiteral).value)
	}
}

