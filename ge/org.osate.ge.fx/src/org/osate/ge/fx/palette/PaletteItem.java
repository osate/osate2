package org.osate.ge.fx.palette;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;

class PaletteItem<I> extends Region {

	final ToggleButton itemButton;
	boolean itemHovered[] = { false };
	final String HOVER_ITEM_STYLE = "-fx-background-color: rgba(252,228,179,1.0);";
	final String SELECTED_ITEM_STYLE = "-fx-background-color: rgba(207,227,250,1.0);";
	final String IDLE_ITEM_STYLE = "-fx-background-color: white;";

	public PaletteItem(final PaletteModel<?, I> model, I item) {
		itemButton = new ToggleButton(model.getItemLabel(item));
		itemButton.setPadding(new Insets(0, 0, 0, 20));
		itemButton.setFont(new Font(14));

		itemButton.setStyle(IDLE_ITEM_STYLE);

		itemButton.setOnMouseEntered(e -> {
			itemHovered[0] = true;
			updateStyle(itemHovered[0], model, item);
		});
		itemButton.setOnMouseExited(e -> {
			itemHovered[0] = false;
			updateStyle(itemHovered[0], model, item);
		});

		itemButton.setAlignment(Pos.BASELINE_LEFT);
		itemButton.setGraphic(new ImageView(model.getItemIcon(item)));
		itemButton.setOnAction(e -> {

			if (model.getActiveItem() != item) {
				model.activateItem(item);

				updateStyle(itemHovered[0], model, item);
			}

		});
		this.getChildren().add(itemButton);
	}

	public void updateStyle(boolean itemHovered, PaletteModel<?, I> model, I item) {

		if (itemHovered && model.getActiveItem() != item) {
			itemButton.setStyle(HOVER_ITEM_STYLE);
		} else if (model.getActiveItem() == item) {
			itemButton.setStyle(SELECTED_ITEM_STYLE);
		}
	}

	@Override
	public void layoutChildren() {
		final double width = this.getWidth();
		final double height = this.getHeight();

		itemButton.resize(width, height);
	}
}
