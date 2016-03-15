package org.osate.ge.internal.ui.editor;

import org.eclipse.ui.actions.LabelRetargetAction;

public class IncreaseNestingDepthRetargetAction extends LabelRetargetAction {
	public IncreaseNestingDepthRetargetAction() {
		super(IncreaseNestingDepthAction.ID, "Increase Nesting Depth");
		setHoverImageDescriptor(IncreaseNestingDepthAction.IMAGE_DESCRIPTOR);
	}
}
