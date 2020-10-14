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
package org.osate.ge.fx;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;

public class DiagramEditorNode extends Region {
	private static final String TITLE_STYLE = "-fx-background-color: linear-gradient(rgb(255,255,255), rgb(237,237,237));";
	private static final String COLLAPSE_BUTTON_HOVER_STYLE = "-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;";
	private static final String COLLAPSE_BUTTON_STYLE = "-fx-background-color: transparent;";
	private static final String PALETTE_CONTAINER_STYLE = "-fx-border-style: hidden solid hidden solid; -fx-border-color: #AAAAAA;";

	/**
	 * Contains the palette container and the canvas container
	 */
	private final HBox contents;
	private final VBox paletteContainer;
	private final AnchorPane paletteTitleContainer;
	private final StackPane canvasContainer;
	private final ScrollPane paletteScrollPane;
	private final ToggleButton collapseButton;
	private final Polygon collapsedPaletteGraphic;
	private final Polygon expandedPaletteGraphic;
	private final Label paletteTitle;
	private final Palette<?, ?> palette;

	public DiagramEditorNode(final PaletteModel<?, ?> paletteModel, final Node canvas) {
		//
		// Palette Title
		//
		paletteTitleContainer = new AnchorPane();
		paletteTitleContainer.setStyle(TITLE_STYLE);
		paletteTitle = new Label("Palette");

		collapsedPaletteGraphic = new Polygon(6.0, 5.0, 0.0, 11.0, 6.0, 16.0);
		collapsedPaletteGraphic.setFill(Color.TRANSPARENT);
		collapsedPaletteGraphic.setStroke(Color.GREY);
		collapsedPaletteGraphic.setStrokeWidth(1.0);
		collapsedPaletteGraphic.setStrokeType(StrokeType.INSIDE);

		expandedPaletteGraphic = new Polygon(0.0, 5.0, 6.0, 11.0, 0.0, 16.0);
		expandedPaletteGraphic.setFill(Color.TRANSPARENT);
		expandedPaletteGraphic.setStroke(Color.GREY);
		expandedPaletteGraphic.setStrokeWidth(1.0);
		expandedPaletteGraphic.setStrokeType(StrokeType.INSIDE);

		collapseButton = new ToggleButton();
		collapseButton.setStyle(COLLAPSE_BUTTON_STYLE);
		collapseButton.setOnMouseEntered(e -> collapseButton.setStyle(COLLAPSE_BUTTON_HOVER_STYLE));
		collapseButton.setOnMouseExited(e -> collapseButton.setStyle(COLLAPSE_BUTTON_STYLE));
		collapseButton.setPadding(new Insets(9, 0, 5, 0));
		collapseButton.setOnAction(e -> {
			updateCollapse();
		});

		paletteTitleContainer.getChildren().addAll(paletteTitle, collapseButton);
		AnchorPane.setTopAnchor(paletteTitle, 5.0);
		AnchorPane.setLeftAnchor(paletteTitle, 5.0);
		AnchorPane.setTopAnchor(collapseButton, 0.0);
		AnchorPane.setRightAnchor(collapseButton, 0.0);

		//
		// Palette
		//
		palette = new Palette<>(paletteModel);

		paletteScrollPane = new ScrollPane();
		paletteScrollPane.setContent(palette);
		paletteScrollPane.setFitToHeight(true);
		paletteScrollPane.setFitToWidth(true);
		paletteScrollPane.setPadding(Insets.EMPTY);

		paletteContainer = new VBox();
		paletteContainer.setStyle(PALETTE_CONTAINER_STYLE);
		paletteContainer.getChildren().addAll(paletteTitleContainer, paletteScrollPane);
		paletteScrollPane.prefHeightProperty().bind(paletteContainer.heightProperty());
		paletteScrollPane.minWidthProperty().bind(palette.minWidthProperty());

		//
		// Canvas Group
		//
		canvasContainer = new StackPane();
		canvasContainer.getChildren().add(canvas);
		canvasContainer
				.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

		//
		// HBox containing the canvas and the palette
		//
		contents = new HBox();
		contents.getChildren().addAll(canvasContainer, paletteContainer);
		HBox.setHgrow(canvasContainer, Priority.ALWAYS);
		HBox.setHgrow(paletteContainer, Priority.NEVER);

		getChildren().add(contents);

		updateCollapse();
	}

	@Override
	public void resize(double width, double height) {
		super.resize(width, height);
		paletteContainer.setMinWidth(paletteContainerWidth());
	}

	@Override
	public void layoutChildren() {
		contents.resize(getWidth(), getHeight());
	}

	public void updateCollapse() {
		// TODO; Don't allow resize while collapsed
		// TODO: Style while collapsed. May be solved by adjusting background colors permaneantly
		// TODO; Is all this required? Can just hide a group or something?
		if (collapseButton.isSelected()) {
			paletteScrollPane.setManaged(false);
			paletteScrollPane.setVisible(false);
			paletteTitle.setManaged(false);
			paletteTitle.setVisible(false);
			collapseButton.setGraphic(collapsedPaletteGraphic);
			collapseButton.setMinWidth(10);
			collapseButton.setMaxWidth(10);
		} else {
			paletteScrollPane.setManaged(true);
			paletteScrollPane.setVisible(true);
			paletteTitle.setManaged(true);
			paletteTitle.setVisible(true);

			collapseButton.setGraphic(expandedPaletteGraphic);
			collapseButton.setMaxSize(30, 25);
			collapseButton.setMinSize(30, 25);
		}

		paletteContainer.setMinWidth(paletteContainerWidth());
	}

	private double paletteContainerWidth() {
		// TODO
		return collapseButton.isSelected() ? 10 : palette.prefWidth(-1);
	}
}
