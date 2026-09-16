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
package org.osate.analysis.flows.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch;
import org.osate.result.AnalysisResult;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1148Test extends XtextTest {

	private static final String DECLARATIVE_FILE = "org.osate.analysis.flows.tests/models/Issue1148/QueuingLatency.aadl";

	private static final String SIMPLE_PERIODIC = "Top.simple_periodic";
	private static final String SIMPLE_ASYNC = "Top.simple_async";
	private static final String PERIODIC_OVERHEAD = "Top.periodic_overhead";
	private static final String ASYNC_OVERHEAD = "Top.async_overhead";
	private static final String VB_BOUND_PERIODIC = "Top.vb_bound_periodic";
	private static final String VB_BOUND_ASYNC = "Top.vb_bound_async";
	private static final String VB_REQUIRED_PERIODIC = "Top.vb_required_periodic";
	private static final String VB_REQUIRED_ASYNC = "Top.vb_required_async";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void simplePeriodic() throws Exception {
		var latencyResult = analyzeLatency(SIMPLE_PERIODIC);

		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyResult.getResults().get(0), List.of(1.0, 0.0, 0.0, 17.0, 0.0, 3.0, 21.0),
				List.of(2.0, 5.0, 0.0, 26.0, 0.0, 5.0, 38.0));
		checkMinMaxValues(latencyResult.getResults().get(1), List.of(1.0, 0.0, 0.0, 33.0, 0.0, 3.0, 37.0),
				List.of(2.0, 5.0, 0.0, 50.0, 0.0, 5.0, 62.0));
		checkMinMaxValues(latencyResult.getResults().get(2), List.of(1.0, 0.0, 0.0, 49.0, 0.0, 3.0, 53.0),
				List.of(2.0, 5.0, 0.0, 74.0, 0.0, 5.0, 86.0));
	}

	@Test
	public void simpleAsync() throws Exception {
		var latencyResult = analyzeLatency(SIMPLE_ASYNC);

		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyResult.getResults().get(0), List.of(1.0, 17.0, 0.0, 0.0, 0.0, 3.0, 21.0),
				List.of(2.0, 26.0, 124.0, 0.0, 0.0, 5.0, 157.0));
		checkMinMaxValues(latencyResult.getResults().get(1), List.of(1.0, 33.0, 0.0, 0.0, 0.0, 3.0, 37.0),
				List.of(2.0, 50.0, 100.0, 0.0, 0.0, 5.0, 157.0));
		checkMinMaxValues(latencyResult.getResults().get(2), List.of(1.0, 49.0, 0.0, 0.0, 0.0, 3.0, 53.0),
				List.of(2.0, 74.0, 76.0, 0.0, 0.0, 5.0, 157.0));
	}

	@Test
	public void periodicOverhead() throws Exception {
		var latencyResult = analyzeLatency(PERIODIC_OVERHEAD);

		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyResult.getResults().get(0), List.of(1.0, 0.0, 0.0, 21.0, 0.0, 3.0, 25.0),
				List.of(2.0, 5.0, 0.0, 32.0, 0.0, 5.0, 44.0));
		checkMinMaxValues(latencyResult.getResults().get(1), List.of(1.0, 0.0, 0.0, 37.0, 0.0, 3.0, 41.0),
				List.of(2.0, 5.0, 0.0, 56.0, 0.0, 5.0, 68.0));
		checkMinMaxValues(latencyResult.getResults().get(2), List.of(1.0, 0.0, 0.0, 53.0, 0.0, 3.0, 57.0),
				List.of(2.0, 5.0, 0.0, 80.0, 0.0, 5.0, 92.0));
	}

	@Test
	public void asyncOverhead() throws Exception {
		var latencyResult = analyzeLatency(ASYNC_OVERHEAD);

		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyResult.getResults().get(0), List.of(1.0, 21.0, 0.0, 0.0, 0.0, 3.0, 25.0),
				List.of(2.0, 32.0, 136.0, 0.0, 0.0, 5.0, 175.0));
		checkMinMaxValues(latencyResult.getResults().get(1), List.of(1.0, 37.0, 0.0, 0.0, 0.0, 3.0, 41.0),
				List.of(2.0, 56.0, 112.0, 0.0, 0.0, 5.0, 175.0));
		checkMinMaxValues(latencyResult.getResults().get(2), List.of(1.0, 53.0, 0.0, 0.0, 0.0, 3.0, 57.0),
				List.of(2.0, 80.0, 88.0, 0.0, 0.0, 5.0, 175.0));
	}

	@Test
	public void vbBoundPeriodic() throws Exception {
		var latencyResult = analyzeLatency(VB_BOUND_PERIODIC);

		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyResult.getResults().get(0), List.of(1.0, 0.0, 0.0, 41.0, 0.0, 0.0, 0.0, 3.0, 45.0),
				List.of(2.0, 5.0, 0.0, 62.0, 0.0, 0.0, 0.0, 5.0, 74.0));
		checkMinMaxValues(latencyResult.getResults().get(1), List.of(1.0, 0.0, 0.0, 57.0, 0.0, 0.0, 0.0, 3.0, 61.0),
				List.of(2.0, 5.0, 0.0, 86.0, 0.0, 0.0, 0.0, 5.0, 98.0));
		checkMinMaxValues(latencyResult.getResults().get(2), List.of(1.0, 0.0, 0.0, 73.0, 0.0, 0.0, 0.0, 3.0, 77.0),
				List.of(2.0, 5.0, 0.0, 110.0, 0.0, 0.0, 0.0, 5.0, 122.0));
	}

	@Test
	public void vbBoundAsync() throws Exception {
		var latencyResult = analyzeLatency(VB_BOUND_ASYNC);

		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyResult.getResults().get(0), List.of(1.0, 41.0, 0.0, 0.0, 0.0, 0.0, 0.0, 3.0, 45.0),
				List.of(2.0, 62.0, 0.0, 0.0, 196.0, 0.0, 0.0, 5.0, 265.0));
		checkMinMaxValues(latencyResult.getResults().get(1), List.of(1.0, 57.0, 0.0, 0.0, 0.0, 0.0, 0.0, 3.0, 61.0),
				List.of(2.0, 86.0, 0.0, 0.0, 172.0, 0.0, 0.0, 5.0, 265.0));
		checkMinMaxValues(latencyResult.getResults().get(2), List.of(1.0, 73.0, 0.0, 0.0, 0.0, 0.0, 0.0, 3.0, 77.0),
				List.of(2.0, 110.0, 0.0, 0.0, 148.0, 0.0, 0.0, 5.0, 265.0));
	}

	@Test
	public void vbRequiredPeriodic() throws Exception {
		var latencyResult = analyzeLatency(VB_REQUIRED_PERIODIC);

		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyResult.getResults().get(0), List.of(1.0, 0.0, 0.0, 41.0, 0.0, 3.0, 45.0),
				List.of(2.0, 5.0, 0.0, 62.0, 0.0, 5.0, 74.0));
		checkMinMaxValues(latencyResult.getResults().get(1), List.of(1.0, 0.0, 0.0, 57.0, 0.0, 3.0, 61.0),
				List.of(2.0, 5.0, 0.0, 86.0, 0.0, 5.0, 98.0));
		checkMinMaxValues(latencyResult.getResults().get(2), List.of(1.0, 0.0, 0.0, 73.0, 0.0, 3.0, 77.0),
				List.of(2.0, 5.0, 0.0, 110.0, 0.0, 5.0, 122.0));
	}

	@Test
	public void vbRequiredAsync() throws Exception {
		var latencyResult = analyzeLatency(VB_REQUIRED_ASYNC);

		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyResult.getResults().get(0), List.of(1.0, 41.0, 0.0, 0.0, 0.0, 3.0, 45.0),
				List.of(2.0, 62.0, 196.0, 0.0, 0.0, 5.0, 265.0));
		checkMinMaxValues(latencyResult.getResults().get(1), List.of(1.0, 57.0, 0.0, 0.0, 0.0, 3.0, 61.0),
				List.of(2.0, 86.0, 172.0, 0.0, 0.0, 5.0, 265.0));
		checkMinMaxValues(latencyResult.getResults().get(2), List.of(1.0, 73.0, 0.0, 0.0, 0.0, 3.0, 77.0),
				List.of(2.0, 110.0, 148.0, 0.0, 0.0, 5.0, 265.0));
	}

	private AnalysisResult analyzeLatency(String implementationName) throws Exception {
		var pkg = testHelper.parseFile(DECLARATIVE_FILE);
		var implementation = (SystemImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> implementationName.equals(classifier.getName()))
				.findFirst()
				.orElseThrow(() -> new AssertionError("No classifier named " + implementationName));

		// instantiate
		SystemInstance instance = InstantiateModel.instantiate(implementation);

		// check flow latency
		var som = instance.getSystemOperationModes().getFirst();
		var checker = new FlowLatencyAnalysisSwitch();
		return checker.invoke(instance, som, true, true, true, true, false);
	}

	private static MinMax getMinMaxValues(Result result) {
		var minimums = new ArrayList<Double>();
		var maximums = new ArrayList<Double>();

		for (var subResult : result.getSubResults()) {
			for (var nested : subResult.getSubResults()) {
				minimums.add(ResultUtil.getReal(nested, 0));
				maximums.add(ResultUtil.getReal(nested, 1));
			}
			minimums.add(ResultUtil.getReal(subResult, 0));
			maximums.add(ResultUtil.getReal(subResult, 1));
		}
		minimums.add(ResultUtil.getReal(result, 0));
		maximums.add(ResultUtil.getReal(result, 1));

		return new MinMax(minimums, maximums);
	}

	private static void checkMinMaxValues(Result result, List<Double> expectedMinimums,
			List<Double> expectedMaximums) {
		var actual = getMinMaxValues(result);

		assertEquals(expectedMinimums.size(), actual.minimums().size());
		assertEquals(expectedMaximums.size(), actual.maximums().size());
		for (var i = 0; i < result.getSubResults().size(); i++) {
			assertEquals(expectedMinimums.get(i), actual.minimums().get(i));
			assertEquals(expectedMaximums.get(i), actual.maximums().get(i));
		}
	}

	private record MinMax(List<Double> minimums, List<Double> maximums) {
	}
}
