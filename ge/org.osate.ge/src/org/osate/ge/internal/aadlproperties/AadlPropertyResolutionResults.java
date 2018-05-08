package org.osate.ge.internal.aadlproperties;

import org.osate.ge.internal.query.Queryable;

public class AadlPropertyResolutionResults {
	public final Queryable dst;
	public final boolean isPartial;

	public AadlPropertyResolutionResults(final Queryable dst,
			final boolean isPartial) {
		this.dst = dst;
		this.isPartial = isPartial;
	}
}