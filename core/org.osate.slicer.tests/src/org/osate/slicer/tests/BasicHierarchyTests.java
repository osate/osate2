/*******************************************************************************
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
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
public class BasicHierarchyTests {

	@Inject
	TestHelper<AadlPackage> myTestHelper;

	private SlicerRepresentation tlg;
	private SystemInstance si;
	private String[] vertices;

	@Before
	public void setUp() throws Exception {
		tlg = new SlicerRepresentation();
		AadlPackage pkg = myTestHelper
				.parseFile("org.osate.slicer.tests/aadl-models/BasicHierarchy.aadl");
		SystemImplementation impl = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		si = InstantiateModel.instantiate(impl);
		tlg.buildGraph(si);

		vertices = new String[8];
		vertices[0] = "sys_impl_Instance.p1.pIn";
		vertices[1] = "sys_impl_Instance.p1.pOut";
		vertices[2] = "sys_impl_Instance.p2.pIn";
		vertices[3] = "sys_impl_Instance.p2.t1.tIn";
		vertices[4] = "sys_impl_Instance.p2.t1.tOut";
		vertices[5] = "sys_impl_Instance.p2.pOut";
		vertices[6] = "sys_impl_Instance.p3.pIn";
		vertices[7] = "sys_impl_Instance.p3.pOut";
	}

	@Test
	public void testForwardReachability() {
		AbstractGraph<OsateSlicerVertex, DefaultEdge> g = tlg.forwardReachability("sys_impl_Instance.p1.pOut");
		Map<String, OsateSlicerVertex> m = g.vertexSet() // Can't query the set directly, so derive a map
				.stream()
				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));

		assertEquals("Number of vertices in forward reach", 7, g.vertexSet().size());
		assertTrue("Wrong vertices found in forward reach subgraph",
				m.keySet().containsAll(Arrays.asList(vertices).subList(1, 8)));

		// Should have six edges connecting the vertices in a linear path
		assertEquals("Number of edges in forward reach", 6, g.edgeSet().size());
		for (int i = 1; i < 7; i++) {
			assertTrue("Edge " + vertices[i] + " -> " + vertices[i + 1] + " doesn't exist!",
					g.containsEdge(m.get(vertices[i]), m.get(vertices[i + 1])));
		}
	}

	@Test
	public void testForwardReach() {
		Collection<EObject> c = tlg
				.forwardReach(SlicerTestUtil.getInstance("sys_impl_Instance.p1", ComponentCategory.PROCESS, si));

		assertEquals("Number of elements in forward reach", 4, c.size());
		assertTrue("Element sys_impl_Instance.p1 not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.p1", ComponentCategory.PROCESS, si)));
		assertTrue("Element sys_impl_Instance.p2 not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.p2", ComponentCategory.PROCESS, si)));
		assertTrue("Element sys_impl_Instance.p2.t1 not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.p2.t1", ComponentCategory.THREAD, si)));
		assertTrue("Element sys_impl_Instance.p3 not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.p3", ComponentCategory.PROCESS, si)));
	}

	@Test
	public void testBackwardReachability() {
		AbstractGraph<OsateSlicerVertex, DefaultEdge> g = tlg.backwardReachability("sys_impl_Instance.p2.pOut");
		Map<String, OsateSlicerVertex> m = g.vertexSet() // Can't query the set directly, so derive a map
				.stream()
				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));

		assertEquals("Number of vertices in backward reach", 6, g.vertexSet().size());
		assertTrue("Wrong vertices found in backward reach subgraph",
				m.keySet().containsAll(Arrays.asList(vertices).subList(0, 6)));

		// Should have five edges connecting the vertices in a linear path
		assertEquals("Number of edges in backward reach", 5, g.edgeSet().size());
		for (int i = 0; i < 5; i++) {
			assertTrue("Edge " + vertices[i] + " -> " + vertices[i + 1] + " doesn't exist!",
					g.containsEdge(m.get(vertices[i]), m.get(vertices[i + 1])));
		}
	}

	@Test
	public void testBackwardReach() {
		Collection<EObject> c = tlg
				.backwardReach(SlicerTestUtil.getInstance("sys_impl_Instance.p3", ComponentCategory.PROCESS, si));

		assertEquals("Number of elements in backward reach", 4, c.size());
		assertTrue("Element sys_impl_Instance.p1 not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.p1", ComponentCategory.PROCESS, si)));
		assertTrue("Element sys_impl_Instance.p2 not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.p2", ComponentCategory.PROCESS, si)));
		assertTrue("Element sys_impl_Instance.p2.t1 not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.p2.t1", ComponentCategory.THREAD, si)));
		assertTrue("Element sys_impl_Instance.p3 not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.p3", ComponentCategory.PROCESS, si)));
	}
}
