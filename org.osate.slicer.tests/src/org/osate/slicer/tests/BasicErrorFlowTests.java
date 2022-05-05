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
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.TypeTokenInstance;
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
public class BasicErrorFlowTests {
	@Inject
	TestHelper<AadlPackage> myTestHelper;

	private SlicerRepresentation tlg;
	private SystemInstance si;
	private String[] vertices;

	@Before
	public void setUp() throws Exception {
		tlg = new SlicerRepresentation();
		var pkg = myTestHelper.parseFile("org.osate.slicer.tests/aadl-models/BasicErrorFlow.aadl");
		var impl = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		si = InstantiateModel.instantiate(impl);
		tlg.buildGraph(si);

		vertices = new String[6];
		vertices[0] = "sys_impl_Instance.a.o1TimingSrc.ItemTimingError";
		vertices[1] = "sys_impl_Instance.a.o1.ItemTimingError";
		vertices[2] = "sys_impl_Instance.b.i1.ItemTimingError";
		vertices[3] = "sys_impl_Instance.b.o3.ItemTimingError";
		vertices[4] = "sys_impl_Instance.c.i3.ItemTimingError";
		vertices[5] = "sys_impl_Instance.c.o3TimingSink.ItemTimingError";
	}

	@Test
	public void testForwardReachability() {
		AbstractGraph<OsateSlicerVertex, DefaultEdge> g = tlg.forwardReachability(vertices[2]);
		Map<String, OsateSlicerVertex> m = g.vertexSet() // Can't query the set directly, so derive a map
				.stream()
				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));

		assertEquals("Number of vertices in forward reach", 4, g.vertexSet().size());
		assertTrue("Wrong vertices found in forward reach subgraph",
				m.keySet().containsAll(Arrays.asList(vertices).subList(2, 6)));

		// Should have three edges connecting the vertices in a linear path
		assertEquals("Number of edges in forward reach", 3, g.edgeSet().size());
		for (int i = 2; i < 4; i++) {
			assertTrue("Edge " + vertices[i] + " -> " + vertices[i + 1] + " doesn't exist!",
					g.containsEdge(m.get(vertices[i]), m.get(vertices[i + 1])));
		}
	}

	@Test
	public void testSuccessfulForwardReach() {
		var component = SlicerTestUtil.getInstance("sys_impl_Instance.b", ComponentCategory.ABSTRACT, si);
		var feature = SlicerTestUtil.getFeatureInstance(component, "i1");
		var annexInstance = (EMV2AnnexInstance) component.getAnnexInstances().get(0);
		var token = (TypeTokenInstance) annexInstance.getPropagations().get(0).getInTypeSet().getElements().get(0);
		var reachableComponents = tlg.forwardReach(feature, token);
		assertEquals("Number of elements in forward reach", 4, reachableComponents.size());
		// TODO: Probably should test the elements contained here. Use Joe's JUnit 5 code?
	}

	@Test
	public void testBackwardReachability() {
		AbstractGraph<OsateSlicerVertex, DefaultEdge> g = tlg.backwardReachability(vertices[3]);
		Map<String, OsateSlicerVertex> m = g.vertexSet() // Can't query the set directly, so derive a map
				.stream()
				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));

		assertEquals("Number of vertices in forward reach", 4, g.vertexSet().size());
		assertTrue("Wrong vertices found in forward reach subgraph",
				m.keySet().containsAll(Arrays.asList(vertices).subList(0, 4)));

		// Should have three edges connecting the vertices in a linear path
		assertEquals("Number of edges in forward reach", 3, g.edgeSet().size());
		for (int i = 0; i < 3; i++) {
			assertTrue("Edge " + vertices[i] + " -> " + vertices[i + 1] + " doesn't exist!",
					g.containsEdge(m.get(vertices[i]), m.get(vertices[i + 1])));
		}
	}

	@Test
	public void testSuccessfulBackwardReach() {
		var component = SlicerTestUtil.getInstance("sys_impl_Instance.b", ComponentCategory.ABSTRACT, si);
		var feature = SlicerTestUtil.getFeatureInstance(component, "o3");
		var annexInstance = (EMV2AnnexInstance) component.getAnnexInstances().get(0);
		var token = (TypeTokenInstance) annexInstance.getPropagations().get(0).getInTypeSet().getElements().get(0);
		var reachableComponents = tlg.backwardReach(feature, token);
		assertEquals("Number of elements in backward reach", 4, reachableComponents.size());
		// TODO: Probably should test the elements contained here. Use Joe's JUnit 5 code?
	}

}
