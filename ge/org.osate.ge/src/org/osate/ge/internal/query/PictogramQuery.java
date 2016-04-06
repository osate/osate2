package org.osate.ge.internal.query;

import java.util.function.Predicate;

import org.osate.ge.query.DiagramElementQuery;
import org.osate.ge.query.FilterArguments;
import org.osate.ge.query.Supplier;

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
		return new FilterByPredicate<A>(this, filter);
	}
	
	@Override
	public PictogramQuery<A> filterByBusinessObject(final Supplier<A, Object> boSupplier) {
		return new FilterByBusinessObjectQuery<A>(this, boSupplier);
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

	@Override
	public PictogramQuery<A> commonAncestors(DiagramElementQuery<A> q2) {
		if(!(q2 instanceof PictogramQuery)) {
			throw new RuntimeException("q2 must be of type PictogramQuery");
		}
		
		return new CommonAncestorsQuery<A>(this, (PictogramQuery<A>)q2);
	}
}
