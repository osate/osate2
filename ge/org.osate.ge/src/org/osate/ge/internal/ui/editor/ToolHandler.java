/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.editor;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.ui.editor.DefaultPaletteBehavior;
import org.osate.ge.di.Activate;
import org.osate.ge.internal.di.Deactivate;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.di.SelectionChanged;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.services.ExtensionService;

/**
 * Handles invoking tools and tracking the current tool.
 *
 */
public class ToolHandler {
	private final DefaultPaletteBehavior paletteBehavior;
	private final IEclipseContext context;
	private Object activeTool = null;
	private DiagramElement[] diagramElements = null;

	public ToolHandler(final ExtensionService extensionService,
			final DefaultPaletteBehavior paletteBehavior) {

		this.paletteBehavior = paletteBehavior;
		this.context = Objects.requireNonNull(extensionService, "extensionService must not be null")
				.createChildContext();
	}

	public void dispose() {
		this.context.dispose();
		diagramElements = null;
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


	public void setSelectedDiagramElements(final List<DiagramElement> diagramElements) {
		if (diagramElements.size() == 0) {
			return;
		}

		final DiagramElement[] newDiagramElements = diagramElements.toArray(new DiagramElement[diagramElements.size()]);

		// Ignore the selection if nothing has changed
		if (Arrays.equals(this.diagramElements, newDiagramElements)) {
			return;
		}

		this.diagramElements = newDiagramElements;

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
		if(diagramElements != null) {
			// Update the context
			if(diagramElements.length == 1) {
				context.set(InternalNames.SELECTED_DIAGRAM_ELEMENT, diagramElements[0]);
			}
			context.set(InternalNames.SELECTED_DIAGRAM_ELEMENTS, diagramElements);
		}
	}

	private void resetContext() {
		context.remove(InternalNames.SELECTED_DIAGRAM_ELEMENT);
		context.remove(InternalNames.SELECTED_DIAGRAM_ELEMENTS);
	}
}
