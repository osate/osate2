package org.osate.ge.layout;

import java.util.List;

public interface LayoutAlgorithm {
	void layout(final List<Shape> shapes, final List<Connection> connections);
}
