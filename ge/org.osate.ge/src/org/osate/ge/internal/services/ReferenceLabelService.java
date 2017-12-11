package org.osate.ge.internal.services;

import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;

public interface ReferenceLabelService {
	/**
	 *
	 * @param ref
	 * @return may return null.
	 */
	String getLabel(CanonicalBusinessObjectReference ref);

	/**
	 *
	 * @param ref
	 * @return may return null
	 */
	String getLabel(RelativeBusinessObjectReference ref);

}
