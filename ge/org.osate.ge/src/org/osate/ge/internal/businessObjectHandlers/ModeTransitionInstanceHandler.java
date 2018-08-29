package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class ModeTransitionInstanceHandler {
	private static final Graphic graphic = ConnectionBuilder.create()
			.destinationTerminator(ArrowBuilder.create().small().build()).build();
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children()
			.filterByBusinessObjectRelativeReference((ModeTransitionInstance mt) -> mt.getSource()));
	private static StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children()
			.filterByBusinessObjectRelativeReference((ModeTransitionInstance mt) -> mt.getDestination()));

	private BusinessObjectContext getSource(final BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstResult(srcQuery, boc);
	}

	private BusinessObjectContext getDestination(final BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ModeTransitionInstance mti) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		return GraphicalConfigurationBuilder.create().graphic(graphic).source(getSource(boc, queryService))
				.destination(getDestination(boc, queryService))
				.style(StyleBuilder
						.create(AadlInheritanceUtil.isInherited(boc) ? Styles.INHERITED_ELEMENT : Style.EMPTY)
						.backgroundColor(Color.BLACK).build())
				.build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ModeTransitionInstance mti) {
		return mti.getName() == null ? "" : mti.getName();
	}
}
