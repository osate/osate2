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
package org.osate.ge.gef.ui.diagram;

import org.eclipse.gef.fx.anchors.IAnchor;
import org.osate.ge.gef.AgeGefRuntimeException;
import org.osate.ge.gef.BaseConnectionNode;
import org.osate.ge.gef.ContainerShape;
import org.osate.ge.gef.DockSide;
import org.osate.ge.gef.DockedShape;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.DockArea;

import javafx.geometry.Point2D;
import javafx.scene.Node;

/**
 * Utility class for working with {@link GefAgeDiagram} instances
 */
public final class GefAgeDiagramUtil {
	private GefAgeDiagramUtil() {
	}

	/**
	 * Returns the anchor to use to reference the specified diagram element.
	 * @param gefDiagram is the diagram which contains the mapping between diagram elements to scene nodes
	 * @param de the element to retrieve the anchor for
	 * @param other is the element at the other end of the connection.
	 * Used for docked shapes to determine which anchor to use. If null, the interior anchor will be used.
	 * @return the anchor for the diagram element.
	 */
	public static IAnchor getAnchor(final GefAgeDiagram gefDiagram, final DiagramElement de,
			final DiagramElement other) {
		final Node sceneNode = gefDiagram.getSceneNode(de);
		if (sceneNode == null) {
			return null;
		}

		if (sceneNode instanceof ContainerShape) {
			return ((ContainerShape) sceneNode).getAnchor();
		} else if (sceneNode instanceof DockedShape) {
			final DockedShape ds = (DockedShape) sceneNode;
			return (other == null || useInteriorAnchor(de, other)) ? ds.getInteriorAnchor() : ds.getExteriorAnchor();
		} else if (sceneNode instanceof BaseConnectionNode) {
			return ((BaseConnectionNode) sceneNode).getMidpointAnchor();
		} else {
			throw new AgeGefRuntimeException(
					"Unexpected case. Attempt to get anchor for node of type : " + sceneNode.getClass().getName());
		}
	}

	/**
	 * Returns whether the connection going from e1 to e2 should use the interior anchor for e1 if it exists.
	 * @param e1
	 * @param e2
	 * @return
	 */
	private static boolean useInteriorAnchor(final DiagramElement e1, final DiagramElement e2) {
		return isInsideUndockedContainer(e2, e1);
	}

	/**
	 * Returns whether e1 is inside the first undocked container in the hierarchy of e2
	 * @param e1
	 * @param e2
	 * @return
	 */
	private static boolean isInsideUndockedContainer(final DiagramElement e1, final DiagramElement e2) {
		// Get the first diagram element in each hierarchy which doesn't have a dock area set.
		DiagramNode nd2 = e2;
		while (nd2 instanceof DiagramElement && ((DiagramElement) nd2).getDockArea() != null) {
			nd2 = nd2.getParent();
		}

		if (!(nd2 instanceof DiagramElement)) {
			return false;
		}

		// Check if e1 is inside the first undocked element in the e2 hierarchy
		for (DiagramNode t1 = e1; t1 != null; t1 = t1.getParent()) {
			if (t1 == nd2) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Converts a {@link DockArea} to an equivalent {@link DockSide}.
	 * @param value the dock area for which to return the dock side.
	 * @return the dock side. Returns null if value is null or if value is {@link DockArea#GROUP}
	 */
	public static DockSide toDockSide(final DockArea value) {
		if (value == null) {
			return null;
		}

		switch (value) {
		case LEFT:
			return DockSide.LEFT;
		case RIGHT:
			return DockSide.RIGHT;
		case TOP:
			return DockSide.TOP;
		case BOTTOM:
			return DockSide.BOTTOM;
		default:
			return null;
		}
	}

	/**
	 * Converts a {@link DockSide} to an equivalent {@link DockArea}.
	 * @param value the dock side for which to return the dock area..
	 * @return the dock area. Returns null if value is null.
	 */
	public static DockArea toDockArea(final DockSide value) {
		if (value == null) {
			return null;
		}

		switch (value) {
		case LEFT:
			return DockArea.LEFT;
		case RIGHT:
			return DockArea.RIGHT;
		case TOP:
			return DockArea.TOP;
		case BOTTOM:
			return DockArea.BOTTOM;
		default:
			throw new AgeGefRuntimeException("Unexpected value: " + value);
		}
	}

	/**
	 * Converts a {@link Point2D} to a {@link org.osate.ge.graphics.Point}.
	 * @param value the point to convert.
	 * @return the converted point. Returns null if value is null/
	 */
	public static org.osate.ge.graphics.Point toAgePoint(final Point2D value) {
		return value == null ? null : new org.osate.ge.graphics.Point(value.getX(), value.getY());
	}
}
