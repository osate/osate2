package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.function.Predicate;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.query.DiagramElementQuery;
import org.osate.ge.query.FilterArguments;
import org.osate.ge.query.Supplier;

public abstract class DiagramNodeQuery<A> implements DiagramElementQuery<A> {
	private DiagramNodeQuery<A> prev;
	
	public DiagramNodeQuery(final DiagramNodeQuery<A> prev) {
		this.prev = prev;
	}
	
	public final DiagramNodeQuery<A> getPrev() {
		return prev;
	}
	
	abstract void run(final Deque<DiagramNodeQuery<A>> remainingQueries, final DiagramNode ctx, final QueryExecutionState<A> state, final QueryResult result);
	
	protected void processResultValue(final Deque<DiagramNodeQuery<A>> remainingQueries, final DiagramNode value, final QueryExecutionState<A> state, final QueryResult result) {
		if(remainingQueries.size() == 0) {
			result.result.add(value);
			return;
		}
		
		final DiagramNodeQuery<A> nextQuery = remainingQueries.pop();
		nextQuery.run(remainingQueries, value, state, result);
		remainingQueries.push(nextQuery);
	}
	
	
	@Override
	public DiagramNodeQuery<A> first(int count) {
		return new FirstQuery<A>(this, count);
	}
	
	@Override
	public DiagramNodeQuery<A> first() {
		return new FirstQuery<A>(this);
	}

	@Override
	public DiagramNodeQuery<A> filter(final Predicate<FilterArguments<A>> filter) {
		return new FilterByPredicate<A>(this, filter);
	}
	
	@Override
	public DiagramNodeQuery<A> filterByBusinessObject(final Supplier<A, Object> boSupplier) {
		return new FilterByBusinessObjectQuery<A>(this, boSupplier);
	}

	@Override
	public DiagramNodeQuery<A> children() {
		return new ChildrenQuery<A>(this);
	}
	
	@Override
	public DiagramNodeQuery<A> descendants() {
		return new DescendantsQuery<A>(this);
	}
	
	@Override
	public DiagramNodeQuery<A> ancestor(final int depth) {
		return new AncestorQuery<A>(this, depth);
	}

	@Override
	public DiagramNodeQuery<A> ancestors() {
		return new AncestorsQuery<A>(this);
	}

	@Override
	public DiagramNodeQuery<A> commonAncestors(DiagramElementQuery<A> q2) {
		if(!(q2 instanceof DiagramNodeQuery)) {
			throw new RuntimeException("q2 must be of type PictogramQuery");
		}
		
		return new CommonAncestorsQuery<A>(this, (DiagramNodeQuery<A>)q2);
	}
	
	public DiagramNodeQuery<A> ifElse(Supplier<ConditionArguments<A>, Boolean> cond, 
			final Supplier<DiagramElementQuery<A>, DiagramElementQuery<A>> trueQuerySupplier,
			final Supplier<DiagramElementQuery<A>, DiagramElementQuery<A>> falseQuerySupplier) {
		return new IfElseQuery<A>(this, cond, trueQuerySupplier, falseQuerySupplier);
	}
	
	public DiagramNodeQuery<A> descendantsByBusinessObjects(final Supplier<A, Object[]> bosSupplier) {
		return new DescendantsByBusinessObjectsQuery<A>(this, bosSupplier);
	}
}
