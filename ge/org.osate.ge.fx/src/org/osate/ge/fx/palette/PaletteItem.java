package org.osate.ge.fx.palette;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;

class PaletteItem<I> extends Region {

	private final Button itemButton;
	private boolean itemHovered = false;
	private static final String HOVER_ITEM_STYLE = "-fx-background-color: rgba(252,228,179,1.0);";
	private static final String SLECTED_ITEM_STYLE = "-fx-background-color: rgba(207,227,250,1.0);";
	private static final String IDLE_ITEM_STYLE = "-fx-background-color: white;";

	public PaletteItem(final PaletteModel<?, I> model, I item) {
		itemButton = new Button(model.getItemLabel(item));
		itemButton.setPadding(new Insets(0, 0, 0, 20));
		itemButton.setFont(new Font(14));

		itemButton.setStyle(IDLE_ITEM_STYLE);

		itemButton.setOnMouseEntered(e -> {
			itemHovered = true;
			updateStyle();
		});
		itemButton.setOnMouseExited(e -> {
			itemHovered = false;
			updateStyle();
		});

		itemButton.setAlignment(Pos.BASELINE_LEFT);
		itemButton.setGraphic(new ImageView(model.getItemIcon(item)));
		itemButton.setOnAction(e -> {

			model.activateItem(item);
			updateStyle();

		});
		this.getChildren().add(itemButton);
	}

	public void updateStyle() {

		if (itemHovered && model.getActiveItem() != item) {
			itemButton.setStyle(HOVER_ITEM_STYLE);
		}

		for (G group : model.getGroups()) {
			for (PaletteItem I : model.getItems(G)) {
				if (model.getActiveItem() == item) {
					itemButton.setStyle(SELECTED_ITEM_STYLE);
				}
			}
		}

	}

	@Override
	public void layoutChildren() {
		final double width = this.getWidth();
		final double height = this.getHeight();

		itemButton.resize(width, height);
	}
}
