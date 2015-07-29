package org.osate.ge.ui.editor;

import org.eclipse.ui.actions.LabelRetargetAction;

/**
 * Action to activate a tool provided by the tool service
 *
 */
public class ActivateToolRetargetAction extends LabelRetargetAction {
	public ActivateToolRetargetAction(final Object tool) {
		super(ToolUtil.getId(tool), ToolUtil.getDescription(tool));
		setHoverImageDescriptor(ToolUtil.getIcon(tool));
	}
}
