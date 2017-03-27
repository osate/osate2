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
	void addElement(final AgeDiagramElement e);
	void removeElement(final AgeDiagramElement e);
	void updateBusinessObjectWithSameRelativeReference(final AgeDiagramElement e, final Object bo); // TODO: Refresh business object? Require relative reference to match?
	void setGraphic(final AgeDiagramElement e, final Graphic value);
	void setPosition(final AgeDiagramElement e, final Point value);
	void setSize(final AgeDiagramElement e, final Dimension value);
	void setDockArea(final AgeDiagramElement e, final DockArea value);
	void setLabelConfiguration(final AgeDiagramElement e, final AgeLabelConfiguration value);
	void setConnectionStart(final AgeDiagramElement e, final AgeDiagramElement value);
	void setConnectionEnd(final AgeDiagramElement e, final AgeDiagramElement value);
	void setBendpoints(final AgeDiagramElement e, final List<Point> bendpoints);
	
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