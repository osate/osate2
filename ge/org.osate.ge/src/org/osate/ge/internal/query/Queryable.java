package org.osate.ge.internal.query;

import java.util.Collection;

public interface Queryable {
	Queryable getParent();
	Collection<? extends Queryable> getChildren();
	Object getBusinessObject();
}
