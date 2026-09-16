/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.analysis.resource.budgets.tests;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.analysis.resource.budgets.busload.NewBusLoadAnalysis;
import org.osate.result.AnalysisResult;
import org.osate.result.DiagnosticType;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2205Test extends XtextTest {

	private static final String PROJECT_LOCATION = "org.osate.analysis.resource.budgets.tests/models/Issue2205/";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testDataOverhead() throws Exception {
		var analysisResult = analyzeBusLoad("TestDataOverhead.aadl", "top.i");

		var somResult = analysisResult.getResults().get(0);
		var busResult = somResult.getSubResults().get(0);
		checkValues(busResult, List.of(768.0, 512.0, 404.0, 192.0), List.of());
		checkIntegerValue(busResult, 7, 8L);
		var vb1Result = busResult.getSubResults().get(0);
		checkValues(vb1Result, List.of(512.0, 384.0, 296.0, 176.0), List.of());
		checkIntegerValue(vb1Result, 7, 24L);
		var c1Result = busResult.getSubResults().get(1);
		checkValues(c1Result, List.of(20.0, 16.0), List.of());
		var vb2Result = vb1Result.getSubResults().get(0);
		checkValues(vb2Result, List.of(384.0, 256.0, 192.0, 144.0), List.of());
		checkIntegerValue(vb2Result, 7, 48L);
		var c2Result = vb1Result.getSubResults().get(1);
		checkValues(c2Result, List.of(40.0, 32.0), List.of());
		var vb3Result = vb2Result.getSubResults().get(0);
		checkValues(vb3Result, List.of(256.0, 128.0, 96.0, 88.0), List.of());
		checkIntegerValue(vb3Result, 7, 80L);
		var c3Result = vb2Result.getSubResults().get(1);
		checkValues(c3Result, List.of(64.0, 56.0), List.of());
		var c4Result = vb3Result.getSubResults().get(0);
		checkValues(c4Result, List.of(96.0, 88.0), List.of());
	}

	@Test
	public void testDataOverheadSOM() throws Exception {
		var analysisResult = analyzeBusLoad("TestDataOverhead_SOM.aadl", "top.i");

		// SOM 1
		{
			var somResult = analysisResult.getResults().get(0);
			var busResult = somResult.getSubResults().get(0);
			checkValues(busResult, List.of(768.0, 512.0, 404.0, 192.0), List.of());
			checkIntegerValue(busResult, 7, 8L);
			var vb1Result = busResult.getSubResults().get(0);
			checkValues(vb1Result, List.of(512.0, 384.0, 296.0, 176.0), List.of());
			checkIntegerValue(vb1Result, 7, 24L);
			var c1Result = busResult.getSubResults().get(1);
			checkValues(c1Result, List.of(20.0, 16.0), List.of());
			var vb2Result = vb1Result.getSubResults().get(0);
			checkValues(vb2Result, List.of(384.0, 256.0, 192.0, 144.0), List.of());
			checkIntegerValue(vb2Result, 7, 48L);
			var c2Result = vb1Result.getSubResults().get(1);
			checkValues(c2Result, List.of(40.0, 32.0), List.of());
			var vb3Result = vb2Result.getSubResults().get(0);
			checkValues(vb3Result, List.of(256.0, 128.0, 96.0, 88.0), List.of());
			checkIntegerValue(vb3Result, 7, 80L);
			var c3Result = vb2Result.getSubResults().get(1);
			checkValues(c3Result, List.of(64.0, 56.0), List.of());
			var c4Result = vb3Result.getSubResults().get(0);
			checkValues(c4Result, List.of(96.0, 88.0), List.of());
		}

		// SOM 2
		{
			var somResult = analysisResult.getResults().get(1);
			var busResult = somResult.getSubResults().get(0);
			checkValues(busResult, List.of(768.0, 512.0, 404.0, 224.0), List.of());
			checkIntegerValue(busResult, 7, 8L);
			var vb1Result = busResult.getSubResults().get(0);
			checkValues(vb1Result, List.of(512.0, 384.0, 296.0, 208.0), List.of());
			checkIntegerValue(vb1Result, 7, 24L);
			var c1Result = busResult.getSubResults().get(1);
			checkValues(c1Result, List.of(20.0, 16.0), List.of());
			var vb2Result = vb1Result.getSubResults().get(0);
			checkValues(vb2Result, List.of(384.0, 256.0, 192.0, 176.0), List.of());
			checkIntegerValue(vb2Result, 7, 48L);
			var c2Result = vb1Result.getSubResults().get(1);
			checkValues(c2Result, List.of(40.0, 32.0), List.of());
			var vb3Result = vb2Result.getSubResults().get(0);
			checkIntegerValue(vb3Result, 7, 112L);
			checkValues(vb3Result, List.of(256.0, 128.0, 96.0, 120.0), List.of());
			var c3Result = vb2Result.getSubResults().get(1);
			checkValues(c3Result, List.of(64.0, 56.0), List.of());
			var c4Result = vb3Result.getSubResults().get(0);
			checkValues(c4Result, List.of(96.0, 120.0), List.of(error(
					"Connection sub1.out4 -> sub2.in4 -- Actual bandwidth > budget: 120.0 KB/s > 96.0 KB/s")));
		}

		// SOM 3
		{
			var somResult = analysisResult.getResults().get(2);
			var busResult = somResult.getSubResults().get(0);
			checkValues(busResult, List.of(768.0, 512.0, 404.0, 224.0), List.of());
			checkIntegerValue(busResult, 7, 16L);
			var vb1Result = busResult.getSubResults().get(0);
			checkValues(vb1Result, List.of(512.0, 384.0, 296.0, 200.0), List.of());
			checkIntegerValue(vb1Result, 7, 32L);
			var c1Result = busResult.getSubResults().get(1);
			checkValues(c1Result, List.of(20.0, 24.0), List.of(error(
					"Connection sub1.out1 -> sub2.in1 -- Actual bandwidth > budget: 24.0 KB/s > 20.0 KB/s")));
			var vb2Result = vb1Result.getSubResults().get(0);
			checkValues(vb2Result, List.of(384.0, 256.0, 192.0, 160.0), List.of());
			checkIntegerValue(vb2Result, 7, 56L);
			var c2Result = vb1Result.getSubResults().get(1);
			checkValues(c2Result, List.of(40.0, 40.0), List.of());
			var vb3Result = vb2Result.getSubResults().get(0);
			checkValues(vb3Result, List.of(256.0, 128.0, 96.0, 96.0), List.of());
			checkIntegerValue(vb3Result, 7, 88L);
			var c3Result = vb2Result.getSubResults().get(1);
			checkValues(c3Result, List.of(64.0, 64.0), List.of());
			var c4Result = vb3Result.getSubResults().get(0);
			checkValues(c4Result, List.of(96.0, 96.0), List.of());
		}

		// SOM 4
		{
			var somResult = analysisResult.getResults().get(3);
			var busResult = somResult.getSubResults().get(0);
			checkValues(busResult, List.of(768.0, 512.0, 404.0, 256.0), List.of());
			checkIntegerValue(busResult, 7, 16L);
			var vb1Result = busResult.getSubResults().get(0);
			checkValues(vb1Result, List.of(512.0, 384.0, 296.0, 232.0), List.of());
			checkIntegerValue(vb1Result, 7, 32L);
			var c1Result = busResult.getSubResults().get(1);
			checkValues(c1Result, List.of(20.0, 24.0), List.of(error(
					"Connection sub1.out1 -> sub2.in1 -- Actual bandwidth > budget: 24.0 KB/s > 20.0 KB/s")));
			var vb2Result = vb1Result.getSubResults().get(0);
			checkValues(vb2Result, List.of(384.0, 256.0, 192.0, 192.0), List.of());
			checkIntegerValue(vb2Result, 7, 56L);
			var c2Result = vb1Result.getSubResults().get(1);
			checkValues(c2Result, List.of(40.0, 40.0), List.of());
			var vb3Result = vb2Result.getSubResults().get(0);
			checkValues(vb3Result, List.of(256.0, 128.0, 96.0, 128.0), List.of());
			checkIntegerValue(vb3Result, 7, 120L);
			var c3Result = vb2Result.getSubResults().get(1);
			checkValues(c3Result, List.of(64.0, 64.0), List.of());
			var c4Result = vb3Result.getSubResults().get(0);
			checkValues(c4Result, List.of(96.0, 128.0), List.of(error(
					"Connection sub1.out4 -> sub2.in4 -- Actual bandwidth > budget: 128.0 KB/s > 96.0 KB/s")));
		}
	}

	@Test
	public void testConnections() throws Exception {
		var analysisResult = analyzeBusLoad("TestConnections.aadl", "top.i");

		var somResult = analysisResult.getResults().get(0);
		var busResult = somResult.getSubResults().get(0);
		checkValues(busResult, List.of(96.0, 64.0, 40.0, 48.0), List.of());
		var c1Result = busResult.getSubResults().get(0);
		checkValues(c1Result, List.of(0.0, 8.0),
				List.of(warning("Connection sub1.out1 -> sub2.in1 has no bandwidth budget")));
		var c2Result = busResult.getSubResults().get(1);
		checkValues(c2Result, List.of(8.0, 16.0), List.of(
				error("Connection sub1.out2 -> sub2.in2 -- Actual bandwidth > budget: 16.0 KB/s > 8.0 KB/s")));
		var c3Result = busResult.getSubResults().get(2);
		checkValues(c3Result, List.of(32.0, 24.0), List.of());
	}

	@Test
	public void testBus_noCapacity_noBudget() throws Exception {
		var analysisResult = analyzeBusLoad("TestBusProperties.aadl", "top.noCapacity_noBudget");

		var somResult = analysisResult.getResults().get(0);
		var busResult = somResult.getSubResults().get(0);
		checkValues(busResult, List.of(0.0, 0.0, 0.0, 8.0),
				List.of(warning("Bus theBus has no capacity"), warning("Bus theBus has no bandwidth budget")));
		var vbResult = busResult.getSubResults().get(0);
		checkValues(vbResult, List.of(0.0, 0.0, 16.0, 8.0),
				List.of(warning("Virtual bus VB1 has no capacity"), warning("Virtual bus VB1 has no bandwidth budget")));
		var c1Result = vbResult.getSubResults().get(0);
		checkValues(c1Result, List.of(16.0, 8.0), List.of());
	}

	@Test
	public void testBus_noCapacity() throws Exception {
		var analysisResult = analyzeBusLoad("TestBusProperties.aadl", "top.noCapacity");

		var somResult = analysisResult.getResults().get(0);
		var busResult = somResult.getSubResults().get(0);
		checkValues(busResult, List.of(0.0, 48.0, 32.0, 8.0), List.of(warning("Bus theBus has no capacity"),
				error("Bus theBus -- budget > capacity: 48.0 KB/s > 0.0 KB/s")));
		var vbResult = busResult.getSubResults().get(0);
		checkValues(vbResult, List.of(0.0, 32.0, 16.0, 8.0), List.of(warning("Virtual bus VB1 has no capacity"),
				error("Virtual bus VB1 -- budget > capacity: 32.0 KB/s > 0.0 KB/s")));
		var c1Result = vbResult.getSubResults().get(0);
		checkValues(c1Result, List.of(16.0, 8.0), List.of());
	}

	@Test
	public void testBus_noBudget() throws Exception {
		var analysisResult = analyzeBusLoad("TestBusProperties.aadl", "top.noBudget");

		var somResult = analysisResult.getResults().get(0);
		var busResult = somResult.getSubResults().get(0);
		checkValues(busResult, List.of(64.0, 0.0, 0.0, 8.0),
				List.of(warning("Bus theBus has no bandwidth budget")));
		var vbResult = busResult.getSubResults().get(0);
		checkValues(vbResult, List.of(48.0, 0.0, 16.0, 8.0),
				List.of(warning("Virtual bus VB1 has no bandwidth budget")));
		var c1Result = vbResult.getSubResults().get(0);
		checkValues(c1Result, List.of(16.0, 8.0), List.of());
	}

	@Test
	public void testBus_budgetLessThanCapacity() throws Exception {
		var analysisResult = analyzeBusLoad("TestBusProperties.aadl", "top.budgetLessThanCapacity");

		var somResult = analysisResult.getResults().get(0);
		var busResult = somResult.getSubResults().get(0);
		checkValues(busResult, List.of(64.0, 48.0, 32.0, 8.0), List.of());
		var vbResult = busResult.getSubResults().get(0);
		checkValues(vbResult, List.of(48.0, 32.0, 16.0, 8.0), List.of());
		var c1Result = vbResult.getSubResults().get(0);
		checkValues(c1Result, List.of(16.0, 8.0), List.of());
	}

	@Test
	public void testBus_budgetGreaterThanCapacity() throws Exception {
		var analysisResult = analyzeBusLoad("TestBusProperties.aadl", "top.budgetGreaterThanCapacity");

		var somResult = analysisResult.getResults().get(0);
		var busResult = somResult.getSubResults().get(0);
		checkValues(busResult, List.of(48.0, 56.0, 32.0, 8.0),
				List.of(error("Bus theBus -- budget > capacity: 56.0 KB/s > 48.0 KB/s")));
		var vbResult = busResult.getSubResults().get(0);
		checkValues(vbResult, List.of(24.0, 32.0, 16.0, 8.0),
				List.of(error("Virtual bus VB1 -- budget > capacity: 32.0 KB/s > 24.0 KB/s")));
		var c1Result = vbResult.getSubResults().get(0);
		checkValues(c1Result, List.of(16.0, 8.0), List.of());
	}

	@Test
	public void testCalculations_actualGreaterThanCapacity() throws Exception {
		var analysisResult = analyzeBusLoad("TestCalculations.aadl", "top.actualGreaterThanCapacity");

		var somResult = analysisResult.getResults().get(0);
		var busResult = somResult.getSubResults().get(0);
		checkValues(busResult, List.of(16.0, 16.0, 24.0, 24.0),
				List.of(error("Bus theBus -- Actual bandwidth > capacity: 24.0 KB/s > 16.0 KB/s"),
						error("Bus theBus -- Required budget > budget: 24.0 KB/s > 16.0 KB/s")));
		var vbResult = busResult.getSubResults().get(0);
		checkValues(vbResult, List.of(12.0, 12.0, 24.0, 16.0),
				List.of(error("Virtual bus vb1 -- Actual bandwidth > capacity: 16.0 KB/s > 12.0 KB/s"),
						error("Virtual bus vb1 -- Required budget > budget: 24.0 KB/s > 12.0 KB/s")));
		var c3Result = busResult.getSubResults().get(1);
		checkValues(c3Result, List.of(12.0, 8.0), List.of());
		var c1Result = vbResult.getSubResults().get(0);
		checkValues(c1Result, List.of(12.0, 8.0), List.of());
		var c2Result = vbResult.getSubResults().get(1);
		checkValues(c2Result, List.of(12.0, 8.0), List.of());
	}

	@Test
	public void testCalculations_requiredBudgetGreaterThanBudget() throws Exception {
		var analysisResult = analyzeBusLoad("TestCalculations.aadl", "top.requiredBudgetGreaterThanBudget");

		var somResult = analysisResult.getResults().get(0);
		var busResult = somResult.getSubResults().get(0);
		checkValues(busResult, List.of(64.0, 24.0, 28.0, 24.0),
				List.of(error("Bus theBus -- Required budget > budget: 28.0 KB/s > 24.0 KB/s")));
		var vbResult = busResult.getSubResults().get(0);
		checkValues(vbResult, List.of(48.0, 16.0, 24.0, 16.0),
				List.of(error("Virtual bus vb1 -- Required budget > budget: 24.0 KB/s > 16.0 KB/s")));
		var c3Result = busResult.getSubResults().get(1);
		checkValues(c3Result, List.of(12.0, 8.0), List.of());
		var c1Result = vbResult.getSubResults().get(0);
		checkValues(c1Result, List.of(12.0, 8.0), List.of());
		var c2Result = vbResult.getSubResults().get(1);
		checkValues(c2Result, List.of(12.0, 8.0), List.of());
	}

	@Test
	public void testCalculations_requiredBudgetLessThanBudget() throws Exception {
		var analysisResult = analyzeBusLoad("TestCalculations.aadl", "top.requiredBudgetLessThanBudget");

		var somResult = analysisResult.getResults().get(0);
		var busResult = somResult.getSubResults().get(0);
		checkValues(busResult, List.of(64.0, 48.0, 44.0, 24.0), List.of());
		var vbResult = busResult.getSubResults().get(0);
		checkValues(vbResult, List.of(48.0, 32.0, 24.0, 16.0), List.of());
		var c3Result = busResult.getSubResults().get(1);
		checkValues(c3Result, List.of(12.0, 8.0), List.of());
		var c1Result = vbResult.getSubResults().get(0);
		checkValues(c1Result, List.of(12.0, 8.0), List.of());
		var c2Result = vbResult.getSubResults().get(1);
		checkValues(c2Result, List.of(12.0, 8.0), List.of());
	}

	@Test
	public void testBroadcast() throws Exception {
		var analysisResult = analyzeBusLoad("TestBroadcast.aadl", "top.i");

		var somResult = analysisResult.getResults().get(0);
		{
			var noBroadcastBusResult = somResult.getSubResults().get(0);
			checkValues(noBroadcastBusResult, List.of(96.0, 64.0, 32.0, 32.0), List.of());
			var c1Result = noBroadcastBusResult.getSubResults().get(0);
			checkValues(c1Result, List.of(8.0, 8.0), List.of());
			var c2Result = noBroadcastBusResult.getSubResults().get(1);
			checkValues(c2Result, List.of(8.0, 8.0), List.of());
			var c3Result = noBroadcastBusResult.getSubResults().get(2);
			checkValues(c3Result, List.of(8.0, 8.0), List.of());
			var c4Result = noBroadcastBusResult.getSubResults().get(3);
			checkValues(c4Result, List.of(8.0, 8.0), List.of());
		}
		{
			var broadcastBusResult = somResult.getSubResults().get(1);
			checkValues(broadcastBusResult, List.of(96.0, 64.0, 16.0, 16.0), List.of());
			var c1Result = broadcastBusResult.getSubResults().get(0);
			checkValues(c1Result, List.of(8.0, 8.0), List.of());
			var broadcastResult = broadcastBusResult.getSubResults().get(1);
			checkValues(broadcastResult, List.of(8.0, 8.0), List.of());
			var c2Result = broadcastResult.getSubResults().get(0);
			checkValues(c2Result, List.of(8.0, 8.0), List.of());
			var c3Result = broadcastResult.getSubResults().get(1);
			checkValues(c3Result, List.of(8.0, 8.0), List.of());
			var c4Result = broadcastResult.getSubResults().get(2);
			checkValues(c4Result, List.of(8.0, 8.0), List.of());
		}
	}

	@Test
	public void testBiggerBroadcast() throws Exception {
		var analysisResult = analyzeBusLoad("TestBiggerBroadcast.aadl", "top.i");

		var somResult = analysisResult.getResults().get(0);
		{
			var noBroadcastBusResult = somResult.getSubResults().get(0);
			checkValues(noBroadcastBusResult, List.of(96.0, 64.0, 24.0, 24.0), List.of());
			var c1Result = noBroadcastBusResult.getSubResults().get(0);
			checkValues(c1Result, List.of(8.0, 8.0), List.of());
			var c2Result = noBroadcastBusResult.getSubResults().get(1);
			checkValues(c2Result, List.of(8.0, 8.0), List.of());
			var c3Result = noBroadcastBusResult.getSubResults().get(2);
			checkValues(c3Result, List.of(8.0, 8.0), List.of());
		}
		{
			var broadcastBusResult = somResult.getSubResults().get(1);
			checkValues(broadcastBusResult, List.of(96.0, 64.0, 24.0, 24.0), List.of());
			var broadcast1Result = broadcastBusResult.getSubResults().get(0);
			checkValues(broadcast1Result, List.of(8.0, 8.0), List.of());
			{
				var c1Result = broadcast1Result.getSubResults().get(0);
				checkValues(c1Result, List.of(8.0, 8.0), List.of());
				var c2Result = broadcast1Result.getSubResults().get(1);
				checkValues(c2Result, List.of(8.0, 8.0), List.of());
				var c3Result = broadcast1Result.getSubResults().get(2);
				checkValues(c3Result, List.of(8.0, 8.0), List.of());
			}
			var broadcast2Result = broadcastBusResult.getSubResults().get(1);
			checkValues(broadcast2Result, List.of(8.0, 8.0), List.of());
			{
				var c1Result = broadcast2Result.getSubResults().get(0);
				checkValues(c1Result, List.of(8.0, 8.0), List.of());
				var c2Result = broadcast2Result.getSubResults().get(1);
				checkValues(c2Result, List.of(8.0, 8.0), List.of());
				var c3Result = broadcast2Result.getSubResults().get(2);
				checkValues(c3Result, List.of(8.0, 8.0), List.of());
			}
			var broadcast3Result = broadcastBusResult.getSubResults().get(2);
			checkValues(broadcast3Result, List.of(8.0, 8.0), List.of());
			{
				var c1Result = broadcast3Result.getSubResults().get(0);
				checkValues(c1Result, List.of(8.0, 8.0), List.of());
				var c2Result = broadcast3Result.getSubResults().get(1);
				checkValues(c2Result, List.of(8.0, 8.0), List.of());
				var c3Result = broadcast3Result.getSubResults().get(2);
				checkValues(c3Result, List.of(8.0, 8.0), List.of());
			}
		}
	}

	@Test
	public void testBiggerBroadcastWarnings() throws Exception {
		var analysisResult = analyzeBusLoad("TestBiggerBroadcast_warnings.aadl", "top.i");

		var somResult = analysisResult.getResults().get(0);
		{
			var noBroadcastBusResult = somResult.getSubResults().get(0);
			checkValues(noBroadcastBusResult, List.of(96.0, 64.0, 24.0, 24.0), List.of());
			var c1Result = noBroadcastBusResult.getSubResults().get(0);
			checkValues(c1Result, List.of(8.0, 8.0), List.of());
			var c2Result = noBroadcastBusResult.getSubResults().get(1);
			checkValues(c2Result, List.of(8.0, 8.0), List.of());
			var c3Result = noBroadcastBusResult.getSubResults().get(2);
			checkValues(c3Result, List.of(8.0, 8.0), List.of());
		}
		{
			var broadcastBusResult = somResult.getSubResults().get(1);
			checkValues(broadcastBusResult, List.of(96.0, 64.0, 40.0, 24.0), List.of());
			var broadcast1Result = broadcastBusResult.getSubResults().get(0);
			checkValues(broadcast1Result, List.of(8.0, 8.0), List.of());
			{
				var c1Result = broadcast1Result.getSubResults().get(0);
				checkValues(c1Result, List.of(8.0, 8.0), List.of());
				var c2Result = broadcast1Result.getSubResults().get(1);
				checkValues(c2Result, List.of(8.0, 8.0), List.of());
				var c3Result = broadcast1Result.getSubResults().get(2);
				checkValues(c3Result, List.of(8.0, 8.0), List.of());
			}
			var broadcast2Result = broadcastBusResult.getSubResults().get(1);
			checkValues(broadcast2Result, List.of(8.0, 8.0), List.of());
			{
				var c1Result = broadcast2Result.getSubResults().get(0);
				checkValues(c1Result, List.of(8.0, 8.0), List.of());
				var c2Result = broadcast2Result.getSubResults().get(1);
				checkValues(c2Result, List.of(8.0, 8.0), List.of());
				var c3Result = broadcast2Result.getSubResults().get(2);
				checkValues(c3Result, List.of(8.0, 8.0), List.of());
			}
			var broadcast3Result = broadcastBusResult.getSubResults().get(2);
			checkValues(broadcast3Result, List.of(24.0, 8.0), List.of(
					warning("Connection sub3c.out1 -> sub4a.in3 sharing broadcast source top_i_Instance.sub3c.out1 has budget 8.0 KB/s; using maximum"),
					warning("Connection sub3c.out1 -> sub4b.in3 sharing broadcast source top_i_Instance.sub3c.out1 has budget 16.0 KB/s; using maximum"),
					warning("Connection sub3c.out1 -> sub4c.in3 sharing broadcast source top_i_Instance.sub3c.out1 has budget 24.0 KB/s; using maximum")));

			/*
			 * Compared as a set. Each sub-result is one connection of the broadcast group, so
			 * their order follows the order of the container's connection instances, and issue
			 * #3037 made that a deterministic across-first order instead of source-first
			 * insertion order. The three connections and their budgets are unchanged.
			 */
			var actualBandwidths = broadcast3Result.getSubResults()
					.stream()
					.map(result -> new Bandwidth(ResultUtil.getReal(result, 0), ResultUtil.getReal(result, 1)))
					.sorted(Comparator.comparingDouble(Bandwidth::budget))
					.toList();
			assertEquals(List.of(new Bandwidth(8.0, 8.0), new Bandwidth(16.0, 8.0), new Bandwidth(24.0, 8.0)),
					actualBandwidths);
		}
	}

	@Test
	public void testComplicated() throws Exception {
		var analysisResult = analyzeBusLoad("Complicated.aadl", "top.i");

		var somResult = analysisResult.getResults().get(0);
		var busResult = somResult.getSubResults().get(0);
		checkValues(busResult, List.of(128.0, 128.0, 120.0, 128.0), List.of());
		var vb4Result = busResult.getSubResults().get(0);
		checkValues(vb4Result, List.of(8.0, 8.0, 12.0, 16.0),
				List.of(error("Virtual bus vb4 -- Actual bandwidth > capacity: 16.0 KB/s > 8.0 KB/s"),
						error("Virtual bus vb4 -- Required budget > budget: 12.0 KB/s > 8.0 KB/s")));
		var vb3Result = busResult.getSubResults().get(1);
		checkValues(vb3Result, List.of(64.0, 64.0, 56.0, 64.0), List.of());
		var c8Result = busResult.getSubResults().get(2);
		checkValues(c8Result, List.of(24.0, 24.0), List.of());
		var c9Result = busResult.getSubResults().get(3);
		checkValues(c9Result, List.of(24.0, 24.0), List.of());

		var c6Result = vb4Result.getSubResults().get(0);
		checkValues(c6Result, List.of(4.0, 8.0), List.of(
				error("Connection sub1.out6 -> sub2.in6 -- Actual bandwidth > budget: 8.0 KB/s > 4.0 KB/s")));
		var c7Result = vb4Result.getSubResults().get(1);
		checkValues(c7Result, List.of(8.0, 8.0), List.of());

		var vb1Result = vb3Result.getSubResults().get(0);
		checkValues(vb1Result, List.of(16.0, 16.0, 16.0, 16.0), List.of());
		var vb2Result = vb3Result.getSubResults().get(1);
		checkValues(vb2Result, List.of(16.0, 16.0, 24.0, 24.0),
				List.of(error("Virtual bus vb2 -- Actual bandwidth > capacity: 24.0 KB/s > 16.0 KB/s"),
						error("Virtual bus vb2 -- Required budget > budget: 24.0 KB/s > 16.0 KB/s")));
		var c5Result = vb3Result.getSubResults().get(2);
		checkValues(c5Result, List.of(24.0, 24.0), List.of());

		var c1Result = vb1Result.getSubResults().get(0);
		checkValues(c1Result, List.of(8.0, 8.0), List.of());
		var c2Result = vb1Result.getSubResults().get(1);
		checkValues(c2Result, List.of(8.0, 8.0), List.of());

		var c3Result = vb2Result.getSubResults().get(0);
		checkValues(c3Result, List.of(8.0, 8.0), List.of());
		var c4Result = vb2Result.getSubResults().get(1);
		checkValues(c4Result, List.of(16.0, 16.0), List.of());
	}

	private AnalysisResult analyzeBusLoad(String fileName, String implementationName) throws Exception {
		var pkg = testHelper.parseFile(PROJECT_LOCATION + fileName);

		// instantiate
		var implementation = (SystemImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> implementationName.equals(classifier.getName()))
				.findFirst()
				.orElseThrow(() -> new AssertionError("No classifier named " + implementationName));
		var instance = InstantiateModel.instantiate(implementation);

		// check bus load
		var checker = new NewBusLoadAnalysis();
		return checker.invoke(null, instance, false);
	}

	private static String error(String message) {
		return diagnosticKey(DiagnosticType.ERROR, message);
	}

	private static String warning(String message) {
		return diagnosticKey(DiagnosticType.WARNING, message);
	}

	private static String diagnosticKey(DiagnosticType type, String message) {
		return type + "|" + message;
	}

	private static void checkValues(Result result, List<Double> values, List<String> diagnostics) {
		for (var i = 0; i < values.size(); i++) {
			assertEquals(values.get(i), ResultUtil.getReal(result, i), 0.0);
		}

		/*
		 * Diagnostics are compared as a set. A budget diagnostic is reported while iterating a
		 * component's connection instances, so its position follows the connection collection
		 * order, and issue #3037 made that a deterministic across-first order instead of
		 * source-first insertion order. Which member of a broadcast group is named first is
		 * therefore not a property of the analysis; the reported set is unchanged.
		 */
		var expectedDiagnostics = diagnostics.stream().sorted().toList();
		var actualDiagnostics = result.getDiagnostics()
				.stream()
				.map(diagnostic -> diagnosticKey(diagnostic.getDiagnosticType(), diagnostic.getMessage()))
				.sorted()
				.toList();
		assertEquals(expectedDiagnostics, actualDiagnostics);
	}

	private static void checkIntegerValue(Result result, int idx, long expected) {
		assertEquals(expected, ResultUtil.getInteger(result, idx));
	}

	/** The budgeted and the actual bandwidth of a single connection, in KB/s. */
	private record Bandwidth(double budget, double actual) {
	}
}
