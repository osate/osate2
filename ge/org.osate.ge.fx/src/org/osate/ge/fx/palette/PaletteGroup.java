package org.osate.ge.fx.palette;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.Region;

/**
 * Represents a single group in the palette.
 *
 */
class PaletteGroup extends Region {
	private BooleanProperty expanded = new SimpleBooleanProperty(false);

	public PaletteGroup(final PaletteModelController mc, final int groupIndex) {
		// TODO: Populate contents based in a manner similar to what is currently in Palette

		// TODO: Update visibility of scrollpane based on state of expanded property
	}

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
