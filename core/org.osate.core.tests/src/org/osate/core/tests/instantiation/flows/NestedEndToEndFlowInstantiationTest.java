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
import static org.junit.Assert.assertTrue;

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
public class NestedEndToEndFlowInstantiationTest extends AbstractEndToEndFlowInstantiationTest {
	private static final String FILE = "NestedFlows.aadl";

	@Test
	public void testNestedAndParentCloneCounts() throws Exception {
		SystemInstance instance = instantiate(FILE, "Top.i");

		// Forward parents are created before their nested alternatives, while the last parent clone is created afterward.
		assertEquals(List.of("forward_parent_1", "forward_nested_1", "forward_nested_2", "forward_parent_2",
				"nested_1", "nested_2", "parent_1", "parent_2", "starts_nested_1", "starts_nested_2",
				"ends_nested_1", "ends_nested_2"), flowNames(instance));
		assertEquals(2, flowsFor(instance, "nested").size());
		assertEquals(2, flowsFor(instance, "parent").size());
		assertEquals(2, flowsFor(instance, "forward_nested").size());
		assertEquals(2, flowsFor(instance, "forward_parent").size());
		assertEquals(2, flowsFor(instance, "starts_nested").size());
		assertEquals(2, flowsFor(instance, "ends_nested").size());
	}

	@Test
	public void testNestedFlowElementsAndBranchOrder() throws Exception {
		SystemInstance instance = instantiate(FILE, "Top.i");
		List<EndToEndFlowInstance> nested = flowsFor(instance, "nested");

		assertEquals(List.of("nested_1", "nested_2"), nested.stream().map(EndToEndFlowInstance::getName).toList());
		assertEquals("upper", flowSpecification(nested.get(0), 0).getComponentInstance().getName());
		assertEquals(List.of("from_upper", "cross"), connectionDeclarations(connection(nested.get(0), 1)));
		assertEquals("right", flowSpecification(nested.get(0), 2).getComponentInstance().getName());
		assertEquals("lower", flowSpecification(nested.get(1), 0).getComponentInstance().getName());
		assertEquals(List.of("from_lower", "cross"), connectionDeclarations(connection(nested.get(1), 1)));
	}

	@Test
	public void testParentReferencesMaterializedNestedInstances() throws Exception {
		SystemInstance instance = instantiate(FILE, "Top.i");
		List<EndToEndFlowInstance> nested = flowsFor(instance, "nested");
		List<EndToEndFlowInstance> parents = flowsFor(instance, "parent");

		assertEquals(List.of("parent_1", "parent_2"), parents.stream().map(EndToEndFlowInstance::getName).toList());
		for (EndToEndFlowInstance parent : parents) {
			EndToEndFlowInstance referenced = nestedFlow(parent, 2);
			assertTrue(nested.stream().anyMatch(candidate -> candidate == referenced));
			assertSame(connection(parent, 1).getDestination().getComponentInstance(),
					flowSpecification(referenced, 0).getComponentInstance());
			assertEquals(List.of("leave"), connectionDeclarations(connection(parent, 3)));
			assertEquals("consumer", flowSpecification(parent, 4).getComponentInstance().getName());
		}
	}

	@Test
	public void testNestedFlowAtBeginningAndEnd() throws Exception {
		SystemInstance instance = instantiate(FILE, "Top.i");

		for (EndToEndFlowInstance flow : flowsFor(instance, "starts_nested")) {
			assertTrue(flow.getFlowElements().get(0) instanceof EndToEndFlowInstance);
			assertEquals(List.of("leave"), connectionDeclarations(connection(flow, 1)));
			assertEquals("consumer", flowSpecification(flow, 2).getComponentInstance().getName());
		}
		for (EndToEndFlowInstance flow : flowsFor(instance, "ends_nested")) {
			assertEquals("producer", flowSpecification(flow, 0).getComponentInstance().getName());
			assertTrue(flow.getFlowElements().get(2) instanceof EndToEndFlowInstance);
			assertEquals(3, flow.getFlowElements().size());
		}
	}

	@Test
	public void testForwardReferenceNamingAndIdentity() throws Exception {
		SystemInstance instance = instantiate(FILE, "Top.i");
		List<EndToEndFlowInstance> nested = flowsFor(instance, "forward_nested");
		List<EndToEndFlowInstance> parents = flowsFor(instance, "forward_parent");

		assertEquals(List.of("forward_nested_1", "forward_nested_2"),
				nested.stream().map(EndToEndFlowInstance::getName).toList());
		assertEquals(List.of("forward_parent_1", "forward_parent_2"),
				parents.stream().map(EndToEndFlowInstance::getName).toList());
		for (EndToEndFlowInstance parent : parents) {
			assertTrue(nested.stream().anyMatch(candidate -> candidate == nestedFlow(parent, 2)));
		}
	}
}
