package org.osate.ge.internal.ui.editor;

import org.eclipse.gef.ui.actions.SelectionAction;
import org.osate.ge.internal.util.ExtensionUtil;

/**
 * Action to activate a tool provided by the tool service
 *
 */
public class ActivateToolAction extends SelectionAction {
	private final ToolHandler toolHandler;
	private final Object tool;
	public ActivateToolAction(final AgeDiagramEditor editor, final ToolHandler toolHandler, final Object tool) {
		super(editor);
		setId(getActionId(ExtensionUtil.getId(tool)));
		setText(ExtensionUtil.getDescription(tool));
		setHoverImageDescriptor(ExtensionUtil.getIcon(tool));
		this.toolHandler = toolHandler;
		this.tool = tool;
	}

	@Override
	protected boolean calculateEnabled() {
		return toolHandler.canActivate(tool);
	}
	
	@Override
	public void run() {
		toolHandler.activate(tool, this);
	}
	
	public ToolHandler getToolHandler() {
		return toolHandler;
	}
	
	
	public static String getActionId(final String toolId) {
		return toolId; 	// Action IDs match tool IDs
	}
}
