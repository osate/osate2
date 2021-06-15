package org.osate.ba.tests

import javax.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class CoveringSyntaxTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	String PATH = "org.osate.ba.tests/models/covering_syntax/";
	String PROPERTY_SET_PATH = PATH+"aadlBaTestPropertySet.aadl";
	String SUBPROGRAM_PATH = PATH+"aadlBaTestSubprogram.aadl";
	String TYPES_PATH = PATH+"aadlBaTestTypes.aadl";
	@Test
	def void aadlBaTest001() {
		val result = testHelper.testFile(PATH+"aadlBaTest001.aadl", PROPERTY_SET_PATH, SUBPROGRAM_PATH, TYPES_PATH)
		2.assertEquals(result.issues.size)
	}
	
	@Test
	def void aadlBaTest002() {
		val result = testHelper.testFile(PATH+"aadlBaTest002.aadl", PROPERTY_SET_PATH, SUBPROGRAM_PATH, TYPES_PATH)
		25.assertEquals(result.issues.size)
	}
	
	@Test
	def void aadlBaTest003() {
		val result = testHelper.testFile(PATH+"aadlBaTest003.aadl", PROPERTY_SET_PATH, SUBPROGRAM_PATH, TYPES_PATH)
		14.assertEquals(result.issues.size)
	}
	
	@Test
	def void aadlBaTest004() {
		val result = testHelper.testFile(PATH+"aadlBaTest004.aadl", PROPERTY_SET_PATH, SUBPROGRAM_PATH, TYPES_PATH)
		3.assertEquals(result.issues.size)
	}
	
	@Test
	def void aadlBaTest005() {
		val result = testHelper.testFile(PATH+"aadlBaTest005.aadl", PROPERTY_SET_PATH, SUBPROGRAM_PATH, TYPES_PATH)
		9.assertEquals(result.issues.size)
	}
	
	@Test
	def void aadlBaTest006() {
		val result = testHelper.testFile(PATH+"aadlBaTest006.aadl", PROPERTY_SET_PATH, SUBPROGRAM_PATH, TYPES_PATH)
		39.assertEquals(result.issues.size)
	}
	
	@Test
	def void aadlBaTest007() {
		val result = testHelper.testFile(PATH+"aadlBaTest007.aadl", PROPERTY_SET_PATH, SUBPROGRAM_PATH, TYPES_PATH)
		46.assertEquals(result.issues.size)
	}
}