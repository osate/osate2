package org.osate.ge.fx.palette;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

class PaletteItem<I> extends Region {

	Button itemButton;

	public PaletteItem(final PaletteModel<?, I> model, I item) {

		itemButton = new Button(model.getItemLabel(item));
		itemButton.setGraphic(new ImageView(model.getItemIcon(item)));
		itemButton.setOnAction(e -> {

			if (model.getActiveItem() != item) {
			model.activateItem(item);
		}

		});
		this.getChildren().add(itemButton);
	}

	@Override
	public void layoutChildren() {

		final double width = this.getWidth();
		final double height = this.getHeight();

		itemButton.resize(width, height);

	}
}
