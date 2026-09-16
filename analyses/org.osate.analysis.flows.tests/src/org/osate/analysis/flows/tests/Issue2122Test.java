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
public class Issue2122Test extends XtextTest {

	private static final String DECLARATIVE_FILE = "org.osate.analysis.flows.tests/models/Issue2122/ResponseTime.aadl";

	private static final String UNBOUND = "Top.unbound";
	private static final String COMPUTE_EXECUTION_TIME = "Top.CET";
	private static final String RESPONSE_TIME = "Top.RT";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void unbound() throws Exception {
		var latencyResult = analyzeLatency(UNBOUND);

		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyResult.getResults().get(0), List.of(1.0, 0.0, 3.0, 4.0),
				List.of(2.0, 0.0, 5.0, 7.0));
		checkMinMaxValues(latencyResult.getResults().get(1), List.of(1.0, 0.0, 3.0, 4.0),
				List.of(2.0, 0.0, 5.0, 7.0));
		checkMinMaxValues(latencyResult.getResults().get(2), List.of(1.0, 0.0, 3.0, 4.0),
				List.of(2.0, 0.0, 5.0, 7.0));
	}

	@Test
	public void computeExecutionTime() throws Exception {
		var latencyResult = analyzeLatency(COMPUTE_EXECUTION_TIME);

		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyResult.getResults().get(0), List.of(4.0, 0.0, 3.0, 7.0),
				List.of(10.0, 0.0, 6.0, 16.0));
		checkMinMaxValues(latencyResult.getResults().get(1), List.of(4.0, 0.0, 3.0, 7.0),
				List.of(10.0, 0.0, 6.0, 16.0));
		checkMinMaxValues(latencyResult.getResults().get(2), List.of(4.0, 0.0, 3.0, 7.0),
				List.of(10.0, 0.0, 6.0, 16.0));
	}

	@Test
	public void responseTime() throws Exception {
		var latencyResult = analyzeLatency(RESPONSE_TIME);

		/* We check straight down the "Min actual" and "max actual" columns */
		checkMinMaxValues(latencyResult.getResults().get(0), List.of(8.0, 0.0, 6.0, 14.0),
				List.of(20.0, 0.0, 12.0, 32.0));
		checkMinMaxValues(latencyResult.getResults().get(1), List.of(8.0, 0.0, 6.0, 14.0),
				List.of(20.0, 0.0, 12.0, 32.0));
		checkMinMaxValues(latencyResult.getResults().get(2), List.of(8.0, 0.0, 6.0, 14.0),
				List.of(20.0, 0.0, 12.0, 32.0));
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
		var instance = InstantiateModel.instantiate(implementation);

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
