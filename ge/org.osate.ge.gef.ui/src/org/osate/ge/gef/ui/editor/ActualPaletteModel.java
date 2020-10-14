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
package org.osate.ge.gef.ui.editor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.fx.PaletteModel;
import org.osate.ge.fx.SimplePaletteGroup;
import org.osate.ge.fx.SimplePaletteItem;
import org.osate.ge.palette.PaletteCommandProviderContext;
import org.osate.ge.palette.PaletteContributor;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyProperty;
import javafx.embed.swt.SWTFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

// TODO: Rename
// TODO: Is SimplePaletteItem good? Will have other tools that don't fit in commands.. selection.
// TODO: Categories and command should be driven by extensions
// TODO; Can share some of implementation with test palette model
// TODO: Test icon on build..
public class ActualPaletteModel implements PaletteModel<SimplePaletteGroup, SimplePaletteItem> {
	private final ReadOnlyObjectWrapper<SimplePaletteItem> activeItem = new ReadOnlyObjectWrapper<>();
	private final Image selectIcon = new Image("./icons/arrow16.gif");
	private final Image marqueeIcon = new Image("./icons/marquee16.gif");
	private final WritableImage folderIcon;

	// TODO: Replace
	private final SimplePaletteGroup rootGroup = new SimplePaletteGroup("Root", null); // Created to simplify implementation
	private final SimplePaletteGroup[] groups;

	public ActualPaletteModel(final Collection<PaletteContributor> paletteContributors, final Object diagramBo,
			final ImageProvider imageProvider) {
		// Root items
		new SimplePaletteItem(rootGroup, "Select", selectIcon);
		new SimplePaletteItem(rootGroup, "Marquee", marqueeIcon);

		final ImageDescriptor folderIconDescriptor = PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_FOLDER);
		final org.eclipse.swt.graphics.Image swtImage = folderIconDescriptor.createImage();
		folderIcon = SWTFXUtils.toFXImage(swtImage.getImageData(), null);
		swtImage.dispose();

		// TODO: Check for null?

		final Map<String, SimplePaletteGroup> unsortedGroups = new HashMap<>();

		for (final PaletteContributor contributor : paletteContributors) {
			contributor.getCategories().forEachOrdered(category -> {
				final SimplePaletteGroup group = new SimplePaletteGroup(category.getLabel(), folderIcon);
				unsortedGroups.put(category.getId(), group);
			});
		}

		// TODO: Once diagram BO is available
		final PaletteCommandProviderContext ctx = new PaletteCommandProviderContext(diagramBo);
		for (final PaletteContributor contributor : paletteContributors) {
			contributor.getTargetedCommands(ctx).forEachOrdered(cmd -> {
				final SimplePaletteGroup group = unsortedGroups.get(cmd.getCategoryId());
				if (group == null) {
					// TODO
					return;
				}

				new SimplePaletteItem(group, cmd.getLabel(),
						cmd.getIconId().flatMap(imageProvider::getImage).orElse(null));
			});

			contributor.getCreateConnectionCommands(ctx).forEachOrdered(cmd -> {
				final SimplePaletteGroup group = unsortedGroups.get(cmd.getCategoryId());
				if (group == null) {
					// TODO
					return;
				}

				new SimplePaletteItem(group, cmd.getLabel(),
						cmd.getIconId().flatMap(imageProvider::getImage).orElse(null));
			});
		}

		groups = unsortedGroups.values().stream().filter(g -> !g.items.isEmpty())
				.sorted((g1, g2) -> g1.label.compareToIgnoreCase(g2.label))
				.toArray(SimplePaletteGroup[]::new);

		// Sort the items in each group
		for (SimplePaletteGroup group : groups) {
			group.items.sort((i1, i2) -> i1.label.compareToIgnoreCase(i2.label));
		}
	}

	@Override
	public SimplePaletteGroup[] getGroups() {
		return groups;
	}

	@Override
	public String getGroupLabel(final SimplePaletteGroup group) {
		return group.label;
	}

	@Override
	public Image getGroupIcon(final SimplePaletteGroup group) {
		return folderIcon;
	}

	@Override
	public SimplePaletteItem[] getItems(SimplePaletteGroup group) {
		if (group == null) {
			group = rootGroup;
		}

		return group.items.toArray(new SimplePaletteItem[group.items.size()]);
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
	public void activateItem(final SimplePaletteItem item) {
		// TODO
		// TODO: Active item property should reflect GEF state.
	}

	@Override
	public ReadOnlyProperty<SimplePaletteItem> activeItemProperty() {
		return activeItem.getReadOnlyProperty();
	}
}
