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
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.testsupport.Aadl2InjectorProvider;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class BasicEndToEndFlowInstantiationTest extends AbstractEndToEndFlowInstantiationTest {
	private static final String FILE = "BasicAndBranching.aadl";

	@Test
	public void testFlowDeclarationOrderAndNames() throws Exception {
		SystemInstance instance = instantiate(FILE, "BasicTop.i");

		assertEquals(List.of("explicit", "implicit"), flowNames(instance));
		assertEquals(List.of("explicit", "implicit"),
				instance.getEndToEndFlows().stream().map(flow -> flow.getEndToEndFlow().getName()).toList());
		assertTrue(instance.getEndToEndFlows().stream().allMatch(flow -> flow.getModesList().isEmpty()));
	}

	@Test
	public void testExplicitFlowElements() throws Exception {
		SystemInstance instance = instantiate(FILE, "BasicTop.i");
		EndToEndFlowInstance flow = flow(instance, "explicit");

		assertEquals(5, flow.getFlowElements().size());
		assertEquals(List.of("fsrc", "producer.output -> middle.input", "fpath",
				"middle.output -> consumer.input", "fsnk"),
				flow.getFlowElements().stream().map(element -> element.getName()).toList());
		assertEquals("producer", flowSpecification(flow, 0).getComponentInstance().getName());
		assertEquals(List.of("first"), connectionDeclarations(connection(flow, 1)));
		assertEquals("middle", flowSpecification(flow, 2).getComponentInstance().getName());
		assertEquals(List.of("second"), connectionDeclarations(connection(flow, 3)));
		assertEquals("consumer", flowSpecification(flow, 4).getComponentInstance().getName());
	}

	@Test
	public void testImplicitSubcomponentFlowElements() throws Exception {
		SystemInstance instance = instantiate(FILE, "BasicTop.i");
		EndToEndFlowInstance flow = flow(instance, "implicit");

		assertEquals(5, flow.getFlowElements().size());
		assertEquals(List.of("producer", "producer.output -> middle.input", "middle",
				"middle.output -> consumer.input", "consumer"),
				flow.getFlowElements().stream().map(element -> element.getName()).toList());
		assertSame(component(instance, "producer"), componentElement(flow, 0));
		assertSame(component(instance, "middle"), componentElement(flow, 2));
		assertSame(component(instance, "consumer"), componentElement(flow, 4));
	}

	@Test
	public void testFlowImplementationBranchNamesAndOrder() throws Exception {
		SystemInstance instance = instantiate(FILE, "BranchingTop.i");

		assertEquals(List.of("branched_1", "branched_2"), flowNames(instance));
		assertEquals(List.of("branched", "branched"),
				instance.getEndToEndFlows().stream().map(flow -> flow.getEndToEndFlow().getName()).toList());
	}

	@Test
	public void testFlowImplementationBranchesRetainDistinctPaths() throws Exception {
		SystemInstance instance = instantiate(FILE, "BranchingTop.i");
		List<EndToEndFlowInstance> flows = instance.getEndToEndFlows();

		for (EndToEndFlowInstance flow : flows) {
			assertEquals(5, flow.getFlowElements().size());
			assertEquals(FlowSpecificationInstance.class, flow.getFlowElements().get(0).eClass().getInstanceClass());
			assertEquals(ConnectionInstance.class, flow.getFlowElements().get(1).eClass().getInstanceClass());
			assertEquals(FlowSpecificationInstance.class, flow.getFlowElements().get(2).eClass().getInstanceClass());
			assertEquals(ConnectionInstance.class, flow.getFlowElements().get(3).eClass().getInstanceClass());
			assertEquals(FlowSpecificationInstance.class, flow.getFlowElements().get(4).eClass().getInstanceClass());
		}
		assertEquals(List.of("enter", "to_upper"), connectionDeclarations(connection(flows.get(0), 1)));
		assertEquals("upper", flowSpecification(flows.get(0), 2).getComponentInstance().getName());
		assertEquals(List.of("from_upper", "leave"), connectionDeclarations(connection(flows.get(0), 3)));
		assertEquals(List.of("enter", "to_lower"), connectionDeclarations(connection(flows.get(1), 1)));
		assertEquals("lower", flowSpecification(flows.get(1), 2).getComponentInstance().getName());
		assertEquals(List.of("from_lower", "leave"), connectionDeclarations(connection(flows.get(1), 3)));
	}

	@Test
	public void testSameNamedConnectionUsesDeclarationFromCurrentComponent() throws Exception {
		SystemInstance instance = instantiate(FILE, "ConnectionIdentityTop.i");
		EndToEndFlowInstance flow = flow(instance, "identity");

		assertEquals(3, flow.getFlowElements().size());
		assertEquals(List.of("link"), connectionDeclarations(connection(flow, 1)));
		assertSame(component(instance, "wanted"), componentElement(flow, 2));
	}
}
