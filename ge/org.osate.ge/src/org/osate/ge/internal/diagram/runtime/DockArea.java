/**
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.osate.ge.DockingPosition;

/**
 * Internal description of the area of the container to which the shape is docked.
 *
 */
public enum DockArea {
	/**
	 * Left Side
	 */
	LEFT("left"),
	/**
	 * Right Side
	 */
	RIGHT("right"),
	/**
	 * Top Side
	 */
	TOP("top"),
	/**
	 * Bottom Side
	 */
	BOTTOM("bottom"),
	/**
	 * Container is a group of docked shapes. String "feature_group" is for backwards compatibility purposes
	 */
	GROUP("feature_group");

	private static final Map<String, DockArea> idToDockAreaMap;
	static {
		final Map<String, DockArea> modifiableMap = new HashMap<String, DockArea>();
		for(final DockArea area : DockArea.values()) {
			modifiableMap.put(area.id, area);
		}
		idToDockAreaMap = Collections.unmodifiableMap(modifiableMap);
	}


	/**
	 * Returns the instance with the specified ID
	 * @param dockAreaId the ID
	 * @return the instance with the specified ID. Returns null if an instance with the ID does not exist.
	 * @see #id
	 */
	public static DockArea getById(final String dockAreaId) {
		return idToDockAreaMap.get(dockAreaId);
	}

	/**
	 * Unique identifier
	 */
	public final String id;

	DockArea(final String id) {
		this.id = id;
	}

	/**
	 * Returns whether this instance is {@link #LEFT} or {@link #RIGHT}
	 * @return whether this instance is {@link #LEFT} or {@link #RIGHT}
	 */
	public boolean isLeftOrRight() {
		return this == LEFT || this == RIGHT;
	}

	/**
	 * Returns the default docking area for a specified {@link DockingPosition}
	 * @param value is the docking position for which to get the default docking area.
	 * @return the default docking area.
	 */
	public static DockArea fromDockingPosition(final DockingPosition value) {
		if(value == null) {
			return null;
		}

		switch(value) {
		case ANY:
			return LEFT;
		case NOT_DOCKABLE:
			return null;
		case LEFT:
			return LEFT;
		case RIGHT:
			return RIGHT;
		case TOP:
			return TOP;
		case BOTTOM:
			return BOTTOM;
		default:
			throw new IllegalArgumentException("Unexpected value: '" + value + "'");
		}
	}
}

