package org.osate.ge.fx.palette;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/*
 * Represents a single group in the palette.
 *
 */
class PaletteGroup<G, I> extends Region {
	private BooleanProperty expanded = new SimpleBooleanProperty(false);

	final VBox buttonBox = new VBox();
	final Button groupButton;

	public PaletteGroup(final PaletteModel<G, I> model, final G groupModel) {

		groupButton = new Button(model.getGroupLabel(groupModel));
		groupButton.setGraphic(new ImageView(model.getGroupIcon(groupModel)));
		groupButton.setOnAction(e -> {

			if (getExpanded() == true) {
				setExpanded(false);
			} else {
				setExpanded(true);
			}

		});

		buttonBox.getChildren().add(groupButton);
		buttonBox.setFillWidth(true);

		final ScrollPane scrollPane = new ScrollPane();

		final VBox itemBox = new VBox();

		for (I itemModel : model.getItems(groupModel)) {

			PaletteItem<I> paletteItem = new PaletteItem<>(model, itemModel);
			itemBox.getChildren().add(paletteItem);

			}
			scrollPane.setContent(itemBox);
			buttonBox.getChildren().add(scrollPane);
			scrollPane.setManaged(false);
			scrollPane.setVisible(false);
			scrollPane.managedProperty().bind(expandedProperty());
			scrollPane.visibleProperty().bind(expandedProperty());
			scrollPane.setFitToWidth(true);
			this.getChildren().add(buttonBox);

		}

	public boolean getExpanded() {
		return expanded.get();
	}

	public void setExpanded(final boolean value) {
		expanded.set(value);
	}

	public BooleanProperty expandedProperty() {
		return expanded;
	}

	@Override
	public void layoutChildren() {

		final double width = this.getWidth();
		final double height = this.getHeight();

		buttonBox.resize(width, height);
		groupButton.setPrefWidth(width);
	}

}
