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
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
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
public class Issue3011Test extends XtextTest {
	private static final String PROJECT = "org.osate.analysis.flows.tests/models/issue3011/";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Inject
	ValidationTestHelper validationHelper;

	@Test
	public void specifiedBusLatencyContributesToQueueWait() throws Exception {
		AadlPackage pkg = testHelper.parseFile(PROJECT + "Issue3011.aadl");
		validationHelper.assertNoIssues(pkg);

		SystemImplementation top = (SystemImplementation) pkg.getPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(c -> c.getName().equals("Top.i"))
				.findFirst()
				.orElseThrow();
		SystemInstance instance = InstantiateModel.instantiate(top);
		AnalysisResult analysis = new FlowLatencyAnalysisSwitch(instance).invoke(instance,
				instance.getSystemOperationModes().get(0), true, true, true, true, false);

		assertEquals(2, analysis.getResults().size());
		for (Result flow : analysis.getResults()) {
			assertEquals(flow.getModelElement().toString(), 10.0, ResultUtil.getReal(flow, 2), 0.0);
		}
	}
}
