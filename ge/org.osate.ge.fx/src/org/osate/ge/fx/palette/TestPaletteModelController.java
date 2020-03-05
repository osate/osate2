package org.osate.ge.fx.palette;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;

public class TestPaletteModelController implements PaletteModelController {
	public Image[] icons = {
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
		final Alert alert = new Alert(Alert.AlertType.INFORMATION);
		final String msg = "Item with index " + itemIndex + " activated";
		alert.setHeaderText(msg);
		alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(msg)));
		alert.showAndWait();
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
