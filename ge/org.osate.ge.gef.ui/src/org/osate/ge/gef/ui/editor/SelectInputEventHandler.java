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

package org.osate.ge.gef.ui.editor;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.gef.LabelNode;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

import javafx.geometry.Bounds;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

// TODO: Rename since it now covers direct editing
/**
 *  {@link InputEventHandler} which handles selection behavior.
 */
public class SelectInputEventHandler implements InputEventHandler {
	private final AgeEditor editor;

	public SelectInputEventHandler(final AgeEditor editor) {
		this.editor = Objects.requireNonNull(editor, "editor must not be null");
	}

	@Override
	public Cursor getCursor(final MouseEvent mouseMoveEvent) {
		return null;
	}

	@Override
	public HandledEvent handleEvent(final InputEvent e) {
		// Only handle primary mouse button presses
		if (e.getEventType() != MouseEvent.MOUSE_PRESSED) {
			return null;
		}

		final MouseEvent mouseEvent = (MouseEvent) e;
		if (mouseEvent.getButton() != MouseButton.PRIMARY && mouseEvent.getButton() != MouseButton.SECONDARY) {
			return null;
		}

		final DiagramElement clickedDiagramElement = InputEventHandlerUtil
				.getTargetDiagramElement(editor.getGefDiagram(), e.getTarget());

		if (!editor.getPaletteModel().isSelectToolActive() || clickedDiagramElement == null) {
			return null;
		}

		if (mouseEvent.isShiftDown()) {
			// If shift is held down. Ensure the element is at the end of the list
			final List<DiagramElement> newSelectedElements = editor.getSelectedDiagramElementList();
			newSelectedElements.remove(clickedDiagramElement);
			newSelectedElements.add(clickedDiagramElement);
			editor.selectDiagramNodes(newSelectedElements);
		} else if (mouseEvent.isControlDown()) {
			// If Ctrl is held down, then remove the element if it is already in the selection. Otherwise, add it.
			final List<DiagramElement> newSelectedElements = editor.getSelectedDiagramElementList();
			if (newSelectedElements.contains(clickedDiagramElement)) {
				newSelectedElements.remove(clickedDiagramElement);
			} else {
				newSelectedElements.add(clickedDiagramElement);
			}
			editor.selectDiagramNodes(newSelectedElements);
		} else {
			final boolean alreadySelected = editor.getSelectedDiagramElementList().contains(clickedDiagramElement);

			// Replace the selection with the object
			editor.selectDiagramNodes(Collections.singletonList(clickedDiagramElement));

			if (alreadySelected) {
				final LabelNode primaryLabel = editor.getGefDiagram().getPrimaryLabelSceneNode(clickedDiagramElement);
				if (isAncestor(primaryLabel, (Node) e.getTarget())) {
					System.err.println("TODO: ENABLE DIRECT EDITING");
					// TODO; Start interaction

					// TODO; Move to interaction
					// TODO: Add to overlay and place on top of label
					// TODO: Popualte value based on name for renaming

					// TODO: See how this was done before
					final String nameForRenaming = clickedDiagramElement.getBusinessObjectHandler()
							.getNameForRenaming(new GetNameContext(clickedDiagramElement.getBusinessObject()));
					final TextField editField = new TextField(nameForRenaming); // TODO

					// TODO: Decide how to set. Just using length results in a really long value
					editField.setPrefColumnCount(Math.max(20, nameForRenaming.length() / 2));

					// TODO: Fix. uses strong listener
					primaryLabel.localToSceneTransformProperty().addListener((o, oldValue, newValue) -> {
						updateEditFieldLayout(primaryLabel, editField);
					});
					// TODO: Size and position. Bind in case of zoom
					// TODO: Should label be affected by zoom
					editor.getOverlays().getChildren().add(editField);

					// TODO: Not needed editField.resize(400, 50);
					updateEditFieldLayout(primaryLabel, editField);

					// TODO: Verify that marquee doesn't activate itself while direct editing

					// TODO: Will need to deactivate and remove at some point

				}
			}
		}

		return HandledEvent.handled();
	}

	// TODO: Rename
	private void updateEditFieldLayout(final LabelNode label, final TextField editField) {

		final Bounds labelBoundsInOverlay = editor.getOverlays()
				.sceneToLocal(label.getLocalToSceneTransform().transform(label.getBoundsInLocal()));

		// TODO: Transform the entire bounds of the primary label into overlay coordinates?

		// TODO: Ensure a minimum size(pad both sides equally)

		// TODO: Center here? Must be sized before calling first time

		// TODO; Height shopuld be min height

		editField.applyCss(); // TODO: Do this outside of the function
		// TODO: Rename variable and share with other branch
		// final Point2D labelPositionScene = labelToSceneTransform.transform(0, 0);
		// final Point2D labelPositionOverlay = editor.getOverlays().sceneToLocal(labelPositionScene);

		// TODO: Easy way to generate preferred width based on current value?
		final double width = Math.max(editField.prefWidth(-1), labelBoundsInOverlay.getWidth());
		final double height = editField.prefHeight(-1);
		System.err.println(editField.prefWidth(-1) + " : " + labelBoundsInOverlay.getWidth() + " : " + width + " : "
				+ editField.getPrefColumnCount()); // TODO
		// TODO: Centering
		editField.resize(width, height);
		editField.setLayoutX(labelBoundsInOverlay.getMinX() + (labelBoundsInOverlay.getWidth() - width) / 2.0);
		editField.setLayoutY(labelBoundsInOverlay.getMinY() + (labelBoundsInOverlay.getHeight() - height) / 2.0);
	}

	// TODO: Document. REname and make specific to primary labels?
	private boolean isAncestor(final Node potentialAncestor, final Node other) {
		if (potentialAncestor == null) {
			return false;
		}

		for (Node tmp = other; tmp != null; tmp = tmp.getParent()) {
			if (tmp == potentialAncestor) {
				return true;
			}
		}
		return false;
	}
}
