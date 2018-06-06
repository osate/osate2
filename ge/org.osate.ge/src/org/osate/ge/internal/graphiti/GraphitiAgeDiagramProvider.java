package org.osate.ge.internal.graphiti;

import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;

public interface GraphitiAgeDiagramProvider {
	/**
	 * Will not return a valid object until initialization is complete.
	 * @return
	 */
	GraphitiAgeDiagram getGraphitiAgeDiagram();
}
