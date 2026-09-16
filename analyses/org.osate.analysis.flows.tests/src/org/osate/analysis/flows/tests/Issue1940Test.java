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

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch;
import org.osate.result.AnalysisResult;
import org.osate.result.RealValue;
import org.osate.result.Result;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1940Test extends XtextTest {

	private static final String PROJECT_PREFIX = "org.osate.analysis.flows.tests/models/Issue1940/";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void periodic() throws Exception {
		var latencyResult = analyzeLatency("Periodic.aadl");
		checkMinMaxComputeExecutionTime(latencyResult.getResults().get(0), 5.0, 10.0);
		checkMinMaxComputeExecutionTime(latencyResult.getResults().get(1), 5.0, 10.0);
		checkMinMaxComputeExecutionTime(latencyResult.getResults().get(2), 5.0, 10.0);
		checkMinMaxComputeExecutionTime(latencyResult.getResults().get(3), 5.0, 10.0);
	}

	@Test
	public void periodic_reference_processor() throws Exception {
		var latencyResult = analyzeLatency("Periodic_RefProc.aadl");
		checkMinMaxComputeExecutionTime(latencyResult.getResults().get(0), 1.25, 2.5);
		checkMinMaxComputeExecutionTime(latencyResult.getResults().get(1), 1.25, 2.5);
		checkMinMaxComputeExecutionTime(latencyResult.getResults().get(2), 1.25, 2.5);
		checkMinMaxComputeExecutionTime(latencyResult.getResults().get(3), 1.25, 2.5);
	}

	@Test
	public void aperiodic() throws Exception {
		var latencyResult = analyzeLatency("Aperiodic.aadl");
		checkMinMaxComputeExecutionTime(latencyResult.getResults().get(0), 5.0, 10.0);
		checkMinMaxComputeExecutionTime(latencyResult.getResults().get(1), 15.0, 20.0);
		checkMinMaxComputeExecutionTime(latencyResult.getResults().get(2), 3.0, 6.0);
		checkMinMaxComputeExecutionTime(latencyResult.getResults().get(3), 20.0, 23.0);
	}

	@Test
	public void aperiodic_reference_processor() throws Exception {
		var latencyResult = analyzeLatency("Aperiodic_RefProc.aadl");
		checkMinMaxComputeExecutionTime(latencyResult.getResults().get(0), 1.25, 2.5);
		checkMinMaxComputeExecutionTime(latencyResult.getResults().get(1), 3.75, 5.0);
		checkMinMaxComputeExecutionTime(latencyResult.getResults().get(2), 0.75, 1.5);
		checkMinMaxComputeExecutionTime(latencyResult.getResults().get(3), 5.0, 5.75);
	}

	private AnalysisResult analyzeLatency(String fileName) throws Exception {
		var pkg = testHelper.parseFile(PROJECT_PREFIX + fileName);
		var implementation = (SystemImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> "s.impl".equals(classifier.getName()))
				.findFirst()
				.orElseThrow(() -> new AssertionError("No classifier named s.impl"));

		// instantiate
		var instance = InstantiateModel.instantiate(implementation);
		assertEquals("s_impl_Instance", instance.getName());

		// check flow latency
		var som = instance.getSystemOperationModes().getFirst();
		var checker = new FlowLatencyAnalysisSwitch();
		return checker.invoke(instance, som, true, true, true, true, false);
	}

	private static void checkMinMaxComputeExecutionTime(Result result, double minExpected, double maxExpected) {
		var subResult = result.getSubResults().get(5);
		var min = ((RealValue) subResult.getValues().get(0)).getValue();
		var max = ((RealValue) subResult.getValues().get(1)).getValue();
		assertEquals(minExpected, min, 0.0);
		assertEquals(maxExpected, max, 0.0);
	}

}
