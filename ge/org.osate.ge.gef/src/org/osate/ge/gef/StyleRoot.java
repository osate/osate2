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

import javafx.scene.Node;

/**
 * Class for accessing the style root property. The property is used to mark an element as a style root.
 * A style root is a node which may have have a separate style from its parent. Styles are applied from the style root
 * and descendants until another style root is reached. The style root flag should be set by the creators of the
 * nodes as needed.
 */
public class StyleRoot {
	/**
	 * Key for whether a node is a style root.
	 */
	private static final Object KEY = new Object();

	/**
	 * Returns whether a node is a style root.
	 * @param node the node for which to check if it is a style root.
	 * @return whether the node is a style root.
	 */
	public static boolean get(final Node node) {
		return (Boolean) node.getProperties().getOrDefault(KEY, Boolean.FALSE);
	}

	/**
	 * Sets whether the node is a style root.
	 * @param node the node for which to set whether it is a style root
	 * @param value is whether the node is a style root
	 */
	public static void set(final Node node, final boolean value) {
		final boolean oldValue = get(node);
		if (!Objects.equals(value, oldValue)) {
			node.getProperties().put(KEY, value);
		}
	}
}
