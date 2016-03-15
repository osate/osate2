package org.osate.ge.internal.layout;

import java.util.List;

public interface LayoutScorer {
	double calculateScore(final List<Shape> shapes, final List<Connection> connections, final int[] diagramSize);
}
