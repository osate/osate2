/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.diagram.runtime;

import java.util.List;

import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.Style;
import org.osate.ge.internal.diagram.runtime.updating.Completeness;

/**
 * Interface provided to Modifier objects to allow making changes to an AgeDiagram. Implementations of this interface are used to
 * modify diagram elements instead of modifying them directly so that changes can be tracked for undo, redo, and dirty flag calculation purposes.
 *
 */
public interface DiagramModification {
	/**
	 * Returns the diagram being modified
	 * @return the diagram being modified. Must not be null.
	 */
	AgeDiagram getDiagram();

	/**
	 * Sets the diagram configuration
	 * @param config the new diagram configuration
	 */
	void setDiagramConfiguration(final DiagramConfiguration config);

	/**
	 * Adds an element to the diagram. The element will be added as a child of the container referenced by the diagram element.
	 * @param e the diagram element to add
	 * @see DiagramElement#getParent()
	 */
	void addElement(final DiagramElement e);

	/**
	 * Removes an element from the diagram.
	 * @param e the diagram element to remove
	 */
	void removeElement(final DiagramElement e);

	/**
	 * Updates a diagram element's business object and the corresponding reference.
	 * @param e the diagram element to modify
	 * @param bo the new business object
	 * @param relativeReference the relative reference to the business object
	 */
	void updateBusinessObject(final DiagramElement e, final Object bo, final RelativeBusinessObjectReference relativeReference);

	/**
	 * Updates the business object for a diagram element. The business object must have the same relative reference as the current business object.
	 * It is intended that this method be used to update an element to reflect an updated model when refreshing the diagram.
	 * Notifications are not sent when this method is called. For updating the business object and the relative reference, see {@link #updateBusinessObject(DiagramElement, Object, RelativeBusinessObjectReference)}
	 * @param e the diagram element to modify
	 * @param bo the new business object
	 */
	void updateBusinessObjectWithSameRelativeReference(final DiagramElement e, final Object bo);

	/**
	 * Sets the diagram element's business object handler. Changes to this value are not tracked and notifications are not sent when this method is called
	 * @param e the diagram element to modify
	 * @param boh is the business object handler
	 */
	void setBusinessObjectHandler(final DiagramElement e, final BusinessObjectHandler boh);

	/**
	 * Sets the diagram element's completeness
	 * @param e the diagram element to modify
	 * @param value the new value
	 * @see DiagramElement#getCompleteness()
	 */
	void setCompleteness(final DiagramElement e, final Completeness value);

	/**
	 * Sets the name used by the diagram element's label
	 * @param e the diagram element to modify
	 * @param value the new value
	 * @see DiagramElement#getLabelName()
	 */
	void setLabelName(final DiagramElement e, final String value);

	/**
	 * Sets the name used for the diagram element in the user interface
	 * @param e the diagram element to modify
	 * @param value the new value
	 * @see DiagramElement#getUserInterfaceName()
	 */
	void setUserInterfaceName(final DiagramElement e, final String value);

	/**
	 * Sets the diagram element's graphical configuration
	 * @param e the diagram element to modify
	 * @param value the new value
	 * @see DiagramElement#getGraphicalConfiguration()
	 */
	void setGraphicalConfiguration(final DiagramElement e, final GraphicalConfiguration value);

	/**
	 * Sets the position. This method does not update contained connection bendpoints, dock areas, or flow indicator positions. It is usually recommended
	 * to use a higher level function.
	 * @param e the diagram element to modify
	 * @param value the new position
	 * @see DiagramElement#getPosition()
	 * @see org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil#moveElement(DiagramModification, DiagramElement, Point)
	 */
	void setPosition(final DiagramElement e, final Point value);

	/**
	 * Sets the diagram element's size
	 * @param e the diagram element to modify
	 * @param value the new size
	 * @see DiagramElement#getSize()
	 */
	void setSize(final DiagramElement e, final Dimension value);

	/**
	 * Sets the diagram element's dock area
	 * @param e the diagram element to modify
	 * @param value the new dock area
	 * @see DiagramElement#getDockArea
	 */
	void setDockArea(final DiagramElement e, final DockArea value);

	/**
	 * Sets the diagram element's bendpoints. Only appropriate for connections and flow indicators.
	 * @param e the diagram element to modify
	 * @param bendpoints the new size
	 * @see DiagramElement#getBendpoints()
	 */
	void setBendpoints(final DiagramElement e, final List<Point> bendpoints);

	/**
	 * Sets position of the diagram element's primary label. Only appropriate for connections and flow indicators.
	 * @param e the diagram element to modify
	 * @param value the new position
	 * @see DiagramElement#getConnectionPrimaryLabelPosition()
	 */
	void setConnectionPrimaryLabelPosition(final DiagramElement e, final Point value);

	/**
	 * Sets the diagram element's style
	 * @param e the diagram element to modify
	 * @param value the new style
	 * @see DiagramElement#getStyle()
	 */
	void setStyle(final DiagramElement e, final Style value);

	/**
	 * Undoes a previous modification. The specified modification must be the most recently performed modification.
	 * @param modification the modification to reverse
	 */
	public void undoModification(final DiagramModification modification);

	/**
	 * Repeats a modification The specified modification must be the most recently performed modification.
	 * @param modification the modification to repeat
	 */
	public void redoModification(final DiagramModification modification);
}