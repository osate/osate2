package org.osate.ge.internal.graphiti.diagram;

import org.osate.ge.graphics.Color;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

public interface ColoringProvider {
	Color getForegroundColor(final DiagramElement de);
}
