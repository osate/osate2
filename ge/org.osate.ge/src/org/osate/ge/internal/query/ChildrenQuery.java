package org.osate.ge.internal.query;

import java.util.Deque;

class ChildrenQuery extends DefaultQuery {
	public ChildrenQuery(final DefaultQuery prev) {
		super(prev);
	}
	
	@Override
	void run(final Deque<DefaultQuery> remainingQueries, final Queryable ctx, final QueryExecutionState state, final QueryResult result) {
		for(final Queryable child : ctx.getChildren()) {
			processResultValue(remainingQueries, child, state, result);
			
			if(result.done) {
				return;
			}
		}
	}
}
