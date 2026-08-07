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
package org.osate.core.tests.instantiation.flows;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.testsupport.Aadl2InjectorProvider;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class FeatureGroupAndRefinementEndToEndFlowInstantiationTest
		extends AbstractEndToEndFlowInstantiationTest {
	private static final String FILE = "FeatureGroupAndRefinement.aadl";

	@Test
	public void testFeatureGroupConnectionExpansionSelectsCompatiblePath() throws Exception {
		SystemInstance instance = instantiate(FILE, "FeatureGroupTop.i");
		EndToEndFlowInstance flow = flow(instance, "feature_group_path");

		assertEquals(5, flow.getFlowElements().size());
		assertEquals(List.of("enter"), connectionDeclarations(connection(flow, 1)));
		assertEquals(List.of("leave"), connectionDeclarations(connection(flow, 3)));
	}

	@Test
	public void testThreadFlowImplementationUsesFlowSpecificationInstance() throws Exception {
		SystemInstance instance = instantiate(FILE, "FeatureGroupTop.i");
		EndToEndFlowInstance flow = flow(instance, "feature_group_path");

		assertEquals(FlowSpecificationInstance.class, flow.getFlowElements().get(2).eClass().getInstanceClass());
		assertEquals("fpath", flowSpecification(flow, 2).getName());
		assertEquals("transform", flowSpecification(flow, 2).getComponentInstance().getName());
	}

	@Test
	public void testRefinedConnectionFlowExpandsToLeafFlow() throws Exception {
		SystemInstance instance = instantiate(FILE, "RefinedConnectionTop.i");
		EndToEndFlowInstance flow = flow(instance, "refined_path");

		assertEquals(5, flow.getFlowElements().size());
		assertEquals("leaf", flowSpecification(flow, 2).getComponentInstance().getName());
		assertEquals(List.of("enter", "enter"), connectionDeclarations(connection(flow, 1)));
		assertEquals(List.of("leave", "leave"), connectionDeclarations(connection(flow, 3)));
	}

	@Test
	public void testConnectionReferencesUseRefinedDeclarations() throws Exception {
		SystemInstance instance = instantiate(FILE, "RefinedConnectionTop.i");
		EndToEndFlowInstance flow = flow(instance, "refined_path");

		assertNotNull(connection(flow, 1).getConnectionReferences().get(1).getConnection().getRefined());
		assertNotNull(connection(flow, 3).getConnectionReferences().get(0).getConnection().getRefined());
	}

	@Test
	public void testNontrivialThreadFlowImplementationUsesSpecificationAndRetainsModes() throws Exception {
		SystemInstance instance = instantiate(FILE, "ThreadCallTop.i");
		List<EndToEndFlowInstance> flows = flowsFor(instance, "thread_call_path");

		assertEquals(2, instance.getSystemOperationModes().size());
		assertEquals(List.of("thread_call_path_1", "thread_call_path_2"),
				flows.stream().map(EndToEndFlowInstance::getName).toList());
		for (int i = 0; i < flows.size(); i++) {
			EndToEndFlowInstance flow = flows.get(i);
			assertEquals(5, flow.getFlowElements().size());
			assertEquals("transform", flowSpecification(flow, 2).getComponentInstance().getName());
			assertEquals("fpath", flowSpecification(flow, 2).getName());
			assertEquals(List.of(instance.getSystemOperationModes().get(i)), flow.getInSystemOperationModes());
			assertEquals(List.of(), flow.getModesList());
		}
	}
}
