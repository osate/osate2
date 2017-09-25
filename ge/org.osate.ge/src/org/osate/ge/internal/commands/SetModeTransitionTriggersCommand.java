package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.GetBusinessObjectToModify;
import org.osate.ge.internal.ui.dialogs.ModeTransitionTriggerSelectionDialog;
import org.osate.ge.internal.ui.dialogs.ModeTransitionTriggerSelectionDialog.ModeTransitionTriggerInfo;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class SetModeTransitionTriggersCommand {
	private static final StandaloneQuery parentQuery = StandaloneQuery.create((root) -> root.ancestor(1));

	@GetLabel
	public String getLabel() {
		return "Set Mode Transition Triggers...";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final ModeTransition modeTransition,
			@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext boc,
			final QueryService queryService) {

		final Object parent = queryService.getFirstBusinessObject(parentQuery, boc);

		// Check that the container is the same shape that owns the mode transition
		return parent instanceof ComponentClassifier && modeTransition.getContainingClassifier() == parent;
	}

	@GetBusinessObjectToModify
	public Object getBusinessObjectToModify(@Named(Names.BUSINESS_OBJECT) final Object bo) {
		return bo;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final ModeTransition modeTransition) {
		final ComponentClassifier cc = (ComponentClassifier) modeTransition.getContainingClassifier();
		final ModeTransitionTriggerInfo[] selectedTriggers = ModeTransitionTriggerSelectionDialog.promptForTriggers(cc, modeTransition);
		if(selectedTriggers != null) {
			// Remove all trigger port triggers from the mode transition
			modeTransition.getOwnedTriggers().clear();

			// Add the selected ones to it
			for(ModeTransitionTriggerInfo selectedPort : selectedTriggers) {
				final ModeTransitionTrigger mtt = modeTransition.createOwnedTrigger();
				mtt.setTriggerPort(selectedPort.port);
				mtt.setContext(selectedPort.context);
			}
		}

		return true;
	}
}
