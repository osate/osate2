package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.List;
import java.util.Objects;
import org.osate.ge.query.Query;
import org.osate.ge.query.Supplier;

class IfElseQuery extends DefaultQuery {
	private final Supplier<ConditionArguments, Boolean> cond;
	private final DefaultQuery trueQuery;
	private final DefaultQuery falseQuery;
	private final RootQuery innerRootQuery = new RootQuery(() -> this.innerRootValue);
	private Queryable innerRootValue;
	
	public IfElseQuery(final DefaultQuery prev, 
			final Supplier<ConditionArguments, Boolean> cond, 
			final Supplier<Query, Query> trueQuerySupplier, 
			final Supplier<Query, Query> falseQuerySupplier) {
		super(prev);
		this.cond = Objects.requireNonNull(cond, "cond must not be null");
		Objects.requireNonNull(trueQuerySupplier, "trueQuerySupplier must not be null");
		Objects.requireNonNull(falseQuerySupplier, "falseQuerySupplier must not be null");		
		this.trueQuery = (DefaultQuery)Objects.requireNonNull(trueQuerySupplier.get((Query)innerRootQuery), "trueQuery must not be null");
		this.falseQuery = (DefaultQuery)Objects.requireNonNull(falseQuerySupplier.get((Query)innerRootQuery), "falseQuery must not be null");
	}

	@Override
	void run(final Deque<DefaultQuery> remainingQueries, final Queryable ctx, final QueryExecutionState state, final QueryResult result) {
		try {
			this.innerRootValue = ctx;

			// Set Condition Arguments
			ExpressionArguments conditionArgs = (ExpressionArguments)state.cache.get(this);
			if(conditionArgs == null) {
				conditionArgs = new ExpressionArguments();
				state.cache.put(this, conditionArgs);
			}
			conditionArgs.update(state, ctx);
			
			// Evaluate the condition
			final Boolean condResult = cond.get(conditionArgs);		
			final DefaultQuery innerQuery = condResult.booleanValue() ? trueQuery : falseQuery;
			
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
