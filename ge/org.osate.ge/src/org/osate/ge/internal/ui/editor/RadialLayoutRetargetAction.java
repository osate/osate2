package org.osate.ge.internal.ui.editor;

import org.eclipse.ui.actions.LabelRetargetAction;

public class RadialLayoutRetargetAction extends LabelRetargetAction {
	public RadialLayoutRetargetAction(final String actionID) {
		super(actionID, "Radial Layout");
		setId(actionID);
		setImageDescriptor(RadialLayoutAction.radialImageDescriptor);
		setDisabledImageDescriptor(RadialLayoutAction.radialDisabledImageDescriptor);
	}	
}
