package org.osate.ge.fx.palette;

import javafx.beans.property.ReadOnlyProperty;
import javafx.scene.image.Image;

/**
 * Provides palette information. The palette is composed of items which may be contained in groups.
 *
 */
public interface PaletteModelController {

	public int getNumberOfGroups();

	public String getGroupLabel(int groupIndex);

	/**
	 *
	 * @param groupIndex
	 * @return may be null
	 */
	public Image getGroupIcon(int groupIndex);

	public int getNumberOfItems();

	public String getItemLabel(int itemIndex);

	/**
	 *
	 * @param itemIndex
	 * @return may be null
	 */
	public Image getItemIcon(int itemIndex);

	/**
	 *
	 * @param itemIndex
	 * @return may be null if the item is not contained within a group
	 */
	public Integer getItemGroup(int itemIndex);

	public void activateItem(int itemIndex);

	/**
	 * Retrieves the index of the active item.
	 * @return the index of the active item or null if no item is active
	 */
	public default Integer getActiveItem() {

		return activeItemProperty().getValue();

	}

	/**
	 * Property for the index of the active item.
	 */
	public ReadOnlyProperty<Integer> activeItemProperty();

}
