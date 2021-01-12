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
package org.osate.ge.gef;

import java.util.Objects;

import javafx.geometry.Point2D;
import javafx.scene.Node;

/**
 * Class for accessing the preferred position property used by {@link ContainerShape} and {@link PreferredPosition} to
 * layout children. Ultimately the container will decide how to position the node and the property may not be used
 * for all children.
 */
public class PreferredPosition {
	/**
	 * Key for the property for the preferred position of the node.
	 */
	private static final Object KEY = new Object();

	/**
	 * Returns the preferred position of a node. If one has not been set, this will return null.
	 * @param node the node for which to retrieve the preferred position
	 * @return the node's preferred position.
	 */
	public static Point2D get(final Node node) {
		return (Point2D) node.getProperties().get(KEY);
	}

	/**
	 * Sets the preferred position of a node. The preferred position is the position where the node should be placed.
	 * The layout algorithm will use it determine the actual position of the node.
	 * @param node the node for which to set the preferred position
	 * @param value the new preferred position
	 */
	public static void set(final Node node, final Point2D value) {
		final Point2D oldValue = get(node);
		if (!Objects.equals(value, oldValue)) {
			if (value == null) {
				node.getProperties().remove(KEY, value);
			} else {
				node.getProperties().put(KEY, value);
			}

			// Request that the parent reposition this child
			if (node.getParent() != null) {
				node.getParent().requestLayout();
			}
		}
	}
}
