package org.osate.ge.fx.palette;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

// TODO: Make this internal once org.osate.gef.ui no longer uses
public class TestPaletteGroup {
	final String label;
	final Image icon;
	final List<TestPaletteItem> items = new ArrayList<>();

	public TestPaletteGroup(final String label, Image icon) {
		this.label = label;
		this.icon = icon;
	}
}