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
package org.osate.ge.fx.palette;

import java.util.ArrayList;
import java.util.Objects;

import org.osate.ge.fx.NodeApplication;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * Generic palette component.
 *
 */
public class Palette extends Region {
	private PaletteModelController mc;

	VBox paletteVbox = new VBox();
	ArrayList<PaletteGroup> paletteList = new ArrayList<PaletteGroup>();

	public Palette(final PaletteModelController mc) {
		this.mc = Objects.requireNonNull(mc, "mc must not be null");

		// TODO: Create contents based on the model controller

		for (int i = 0; i < mc.getNumberOfGroups(); i++) {
			// TODO: Move into PaletteGroup
			// TODO: Create a palette group for each group
			// TODO: Add each palette to a list
			// TODO: Listen for change to expanded property. When it is set, adjust expanded state of other

			PaletteGroup paletteGroup = new PaletteGroup(mc, i);

			Button groupButton = new Button(mc.getGroupLabel(i));
			groupButton.setGraphic(new ImageView(mc.getGroupIcon(i)));

			/*
			 * This is the only way to add the group button to the palette group,
			 * but since palette group cannot be a parent this is impossible and causes
			 * a runtime exception.
			 */
			// paletteGroup.getChildrenUnmodifiable().add(groupButton);

			paletteList.add(paletteGroup);
			paletteVbox.getChildren().addAll(paletteList);

			ScrollPane scrollPane = new ScrollPane();

			groupButton.getChildrenUnmodifiable().add(scrollPane);

			VBox itemVbox = new VBox();
			for (int k = 0; k < mc.getNumberOfItems(); k++) {

				if (mc.getItemGroup(k) != null && mc.getItemGroup(k) == i) {

					Button itemButton = new Button(mc.getItemLabel(k));
					itemVbox.getChildren().add(itemButton);

				}

			}

		}

		for (int i = 0; i < mc.getNumberOfGroups(); i++) {

			// paletteList.get(i).getChildrenUnmodifiable().addListener();

			/*
			 *
			 * Somehow add a listener for mouse events on the group button contained
			 * within each palette group stored in the palette list.
			 *
			 * This listener should set the scroll pane of that element to be visible and managed,
			 * and should set all other scroll panes to be not visible and not managed.
			 *
			 */

		}

	}

	@Override
	public void layoutChildren() {
		// TODO: Replace with something that sizes and positions children appropriately.
		super.layoutChildren();
	}

	public static void main(final String[] args) {
		NodeApplication.run(() -> new Node[] { new Palette(new TestPaletteModelController()) });
	}

}