package org.osate.ge.query;

@FunctionalInterface
public interface Supplier<A, R> {
	R get(final A queryArgument);
}
