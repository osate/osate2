package org.osate.ge.ui.editor;

import org.eclipse.ui.actions.LabelRetargetAction;

public class SetBindingRetargetAction extends LabelRetargetAction implements ComponentImplementationItem {
	public SetBindingRetargetAction() {
		super(SetBindingAction.ID, SetBindingAction.TEXT);
		setHoverImageDescriptor(SetBindingAction.IMAGE_DESCRIPTOR);
	}
}
