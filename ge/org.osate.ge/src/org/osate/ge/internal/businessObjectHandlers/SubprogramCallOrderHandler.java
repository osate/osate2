package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.eclipse.xtext.util.Strings;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetNameForUserInterface;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.model.SubprogramCallOrder;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class SubprogramCallOrderHandler {
	private static final Graphic graphic = ConnectionBuilder.create().destinationTerminator(ArrowBuilder.create().line().build()).build();
	private static final Style style = StyleBuilder.create().backgroundColor(Color.BLACK).build();
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children().filterByBusinessObjectRelativeReference(sco->((SubprogramCallOrder)sco).previousSubprogramCall));
	private static StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children().filterByBusinessObjectRelativeReference(sco->((SubprogramCallOrder)sco).subprogramCall));

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) SubprogramCallOrder bo) {
		return true;
	}

	@GetNameForUserInterface
	public String getNameForUi(final @Named(Names.BUSINESS_OBJECT) SubprogramCallOrder bo) {
		return "Subprogram Call Order " + Strings.emptyIfNull(bo.previousSubprogramCall.getName()) + " -> "
				+ Strings.emptyIfNull(bo.subprogramCall.getName());
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT) SubprogramCallOrder bo,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final QueryService queryService) {
		return GraphicalConfigurationBuilder.create().
				graphic(getGraphicalRepresentation(bo)).
				style(style).
				source(getSource(boc, queryService)).
				destination(getDestination(boc, queryService)).
				build();
	}

	private Graphic getGraphicalRepresentation(final SubprogramCallOrder bo) {
		return graphic;
	}

	private BusinessObjectContext getSource(final BusinessObjectContext boc,
			final QueryService queryService) {
		return queryService.getFirstResult(srcQuery, boc);
	}

	private BusinessObjectContext getDestination(final BusinessObjectContext boc,
			final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}
}
