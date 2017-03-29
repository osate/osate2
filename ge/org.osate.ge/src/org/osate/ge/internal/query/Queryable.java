package org.osate.ge.internal.query;

import java.util.Collection;

public interface Queryable {
	Queryable getParent();
	Collection<Queryable> getChildren();
	Object getBusinessObject();
}
