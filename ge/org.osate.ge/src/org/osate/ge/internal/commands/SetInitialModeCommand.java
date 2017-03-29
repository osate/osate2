package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.DiagramElement;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.di.ModifiesBusinessObjects;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.QueryService;

@ModifiesBusinessObjects
public class SetInitialModeCommand {
	private static final StandaloneDiagramElementQuery parentQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestor(1));
	final boolean isInitial;

	public SetInitialModeCommand(boolean isInitial) {
		this.isInitial = isInitial;
	}

	@GetLabel
	public String getLabel() {
		return isInitial ? "Change to Initial Mode" : "Change to Non-initial Mode";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final Mode mode,
			@Named(InternalNames.DIAGRAM_ELEMENT) final DiagramElement diagramElement,
			final QueryService queryService) {
		final Object diagram = queryService.getFirstBusinessObject(parentQuery, diagramElement);
		return diagram instanceof ComponentClassifier && mode.getContainingClassifier() == diagram && mode.isInitial() != isInitial;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final Mode mode) {
		// Reset the current initial mode. Only look in the current classifier and not in classifiers that have been extended
		if(isInitial) {
			final ComponentClassifier cc = (ComponentClassifier)mode.getContainingClassifier();
			for(final Mode m : cc.getOwnedModes()) {
				if(m.isInitial()) {
					m.setInitial(false);
				}
			}
		}

		mode.setInitial(isInitial);			

		return true;
	}
}
