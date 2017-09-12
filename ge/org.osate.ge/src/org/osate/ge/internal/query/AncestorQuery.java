package org.osate.ge.internal.query;

import java.util.Deque;

class AncestorQuery extends DefaultQuery {
	private final int depth;
	
	public AncestorQuery(final DefaultQuery prev, final int depth) {
		super(prev);
		this.depth = depth;
		
		if(depth <= 0) {
			throw new RuntimeException("Invalid depth: " + depth);
		}
	}
	
	@Override
	void run(final Deque<DefaultQuery> remainingQueries, final Queryable ctx, final QueryExecutionState state, final QueryResult result) {
		Queryable e = ctx;
		for(int i = 0; i < depth && ctx != null; i++) {
			e = e.getParent();
		}
		
		// Process the value. If any
		if(e != null) {
			processResultValue(remainingQueries, e, state, result);
		}
	}
}
