package org.osate.ba.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals

/**
 * Exercises the Behavior Annex legality, consistency, semantic, and type checkers through validation of embedded
 * annexes. The models intentionally violate named standard rules, so their diagnostics must remain user-visible.
 */
@RunWith(XtextRunner)
@InjectWith(BehaviorAnnexInjectorProvider)
class CoveringSemanticTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	String PATH = "org.osate.ba.tests/models/covering_semantic/";
	
	@Test
	def void test_cr_D3_C4() {
		val result = testHelper.testFile(PATH+"cr_D3_C4.aadl")
		1.assertEquals(result.issues.size)
	}
	
	@Test
	def void test_lr_D3_L1_L2() {
		val result = testHelper.testFile(PATH+"lr_D3_L1_L2.aadl")
		4.assertEquals(result.issues.size)
	}
	
	@Test
	def void test_lr_D3_L3_L4() {
		val result = testHelper.testFile(PATH+"lr_D3_L3_L4.aadl")
		2.assertEquals(result.issues.size)
	}
	
	@Test
	def void test_lr_D3_L5() {
		val result = testHelper.testFile(PATH+"lr_D3_L5.aadl")
		2.assertEquals(result.issues.size)
	}
	
	@Test
	def void test_lr_D3_L6_L7_L8() {
		val result = testHelper.testFile(PATH+"lr_D3_L6_L7_L8.aadl")
		4.assertEquals(result.issues.size)
	}
	
	@Test
	def void test_lr_D4_L1_L2() {
		val result = testHelper.testFile(PATH+"lr_D4_L1_L2.aadl")
		8.assertEquals(result.issues.size)
	}
	
	@Test
	def void test_lr_D6_L2_nr_D6_N1() {
		val result = testHelper.testFile(PATH+"lr_D6_L2_nr_D6_N1.aadl")
		0.assertEquals(result.issues.size)
	}
	
	@Test
	def void test_lr_D6_L3_L4() {
		val result = testHelper.testFile(PATH+"lr_D6_L3_L4.aadl")
		2.assertEquals(result.issues.size)
	}
	
	@Test
	def void test_lr_D6_L8() {
		val result = testHelper.testFile(PATH+"lr_D6_L8.aadl")
		1.assertEquals(result.issues.size)
	}
	
	@Test
	def void test_sr_D3_18() {
		val result = testHelper.testFile(PATH+"sr_D3_18.aadl")
		1.assertEquals(result.issues.size)
	}
	
	@Test
	def void test_sr_D4_6() {
		val result = testHelper.testFile(PATH+"sr_D4_6.aadl")
		3.assertEquals(result.issues.size)
	}
}
