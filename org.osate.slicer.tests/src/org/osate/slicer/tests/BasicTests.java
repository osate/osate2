package org.osate.slicer.tests;

import org.junit.Before;
import org.junit.Test;
import org.osate.slicer.SlicerRepresentation;

public class BasicTests {

	private final String a = "a";
	private final String b = "b";
	private final String c = "c";
	private final String d = "d";
	private final String e = "e";
	SlicerRepresentation tlg;

	@Before
	public void setUp() throws Exception {
		tlg = new SlicerRepresentation();

		// Build vertices
		tlg.addVertex(a);
		tlg.addVertex(b);
		tlg.addVertex(c);
		tlg.addVertex(d);
		tlg.addVertex(e);

		// Add edges
		tlg.addEdge(a, b);
		tlg.addEdge(b, c);
		tlg.addEdge(c, d);
		tlg.addEdge(d, e);

		tlg.freeze();
	}

	@Test
	public void testForwardSlice() {
		System.out.println(tlg.forwardReachability(c));
	}

	@Test
	public void testBackwardSlice() {
		System.out.println(tlg.backwardReachability(c));
	}
}
