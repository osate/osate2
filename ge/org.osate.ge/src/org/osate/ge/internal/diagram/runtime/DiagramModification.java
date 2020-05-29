/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
	/**
	 * Returns the diagram being modified
	 * @return the diagram being modified. Must not be null.
	 */
	AgeDiagram getDiagram();

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

	/**
	 * Sets the position. This method does not update connection bendpoints, dock areas, or flow indicators. It is usually recommended
	 * to use a higher level function.
	 */
	void setPosition(final DiagramElement e, final Point value);

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