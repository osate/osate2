package org.osate.ge.internal.query;

import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.services.ReferenceBuilderService;

interface InternalQueryUtil {
	public static RelativeBusinessObjectReference getRelativeReference(final Queryable q,
			final ReferenceBuilderService refBuilder) {
		if (q instanceof RelativeReferenceProvider) {
			return ((RelativeReferenceProvider) q).getRelativeReference();
		}

		return refBuilder.getRelativeReference(q.getBusinessObject());
	}
}
