package org.osate.ge.fx.palette;

import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/*
 * Represents a single group in the palette.
 *
 */
class PaletteGroup<G, I> extends Region {

	final VBox buttonBox = new VBox();
	final ToggleButton groupButton;

	public PaletteGroup(final PaletteModel<G, I> model, final G groupModel) {

		final ScrollPane scrollPane = new ScrollPane();
		groupButton = new ToggleButton(model.getGroupLabel(groupModel));
		groupButton.setStyle("-fx-background-color: linear-gradient(#ededed, #d9d9d9)");
		groupButton.setAlignment(Pos.BASELINE_LEFT);
		groupButton.setGraphic(new ImageView(model.getGroupIcon(groupModel)));
		groupButton.setOnAction(e -> {

			if (groupButton.isSelected() == true) {
				scrollPane.setManaged(true);
				scrollPane.setVisible(true);
				groupButton.setStyle("-fx-background-color: rgb(242,242,242)");
			} else {
				scrollPane.setVisible(false);
				scrollPane.setManaged(false);
				groupButton.setStyle("-fx-background-color: linear-gradient(#ededed, #d9d9d9)");
			}

		});

		groupButton.setOnMouseEntered(e -> {

			groupButton.setStyle("-fx-background-color: rgb(242,242,242)");

		});

		groupButton.setOnMouseExited(e -> {

			if (!groupButton.isSelected()) {
				groupButton.setStyle("-fx-background-color: linear-gradient(#ededed, #d9d9d9)");
			}

		});

		buttonBox.getChildren().add(groupButton);

		final VBox itemBox = new VBox();

		for (I itemModel : model.getItems(groupModel)) {

			PaletteItem<I> paletteItem = new PaletteItem<>(model, itemModel);
			itemBox.getChildren().add(paletteItem);

		}
		scrollPane.setContent(itemBox);
		buttonBox.getChildren().add(scrollPane);
		scrollPane.setManaged(false);
		scrollPane.setVisible(false);
		scrollPane.setFitToWidth(true);
		this.getChildren().add(buttonBox);

	}

	@Override
	public void layoutChildren() {

		final double width = this.getWidth();
		final double height = this.getHeight();

		buttonBox.resize(width, height);
		groupButton.setPrefWidth(width);
	}

}
