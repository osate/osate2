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
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

import static extension org.junit.Assert.assertEquals
import org.osate.result.Result
import java.util.List
import java.util.ArrayList
import org.osate.result.util.ResultUtil

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class Issue2122Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper

	static val DECLARATIVE_FILE = "org.osate.analysis.flows.tests/models/Issue2122/ResponseTime.aadl"
	
	static val UNBOUND = "Top.unbound"
	static val COMPUTE_EXECUTION_TIME = "Top.CET"
	static val RESPONSE_TIME = "Top.RT"
	
	@Test
	def void unbound() {
		val pkg = testHelper.parseFile(DECLARATIVE_FILE)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == UNBOUND])

		// instantiate
		val sysImpl = cls.findFirst[name == UNBOUND] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true, false)
		
		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyresult.results.get(0), #[1.0, 0.0, 3.0, 4.0], #[2.0, 0.0, 5.0, 7.0])
		checkMinMaxValues(latencyresult.results.get(1), #[1.0, 0.0, 3.0, 4.0], #[2.0, 0.0, 5.0, 7.0])
		checkMinMaxValues(latencyresult.results.get(2), #[1.0, 0.0, 3.0, 4.0], #[2.0, 0.0, 5.0, 7.0])
	}

	@Test
	def void computeExecutionTime() {
		val pkg = testHelper.parseFile(DECLARATIVE_FILE)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == COMPUTE_EXECUTION_TIME])

		// instantiate
		val sysImpl = cls.findFirst[name == COMPUTE_EXECUTION_TIME] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true, false)
		
		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyresult.results.get(0), #[4.0, 0.0, 3.0, 7.0], #[10.0, 0.0, 6.0, 16.0])
		checkMinMaxValues(latencyresult.results.get(1), #[4.0, 0.0, 3.0, 7.0], #[10.0, 0.0, 6.0, 16.0])
		checkMinMaxValues(latencyresult.results.get(2), #[4.0, 0.0, 3.0, 7.0], #[10.0, 0.0, 6.0, 16.0])
	}

	@Test
	def void responseTime() {
		val pkg = testHelper.parseFile(DECLARATIVE_FILE)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == RESPONSE_TIME])

		// instantiate
		val sysImpl = cls.findFirst[name == RESPONSE_TIME] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true, false)
		
		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyresult.results.get(0), #[8.0, 0.0, 6.0, 14.0], #[20.0, 0.0, 12.0, 32.0])
		checkMinMaxValues(latencyresult.results.get(1), #[8.0, 0.0, 6.0, 14.0], #[20.0, 0.0, 12.0, 32.0])
		checkMinMaxValues(latencyresult.results.get(2), #[8.0, 0.0, 6.0, 14.0], #[20.0, 0.0, 12.0, 32.0])
	}

	private static def List<List<Double>> getMinMaxValues(Result result) {
		val minimums = new ArrayList<Double>()
		val maximums = new ArrayList<Double>()
		
		result.subResults.forEach[
			it.subResults.forEach[
				minimums.add(ResultUtil.getReal(it, 0))
				maximums.add(ResultUtil.getReal(it, 1))
			]
			minimums.add(ResultUtil.getReal(it, 0))
			maximums.add(ResultUtil.getReal(it, 1))
		]
		minimums.add(ResultUtil.getReal(result, 0))
		maximums.add(ResultUtil.getReal(result, 1))
		
		return #[minimums, maximums]
	}

	private static def void checkMinMaxValues(Result result, List<Double> expectedMinimums, List<Double> expectedMaximums) {
		val minMaxActual = getMinMaxValues(result)
		val actualMinimums = minMaxActual.get(0)
		val actualMaximums = minMaxActual.get(1)
		
		assertEquals(expectedMinimums.size, actualMinimums.size)
		assertEquals(expectedMaximums.size, actualMaximums.size)
		for (var i = 0; i < result.subResults.size; i++) {
			assertEquals(expectedMinimums.get(i), actualMinimums.get(i))
			assertEquals(expectedMaximums.get(i), actualMaximums.get(i))
		}
	}
}
