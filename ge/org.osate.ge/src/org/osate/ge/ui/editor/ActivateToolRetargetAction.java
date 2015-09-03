package org.osate.ge.ui.editor;

import org.eclipse.ui.actions.LabelRetargetAction;
import org.osate.ge.ext.ExtensionUtil;

/**
 * Action to activate a tool provided by the tool service
 *
 */
public class ActivateToolRetargetAction extends LabelRetargetAction {
	public ActivateToolRetargetAction(final Object tool) {
		super(ExtensionUtil.getId(tool), ExtensionUtil.getDescription(tool));
		setHoverImageDescriptor(ExtensionUtil.getIcon(tool));
	}
}
