package org.osate.ge.fx.palette;

import javafx.scene.image.Image;

// TODO: Make this internal once org.osate.gef.ui no longer uses
public class TestPaletteItem {
	final String label;
	final Image icon;

	public TestPaletteItem(TestPaletteGroup group, Image icon) {
		group.items.add(this);
		this.label = group.label + " - Item " + group.items.size();
		this.icon = icon;
	}
}