package org.osate.ge.internal.businessObjectHandlers;

import java.awt.Color;

import javax.inject.Named;

import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class ModeTransitionTriggerHandler {
	private static final Graphic graphic = ConnectionBuilder.create().dashed().build();

	// If context is null look for the port under the trigger's ancestor. if context is not null use ancestor(1).children().filterByBo(context);
	private static StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.ancestor(2).ifElse((ca) -> ((ModeTransitionTrigger)ca.getQueryArgument()).getContext() == null,
			(innerRoot) -> innerRoot,
			(innerRoot) -> innerRoot.children().filterByBusinessObjectRelativeReference((ModeTransitionTrigger mtt) -> mtt.getContext()).first()).
			children().filterByBusinessObjectRelativeReference((ModeTransitionTrigger mtt) -> mtt.getTriggerPort()));

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ModeTransitionTrigger mtt) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final QueryService queryService) {
		return GraphicalConfigurationBuilder.create().
				graphic(graphic).
				source(getSource(boc)).
				destination(getDestination(boc, queryService)).
				defaultBackgroundColor(Color.BLACK).
				build();
	}

	// Source - the mode transition
	private BusinessObjectContext getSource(final BusinessObjectContext boc) {
		return boc.getParent();
	}

	// Destination - trigger feature
	private BusinessObjectContext getDestination(final BusinessObjectContext boc,
			final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}
}
