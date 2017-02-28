package org.osate.ge.internal.query;

import java.util.Deque;

public class FirstPictogramQuery<A> extends PictogramQuery<A> {
	private int maximumNumberOfResults;
	
	public FirstPictogramQuery(final Query<A> prev, int count) {
		super(prev);
		this.maximumNumberOfResults = count;
	}
	
	public FirstPictogramQuery(final Query<A> prev) {
		super(prev);
		this.maximumNumberOfResults = 1;
	}
	
	public int getMaximumNumberOfResults() {
		return maximumNumberOfResults;
	}
	
	@Override
	void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryExecutionState<A> state, final QueryResult result) {
		final Integer currentCountInteger = (Integer)state.cache.get(this);
		int currentCount;
		if(currentCountInteger == null) {
			currentCount = 1;
			state.cache.put(this, currentCount);
		} else {
			currentCount = ((int)currentCountInteger) + 1;
			state.cache.put(this, currentCount);
		}
		
		if(maximumNumberOfResults >= currentCount) {
			processResultValue(remainingQueries, ctx, state, result);
		}
		
		if(maximumNumberOfResults <= currentCount) {
			// Mark query as done. 
			result.done = true;
		}
	}
}
