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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch;
import org.osate.result.DiagnosticType;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3326Test extends XtextTest {
	private static final String FILE = "org.osate.analysis.flows.tests/models/issue3326/Issue3326.aadl";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Inject
	ValidationTestHelper validationHelper;

	@Test
	public void asynchronousCrossingBeforeReceiverStage() throws Exception {
		assertLatency("Top.receiver_stage", true, 3.0, 6.0, false);
	}

	@Test
	public void explicitAsynchronousCrossingOverridesSynchronousDefault() throws Exception {
		assertLatency("Top.receiver_stage", false, 3.0, 6.0, false);
	}

	@Test
	public void asynchronousCrossingAfterSenderStage() throws Exception {
		assertLatency("Top.sender_stage", true, 3.0, 6.0, false);
	}

	@Test
	public void sharedClockOverridesAsynchronousDefault() throws Exception {
		assertLatency("Top.shared_clock", true, 0.5, 3.5, true);
	}

	@Test
	public void sharedClockWithSynchronousDefault() throws Exception {
		assertLatency("Top.shared_clock", false, 0.5, 3.5, true);
	}

	@Test
	public void unknownClockUsesAsynchronousDefault() throws Exception {
		assertLatency("Top.unknown_clock", true, 3.0, 6.0, false);
	}

	@Test
	public void unknownClockUsesSynchronousDefault() throws Exception {
		var flow = assertLatency("Top.unknown_clock", false, 0.5, 3.5, false);
		assertTrue(samplingResult(flow).getDiagnostics().stream()
				.anyMatch(d -> d.getMessage().equals("Assume synchronous communication")));
	}

	@Test
	public void samplingAtIntermediateStageResetsSynchronizationContext() throws Exception {
		assertLatency("Top.periodic_stage", true, 2.0, 8.0, true);
	}

	@Test
	public void sampledBusDoesNotHideAsynchronousCrossing() throws Exception {
		assertLatency("Top.sampled_bus", true, 3.0, 8.5, false);
	}

	private Result assertLatency(String implementationName, boolean asynchronousSystem, double samplingMaximum,
			double flowMaximum, boolean synchronousDiagnostic) throws Exception {
		var pkg = testHelper.parseFile(FILE);
		validationHelper.assertNoIssues(pkg);
		var implementation = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().stream()
				.filter(c -> c.getName().equals(implementationName)).findFirst().orElseThrow();
		var instance = InstantiateModel.instantiate(implementation);
		var analysis = new FlowLatencyAnalysisSwitch(instance).invoke(instance,
				instance.getSystemOperationModes().getFirst(), asynchronousSystem, false, true, true, true);
		assertEquals(1, analysis.getResults().size());
		var flow = analysis.getResults().getFirst();
		assertNoWarningsOrErrors(flow);
		var sampling = samplingResult(flow);
		assertEquals(0.0, ResultUtil.getReal(sampling, 0), 0.0);
		assertEquals(samplingMaximum, ResultUtil.getReal(sampling, 1), 0.0);
		assertEquals(3.0, ResultUtil.getReal(flow, 1), 0.0);
		assertEquals(flowMaximum, ResultUtil.getReal(flow, 2), 0.0);
		assertEquals(synchronousDiagnostic, sampling.getDiagnostics().stream()
				.anyMatch(d -> d.getMessage().equals("Synchronous communication on same platform")));
		return flow;
	}

	private Result samplingResult(Result flow) {
		return flow.getSubResults().stream()
				.filter(r -> r.getModelElement() instanceof ComponentInstance component
						&& component.getComponentInstancePath().equals("consumer.t")
						&& ResultUtil.getString(r, 5).equals("sampling"))
				.findFirst().orElseThrow();
	}

	private void assertNoWarningsOrErrors(Result result) {
		for (var diagnostic : result.getDiagnostics()) {
			assertFalse(diagnostic.getMessage(), diagnostic.getDiagnosticType() == DiagnosticType.ERROR
					|| diagnostic.getDiagnosticType() == DiagnosticType.WARNING);
		}
		result.getSubResults().forEach(this::assertNoWarningsOrErrors);
	}
}
