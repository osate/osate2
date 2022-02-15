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
public class BasicErrorFlowTests {
	@Inject
	TestHelper<AadlPackage> myTestHelper;

	private SlicerRepresentation tlg;
	private SystemInstance si;
	private String[] vertices;

	@Before
	public void setUp() throws Exception {
		tlg = new SlicerRepresentation();
		AadlPackage pkg = myTestHelper.parseFile("org.osate.slicer.tests/aadl-models/BasicErrorFlow.aadl");
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
}
