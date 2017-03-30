package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.ge.di.GetDestination;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetSource;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.di.CreateParentQuery;
import org.osate.ge.internal.model.SubprogramCallOrder;
import org.osate.ge.query.Query;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class SubprogramCallOrderHandler {
	private static final Graphic graphic = ConnectionBuilder.create().destinationTerminator(ArrowBuilder.create().line().build()).build();
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children().filterByBusinessObject(sco->((SubprogramCallOrder)sco).previousSubprogramCall));
	private static StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children().filterByBusinessObject(sco->((SubprogramCallOrder)sco).subprogramCall));
	
	@IsApplicable	
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) SubprogramCallOrder bo) {
		return true;
	}
	
	@GetGraphic
	public Graphic getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT) SubprogramCallOrder bo) {
		return graphic;
	}
	
	@CreateParentQuery
	public Query createOwnerDiagramElementQuery(final @Named(Names.SOURCE_ROOT_QUERY) Query srcRootQuery) {
		return srcRootQuery.ancestor(1);
	}
	
	@GetSource
	public BusinessObjectContext getSource(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, 
			final QueryService queryService) {
		return queryService.getFirstResult(srcQuery, boc);
	}
	
	@GetDestination
	public BusinessObjectContext getDestination(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, 
			final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}
}
