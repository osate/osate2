package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.DiagramElement;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.di.ModifiesBusinessObjects;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.ui.dialogs.ModeTransitionTriggerSelectionDialog;
import org.osate.ge.internal.ui.dialogs.ModeTransitionTriggerSelectionDialog.ModeTransitionTriggerInfo;

@ModifiesBusinessObjects
public class SetModeTransitionTriggersCommand {
	private static final StandaloneDiagramElementQuery parentQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestor(1));

	@GetLabel
	public String getLabel() {
		return "Set Mode Transition Triggers...";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final ModeTransition modeTransition,
			@Named(InternalNames.DIAGRAM_ELEMENT) final DiagramElement diagramElement,
			final QueryService queryService) {

		final Object diagram = queryService.getFirstBusinessObject(parentQuery, diagramElement);

		// Check that the container is the same shape that owns the mode transition
		return diagram instanceof ComponentClassifier && modeTransition.getContainingClassifier() == diagram;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final ModeTransition modeTransition,
			@Named(InternalNames.DIAGRAM_ELEMENT) final DiagramElement diagramElement,
			final QueryService queryService) {
		final ComponentClassifier cc = (ComponentClassifier)queryService.getFirstBusinessObject(parentQuery, diagramElement);

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
