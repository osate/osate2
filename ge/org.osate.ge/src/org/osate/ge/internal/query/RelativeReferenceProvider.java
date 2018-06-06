package org.osate.ge.internal.query;

import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;

/**
 * Indicates that the object can provide the relative reference associated with it's business object.
 * Optional interface that can be implemented by queryables for optimization purposes.
 *
 */
public interface RelativeReferenceProvider {
	RelativeBusinessObjectReference getRelativeReference();
}
