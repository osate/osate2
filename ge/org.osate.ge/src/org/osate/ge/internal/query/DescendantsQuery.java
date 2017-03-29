package org.osate.ge.internal.query;

import java.util.Deque;

class DescendantsQuery<A> extends Query<A> {
	public DescendantsQuery(final Query<A> prev) {
		super(prev);
	}
	
	@Override
	void run(final Deque<Query<A>> remainingQueries, final Queryable ctx, final QueryExecutionState<A> state, final QueryResult result) {
		final Queryable container = ctx;
		for(final Queryable child : container.getChildren()) {
			processResultValue(remainingQueries, child, state, result);
			if(result.done) {
				return;
			}
			
			run(remainingQueries, child, state, result);			
			if(result.done) {
				return;
			}
		}
	}
}
