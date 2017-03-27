package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.List;
import java.util.Objects;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.query.DiagramElementQuery;
import org.osate.ge.query.Supplier;

class IfElseQuery<A> extends AgeDiagramElementQuery<A> {
	private final Supplier<ConditionArguments<A>, Boolean> cond;
	private final AgeDiagramElementQuery<A> trueQuery;
	private final AgeDiagramElementQuery<A> falseQuery;
	private final RootAgeDiagramElementQuery innerRootQuery = new RootAgeDiagramElementQuery(() -> this.innerRootValue);
	private DiagramNode innerRootValue;
	
	@SuppressWarnings("unchecked")
	public IfElseQuery(final AgeDiagramElementQuery<A> prev, 
			final Supplier<ConditionArguments<A>, Boolean> cond, 
			final Supplier<DiagramElementQuery<A>, DiagramElementQuery<A>> trueQuerySupplier, 
			final Supplier<DiagramElementQuery<A>, DiagramElementQuery<A>> falseQuerySupplier) {
		super(prev);
		this.cond = Objects.requireNonNull(cond, "cond must not be null");
		Objects.requireNonNull(trueQuerySupplier, "trueQuerySupplier must not be null");
		Objects.requireNonNull(falseQuerySupplier, "falseQuerySupplier must not be null");		
		this.trueQuery = (AgeDiagramElementQuery<A>)Objects.requireNonNull(trueQuerySupplier.get((DiagramElementQuery<A>)innerRootQuery), "trueQuery must not be null");
		this.falseQuery = (AgeDiagramElementQuery<A>)Objects.requireNonNull(falseQuerySupplier.get((DiagramElementQuery<A>)innerRootQuery), "falseQuery must not be null");
	}

	@Override
	void run(final Deque<AgeDiagramElementQuery<A>> remainingQueries, final DiagramNode ctx, final QueryExecutionState<A> state, final QueryResult result) {
		try {
			this.innerRootValue = ctx;

			// Set Condition Arguments
			@SuppressWarnings("unchecked")
			ExpressionArguments<A> conditionArgs = (ExpressionArguments<A>)state.cache.get(this);
			if(conditionArgs == null) {
				conditionArgs = new ExpressionArguments<>();
				state.cache.put(this, conditionArgs);
			}
			conditionArgs.update(state, (DiagramNode)ctx);
			
			// Evaluate the condition
			final Boolean condResult = cond.get(conditionArgs);		
			final AgeDiagramElementQuery<A> innerQuery = condResult.booleanValue() ? trueQuery : falseQuery;
			
			// Process the results of the inner query.
			// NOTE: Ideally this would be lazily evaluated instead of retrieving all the results. However, in the current use cases, only one result will be 
			// returned by the inner query.
			final List<DiagramNode> diagramElementContainers = state.queryRunner.getResults(innerQuery, state.arg);
			for(final DiagramNode diagramElementContainer : diagramElementContainers) {
				processResultValue(remainingQueries, diagramElementContainer, state, result);
				
				if(result.done) {
					return;
				}
			}
		} finally {
			innerRootValue = null;
		}
	}
}
