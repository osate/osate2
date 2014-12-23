package org.osate.categories.util

import org.osate.categories.categories.Category
import org.osate.categories.categories.Categories
import org.osate.categories.categories.RequirementCategories
import org.osate.categories.categories.VerificationCategories
import org.osate.categories.categories.HazardCategories

class CategoriesUtil {
	
	def static Categories containingCategories(Category sh){
		sh.eContainer() as Categories
	}
	
	def static category(Categories cats) {
		switch (cats) {
			RequirementCategories: cats.category
			VerificationCategories: cats.category
			HazardCategories: cats.category
		}
	}
}