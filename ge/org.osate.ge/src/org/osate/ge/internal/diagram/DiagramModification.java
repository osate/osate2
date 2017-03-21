package org.osate.ge.internal.diagram;

import java.awt.Dimension;
import java.awt.Point;

import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DockArea;

/**
 * Interface provided to Modifier objects to allow making changes to an AgeDiagram. 
 *
 */
public interface DiagramModification {
	void addElement(final AgeDiagramElement e);
	void removeElement(final AgeDiagramElement e);
	void updateBusinessObjectWithSameRelativeReference(final AgeDiagramElement e, final Object bo); // TODO: Refresh business object? Require relative reference to match?
	void setGraphic(final AgeDiagramElement e, final Graphic value);
	void setDockArea(final AgeDiagramElement e, final DockArea value);
	void setPosition(final AgeDiagramElement e, final Point value);
	void setSize(final AgeDiagramElement e, final Dimension value);
	void setConnectionStart(final AgeDiagramElement e, final AgeDiagramElement value);
	void setConnectionEnd(final AgeDiagramElement e, final AgeDiagramElement value);
}