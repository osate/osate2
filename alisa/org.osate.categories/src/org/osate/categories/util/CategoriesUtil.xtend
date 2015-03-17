package org.osate.categories.util

import org.osate.categories.categories.Categories
import org.osate.categories.categories.Category
import org.osate.categories.categories.RequirementCategories
import org.osate.categories.categories.RequirementCategory
import org.osate.categories.categories.SelectionCategories
import org.osate.categories.categories.SelectionCategory
import org.osate.categories.categories.VerificationCategories
import org.osate.categories.categories.VerificationCategory

class CategoriesUtil {
	
	def Categories containingCategories(Category sh){
		sh.eContainer() as Categories
	}
	
	def category(Categories cats) {
		switch (cats) {
			RequirementCategories: cats.category
			VerificationCategories: cats.category
			SelectionCategories: cats.category
		}
	}
	
	def Category getSuperType(Category cat) {
		switch (cat) {
			RequirementCategory: cat.extends
			VerificationCategory: cat.extends
			SelectionCategory: cat.extends
		}
	}
	
	def void setSuperType(Category cat, Category value) {
		switch (cat) {
			RequirementCategory: cat.extends = (value as RequirementCategory)
			VerificationCategory: cat.extends = (value as VerificationCategory)
			SelectionCategory: cat.extends = (value as SelectionCategory)
		}
	}
	
}