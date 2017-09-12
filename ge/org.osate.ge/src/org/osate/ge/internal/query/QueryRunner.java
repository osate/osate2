package org.osate.ge.internal.query;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import org.osate.ge.internal.services.ReferenceService;

public class QueryRunner {
	private final ReferenceService refBuilder;
	
	public QueryRunner(final ReferenceService refBuilder) {
		this.refBuilder = Objects.requireNonNull(refBuilder, "refBuilder must not be null");
	}
	
	/**
	 * same as run() but returns the first result. Returns null if there are no results.
	 * @param query
	 * @param arg
	 * @return
	 */
	public final Queryable getFirstResult(final DefaultQuery query, final Object arg) {
		final List<Queryable> results = getResults(query, arg);
		if(results.size() == 0) {
			return null;
		}
		
		return results.get(0);
	}
	
	public final List<Queryable> getResults(final DefaultQuery query, final Object arg) {
		Objects.requireNonNull(query, "query must not be null");
		
		final Deque<DefaultQuery> queryStack = new ArrayDeque<>();
		for(DefaultQuery q = query; q != null; q = q.getPrev()) {
			queryStack.push(q);
		}

		final DefaultQuery initialQuery = queryStack.pop();
		final QueryExecutionState state = new QueryExecutionState(this, refBuilder, arg);
		final QueryResult result = new QueryResult();
		initialQuery.run(queryStack, null, state, result);
		
		return result.result;
	}
}
