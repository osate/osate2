/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
