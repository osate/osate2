package org.osate.ge.internal.query;

import java.util.Deque;

class AncestorsQuery extends DefaultQuery {
	public AncestorsQuery(final DefaultQuery prev) {
		super(prev);
	}
	
	@Override
	void run(final Deque<DefaultQuery> remainingQueries, final Queryable ctx, final QueryExecutionState state, final QueryResult result) {
		Queryable e = ctx;

		while(e != null && !result.done) {		
			e = e.getParent();
			if(e != null) {
				processResultValue(remainingQueries, e, state, result);
			}
		}
	}
}
