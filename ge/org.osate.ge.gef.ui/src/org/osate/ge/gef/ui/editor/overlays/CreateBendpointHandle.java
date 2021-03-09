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
package org.osate.ge.gef.ui.editor.overlays;

import org.osate.ge.internal.diagram.runtime.DiagramElement;

import javafx.scene.shape.Circle;

// TODO: Document
public class CreateBendpointHandle extends Circle implements Handle {
	private final DiagramElement diagramElement;

	public CreateBendpointHandle(final DiagramElement diagramElement, final boolean primary) {
		super(4.0, primary ? OverlayColors.PRIMARY_SELECTION_HANDLE_FILL_COLOR
				: OverlayColors.SECONDARY_SELECTION_HANDLE_FILL_COLOR);
		this.diagramElement = diagramElement;
		setStroke(OverlayColors.HANDLE_COLOR); // TODO
		setStrokeWidth(1.0);
	}

	@Override
	public DiagramElement getDiagramElement() {
		return diagramElement;
	}

	@Override
	public void setPrimary(final boolean value) {
		setFill(value ? OverlayColors.PRIMARY_SELECTION_HANDLE_FILL_COLOR
				: OverlayColors.SECONDARY_SELECTION_HANDLE_FILL_COLOR);
	}
}
