/*******************************************************************************
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file).
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
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
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
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.slicer.OsateSlicerVertex;
import org.osate.slicer.SlicerRepresentation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.common.base.Functions;
import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class BasicEndToEndFlowTests {
	@Inject
	TestHelper<AadlPackage> myTestHelper;

	private SlicerRepresentation tlg;
	private SystemInstance si;
	private String[] vertices;

	@Before
	public void setUp() throws Exception {
		tlg = new SlicerRepresentation();
		AadlPackage pkg = myTestHelper.parseFile("org.osate.slicer.tests/aadl-models/BasicEndToEndFlow.aadl");
		SystemImplementation impl = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		si = InstantiateModel.instantiate(impl);
		tlg.buildGraph(si);
		
		vertices = new String[12];
		vertices[0] = "sys_impl_Instance.a1.o";
		vertices[1] = "sys_impl_Instance.a2.o";
		vertices[2] = "sys_impl_Instance.a3.o";
		vertices[3] = "sys_impl_Instance.b.i1";
		vertices[4] = "sys_impl_Instance.b.i2";
		vertices[5] = "sys_impl_Instance.b.i3";
		vertices[6] = "sys_impl_Instance.b.o1";
		vertices[7] = "sys_impl_Instance.b.o2";
		vertices[8] = "sys_impl_Instance.b.o3";
		vertices[9] = "sys_impl_Instance.c1.i";
		vertices[10] = "sys_impl_Instance.c2.i";
		vertices[11] = "sys_impl_Instance.c3.i";
	}

	@Test
	public void testSuccessfulForwardReachability() {
		AbstractGraph<OsateSlicerVertex, DefaultEdge> g = tlg.forwardReachability(vertices[2]);
		Map<String, OsateSlicerVertex> m = g.vertexSet() // Can't query the set directly, so derive a map
				.stream()
				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));

		Integer[] verticesInSlice = new Integer[4];
		verticesInSlice[0] = 2;
		verticesInSlice[1] = 5;
		verticesInSlice[2] = 6;
		verticesInSlice[3] = 9;

		assertEquals("Number of vertices in forward reach", verticesInSlice.length, g.vertexSet().size());
		Arrays.asList(verticesInSlice)
				.stream()
				.forEach(v -> assertTrue("Element " + vertices[v] + " not found", m.keySet().contains(vertices[v])));

		// Should have a straight path through the graph, so one less edge than vertex
		assertEquals("Number of edges in forward reach", verticesInSlice.length - 1, g.edgeSet().size());
		for (int i = 0; i < verticesInSlice.length - 1; i++) {
			assertTrue("Edge " + vertices[verticesInSlice[i]] + " -> " + vertices[verticesInSlice[i+1]] + " doesn't exist!",
					g.containsEdge(m.get(vertices[verticesInSlice[i]]), m.get(vertices[verticesInSlice[i + 1]])));
		}
	}

	@Test
	public void testSuccessfulForwardReach() {
		Collection<EObject> c = tlg
				.forwardReach(SlicerTestUtil.getInstance("sys_impl_Instance.a3", ComponentCategory.ABSTRACT, si));

		assertEquals("Number of elements in forward reach", 3, c.size());
		assertTrue("Element sys_impl_Instance.a3 not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.a3", ComponentCategory.ABSTRACT, si)));
		assertTrue("Element sys_impl_Instance.b not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.b", ComponentCategory.ABSTRACT, si)));
		assertTrue("Element sys_impl_Instance.c1 not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.c1", ComponentCategory.ABSTRACT, si)));
	}

	@Test
	public void testDeadendForwardReachability() {
		AbstractGraph<OsateSlicerVertex, DefaultEdge> g = tlg.forwardReachability(vertices[1]);
		Map<String, OsateSlicerVertex> m = g.vertexSet() // Can't query the set directly, so derive a map
				.stream()
				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));

		Integer[] verticesInSlice = new Integer[2];
		verticesInSlice[0] = 1;
		verticesInSlice[1] = 4;

		assertEquals("Number of vertices in forward reach", verticesInSlice.length, g.vertexSet().size());
		Arrays.asList(verticesInSlice)
				.stream()
				.forEach(v -> assertTrue("Element " + vertices[v] + " not found", m.keySet().contains(vertices[v])));

		// Should have a straight path through the graph, so one less edge than vertex
		assertEquals("Number of edges in forward reach", verticesInSlice.length - 1, g.edgeSet().size());
		for (int i = 0; i < verticesInSlice.length - 1; i++) {
			assertTrue(
					"Edge " + vertices[verticesInSlice[i]] + " -> " + vertices[verticesInSlice[i + 1]]
							+ " doesn't exist!",
					g.containsEdge(m.get(vertices[verticesInSlice[i]]), m.get(vertices[verticesInSlice[i + 1]])));
		}
	}

	@Test
	public void testDeadendForwardReach() {
		Collection<EObject> c = tlg
				.forwardReach(SlicerTestUtil.getInstance("sys_impl_Instance.a2", ComponentCategory.ABSTRACT, si));

		assertEquals("Number of elements in forward reach", 2, c.size());
		assertTrue("Element sys_impl_Instance.a3 not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.a2", ComponentCategory.ABSTRACT, si)));
		assertTrue("Element sys_impl_Instance.b not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.b", ComponentCategory.ABSTRACT, si)));
	}

	@Test
	public void testSuccessfulBackwardReachability() {
		AbstractGraph<OsateSlicerVertex, DefaultEdge> g = tlg.backwardReachability(vertices[9]);
		Map<String, OsateSlicerVertex> m = g.vertexSet() // Can't query the set directly, so derive a map
				.stream()
				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));

		Integer[] verticesInSlice = new Integer[4];
		verticesInSlice[0] = 2;
		verticesInSlice[1] = 5;
		verticesInSlice[2] = 6;
		verticesInSlice[3] = 9;

		assertEquals("Number of vertices in backward reach", verticesInSlice.length, g.vertexSet().size());
		Arrays.asList(verticesInSlice)
				.stream()
				.forEach(v -> assertTrue("Element " + vertices[v] + " not found", m.keySet().contains(vertices[v])));

		// Should have a straight path through the graph, so one less edge than vertex
		assertEquals("Number of edges in backward reach", verticesInSlice.length - 1, g.edgeSet().size());
		for (int i = 0; i < verticesInSlice.length - 1; i++) {
			assertTrue(
					"Edge " + vertices[verticesInSlice[i]] + " -> " + vertices[verticesInSlice[i + 1]]
							+ " doesn't exist!",
					g.containsEdge(m.get(vertices[verticesInSlice[i]]), m.get(vertices[verticesInSlice[i + 1]])));
		}
	}

	@Test
	public void testSuccessfulBackwardReach() {
		Collection<EObject> c = tlg
				.backwardReach(SlicerTestUtil.getInstance("sys_impl_Instance.c1", ComponentCategory.ABSTRACT, si));

		assertEquals("Number of elements in forward reach", 3, c.size());
		assertTrue("Element sys_impl_Instance.a3 not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.a3", ComponentCategory.ABSTRACT, si)));
		assertTrue("Element sys_impl_Instance.b not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.b", ComponentCategory.ABSTRACT, si)));
		assertTrue("Element sys_impl_Instance.c1 not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.c1", ComponentCategory.ABSTRACT, si)));
	}

	@Test
	public void testDeadendBackwardReachability() {
		AbstractGraph<OsateSlicerVertex, DefaultEdge> g = tlg.backwardReachability(vertices[10]);
		Map<String, OsateSlicerVertex> m = g.vertexSet() // Can't query the set directly, so derive a map
				.stream()
				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));

		Integer[] verticesInSlice = new Integer[2];
		verticesInSlice[0] = 7;
		verticesInSlice[1] = 10;

		assertEquals("Number of vertices in backward reach", verticesInSlice.length, g.vertexSet().size());
		Arrays.asList(verticesInSlice)
				.stream()
				.forEach(v -> assertTrue("Element " + vertices[v] + " not found", m.keySet().contains(vertices[v])));

		// Should have a straight path through the graph, so one less edge than vertex
		assertEquals("Number of edges in backward reach", verticesInSlice.length - 1, g.edgeSet().size());
		for (int i = 0; i < verticesInSlice.length - 1; i++) {
			assertTrue(
					"Edge " + vertices[verticesInSlice[i]] + " -> " + vertices[verticesInSlice[i + 1]]
							+ " doesn't exist!",
					g.containsEdge(m.get(vertices[verticesInSlice[i]]), m.get(vertices[verticesInSlice[i + 1]])));
		}
	}

	@Test
	public void testDeadendBackwardReach() {
		Collection<EObject> c = tlg
				.backwardReach(SlicerTestUtil.getInstance("sys_impl_Instance.c2", ComponentCategory.ABSTRACT, si));

		assertEquals("Number of elements in forward reach", 2, c.size());
		assertTrue("Element sys_impl_Instance.a3 not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.c2", ComponentCategory.ABSTRACT, si)));
		assertTrue("Element sys_impl_Instance.b not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.b", ComponentCategory.ABSTRACT, si)));
	}
}
