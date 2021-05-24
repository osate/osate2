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
import java.util.Objects;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.MenuDetectListener;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.gef.LabelNode;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.ui.editor.EditorRenameUtil;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.WeakChangeListener;
import javafx.geometry.Bounds;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.transform.Transform;

/**
 *  {@link InputEventHandler} which handles renaming behavior.
 */
public class RenameInputEventHandler implements InputEventHandler {
	private final AgeEditor editor;
	private boolean wasSelected = false;
	private DiagramElement mousePressDiagramElement = null;

	public RenameInputEventHandler(final AgeEditor editor) {
		this.editor = Objects.requireNonNull(editor, "editor must not be null");
	}

	@Override
	public Cursor getCursor(final MouseEvent mouseMoveEvent) {
		return null;
	}

	@Override
	public HandledEvent handleEvent(final InputEvent e) {
		// Only handle primary mouse button releases
		if (e.getEventType() != MouseEvent.MOUSE_PRESSED && e.getEventType() != MouseEvent.MOUSE_RELEASED) {
			return null;
		}

		final MouseEvent mouseEvent = (MouseEvent) e;
		if (mouseEvent.getButton() != MouseButton.PRIMARY) {
			return null;
		}

		final DiagramElement clickedDiagramElement = InputEventHandlerUtil
				.getTargetDiagramElement(editor.getGefDiagram(), e.getTarget());
		if (!editor.getPaletteModel().isSelectToolActive() || clickedDiagramElement == null) {
			return null;
		}

		if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {

			wasSelected = editor.getSelectedDiagramElements().contains(clickedDiagramElement);
			mousePressDiagramElement = clickedDiagramElement;
		} else if (e.getEventType() == MouseEvent.MOUSE_RELEASED && mouseEvent.getButton() == MouseButton.PRIMARY
				&& !mouseEvent.isShiftDown() && !mouseEvent.isControlDown()
				&& wasSelected && clickedDiagramElement == mousePressDiagramElement
				&& editor.getSelectedDiagramElements().contains(clickedDiagramElement)) {
			final LabelNode primaryLabel = editor.getGefDiagram().getPrimaryLabelSceneNode(clickedDiagramElement);
			if (isAncestor(primaryLabel, (Node) e.getTarget()) && EditorRenameUtil.canRename(clickedDiagramElement)) {
				final RenameInteraction newInteraction = new RenameInteraction(clickedDiagramElement, primaryLabel,
						editor);
				return HandledEvent.newInteraction(newInteraction);
			}

			return HandledEvent.consumed();
		}

		return null;
	}

	/**
	 * Returns true if potential ancestor is an ancestor of other.
	 * @param potentialAncestor the node which is being checked to determine if it is an ancestor.
	 * @param other the potential descendant node
	 * @return true if the potential ancestor is an ancestor of the other node.
	 */
	private static boolean isAncestor(final Node potentialAncestor, final Node other) {
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

class RenameInteraction extends BaseInteraction {
	private static final String ERROR_STYLE = "-fx-control-inner-background: #FBE9EB; -fx-text-fill: #C90017;";

	private final AgeEditor editor;
	private final DiagramElement diagramElement;
	private final TextField editField;
	private final ChangeListener<Transform> labelTransformChangeListener;
	private final String originalName;

	/**
	 * {@link MenuDetectListener} which consumes the event to avoid showing the context menu. Avoids showing the
	 * editor's context menu when interaction is active. Otherwise, multiple context menus will be shown when
	 * right-clicking on {@link #editField}
	 */
	private final MenuDetectListener supressSwtMenu = e -> {
		e.doit = false;
	};

	/**
	 * Text node used to measure the text size off-screen so that {@link #editField} can be sized appropriately.
	 */
	private Text measuringText = new Text();

	/**
	 * Creates a new instance
	 * @param diagramElement the diagram element being renamed
	 * @param primaryLabel the primary label for the diagram element
	 * @param editor the editor
	 */
	public RenameInteraction(final DiagramElement diagramElement, final LabelNode primaryLabel,
			final AgeEditor editor) {
		// Add the measuring text to a scene so that sizes can be calculated.
		new Scene(new Group(measuringText));

		this.editor = Objects.requireNonNull(editor, "editor must not be null");
		this.diagramElement = Objects.requireNonNull(diagramElement, "diagramElement must not be null");
		this.originalName = diagramElement.getBusinessObjectHandler()
				.getNameForRenaming(new GetNameContext(diagramElement.getBusinessObject()));
		this.editField = new TextField(originalName);
		editor.getOverlays().getChildren().add(editField);

		// Avoid showing the editor's context menu while the interaction is active
		editor.getFxCanvas().addMenuDetectListener(supressSwtMenu);

		// Listen for changes to the label's transform
		this.labelTransformChangeListener = (o, oldValue, newValue) -> {
			layoutEditField(primaryLabel, editField);
		};
		primaryLabel.localToSceneTransformProperty()
				.addListener(new WeakChangeListener<>(labelTransformChangeListener));

		// Set the edit field's position
		editField.applyCss();
		layoutEditField(primaryLabel, editField);

		// Update field size when the contents change
		editField.textProperty().addListener((o, oldValue, newValue) -> {
			editField.resize(calculateWidth(), editField.getHeight());

			// Validate the new value
			if (EditorRenameUtil.validateName(diagramElement, newValue) == null) {
				editField.setStyle("");
			} else {
				editField.setStyle(ERROR_STYLE);
			}
		});
		editField.requestFocus();
	}

	private double calculateWidth() {
		measuringText.setText(editField.getText() + "WW");
		measuringText.applyCss();
		return measuringText.getLayoutBounds().getWidth();
	}

	@Override
	public void close() {
		// Check if the name was changed
		final String newName = editField.getText();
		if (!Objects.equals(originalName, newName)) {
			// Check if the new name is valid
			final String validationError = EditorRenameUtil.validateName(diagramElement, newName);
			if (validationError == null) {
				// Rename the business object
				EditorRenameUtil.rename(diagramElement, newName, editor);
			} else {
				// Show an error
				MessageDialog.openError(editor.getEditorSite().getShell(), "Unable to edit value", validationError);
			}
		}

		// Re-enable the SWT context menu
		editor.getFxCanvas().removeMenuDetectListener(supressSwtMenu);

		// Remove the edit field
		((Group) editField.getParent()).getChildren().remove(editField);
	}

	@Override
	protected Interaction.InteractionState onMousePressed(final MouseEvent e) {
		if (e.getTarget() instanceof Node) {
			for (Node tmp = (Node) e.getTarget(); tmp != null; tmp = tmp.getParent()) {
				if (tmp == editField) {
					return InteractionState.IN_PROGRESS;
				}
			}
		}

		// Select the clicked element and deactivate direct editing
		final DiagramElement clickedDiagramElement = InputEventHandlerUtil
				.getTargetDiagramElement(editor.getGefDiagram(), e.getTarget());
		if (clickedDiagramElement != null) {
			editor.selectDiagramNodes(Collections.singletonList(clickedDiagramElement));
		}

		return InteractionState.COMPLETE;
	}

	@Override
	protected Interaction.InteractionState onKeyPressed(final KeyEvent e) {
		if (e.getCode() == KeyCode.ENTER) {
			return InteractionState.COMPLETE;
		} else if (e.getCode() == KeyCode.ESCAPE) {
			// Revert changes so name will not be saved
			editField.setText(originalName);
			return InteractionState.COMPLETE;
		}

		return super.onKeyPressed(e);
	}

	private void layoutEditField(final LabelNode label, final TextField editField) {
		// Determine the size of the edit field
		final double width = calculateWidth();
		final double height = editField.prefHeight(-1);
		editField.resize(width, height);

		// Position the edit field so it is centered around the label
		final Bounds labelBoundsInOverlay = editor.getOverlays()
				.sceneToLocal(label.getLocalToSceneTransform().transform(label.getBoundsInLocal()));
		editField.setLayoutX(labelBoundsInOverlay.getMinX() + (labelBoundsInOverlay.getWidth() - width) / 2.0);
		editField.setLayoutY(labelBoundsInOverlay.getMinY() + (labelBoundsInOverlay.getHeight() - height) / 2.0);
	}
}
