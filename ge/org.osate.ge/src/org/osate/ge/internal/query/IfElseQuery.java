package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.List;
import java.util.Objects;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.query.DiagramElementQuery;
import org.osate.ge.query.Supplier;

class IfElseQuery<A> extends PictogramQuery<A> {
	private final Supplier<ConditionArguments<A>, Boolean> cond;
	private final PictogramQuery<A> trueQuery;
	private final PictogramQuery<A> falseQuery;
	private final RootPictogramQuery innerRootQuery = new RootPictogramQuery(() -> this.innerRootValue);
	private PictogramElement innerRootValue;
	
	@SuppressWarnings("unchecked")
	public IfElseQuery(final Query<A> prev, 
			final Supplier<ConditionArguments<A>, Boolean> cond, 
			final Supplier<DiagramElementQuery<A>, DiagramElementQuery<A>> trueQuerySupplier, 
			final Supplier<DiagramElementQuery<A>, DiagramElementQuery<A>> falseQuerySupplier) {
		super(prev);
		this.cond = Objects.requireNonNull(cond, "cond must not be null");
		Objects.requireNonNull(trueQuerySupplier, "trueQuerySupplier must not be null");
		Objects.requireNonNull(falseQuerySupplier, "falseQuerySupplier must not be null");		
		this.trueQuery = (PictogramQuery<A>)Objects.requireNonNull(trueQuerySupplier.get((DiagramElementQuery<A>)innerRootQuery), "trueQuery must not be null");
		this.falseQuery = (PictogramQuery<A>)Objects.requireNonNull(falseQuerySupplier.get((DiagramElementQuery<A>)innerRootQuery), "falseQuery must not be null");
	}

	@Override
	void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryExecutionState<A> state, final QueryResult result) {
		try {
			if(ctx instanceof Shape || ctx instanceof Connection) {
				innerRootValue = (PictogramElement)ctx;
			} else {
				throw new RuntimeException("Unsupported context: " + ctx);
			}
			
			// Set Condition Arguments
			@SuppressWarnings("unchecked")
			ExpressionArguments<A> conditionArgs = (ExpressionArguments<A>)state.cache.get(this);
			if(conditionArgs == null) {
				conditionArgs = new ExpressionArguments<>();
				state.cache.put(this, conditionArgs);
			}
			conditionArgs.update(state, (PictogramElement)ctx);
			
			// Evaluate the condition
			final Boolean condResult = cond.get(conditionArgs);		
			final PictogramQuery<A> innerQuery = condResult.booleanValue() ? trueQuery : falseQuery;
			
			// Process the results of the inner query.
			// NOTE: Ideally this would be lazily evaluated instead of retrieving all the results. However, in the current use cases, only one result will be 
			// returned by the inner query.
			final List<? extends PictogramElement> pes = state.queryRunner.getPictogramElements(innerQuery, state.arg);
			for(final PictogramElement pe : pes) {
				processResultValue(remainingQueries, pe, state, result);
				
				if(result.done) {
					return;
				}
			}
		} finally {
			innerRootValue = null;
		}
	}
}
