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
class PaletteGroup extends Region {
	private BooleanProperty expanded = new SimpleBooleanProperty(false);

	public PaletteGroup(final PaletteModelController mc, final int groupIndex) {
		// TODO: Populate contents based in a manner similar to what is currently in Palette

		VBox buttonBox = new VBox();

		Button groupButton = new Button(mc.getGroupLabel(groupIndex));
		groupButton.setGraphic(new ImageView(mc.getGroupIcon(groupIndex)));

		buttonBox.getChildren().add(groupButton);

		ScrollPane scrollPane = new ScrollPane();
		for (int i = 0; i < mc.getNumberOfItems(); i++) {

			PaletteItem paletteItem = new PaletteItem(mc, i, groupIndex);
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
