package org.osate.ge.internal.query;

import java.util.Deque;

// TODO: Rename?
public class Query<A> {
	private Query<A> prev;
	
	public Query(final Query<A> prev) {
		this.prev = prev;
	}
	
	// TODO: Remove?
	final Query<A> getPrev() {
		return prev;
	}
	
	// TODO: Make abstract..
	void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryArguments<A> args, final QueryResult result) {
		System.err.println("run() - not implemented for: " + getClass().getName());
	}
	
	// TODO: Need flag to set done flag and quit? or is that manual?
	// TODO: Rename
	protected void processResultValue(final Deque<Query<A>> remainingQueries, final Object value, final QueryArguments<A> args, final QueryResult result) {
		if(remainingQueries.size() == 0) {
			result.result.add(value);
			return;
		}
		
		final Query<A> nextQuery = remainingQueries.pop();
		nextQuery.run(remainingQueries, value, args, result);
		remainingQueries.push(nextQuery);
	}
}
