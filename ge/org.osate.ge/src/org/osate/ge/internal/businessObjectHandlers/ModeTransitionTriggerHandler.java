package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

import com.google.common.base.Strings;

public class ModeTransitionTriggerHandler {
	private static final Graphic graphic = ConnectionBuilder.create().build();
	private static final Style style = StyleBuilder.create().backgroundColor(Color.BLACK).dashed()
			.primaryLabelVisible(false).build();

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
				style(style).
				source(getSource(boc)).
				destination(getDestination(boc, queryService)).
				build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ModeTransitionTrigger mtt) {
		final String portName = Strings
				.nullToEmpty(mtt.getTriggerPort() == null ? null : mtt.getTriggerPort().getName());
		if (Strings.isNullOrEmpty(portName)) {
			return null;
		}

		final String contextName = Strings.nullToEmpty(mtt.getContext() == null ? null : mtt.getContext().getName());
		return (contextName.length() == 0 ? "" : (contextName + ".")) + portName;
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
