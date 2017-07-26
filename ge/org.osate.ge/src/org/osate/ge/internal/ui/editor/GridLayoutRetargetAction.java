package org.osate.ge.internal.ui.editor;

import org.eclipse.ui.actions.LabelRetargetAction;

public class GridLayoutRetargetAction extends LabelRetargetAction {
	public GridLayoutRetargetAction(final String actionID) {
		super(actionID, "Grid Layout");
		setId(actionID);
		setImageDescriptor(GridLayoutAction.gridLayoutImageDescriptor);
		setDisabledImageDescriptor(GridLayoutAction.gridLayoutDisabledImageDescriptor);
	}	
}
