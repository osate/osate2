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
import static org.osate.testsupport.ResultHelper.generateOrAssert;

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
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class FlowLatencyCodeCoverageTest {
	private static final String DIR_NAME = "org.osate.analysis.flows.tests/models/FlowLatencyCodeCoverage/";

	private static final List<String> PACKAGE_NAMES = List.of("empty", "component_instance_as_segment",
			"connect_to_subcomponent", "categories", "categories2", "dispatch", "dispatch2", "immediate", "partition1",
			"partition2", "partition3", "partition4", "partition5", "partition6", "partition7", "partition8",
			"partition9", "partition10", "partition11", "partition12", "partition13", "execution_time", "queuing",
			"data_port_connection", "bound_to_vb", "latency", "hardware", "partition_duration", "bound_to_processor",
			"required_vb1", "required_vb2", "transmission_time1", "transmission_time2", "not_in_schedule",
			"no_parition_latency", "negative_time", "other_parition_in_schedule");

	private static final boolean GENERATE_RESULTS = false;

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testFlowLatency() throws Exception {
		for (var pkgName : PACKAGE_NAMES) {
			var instance = instantiate(pkgName);
			var analysis = new FlowLatencyAnalysisSwitch();
			var actual = analysis.invoke(instance, instance.getSystemOperationModes().getFirst(), true, true, true,
					true, false);

			var resultPath = DIR_NAME + "results/testFlowLatency/" + pkgName + ".result";
			generateOrAssert(GENERATE_RESULTS, resultPath, actual);
		}
	}

	@Test
	public void testWithLatencyReport() throws Exception {
		var pkgName = "empty";
		var instance = instantiate(pkgName);
		var analysis = new FlowLatencyAnalysisSwitch();
		var actual = analysis.invoke(instance, instance.getSystemOperationModes().getFirst(), true, true, true, true,
				false);

		var resultPath = DIR_NAME + "results/testWithLatencyReport/" + pkgName + ".result";
		generateOrAssert(GENERATE_RESULTS, resultPath, actual);
	}

	@Test
	public void testWorstCaseExecutionTime() throws Exception {
		var pkgName = "execution_time";
		var instance = instantiate(pkgName);
		var analysis = new FlowLatencyAnalysisSwitch();
		var actual = analysis.invoke(instance, instance.getSystemOperationModes().getFirst(), true, true, false, true,
				false);

		var resultPath = DIR_NAME + "results/testWorstCaseExecutionTime/" + pkgName + ".result";
		generateOrAssert(GENERATE_RESULTS, resultPath, actual);
	}

	@Test
	public void testBestCaseFullQueue() throws Exception {
		var pkgName = "queuing";
		var instance = instantiate(pkgName);
		var analysis = new FlowLatencyAnalysisSwitch();
		var actual = analysis.invoke(instance, instance.getSystemOperationModes().getFirst(), true, true, true, false,
				false);

		var resultPath = DIR_NAME + "results/testBestCaseFullQueue/" + pkgName + ".result";
		generateOrAssert(GENERATE_RESULTS, resultPath, actual);
	}

	private SystemInstance instantiate(String pkgName) throws Exception {
		var pkg = testHelper.parseFile(DIR_NAME + pkgName + ".aadl");
		assertEquals(pkgName, pkg.getName());

		var implementation = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals("s1.i1", implementation.getName());

		var instance = InstantiateModel.instantiate(implementation);
		assertEquals("s1_i1_Instance", instance.getName());
		return instance;
	}
}
