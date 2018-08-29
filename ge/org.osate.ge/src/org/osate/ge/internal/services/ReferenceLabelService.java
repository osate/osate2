package org.osate.ge.internal.services;

import org.eclipse.core.resources.IProject;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;

public interface ReferenceLabelService {
	/**
	 *
	 * @param ref
	 * @param project is a hint as to the project which contains the reference.
	 * @return may return null.
	 */
	String getLabel(CanonicalBusinessObjectReference ref, IProject project);

	/**
	 *
	 * @param ref must not be null.
	 * @return may return null
	 */
	String getLabel(RelativeBusinessObjectReference ref);

}
