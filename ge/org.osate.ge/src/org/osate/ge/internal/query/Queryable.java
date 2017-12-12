package org.osate.ge.internal.query;

import java.util.Collection;
import java.util.Optional;

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
}
