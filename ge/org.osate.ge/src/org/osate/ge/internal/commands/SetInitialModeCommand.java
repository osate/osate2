package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.GetBusinessObjectToModify;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class SetInitialModeCommand {
	private static final StandaloneQuery parentQuery = StandaloneQuery.create((root) -> root.ancestor(1));
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
			@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext boc,
			final QueryService queryService) {
		final Object parent = queryService.getFirstBusinessObject(parentQuery, boc);
		return parent instanceof ComponentClassifier && mode.getContainingClassifier() == parent && mode.isInitial() != isInitial;
	}

	@GetBusinessObjectToModify
	public Object getBusinessObjectToModify(@Named(Names.BUSINESS_OBJECT) final Mode mode) {
		return mode.getContainingClassifier();
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
