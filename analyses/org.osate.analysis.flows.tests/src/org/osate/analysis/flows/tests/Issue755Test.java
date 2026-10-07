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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch;
import org.osate.result.AnalysisResult;
import org.osate.result.util.ResultUtil;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue755Test extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void analyzeNonModalSystem() throws Exception {
		var instance = instantiate();
		assertLatency(instance, new FlowLatencyAnalysisSwitch(instance).invoke(instance, null,
				true, true, true, true, false));
	}

	@Test
	public void analyzeNonModalComponent() throws Exception {
		var instance = instantiate();
		assertLatency(instance, new FlowLatencyAnalysisSwitch(instance).invoke((ComponentInstance) instance, null,
				true, true, true, true, false));
	}

	@Test
	public void analyzeNonModalFlow() throws Exception {
		var instance = instantiate();
		var flow = instance.getEndToEndFlows().getFirst();
		assertTrue(flow.isActive(null));
		assertLatency(instance, new FlowLatencyAnalysisSwitch(instance).invoke(flow, null,
				true, true, true, true, false));
	}

	private void assertLatency(SystemInstance instance, AnalysisResult result) {
		assertEquals(1, result.getResults().size());
		var flowResult = result.getResults().getFirst();
		assertSame(instance.getEndToEndFlows().getFirst(), flowResult.getModelElement());
		assertEquals(5.0, ResultUtil.getReal(flowResult, 2), 0.0);
	}

	private SystemInstance instantiate() throws Exception {
		var pkg = testHelper.parseFile("org.osate.analysis.flows.tests/models/issue755/Issue755.aadl");
		validationHelper.assertNoIssues(pkg);
		var implementation = (ComponentImplementation) pkg.getOwnedPublicSection().getOwnedClassifiers().stream()
				.filter(classifier -> classifier.getName().equals("Top.i")).findFirst().orElseThrow();
		return InstantiateModel.instantiate(implementation);
	}
}
