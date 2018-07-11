package org.osate.ge.internal.ui.handlers;

import org.osate.ge.internal.diagram.runtime.DiagramElement;

public class RelativeDiagramElement {
	// TODO store xSum to top? would remove need for bubbling up twice
	private final DiagramElement de;
	private double relativeCoordinate;

	RelativeDiagramElement(final DiagramElement de, final double relativeValue) {
		this.de = de;
		this.relativeCoordinate = relativeValue;
	}

	void setNewX(final double x) {
		this.relativeCoordinate = x;
	}

	void setRelative(final double newX) {
		double x = 0;
		DiagramElement de = this.de;
		while (de.getParent() instanceof DiagramElement) {
			de = (DiagramElement) de.getParent();
			x += de.getX();
		}

		this.relativeCoordinate = newX + x;
	}

	double getRelativeCoordinate() {
		return relativeCoordinate;
	}

	DiagramElement getDiagramElement() {
		return de;
	}
}
