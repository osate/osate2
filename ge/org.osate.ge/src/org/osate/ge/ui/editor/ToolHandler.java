package org.osate.ge.ui.editor;

import java.util.Objects;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.ui.tools.ToolConstants;
import org.osate.ge.ui.tools.annotations.Activate;
import org.osate.ge.ui.tools.annotations.CanActivate;
import org.osate.ge.ui.tools.annotations.Deactivate;
import org.osate.ge.ui.tools.annotations.SelectedFlow;
import org.osate.ge.ui.tools.annotations.SelectionChanged;

/**
 * Handles invoking tools and tracking the current tool.
 * @author philip.alldredge
 *
 */
public class ToolHandler {
	private final IEclipseContext context;
	private Object activeTool = null;
	
	public ToolHandler(final IEclipseContext context) {
		this.context = Objects.requireNonNull(context, "context must not be null").createChild();
	}

	public boolean canActivate(final Object tool) {
		final Object result = ContextInjectionFactory.invoke(tool, CanActivate.class, context, Boolean.TRUE);
		if(!(result instanceof Boolean)) {
			throw new RuntimeException("CanActivate method must return a Boolean value");
		}
		
		return ((Boolean) result).booleanValue();
	}
	
	public void activate(final Object tool) {
		// Deactivate the current tool
		if(activeTool != null) {
			deactivate(activeTool);
		}

		activeTool = tool;
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
	}
	
	public void setSelectedPictogramElements(final PictogramElement[] pes, final Object object) {
		// Update the context
		context.set(ToolConstants.SELECTED_PICTOGRAM_ELEMENTS, pes);
		context.set(ToolConstants.SELECTED_FLOW, object);
		// Notify the active tool
		if(activeTool != null) {
			ContextInjectionFactory.invoke(activeTool, SelectionChanged.class, context);
			ContextInjectionFactory.invoke(activeTool, SelectionChanged.class, context);
		}
	}
}
