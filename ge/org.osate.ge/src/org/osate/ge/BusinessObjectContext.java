package org.osate.ge;

import org.osate.ge.internal.query.Queryable;

public interface BusinessObjectContext extends Queryable {
	BusinessObjectContext getParent();
	Object getBusinessObject();
}
