package org.osate.ge.fx.palette;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

class PaletteItem<I> extends Region {

	Button itemButton;

	public PaletteItem(final PaletteModel<?, I> model, I item) {

		itemButton = new Button(model.getItemLabel(item));

		itemButton.setStyle("-fx-background-color: white;");
		itemButton.setOnMouseEntered(e -> {

			if (model.getActiveItem() != item) {
			itemButton.setStyle("-fx-background-color: rgba(255,165,0,0.3)");
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

			itemButton.setStyle("-fx-background-color: rgba(0,100,255,0.2)");
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
