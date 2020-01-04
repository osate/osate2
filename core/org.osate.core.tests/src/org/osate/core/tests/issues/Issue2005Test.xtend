package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import org.osate.aadl2.instantiation.InstantiateModel
import static extension org.junit.Assert.*
import com.itemis.xtext.testing.XtextTest
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instance.SystemOperationMode
import java.util.List
import org.osate.aadl2.instance.EndToEndFlowInstance

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2005Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue2005/"

	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void testPkg1() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "pkg1.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "top.i"] as SystemImplementation
		
		val instance = InstantiateModel.instantiate(sysImpl)
		
		// SHould be 12 system operation modes
		val soms = instance.systemOperationModes
		assertEquals(12, soms.size)
		
		// SHould be 12 end to end flows
		assertEquals(12, instance.endToEndFlows.size)
		testETEF(soms, instance.endToEndFlows.get(0), #[3, 7])
		testETEF(soms, instance.endToEndFlows.get(1), #[3])
		testETEF(soms, instance.endToEndFlows.get(2), #[7])

		testETEF(soms, instance.endToEndFlows.get(3), #[8, 8])
		testETEF(soms, instance.endToEndFlows.get(4), #[4])
		testETEF(soms, instance.endToEndFlows.get(5), #[8])

		testETEF(soms, instance.endToEndFlows.get(6), #[5, 9])
		testETEF(soms, instance.endToEndFlows.get(7), #[5])
		testETEF(soms, instance.endToEndFlows.get(8), #[9])

		testETEF(soms, instance.endToEndFlows.get(9), #[6, 10])
		testETEF(soms, instance.endToEndFlows.get(10), #[6])
		testETEF(soms, instance.endToEndFlows.get(11), #[10])
	}

	def private static void testETEF(List<SystemOperationMode> soms, EndToEndFlowInstance etef, List<Integer> somIdxs) {
		val inSOMs = etef.inSystemOperationModes
		assertEquals(somIdxs.size, inSOMs.size)
		for (int i : somIdxs) {
			assertTrue(inSOMs.contains(getSOM(soms, i)))
		}
	}

	@Test
	def void testPkg2() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "pkg2.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "top.i"] as SystemImplementation
		
		val instance = InstantiateModel.instantiate(sysImpl)
		
		// SHould be 16 system operation modes
		val soms = instance.systemOperationModes
		assertEquals(16, soms.size)
		
		// Check the modes of the 1 end to end flow
		assertEquals(1, instance.endToEndFlows.size)
		val etef10 = instance.endToEndFlows.get(0)
		
		// Should be { som4, som8, som12, som16 }
		val inSOMs = etef10.inSystemOperationModes
		assertEquals(4, inSOMs.size)
		assertTrue(inSOMs.contains(getSOM(soms, 4)))
		assertTrue(inSOMs.contains(getSOM(soms, 8)))
		assertTrue(inSOMs.contains(getSOM(soms, 12)))
		assertTrue(inSOMs.contains(getSOM(soms, 16)))
	}

	def private static getSOM(List<SystemOperationMode> soms, int idx) {
		soms.get(idx - 1)
	}
}
