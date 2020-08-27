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
package org.osate.ge.aadl2.ui.internal.properties;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.NamedElement;

public class AadlPropertySectionUtil {
	// Returns initial value for type options and populates type options
	public static <T extends NamedElement> EClass getTypeOptionsInformation(final Set<T> selectedElements,
			final Collection<EClass> allTypes, final BiFunction<T, EClass, Boolean> isValidTypeOption,
			final Consumer<EClass> addTypeOption) {
		EClass selectedType = null;
		for (final EClass type : allTypes) {
			final Iterator<T> it = selectedElements.iterator();
			T ne = it.next();
			// Initial combo selected value
			selectedType = ne.eClass();
	
			// Only add eligible types to the combo
			boolean addEClass = isValidTypeOption.apply(ne, type);
			if (addEClass) {
				// Check the rest of selected elements if necessary
				while (addEClass && it.hasNext()) {
					ne = it.next();
					// Check if all selected elements are the same EClass
					if (selectedType != ne.eClass()) {
						selectedType = null;
					}
					addEClass = isValidTypeOption.apply(ne, type);
				}
	
				if (addEClass) {
					addTypeOption.accept(type);
				}
			}
		}
	
		return selectedType;
	}

}
