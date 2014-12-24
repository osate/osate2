package org.osate.categories.util

import org.osate.categories.categories.Category
import org.osate.categories.categories.Categories
import org.osate.categories.categories.RequirementCategories
import org.osate.categories.categories.VerificationCategories
import org.osate.categories.categories.HazardCategories
import org.osate.categories.categories.RequirementCategory
import org.osate.categories.categories.VerificationCategory
import org.osate.categories.categories.HazardCategory
import org.eclipse.emf.ecore.EObject

class CategoriesUtil {
	
	def Categories containingCategories(Category sh){
		sh.eContainer() as Categories
	}
	
	def category(Categories cats) {
		switch (cats) {
			RequirementCategories: cats.category
			VerificationCategories: cats.category
			HazardCategories: cats.category
		}
	}
	
	def Category getSuperType(Category cat) {
		switch (cat) {
			RequirementCategory: cat.extends
			VerificationCategory: cat.extends
			HazardCategory: cat.extends
		}
	}
	
	def void setSuperType(Category cat, Category value) {
		switch (cat) {
			RequirementCategory: cat.extends = (value as RequirementCategory)
			VerificationCategory: cat.extends = (value as VerificationCategory)
			HazardCategory: cat.extends = (value as HazardCategory)
		}
	}
	
}