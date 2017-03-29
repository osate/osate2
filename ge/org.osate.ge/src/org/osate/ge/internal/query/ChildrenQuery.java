package org.osate.ge.internal.query;

import java.util.Deque;

class ChildrenQuery<A> extends Query<A> {
	public ChildrenQuery(final Query<A> prev) {
		super(prev);
	}
	
	@Override
	void run(final Deque<Query<A>> remainingQueries, final Queryable ctx, final QueryExecutionState<A> state, final QueryResult result) {
		for(final Queryable child : ctx.getChildren()) {
			processResultValue(remainingQueries, child, state, result);
			
			if(result.done) {
				return;
			}
		}
	}
}
