package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.function.Predicate;
import org.osate.ge.query.DiagramElementQuery;
import org.osate.ge.query.FilterArguments;
import org.osate.ge.query.Supplier;

public abstract class Query<A> implements DiagramElementQuery<A> {
	private Query<A> prev;
	
	public Query(final Query<A> prev) {
		this.prev = prev;
	}
	
	public final Query<A> getPrev() {
		return prev;
	}
	
	abstract void run(final Deque<Query<A>> remainingQueries, final Queryable ctx, final QueryExecutionState<A> state, final QueryResult result);
	
	protected void processResultValue(final Deque<Query<A>> remainingQueries, final Queryable value, final QueryExecutionState<A> state, final QueryResult result) {
		if(remainingQueries.size() == 0) {
			result.result.add(value);
			return;
		}
		
		final Query<A> nextQuery = remainingQueries.pop();
		nextQuery.run(remainingQueries, value, state, result);
		remainingQueries.push(nextQuery);
	}
	
	
	@Override
	public Query<A> first(int count) {
		return new FirstQuery<A>(this, count);
	}
	
	@Override
	public Query<A> first() {
		return new FirstQuery<A>(this);
	}

	@Override
	public Query<A> filter(final Predicate<FilterArguments<A>> filter) {
		return new FilterByPredicate<A>(this, filter);
	}
	
	@Override
	public Query<A> filterByBusinessObject(final Supplier<A, Object> boSupplier) {
		return new FilterByBusinessObjectQuery<A>(this, boSupplier);
	}

	@Override
	public Query<A> children() {
		return new ChildrenQuery<A>(this);
	}
	
	@Override
	public Query<A> descendants() {
		return new DescendantsQuery<A>(this);
	}
	
	@Override
	public Query<A> ancestor(final int depth) {
		return new AncestorQuery<A>(this, depth);
	}

	@Override
	public Query<A> ancestors() {
		return new AncestorsQuery<A>(this);
	}

	@Override
	public Query<A> commonAncestors(DiagramElementQuery<A> q2) {
		if(!(q2 instanceof Query)) {
			throw new RuntimeException("q2 must be of type PictogramQuery");
		}
		
		return new CommonAncestorsQuery<A>(this, (Query<A>)q2);
	}
	
	public Query<A> ifElse(Supplier<ConditionArguments<A>, Boolean> cond, 
			final Supplier<DiagramElementQuery<A>, DiagramElementQuery<A>> trueQuerySupplier,
			final Supplier<DiagramElementQuery<A>, DiagramElementQuery<A>> falseQuerySupplier) {
		return new IfElseQuery<A>(this, cond, trueQuerySupplier, falseQuerySupplier);
	}
	
	public Query<A> descendantsByBusinessObjects(final Supplier<A, Object[]> bosSupplier) {
		return new DescendantsByBusinessObjectsQuery<A>(this, bosSupplier);
	}
}
