package org.osate.categories.util

import org.osate.categories.categories.Categories
import org.osate.categories.categories.Category
import org.osate.categories.categories.RequirementCategories
import org.osate.categories.categories.RequirementCategory
import org.osate.categories.categories.SelectionCategories
import org.osate.categories.categories.SelectionCategory
import org.osate.categories.categories.MethodCategories
import org.osate.categories.categories.MethodCategory
import java.util.HashSet
import org.osate.categories.categories.QualityCategories
import org.osate.categories.categories.ComponentCategories
import org.osate.categories.categories.CategorySet

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
			ComponentCategories: cats.category
		}
	}

//	def static Iterable<? extends Category> subCategories(Category cat) {
//		switch (cat) {
//			RequirementCategory: cat.subCategories
//			MethodCategory: cat.subCategories
//			SelectionCategory: cat.subCategories
//		}
//	}
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