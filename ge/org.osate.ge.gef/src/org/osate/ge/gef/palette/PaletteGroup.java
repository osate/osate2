/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.gef.palette;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Represents a single group in the palette.
 *
 */
class PaletteGroup<G, I> extends VBox {
	private static final String SHARED_STYLE = "-fx-border-width: 1 0 0 0;" + "-fx-border-color: rgba(0,0,0,.2);"
			+ "-fx-border-style: solid, hidden, hidden, hidden;";
	private static final String IDLE_GROUP_STYLE = SHARED_STYLE
			+ "-fx-background-color: linear-gradient(rgb(247,247,247),rgb(200,200,200));";
	private static final String HOVER_GROUP_STYLE = SHARED_STYLE
			+ "-fx-background-color: #f2f2f2;";
	private static final String EXPANDED_STYLE = SHARED_STYLE
			+ "-fx-background-color: #f2f2f2;";
	private final ToggleButton groupButton;
	private final ScrollPane scrollPane;
	private final VBox items;
	private boolean hover = false;

	public PaletteGroup(final PaletteModel<G, I> model, final G groupModel) {
		// Group Button
		groupButton = new ToggleButton(model.getGroupLabel(groupModel));
		groupButton.setStyle(IDLE_GROUP_STYLE);
		groupButton.setFont(new Font(12));
		groupButton.setPadding(new Insets(1, 0, 1, 2));
		groupButton.setAlignment(Pos.BASELINE_LEFT);
		groupButton.setGraphic(new ImageView(model.getGroupIcon(groupModel)));
		groupButton.setMaxWidth(Double.MAX_VALUE);

		groupButton.setOnAction(e -> {
			if (groupButton.isSelected() == true) {
				refresh();
			} else {
				refresh();
				groupButton.setStyle(IDLE_GROUP_STYLE);
			}
		});

		groupButton.setOnMouseEntered(e -> {
			hover = true;
			refresh();
		});

		groupButton.setOnMouseExited(e -> {
			hover = false;
			refresh();
		});

		getChildren().add(groupButton);

		// Palette Items
		items = new VBox(2);
		items.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		for (I itemModel : model.getItems(groupModel)) {
			PaletteItem<I> paletteItem = new PaletteItem<>(model, itemModel);
			items.getChildren().add(paletteItem);
		}

		// Scroll Pane
		scrollPane = new ScrollPane();
		scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent; ");
		scrollPane.setFitToWidth(true);
		scrollPane.setPadding(Insets.EMPTY);
		scrollPane.setContent(items);
		getChildren().add(scrollPane);

		refresh();
	}

	private void refresh() {
		final boolean expanded = groupButton.isSelected();

		// Refresh button style
		if (hover) {
			groupButton.setStyle(HOVER_GROUP_STYLE);
		} else if (expanded) {
			groupButton.setStyle(EXPANDED_STYLE);
		} else {
			groupButton.setStyle(IDLE_GROUP_STYLE);
		}

		// Refresh scroll pane visibility
		scrollPane.setVisible(expanded);
		scrollPane.setManaged(expanded);
	}

	@Override
	protected double computePrefWidth(final double height) {
		double value = 0;

		// VBar policy is updated temporarily to allow computing appropriate value
		scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);

		for (final Node child : getChildren()) {
			value = Math.max(value, child.prefWidth(-1));
		}

		scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);

		// Add some additional padding
		value += 20;

		return value;
	}
}
