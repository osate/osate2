package org.osate.ge.internal.diagram.runtime.layout;

import java.util.Objects;

import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.internal.AgeConnection;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramModification;

/**
 * Interface for objects that are used to map from the ElkLabel to the diagram.
 * This is needed because the primary label position for connections is stored in the connection's diagram element.
 * Since the connection diagram element is mapped to the ElkEdge, a new object is needed for the mapping of the primary ElkLabel.
 * This interface allows simplifying the handling of the differences between primary and secondary connection labels.
 */
class PrimaryConnectionLabelReference implements ConnectionLabelReference {
	private DiagramElement connectionDiagramElement;

	public PrimaryConnectionLabelReference(final DiagramElement connectionDiagramElement) {
		this.connectionDiagramElement = Objects.requireNonNull(connectionDiagramElement,
				"connectionDiagramElement must not be null");

		if (!(connectionDiagramElement.getGraphic() instanceof AgeConnection)) {
			throw new RuntimeException("Diagram elmeent must be a connection");
		}
	}

	@Override
	public void setPosition(DiagramModification modification, Point position) {
		modification.setConnectionPrimaryLabelPosition(connectionDiagramElement, position);
	}

}
