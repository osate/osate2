/**
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file).
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

/**
 * Describes the side of a rectangular shape to which a {@link DockedShape} is docked.
 */
public enum DockSide {
	/**
	 * The left side of the container.
	 */
	LEFT(true, false),
	/**
	* The right side of the container
	*/
	RIGHT(true, true),
	/**
	* The top of the container
	*/
	TOP(false, false),
	/**
	* The bottom of the container
	*/
	BOTTOM(false, true);

	/**
	 * True if the side is a vertical axis. For example: the left and right sides are vertical.
	 */
	public final boolean vertical;

	/**
	 * Whether the node should aligned to the end of the orthogonal axis. For nodes on a vertical axis, this indicates the graphic should be flush
	 * with the right of the container. For nodes on a horizontal axis, this indicates the graphic should be flushed with the bottom of the container.
	 */
	final boolean alignEnd;

	DockSide(final boolean vertical, final boolean alignEnd) {
		this.vertical = vertical;
		this.alignEnd = alignEnd;
	}
}