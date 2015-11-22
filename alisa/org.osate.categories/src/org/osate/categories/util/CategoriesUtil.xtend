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

import java.util.HashSet
import org.osate.categories.categories.Categories
import org.osate.categories.categories.Category
import org.osate.categories.categories.CategorySet
import org.osate.categories.categories.MethodCategories
import org.osate.categories.categories.QualityCategories
import org.osate.categories.categories.RequirementCategories
import org.osate.categories.categories.SelectionCategories

class CategoriesUtil {

	def static Categories containingCategories(Category sh) {
		sh.eContainer() as Categories
	}

	def static category(Categories cats) {
		switch (cats) {
			RequirementCategories: cats.category
			MethodCategories: cats.category
			SelectionCategories: cats.category
			QualityCategories: cats.category
		}
	}

	def static boolean isSameorContains(Category catset, Category cat) {
		if(catset.name.equalsIgnoreCase(cat.name)) return true
		if (catset instanceof CategorySet) {
			for (c : catset.elements) {
				if(c.isSameorContains(cat)) return true
			}
		}
		return false;
	}

	def static CategorySet hasCycle(CategorySet cat) {
		val visitedCategory = <Category>newHashSet()
		return doCycle(cat, visitedCategory)
	}

	private static def CategorySet doCycle(CategorySet catset, HashSet<Category> visitedCategory) {
		for (c : catset.elements) {
			if (visitedCategory.contains(c)) {
				return catset
			}
			if (c instanceof CategorySet){
				val res = c.doCycle(visitedCategory)
				if (res != null) return res
			}
		}
		return null
	}

	def static void removeSetElement(CategorySet catset, String name) {
		val obj = catset.findSubcategory(name)
		catset.elements.remove(obj)
	}

	def static Category findSubcategory(CategorySet catset, String name) {
		for (c : catset.elements) {
			if(c.name.equalsIgnoreCase(catset.name)) return c
		}
		return null;
	}

	def static boolean intersects(Iterable<? extends Category> elementcat, Iterable<? extends Category> criteria,
		boolean strict) {
		if(criteria.empty) return true // elementcat can be empty or non-empty
		if (elementcat.empty) {
			return !strict
		}
		for (f : criteria) {
			for (s : elementcat) {
				if(f.isSameorContains(s) || s.isSameorContains(f)) return true
			}
		}
		return false
	}

	def static boolean intersects(Iterable<? extends Category> elementcat, CategorySet criteria,
		boolean strict) {
		if(criteria.elements.empty) return true // elementcat can be empty or non-empty
		if (elementcat.empty) {
			return !strict
		}
		for (f : criteria.elements) {
			for (s : elementcat) {
				if(f.isSameorContains(s) || s.isSameorContains(f)) 
					return true
			}
		}
		return false
	}

}