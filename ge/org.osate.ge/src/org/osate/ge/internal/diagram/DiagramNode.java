package org.osate.ge.internal.diagram;

import java.util.Collection;

import org.osate.ge.internal.BusinessObjectContext;
import org.osate.ge.internal.query.Queryable;

public interface DiagramNode extends Queryable, BusinessObjectContext {
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
	
	default DiagramNode getParent() { return getContainer(); }
}
