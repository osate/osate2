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
package org.osate.ge.gef;

import java.util.UUID;

import org.eclipse.gef.common.adapt.AdapterKey;
import org.eclipse.gef.mvc.fx.domain.IDomain;
import org.eclipse.gef.mvc.fx.viewer.IViewer;
import org.osate.ge.fx.palette.Palette;
import org.osate.ge.fx.palette.TestPaletteModelController;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;

import com.google.inject.Guice;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// TODO: Revise this into a component that combines the palette and the editor witch proper collapsable behavior.
public class DemoApplication extends Application {
	private IDomain domain;

	@Override
	public void start(final Stage primaryStage) throws Exception {
		// Create the domain
		this.domain = Guice.createInjector(new AgeModule()).getInstance(IDomain.class);

		final SplitPane sp = new SplitPane();

		final VBox palettePane = new VBox();
		final HBox palettePaneHeader = new HBox();
		final Label paletteHeaderLbl = new Label("Palette");
		final Button toggleBtn = new Button("T");
		palettePaneHeader.getChildren().addAll(paletteHeaderLbl, toggleBtn);
		paletteHeaderLbl.managedProperty().bind(paletteHeaderLbl.visibleProperty());

		final Palette palette = new Palette(new TestPaletteModelController());
		toggleBtn.setOnAction(new EventHandler<ActionEvent>() {
			double[] dividerPositions;

			@Override
			public void handle(ActionEvent event) {
				final boolean isVisible = !palette.isVisible();
				palette.setVisible(isVisible);
				paletteHeaderLbl.setVisible(isVisible);
				if (isVisible) {
					sp.setDividerPositions(dividerPositions);
				} else {
					dividerPositions = sp.getDividerPositions();
					sp.setDividerPositions(1.0);
				}
			}
		});
		palettePane.getChildren().addAll(palettePaneHeader, palette);

		final Parent canvas = getContentViewer().getCanvas();

		sp.getItems().addAll(canvas, palettePane);

		// Create viewer
		primaryStage.setScene(new Scene(sp));

		// Setup the stage
		primaryStage.setResizable(true);
		primaryStage.setWidth(640);
		primaryStage.setHeight(480);
		primaryStage.setTitle("Test Application");
		// primaryStage.sizeToScene();

		primaryStage.show();

		// TODO: Avoid hard coding values
		final double initialDividerPosition = Math.max(0.0, 1.0 - (palette.prefWidth(100) + 5) / sp.getWidth());
		sp.setDividerPositions(initialDividerPosition);
		sp.layout();
		SplitPane.setResizableWithParent(palettePane, false);

		// Active the domain
		domain.activate();

		// Build model
		final AgeDiagram diagram = new AgeDiagram();
		diagram.modify("Initial", m -> {
			final DiagramElement newElement = new DiagramElement(diagram, null, null,
					new RelativeBusinessObjectReference("test1"), UUID.randomUUID());
			m.addElement(newElement);
		});

		getContentViewer().getContents().setAll(diagram.getDiagramElements());
	}

	private IViewer getContentViewer() {
		return domain.getAdapter(AdapterKey.get(IViewer.class, IDomain.CONTENT_VIEWER_ROLE));
	}

	public static void main(final String[] args) {
		Application.launch(args);
	}
}
