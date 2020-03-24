package org.osate.ge.fx.palette;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyProperty;
import javafx.scene.image.Image;

/**
 * Test view model for the {@link Palette} view. Provides a few groups and items with some of those having solid colored icons.
 *
 */
public class TestPaletteModel implements PaletteModel<TestPaletteGroup, TestPaletteItem> {
	private final ReadOnlyObjectWrapper<TestPaletteItem> activeItem = new ReadOnlyObjectWrapper<>();
	private final TestPaletteGroup[] groups;
	private final TestPaletteGroup rootGroup = new TestPaletteGroup("Root", null); // Created to simplify implementation
	private final Image[] icons = { createTestIcon(0xFFFF0000), createTestIcon(0xFF00FF00),
			createTestIcon(0xFF0000FF), };

	public TestPaletteModel() {
		groups = new TestPaletteGroup[] { new TestPaletteGroup("Group 1", icons[0]),
				new TestPaletteGroup("Group 2", null), new TestPaletteGroup("Group 3", icons[2]), };

		new TestPaletteItem(rootGroup, icons[0]);
		new TestPaletteItem(rootGroup, icons[1]);
		new TestPaletteItem(groups[0], icons[0]);
		new TestPaletteItem(groups[0], icons[0]);
		new TestPaletteItem(groups[0], icons[1]);
		new TestPaletteItem(groups[1], icons[2]);
		new TestPaletteItem(groups[1], icons[2]);
		new TestPaletteItem(groups[1], icons[1]);
		new TestPaletteItem(groups[2], icons[0]);
		new TestPaletteItem(groups[2], null);
	}

	@Override
	public TestPaletteGroup[] getGroups() {
		return groups.clone();
	}

	@Override
	public String getGroupLabel(TestPaletteGroup group) {
		return group.label;
	}

	@Override
	public Image getGroupIcon(TestPaletteGroup group) {
		return group.icon;
	}

	@Override
	public TestPaletteItem[] getItems(TestPaletteGroup group) {
		if (group == null) {
			group = rootGroup;
		}

		return group.items.toArray(new TestPaletteItem[group.items.size()]);
	}

	@Override
	public String getItemLabel(TestPaletteItem item) {
		return item.label;
	}

	@Override
	public Image getItemIcon(TestPaletteItem item) {
		return item.icon;
	}

	@Override
	public void activateItem(TestPaletteItem item) {
		activeItem.set(item);

		// Sleep for 3 seconds and then change the active item to the first palette item.
		final Thread t = new Thread(() -> {
			try {
				Thread.sleep(3000);
				Platform.runLater(() -> activeItem.set(null));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		t.start();
	}

	@Override
	public ReadOnlyProperty<TestPaletteItem> activeItemProperty() {
		return activeItem.getReadOnlyProperty();
	}

	// Creates an icon with a solid color for testing
	private Image createTestIcon(final int rgb) {
		final BufferedImage bi = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		for (int y = 0; y < bi.getHeight(); y++) {
			for (int x = 0; x < bi.getWidth(); x++) {
				bi.setRGB(x, y, rgb);
			}
		}

		final ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ImageIO.write(bi, "png", os);
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
		return new Image(new ByteArrayInputStream(os.toByteArray()));
	}
}

class TestPaletteGroup {
	final String label;
	final Image icon;
	final List<TestPaletteItem> items = new ArrayList<>();

	public TestPaletteGroup(final String label, Image icon) {
		this.label = label;
		this.icon = icon;
	}
}

class TestPaletteItem {
	final String label;
	final Image icon;

	public TestPaletteItem(TestPaletteGroup group, Image icon) {
		group.items.add(this);
		this.label = group.label + " - Item " + group.items.size();
		this.icon = icon;
	}
}
