package org.osate.ge;

import org.osate.ge.internal.query.Queryable;

// TODO: Rename, Review, and Document
public interface BusinessObjectContext extends Queryable {
	BusinessObjectContext getParent();
	Object getBusinessObject();
}
