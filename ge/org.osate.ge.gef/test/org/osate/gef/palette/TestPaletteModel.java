/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.gef.palette;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import org.osate.ge.gef.palette.Palette;
import org.osate.ge.gef.palette.PaletteModel;
import org.osate.ge.gef.palette.SimplePaletteGroup;
import org.osate.ge.gef.palette.SimplePaletteItem;

import com.google.common.collect.ImmutableList;

import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyProperty;
import javafx.scene.image.Image;

/**
 * Test view model for the {@link Palette} view. Provides a few groups and items with some of those having solid colored icons.
 *
 * @noextend This class is not intended to be subclassed by clients.
 * @noreference This class is not intended to be referenced by clients.
 */
public class TestPaletteModel implements PaletteModel<SimplePaletteGroup, SimplePaletteItem> {
	private final ReadOnlyObjectWrapper<SimplePaletteItem> activeItem = new ReadOnlyObjectWrapper<>();
	private final ImmutableList<SimplePaletteGroup> groups;
	private final SimplePaletteGroup rootGroup = new SimplePaletteGroup("Root", null); // Created to simplify implementation
	private final Image[] icons = { createTestIcon(0xFFFF0000), createTestIcon(0xFF00FF00),
			createTestIcon(0xFF0000FF), };

	public TestPaletteModel() {
		groups = ImmutableList.of(new SimplePaletteGroup("Group 1", icons[0]), new SimplePaletteGroup("Group 2", null),
				new SimplePaletteGroup("Group 3", icons[2]));

		createItem(rootGroup, icons[0]);
		createItem(rootGroup, icons[1]);
		createItem(groups.get(0), null);
		createItem(groups.get(0), icons[0]);
		createItem(groups.get(0), icons[1]);
		createItem(groups.get(1), icons[2]);
		createItem(groups.get(1), icons[2]);
		createItem(groups.get(1), icons[1]);

		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);
		createItem(groups.get(1), icons[1]);

		createItem(groups.get(2), icons[0]);
	}

	private static void createItem(final SimplePaletteGroup group, final Image icon) {
		new SimplePaletteItem(group, group.label + " - Item " + group.items.size(), icon);
	}

	@Override
	public ImmutableList<SimplePaletteGroup> getGroups() {
		return groups;
	}

	@Override
	public String getGroupLabel(SimplePaletteGroup group) {
		return group.label;
	}

	@Override
	public Image getGroupIcon(SimplePaletteGroup group) {
		return group.icon;
	}

	@Override
	public List<SimplePaletteItem> getItems(SimplePaletteGroup group) {
		if (group == null) {
			group = rootGroup;
		}

		return Collections.unmodifiableList(group.items);
	}

	@Override
	public String getItemLabel(SimplePaletteItem item) {
		return item.label;
	}

	@Override
	public Image getItemIcon(SimplePaletteItem item) {
		return item.icon;
	}

	@Override
	public void activateItem(SimplePaletteItem item) {
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
	public ReadOnlyProperty<SimplePaletteItem> activeItemProperty() {
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
