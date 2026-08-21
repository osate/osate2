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
import static org.junit.Assert.assertSame;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.testsupport.Aadl2InjectorProvider;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ModalEndToEndFlowInstantiationTest extends AbstractEndToEndFlowInstantiationTest {
	private static final String FILE = "ModalFlows.aadl";

	@Test
	public void testModeCombinationsAndFlowOrder() throws Exception {
		SystemInstance instance = instantiate(FILE, "ModalTop.i");

		assertEquals(4, instance.getSystemOperationModes().size());
		assertEquals(List.of("one_one", "one_two", "two_one", "two_two"), flowNames(instance));
		for (EndToEndFlowInstance flow : instance.getEndToEndFlows()) {
			assertEquals(1, flow.getInSystemOperationModes().size());
		}
	}

	@Test
	public void testFlowSystemOperationModeMembership() throws Exception {
		SystemInstance instance = instantiate(FILE, "ModalTop.i");

		assertSame(instance.getSystemOperationModes().get(0), flow(instance, "one_one").getInSystemOperationModes().get(0));
		assertSame(instance.getSystemOperationModes().get(1), flow(instance, "one_two").getInSystemOperationModes().get(0));
		assertSame(instance.getSystemOperationModes().get(2), flow(instance, "two_one").getInSystemOperationModes().get(0));
		assertSame(instance.getSystemOperationModes().get(3), flow(instance, "two_two").getInSystemOperationModes().get(0));
	}

	@Test
	public void testNestedFlowModesConstrainParent() throws Exception {
		SystemInstance instance = instantiate(FILE, "NestedModalTop.i");
		EndToEndFlowInstance nested = flow(instance, "nested");
		EndToEndFlowInstance parent = flow(instance, "parent");

		assertEquals(2, instance.getSystemOperationModes().size());
		assertEquals(1, nested.getInSystemOperationModes().size());
		assertEquals(1, parent.getInSystemOperationModes().size());
		assertSame(instance.getSystemOperationModes().get(0), nested.getInSystemOperationModes().get(0));
		assertSame(instance.getSystemOperationModes().get(0), parent.getInSystemOperationModes().get(0));
		assertSame(nested, nestedFlow(parent, 2));
	}

	@Test
	public void testFlowImplementationModesCreateDistinctClones() throws Exception {
		SystemInstance instance = instantiate(FILE, "FlowImplementationModeTop.i");
		List<EndToEndFlowInstance> flows = instance.getEndToEndFlows();

		assertEquals(2, instance.getSystemOperationModes().size());
		assertEquals(List.of("modal_implementation_1", "modal_implementation_2"), flowNames(instance));
		assertEquals("upper", flowSpecification(flows.get(0), 2).getComponentInstance().getName());
		assertEquals("lower", flowSpecification(flows.get(1), 2).getComponentInstance().getName());
		assertEquals(1, flows.get(0).getInSystemOperationModes().size());
		assertEquals(1, flows.get(1).getInSystemOperationModes().size());
		assertSame(instance.getSystemOperationModes().get(0), flows.get(0).getInSystemOperationModes().get(0));
		assertSame(instance.getSystemOperationModes().get(1), flows.get(1).getInSystemOperationModes().get(0));
		assertEquals(List.of(), flows.get(0).getModesList());
		assertEquals(List.of(), flows.get(1).getModesList());
	}

	@Test
	public void testContainingComponentModesConstrainImplicitFlow() throws Exception {
		SystemInstance instance = instantiate(FILE, "InheritedModeTop.i");
		EndToEndFlowInstance flow = flow(component(instance, "container"), "implicit");

		assertEquals(2, instance.getSystemOperationModes().size());
		assertEquals(1, flow.getInSystemOperationModes().size());
		assertSame(instance.getSystemOperationModes().get(0), flow.getInSystemOperationModes().get(0));
		assertEquals(List.of("producer", "producer.output -> middle.input", "middle",
				"middle.output -> consumer.input", "consumer"),
				flow.getFlowElements().stream().map(element -> element.getName()).toList());
		assertEquals(List.of(), flow.getModesList());
	}
}
