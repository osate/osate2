package org.osate.ge.internal.query;

import java.util.Deque;

import org.osate.ge.internal.diagram.DiagramNode;

public class FirstQuery<A> extends DiagramNodeQuery<A> {
	private int maximumNumberOfResults;
	
	public FirstQuery(final DiagramNodeQuery<A> prev, int count) {
		super(prev);
		this.maximumNumberOfResults = count;
	}
	
	public FirstQuery(final DiagramNodeQuery<A> prev) {
		super(prev);
		this.maximumNumberOfResults = 1;
	}
	
	public int getMaximumNumberOfResults() {
		return maximumNumberOfResults;
	}
	
	@Override
	void run(final Deque<DiagramNodeQuery<A>> remainingQueries, final DiagramNode ctx, final QueryExecutionState<A> state, final QueryResult result) {
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
