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
import org.osate.aadl2.instance.ComponentInstance;
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
		assertEquals(3, g.vertexSet().size());
		assertTrue(m.containsKey("sys_impl_Instance.b.output"));
		assertTrue(m.containsKey("sys_impl_Instance.c.input"));
		assertTrue(m.containsKey("sys_impl_Instance.c.output"));

		// Should have an edge from b.out to c.in and c.in to c.out
		assertEquals(2, g.edgeSet().size());
		assertTrue(g.containsEdge(m.get("sys_impl_Instance.b.output"), m.get("sys_impl_Instance.c.input")));
		assertTrue(g.containsEdge(m.get("sys_impl_Instance.c.input"), m.get("sys_impl_Instance.c.output")));
	}

	@Test
	public void testForwardReach() {
		Collection<EObject> c = tlg.forwardReach(getAbstractInstance("sys_impl_Instance.b"));

		// Should have two elements: b and c
		assertEquals(2, c.size());
		c.contains(getAbstractInstance("sys_impl_Instance.b"));
		c.contains(getAbstractInstance("sys_impl_Instance.c"));
	}

	@Test
	public void testBackwardReachability() {
		AbstractGraph<OsateSlicerVertex, DefaultEdge> g = tlg.backwardReachability("sys_impl_Instance.b.output");
		Map<String, OsateSlicerVertex> m = g.vertexSet() // Can't query the set directly, so derive a map
				.stream()
				.collect(Collectors.toMap(OsateSlicerVertex::getName, Functions.identity()));

		// Should have four vertices: a.in, a.out, b.in, and b.out
		assertEquals(4, g.vertexSet().size());
		assertTrue(m.containsKey("sys_impl_Instance.a.input"));
		assertTrue(m.containsKey("sys_impl_Instance.a.output"));
		assertTrue(m.containsKey("sys_impl_Instance.b.input"));
		assertTrue(m.containsKey("sys_impl_Instance.b.output"));

		// Should have three edges: from a.in to a.out, a.out to b.in, and b.in to to b.out
		assertEquals(3, g.edgeSet().size());
		assertTrue(g.containsEdge(m.get("sys_impl_Instance.a.input"), m.get("sys_impl_Instance.a.output")));
		assertTrue(g.containsEdge(m.get("sys_impl_Instance.a.output"), m.get("sys_impl_Instance.b.input")));
		assertTrue(g.containsEdge(m.get("sys_impl_Instance.b.input"), m.get("sys_impl_Instance.b.output")));
	}

	@Test
	public void testBackwardReach() {
		Collection<EObject> c = tlg.forwardReach(getAbstractInstance("sys_impl_Instance.b"));

		// Should have two elements: a and b
		assertEquals(2, c.size());
		c.contains(getAbstractInstance("sys_impl_Instance.a"));
		c.contains(getAbstractInstance("sys_impl_Instance.b"));
	}

	private ComponentInstance getAbstractInstance(String name) {
		return si.getAllComponentInstances(ComponentCategory.ABSTRACT)
				.stream()
				.filter(ci -> name.equals(tlg.getCompleteFeatureName(ci)))
				.findFirst()
				.get();
	}
}
