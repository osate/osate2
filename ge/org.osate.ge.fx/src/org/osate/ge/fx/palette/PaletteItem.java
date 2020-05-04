package org.osate.ge.fx.palette;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;

class PaletteItem<I> extends Region {

	ToggleButton itemButton;
	ToggleGroup itemGroup = new ToggleGroup();
	final String HOVER_ITEM_STYLE = "-fx-background-color: rgba(252,228,179,1.0);";
	final String SELECTED_ITEM_STYLE = "-fx-background-color: rgba(207,227,250,1.0);";
	final String IDLE_ITEM_STYLE = "-fx-background-color: white;";

	public PaletteItem(final PaletteModel<?, I> model, I item) {
		itemButton = new ToggleButton(model.getItemLabel(item));
		itemButton.setPadding(new Insets(0, 0, 0, 20));
		itemButton.setFont(new Font(14));
		itemButton.setToggleGroup(itemGroup);

		itemButton.setStyle(IDLE_ITEM_STYLE);

		// TODO: Find a way to listen to the activeItemProperty and change the style based on that.
		model.activeItemProperty().addListener((ChangeListener<I>) (o, oldValue, newValue) -> {
			for (Toggle t : itemGroup.getToggles()) {
				if (t.isSelected()) {
					itemButton.setStyle(SELECTED_ITEM_STYLE);
				} else {
					itemButton.setStyle(IDLE_ITEM_STYLE);
				}
			}
		});
		itemButton.setOnMouseEntered(e -> {

			if (model.getActiveItem() != item) {
				itemButton.setStyle(HOVER_ITEM_STYLE);
			}

		});
		itemButton.setOnMouseExited(e -> {
			if (model.getActiveItem() != item) {
				itemButton.setStyle(IDLE_ITEM_STYLE);
			}

		});

		itemButton.setAlignment(Pos.BASELINE_LEFT);
		itemButton.setGraphic(new ImageView(model.getItemIcon(item)));
		itemButton.setOnAction(e -> {

			if (model.getActiveItem() != item) {
				model.activateItem(item);

				itemButton.setStyle(SELECTED_ITEM_STYLE);
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
