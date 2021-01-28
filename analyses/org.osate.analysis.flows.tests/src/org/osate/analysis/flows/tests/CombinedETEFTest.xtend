/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.analysis.flows.tests

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.result.RealValue
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

import static extension org.junit.Assert.assertEquals
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class CombinedETEFTest extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper

	val projectprefix = "org.osate.analysis.flows.tests/models/latencytest/"

	val combinedETEFText = "CombinedETEF.aadl"
	
	@Test
	def void flows_combinedETEFs() {

		val pkg = testHelper.parseFile(projectprefix+combinedETEFText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 'Test.Impl'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'Test.Impl'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals("Test_Impl_Instance", instance.name)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true, false)
		val resab = latencyresult.results.get(0)
		assertTrue((resab.values.get(1) as RealValue).value == (20.0))
		assertTrue((resab.values.get(2) as RealValue).value == (20.0))
		assertTrue((resab.values.get(3) as RealValue).value == (20.0))
		assertTrue((resab.values.get(4) as RealValue).value == (20.0))
		assertTrue((resab.values.get(5) as RealValue).value == (0.0))
		assertTrue((resab.values.get(6) as RealValue).value == (0.0))
		resab.subResults.size.assertEquals(3)
		resab.diagnostics.size.assertEquals(1)

		val rescd = latencyresult.results.get(1)
		assertTrue((rescd.values.get(1) as RealValue).value == (20.0))
		assertTrue((rescd.values.get(2) as RealValue).value == (20.0))
		assertTrue((rescd.values.get(3) as RealValue).value == (20.0))
		assertTrue((rescd.values.get(4) as RealValue).value == (20.0))
		assertTrue((rescd.values.get(5) as RealValue).value == (0.0))
		assertTrue((rescd.values.get(6) as RealValue).value == (0.0))
		rescd.subResults.size.assertEquals(3)
		rescd.diagnostics.size.assertEquals(1)

		val restotal = latencyresult.results.get(2)
		assertTrue((restotal.values.get(1) as RealValue).value == (40.0))
		assertTrue((restotal.values.get(2) as RealValue).value == (40.0))
		assertTrue((restotal.values.get(3) as RealValue).value == (40.0))
		assertTrue((restotal.values.get(4) as RealValue).value == (40.0))
		assertTrue((restotal.values.get(5) as RealValue).value == (20.0))
		assertTrue((restotal.values.get(6) as RealValue).value == (30.0))
		restotal.subResults.size.assertEquals(7)
		restotal.diagnostics.size.assertEquals(4)

	}

}
