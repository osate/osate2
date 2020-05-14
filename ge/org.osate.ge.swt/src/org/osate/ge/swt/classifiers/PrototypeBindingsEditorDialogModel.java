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
package org.osate.ge.swt.classifiers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Model decorator used by the dialog which tracks changes and allows reverting.
 *
 * @param <N>
 * @param <D>
 * @param <T>
 * @param <C>
 */
class PrototypeBindingsEditorDialogModel<N, D, T, C>
		extends PrototypeBindingsModelDecorator<N, D, T, C> {
	private final Map<N, D> originalDirections = new HashMap<>();
	private final Map<N, T> originalTypes = new HashMap<>();
	private final Map<N, C> originalClassifiers = new HashMap<>();

	public PrototypeBindingsEditorDialogModel(final PrototypeBindingsModel<N, D, T, C> inner) {
		super(inner);
	}

	@Override
	public void setDirection(final N node, final D value) {
		// Store original value to allow reverting
		if (!originalDirections.containsKey(node)) {
			originalDirections.put(node, super.getDirection(node));
		}

		super.setDirection(node, value);
	}

	@Override
	public void setType(final N node, final T value) {
		// Store original value to allow reverting
		if (!originalTypes.containsKey(node)) {
			originalTypes.put(node, super.getType(node));
		}

		super.setType(node, value);
	}

	@Override
	public void setClassifier(final N node, final C value) {
		// Store original value to allow reverting
		if (!originalClassifiers.containsKey(node)) {
			originalClassifiers.put(node, super.getClassifier(node));
		}

		super.setClassifier(node, value);
	}

	public void revert() {
		// Revert classifier changes
		for (final Entry<N, C> e : originalClassifiers.entrySet()) {
			super.setClassifier(e.getKey(), e.getValue());
		}
		originalClassifiers.clear();

		// Revert type changes
		for (final Entry<N, T> e : originalTypes.entrySet()) {
			super.setType(e.getKey(), e.getValue());
		}
		originalTypes.clear();

		// Revert direction changes
		for (final Entry<N, D> e : originalDirections.entrySet()) {
			super.setDirection(e.getKey(), e.getValue());
		}
		originalDirections.clear();
	}
}