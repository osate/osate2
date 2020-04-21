package org.osate.ge.fx.palette;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

class PaletteItem<I> extends Region {

	Button itemButton;

	public PaletteItem(final PaletteModel<?, I> model, I item, boolean grouped) {

		itemButton = new Button(model.getItemLabel(item));

		if (grouped) {

			itemButton.setPadding(new Insets(0, 0, 0, 20));

		}

		itemButton.setStyle("-fx-background-color: white;");
		itemButton.setOnMouseEntered(e -> {

			if (model.getActiveItem() != item) {
				itemButton.setStyle("-fx-background-color: rgba(255,165,0,0.2)");
			}

		});
		itemButton.setOnMouseExited(e -> {

			if (model.getActiveItem() != item) {
				itemButton.setStyle("-fx-background-color: white;");
			}

		});

		itemButton.setAlignment(Pos.BASELINE_LEFT);
		itemButton.setGraphic(new ImageView(model.getItemIcon(item)));
		itemButton.setOnAction(e -> {

			if (model.getActiveItem() != item) {
				model.activateItem(item);

				itemButton.setStyle("-fx-background-color: rgba(0,0,255,0.1)");
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
