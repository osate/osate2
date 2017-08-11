package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.di.Activate;
import org.osate.ge.di.CanActivate;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public abstract class ReorderSubprogramCallCommand {
	private static final StandaloneQuery parentQuery = StandaloneQuery.create((root) -> root.ancestor(1));
	private static final StandaloneQuery grandparentQuery = StandaloneQuery.create((root) -> root.ancestor(2));

	/**
	 * Returns the new index for a subprogram call on which this feature is executed 
	 */
	abstract protected int getNewIndex(final SubprogramCall call);

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final SubprogramCall subprogramCall,
			@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext boc,
			final QueryService queryService) {
		final Object parent = queryService.getFirstBusinessObject(parentQuery, boc);
		return parent instanceof SubprogramCallSequence && subprogramCall.eContainer() instanceof SubprogramCallSequence &&
				subprogramCall.getContainingClassifier() == queryService.getFirstBusinessObject(grandparentQuery, boc);
	}

	@CanActivate
	public boolean canActivate(@Named(Names.BUSINESS_OBJECT) final SubprogramCall subprogramCall) {
		final SubprogramCallSequence cs = (SubprogramCallSequence)subprogramCall.eContainer();
		final int currentIndex = cs.getOwnedSubprogramCalls().indexOf(subprogramCall);
		final int newIndex = getNewIndex(subprogramCall);
		return currentIndex != -1 && currentIndex != newIndex && newIndex >= 0 && newIndex < cs.getOwnedSubprogramCalls().size();
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final SubprogramCall subprogramCall) {
		final SubprogramCallSequence cs = (SubprogramCallSequence)subprogramCall.eContainer();
		cs.getOwnedSubprogramCalls().move(getNewIndex(subprogramCall), subprogramCall);
		return true;
	}
}
