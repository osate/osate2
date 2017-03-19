package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.function.Predicate;
import org.osate.ge.internal.diagram.DiagramElementContainer;
import org.osate.ge.query.DiagramElementQuery;
import org.osate.ge.query.FilterArguments;
import org.osate.ge.query.Supplier;

public abstract class AgeDiagramElementQuery<A> implements DiagramElementQuery<A> {
	private AgeDiagramElementQuery<A> prev;
	
	public AgeDiagramElementQuery(final AgeDiagramElementQuery<A> prev) {
		this.prev = prev;
	}
	
	public final AgeDiagramElementQuery<A> getPrev() {
		return prev;
	}
	
	abstract void run(final Deque<AgeDiagramElementQuery<A>> remainingQueries, final DiagramElementContainer ctx, final QueryExecutionState<A> state, final QueryResult result);
	
	protected void processResultValue(final Deque<AgeDiagramElementQuery<A>> remainingQueries, final DiagramElementContainer value, final QueryExecutionState<A> state, final QueryResult result) {
		if(remainingQueries.size() == 0) {
			result.result.add(value);
			return;
		}
		
		final AgeDiagramElementQuery<A> nextQuery = remainingQueries.pop();
		nextQuery.run(remainingQueries, value, state, result);
		remainingQueries.push(nextQuery);
	}
	
	
	@Override
	public AgeDiagramElementQuery<A> first(int count) {
		return new FirstQuery<A>(this, count);
	}
	
	@Override
	public AgeDiagramElementQuery<A> first() {
		return new FirstQuery<A>(this);
	}

	@Override
	public AgeDiagramElementQuery<A> filter(final Predicate<FilterArguments<A>> filter) {
		return new FilterByPredicate<A>(this, filter);
	}
	
	@Override
	public AgeDiagramElementQuery<A> filterByBusinessObject(final Supplier<A, Object> boSupplier) {
		return new FilterByBusinessObjectQuery<A>(this, boSupplier);
	}

	@Override
	public AgeDiagramElementQuery<A> children() {
		return new ChildrenQuery<A>(this);
	}
	
	@Override
	public AgeDiagramElementQuery<A> descendants() {
		return new DescendantsQuery<A>(this);
	}
	
	@Override
	public AgeDiagramElementQuery<A> ancestor(final int depth) {
		return new AncestorQuery<A>(this, depth);
	}

	@Override
	public AgeDiagramElementQuery<A> ancestors() {
		return new AncestorsQuery<A>(this);
	}

	@Override
	public AgeDiagramElementQuery<A> commonAncestors(DiagramElementQuery<A> q2) {
		if(!(q2 instanceof AgeDiagramElementQuery)) {
			throw new RuntimeException("q2 must be of type PictogramQuery");
		}
		
		return new CommonAncestorsQuery<A>(this, (AgeDiagramElementQuery<A>)q2);
	}
	
	public AgeDiagramElementQuery<A> ifElse(Supplier<ConditionArguments<A>, Boolean> cond, 
			final Supplier<DiagramElementQuery<A>, DiagramElementQuery<A>> trueQuerySupplier,
			final Supplier<DiagramElementQuery<A>, DiagramElementQuery<A>> falseQuerySupplier) {
		return new IfElseQuery<A>(this, cond, trueQuerySupplier, falseQuerySupplier);
	}
	
	public AgeDiagramElementQuery<A> descendantsByBusinessObjects(final Supplier<A, Object[]> bosSupplier) {
		return new DescendantsByBusinessObjectsQuery<A>(this, bosSupplier);
	}
}
