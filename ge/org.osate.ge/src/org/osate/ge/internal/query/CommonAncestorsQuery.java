package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.List;
import java.util.Objects;

class CommonAncestorsQuery extends DefaultQuery {
	private final DefaultQuery q1;
	private final DefaultQuery q2;
	
	public CommonAncestorsQuery(final DefaultQuery q1, final DefaultQuery q2) {
		super(null);
		this.q1 = Objects.requireNonNull(q1, "q1 must not be null");
		this.q2 = Objects.requireNonNull(q2, "q2 must not be null");
	}

	@Override
	void run(final Deque<DefaultQuery> remainingQueries, final Queryable ctx, final QueryExecutionState state, final QueryResult result) {
		final List<Queryable> q1Result = state.queryRunner.getResults(q1, state.arg);		
		final List<Queryable> q2Result = state.queryRunner.getResults(q2, state.arg);
		
		// Check sizes
		if(q1Result.size() == 0 || q2Result.size() == 0) {
			return;
		}
		
		if(q1Result.size() > 1) {
			throw new RuntimeException("q1 returns more than one element");
		}
		
		if(q2Result.size() > 1) {
			throw new RuntimeException("q2 returns more than one element");
		}
		
		final Queryable qc1 = q1Result.get(0).getParent();
		final Queryable qc2 = q2Result.get(0).getParent();

		// Get all common ancestors common ancestor
		Queryable temp1 = qc1;
		while(temp1 != null) {
			Queryable temp2 = qc2;
			while(temp2 != null) {
				if(temp1 == temp2) {
					processResultValue(remainingQueries, temp1, state, result);

					// Return all other ancestors
					while(!result.done) {
						temp1 = temp1.getParent();

						if(temp1 == null) {
							break;
						} else {							
							processResultValue(remainingQueries, temp1, state, result);
						}
					}
					return;
				}
				temp2 = temp2.getParent();
			}
			
			temp1 = temp1.getParent();
		}		
	}
}
