package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.List;
import java.util.Objects;
import org.osate.ge.query.DiagramElementQuery;
import org.osate.ge.query.Supplier;

class IfElseQuery<A> extends Query<A> {
	private final Supplier<ConditionArguments<A>, Boolean> cond;
	private final Query<A> trueQuery;
	private final Query<A> falseQuery;
	private final RootQuery innerRootQuery = new RootQuery(() -> this.innerRootValue);
	private Queryable innerRootValue;
	
	@SuppressWarnings("unchecked")
	public IfElseQuery(final Query<A> prev, 
			final Supplier<ConditionArguments<A>, Boolean> cond, 
			final Supplier<DiagramElementQuery<A>, DiagramElementQuery<A>> trueQuerySupplier, 
			final Supplier<DiagramElementQuery<A>, DiagramElementQuery<A>> falseQuerySupplier) {
		super(prev);
		this.cond = Objects.requireNonNull(cond, "cond must not be null");
		Objects.requireNonNull(trueQuerySupplier, "trueQuerySupplier must not be null");
		Objects.requireNonNull(falseQuerySupplier, "falseQuerySupplier must not be null");		
		this.trueQuery = (Query<A>)Objects.requireNonNull(trueQuerySupplier.get((DiagramElementQuery<A>)innerRootQuery), "trueQuery must not be null");
		this.falseQuery = (Query<A>)Objects.requireNonNull(falseQuerySupplier.get((DiagramElementQuery<A>)innerRootQuery), "falseQuery must not be null");
	}

	@Override
	void run(final Deque<Query<A>> remainingQueries, final Queryable ctx, final QueryExecutionState<A> state, final QueryResult result) {
		try {
			this.innerRootValue = ctx;

			// Set Condition Arguments
			@SuppressWarnings("unchecked")
			ExpressionArguments<A> conditionArgs = (ExpressionArguments<A>)state.cache.get(this);
			if(conditionArgs == null) {
				conditionArgs = new ExpressionArguments<>();
				state.cache.put(this, conditionArgs);
			}
			conditionArgs.update(state, ctx);
			
			// Evaluate the condition
			final Boolean condResult = cond.get(conditionArgs);		
			final Query<A> innerQuery = condResult.booleanValue() ? trueQuery : falseQuery;
			
			// Process the results of the inner query.
			// NOTE: Ideally this would be lazily evaluated instead of retrieving all the results. However, in the current use cases, only one result will be 
			// returned by the inner query.
			final List<Queryable> containers = state.queryRunner.getResults(innerQuery, state.arg);
			for(final Queryable container : containers) {
				processResultValue(remainingQueries, container, state, result);
				
				if(result.done) {
					return;
				}
			}
		} finally {
			innerRootValue = null;
		}
	}
}
