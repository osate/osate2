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
package org.osate.categories.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;
import org.osate.categories.categories.Categories;
import org.osate.categories.categories.Category;

public class CategoriesUtil {
	public static Categories containingCategories(final Category sh) {
		return (Categories) sh.eContainer();
	}

	public static boolean matches(final Iterable<? extends Category> specifiedCategories,
			final Iterable<? extends Category> filterCriteria, final boolean any) {
		if (isEmpty(filterCriteria)) {
			return true;
		}
		if (isEmpty(specifiedCategories)) {
			return any;
		}
		final Iterable<? extends Categories> filterCTS = CategoriesUtil.getCategoriesSet(filterCriteria);
		boolean result = true;
		for (final Categories ct : filterCTS) {
			{
				final Iterable<? extends Category> filterCS = CategoriesUtil.getCategorySet(filterCriteria, ct);
				final Iterable<? extends Category> specifiedCS = CategoriesUtil.getCategorySet(specifiedCategories, ct);
				result = (result && CategoriesUtil.intersects(specifiedCS, filterCS, any));
			}
		}
		return result;
	}

	public static boolean intersects(final Iterable<? extends Category> specifiedCategories,
			final Iterable<? extends Category> filterCriteria, final boolean any) {
		if (isEmpty(filterCriteria)) {
			return true;
		}
		if (isEmpty(specifiedCategories)) {
			return any;
		}
		for (final Category fcrit : filterCriteria) {
			for (final Category scat : specifiedCategories) {
				if (fcrit.getName().equalsIgnoreCase(scat.getName())) {
					return true;
				}
			}
		}
		return false;
	}

	public static Iterable<? extends Category> intersection(final Iterable<? extends Category> set1,
			final Iterable<? extends Category> set2) {
		final Collection<Category> result = new ArrayList<Category>();
		if (isEmpty(set1) || isEmpty(set2)) {
			return result;
		}
		for (final Category crit1 : set1) {
			for (final Category crit2 : set2) {
				if (crit1.getName().equalsIgnoreCase(crit2.getName())) {
					result.add(crit1);
				}
			}
		}
		return result;
	}

	public static Iterable<? extends Categories> getCategoriesSet(final Iterable<? extends Category> set1) {
		final Collection<Categories> result = new HashSet<Categories>();
		for (final Category crit1 : set1) {
			result.add(CategoriesUtil.containingCategories(crit1));
		}
		return result;
	}

	public static Iterable<? extends Category> getCategorySet(final Iterable<? extends Category> set1,
			final Categories categoryType) {
		final Collection<Category> result = new HashSet<Category>();
		for (final Category crit1 : set1) {
			if (CategoriesUtil.containingCategories(crit1).getName().equalsIgnoreCase(categoryType.getName())) {
				result.add(crit1);
			}
		}
		return result;
	}

	private static boolean isEmpty(final Iterable<?> values) {
		return !values.iterator().hasNext();
	}
}
