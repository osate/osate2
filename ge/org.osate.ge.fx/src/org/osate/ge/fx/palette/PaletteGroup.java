package org.osate.ge.fx.palette;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * Represents a single group in the palette.
 *
 */
class PaletteGroup<G, I> extends Region {
	private BooleanProperty expanded = new SimpleBooleanProperty(false);

	public PaletteGroup(final PaletteModel<G, I> model, final G groupModel) {
		// TODO: Populate contents based in a manner similar to what is currently in Palette

		VBox buttonBox = new VBox();

		Button groupButton = new Button(model.getGroupLabel(groupModel));
		groupButton.setGraphic(new ImageView(model.getGroupIcon(groupModel)));

		buttonBox.getChildren().add(groupButton);

		ScrollPane scrollPane = new ScrollPane();

		for (I itemModel : model.getItems(groupModel)) {

			PaletteItem<I> paletteItem = new PaletteItem<>(model, itemModel);
			scrollPane.setContent(paletteItem);

			}
			buttonBox.getChildren().add(scrollPane);
			scrollPane.setManaged(false);
			scrollPane.setVisible(false);
			scrollPane.managedProperty().bind(expandedProperty());

		}

		// TODO: Update visibility of scrollpane based on state of expanded property

	// The palette group has a property which indicates whether it is be expanded.
	public boolean getExpanded() {
		return expanded.get();
	}

	public void setExpanded(final boolean value) {
		expanded.set(value);
	}

	public BooleanProperty expandedProperty() {
		return expanded;
	}
}
