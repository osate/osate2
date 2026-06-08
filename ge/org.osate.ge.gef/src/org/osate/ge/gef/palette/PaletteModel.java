/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.List;

import javafx.beans.property.ReadOnlyProperty;
import javafx.scene.image.Image;

/**
 * View model for the {@link Palette} view. Provides palette information.
 * The palette is composed of items which may be contained in groups.
 *
 * @param <G> the type of the group returned by this model.
 * @param <I> the type of the palette items returned by this model.
 */
public interface PaletteModel<G, I> {
	/**
	 * Provides the groups for the palette.
	 * @return an unmodifiable list of palette groups
	 */
	List<G> getGroups();

	/**
	 * Gets the label for a specified group.
	 * @param group is the label for the group. Must not be null.
	 * @return the group's label.
	 */
	String getGroupLabel(G group);

	/**
	 * Returns the icon for the specified group.
	 * @param group is the group for which to return the icon.
	 * @return icon for the group. Returns null if the group does not have an icon.
	 */
	Image getGroupIcon(G group);

	/**
	 * Returns the item in a specified group.
	 * @param group is the group for which to return items. A value of null indicates that root items should be returned.
	 * @return an unmodifiable list containing the items for the group or root items when group is null.
	 */
	List<I> getItems(G group);

	/**
	 * Gets the label for a specified item.
	 * @param item is the label for the item. Must not be null.
	 * @return the item's label.
	 */
	String getItemLabel(I item);

	/**
	 * Returns the icon for the specified item.
	 * @param item is the item for which to return the icon.
	 * @return icon for the item. Returns null if the item does not have an icon.
	 */
	Image getItemIcon(I item);

	/**
	 * Requests the activation of a palette item.
	 * If the active palette item is changed, it will be reflected by {@link #activeItemProperty}.
	 * @param item is the palette item to activate.
	 */
	void activateItem(I item);

	/**
	 * Gets the value of {@link #activeItemProperty()}
	 * @return the active palette item or null if no item is active
	 */
	public default I getActiveItem() {
		return activeItemProperty().getValue();
	}

	/**
	 * The active palette item. The value of the property will be null if no item is active
	 * @return the active palette item. The value of the property will be null if no item is active
	 */
	public ReadOnlyProperty<I> activeItemProperty();
}
