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
package org.osate.ge.gef.palette;

import java.util.Objects;

import javafx.scene.image.Image;

/**
 * A basic class suitable for use as palette item type when implementing {@link PaletteModel}
 */
public class SimplePaletteItem {
	public final String label;
	public final Image icon;

	/**
	 * Creates a new instance
	 * @param group the group to which to add the palette item. Must not be null.
	 * @param label the label for the item. Must not be null.
	 * @param icon the icon for item. May be null.
	 */
	public SimplePaletteItem(final SimplePaletteGroup group, final String label, final Image icon) {
		Objects.requireNonNull(group, "group must not be null");
		group.items.add(this);
		this.label = Objects.requireNonNull(label, "label must not be null");
		this.icon = icon;
	}

	/**
	 * Returns the label for the palette item
	 * @return the item's label. Will not return null.
	 */
	public String getLabel() {
		return label;
	}
}