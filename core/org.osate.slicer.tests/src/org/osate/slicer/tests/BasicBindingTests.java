/*******************************************************************************
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
package org.osate.slicer.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.jgrapht.graph.AbstractGraph;
import org.jgrapht.graph.DefaultEdge;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.TypeTokenInstance;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.slicer.OsateSlicerVertex;
import org.osate.slicer.SlicerRepresentation;
import org.osate.testsupport.TestHelper;

import com.google.common.base.Functions;
import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class BasicBindingTests {
	@Inject
	TestHelper<AadlPackage> myTestHelper;

	private SlicerRepresentation tlg;
	private SystemInstance si;

	private String[] vert1, vert2, vert3, vert4;

//	Tuesday, December 8, 2022 -- Disabled tests related to the fourth source and sink
//	They can / should be re-enabled when this issue is resolved: https://github.com/saeaadl/emv2/issues/72

	@Before
	public void setUp() throws Exception {
		tlg = new SlicerRepresentation();
		AadlPackage pkg = myTestHelper.parseFile("org.osate.slicer.tests/aadl-models/BasicBinding.aadl");
		SystemImplementation impl = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		si = InstantiateModel.instantiate(impl);
		tlg.buildGraph(si);

		vert1 = new String[4];
		vert1[0] = "s_i_Instance.proc.o1Src.ServiceError";
		vert1[1] = "s_i_Instance.proc.bindings.ServiceError";
		vert1[2] = "s_i_Instance.ps.t.processor.ServiceError";
		vert1[3] = "s_i_Instance.ps.t.o1Snk.ServiceError";

		vert2 = new String[4];
		vert2[0] = "s_i_Instance.d.o2Src.ServiceError";
		vert2[1] = "s_i_Instance.d.memory.ServiceError";
		vert2[2] = "s_i_Instance.m.bindings.ServiceError";
		vert2[3] = "s_i_Instance.m.o2Snk.ServiceError";

		vert3 = new String[4];
		vert3[0] = "s_i_Instance.b.o3Src.ServiceError";
		vert3[1] = "s_i_Instance.b.bindings.ServiceError";
		vert3[2] = "s_i_Instance.vb.connection.ServiceError";
		vert3[3] = "s_i_Instance.vb.o3Snk.ServiceError";

//		vert4 = new String[4];
//		vert4[0] = "s_i_Instance.sys1.o4Src.ServiceError";
//		vert4[1] = "s_i_Instance.sys1.bindings.ServiceError";
//		vert4[2] = "s_i_Instance.sys2.binding.ServiceError";
//		vert4[3] = "s_i_Instance.sys2.o4Snk.ServiceError";
	}

	@Test
	public void testForwardReachability() {
		AbstractGraph<OsateSlicerVertex, DefaultEdge> g1 = tlg.forwardReachability(vert1[1]);
		AbstractGraph<OsateSlicerVertex, DefaultEdge> g2 = tlg.forwardReachability(vert2[1]);
		AbstractGraph<OsateSlicerVertex, DefaultEdge> g3 = tlg.forwardReachability(vert3[1]);
//		AbstractGraph<OsateSlicerVertex, DefaultEdge> g4 = tlg.forwardReachability(vert4[1]);
		Map<String, OsateSlicerVertex> m1 = g1.vertexSet() // Can't query the set directly, so derive a map
				.stream()
				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));
		Map<String, OsateSlicerVertex> m2 = g2.vertexSet()
				.stream()
				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));
		Map<String, OsateSlicerVertex> m3 = g3.vertexSet()
				.stream()
				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));
//		Map<String, OsateSlicerVertex> m4 = g4.vertexSet()
//				.stream()
//				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));

		assertEquals("Number of vertices in forward reach", 3, g1.vertexSet().size());
		assertTrue("Wrong vertices found in forward reach subgraph",
				m1.keySet().containsAll(Arrays.asList(vert1).subList(1, 3)));
		assertEquals("Number of vertices in forward reach", 3, g2.vertexSet().size());
		assertTrue("Wrong vertices found in forward reach subgraph",
				m2.keySet().containsAll(Arrays.asList(vert2).subList(1, 3)));
		assertEquals("Number of vertices in forward reach", 3, g3.vertexSet().size());
		assertTrue("Wrong vertices found in forward reach subgraph",
				m3.keySet().containsAll(Arrays.asList(vert3).subList(1, 3)));
//		assertEquals("Number of vertices in forward reach", 4, g4.vertexSet().size());
//		assertTrue("Wrong vertices found in forward reach subgraph",
//				m4.keySet().containsAll(Arrays.asList(vert4).subList(1, 3)));

		// Should have two edges connecting the vertices in a linear path
		assertEquals("Number of edges in forward reach", 2, g1.edgeSet().size());
		assertEquals("Number of edges in forward reach", 2, g2.edgeSet().size());
		assertEquals("Number of edges in forward reach", 2, g3.edgeSet().size());
//		assertEquals("Number of edges in forward reach", 2, g4.edgeSet().size());
		for (int i = 1; i < 3; i++) {
			assertTrue("Edge " + vert1[i] + " -> " + vert1[i + 1] + " doesn't exist!",
					g1.containsEdge(m1.get(vert1[i]), m1.get(vert1[i + 1])));
			assertTrue("Edge " + vert2[i] + " -> " + vert2[i + 1] + " doesn't exist!",
					g2.containsEdge(m2.get(vert2[i]), m2.get(vert2[i + 1])));
			assertTrue("Edge " + vert3[i] + " -> " + vert3[i + 1] + " doesn't exist!",
					g3.containsEdge(m3.get(vert3[i]), m3.get(vert3[i + 1])));
//			assertTrue("Edge " + vert4[i] + " -> " + vert4[i + 1] + " doesn't exist!",
//					g4.containsEdge(m4.get(vert3[i]), m4.get(vert4[i + 1])));
		}
	}

	@Test
	public void testSuccessfulForwardReach() {
		var component = SlicerTestUtil.getInstance("s_i_Instance.proc", ComponentCategory.PROCESSOR, si);
		var binding = BindingType.BINDINGS;
		var annexInstance = (EMV2AnnexInstance) component.getAnnexInstances().get(0);
		var token = (TypeTokenInstance) annexInstance.getPropagations().get(0).getOutTypeSet().getElements().get(0);
		var reachableComponents = tlg.forwardReach(component, binding, token);
		assertEquals("Number of elements in forward reach", 3, reachableComponents.size());
	}

	@Test
	public void testBackwardReachability() {
		AbstractGraph<OsateSlicerVertex, DefaultEdge> g1 = tlg.backwardReachability(vert1[2]);
		AbstractGraph<OsateSlicerVertex, DefaultEdge> g2 = tlg.backwardReachability(vert2[2]);
		AbstractGraph<OsateSlicerVertex, DefaultEdge> g3 = tlg.backwardReachability(vert3[2]);
//		AbstractGraph<OsateSlicerVertex, DefaultEdge> g4 = tlg.backwardReachability(vert4[2]);
		Map<String, OsateSlicerVertex> m1 = g1.vertexSet() // Can't query the set directly, so derive a map
				.stream()
				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));
		Map<String, OsateSlicerVertex> m2 = g2.vertexSet()
				.stream()
				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));
		Map<String, OsateSlicerVertex> m3 = g3.vertexSet()
				.stream()
				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));
//		Map<String, OsateSlicerVertex> m4 = g4.vertexSet()
//				.stream()
//				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));

		assertEquals("Number of vertices in backward reach", 3, g1.vertexSet().size());
		assertTrue("Wrong vertices found in backward reach subgraph",
				m1.keySet().containsAll(Arrays.asList(vert1).subList(0, 2)));
		assertEquals("Number of vertices in backward reach", 3, g2.vertexSet().size());
		assertTrue("Wrong vertices found in backward reach subgraph",
				m2.keySet().containsAll(Arrays.asList(vert2).subList(0, 2)));
		assertEquals("Number of vertices in backward reach", 3, g3.vertexSet().size());
		assertTrue("Wrong vertices found in backward reach subgraph",
				m3.keySet().containsAll(Arrays.asList(vert3).subList(0, 2)));
//		assertEquals("Number of vertices in backward reach", 4, g4.vertexSet().size());
//		assertTrue("Wrong vertices found in backward reach subgraph",
//				m4.keySet().containsAll(Arrays.asList(vert4).subList(0, 2)));

		// Should have two edges connecting the vertices in a linear path
		assertEquals("Number of edges in backward reach", 2, g1.edgeSet().size());
		assertEquals("Number of edges in backward reach", 2, g2.edgeSet().size());
		assertEquals("Number of edges in backward reach", 2, g3.edgeSet().size());
//		assertEquals("Number of edges in backward reach", 2, g4.edgeSet().size());
		for (int i = 0; i < 2; i++) {
			assertTrue("Edge " + vert1[i] + " -> " + vert1[i + 1] + " doesn't exist!",
					g1.containsEdge(m1.get(vert1[i]), m1.get(vert1[i + 1])));
			assertTrue("Edge " + vert2[i] + " -> " + vert2[i + 1] + " doesn't exist!",
					g2.containsEdge(m2.get(vert2[i]), m2.get(vert2[i + 1])));
			assertTrue("Edge " + vert3[i] + " -> " + vert3[i + 1] + " doesn't exist!",
					g3.containsEdge(m3.get(vert3[i]), m3.get(vert3[i + 1])));
//			assertTrue("Edge " + vert4[i] + " -> " + vert4[i + 1] + " doesn't exist!",
//					g3.containsEdge(m4.get(vert4[i]), m4.get(vert4[i + 1])));
		}
	}

	@Test
	public void testSuccessfulBackwardReach() {
		var component = SlicerTestUtil.getInstance("s_i_Instance.ps.t", ComponentCategory.THREAD, si);
		var binding = BindingType.PROCESSOR;
		var annexInstance = (EMV2AnnexInstance) component.getAnnexInstances().get(0);
		var token = (TypeTokenInstance) annexInstance.getPropagations().get(0).getInTypeSet().getElements().get(0);
		var reachableComponents = tlg.backwardReach(component, binding, token);
		assertEquals("Number of elements in backward reach", 3, reachableComponents.size());
	}

}
