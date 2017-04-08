package org.osate.ge.internal.graphiti.diagram;

import org.osate.ge.internal.diagram.DiagramElement;

public interface ColoringProvider {
	java.awt.Color getForegroundColor(final DiagramElement de);
}
