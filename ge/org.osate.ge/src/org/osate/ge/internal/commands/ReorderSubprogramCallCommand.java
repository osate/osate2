package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.di.Activate;
import org.osate.ge.di.CanActivate;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.DiagramElement;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.di.ModifiesBusinessObjects;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.services.SubcomponentService;

@ModifiesBusinessObjects
public abstract class ReorderSubprogramCallCommand {
	private static final StandaloneDiagramElementQuery parentQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestor(1));
	private static final StandaloneDiagramElementQuery grandparentQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestor(2));

	/**
	 * Returns the new index for a subprogram call on which this feature is executed 
	 */
	abstract protected int getNewIndex(final SubprogramCall call);

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final SubprogramCall subprogramCall,
			@Named(InternalNames.DIAGRAM_ELEMENT_PROXY) final DiagramElement diagramElement,
			final QueryService queryService,
			final SubcomponentService subcomponentService) {
		final Object diagram = queryService.getFirstBusinessObject(parentQuery, diagramElement);
		return diagram instanceof SubprogramCallSequence && subprogramCall.eContainer() instanceof SubprogramCallSequence &&
				subprogramCall.getContainingClassifier() == queryService.getFirstBusinessObject(grandparentQuery, diagramElement);
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
