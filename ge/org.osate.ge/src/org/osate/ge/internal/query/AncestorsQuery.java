package org.osate.ge.internal.query;

import java.util.Deque;

class AncestorsQuery<A> extends Query<A> {
	public AncestorsQuery(final Query<A> prev) {
		super(prev);
	}
	
	@Override
	void run(final Deque<Query<A>> remainingQueries, final Queryable ctx, final QueryExecutionState<A> state, final QueryResult result) {
		Queryable e = ctx;

		while(e != null && !result.done) {		
			e = e.getParent();
			if(e != null) {
				processResultValue(remainingQueries, e, state, result);
			}
		}
	}
}
