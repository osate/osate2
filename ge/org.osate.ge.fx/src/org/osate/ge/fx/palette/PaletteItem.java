package org.osate.ge.fx.palette;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

class PaletteItem extends Region {

	public PaletteItem(final PaletteModelController mc, final int itemIndex, final int groupIndex) {

		if (mc.getItemGroup(itemIndex) != null && mc.getItemGroup(itemIndex) == groupIndex) {

			Button itemButton = new Button(mc.getItemLabel(itemIndex));
			itemButton.setGraphic(new ImageView(mc.getItemIcon(itemIndex)));

		}

	}
}
