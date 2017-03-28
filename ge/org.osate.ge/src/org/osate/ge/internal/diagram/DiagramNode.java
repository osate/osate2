package org.osate.ge.internal.diagram;

import java.util.Collection;

public interface DiagramNode {
	/**
	 * @return an unmodifiable view to the child diagram elements.
	 */
	Collection<AgeDiagramElement> getDiagramElements();
	
	/**
	 * 
	 * @param ref
	 * @return the child diagram element which has the specified relative reference
	 */
	AgeDiagramElement getByRelativeReference(final RelativeBusinessObjectReference ref);
	DiagramNode getContainer();
}
