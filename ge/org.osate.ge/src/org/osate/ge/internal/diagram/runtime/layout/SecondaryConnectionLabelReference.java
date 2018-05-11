package org.osate.ge.internal.diagram.runtime.layout;

import java.util.Objects;

import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.internal.Label;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramModification;

public class SecondaryConnectionLabelReference implements ConnectionLabelReference {
	private DiagramElement labelDiagramElement;

	public SecondaryConnectionLabelReference(final DiagramElement labelDiagramElement) {
		this.labelDiagramElement = Objects.requireNonNull(labelDiagramElement, "labelDiagramElement must not be null");

		if (!(labelDiagramElement.getGraphic() instanceof Label)) {
			throw new RuntimeException("Diagram elmeent must be a label");
		}
	}

	@Override
	public void setPosition(DiagramModification modification, Point position) {
		modification.setPosition(labelDiagramElement, position);
	}

}
