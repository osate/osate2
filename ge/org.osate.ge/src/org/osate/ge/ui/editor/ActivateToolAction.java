package org.osate.ge.ui.editor;

import org.eclipse.gef.ui.actions.SelectionAction;
import org.osate.ge.ext.ExtensionUtil;

/**
 * Action to activate a tool provided by the tool service
 *
 */
public class ActivateToolAction extends SelectionAction {
	private final ToolHandler toolHandler;
	private final Object tool;
	public ActivateToolAction(final AgeDiagramEditor editor, final ToolHandler toolHandler, final Object tool) {
		super(editor);
		setId(ExtensionUtil.getId(tool));
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
		toolHandler.activate(tool);
	}
	
	public ToolHandler getToolHandler() {
		return toolHandler;
	}
	
}
