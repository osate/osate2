package org.osate.ge.internal.services.impl;

import java.util.List;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.query.QueryRunner;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.query.DefaultStandaloneQuery;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class DefaultQueryService implements QueryService {
	private final QueryRunner queryRunner;
	
	public DefaultQueryService(final PropertyService propertyService, final BusinessObjectResolutionService bor, final InternalReferenceBuilderService refBuilder) {
		this.queryRunner = new QueryRunner(propertyService, bor, refBuilder);
	}
	
	@Override
	public BusinessObjectContext getFirstResult(StandaloneQuery query, BusinessObjectContext boc) {
		return (BusinessObjectContext)((DefaultStandaloneQuery)query).getFirstResult(queryRunner, boc);
	}
	
	@Override
	public Object getFirstBusinessObject(final StandaloneQuery query, final BusinessObjectContext boc) {
		final Queryable result = ((DefaultStandaloneQuery)query).getFirstResult(queryRunner, boc);
		return result == null ? null : result.getBusinessObject();
	}
	
	@SuppressWarnings("unchecked")
	public List<BusinessObjectContext> getResults(final StandaloneQuery query, final BusinessObjectContext boc) {
		return (List<BusinessObjectContext>)((DefaultStandaloneQuery)query).getResults(queryRunner, boc);
	}
}
