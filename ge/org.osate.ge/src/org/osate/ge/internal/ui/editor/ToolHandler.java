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
package org.osate.ge.internal.ui.editor;

import java.util.Objects;

import org.eclipse.graphiti.ui.editor.DefaultPaletteBehavior;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.ui.tools.ActivatedEvent;
import org.osate.ge.internal.ui.tools.DeactivatedEvent;
import org.osate.ge.internal.ui.tools.SelectionChangedEvent;
import org.osate.ge.internal.ui.tools.Tool;

import com.google.common.collect.ImmutableList;

/**
 * Handles invoking tools and tracking the current tool.
 *
 */
public class ToolHandler {
	private final DefaultPaletteBehavior paletteBehavior;
	private Tool activeTool = null;
	private ImmutableList<BusinessObjectContext> selectedBocs = ImmutableList.of();
	private final AgeDiagram diagram;
	private final AadlModificationService aadlModService;
	private final UiService uiService;
	private final ColoringService coloringService;

	public ToolHandler(final DefaultPaletteBehavior paletteBehavior,
			final AgeDiagram diagram,
			final AadlModificationService aadlModService, final UiService uiService,
			final ColoringService coloringService) {

		this.paletteBehavior = paletteBehavior;
		this.diagram = Objects.requireNonNull(diagram, "diagram must not be null");
		this.aadlModService = Objects.requireNonNull(aadlModService, "aadlModService must not be null");
		this.uiService = Objects.requireNonNull(uiService, "uiService must not be null");
		this.coloringService = Objects.requireNonNull(coloringService, "coloringService must not be null");
	}

	public boolean isToolActive() {
		return activeTool != null;
	}

	public void activate(final Tool tool) {
		Objects.requireNonNull(tool, "tool must not be null");

		// Deactivate the current tool
		if (activeTool != null) {
			deactivateActiveTool();
		}

		activeTool = tool;
		paletteBehavior.refreshPalette();
		activeTool.activated(new ActivatedEvent(selectedBocs, diagram, aadlModService, uiService, coloringService));
	}

	public void deactivateActiveTool() {
		if(activeTool != null) {
			deactivate(activeTool);
		}
	}

	public void deactivate(final Tool tool) {
		tool.deactivated(new DeactivatedEvent());
		activeTool = null;
		paletteBehavior.refreshPalette();
	}

	public void setSelectedElements(final ImmutableList<BusinessObjectContext> newSelectedBocs) {
		// Ignore the selection if nothing has changed
		if (Objects.equals(this.selectedBocs, newSelectedBocs)) {
			return;
		}

		this.selectedBocs = newSelectedBocs;

		if (selectedBocs.isEmpty()) {
			return;
		}

		// Notify the active tool
		if(activeTool != null) {
			activeTool.selectionChanged(new SelectionChangedEvent(selectedBocs));
		}
	}
}
