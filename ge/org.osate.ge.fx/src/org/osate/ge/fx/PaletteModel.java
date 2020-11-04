package org.osate.ge.fx;

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
	 * @return an array of palette groups
	 */
	// TODO: Consider making this an immutable collection
	G[] getGroups();

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
	 * @return the items for the group or root items when group is null.
	 */
	// TODO: Consider making this an immutable collection
	I[] getItems(G group);

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
	 * If the active palette item is changed, it will be reflected by {@link activeItemProperty}.
	 * @param item is the palette item to activate.
	 */
	void activateItem(I item);

	/**
	 * Retrieves the active item.
	 * @return the active item or null if no item is active
	 */
	public default I getActiveItem() {
		return activeItemProperty().getValue();
	}

	/**
	 * Property for the active item.
	 */
	public ReadOnlyProperty<I> activeItemProperty();
}
