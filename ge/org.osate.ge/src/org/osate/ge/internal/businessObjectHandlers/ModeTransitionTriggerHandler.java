package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.ge.di.GetDestination;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetSource;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.di.CreateParentQuery;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.query.Query;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class ModeTransitionTriggerHandler {
	private static final Graphic graphic = ConnectionBuilder.create().dashed().build();
	
	// If context is null look for the port under the trigger's ancestor. if context is not null use ancestor(1).children().filterByBo(context);
	private static StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.ancestor(1).ifElse((ca) -> ((ModeTransitionTrigger)ca.getQueryArgument()).getContext() == null, 
			(innerRoot) -> innerRoot, 
			(innerRoot) -> innerRoot.children().filterByBusinessObjectRelativeReference((ModeTransitionTrigger mtt) -> mtt.getContext()).first()).
				children().filterByBusinessObjectRelativeReference((ModeTransitionTrigger mtt) -> mtt.getTriggerPort()));
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ModeTransitionTrigger mtt) {
		return true;
	}
	
	@GetGraphic
	public Graphic getGraphicalRepresentation() {
		return graphic;
	}
	
	// Source - the mode transition
	@GetSource
	public BusinessObjectContext getSource(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc) {
		return boc.getParent();
	}
	
	// Destination - trigger feature
	@GetDestination
	public BusinessObjectContext getDestination(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, 
			final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}
	
	@CreateParentQuery
	public Query createParentQuery(final @Named(InternalNames.DESTINATION_ROOT_QUERY) Query dstRootQuery) {
		return dstRootQuery.ifElse((ca) -> ((ModeTransitionTrigger)ca.getQueryArgument()).getContext() == null, 
				(innerRoot) -> innerRoot.ancestor(1), 
				(innerRoot) -> innerRoot.ancestor(2)).
					children().filterByBusinessObjectRelativeReference((ModeTransitionTrigger mtt) -> mtt.eContainer()).first();
	}
}
