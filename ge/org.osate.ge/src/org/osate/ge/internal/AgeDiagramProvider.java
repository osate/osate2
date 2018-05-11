package org.osate.ge.internal;

import org.osate.ge.internal.diagram.runtime.AgeDiagram;

public interface AgeDiagramProvider {
	/**
	 * Will not return a valid object until initialization is complete.
	 * @return
	 */
	AgeDiagram getAgeDiagram();
}
