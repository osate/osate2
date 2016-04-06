package org.osate.ge.internal.query;

import java.util.Deque;

public class FirstPictogramQuery<A> extends PictogramQuery<A> {
	public FirstPictogramQuery(final Query<A> prev) {
		super(prev);
	}
	
	@Override
	void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryArguments<A> args, final QueryResult result) {
		processResultValue(remainingQueries, ctx, args, result);
		
		// Mark query as done. 
		result.done = true;
	}
}
