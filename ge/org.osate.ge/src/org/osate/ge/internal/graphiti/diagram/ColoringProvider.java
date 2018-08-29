package org.osate.ge.internal.graphiti.diagram;

import java.util.Map;

import org.osate.ge.graphics.Color;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

public interface ColoringProvider {
	/**
	 * Returns a map of override foreground colors for elements.
	 */
	Map<DiagramElement, Color> buildForegroundColorMap();
}
