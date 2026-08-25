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
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class AccessEndToEndFlowInstantiationTest extends AbstractEndToEndFlowInstantiationTest {
	private static final String FILE = "AccessFlows.aadl";

	@Test
	public void testDataAccessFlowElements() throws Exception {
		SystemInstance instance = instantiate(FILE, "DirectAccessTop.i");
		EndToEndFlowInstance flow = flow(instance, "data_path");

		assertEquals(5, flow.getFlowElements().size());
		assertEquals(List.of("data_in"), connectionDeclarations(connection(flow, 1)));
		assertEquals(ComponentCategory.DATA, componentElement(flow, 2).getCategory());
		assertEquals("shared_data", componentElement(flow, 2).getName());
		assertEquals(List.of("data_out"), connectionDeclarations(connection(flow, 3)));
	}

	@Test
	public void testSubprogramAccessFlowElements() throws Exception {
		SystemInstance instance = instantiate(FILE, "DirectAccessTop.i");
		EndToEndFlowInstance flow = flow(instance, "subprogram_path");

		assertEquals(5, flow.getFlowElements().size());
		assertEquals(List.of("subprogram_in"), connectionDeclarations(connection(flow, 1)));
		assertEquals(ComponentCategory.SUBPROGRAM, componentElement(flow, 2).getCategory());
		assertEquals("shared_subprogram", componentElement(flow, 2).getName());
		assertEquals(List.of("subprogram_out"), connectionDeclarations(connection(flow, 3)));
	}

	@Test
	public void testDirectAccessFlowOrder() throws Exception {
		SystemInstance instance = instantiate(FILE, "DirectAccessTop.i");

		assertEquals(List.of("data_path", "subprogram_path"), flowNames(instance));
	}

	@Test
	public void testMultipleAccessCandidatesCreateClones() throws Exception {
		SystemInstance instance = instantiate(FILE, "MultipleAccessTop.i");
		ComponentInstance container = component(instance, "container");

		assertEquals(List.of("access_path_1", "access_path_2"), flowNames(container));
	}

	@Test
	public void testMultipleAccessCandidatesRetainDistinctTargets() throws Exception {
		SystemInstance instance = instantiate(FILE, "MultipleAccessTop.i");
		ComponentInstance container = component(instance, "container");
		List<EndToEndFlowInstance> flows = container.getEndToEndFlows();

		assertEquals("first_data", componentElement(flows.get(0), 2).getName());
		assertEquals("second_data", componentElement(flows.get(1), 2).getName());
		assertSame(component(instance, "first_data"), componentElement(flows.get(0), 2));
		assertSame(component(instance, "second_data"), componentElement(flows.get(1), 2));
	}

	@Test
	public void testSameTargetAccessBranchesRetainTheirOwnConnectionPaths() throws Exception {
		SystemInstance instance = instantiate(FILE, "SameTargetMultipleAccessTop.i");
		ComponentInstance container = component(instance, "container");
		List<EndToEndFlowInstance> flows = flowsFor(container, "access_path");

		assertEquals(List.of("access_path_1", "access_path_2"),
				flows.stream().map(EndToEndFlowInstance::getName).toList());
		assertEquals(List.of("first", "from_boundary"), connectionDeclarations(connection(flows.get(0), 3)));
		assertEquals(List.of("second", "from_boundary"), connectionDeclarations(connection(flows.get(1), 3)));
	}

	@Test
	public void testInvalidAccessAlternativeDoesNotCommitAnUntraversedFork() throws Exception {
		InstantiationResult result = instantiateWithErrors(FILE, "MixedValidInvalidAccessTop.i");
		ComponentInstance container = component(result.instance(), "container");
		EndToEndFlowInstance flow = flow(container, "access_path");

		assertEquals(List.of("access_path"), flowNames(container));
		assertEquals(5, flow.getFlowElements().size());
		assertEquals(List.of("valid", "from_boundary"), connectionDeclarations(connection(flow, 3)));
		assertEquals(1, result.messages()
				.stream()
				.filter(message -> message.message.contains("is not a proxy for a data or subprogram component"))
				.count());
	}

	@Test
	public void testSubprogramAccessCandidatesRetainDistinctTargets() throws Exception {
		SystemInstance instance = instantiate(FILE, "MultipleSubprogramAccessTop.i");
		ComponentInstance container = component(instance, "container");
		List<EndToEndFlowInstance> flows = container.getEndToEndFlows();

		assertEquals(List.of("access_path_1", "access_path_2"), flowNames(container));
		assertEquals("first_subprogram", componentElement(flows.get(0), 2).getName());
		assertEquals("second_subprogram", componentElement(flows.get(1), 2).getName());
		assertSame(component(instance, "first_subprogram"), componentElement(flows.get(0), 2));
		assertSame(component(instance, "second_subprogram"), componentElement(flows.get(1), 2));
	}

	@Test
	public void testFlowStartingAtAccessFeatureIsDiscardedWhenItHasNoElements() throws Exception {
		SystemInstance instance = instantiate(FILE, "MultipleAccessTop.i");

		assertTrue(flowsFor(component(instance, "container"), "starts_at_access").isEmpty());
	}

	@Test
	public void testUnresolvedBoundaryAccessDiscardsEmptyFlowsAndReportsSystemBoundaryErrors() throws Exception {
		InstantiationResult result = instantiateWithErrors(FILE, "AccessContainer.i");

		assertTrue(result.instance().getEndToEndFlows().isEmpty());
		assertEquals(List.of(
				"access_path could not be instantiated: Access feature "
						+ "E2E_Access_Flows::AccessContainer.data_access is not a proxy for a data or subprogram component.",
				"Flow instance leaves system instance for flow AccessContainer_i_Instance.starts_at_access"),
				result.messages().stream().map(message -> message.message).toList());
		assertEquals(result.instance(), result.messages().get(0).where);
		for (var message : result.messages()) {
			assertEquals(QueuingAnalysisErrorReporter.Kind.ERROR, message.kind);
		}
	}
}
