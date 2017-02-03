package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.ge.di.CreateDestinationQuery;
import org.osate.ge.di.CreateParentQuery;
import org.osate.ge.di.CreateSourceQuery;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.query.PictogramQuery;
import org.osate.ge.query.DiagramElementQuery;

public class ModeTransitionTriggerHandler {
	private static final Graphic graphic = ConnectionBuilder.create().dashed().build();
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ModeTransitionTrigger mtt) {
		return true;
	}
	
	@GetGraphic
	public Graphic getGraphicalRepresentation() {
		return graphic;
	}
	
	// Source - the mode transition
	@CreateSourceQuery
	public DiagramElementQuery<ModeTransitionTrigger> createSourceQuery(final @Named(Names.ROOT_QUERY) DiagramElementQuery<ModeTransitionTrigger> rootQuery) {
		return rootQuery;
	}	
			
	// Destination - trigger feature
	@CreateDestinationQuery
	public DiagramElementQuery<ModeTransitionTrigger> createDestination(final @Named(Names.ROOT_QUERY) PictogramQuery<ModeTransitionTrigger> rootQuery) {
		// If context is null look for the port under the trigger's ancestor. if context is not null use ancestor(1).children().filterByBo(context);
		return rootQuery.ancestor(1).ifElse((ca) -> ca.getQueryArgument().getContext() == null, 
				(innerRoot) -> innerRoot, 
				(innerRoot) -> innerRoot.children().filterByBusinessObject((mtt) -> mtt.getContext()).first()).
					children().filterByBusinessObject((mtt) -> mtt.getTriggerPort());
	}
	
	@CreateParentQuery
	public DiagramElementQuery<ModeTransitionTrigger> createParentDiagramElementQuery(final @Named(Names.DESTINATION_ROOT_QUERY) PictogramQuery<ModeTransitionTrigger> dstRootQuery) {
		return dstRootQuery.ifElse((ca) -> ca.getQueryArgument().getContext() == null, 
				(innerRoot) -> innerRoot.ancestor(1), 
				(innerRoot) -> innerRoot.ancestor(2)).
					children().filterByBusinessObject((mtt) -> mtt.eContainer()).first();
	}
}
