/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
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