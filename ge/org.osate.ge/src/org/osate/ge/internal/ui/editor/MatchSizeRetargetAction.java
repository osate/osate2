package org.osate.ge.internal.ui.editor;

import org.eclipse.ui.actions.LabelRetargetAction;

public class MatchSizeRetargetAction extends LabelRetargetAction{
	public MatchSizeRetargetAction(final String actionID) {
		super(actionID,"Match Height and Width of Selected Objects to the Primary Selection");
		setId(actionID);
		setImageDescriptor(MatchSizeAction.matchSizeImageDescriptor);
		setDisabledImageDescriptor(MatchSizeAction.matchSizeDisabledImageDescriptor);
	}	
}