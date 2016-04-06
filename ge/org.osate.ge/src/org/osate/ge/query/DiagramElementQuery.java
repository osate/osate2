package org.osate.ge.query;

import java.util.function.Predicate;

public interface DiagramElementQuery<A> {
	DiagramElementQuery<A> first();
	DiagramElementQuery<A> filter(Predicate<FilterArguments<A>> filter);
	DiagramElementQuery<A> filterByBusinessObject(Supplier<A, Object> boSupplier);
	DiagramElementQuery<A> children();
	DiagramElementQuery<A> descendants();
	DiagramElementQuery<A> ancestor(int depth);
	DiagramElementQuery<A> ancestors();
	DiagramElementQuery<A> commonAncestors(DiagramElementQuery<A> q2);
}
