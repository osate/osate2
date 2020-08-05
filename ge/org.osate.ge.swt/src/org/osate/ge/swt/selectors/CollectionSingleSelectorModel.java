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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

import org.osate.ge.swt.BaseObservableModel;

/**
 * Abstract implementation of {@link SingleSelectorModel} which provides elements from a collection.
 * @since 1.1
 */
public abstract class CollectionSingleSelectorModel<T> extends BaseObservableModel implements SingleSelectorModel<T> {
	private T selectedElement;
	private final Collection<T> elements;

	/**
	 * Creates a new instance
	 * @param elements the collection of elements. The collection will be copied by the model. Changes to the collection will not be reflected by the model.
	 */
	public CollectionSingleSelectorModel(final Collection<T> elements) {
		this.elements = new ArrayList<>(Objects.requireNonNull(elements, "elements must not be null"));
	}

	@Override
	public final Stream<T> getElements() {
		return elements.stream();
	}

	@Override
	public final T getSelectedElement() {
		return selectedElement;
	}

	@Override
	public final void setSelectedElement(final T value) {
		if (!Objects.equals(selectedElement, value)) {
			this.selectedElement = value;
			triggerChangeEvent();
		}
	}
}