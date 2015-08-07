package org.osate.ge.ui.editor;

import org.eclipse.gef.ui.actions.SelectionAction;

/**
 * Action to activate a tool provided by the tool service
 *
 */
public class ActivateToolAction extends SelectionAction {
	private final ToolHandler toolHandler;
	private final Object tool;
	public ActivateToolAction(final AgeDiagramEditor editor, final ToolHandler toolHandler, final Object tool) {
		super(editor);
		setId(ToolUtil.getId(tool));
		setText(ToolUtil.getDescription(tool));
		setHoverImageDescriptor(ToolUtil.getIcon(tool));
		this.toolHandler = toolHandler;
		this.tool = tool;
	}

	@Override
	protected boolean calculateEnabled() {
		return toolHandler.canActivate(tool);
	}
	
	@Override
	public void run() {
		toolHandler.activate(tool);
	}
	
	public ToolHandler getToolHandler() {
		return toolHandler;
	}
	
}
