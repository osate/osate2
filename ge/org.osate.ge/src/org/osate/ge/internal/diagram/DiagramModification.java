package org.osate.ge.internal.diagram;

import java.util.List;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DockArea;
import org.osate.ge.internal.labels.AgeLabelConfiguration;

/**
 * Interface provided to Modifier objects to allow making changes to an AgeDiagram. 
 *
 */
public interface DiagramModification {
	void addElement(final DiagramElement e);
	void removeElement(final DiagramElement e);
	
	/**
	 * Updates the business object for a diagram element. The business object must have the same relative reference as the current business object.
	 * It is intended that this method be used to update an element to reflect an updated model when refreshing the diagram.
	 * @param e
	 * @param bo
	 */
	void updateBusinessObjectWithSameRelativeReference(final DiagramElement e, final Object bo);
	
	void setGraphic(final DiagramElement e, final Graphic value);
	void setPosition(final DiagramElement e, final Point value);
	void setSize(final DiagramElement e, final Dimension value);
	void setDockArea(final DiagramElement e, final DockArea value);
	void setLabelConfiguration(final DiagramElement e, final AgeLabelConfiguration value);
	void setConnectionStart(final DiagramElement e, final DiagramElement value);
	void setConnectionEnd(final DiagramElement e, final DiagramElement value);
	void setBendpoints(final DiagramElement e, final List<Point> bendpoints);
	
	/**
	 * Undoes a previous modification. The specified modification must be the most recently performed modification.
	 * @param modification
	 */
	public void undoModification(final DiagramModification modification);
	
	/**
	 * Repeats a modification The specified modification must be the most recently performed modification.
	 * @param modification
	 */
	public void redoModification(final DiagramModification modification);
	public boolean isUndoable();
	public boolean isRedoable();
}