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
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osate.ge.swt.BaseObservableModel;

/**
 *
 * @noreference This class is not intended to be referenced by clients.
 *
 */
public class TestSelectorModel extends BaseObservableModel implements SelectorModel<String> {
	private final List<String> elements = new ArrayList<>();
	private List<String> selection = Collections.emptyList();

	public TestSelectorModel() {
		elements.add(null);
		elements.add("A");
		elements.add("B");
		elements.add("C");
		elements.add("D");
	}

	@Override
	public Stream<String> getElements() {
		return elements.stream();
	}

	@Override
	public Stream<String> getSelectedElements() {
		return selection.stream();
	}

	@Override
	public void setSelectedElements(final Stream<String> value) {
		final List<String> newSelection = value.collect(Collectors.toList());
		if (!Objects.equals(selection, newSelection)) {
			this.selection = newSelection;
			triggerChangeEvent();
		}
	}

	@Override
	public String getLabel(final String element) {
		return element == null ? "<null>" : element;
	}

	@Override
	public boolean supportsMultiSelect() {
		return true;
	}
}
