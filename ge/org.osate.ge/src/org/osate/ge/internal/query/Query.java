package org.osate.ge.internal.query;

import java.util.Deque;

/**
 * Base class for queries. Queries should be written in such a way to not contain any mutable state. 
 */
public abstract class Query<A> {
	private Query<A> prev;
	
	public Query(final Query<A> prev) {
		this.prev = prev;
	}
	
	final Query<A> getPrev() {
		return prev;
	}
	
	abstract void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryExecutionState<A> state, final QueryResult result);
	
	protected void processResultValue(final Deque<Query<A>> remainingQueries, final Object value, final QueryExecutionState<A> state, final QueryResult result) {
		if(remainingQueries.size() == 0) {
			result.result.add(value);
			return;
		}
		
		final Query<A> nextQuery = remainingQueries.pop();
		nextQuery.run(remainingQueries, value, state, result);
		remainingQueries.push(nextQuery);
	}
}
