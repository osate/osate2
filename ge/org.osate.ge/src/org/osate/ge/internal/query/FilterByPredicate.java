package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.Objects;
import java.util.function.Predicate;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.query.FilterArguments;

class FilterByPredicate<A> extends PictogramQuery<A> {
	private final Predicate<FilterArguments<A>> filter;
	
	public FilterByPredicate(final Query<A> prev, final Predicate<FilterArguments<A>> filter) {
		super(prev);
		this.filter = Objects.requireNonNull(filter, "filter must not be null");
	}
	
	@Override
	void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryExecutionState<A> state, final QueryResult result) {
		if(!(ctx instanceof PictogramElement)) {
			throw new RuntimeException("Unsupported context: " + ctx);
		}

		// Set filter arguments
		@SuppressWarnings("unchecked")
		SimpleFilterArguments<A> filterArgs = (SimpleFilterArguments<A>)state.cache.get(this);
		if(filterArgs == null) {
			filterArgs = new SimpleFilterArguments<>();
			state.cache.put(this, filterArgs);
		}
		filterArgs.update(state, (PictogramElement)ctx);
		
		// Run the predicate
		if(filter.test(filterArgs)) {
			processResultValue(remainingQueries, ctx, state, result);
		}
	}
	
	private static class SimpleFilterArguments<A> implements FilterArguments<A> {
		private QueryExecutionState<A> state;
		private PictogramElement pe;

		void update(final QueryExecutionState<A> state, final PictogramElement pe) {
			this.state = state;
			this.pe = pe;			
		}		
		
		@Override
		public Object getBusinessObject() {
			return state.bor.getBusinessObjectForPictogramElement(pe);
		}

		@Override
		public A getQueryArgument() {
			return state.arg;
		}		
	}		
}
