package org.osate.ge.services.impl;

import java.util.List;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.query.QueryRunner;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.query.DefaultStandaloneQuery;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class DefaultQueryService implements QueryService {
	private final QueryRunner queryRunner;
	
	public DefaultQueryService(final ReferenceService refBuilder) {
		this.queryRunner = new QueryRunner(refBuilder);
	}
	
	@Override
	public final BusinessObjectContext getFirstResult(StandaloneQuery query, BusinessObjectContext boc, final Object arg) {
		return (BusinessObjectContext)((DefaultStandaloneQuery)query).getFirstResult(queryRunner, boc, arg);
	}
	
	@Override
	public final Object getFirstBusinessObject(final StandaloneQuery query, final BusinessObjectContext boc, final Object arg) {
		final Queryable result = ((DefaultStandaloneQuery)query).getFirstResult(queryRunner, boc, arg);
		return result == null ? null : result.getBusinessObject();
	}
	
	@SuppressWarnings("unchecked")
	public final List<BusinessObjectContext> getResults(final StandaloneQuery query, final BusinessObjectContext boc, final Object arg) {
		return (List<BusinessObjectContext>)((DefaultStandaloneQuery)query).getResults(queryRunner, boc, arg);
	}
}
