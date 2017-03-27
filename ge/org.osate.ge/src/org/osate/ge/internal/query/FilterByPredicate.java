package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.Objects;
import java.util.function.Predicate;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.query.FilterArguments;

class FilterByPredicate<A> extends AgeDiagramElementQuery<A> {
	private final Predicate<FilterArguments<A>> filter;
	
	public FilterByPredicate(final AgeDiagramElementQuery<A> prev, final Predicate<FilterArguments<A>> filter) {
		super(prev);
		this.filter = Objects.requireNonNull(filter, "filter must not be null");
	}
	
	@Override
	void run(final Deque<AgeDiagramElementQuery<A>> remainingQueries, final DiagramNode ctx, final QueryExecutionState<A> state, final QueryResult result) {
		// Set filter arguments
		@SuppressWarnings("unchecked")
		ExpressionArguments<A> filterArgs = (ExpressionArguments<A>)state.cache.get(this);
		if(filterArgs == null) {
			filterArgs = new ExpressionArguments<>();
			state.cache.put(this, filterArgs);
		}
		filterArgs.update(state, ctx);
		
		// Run the predicate
		if(filter.test(filterArgs)) {
			processResultValue(remainingQueries, ctx, state, result);
		}
	}
}
