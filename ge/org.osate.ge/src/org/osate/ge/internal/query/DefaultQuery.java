package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.function.Predicate;
import org.osate.ge.query.Query;
import org.osate.ge.query.FilterArguments;
import org.osate.ge.query.Supplier;

public abstract class DefaultQuery implements Query {
	private DefaultQuery prev;
	
	public DefaultQuery(final DefaultQuery prev) {
		this.prev = prev;
	}
	
	public final DefaultQuery getPrev() {
		return prev;
	}
	
	abstract void run(final Deque<DefaultQuery> remainingQueries, final Queryable ctx, final QueryExecutionState state, final QueryResult result);
	
	protected void processResultValue(final Deque<DefaultQuery> remainingQueries, final Queryable value, final QueryExecutionState state, final QueryResult result) {
		if(remainingQueries.size() == 0) {
			result.result.add(value);
			return;
		}
		
		final DefaultQuery nextQuery = remainingQueries.pop();
		nextQuery.run(remainingQueries, value, state, result);
		remainingQueries.push(nextQuery);
	}
	
	
	@Override
	public DefaultQuery first(int count) {
		return new FirstQuery(this, count);
	}
	
	@Override
	public DefaultQuery first() {
		return new FirstQuery(this);
	}

	@Override
	public DefaultQuery filter(final Predicate<FilterArguments> filter) {
		return new FilterByPredicate(this, filter);
	}
	
	@Override
	public DefaultQuery filterByBusinessObject(final Supplier<?, Object> boSupplier) {
		return new FilterByBusinessObjectQuery(this, boSupplier);
	}

	@Override
	public DefaultQuery children() {
		return new ChildrenQuery(this);
	}
	
	@Override
	public DefaultQuery descendants() {
		return new DescendantsQuery(this);
	}
	
	@Override
	public DefaultQuery ancestor(final int depth) {
		return new AncestorQuery(this, depth);
	}

	@Override
	public DefaultQuery ancestors() {
		return new AncestorsQuery(this);
	}

	@Override
	public DefaultQuery commonAncestors(Query q2) {
		if(!(q2 instanceof DefaultQuery)) {
			throw new RuntimeException("q2 must be of type PictogramQuery");
		}
		
		return new CommonAncestorsQuery(this, (DefaultQuery)q2);
	}
	
	@Override
	public DefaultQuery ifElse(Supplier<ConditionArguments, Boolean> cond, 
			final Supplier<Query, Query> trueQuerySupplier,
			final Supplier<Query, Query> falseQuerySupplier) {
		return new IfElseQuery(this, cond, trueQuerySupplier, falseQuerySupplier);
	}
	
	@Override
	public DefaultQuery descendantsByBusinessObjects(final Supplier<?, Object[]> bosSupplier) {
		return new DescendantsByBusinessObjectsQuery(this, bosSupplier);
	}
}
