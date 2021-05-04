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

import javafx.scene.Cursor;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * Base class for interactions. Provides dedicated functions to be overridden for specific event types.
 */
public abstract class BaseInteraction implements Interaction {
	@Override
	public final InteractionState handleEvent(final InputEvent e) {
		if (e.getEventType() == MouseEvent.MOUSE_MOVED) {
			return onMouseMoved((MouseEvent) e);
		} else if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {
			return onMousePressed((MouseEvent) e);
		} else if (e.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			return onMouseDragged((MouseEvent) e);
		} else if (e.getEventType() == MouseEvent.MOUSE_RELEASED) {
			return onMouseReleased((MouseEvent) e);
		} else if (e.getEventType() == KeyEvent.KEY_PRESSED) {
			return onKeyPressed((KeyEvent) e);
		}

		return InteractionState.IN_PROGRESS;
	}

	@Override
	public Cursor getCursor() {
		return null;
	}

	protected Interaction.InteractionState onMouseMoved(final MouseEvent e) {
		return InteractionState.IN_PROGRESS;
	}

	/**
	 * Handles mouse press events. By default, the interaction is completed if the secondary mouse button is pressed.
	 * @param e the mouse event
	 * @return the new state for the interaction.
	 */
	protected Interaction.InteractionState onMousePressed(final MouseEvent e) {
		if (e.getButton() == MouseButton.SECONDARY) {
			return InteractionState.COMPLETE;
		}

		return InteractionState.IN_PROGRESS;
	}

	protected Interaction.InteractionState onMouseDragged(final MouseEvent e) {
		return InteractionState.IN_PROGRESS;
	}

	protected Interaction.InteractionState onMouseReleased(final MouseEvent e) {
		return InteractionState.IN_PROGRESS;
	}

	protected Interaction.InteractionState onKeyPressed(final KeyEvent e) {
		if (e.getCode() == KeyCode.ESCAPE) {
			return InteractionState.COMPLETE;
		}

		return InteractionState.IN_PROGRESS;
	}
}
