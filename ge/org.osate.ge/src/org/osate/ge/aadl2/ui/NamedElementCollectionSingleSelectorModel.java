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
package org.osate.ge.aadl2.ui;

import java.util.Collection;

import org.osate.aadl2.NamedElement;
import org.osate.ge.swt.selectors.CollectionSingleSelectorModel;
import org.osate.ge.swt.selectors.SingleSelectorModel;

import com.google.common.base.Strings;

/**
 * Implementation of {@link SingleSelectorModel} which allows selecting a named element from a collection.
 * @since 2.0
 */
public class NamedElementCollectionSingleSelectorModel<T extends NamedElement> extends CollectionSingleSelectorModel<T> {
	/**
	 * Creates a new instance
	 * @param elements the collection of named elements. The collection will be copied by the model. Changes to the collection will not be reflected by the model.
	 */
	public NamedElementCollectionSingleSelectorModel(final Collection<T> elements) {
		super(elements);
	}

	@Override
	public String getLabel(T element) {
		return Strings.nullToEmpty(element.getQualifiedName());
	}
}