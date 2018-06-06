package org.osate.ge.internal.diagram.runtime.layout;

import org.osate.ge.internal.diagram.runtime.DiagramModification;

/**
 * Interface for objects that are used to map from the ElkLabel to the diagram.
 * This is needed because the primary label position for connections is stored in the connection's diagram element.
 * Since the connection diagram element is mapped to the ElkEdge, a new object is needed for the mapping of the primary ElkLabel.
 * This interface allows simplifying the handling of the differences between primary and secondary connection labels.
 */
interface ConnectionLabelReference {
	/**
	 *
	 * @param modification
	 * @param position is the label position. The position should be relative to the connection's midpoint.
	 */
	void setPosition(DiagramModification modification, org.osate.ge.graphics.Point position);
}
