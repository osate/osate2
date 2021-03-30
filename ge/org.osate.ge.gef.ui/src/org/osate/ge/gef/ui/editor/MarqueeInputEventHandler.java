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

import org.osate.ge.gef.ui.diagram.GefAgeDiagram;
import org.osate.ge.gef.ui.editor.overlays.Handle;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

import javafx.scene.Cursor;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *  {@link InputEventHandler} for marquee selection.
 */
public class MarqueeInputEventHandler implements InputEventHandler {
	private final AgeEditorPaletteModel paletteModel;

	public MarqueeInputEventHandler(final AgeEditorPaletteModel paletteModel) {
		this.paletteModel = paletteModel;
	}

	@Override
	public Cursor getCursor(MouseEvent mouseMoveEvent) {
		// TODO: Check to ensure it's not a scrollbar
		return paletteModel.isMarqueeToolActive() ? Cursor.CROSSHAIR : null;
	}

	@Override
	public HandledEvent handleEvent(GefAgeDiagram gefDiagram, InputEvent e) {
		if (e.getEventType() != MouseEvent.MOUSE_PRESSED || ((MouseEvent) e).getButton() != MouseButton.PRIMARY) {
			return null;
		}

		final DiagramElement clickedDiagramElement = InputEventHandlerUtil.getClosestDiagramElement(gefDiagram,
				e.getTarget());
		if (paletteModel.isMarqueeToolActive()
				|| (paletteModel.isSelectToolActive() && clickedDiagramElement == null
						&& !(e.getTarget() instanceof Handle))) {
			// TODO: Need to ensure that this isn't fired when using the scrollbar
			System.err.println("START MARQUEE");

			// TODO: Create interaction
			return HandledEvent.handled();
		}

		return null;
	}
}
