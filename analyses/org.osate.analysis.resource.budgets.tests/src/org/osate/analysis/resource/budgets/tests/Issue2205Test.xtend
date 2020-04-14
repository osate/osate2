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
package org.osate.analysis.resource.budgets.tests

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

import static extension org.junit.Assert.assertEquals
import org.osate.result.Result
import java.util.List
import org.osate.result.util.ResultUtil
import org.osate.analysis.resource.budgets.busload.NewBusLoadAnalysis
import org.osate.result.Diagnostic
import org.osate.result.DiagnosticType

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class Issue2205Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper

	val static PROJECT_LOCATION = "org.osate.analysis.resource.budgets.tests/models/Issue2205/"
	

	@Test
	def void testDataOverhead() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestDataOverhead.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "top.i"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check bus load
		val checker = new NewBusLoadAnalysis()
		val analysisResult = checker.invoke(null, instance)

		val somResult = analysisResult.results.get(0)
		val busResult = somResult.subResults.get(0)
		checkValues(busResult, #[768.0, 512.0, 404.0, 192.0], #[])
		checkIntegerValue(busResult, 7, 8L)
		val vb1Result = busResult.subResults.get(0)
		checkValues(vb1Result, #[512.0, 384.0, 296.0, 176.0], #[])
		checkIntegerValue(vb1Result, 7, 24L)
		val c1Result = busResult.subResults.get(1)
		checkValues(c1Result, #[20.0, 16.0], #[])
		val vb2Result = vb1Result.subResults.get(0)
		checkValues(vb2Result, #[384.0, 256.0, 192.0, 144.0], #[])
		checkIntegerValue(vb2Result, 7, 48L)
		val c2Result = vb1Result.subResults.get(1)	
		checkValues(c2Result, #[40.0, 32.0], #[])
		val vb3Result = vb2Result.subResults.get(0)
		checkValues(vb3Result, #[256.0, 128.0, 96.0, 88.0], #[])
		checkIntegerValue(vb3Result, 7, 80L)
		val c3Result = vb2Result.subResults.get(1)	
		checkValues(c3Result, #[64.0, 56.0], #[])
		val c4Result = vb3Result.subResults.get(0)	
		checkValues(c4Result, #[96.0, 88.0], #[])
	}
	
	@Test
	def void testDataOverheadSOM() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestDataOverhead_SOM.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "top.i"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check bus load
		val checker = new NewBusLoadAnalysis()
		val analysisResult = checker.invoke(null, instance)

		// SOM 1
		{
			val somResult = analysisResult.results.get(0)
			val busResult = somResult.subResults.get(0)
			checkValues(busResult, #[768.0, 512.0, 404.0, 192.0], #[])
			checkIntegerValue(busResult, 7, 8L)
			val vb1Result = busResult.subResults.get(0)
			checkValues(vb1Result, #[512.0, 384.0, 296.0, 176.0], #[])
			checkIntegerValue(vb1Result, 7, 24L)
			val c1Result = busResult.subResults.get(1)
			checkValues(c1Result, #[20.0, 16.0], #[])
			val vb2Result = vb1Result.subResults.get(0)
			checkValues(vb2Result, #[384.0, 256.0, 192.0, 144.0], #[])
			checkIntegerValue(vb2Result, 7, 48L)
			val c2Result = vb1Result.subResults.get(1)	
			checkValues(c2Result, #[40.0, 32.0], #[])
			val vb3Result = vb2Result.subResults.get(0)
			checkValues(vb3Result, #[256.0, 128.0, 96.0, 88.0], #[])
			checkIntegerValue(vb3Result, 7, 80L)
			val c3Result = vb2Result.subResults.get(1)	
			checkValues(c3Result, #[64.0, 56.0], #[])
			val c4Result = vb3Result.subResults.get(0)	
			checkValues(c4Result, #[96.0, 88.0], #[])
		}

		// SOM 2
		{
			val somResult = analysisResult.results.get(1)
			val busResult = somResult.subResults.get(0)
			checkValues(busResult, #[768.0, 512.0, 404.0, 224.0], #[])
			checkIntegerValue(busResult, 7, 8L)
			val vb1Result = busResult.subResults.get(0)
			checkValues(vb1Result, #[512.0, 384.0, 296.0, 208.0], #[])
			checkIntegerValue(vb1Result, 7, 24L)
			val c1Result = busResult.subResults.get(1)
			checkValues(c1Result, #[20.0, 16.0], #[])
			val vb2Result = vb1Result.subResults.get(0)
			checkValues(vb2Result, #[384.0, 256.0, 192.0, 176.0], #[])
			checkIntegerValue(vb2Result, 7, 48L)
			val c2Result = vb1Result.subResults.get(1)	
			checkValues(c2Result, #[40.0, 32.0], #[])
			val vb3Result = vb2Result.subResults.get(0)
			checkIntegerValue(vb3Result, 7, 112L)
			checkValues(vb3Result, #[256.0, 128.0, 96.0, 120.0], #[])
			val c3Result = vb2Result.subResults.get(1)	
			checkValues(c3Result, #[64.0, 56.0], #[])
			val c4Result = vb3Result.subResults.get(0)	
			checkValues(c4Result, #[96.0, 120.0], #[error("Connection sub1.out4 -> sub2.in4 -- Actual bandwidth > budget: 120.0 KB/s > 96.0 KB/s")])
		}

		// SOM 3
		{
			val somResult = analysisResult.results.get(2)
			val busResult = somResult.subResults.get(0)
			checkValues(busResult, #[768.0, 512.0, 404.0, 224.0], #[])
			checkIntegerValue(busResult, 7, 16L)
			val vb1Result = busResult.subResults.get(0)
			checkValues(vb1Result, #[512.0, 384.0, 296.0, 200.0], #[])
			checkIntegerValue(vb1Result, 7, 32L)
			val c1Result = busResult.subResults.get(1)
			checkValues(c1Result, #[20.0, 24.0], #[error("Connection sub1.out1 -> sub2.in1 -- Actual bandwidth > budget: 24.0 KB/s > 20.0 KB/s")])
			val vb2Result = vb1Result.subResults.get(0)
			checkValues(vb2Result, #[384.0, 256.0, 192.0, 160.0], #[])
			checkIntegerValue(vb2Result, 7, 56L)
			val c2Result = vb1Result.subResults.get(1)	
			checkValues(c2Result, #[40.0, 40.0], #[])
			val vb3Result = vb2Result.subResults.get(0)
			checkValues(vb3Result, #[256.0, 128.0, 96.0, 96.0], #[])
			checkIntegerValue(vb3Result, 7, 88L)
			val c3Result = vb2Result.subResults.get(1)	
			checkValues(c3Result, #[64.0, 64.0], #[])
			val c4Result = vb3Result.subResults.get(0)	
			checkValues(c4Result, #[96.0, 96.0], #[])
		}

		// SOM 4
		{
			val somResult = analysisResult.results.get(3)
			val busResult = somResult.subResults.get(0)
			checkValues(busResult, #[768.0, 512.0, 404.0, 256.0], #[])
			checkIntegerValue(busResult, 7, 16L)
			val vb1Result = busResult.subResults.get(0)
			checkValues(vb1Result, #[512.0, 384.0, 296.0, 232.0], #[])
			checkIntegerValue(vb1Result, 7, 32L)
			val c1Result = busResult.subResults.get(1)
			checkValues(c1Result, #[20.0, 24.0], #[error("Connection sub1.out1 -> sub2.in1 -- Actual bandwidth > budget: 24.0 KB/s > 20.0 KB/s")])
			val vb2Result = vb1Result.subResults.get(0)
			checkValues(vb2Result, #[384.0, 256.0, 192.0, 192.0], #[])
			checkIntegerValue(vb2Result, 7, 56L)
			val c2Result = vb1Result.subResults.get(1)	
			checkValues(c2Result, #[40.0, 40.0], #[])
			val vb3Result = vb2Result.subResults.get(0)
			checkValues(vb3Result, #[256.0, 128.0, 96.0, 128.0], #[])
			checkIntegerValue(vb3Result, 7, 120L)
			val c3Result = vb2Result.subResults.get(1)	
			checkValues(c3Result, #[64.0, 64.0], #[])
			val c4Result = vb3Result.subResults.get(0)	
			checkValues(c4Result, #[96.0, 128.0], #[error("Connection sub1.out4 -> sub2.in4 -- Actual bandwidth > budget: 128.0 KB/s > 96.0 KB/s")])
		}
	}

	@Test
	def void testConnections() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestConnections.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "top.i"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check bus load
		val checker = new NewBusLoadAnalysis()
		val analysisResult = checker.invoke(null, instance)

		val somResult = analysisResult.results.get(0)
		val busResult = somResult.subResults.get(0)
		checkValues(busResult, #[96.0, 64.0, 40.0, 48.0], #[])
		val c1Result = busResult.subResults.get(0)
		checkValues(c1Result, #[0.0, 8.0], #[warning("Connection sub1.out1 -> sub2.in1 has no bandwidth budget")])
		val c2Result = busResult.subResults.get(1)
		checkValues(c2Result, #[8.0, 16.0], #[error("Connection sub1.out2 -> sub2.in2 -- Actual bandwidth > budget: 16.0 KB/s > 8.0 KB/s")])
		val c3Result = busResult.subResults.get(2)
		checkValues(c3Result, #[32.0, 24.0], #[])
	}

	@Test
	def void testBus_noCapacity_noBudget() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestBusProperties.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "top.noCapacity_noBudget"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check bus load
		val checker = new NewBusLoadAnalysis()
		val analysisResult = checker.invoke(null, instance)

		val somResult = analysisResult.results.get(0)
		val busResult = somResult.subResults.get(0)
		checkValues(busResult, #[0.0, 0.0, 0.0, 8.0], #[warning("Bus theBus has no capacity"), warning("Bus theBus has no bandwidth budget")])
		val vbResult = busResult.subResults.get(0)
		checkValues(vbResult, #[0.0, 0.0, 16.0, 8.0], #[warning("Virtual bus VB1 has no capacity"), warning("Virtual bus VB1 has no bandwidth budget")])
		val c1Result = vbResult.subResults.get(0)
		checkValues(c1Result, #[16.0, 8.0], #[])
	}

	@Test
	def void testBus_noCapacity() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestBusProperties.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "top.noCapacity"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check bus load
		val checker = new NewBusLoadAnalysis()
		val analysisResult = checker.invoke(null, instance)

		val somResult = analysisResult.results.get(0)
		val busResult = somResult.subResults.get(0)
		checkValues(busResult, #[0.0, 48.0, 32.0, 8.0], #[warning("Bus theBus has no capacity"), error("Bus theBus -- budget > capacity: 48.0 KB/s > 0.0 KB/s")])
		val vbResult = busResult.subResults.get(0)
		checkValues(vbResult, #[0.0, 32.0, 16.0, 8.0], #[warning("Virtual bus VB1 has no capacity"), error("Virtual bus VB1 -- budget > capacity: 32.0 KB/s > 0.0 KB/s")])
		val c1Result = vbResult.subResults.get(0)
		checkValues(c1Result, #[16.0, 8.0], #[])
	}

	@Test
	def void testBus_noBudget() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestBusProperties.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "top.noBudget"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check bus load
		val checker = new NewBusLoadAnalysis()
		val analysisResult = checker.invoke(null, instance)

		val somResult = analysisResult.results.get(0)
		val busResult = somResult.subResults.get(0)
		checkValues(busResult, #[64.0, 0.0, 0.0, 8.0], #[warning("Bus theBus has no bandwidth budget")])
		val vbResult = busResult.subResults.get(0)
		checkValues(vbResult, #[48.0, 0.0, 16.0, 8.0], #[warning("Virtual bus VB1 has no bandwidth budget")])
		val c1Result = vbResult.subResults.get(0)
		checkValues(c1Result, #[16.0, 8.0], #[])
	}

	@Test
	def void testBus_budgetLessThanCapacity() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestBusProperties.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "top.budgetLessThanCapacity"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check bus load
		val checker = new NewBusLoadAnalysis()
		val analysisResult = checker.invoke(null, instance)

		val somResult = analysisResult.results.get(0)
		val busResult = somResult.subResults.get(0)
		checkValues(busResult, #[64.0, 48.0, 32.0, 8.0], #[])
		val vbResult = busResult.subResults.get(0)
		checkValues(vbResult, #[48.0, 32.0, 16.0, 8.0], #[])
		val c1Result = vbResult.subResults.get(0)
		checkValues(c1Result, #[16.0, 8.0], #[])
	}

	@Test
	def void testBus_budgetGreaterThanCapacity() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestBusProperties.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "top.budgetGreaterThanCapacity"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check bus load
		val checker = new NewBusLoadAnalysis()
		val analysisResult = checker.invoke(null, instance)

		val somResult = analysisResult.results.get(0)
		val busResult = somResult.subResults.get(0)
		checkValues(busResult, #[48.0, 56.0, 32.0, 8.0], #[error("Bus theBus -- budget > capacity: 56.0 KB/s > 48.0 KB/s")])
		val vbResult = busResult.subResults.get(0)
		checkValues(vbResult, #[24.0, 32.0, 16.0, 8.0], #[error("Virtual bus VB1 -- budget > capacity: 32.0 KB/s > 24.0 KB/s")])
		val c1Result = vbResult.subResults.get(0)
		checkValues(c1Result, #[16.0, 8.0], #[])
	}

	@Test
	def void testCalculations_actualGreaterThanCapacity() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestCalculations.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "top.actualGreaterThanCapacity"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check bus load
		val checker = new NewBusLoadAnalysis()
		val analysisResult = checker.invoke(null, instance)

		val somResult = analysisResult.results.get(0)
		val busResult = somResult.subResults.get(0)
		checkValues(busResult, #[16.0, 16.0, 24.0, 24.0], #[error("Bus theBus -- Actual bandwidth > capacity: 24.0 KB/s > 16.0 KB/s"), error("Bus theBus -- Required budget > budget: 24.0 KB/s > 16.0 KB/s")])
		val vbResult = busResult.subResults.get(0)
		checkValues(vbResult, #[12.0, 12.0, 24.0, 16.0], #[error("Virtual bus vb1 -- Actual bandwidth > capacity: 16.0 KB/s > 12.0 KB/s"), error("Virtual bus vb1 -- Required budget > budget: 24.0 KB/s > 12.0 KB/s")])
		val c3Result = busResult.subResults.get(1)
		checkValues(c3Result, #[12.0, 8.0], #[])
		val c1Result = vbResult.subResults.get(0)
		checkValues(c1Result, #[12.0, 8.0], #[])
		val c2Result = vbResult.subResults.get(1)
		checkValues(c2Result, #[12.0, 8.0], #[])
	}

	@Test
	def void testCalculations_requiredBudgetGreaterThanBudget() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestCalculations.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "top.requiredBudgetGreaterThanBudget"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check bus load
		val checker = new NewBusLoadAnalysis()
		val analysisResult = checker.invoke(null, instance)

		val somResult = analysisResult.results.get(0)
		val busResult = somResult.subResults.get(0)
		checkValues(busResult, #[64.0, 24.0, 28.0, 24.0], #[error("Bus theBus -- Required budget > budget: 28.0 KB/s > 24.0 KB/s")])
		val vbResult = busResult.subResults.get(0)
		checkValues(vbResult, #[48.0, 16.0, 24.0, 16.0], #[error("Virtual bus vb1 -- Required budget > budget: 24.0 KB/s > 16.0 KB/s")])
		val c3Result = busResult.subResults.get(1)
		checkValues(c3Result, #[12.0, 8.0], #[])
		val c1Result = vbResult.subResults.get(0)
		checkValues(c1Result, #[12.0, 8.0], #[])
		val c2Result = vbResult.subResults.get(1)
		checkValues(c2Result, #[12.0, 8.0], #[])
	}

	@Test
	def void testCalculations_requiredBudgetLessThanBudget() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestCalculations.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "top.requiredBudgetLessThanBudget"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check bus load
		val checker = new NewBusLoadAnalysis()
		val analysisResult = checker.invoke(null, instance)

		val somResult = analysisResult.results.get(0)
		val busResult = somResult.subResults.get(0)
		checkValues(busResult, #[64.0, 48.0, 44.0, 24.0], #[])
		val vbResult = busResult.subResults.get(0)
		checkValues(vbResult, #[48.0, 32.0, 24.0, 16.0], #[])
		val c3Result = busResult.subResults.get(1)
		checkValues(c3Result, #[12.0, 8.0], #[])
		val c1Result = vbResult.subResults.get(0)
		checkValues(c1Result, #[12.0, 8.0], #[])
		val c2Result = vbResult.subResults.get(1)
		checkValues(c2Result, #[12.0, 8.0], #[])
	}

	@Test
	def void testBroadcast() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestBroadcast.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "top.i"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check bus load
		val checker = new NewBusLoadAnalysis()
		val analysisResult = checker.invoke(null, instance)

		val somResult = analysisResult.results.get(0)
		{
			val noBroadcastBusResult = somResult.subResults.get(0)
			checkValues(noBroadcastBusResult, #[96.0, 64.0, 32.0, 32.0], #[])
			val c1Result = noBroadcastBusResult.subResults.get(0)
			checkValues(c1Result, #[8.0, 8.0], #[])
			val c2Result = noBroadcastBusResult.subResults.get(1)
			checkValues(c2Result, #[8.0, 8.0], #[])
			val c3Result = noBroadcastBusResult.subResults.get(2)
			checkValues(c3Result, #[8.0, 8.0], #[])
			val c4Result = noBroadcastBusResult.subResults.get(3)
			checkValues(c4Result, #[8.0, 8.0], #[])
		}		
		{
			val broadcastBusResult = somResult.subResults.get(1)
			checkValues(broadcastBusResult, #[96.0, 64.0, 16.0, 16.0], #[])
			val c1Result = broadcastBusResult.subResults.get(0)
			checkValues(c1Result, #[8.0, 8.0], #[])
			val broadcastResult = broadcastBusResult.subResults.get(1)
			checkValues(broadcastResult, #[8.0, 8.0], #[])
			val c2Result = broadcastResult.subResults.get(0)
			checkValues(c2Result, #[8.0, 8.0], #[])
			val c3Result = broadcastResult.subResults.get(1)
			checkValues(c3Result, #[8.0, 8.0], #[])
			val c4Result = broadcastResult.subResults.get(2)
			checkValues(c4Result, #[8.0, 8.0], #[])
		}		
	}

	@Test
	def void testBiggerBroadcast() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestBiggerBroadcast.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "top.i"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check bus load
		val checker = new NewBusLoadAnalysis()
		val analysisResult = checker.invoke(null, instance)

		val somResult = analysisResult.results.get(0)
		{
			val noBroadcastBusResult = somResult.subResults.get(0)
			checkValues(noBroadcastBusResult, #[96.0, 64.0, 24.0, 24.0], #[])
			val c1Result = noBroadcastBusResult.subResults.get(0)
			checkValues(c1Result, #[8.0, 8.0], #[])
			val c2Result = noBroadcastBusResult.subResults.get(1)
			checkValues(c2Result, #[8.0, 8.0], #[])
			val c3Result = noBroadcastBusResult.subResults.get(2)
			checkValues(c3Result, #[8.0, 8.0], #[])
		}		
		{
			val broadcastBusResult = somResult.subResults.get(1)
			checkValues(broadcastBusResult, #[96.0, 64.0, 24.0, 24.0], #[])
			val broadcast1Result = broadcastBusResult.subResults.get(0)
			checkValues(broadcast1Result, #[8.0, 8.0], #[])
			{
				val c1Result = broadcast1Result.subResults.get(0)
				checkValues(c1Result, #[8.0, 8.0], #[])
				val c2Result = broadcast1Result.subResults.get(1)
				checkValues(c2Result, #[8.0, 8.0], #[])
				val c3Result = broadcast1Result.subResults.get(2)
				checkValues(c3Result, #[8.0, 8.0], #[])
			}
			val broadcast2Result = broadcastBusResult.subResults.get(1)
			checkValues(broadcast2Result, #[8.0, 8.0], #[])
			{
				val c1Result = broadcast2Result.subResults.get(0)
				checkValues(c1Result, #[8.0, 8.0], #[])
				val c2Result = broadcast2Result.subResults.get(1)
				checkValues(c2Result, #[8.0, 8.0], #[])
				val c3Result = broadcast2Result.subResults.get(2)
				checkValues(c3Result, #[8.0, 8.0], #[])
			}
			val broadcast3Result = broadcastBusResult.subResults.get(2)
			checkValues(broadcast3Result, #[8.0, 8.0], #[])
			{
				val c1Result = broadcast3Result.subResults.get(0)
				checkValues(c1Result, #[8.0, 8.0], #[])
				val c2Result = broadcast3Result.subResults.get(1)
				checkValues(c2Result, #[8.0, 8.0], #[])
				val c3Result = broadcast3Result.subResults.get(2)
				checkValues(c3Result, #[8.0, 8.0], #[])
			}
		}		
	}

	@Test
	def void testBiggerBroadcastWarnings() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestBiggerBroadcast_warnings.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "top.i"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check bus load
		val checker = new NewBusLoadAnalysis()
		val analysisResult = checker.invoke(null, instance)

		val somResult = analysisResult.results.get(0)
		{
			val noBroadcastBusResult = somResult.subResults.get(0)
			checkValues(noBroadcastBusResult, #[96.0, 64.0, 24.0, 24.0], #[])
			val c1Result = noBroadcastBusResult.subResults.get(0)
			checkValues(c1Result, #[8.0, 8.0], #[])
			val c2Result = noBroadcastBusResult.subResults.get(1)
			checkValues(c2Result, #[8.0, 8.0], #[])
			val c3Result = noBroadcastBusResult.subResults.get(2)
			checkValues(c3Result, #[8.0, 8.0], #[])
		}		
		{
			val broadcastBusResult = somResult.subResults.get(1)
			checkValues(broadcastBusResult, #[96.0, 64.0, 40.0, 24.0], #[])
			val broadcast1Result = broadcastBusResult.subResults.get(0)
			checkValues(broadcast1Result, #[8.0, 8.0], #[])
			{
				val c1Result = broadcast1Result.subResults.get(0)
				checkValues(c1Result, #[8.0, 8.0], #[])
				val c2Result = broadcast1Result.subResults.get(1)
				checkValues(c2Result, #[8.0, 8.0], #[])
				val c3Result = broadcast1Result.subResults.get(2)
				checkValues(c3Result, #[8.0, 8.0], #[])
			}
			val broadcast2Result = broadcastBusResult.subResults.get(1)
			checkValues(broadcast2Result, #[8.0, 8.0], #[])
			{
				val c1Result = broadcast2Result.subResults.get(0)
				checkValues(c1Result, #[8.0, 8.0], #[])
				val c2Result = broadcast2Result.subResults.get(1)
				checkValues(c2Result, #[8.0, 8.0], #[])
				val c3Result = broadcast2Result.subResults.get(2)
				checkValues(c3Result, #[8.0, 8.0], #[])
			}
			val broadcast3Result = broadcastBusResult.subResults.get(2)
			checkValues(broadcast3Result, #[24.0, 8.0], #[warning("Connection sub3c.out1 -> sub4a.in3 sharing broadcast source top_i_Instance.sub3c.out1 has budget 8.0 KB/s; using maximum"), warning("Connection sub3c.out1 -> sub4b.in3 sharing broadcast source top_i_Instance.sub3c.out1 has budget 16.0 KB/s; using maximum"), warning("Connection sub3c.out1 -> sub4c.in3 sharing broadcast source top_i_Instance.sub3c.out1 has budget 24.0 KB/s; using maximum")])
			{
				val c1Result = broadcast3Result.subResults.get(0)
				checkValues(c1Result, #[8.0, 8.0], #[])
				val c2Result = broadcast3Result.subResults.get(1)
				checkValues(c2Result, #[16.0, 8.0], #[])
				val c3Result = broadcast3Result.subResults.get(2)
				checkValues(c3Result, #[24.0, 8.0], #[])
			}
		}		
	}

	@Test
	def void testComplicated() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "Complicated.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "top.i"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check bus load
		val checker = new NewBusLoadAnalysis()
		val analysisResult = checker.invoke(null, instance)

		val somResult = analysisResult.results.get(0)
		val busResult = somResult.subResults.get(0)
		checkValues(busResult, #[128.0, 128.0, 120.0, 128.0], #[])
		val vb4Result = busResult.subResults.get(0)
		checkValues(vb4Result, #[8.0, 8.0, 12.0, 16.0], #[error("Virtual bus vb4 -- Actual bandwidth > capacity: 16.0 KB/s > 8.0 KB/s"), error("Virtual bus vb4 -- Required budget > budget: 12.0 KB/s > 8.0 KB/s")])
		val vb3Result = busResult.subResults.get(1)
		checkValues(vb3Result, #[64.0, 64.0, 56.0, 64.0], #[])
		val c8Result = busResult.subResults.get(2)
		checkValues(c8Result, #[24.0, 24.0], #[])
		val c9Result = busResult.subResults.get(3)
		checkValues(c9Result, #[24.0, 24.0], #[])
		
		val c6Result = vb4Result.subResults.get(0)
		checkValues(c6Result, #[4.0, 8.0], #[error("Connection sub1.out6 -> sub2.in6 -- Actual bandwidth > budget: 8.0 KB/s > 4.0 KB/s")])
		val c7Result = vb4Result.subResults.get(1)
		checkValues(c7Result, #[8.0, 8.0], #[])
		
		val vb1Result = vb3Result.subResults.get(0)
		checkValues(vb1Result, #[16.0, 16.0, 16.0, 16.0], #[])
		val vb2Result = vb3Result.subResults.get(1)
		checkValues(vb2Result, #[16.0, 16.0, 24.0, 24.0], #[error("Virtual bus vb2 -- Actual bandwidth > capacity: 24.0 KB/s > 16.0 KB/s"), error("Virtual bus vb2 -- Required budget > budget: 24.0 KB/s > 16.0 KB/s")])
		val c5Result = vb3Result.subResults.get(2)
		checkValues(c5Result, #[24.0, 24.0], #[])

		val c1Result = vb1Result.subResults.get(0)
		checkValues(c1Result, #[8.0, 8.0], #[])
		val c2Result = vb1Result.subResults.get(1)
		checkValues(c2Result, #[8.0, 8.0], #[])

		val c3Result = vb2Result.subResults.get(0)
		checkValues(c3Result, #[8.0, 8.0], #[])
		val c4Result = vb2Result.subResults.get(1)
		checkValues(c4Result, #[16.0, 16.0], #[])
	}

	private static def List<Object> error(String msg) {
		return #[DiagnosticType.ERROR, msg]
	}
	
	private static def List<Object> warning(String msg) {
		return #[DiagnosticType.WARNING, msg]
	}
	
	private static def void checkDiagnostic(Diagnostic d, DiagnosticType type, String msg) {
		assertEquals(type, d.diagnosticType)
		assertEquals(msg, d.message)
	}

	private static def void checkValues(Result result, List<Double> values, List<List<Object>> diagnostics) {
		for (var i = 0; i < values.size; i++) {
			val expected = values.get(i)
			val actual = ResultUtil.getReal(result, i)
			assertEquals(expected, actual, 0.0)
		}
		
		assertEquals(diagnostics.size, result.diagnostics.size)
		for (var i = 0; i < diagnostics.size; i++) {
			val expected = diagnostics.get(i)
			checkDiagnostic(result.diagnostics.get(i), expected.get(0) as DiagnosticType, expected.get(1) as String)
		}
	}
	
	private static def void checkIntegerValue(Result result, int idx, long expected) {
		val actual = ResultUtil.getInteger(result, idx)
		assertEquals(expected, actual)
	}
}
