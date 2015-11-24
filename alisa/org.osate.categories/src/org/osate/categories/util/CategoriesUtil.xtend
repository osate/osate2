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
import org.osate.categories.categories.RequirementTypeCategories
import org.osate.categories.categories.MethodTypeCategories
import org.osate.categories.categories.UserSelectionCategories
import org.osate.categories.categories.QualityAttributeCategories

class CategoriesUtil {

	def static Categories containingCategories(Category sh) {
		sh.eContainer() as Categories
	}

	def static category(Categories cats) {
		switch (cats) {
			RequirementTypeCategories: cats.category
			MethodTypeCategories: cats.category
			UserSelectionCategories: cats.category
			QualityAttributeCategories: cats.category
		}
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

}