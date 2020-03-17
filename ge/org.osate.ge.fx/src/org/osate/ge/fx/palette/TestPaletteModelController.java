package org.osate.ge.fx.palette;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyProperty;
import javafx.scene.image.Image;

public class TestPaletteModelController implements PaletteModelController {
	private final ReadOnlyObjectWrapper<Integer> activeItem = new ReadOnlyObjectWrapper<>();

	private final Image[] icons = {
			createTestIcon(0xFFFF0000), createTestIcon(0xFF00FF00), createTestIcon(0xFF0000FF),
	};

	@Override
	public int getNumberOfGroups() {
		return 3;
	}

	@Override
	public String getGroupLabel(int groupIndex) {
		return "Group " + groupIndex;
	}

	@Override
	public Image getGroupIcon(int groupIndex) {
		final int iconIndex = groupIndex % (icons.length + 1);
		return iconIndex == icons.length ? null : icons[iconIndex];
	}

	@Override
	public int getNumberOfItems() {
		return (getNumberOfGroups() + 1) * 3;
	}

	@Override
	public String getItemLabel(int itemIndex) {
		final Integer group = getItemGroup(itemIndex);
		return "Item " + (4 - itemIndex % 3) + (group == null ? "" : " of group " + group);
	}

	@Override
	public Image getItemIcon(int itemIndex) {
		final int iconIndex = itemIndex % (icons.length + 1);
		return iconIndex == icons.length ? null : icons[iconIndex];
	}

	@Override
	public Integer getItemGroup(int itemIndex) {
		return itemIndex >= (getNumberOfGroups() * 3) ? null : (itemIndex / 3);
	}

	@Override
	public void activateItem(int itemIndex) {
		if (itemIndex < 0 || itemIndex >= getNumberOfItems()) {
			throw new RuntimeException("Invalid index " + itemIndex);
		}

		activeItem.set(itemIndex);

		// Sleep for 3 seconds and then change the active item to the first palette item.
		final Thread t = new Thread(() -> {
			try {
				Thread.sleep(3000);
				Platform.runLater(() -> activeItem.set(0));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		t.start();
	}

	@Override
	public ReadOnlyProperty<Integer> activeItemProperty() {
		return activeItem.getReadOnlyProperty();
	}

	// Creates an icon with a solid color for testing
	private Image createTestIcon(final int rgb) {
		final BufferedImage bi = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
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
