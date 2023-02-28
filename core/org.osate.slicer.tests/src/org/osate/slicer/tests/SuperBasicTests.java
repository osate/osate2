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
public class SuperBasicTests {

	@Inject
	TestHelper<AadlPackage> myTestHelper;

	SlicerRepresentation tlg;
	SystemInstance si;

	@Before
	public void setUp() throws Exception {
		tlg = new SlicerRepresentation();
		AadlPackage pkg = myTestHelper.parseFile("org.osate.slicer.tests/aadl-models/SuperBasic.aadl");
		SystemImplementation impl = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		si = InstantiateModel.instantiate(impl);
		tlg.buildGraph(si);
	}

	@Test
	public void testForwardReachability() {
		AbstractGraph<OsateSlicerVertex, DefaultEdge> g = tlg.forwardReachability("sys_impl_Instance.b.output");
		Map<String, OsateSlicerVertex> m = g.vertexSet() // Can't query the set directly, so derive a map
				.stream()
				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));

		// Should have three vertices: b.out, c.in, and c.out
		assertEquals("Number of vertices in forward reach", 3, g.vertexSet().size());
		assertTrue("Vertex sys_impl_Instance.b.output not found", m.containsKey("sys_impl_Instance.b.output"));
		assertTrue("Vertex sys_impl_Instance.c.input not found", m.containsKey("sys_impl_Instance.c.input"));
		assertTrue("Vertex sys_impl_Instance.c.output not found", m.containsKey("sys_impl_Instance.c.output"));

		// Should have an edge from b.out to c.in and c.in to c.out
		assertEquals("Number of edges in forward reach", 2, g.edgeSet().size());
		assertTrue("Edge sys_impl_Instance.b.output -> sys_impl_Instance.c.input doesn't exist!",
				g.containsEdge(m.get("sys_impl_Instance.b.output"), m.get("sys_impl_Instance.c.input")));
		assertTrue("Edge sys_impl_Instance.c.input -> sys_impl_Instance.c.output doesn't exist!",
				g.containsEdge(m.get("sys_impl_Instance.c.input"), m.get("sys_impl_Instance.c.output")));
	}

	@Test
	public void testForwardReachComponent() {
		Collection<EObject> c = tlg
				.forwardReach(SlicerTestUtil.getInstance("sys_impl_Instance.b", ComponentCategory.ABSTRACT, si));

		// Should have two elements: b and c
		assertEquals("Number of elements in forward reach", 2, c.size());
		assertTrue("Element sys_impl_Instance.b not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.b", ComponentCategory.ABSTRACT, si)));
		assertTrue("Element sys_impl_Instance.c not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.c", ComponentCategory.ABSTRACT, si)));
	}

	@Test
	public void testForwardReachFeature() {
		var compB = SlicerTestUtil.getInstance("sys_impl_Instance.b", ComponentCategory.ABSTRACT, si);
		var compC = SlicerTestUtil.getInstance("sys_impl_Instance.c", ComponentCategory.ABSTRACT, si);
		var featBInput = SlicerTestUtil.getFeatureInstance(compB, "input");
		var featBOutput = SlicerTestUtil.getFeatureInstance(compB, "output");
		var featCInput = SlicerTestUtil.getFeatureInstance(compC, "input");
		var featCOutput = SlicerTestUtil.getFeatureInstance(compC, "output");

		var c = tlg.forwardReach(featBInput);

		// Should have four elements: b.input, b.output, c.input, c.output
		assertEquals("Number of elements in forward reach", 4, c.size());
		assertTrue("Feature sys_impl_Instance.b.input not found", c.contains(featBInput));
		assertTrue("Element sys_impl_Instance.b.output not found", c.contains(featBOutput));
		assertTrue("Feature sys_impl_Instance.c.input not found", c.contains(featCInput));
		assertTrue("Element sys_impl_Instance.c.output not found", c.contains(featCOutput));
	}

	@Test
	public void testBackwardReachability() {
		AbstractGraph<OsateSlicerVertex, DefaultEdge> g = tlg.backwardReachability("sys_impl_Instance.b.output");
		Map<String, OsateSlicerVertex> m = g.vertexSet() // Can't query the set directly, so derive a map
				.stream()
				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));

		// Should have four vertices: a.in, a.out, b.in, and b.out
		assertEquals("Number of vertices in backward reach", 4, g.vertexSet().size());
		assertTrue("Vertex sys_impl_Instance.a.input not found", m.containsKey("sys_impl_Instance.a.input"));
		assertTrue("Vertex sys_impl_Instance.a.output not found", m.containsKey("sys_impl_Instance.a.output"));
		assertTrue("Vertex sys_impl_Instance.b.input not found", m.containsKey("sys_impl_Instance.b.input"));
		assertTrue("Vertex sys_impl_Instance.b.output not found", m.containsKey("sys_impl_Instance.b.output"));

		// Should have three edges: from a.in to a.out, a.out to b.in, and b.in to to b.out
		assertEquals("Number of edges in backward reach", 3, g.edgeSet().size());
		assertTrue("Edge sys_impl_Instance.a.input -> sys_impl_Instance.a.output doesn't exist!",
				g.containsEdge(m.get("sys_impl_Instance.a.input"), m.get("sys_impl_Instance.a.output")));
		assertTrue("Edge sys_impl_Instance.a.output -> sys_impl_Instance.b.input doesn't exist!",
				g.containsEdge(m.get("sys_impl_Instance.a.output"), m.get("sys_impl_Instance.b.input")));
		assertTrue("Edge sys_impl_Instance.b.input -> sys_impl_Instance.b.output doesn't exist!",
				g.containsEdge(m.get("sys_impl_Instance.b.input"), m.get("sys_impl_Instance.b.output")));
	}

	@Test
	public void testBackwardReachComponent() {
		Collection<EObject> c = tlg
				.backwardReach(SlicerTestUtil.getInstance("sys_impl_Instance.b", ComponentCategory.ABSTRACT, si));

		// Should have two elements: a and b
		assertEquals("Number of elements in backward reach", 2, c.size());
		assertTrue("Element sys_impl_Instance.a not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.a", ComponentCategory.ABSTRACT, si)));
		assertTrue("Element sys_impl_Instance.b not found",
				c.contains(SlicerTestUtil.getInstance("sys_impl_Instance.b", ComponentCategory.ABSTRACT, si)));
	}

	@Test
	public void testBackwardReachFeature() {
		var compA = SlicerTestUtil.getInstance("sys_impl_Instance.a", ComponentCategory.ABSTRACT, si);
		var compB = SlicerTestUtil.getInstance("sys_impl_Instance.b", ComponentCategory.ABSTRACT, si);
		var featAInput = SlicerTestUtil.getFeatureInstance(compA, "input");
		var featAOutput = SlicerTestUtil.getFeatureInstance(compA, "output");
		var featBInput = SlicerTestUtil.getFeatureInstance(compB, "input");
		var featBOutput = SlicerTestUtil.getFeatureInstance(compB, "output");

		var c = tlg.backwardReach(featBOutput);

		// Should have four elements: a.input, a.output, b.input, b.output
		assertEquals("Number of elements in forward reach", 4, c.size());
		assertTrue("Feature sys_impl_Instance.b.input not found", c.contains(featAInput));
		assertTrue("Element sys_impl_Instance.b.output not found", c.contains(featAOutput));
		assertTrue("Feature sys_impl_Instance.c.input not found", c.contains(featBInput));
		assertTrue("Element sys_impl_Instance.c.output not found", c.contains(featBOutput));
	}
}
