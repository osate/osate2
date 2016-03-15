package org.osate.ge.internal.layout;

import java.util.List;

public interface LayoutAlgorithm {
	void layout(final List<Shape> shapes, final List<Connection> connections);
}
