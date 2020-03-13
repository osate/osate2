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
class Issue1148Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper

	static val DECLARATIVE_FILE = "org.osate.analysis.flows.tests/models/Issue1148/QueuingLatency.aadl"
	
	static val SIMPLE_PERIODIC = "Top.simple_periodic"
	static val SIMPLE_ASYNC = "Top.simple_async"
	static val PERIODIC_OVERHEAD = "Top.periodic_overhead"
	static val ASYNC_OVERHEAD = "Top.async_overhead"
	static val VB_BOUND_PERIODIC = "Top.vb_bound_periodic"
	static val VB_BOUND_ASYNC = "Top.vb_bound_async"
	static val VB_REQUIRED_PERIODIC = "Top.vb_required_periodic"
	static val VB_REQUIRED_ASYNC = "Top.vb_required_async"
	
	@Test
	def void simplePeriodic() {
		val pkg = testHelper.parseFile(DECLARATIVE_FILE)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == SIMPLE_PERIODIC])

		// instantiate
		val sysImpl = cls.findFirst[name == SIMPLE_PERIODIC] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true, false)
		
		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyresult.results.get(0), #[1.0, 0.0, 0.0, 17.0, 0.0, 3.0, 21.0], #[2.0, 5.0, 0.0, 26.0, 0.0, 5.0, 38.0])
		checkMinMaxValues(latencyresult.results.get(1), #[1.0, 0.0, 0.0, 33.0, 0.0, 3.0, 37.0], #[2.0, 5.0, 0.0, 50.0, 0.0, 5.0, 62.0])
		checkMinMaxValues(latencyresult.results.get(2), #[1.0, 0.0, 0.0, 49.0, 0.0, 3.0, 53.0], #[2.0, 5.0, 0.0, 74.0, 0.0, 5.0, 86.0])
	}
	
	@Test
	def void simpleAsync() {
		val pkg = testHelper.parseFile(DECLARATIVE_FILE)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == SIMPLE_ASYNC])

		// instantiate
		val sysImpl = cls.findFirst[name == SIMPLE_ASYNC] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true, false)
		
		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyresult.results.get(0), #[1.0, 17.0, 0.0, 0.0, 0.0, 3.0, 21.0], #[2.0, 26.0, 124.0, 0.0, 0.0, 5.0, 157.0])
		checkMinMaxValues(latencyresult.results.get(1), #[1.0, 33.0, 0.0, 0.0, 0.0, 3.0, 37.0], #[2.0, 50.0, 100.0, 0.0, 0.0, 5.0, 157.0])
		checkMinMaxValues(latencyresult.results.get(2), #[1.0, 49.0, 0.0, 0.0, 0.0, 3.0, 53.0], #[2.0, 74.0, 76.0, 0.0, 0.0, 5.0, 157.0])
	}
	
	@Test
	def void periodicOverhead() {
		val pkg = testHelper.parseFile(DECLARATIVE_FILE)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == PERIODIC_OVERHEAD])

		// instantiate
		val sysImpl = cls.findFirst[name == PERIODIC_OVERHEAD] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true, false)
		
		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyresult.results.get(0), #[1.0, 0.0, 0.0, 21.0, 0.0, 3.0, 25.0], #[2.0, 5.0, 0.0, 32.0, 0.0, 5.0, 44.0])
		checkMinMaxValues(latencyresult.results.get(1), #[1.0, 0.0, 0.0, 37.0, 0.0, 3.0, 41.0], #[2.0, 5.0, 0.0, 56.0, 0.0, 5.0, 68.0])
		checkMinMaxValues(latencyresult.results.get(2), #[1.0, 0.0, 0.0, 53.0, 0.0, 3.0, 57.0], #[2.0, 5.0, 0.0, 80.0, 0.0, 5.0, 92.0])
	}
	
	@Test
	def void asyncOverhead() {
		val pkg = testHelper.parseFile(DECLARATIVE_FILE)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == ASYNC_OVERHEAD])

		// instantiate
		val sysImpl = cls.findFirst[name == ASYNC_OVERHEAD] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true, false)
		
		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyresult.results.get(0), #[1.0, 21.0, 0.0, 0.0, 0.0, 3.0, 25.0], #[2.0, 32.0, 136.0, 0.0, 0.0, 5.0, 175.0])
		checkMinMaxValues(latencyresult.results.get(1), #[1.0, 37.0, 0.0, 0.0, 0.0, 3.0, 41.0], #[2.0, 56.0, 112.0, 0.0, 0.0, 5.0, 175.0])
		checkMinMaxValues(latencyresult.results.get(2), #[1.0, 53.0, 0.0, 0.0, 0.0, 3.0, 57.0], #[2.0, 80.0, 88.0, 0.0, 0.0, 5.0, 175.0])
	}
	
	@Test
	def void vbBoundPeriodic() {
		val pkg = testHelper.parseFile(DECLARATIVE_FILE)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == VB_BOUND_PERIODIC])

		// instantiate
		val sysImpl = cls.findFirst[name == VB_BOUND_PERIODIC] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true, false)
		
		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyresult.results.get(0), #[1.0, 0.0, 0.0, 41.0, 0.0, 0.0, 0.0, 3.0, 45.0], #[2.0, 5.0, 0.0, 62.0, 0.0, 0.0, 0.0, 5.0, 74.0])
		checkMinMaxValues(latencyresult.results.get(1), #[1.0, 0.0, 0.0, 57.0, 0.0, 0.0, 0.0, 3.0, 61.0], #[2.0, 5.0, 0.0, 86.0, 0.0, 0.0, 0.0, 5.0, 98.0])
		checkMinMaxValues(latencyresult.results.get(2), #[1.0, 0.0, 0.0, 73.0, 0.0, 0.0, 0.0, 3.0, 77.0], #[2.0, 5.0, 0.0, 110.0, 0.0, 0.0, 0.0, 5.0, 122.0])
	}
	
	@Test
	def void vbBoundAsync() {
		val pkg = testHelper.parseFile(DECLARATIVE_FILE)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == VB_BOUND_ASYNC])

		// instantiate
		val sysImpl = cls.findFirst[name == VB_BOUND_ASYNC] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true, false)
		
		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyresult.results.get(0), #[1.0, 41.0, 0.0, 0.0, 0.0, 0.0, 0.0, 3.0, 45.0], #[2.0, 62.0, 0.0, 0.0, 196.0, 0.0, 0.0, 5.0, 265.0])
		checkMinMaxValues(latencyresult.results.get(1), #[1.0, 57.0, 0.0, 0.0, 0.0, 0.0, 0.0, 3.0, 61.0], #[2.0, 86.0, 0.0, 0.0, 172.0, 0.0, 0.0, 5.0, 265.0])
		checkMinMaxValues(latencyresult.results.get(2), #[1.0, 73.0, 0.0, 0.0, 0.0, 0.0, 0.0, 3.0, 77.0], #[2.0, 110.0, 0.0, 0.0, 148.0, 0.0, 0.0, 5.0, 265.0])
	}
	
	@Test
	def void vbRequiredPeriodic() {
		val pkg = testHelper.parseFile(DECLARATIVE_FILE)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == VB_REQUIRED_PERIODIC])

		// instantiate
		val sysImpl = cls.findFirst[name == VB_REQUIRED_PERIODIC] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true, false)
		
		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyresult.results.get(0), #[1.0, 0.0, 0.0, 41.0, 0.0, 3.0, 45.0], #[2.0, 5.0, 0.0, 62.0, 0.0, 5.0, 74.0])
		checkMinMaxValues(latencyresult.results.get(1), #[1.0, 0.0, 0.0, 57.0, 0.0, 3.0, 61.0], #[2.0, 5.0, 0.0, 86.0, 0.0, 5.0, 98.0])
		checkMinMaxValues(latencyresult.results.get(2), #[1.0, 0.0, 0.0, 73.0, 0.0, 3.0, 77.0], #[2.0, 5.0, 0.0, 110.0, 0.0, 5.0, 122.0])
	}
	
	@Test
	def void vbRequiredAsync() {
		val pkg = testHelper.parseFile(DECLARATIVE_FILE)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == VB_REQUIRED_ASYNC])

		// instantiate
		val sysImpl = cls.findFirst[name == VB_REQUIRED_ASYNC] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check flow latency
		val som = instance.systemOperationModes.head
		val checker = new FlowLatencyAnalysisSwitch()
		val latencyresult = checker.invoke(instance, som,true,true,true,true, false)
		
		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyresult.results.get(0), #[1.0, 41.0, 0.0, 0.0, 0.0, 3.0, 45.0], #[2.0, 62.0, 196.0, 0.0, 0.0, 5.0, 265.0])
		checkMinMaxValues(latencyresult.results.get(1), #[1.0, 57.0, 0.0, 0.0, 0.0, 3.0, 61.0], #[2.0, 86.0, 172.0, 0.0, 0.0, 5.0, 265.0])
		checkMinMaxValues(latencyresult.results.get(2), #[1.0, 73.0, 0.0, 0.0, 0.0, 3.0, 77.0], #[2.0, 110.0, 148.0, 0.0, 0.0, 5.0, 265.0])
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
