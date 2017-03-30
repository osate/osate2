package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.Objects;
import java.util.function.Predicate;
import org.osate.ge.query.FilterArguments;

class FilterByPredicate extends DefaultQuery {
	private final Predicate<FilterArguments> filter;
	
	public FilterByPredicate(final DefaultQuery prev, final Predicate<FilterArguments> filter) {
		super(prev);
		this.filter = Objects.requireNonNull(filter, "filter must not be null");
	}
	
	@Override
	void run(final Deque<DefaultQuery> remainingQueries, final Queryable ctx, final QueryExecutionState state, final QueryResult result) {
		// Set filter arguments
		ExpressionArguments filterArgs = (ExpressionArguments)state.cache.get(this);
		if(filterArgs == null) {
			filterArgs = new ExpressionArguments();
			state.cache.put(this, filterArgs);
		}
		filterArgs.update(state, ctx);
		
		// Run the predicate
		if(filter.test(filterArgs)) {
			processResultValue(remainingQueries, ctx, state, result);
		}
	}
}
