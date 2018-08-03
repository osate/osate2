package org.osate.ge.internal.util;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class AgeEmfUtil {
	/**
	 * Copies structural feature values from original to replacement. If replacement does not contain a matching structural feature, the value is ignored. If a feature is not set,
	 * its value is not copied over to the replacement.
	 * @param original
	 * @param replacement
	 */
	public static void transferStructuralFeatureValues(final EObject original, final EObject replacement) {
		for (final EStructuralFeature feature : original.eClass().getEAllStructuralFeatures()) {
			if (feature.isChangeable() && !feature.isDerived()) {
				final Object originalValue = original.eGet(feature, true);

				// Only copy values that are set
				if (original.eIsSet(feature)) {
					if (replacement.eClass().getEAllStructuralFeatures().contains(feature)) {
						if (feature.isMany()) {
							final @SuppressWarnings("unchecked") List<Object> originalList = (List<Object>) originalValue;
							final Object replacementValue = replacement.eGet(feature);
							final @SuppressWarnings("unchecked") List<Object> replacementList = (List<Object>) replacementValue;
							replacementList.addAll(originalList);
						} else {
							replacement.eSet(feature, originalValue);
						}
					}
				}
			}
		}
	}
}
