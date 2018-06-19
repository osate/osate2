package org.osate.ge.internal.ui.handlers;

import org.osate.ge.internal.diagram.runtime.DiagramElement;

public class RelativeDiagramElement {
	// TODO store xSum to top? would remove need for bubbling up twice
	final DiagramElement de;
	double x;

	RelativeDiagramElement(final DiagramElement de, final double relativeValue) {
		this.de = de;
		this.x = relativeValue;
		// this.x = getRelativeValue.apply(de);
	}

	void setNewX(final double x) {
		this.x = x;
	}

	void setRelative(final double newX) {
		double x = 0;
		DiagramElement de = this.de;
		while (de.getParent() instanceof DiagramElement) {
			de = (DiagramElement) de.getParent();
			x += de.getX();
		}

		this.x = newX + x;
	}
}
