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
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.CanActivate;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.Deactivate;
import org.osate.ge.internal.di.SelectionChanged;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.graphiti.PictogramElementUtil;
import org.osate.ge.internal.services.ExtensionService;

/**
 * Handles invoking tools and tracking the current tool.
 *
 */
public class ToolHandler {
	private final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider;
	private final DefaultPaletteBehavior paletteBehavior;
	private final IEclipseContext context;
	private Object activeTool = null;
	private ActivateToolAction activeToolAction = null; // Action that was used to activate the active tool
	private BusinessObjectContext[] bocs = null;
	
	public ToolHandler(final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider,
			final ExtensionService extensionService, 
			final DefaultPaletteBehavior paletteBehavior) {
		this.graphitiAgeDiagramProvider = Objects.requireNonNull(graphitiAgeDiagramProvider, "graphitiAgeDiagramProvider must not be null");
		this.paletteBehavior = paletteBehavior;
		this.context = Objects.requireNonNull(extensionService, "extensionService must not be null").createChildContext();
	}
	
	public void dispose() {
		this.context.dispose();
		bocs = null;
	}
	
	public boolean isToolActive() {
		return activeTool != null;
	}

	public boolean canActivate(final Object tool) {
		if(bocs == null) {
			return false;
		}
		
		try {
			populateContext();			
			final Object result = ContextInjectionFactory.invoke(tool, CanActivate.class, context, Boolean.FALSE);
			if(!(result instanceof Boolean)) {
				throw new RuntimeException("CanActivate method must return a Boolean value");
			}
			return ((Boolean) result).booleanValue();
		} finally {
			resetContext();
		}
	}
		
	public void activate(final Object tool, final ActivateToolAction action) {
		// Deactivate the current tool
		if(activeTool != null) {
			deactivate(activeTool);
		}

		activeTool = tool;
		activeToolAction = action;
		
		paletteBehavior.refreshPalette();
		
		try {
			populateContext();	
			ContextInjectionFactory.invoke(tool, Activate.class, context);
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
		
		activeToolAction.update();
		activeToolAction = null;
	}
	
	
	public void setSelectedPictogramElements(final PictogramElement[] pes) {
		this.bocs = PictogramElementUtil.getBusinessObjectContexts(graphitiAgeDiagramProvider.getGraphitiAgeDiagram(), pes);
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
		// Update the context
		if(bocs.length == 1) {
			context.set(Names.BUSINESS_OBJECT_CONTEXT, bocs[0]);	
		}			
		context.set(Names.BUSINESS_OBJECT_CONTEXTS, bocs);
	}
	
	private void resetContext() {
		context.remove(Names.BUSINESS_OBJECT_CONTEXT);
		context.remove(Names.BUSINESS_OBJECT_CONTEXTS);
	}
}
