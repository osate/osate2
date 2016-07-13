/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.editor;

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.editor.DefaultPaletteBehavior;
import org.osate.ge.di.Activate;
import org.osate.ge.di.CanActivate;
import org.osate.ge.internal.di.Deactivate;
import org.osate.ge.internal.di.InternalNames;
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
	private ActivateToolAction activeToolAction = null; // Action that was used to activate the active tool
	
	public ToolHandler(final ExtensionService extensionService, final DefaultPaletteBehavior paletteBehavior) {
		this.paletteBehavior = paletteBehavior;
		this.context = Objects.requireNonNull(extensionService, "extensionService must not be null").createChildContext();
	}
	
	public void dispose() {
		this.context.dispose();
	}
	
	public boolean isToolActive() {
		return activeTool != null;
	}

	public boolean canActivate(final Object tool) {
		final Object result = ContextInjectionFactory.invoke(tool, CanActivate.class, context, Boolean.TRUE);
		if(!(result instanceof Boolean)) {
			throw new RuntimeException("CanActivate method must return a Boolean value");
		}
		
		return ((Boolean) result).booleanValue();
	}
	
	public void activate(final Object tool, final ActivateToolAction action) {
		// Deactivate the current tool
		if(activeTool != null) {
			deactivate(activeTool);
		}

		activeTool = tool;
		activeToolAction = action;
		
		paletteBehavior.refreshPalette();
		ContextInjectionFactory.invoke(tool, Activate.class, context);
	}
	
	public void deactivateActiveTool() {
		if(activeTool != null) {
			deactivate(activeTool);
		}
	}
	
	public void deactivate(final Object tool) {
		ContextInjectionFactory.invoke(tool, Deactivate.class, context);
		activeTool = null;
		paletteBehavior.refreshPalette();
		
		activeToolAction.update();
		activeToolAction = null;
	}
	
	public void setSelectedPictogramElements(final PictogramElement[] pes) {
		try {
			// Update the context
			context.set(InternalNames.SELECTED_PICTOGRAM_ELEMENTS, pes);
			// Notify the active tool
			if(activeTool != null) {
				ContextInjectionFactory.invoke(activeTool, SelectionChanged.class, context, null);
			}
		} finally {
			context.set(InternalNames.SELECTED_PICTOGRAM_ELEMENTS, null);
		}
	}
}
