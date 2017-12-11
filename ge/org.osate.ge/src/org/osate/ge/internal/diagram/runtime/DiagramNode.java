package org.osate.ge.internal.diagram.runtime;

import java.util.Collection;
import java.util.stream.Stream;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.query.Queryable;

public interface DiagramNode extends Queryable, BusinessObjectContext {
	/**
	 * @return an unmodifiable view to the child diagram elements.
	 */
	Collection<DiagramElement> getDiagramElements();

	/**
	 *
	 * @param ref
	 * @return the child diagram element which has the specified relative reference
	 */
	DiagramElement getByRelativeReference(final RelativeBusinessObjectReference ref);
	DiagramNode getContainer();

	@Override
	default DiagramNode getParent() { return getContainer(); }

	/**
	 * @return a stream containing this and all descendant nodes.
	 */
	default Stream<DiagramNode> getAllDiagramNodes() {
		return Stream.concat(Stream.of(this), getDiagramElements().stream().flatMap(DiagramNode::getAllDiagramNodes));
	}
}
