package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.internal.di.CreateParentQuery;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.query.Query;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class ConnectionReferenceHandler {
	private static final Graphic graphic = ConnectionBuilder.create().build();
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendants().filterByBusinessObjectCanonicalReference((ConnectionReference cr) -> cr.getSource()));
	private static StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendants().filterByBusinessObjectCanonicalReference((ConnectionReference cr) -> cr.getDestination()));
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ConnectionReference cr) {
		return true;
	}
		
	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, 
			final QueryService queryService) {
		return GraphicalConfigurationBuilder.create().
				graphic(graphic).
				source(getSource(boc, queryService)).
				destination(getDestination(boc, queryService)).
				build();
	}
	
	private BusinessObjectContext getSource(BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstResult(srcQuery, boc);
	}
	
	private BusinessObjectContext getDestination(BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}
	
	@CreateParentQuery
	public Query createParentQuery(final @Named(InternalNames.SOURCE_ROOT_QUERY) Query srcRootQuery, 
			final @Named(InternalNames.DESTINATION_ROOT_QUERY) Query dstRootQuery) {
		
		return srcRootQuery.ancestors().filterByBusinessObjectRelativeReference((ConnectionReference cr) -> cr.getContainingComponentInstance());
	}
}
