package org.osate.ge.internal.ui.editor;

import org.eclipse.ui.actions.LabelRetargetAction;

public class DistributeHorizontallyRetargetAction extends LabelRetargetAction{
	public DistributeHorizontallyRetargetAction(final String actionID) {
		super(actionID,"Distribute Shapes Horizontally");
		setId(actionID);
		setImageDescriptor(DistributeHorizontallyAction.horizontalImageDescriptor);
		setDisabledImageDescriptor(DistributeHorizontallyAction.horizontalDisabledImageDescriptor);
	}	
}