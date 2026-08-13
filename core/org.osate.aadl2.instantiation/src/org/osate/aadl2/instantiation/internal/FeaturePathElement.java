/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.instantiation.internal;

import org.osate.aadl2.Feature;
import org.osate.aadl2.instance.FeatureInstance;

/**
 * One step of a {@link FeaturePath}: a feature declaration and, when it has been
 * resolved, the feature instance it denotes.
 *
 * <p>
 * The instance is absent while a path is still symbolic, which happens when a
 * feature group has not been expanded into its leaves yet. Keeping the
 * declaration and the instance in one element is what lets a symbolic path and a
 * resolved path be compared for compatibility without losing the declaration.
 * </p>
 *
 * @param feature the declared feature this step enters
 * @param instance the resolved feature instance, or {@code null} while symbolic
 */
public record FeaturePathElement(Feature feature, FeatureInstance instance) {

	public FeaturePathElement {
		if (feature == null) {
			throw new IllegalArgumentException("A feature path element needs a feature");
		}
	}

	/** A resolved element. */
	public static FeaturePathElement of(FeatureInstance instance) {
		if (instance == null) {
			throw new IllegalArgumentException("A resolved feature path element needs a feature instance");
		}
		return new FeaturePathElement(instance.getFeature(), instance);
	}

	/** A symbolic element, for a feature group that has not been expanded yet. */
	public static FeaturePathElement symbolic(Feature feature) {
		return new FeaturePathElement(feature, null);
	}

	public boolean isResolved() {
		return instance != null;
	}

	/** Stable identity of this step. Never uses object identity. */
	public String key() {
		return PathKeys.declarative(feature) + "@" + PathKeys.instance(instance);
	}
}
