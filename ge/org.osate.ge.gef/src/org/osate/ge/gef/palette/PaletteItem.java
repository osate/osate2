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

import java.util.Objects;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WeakChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PaletteItem<I> extends VBox {
	/**
	 * Style class used to find palette item durign tests.
	 */
	public static final String STYLE_CLASS = "palette_item";

	private static final String HOVER_ITEM_STYLE = "-fx-background-color: #fce4b3;";
	private static final String SELECTED_ITEM_STYLE = "-fx-background-color: #cfe3fa;";
	private static final String IDLE_ITEM_STYLE = "-fx-background-color: #ffffff;";
	private final PaletteModel<?, ?> model;
	private final Button button;
	private boolean hovered;
	private final I item;
	private ChangeListener<I> listener;

	public PaletteItem(final PaletteModel<?, I> model, I item) {
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.item = Objects.requireNonNull(item, "item must not be null");
		getStyleClass().add(STYLE_CLASS);
		hovered = false;
		button = new Button(model.getItemLabel(item));
		button.setMaxWidth(Double.MAX_VALUE);
		button.setPadding(new Insets(0, 0, 0, 20));
		button.setFont(new Font(12));
		button.setOnMouseEntered(e -> {
			hovered = true;
			updateStyle();
		});
		button.setOnMouseExited(e -> {
			hovered = false;
			updateStyle();
		});
		this.listener = this::activeItemChanged;
		model.activeItemProperty().addListener(new WeakChangeListener<I>(listener));

		button.setAlignment(Pos.BASELINE_LEFT);
		button.setGraphic(new ImageView(model.getItemIcon(item)));
		button.setOnAction(e -> {
			model.activateItem(item);
		});
		this.getChildren().add(button);
		updateStyle();
	}

	/**
	 * Returns the button contained inside the palette. Intended for testing only
	 * @return the button
	 */
	public final Button getButton() {
		return button;
	}

	private void activeItemChanged(ObservableValue<? extends I> observable, I oldValue, I value) {
		updateStyle();
	}

	private void updateStyle() {
		if (hovered && model.getActiveItem() != item) {
			button.setStyle(HOVER_ITEM_STYLE);
		}
		else if (!hovered && model.getActiveItem() != item) {
			button.setStyle(IDLE_ITEM_STYLE);
		}
		else if (model.getActiveItem() == item) {
			button.setStyle(SELECTED_ITEM_STYLE);
		}
	}
}