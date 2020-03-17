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

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

/**
 * Generic palette component.
 *
 */
public class Palette extends Region {
	private PaletteModelController mc;



	ArrayList<TreeItem> ItemArray = new ArrayList<TreeItem>();

	TreeView<String> treeView;
	Group TreeGroup = new Group();

	public Palette(final PaletteModelController mc) {
		this.mc = Objects.requireNonNull(mc, "mc must not be null");

		// TODO: Create contents based on the model controller

		TreeItem<String> root;
		root = new TreeItem<>();
		root.setExpanded(true);

		for (int i = 0; i < mc.getNumberOfGroups(); i++) {

			TreeItem<String> GroupName = makeBranch(mc.getGroupLabel(i), root, i);

			for (int j = 0; j < mc.getNumberOfItems(); j++) {

				if (mc.getItemGroup(j) != null && mc.getItemGroup(j) == i) {

					makeBranch(mc.getItemLabel(j), GroupName, j);

				}
			}
		}

		treeView = new TreeView<>(root);
		treeView.setShowRoot(false);

		treeView.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> handle(newValue, oldValue));

		this.getChildren().add(treeView);
		this.getStylesheets().add(getClass().getResource("Palette.css").toExternalForm());

	}

	@Override
	public void layoutChildren() {
		// TODO: Replace with something that sizes and positions children appropriately.
		super.layoutChildren();
	}

	public static void main(final String[] args) {
		NodeApplication.run(() -> new Node[] { new Palette(new TestPaletteModelController()) });
	}

	public TreeItem<String> makeBranch(String title, TreeItem<String> parent, int iconIndex) {

		TreeItem<String> item;

		if (parent.getValue() == "root") {

			item = new TreeItem<String>(title, new ImageView(mc.getGroupIcon(iconIndex)));
			System.out.println(mc.getGroupIcon(iconIndex));
			item.setExpanded(false);
			parent.getChildren().add(item);

		} else {

			item = new TreeItem<String>(title, new ImageView(mc.getItemIcon(iconIndex)));
			System.out.println(mc.getItemIcon(iconIndex));
			item.setExpanded(false);
			parent.getChildren().add(item);
			ItemArray.add(item);

		}


		return item;
	}

	private void handle(TreeItem<String> newValue, TreeItem<String> oldValue) {

		if (newValue.isLeaf()) {

			// This is what causes latency because of the line Thread.sleep(3000)
			mc.activateItem(ItemArray.indexOf(newValue));
			System.out.println(ItemArray.indexOf(newValue));

		}

		if (!newValue.isLeaf()) {

			if (!newValue.isExpanded()) {
				newValue.setExpanded(true);
			}

			if (oldValue != null && oldValue.isExpanded()) {
				oldValue.setExpanded(false);
			}


		}
	}
}

