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
package org.osate.ge.swt.selectors;

import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.EventSource;

/**
 * Adapter which implements {@link SelectorModel} for a {@link SingleSelectorModel} implementation.
 * @since 1.1
 */
public class SingleSelectorModelToSelectorModelAdapter<T> implements SelectorModel<T> {
	private final SingleSelectorModel<T> inner;

	public SingleSelectorModelToSelectorModelAdapter(final SingleSelectorModel<T> model) {
		this.inner = Objects.requireNonNull(model, "model must not be null");
	}

	@Override
	public EventSource<ChangeEvent> changed() {
		return inner.changed();
	}

	@Override
	public Stream<T> getElements() {
		return inner.getElements();
	}

	@Override
	public Stream<T> getSelectedElements() {
		return Stream.of(inner.getSelectedElement());
	}

	@Override
	public void setSelectedElements(final Stream<T> value) {
		final Iterator<T> it = value.iterator();
		inner.setSelectedElement(it.hasNext() ? it.next() : null);
	}

	@Override
	public String getLabel(final T element) {
		return inner.getLabel(element);
	}

	@Override
	public boolean supportsMultiSelect() {
		return false;
	}
}
