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
import javafx.scene.input.MouseEvent;

/**
 * Interface for objects which handle input events. Such handlers may optionally start an interaction. Once an interaction is started,
 * events are passed to the interaction rather than the input event handlers until the interaction is complete.
 */
public interface InputEventHandler {
	/**
	 * The result of handling an event
	 */
	static class HandledEvent {
		private static final HandledEvent CONSUMED = new HandledEvent(null);

		/**
		 * If an interaction is started, then this contains the new interaction.
		 */
		final Interaction newInteraction;

		private HandledEvent(final Interaction newInteraction) {
			this.newInteraction = newInteraction;
		}

		/**
		 * Returns an instance used in cases where the event has been handled, an interaction was not started, and
		 * the event should not be passed to subsequent event handlers.
		 * @return the instance.
		 */
		public static HandledEvent consumed() {
			return CONSUMED;
		}

		/**
		 * Returns an instance that indicates that the event has been handled and a new interaction has started.
		 * @param interaction the new interaction
		 * @return the instance
		 */
		public static HandledEvent newInteraction(final Interaction interaction) {
			return new HandledEvent(interaction);
		}
	}

	/**
	* Returns the mouse cursor based that should override the default cursor.
	* @param mouseMoveEvent is the mouse move event containing the location of the cursor.
	* @return the cursor that should be used or null if the cursor shouldn't be overridden.
	*/
	Cursor getCursor(final MouseEvent mouseMoveEvent);

	/**
	 * Handles the event.
	 * @param e the new input event
	 * @return the result of handling the event. If the event was not consumed by the handler, then null is returned.
	 */
	HandledEvent handleEvent(InputEvent e);
}
