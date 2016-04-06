package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.function.Predicate;

import org.osate.ge.query.DiagramElementQuery;
import org.osate.ge.query.FilterArguments;

public abstract class PictogramQuery<A> extends Query<A> implements DiagramElementQuery<A> {
	public PictogramQuery(final Query<A> prev) {
		super(prev);
	}
	
	@Override
	public PictogramQuery<A> first() {
		return new FirstPictogramQuery<A>(this);
	}

	@Override
	public PictogramQuery<A> filter(final Predicate<FilterArguments<A>> filter) {
		throw new RuntimeException("Unimplemented");
	}
	
	@Override
	public DiagramElementQuery<A> filterByBusinessObject(final Object bo) {
		throw new RuntimeException("Unimplemented");
	}

	@Override
	public PictogramQuery<A> children() {
		return new ChildrenQuery<A>(this);
	}
	
	@Override
	public PictogramQuery<A> descendants() {
		return new DescendantsQuery<A>(this);
	}
	
	@Override
	public PictogramQuery<A> ancestor(final int depth) {
		return new AncestorQuery<A>(this, depth);
	}

	@Override
	public PictogramQuery<A> ancestors() {
		return new AncestorsQuery<A>(this);
	}

	// TODO: Remove should be abstract part of Query
	abstract void run(final Deque<Query<A>> remainingQueries, final Object ctx, final QueryArguments<A> args, final QueryResult result);
}
