package org.osate.ge;

import org.osate.ge.internal.query.Queryable;

public interface BusinessObjectContext extends Queryable {
	@Override
	BusinessObjectContext getParent();
	@Override
	Object getBusinessObject();

	@Override
	public default BusinessObjectContext getAncestor(final int depth) {
		return (BusinessObjectContext) Queryable.super.getAncestor(depth);
	}
}
