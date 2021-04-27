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

import java.util.Objects;

import org.osate.ge.internal.diagram.runtime.DiagramElement;

import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *  {@link InputEventHandler} which handles moving diagram elements.
 */
public class MoveInputEventHandler implements InputEventHandler {
	/**
	 * Minimum mouse dragged distance before starting the move interaction. This avoids starting the move interaction
	 * when the user is attempting to perform a rename or other interaction.
	 */
	private static double MIN_MOUSE_DRAGGED_DISTANCE = 10.0;

	private final AgeEditor editor;

	/**
	 * Location of the mouse pressed event in scene coordinates. Used to determine if the mouse was dragged enough to
	 * start the move interaction.
	 */
	private Point2D pressLocationScene;

	public MoveInputEventHandler(final AgeEditor editor) {
		this.editor = Objects.requireNonNull(editor, "editor must not be null");
	}

	@Override
	public Cursor getCursor(final MouseEvent mouseMoveEvent) {
		return null;
	}

	@Override
	public HandledEvent handleEvent(final InputEvent e) {
		if (e.getEventType() != MouseEvent.MOUSE_PRESSED && e.getEventType() != MouseEvent.MOUSE_DRAGGED) {
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
			// Store the starting position.
			pressLocationScene = new Point2D(mouseEvent.getSceneX(), mouseEvent.getSceneY());
		} else if (e.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			final double d = pressLocationScene.distance(mouseEvent.getSceneX(), mouseEvent.getSceneY());
			if (d > MIN_MOUSE_DRAGGED_DISTANCE) {
				final MoveInteraction newInteraction = new MoveInteraction();
				return HandledEvent.newInteraction(newInteraction);
			}
		}

		return HandledEvent.consumed();
	}
}

class MoveInteraction extends BaseInteraction {
	@Override
	public void close() {

	}

	@Override
	protected Interaction.InteractionState onMouseReleased(final MouseEvent e) {
		if (e.getButton() != MouseButton.PRIMARY) {
			return super.onMousePressed(e);
		}

		System.err.println("TODO: DO ACTUAL MOVE");

		return InteractionState.COMPLETE;
	}
}