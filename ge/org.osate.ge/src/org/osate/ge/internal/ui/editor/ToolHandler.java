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

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.ui.editor.DefaultPaletteBehavior;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.Deactivate;
import org.osate.ge.internal.di.SelectionChanged;
import org.osate.ge.internal.services.ExtensionService;

/**
 * Handles invoking tools and tracking the current tool.
 *
 */
public class ToolHandler {
	private final DefaultPaletteBehavior paletteBehavior;
	private final IEclipseContext context;
	private Object activeTool = null;
	private BusinessObjectContext[] bocs = null;

	public ToolHandler(final ExtensionService extensionService,
			final DefaultPaletteBehavior paletteBehavior) {

		this.paletteBehavior = paletteBehavior;
		this.context = Objects.requireNonNull(extensionService, "extensionService must not be null")
				.createChildContext();
	}

	public void dispose() {
		this.context.dispose();
		bocs = null;
	}

	public boolean isToolActive() {
		return activeTool != null;
	}

	public void activate(final Object tool) {
		Objects.requireNonNull(tool, "tool must not be null");

		// Deactivate the current tool
		if (activeTool != null) {
			deactivateActiveTool();
		}

		activeTool = tool;
		paletteBehavior.refreshPalette();

		try {
			populateContext();
			ContextInjectionFactory.invoke(activeTool, Activate.class, context);
		} finally {
			resetContext();
		}
	}

	public void deactivateActiveTool() {
		if(activeTool != null) {
			deactivate(activeTool);
		}
	}

	public void deactivate(final Object tool) {
		try {
			populateContext();
			ContextInjectionFactory.invoke(tool, Deactivate.class, context);
		} finally {
			resetContext();
		}

		activeTool = null;
		paletteBehavior.refreshPalette();
	}

	public void setSelectedElements(final List<BusinessObjectContext> bocs) {
		final BusinessObjectContext[] newBocs = bocs.toArray(new BusinessObjectContext[bocs.size()]);

		// Ignore the selection if nothing has changed
		if (Arrays.equals(this.bocs, newBocs)) {
			return;
		}

		this.bocs = newBocs;

		if (bocs.isEmpty()) {
			return;
		}

		// Notify the active tool
		if(activeTool != null) {
			try {
				populateContext();
				ContextInjectionFactory.invoke(activeTool, SelectionChanged.class, context, null);
			}
			finally {
				resetContext();
			}
		}
	}

	private void populateContext() {
		if(bocs != null) {
			// Update the context
			if(bocs.length == 1) {
				context.set(Names.BUSINESS_OBJECT_CONTEXT, bocs[0]);
			}
			context.set(Names.BUSINESS_OBJECT_CONTEXTS, bocs);
		}
	}

	private void resetContext() {
		context.remove(Names.BUSINESS_OBJECT_CONTEXT);
		context.remove(Names.BUSINESS_OBJECT_CONTEXTS);
	}
}
