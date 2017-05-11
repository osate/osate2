package org.osate.ge.internal;

import org.osate.ge.internal.diagram.AgeDiagram;

public interface AgeDiagramProvider {
	/**
	 * Will not return a valid object until initialization is complete.
	 * @return
	 */
	AgeDiagram getAgeDiagram();
}
