/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
