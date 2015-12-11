package org.osate.ge.layout;

import java.util.List;

public interface LayoutScorer {
	double calculateScore(final List<Shape> shapes, final List<Connection> connections, final int[] diagramSize);
}
