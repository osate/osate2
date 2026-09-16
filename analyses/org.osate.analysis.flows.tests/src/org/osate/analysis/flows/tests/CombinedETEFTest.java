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
import org.osate.result.RealValue;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class CombinedETEFTest extends XtextTest {
	private static final String FILE = "org.osate.analysis.flows.tests/models/latencytest/CombinedETEF.aadl";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void flows_combinedETEFs() throws Exception {
		var pkg = testHelper.parseFile(FILE);
		var implementation = (SystemImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> "Test.Impl".equals(classifier.getName()))
				.findFirst()
				.orElseThrow(() -> new AssertionError("No classifier named Test.Impl"));

		// instantiate
		var instance = InstantiateModel.instantiate(implementation);
		assertEquals("Test_Impl_Instance", instance.getName());

		// check flow latency
		var som = instance.getSystemOperationModes().getFirst();
		var checker = new FlowLatencyAnalysisSwitch();
		var latencyResult = checker.invoke(instance, som, true, true, true, true, false);

		var abResult = latencyResult.getResults().get(0);
		assertEquals(20.0, ((RealValue) abResult.getValues().get(1)).getValue(), 0.0);
		assertEquals(20.0, ((RealValue) abResult.getValues().get(2)).getValue(), 0.0);
		assertEquals(20.0, ((RealValue) abResult.getValues().get(3)).getValue(), 0.0);
		assertEquals(20.0, ((RealValue) abResult.getValues().get(4)).getValue(), 0.0);
		assertEquals(0.0, ((RealValue) abResult.getValues().get(5)).getValue(), 0.0);
		assertEquals(0.0, ((RealValue) abResult.getValues().get(6)).getValue(), 0.0);
		assertEquals(3, abResult.getSubResults().size());
		assertEquals(1, abResult.getDiagnostics().size());

		var cdResult = latencyResult.getResults().get(1);
		assertEquals(20.0, ((RealValue) cdResult.getValues().get(1)).getValue(), 0.0);
		assertEquals(20.0, ((RealValue) cdResult.getValues().get(2)).getValue(), 0.0);
		assertEquals(20.0, ((RealValue) cdResult.getValues().get(3)).getValue(), 0.0);
		assertEquals(20.0, ((RealValue) cdResult.getValues().get(4)).getValue(), 0.0);
		assertEquals(0.0, ((RealValue) cdResult.getValues().get(5)).getValue(), 0.0);
		assertEquals(0.0, ((RealValue) cdResult.getValues().get(6)).getValue(), 0.0);
		assertEquals(3, cdResult.getSubResults().size());
		assertEquals(1, cdResult.getDiagnostics().size());

		var totalResult = latencyResult.getResults().get(2);
		assertEquals(40.0, ((RealValue) totalResult.getValues().get(1)).getValue(), 0.0);
		assertEquals(40.0, ((RealValue) totalResult.getValues().get(2)).getValue(), 0.0);
		assertEquals(40.0, ((RealValue) totalResult.getValues().get(3)).getValue(), 0.0);
		assertEquals(40.0, ((RealValue) totalResult.getValues().get(4)).getValue(), 0.0);
		assertEquals(20.0, ((RealValue) totalResult.getValues().get(5)).getValue(), 0.0);
		assertEquals(30.0, ((RealValue) totalResult.getValues().get(6)).getValue(), 0.0);
		assertEquals(7, totalResult.getSubResults().size());
		assertEquals(4, totalResult.getDiagnostics().size());
	}

}
