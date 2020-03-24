package org.osate.ge.fx.palette;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

class PaletteItem<I> extends Region {

	public PaletteItem(final PaletteModel<?, I> model, I item) {

		// TODO; Shouldn't be needed. We don't want to create empty items.
		// if (mc.getItemGroup(itemIndex) != null && mc.getItemGroup(itemIndex) == groupIndex) {

		Button itemButton = new Button(model.getItemLabel(item));
		itemButton.setGraphic(new ImageView(model.getItemIcon(item)));

		// }

	}
}
