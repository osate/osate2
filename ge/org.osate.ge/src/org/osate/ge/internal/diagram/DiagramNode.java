package org.osate.ge.internal.diagram;

import java.util.Collection;

public interface DiagramNode {
	// TODO: Document. Unmodifiable.
	Collection<AgeDiagramElement> getDiagramElements();
	AgeDiagramElement getByRelativeReference(final RelativeBusinessObjectReference ref);
	DiagramNode getContainer();
}
