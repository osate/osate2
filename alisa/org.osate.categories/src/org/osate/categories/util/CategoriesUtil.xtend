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

package org.osate.categories.util

import org.osate.categories.categories.Categories
import org.osate.categories.categories.Category
import java.util.ArrayList
import java.util.Collection
import java.util.HashSet

class CategoriesUtil {

	def static Categories containingCategories(Category sh) {
		sh.eContainer() as Categories
	}

	def static boolean matches(Iterable<? extends Category> specifiedCategories, Iterable<? extends Category> filterCriteria,
		boolean any) {
		if(filterCriteria.empty) return true 
		if (specifiedCategories.empty) return any
		val filterCTS = filterCriteria.categoriesSet
		var result = true
		for (ct : filterCTS){
			val filterCS = filterCriteria.getCategorySet(ct)
			val specifiedCS = specifiedCategories.getCategorySet(ct)
			result = result && specifiedCS.intersects(filterCS,any)
		}
		return result
	}

	def static boolean intersects(Iterable<? extends Category> specifiedCategories, Iterable<? extends Category> filterCriteria,
		boolean any) {
		if(filterCriteria.empty) return true 
		if (specifiedCategories.empty) return any
		for (fcrit : filterCriteria){
			for (scat : specifiedCategories) {
				if(fcrit.name.equalsIgnoreCase(scat.name)) return true
			}
		}
		return false
	}

	def static Iterable<? extends Category> intersection(Iterable<? extends Category> set1, Iterable<? extends Category> set2) {
		val Collection<Category> result = new ArrayList<Category>();
		if(set1.empty || set2.empty) return result 
		for (crit1 : set1){
			for (crit2 : set2) {
				if(crit1.name.equalsIgnoreCase(crit2.name)) result.add(crit1)
			}
		}
		return result
	}

	def static Iterable<? extends Categories> getCategoriesSet(Iterable<? extends Category> set1) {
		val Collection<Categories> result = new HashSet<Categories>();
		for (crit1 : set1){
			result.add(crit1.containingCategories)
		}
		return result
	}

	def static Iterable<? extends Category> getCategorySet(Iterable<? extends Category> set1, Categories categoryType) {
		val Collection<Category> result = new HashSet<Category>();
		for (crit1 : set1){
			if (crit1.containingCategories.name.equalsIgnoreCase(categoryType.name)) result.add(crit1)
		}
		return result
	}

}