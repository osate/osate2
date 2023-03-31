/**
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.gef.ui.editor;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.Categories;
import org.osate.ge.gef.palette.PaletteModel;
import org.osate.ge.gef.palette.SimplePaletteGroup;
import org.osate.ge.gef.palette.SimplePaletteItem;
import org.osate.ge.gef.ui.AgeGefUiPlugin;
import org.osate.ge.palette.PaletteCommand;
import org.osate.ge.palette.PaletteCommandProviderContext;
import org.osate.ge.palette.PaletteContributor;

import com.google.common.collect.ImmutableList;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyProperty;
import javafx.embed.swt.SWTFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

/**
 * {@link PaletteModel} implementation for {@link AgeEditor} which provides palette items and groups based on {@link PaletteContributor} instances.
 */
public class AgeEditorPaletteModel implements PaletteModel<SimplePaletteGroup, SimplePaletteItem> {
	/**
	 * Interface for providing image based on IDs specified by the {@link PaletteContributor}. This is used to avoid complicating
	 * the palette model with the details of finding and loading images.
	 */
	public static interface ImageProvider {
		/**
		 * Returns the JavafX image for the specified ID.
		 * @param id the ID as specified by the {@link PaletteContributor}
		 * @return the JavaFX image for the specified ID
		 */
		Optional<Image> getImage(String id);
	}

	private final ReadOnlyObjectWrapper<SimplePaletteItem> activeItem = new ReadOnlyObjectWrapper<>();
	private final Image selectIcon = AgeGefUiPlugin.loadBundleImage("/icons/arrow16.gif");
	private final Image marqueeIcon = AgeGefUiPlugin.loadBundleImage("/icons/marquee16.gif");
	private final WritableImage folderIcon;
	private final SimplePaletteGroup rootGroup = new SimplePaletteGroup("Root", null); // Created to simplify implementation
	private final SimplePaletteGroup miscPaletteGroup;
	private final SimplePaletteItem selectItem = new SimplePaletteItem(rootGroup, "Select", selectIcon);
	private final SimplePaletteItem marqueeItem = new SimplePaletteItem(rootGroup, "Marquee", marqueeIcon);
	private final ImmutableList<SimplePaletteGroup> groups;

	/**
	 * Creates a new instance
	 * @param paletteContributors the palette contributors used to populate the palette.
	 * @param diagramBo the business object for the diagram. Must not be null.
	 * @param imageProvider provides images referenced by the palette contributors.
	 */
	public AgeEditorPaletteModel(final Collection<PaletteContributor> paletteContributors, final Object diagramBo,
			final ImageProvider imageProvider) {
		Objects.requireNonNull(diagramBo, "DiagramBo must not be null");
		final ImageDescriptor folderIconDescriptor = PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_FOLDER);
		final org.eclipse.swt.graphics.Image folderIconImage = folderIconDescriptor.createImage();
		Objects.requireNonNull(folderIconImage, "Unable to create folder icon image");
		folderIcon = SWTFXUtils.toFXImage(folderIconImage.getImageData(), null);
		folderIconImage.dispose();

		final Map<String, SimplePaletteGroup> unsortedGroups = new HashMap<>();

		miscPaletteGroup = new SimplePaletteGroup("Miscellaneous", folderIcon);
		unsortedGroups.put(Categories.MISC, miscPaletteGroup);

		// Create groups from the categories provided by the palette contributors
		for (final PaletteContributor contributor : paletteContributors) {
			contributor.getCategories().forEachOrdered(category -> {
				final SimplePaletteGroup group = new SimplePaletteGroup(category.getLabel(), folderIcon);
				unsortedGroups.put(category.getId(), group);
			});
		}

		// Create palette items based on the commands from the palette contributors
		final PaletteCommandProviderContext ctx = new PaletteCommandProviderContext(diagramBo);
		for (final PaletteContributor contributor : paletteContributors) {
			contributor.getTargetedCommands(ctx).forEachOrdered(cmd -> {
				final SimplePaletteGroup group = Objects.requireNonNull(unsortedGroups.get(cmd.getCategoryId()),
						"unable to find group for category: " + cmd.getCategoryId());
				new SimplePaletteItem(group, cmd.getLabel(),
						cmd.getIconId().flatMap(imageProvider::getImage).orElse(null), cmd);
			});

			contributor.getCreateConnectionCommands(ctx).forEachOrdered(cmd -> {
				final SimplePaletteGroup group = Objects.requireNonNull(unsortedGroups.get(cmd.getCategoryId()),
						"unable to find group for category: " + cmd.getCategoryId());
				new SimplePaletteItem(group, cmd.getLabel(),
						cmd.getIconId().flatMap(imageProvider::getImage).orElse(null), cmd);
			});
		}

		groups = unsortedGroups.values().stream().filter(g -> !g.items.isEmpty())
				.sorted((g1, g2) -> g1.label.compareToIgnoreCase(g2.label)).collect(ImmutableList.toImmutableList());

		// Sort the items in each group
		for (SimplePaletteGroup group : groups) {
			group.items.sort((i1, i2) -> i1.label.compareToIgnoreCase(i2.label));
		}

		// Activate the Select tool by default
		activateItem(selectItem);
	}

	@Override
	public ImmutableList<SimplePaletteGroup> getGroups() {
		return groups;
	}

	@Override
	public String getGroupLabel(final SimplePaletteGroup group) {
		return group.label;
	}

	@Override
	public Image getGroupIcon(final SimplePaletteGroup group) {
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
	public String getItemLabel(final SimplePaletteItem item) {
		return item.label;
	}

	@Override
	public Image getItemIcon(final SimplePaletteItem item) {
		return item.icon;
	}

	@Override
	public void activateItem(final SimplePaletteItem item) {
		activeItem.setValue(item);
	}

	/**
	 * Returns whether the Select tool is the active tool.
	 * @return true if the Select tool is the active tool.
	 */
	public boolean isSelectToolActive() {
		return getActiveItem() == selectItem;
	}

	/**
	 * Returns whether the Marquee tool is the active tool.
	 * @return true if the Marquee tool is the active tool.
	 */
	public boolean isMarqueeToolActive() {
		return getActiveItem() == marqueeItem;
	}

	/**
	 * Returns the {@link PaletteCommand} associated with the active item.
	 * @return the palette command associated with the active item. Returns null if there is not a command associated with the active item.
	 */
	public PaletteCommand getActivePaletteCommand() {
		final SimplePaletteItem item = getActiveItem();
		return item != null && item.userData instanceof PaletteCommand ? (PaletteCommand) item.userData : null;
	}

	@Override
	public ReadOnlyProperty<SimplePaletteItem> activeItemProperty() {
		return activeItem.getReadOnlyProperty();
	}

	/**
	 * If the selected item is not the select or marquee tool, activate the select tool.
	 */
	public void deactivateNonSelectItem() {
		final SimplePaletteItem item = activeItem.getValue();
		if (item != selectItem && item != marqueeItem) {
			activeItem.setValue(selectItem);
		}
	}
}
