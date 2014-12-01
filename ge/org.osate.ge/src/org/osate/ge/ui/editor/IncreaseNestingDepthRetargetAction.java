package org.osate.ge.ui.editor;

import org.eclipse.ui.actions.LabelRetargetAction;

public class IncreaseNestingDepthRetargetAction extends LabelRetargetAction implements ComponentImplementationItem {
	public IncreaseNestingDepthRetargetAction() {
		super(IncreaseNestingDepthAction.ID, "Increase Nesting Depth");
		setHoverImageDescriptor(IncreaseNestingDepthAction.IMAGE_DESCRIPTOR);
	}
}
