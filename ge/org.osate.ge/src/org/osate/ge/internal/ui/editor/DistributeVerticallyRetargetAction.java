package org.osate.ge.internal.ui.editor;

import org.eclipse.ui.actions.LabelRetargetAction;

public class DistributeVerticallyRetargetAction extends LabelRetargetAction{
	public DistributeVerticallyRetargetAction(final String actionID) {
		super(actionID,"Distribute Shapes Vertically");
		setId(actionID);
		setImageDescriptor(DistributeVerticallyAction.verticalImageDescriptor);
		setDisabledImageDescriptor(DistributeVerticallyAction.verticalDisabledImageDescriptor);
	}	
}