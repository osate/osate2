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

import org.osate.ge.internal.diagram.runtime.DiagramElement;

import javafx.scene.Cursor;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *  {@link InputEventHandler} which handles selection.
 */
public class SelectInputEventHandler implements InputEventHandler {
	private final AgeEditor editor;
	private boolean selectOnRelease = false; // Flag used to delay selection until the mouse button is released

	public SelectInputEventHandler(final AgeEditor editor) {
		this.editor = Objects.requireNonNull(editor, "editor must not be null");
	}

	@Override
	public Cursor getCursor(final MouseEvent mouseMoveEvent) {
		return null;
	}

	@Override
	public HandledEvent handleEvent(final InputEvent e) {
		if (e.getEventType() != MouseEvent.MOUSE_PRESSED && e.getEventType() != MouseEvent.MOUSE_RELEASED) {
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

		if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {
			if (mouseEvent.isShiftDown()) {
				// If shift is held down. Ensure the element is at the end of the list
				final List<DiagramElement> newSelectedElements = editor.getSelectedDiagramElements();
				newSelectedElements.remove(clickedDiagramElement);
				newSelectedElements.add(clickedDiagramElement);
				editor.selectDiagramNodes(newSelectedElements);
			} else if (mouseEvent.isControlDown()) {
				if (mouseEvent.getButton() == MouseButton.PRIMARY
						|| !editor.getSelectedDiagramElements().contains(clickedDiagramElement)) {
					// If Ctrl is held down, then remove the element if it is already in the selection. Otherwise, add it.
					final List<DiagramElement> newSelectedElements = editor.getSelectedDiagramElements();
					if (newSelectedElements.contains(clickedDiagramElement)) {
						newSelectedElements.remove(clickedDiagramElement);
					} else {
						newSelectedElements.add(clickedDiagramElement);
					}
					editor.selectDiagramNodes(newSelectedElements);
				}
			} else {
				final boolean alreadySelected = editor.getSelectedDiagramElements().contains(clickedDiagramElement);
				// Don't overwrite the selection if it is already selected
				// If it is a primary click then the selection will be overwritten on release.
				// Otherwise, the selection will be preserved so that the selection for the context menu will be correct
				if (alreadySelected) {
					if (mouseEvent.getButton() == MouseButton.PRIMARY) {
						selectOnRelease = true;
					}
				} else {
					// Replace the selection with the object
					editor.selectDiagramNodes(Collections.singletonList(clickedDiagramElement));
				}
			}

			// Allow subsequent input event handlers to handle the event
			return null;
		} else if (e.getEventType() == MouseEvent.MOUSE_RELEASED) {
			// Overwrite the selection if the select on release flag has bee nset
			if (selectOnRelease) {
				editor.selectDiagramNodes(Collections.singletonList(clickedDiagramElement));
				selectOnRelease = false;
			}

			// Allow subsequent input event handlers to handle the event
			return null;
		}

		return HandledEvent.consumed();
	}
}
