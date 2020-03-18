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

import java.util.Objects;

import org.osate.ge.fx.NodeApplication;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;

/**
 * Generic palette component.
 *
 */
public class Palette extends Region {
	private PaletteModelController mc;

	public Palette(final PaletteModelController mc) {
		this.mc = Objects.requireNonNull(mc, "mc must not be null");

		// TODO: Create contents based on the model controller

		ScrollPane scrollPane = new ScrollPane();

		Group itemButtonGroup = new Group();

		for (int i = 0; i < mc.getNumberOfGroups(); i++) {

			Button groupButton = new Button(mc.getGroupLabel(i));

			for (int j = 0; j < mc.getNumberOfItems(); j++) {

				if (mc.getItemGroup(j) != null && mc.getItemGroup(j) == i) {

					Button itemButton = new Button(mc.getItemLabel(j));
					itemButtonGroup.getChildren().add(itemButton);

				}
			}
			scrollPane.setContent(itemButtonGroup);
			/*
			 * I am still working on how to position each individual Item that should be within the ScollPane.
			 * I am also still trying to figure out how to best create each scrollPane in a way that can be indexed later since they
			 * cannot be given different names while in the for loop.
			 * Buttons may not be the best way to represent the items within the scollpanes, but for now they will work as a stand
			 * in until I discover a new way of doing things.
			 */
		}

		this.getChildren().add(scrollPane);

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