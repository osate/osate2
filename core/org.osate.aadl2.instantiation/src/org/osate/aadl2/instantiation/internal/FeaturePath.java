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

import java.util.ArrayList;
import java.util.List;

/**
 * The chain of features a semantic connection reaches through on one side, from a
 * component's own feature down into nested feature groups.
 *
 * <p>
 * Source-first kept this state in two feature group stacks shared by every path under
 * {@code downFeature} stacks, which belong to the switch rather than to a path.
 * Two paths being enumerated share one stack, and a path seeded partway down a
 * feature group nesting still sees the levels above it, which is the mechanism
 * behind issues #3038 and #3040. A path here owns its feature state, and the state
 * is immutable, so extending one path cannot disturb another.
 * </p>
 *
 * @param elements the steps, outermost feature first
 */
public record FeaturePath(List<FeaturePathElement> elements) {

	/** The path of a connection end that reaches into no feature group. */
	public static final FeaturePath EMPTY = new FeaturePath(List.of());

	public FeaturePath {
		elements = List.copyOf(elements);
	}

	/** This path with one more step appended. Returns a new path; this one is unchanged. */
	public FeaturePath append(FeaturePathElement element) {
		if (element == null) {
			throw new IllegalArgumentException("Cannot append a null feature path element");
		}
		List<FeaturePathElement> extended = new ArrayList<>(elements);
		extended.add(element);
		return new FeaturePath(extended);
	}

	/** Stable identity of the whole chain. Never uses object identity. */
	public String key() {
		StringBuilder key = new StringBuilder();
		for (FeaturePathElement element : elements) {
			key.append(element.key()).append('/');
		}
		return key.toString();
	}
}
