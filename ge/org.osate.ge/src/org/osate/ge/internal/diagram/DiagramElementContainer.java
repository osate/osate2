package org.osate.ge.internal.diagram;

import java.util.Collection;

public interface DiagramElementContainer {
	// TODO: Document. Unmodifiable.
	Collection<AgeDiagramElement> getDiagramElements();
	AgeDiagramElement getByRelativeReference(final RelativeBusinessObjectReference ref);
}
