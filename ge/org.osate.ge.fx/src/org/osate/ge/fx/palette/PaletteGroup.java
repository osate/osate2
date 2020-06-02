package org.osate.ge.fx.palette;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/*
 * Represents a single group in the palette.
 *
 */
class PaletteGroup<G, I> extends Region {
	private static final String IDLE_GROUP_STYLE = "-fx-background-color: linear-gradient(rgb(247,247,247),rgb(200,200,200));"
			+ "-fx-border-width: 1;" + "-fx-border-color: rgba(0,0,0,.2);"
			+ "-fx-border-style: solid, hidden, solid, hidden;";
	private static final String HOVER_GROUP_STYLE = "-fx-background-color: linear-gradient(rgb(243,243,243), rgb(222,222,222));"
			+ "-fx-border-width: 1;" + "-fx-border-color: rgba(0,0,0,.2);"
			+ "-fx-border-style: solid, hidden, solid, hidden;";
	private static final String SELECTED_GROUP_STYLE = "-fx-background-color: linear-gradient(rgb(243,243,243), rgb(222,222,222));"
			+ "-fx-border-width: 1;" + "-fx-border-color: rgba(0,0,0,.2);"
			+ "-fx-border-style: solid, hidden, hidden, hidden;";
	private static final String ITEMBOX_BACKGROUND = "-fx-background-color: white;";
	private static final VBox buttonBox = new VBox();
	private final ToggleButton groupButton;
	private final ScrollPane scrollPane;
	private final VBox itemBox;

	public PaletteGroup(final PaletteModel<G, I> model, final G groupModel) {
		scrollPane = new ScrollPane();
		groupButton = new ToggleButton(model.getGroupLabel(groupModel));
		groupButton.setStyle(IDLE_GROUP_STYLE);
		groupButton.setFont(new Font(12));
		groupButton.setPadding(new Insets(2, 0, 2, 2));
		groupButton.setAlignment(Pos.BASELINE_LEFT);
		groupButton.setGraphic(new ImageView(model.getGroupIcon(groupModel)));

		groupButton.setOnAction(e -> {
			if (groupButton.isSelected() == true) {
				scrollPane.setManaged(true);
				scrollPane.setVisible(true);
				groupButton.setStyle(SELECTED_GROUP_STYLE);
			} else {
				scrollPane.setVisible(false);
				scrollPane.setManaged(false);
				groupButton.setStyle(IDLE_GROUP_STYLE);
			}
		});

		groupButton.setOnMouseEntered(e -> {
			groupButton.setStyle(HOVER_GROUP_STYLE);
		});

		groupButton.setOnMouseExited(e -> {
			if (!groupButton.isSelected()) {
				groupButton.setStyle(IDLE_GROUP_STYLE);
			}
		});

		buttonBox.getChildren().add(groupButton);

		itemBox = new VBox(6);
		itemBox.setStyle(ITEMBOX_BACKGROUND);

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
