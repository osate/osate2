package org.osate.ge.internal.util;

import java.util.Optional;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.internal.query.Queryable;

public class AadlClassifierUtil {
	/**
	 * Returns a component implementation for a specified business object. Only component implementations and subcomponents are supported.
	 * @param bo
	 * @return
	 */
	public static Optional<ComponentImplementation> getComponentImplementation(final Object bo) {
		final ComponentImplementation ci;
		if (bo instanceof Queryable) {
			return getComponentImplementation(((Queryable) bo).getBusinessObject());
		} else if (bo instanceof ComponentImplementation) {
			ci = (ComponentImplementation) bo;
		} else if (bo instanceof Subcomponent) {
			final Classifier scClassifier = ((Subcomponent) bo).getAllClassifier();
			ci = scClassifier instanceof ComponentImplementation ? (ComponentImplementation) scClassifier : null;
		} else {
			ci = null;
		}

		return Optional.ofNullable(ci);
	}
}
