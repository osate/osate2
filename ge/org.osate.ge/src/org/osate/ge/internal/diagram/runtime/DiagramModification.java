package org.osate.ge.internal.diagram.runtime;

import java.util.List;

import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.internal.AgeGraphicalConfiguration;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;

/**
 * Interface provided to Modifier objects to allow making changes to an AgeDiagram.
 *
 */
public interface DiagramModification {
	void setDiagramConfiguration(final DiagramConfiguration config);

	void addElement(final DiagramElement e);
	void removeElement(final DiagramElement e);

	void updateBusinessObject(final DiagramElement e, final Object bo, final RelativeBusinessObjectReference relativeReference);

	/**
	 * Updates the business object for a diagram element. The business object must have the same relative reference as the current business object.
	 * It is intended that this method be used to update an element to reflect an updated model when refreshing the diagram.
	 * Notifications are not sent when this method is called.
	 * @param e
	 * @param bo
	 */
	void updateBusinessObjectWithSameRelativeReference(final DiagramElement e, final Object bo);

	/**
	 * Notifications are not sent when this method is called
	 * @param e
	 * @param boh is the business object handler
	 */
	void setBusinessObjectHandler(final DiagramElement e, final Object boh);

	void setCompleteness(final DiagramElement e, final Completeness value);
	void setLabelName(final DiagramElement e, final String value);

	void setUserInterfaceName(final DiagramElement e, final String value);
	void setGraphicalConfiguration(final DiagramElement e, final AgeGraphicalConfiguration value);

	default void setPosition(final DiagramElement e, final Point value) {
		setPosition(e, value, true, true);
	}

	/**
	 * Sets the position of a diagram element
	 * @param e the element to set position
	 * @param value the new position of the element
	 * @param updateDockArea whether the dock area should be updated based on the set position.
	 * @param updateBendpoints whether to update contained bendpoints
	 */
	void setPosition(final DiagramElement e, final Point value, final boolean updateDockArea,
			final boolean updateBendpoints);

	void setSize(final DiagramElement e, final Dimension value);
	void setDockArea(final DiagramElement e, final DockArea value);
	void setBendpoints(final DiagramElement e, final List<Point> bendpoints);
	void setConnectionPrimaryLabelPosition(final DiagramElement e, final Point value);
	void setStyle(final DiagramElement e, final Style value);


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
}