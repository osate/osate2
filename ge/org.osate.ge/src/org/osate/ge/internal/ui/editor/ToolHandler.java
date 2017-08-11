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
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagramProvider;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
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
	private DiagramElement[] diagramElements = null;
	
	public ToolHandler(final GraphitiAgeDiagramProvider graphitiAgeDiagramProvider,
			final ExtensionService extensionService, 
			final DefaultPaletteBehavior paletteBehavior) {
		this.graphitiAgeDiagramProvider = Objects.requireNonNull(graphitiAgeDiagramProvider, "graphitiAgeDiagramProvider must not be null");
		this.paletteBehavior = paletteBehavior;
		this.context = Objects.requireNonNull(extensionService, "extensionService must not be null").createChildContext();
	}
	
	public void dispose() {
		this.context.dispose();
		diagramElements = null;
	}
	
	public boolean isToolActive() {
		return activeTool != null;
	}

	public boolean canActivate(final Object tool) {
		if(diagramElements == null) {
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
		this.diagramElements = getDiagramElements(graphitiAgeDiagramProvider.getGraphitiAgeDiagram(), pes);
		if(diagramElements == null) {
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
	
	/**
	 * Returns null if it is unable get the diagram element for any pictogram element
	 * @param pes
	 * @return
	 */
	private static DiagramElement[] getDiagramElements(final GraphitiAgeDiagram graphitiAgeDiagram, final PictogramElement[] pes) {
		final DiagramElement[] diagramElements = new DiagramElement[pes.length];
		for(int i = 0; i < pes.length; i++) {
			final DiagramNode dn = graphitiAgeDiagram.getClosestDiagramNode(pes[i]);
			// Return null if we are unable to get the diagram element for any passed in pictogram element
			if(!(dn instanceof DiagramElement)) {
				return null;
			}

			diagramElements[i] = (DiagramElement)dn;
		}

		return diagramElements;
	}
}
