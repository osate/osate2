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

import java.awt.Composite;
import java.util.UUID;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.mvc.fx.models.SelectionModel;
import org.eclipse.gef.mvc.fx.ui.parts.AbstractFXEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.osate.ge.fx.palette.Palette;
import org.osate.ge.fx.palette.TestPaletteGroup;
import org.osate.ge.fx.palette.TestPaletteItem;
import org.osate.ge.fx.palette.TestPaletteModel;
import org.osate.ge.gef.AgeModule;
import org.osate.ge.gef.ui.AgeUiModule;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;

import com.google.inject.Guice;
import com.google.inject.util.Modules;

import javafx.embed.swt.FXCanvas;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

// TODO: Implement selection notification..
// TODO: Rename to AgeDiagramEditor to match name of existing editor?
public class AgeEditor extends AbstractFXEditor {
	public AgeEditor() {
		super(Guice.createInjector(Modules.override(new AgeModule()).with(new AgeUiModule())));
	}

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		super.init(site, input);

		// TODO: Create and set model
//		// TODO: Should load something from the input
		final AgeDiagram diagram = new AgeDiagram();
		diagram.modify("Initial", m -> {
			final DiagramElement newElement = new DiagramElement(diagram, null, null,
					new RelativeBusinessObjectReference("test1"), UUID.randomUUID());
			m.addElement(newElement);
		});

		getContentViewer().getContents().setAll(diagram.getDiagramElements());
	}

	// Provide access to the SWT widget. This should only be used for testing.
	@Override
	public FXCanvas getCanvas() {
		return super.getCanvas();
	}

	@Override
	public void createPartControl(final Composite parent) {
		super.createPartControl(parent);

		// Create SWT Menu for testing purposes. In reality it would be registered to accept contributions
		final FXCanvas canvas = getCanvas();
		final Menu testMenu = new Menu(canvas);
		canvas.setMenu(testMenu);

		final MenuItem miTest = new MenuItem(testMenu, SWT.NONE);
		miTest.setText("Test Menu Item");
		miTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final SelectionModel selectionModel = getContentViewer().getAdapter(SelectionModel.class);
				final String selectionDescription = selectionModel.getSelectionUnmodifiable().stream()
						.map(cp -> cp.getContent()).filter(c -> c instanceof DiagramElement).map(de -> de.toString())
						.collect(Collectors.joining("\n"));
				MessageDialog.openInformation(canvas.getShell(), "Test",
						"Test Menu Item was selected.\nEditor Selection:\n" + selectionDescription);
			}
		});
	}

	@Override
	protected void hookViewers() {
		// TODO: Replace this with widget derived from DemoApplication
		final String TITLE_STYLE = "-fx-background-color: linear-gradient(rgb(255,255,255), rgb(237,237,237));";
		final String COLLAPSE_BUTTON_ACTIVATED = "-fx-background-color: linear-gradient(rgb(255,255,255), rgb(237,237,237));"
				+ "-fx-border-style: dotted; -fx-border-color: black;";
		final String COLLAPSE_BUTTON_IDLE = "-fx-background-color: linear-gradient(rgb(255,255,255), rgb(237,237,237));"
				+ "-fx-border-style: dotted; -fx-border-color: black;";

		final SplitPane sp = new SplitPane();
		final VBox paletteContainer = new VBox();
		final AnchorPane titleContainer = new AnchorPane();
		final ScrollPane scrollPane = new ScrollPane();
		titleContainer.setStyle(TITLE_STYLE);
		final Label paletteTitle = new Label("Palette");
		paletteTitle.setStyle(TITLE_STYLE);
		paletteTitle.setPadding(new Insets(5, 0, 5, 0));
		final ToggleButton collapseButton = new ToggleButton();
		collapseButton.setPadding(new Insets(10, 0, 10, 0));
		collapseButton.setStyle(COLLAPSE_BUTTON_IDLE);
		collapseButton.setMaxSize(30, 30);
		collapseButton.setMinSize(30, 30);
		collapseButton.setOnAction(e -> {

			if (collapseButton.isSelected()) {
				scrollPane.setManaged(false);
				scrollPane.setVisible(false);
				paletteTitle.setManaged(false);
				paletteTitle.setVisible(false);
				sp.setDividerPositions(1.0);
				collapseButton.setStyle(COLLAPSE_BUTTON_ACTIVATED);
				collapseButton.setGraphic("ge/Icons/CollapsedIcon");
				collapseButton.setMinWidth(10);
				collapseButton.setMaxWidth(10);
			}

			else {
				scrollPane.setManaged(true);
				scrollPane.setVisible(true);
				paletteTitle.setManaged(true);
				paletteTitle.setVisible(true);
				sp.setDividerPositions(1.0 - (paletteContainer.getPrefWidth() / sp.getWidth()));
				collapseButton.setStyle(COLLAPSE_BUTTON_IDLE);
				collapseButton.setGraphic("ge/Icons/OpenedIcon");
				collapseButton.setMaxSize(30, 30);
				collapseButton.setMinSize(30, 30);
			}

		});

		final Palette<TestPaletteGroup, TestPaletteItem> palette = new Palette<>(new TestPaletteModel());

		// TODO: Use a color picker to determine background gradient of current palette.

		scrollPane.setContent(palette);
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);
		scrollPane.maxWidthProperty().bind(paletteContainer.maxWidthProperty());
		scrollPane.prefWidthProperty().bind(paletteContainer.prefWidthProperty());
		paletteContainer.setPrefWidth(250);
		paletteContainer.setMaxWidth(500);

		titleContainer.getChildren().addAll(paletteTitle, collapseButton);
		AnchorPane.setRightAnchor(collapseButton, 5.0);
		AnchorPane.setLeftAnchor(paletteTitle, 5.0);
		paletteContainer.getChildren().addAll(titleContainer, scrollPane);

		sp.getItems().addAll(getContentViewer().getCanvas(), paletteContainer);

		// Set the scene
		getCanvas().setScene(new Scene(sp));

		sp.setDividerPositions(1.0 - (paletteContainer.getPrefWidth() / sp.getWidth()));
		sp.layout();
		SplitPane.setResizableWithParent(palette, false);
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO
	}

	@Override
	public void doSaveAs() {
		// TODO
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO
		return false;
	}
}
