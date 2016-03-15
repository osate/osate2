package org.osate.ge.internal.ui.editor;

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.editor.DefaultPaletteBehavior;
import org.osate.ge.di.Activate;
import org.osate.ge.di.CanActivate;
import org.osate.ge.di.Deactivate;
import org.osate.ge.di.Names;
import org.osate.ge.di.SelectionChanged;
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
		// Update the context
		context.set(Names.SELECTED_PICTOGRAM_ELEMENTS, pes);
		// Notify the active tool
		if(activeTool != null) {
			ContextInjectionFactory.invoke(activeTool, SelectionChanged.class, context, null);
		}
	}
}
