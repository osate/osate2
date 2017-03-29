package org.osate.ge.internal.query;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;

public class QueryRunner {
	private final PropertyService propertyService;
	private final BusinessObjectResolutionService bor;
	private final InternalReferenceBuilderService refBuilder;
	
	public QueryRunner(final PropertyService propertyService, final BusinessObjectResolutionService bor, final InternalReferenceBuilderService refBuilder) {
		this.propertyService = Objects.requireNonNull(propertyService, "propertyService must not be null");
		this.bor = Objects.requireNonNull(bor, "bor must not be null");
		this.refBuilder = Objects.requireNonNull(refBuilder, "refBuilder must not be null");
	}
	
	/**
	 * same as run() but returns the first result. Returns null if there are no results.
	 * @param query
	 * @param arg
	 * @return
	 */
	public final <A> Queryable getFirstResult(final Query<A> query, final A arg) {
		final List<Queryable> results = getResults(query, arg);
		if(results.size() == 0) {
			return null;
		}
		
		return results.get(0);
	}
	
	public final <A> List<Queryable> getResults(final Query<A> query, final A arg) {
		Objects.requireNonNull(query, "query must not be null");
		
		final Deque<Query<A>> queryStack = new ArrayDeque<>();
		for(Query<A> q = query; q != null; q = q.getPrev()) {
			queryStack.push(q);
		}

		final Query<A> initialQuery = queryStack.pop();
		final QueryExecutionState<A> state = new QueryExecutionState<>(this, propertyService, bor, refBuilder, arg);
		final QueryResult result = new QueryResult();
		initialQuery.run(queryStack, null, state, result);
		
		return result.result;
	}
}
