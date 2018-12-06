package org.osate.ge.internal.query;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public interface Queryable {
	Queryable getParent();
	Collection<? extends Queryable> getChildren();
	Object getBusinessObject();

	static Optional<Queryable> getFirstCommonAncestor(final Queryable q1, final Queryable q2) {
		Queryable temp1 = q1;
		while (temp1 != null) {
			Queryable temp2 = q2;
			while (temp2 != null) {
				if (temp1 == temp2) {
					return Optional.of(temp1);
				}
				temp2 = temp2.getParent();
			}

			temp1 = temp1.getParent();
		}

		return Optional.empty();
	}

	public default Stream<Queryable> getAllDescendants() {
		return Stream.concat(Stream.of(this), getChildren().stream().flatMap(Queryable::getAllDescendants));
	}

	/**
	 * Returns the ancestors which has a specified depth relative to this query.
	 * @param depth must be {@literal >} 0. A value of 1 returns the immediate ancestor.
	 * @return the new query
	 */
	public default Queryable getAncestor(final int depth) {
		Queryable e = this;
		for (int i = 0; i < depth && e != null; i++) {
			e = e.getParent();
		}

		return e;
	}

}
