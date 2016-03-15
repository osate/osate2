package org.osate.ge.internal.ui.editor;

import org.eclipse.ui.actions.RetargetAction;

public class DecreaseNestingDepthRetargetAction extends RetargetAction {
	public DecreaseNestingDepthRetargetAction() {
		super(DecreaseNestingDepthAction.ID, "Decrease Nesting Depth");
		setHoverImageDescriptor(DecreaseNestingDepthAction.IMAGE_DESCRIPTOR);
	}
}
