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

package org.osate.categories.tests
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.osate.categories.CategoriesInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.osate.categories.categories.Categories
import com.google.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.osate.categories.categories.CategoriesPackage
import org.osate.categories.validation.CategoriesValidator

@RunWith(typeof(XtextRunner))
	@InjectWith(typeof(CategoriesInjectorProvider))
	

class CategoriesTests {
	@Inject extension ValidationTestHelper
	@Inject extension ParseHelper<Categories>
	
	@Test
	def void testCycles(){
		val categories = '''
		requirement categories [
		    category me extends you
		    category you extends me
		]
		'''.parse
		categories.assertError(CategoriesPackage::eINSTANCE.category,
			CategoriesValidator::CYCLES_CATEGORY,
			"Cycle in extends hierarchy of Category 'me'")
		categories.assertError(CategoriesPackage::eINSTANCE.category,
			CategoriesValidator::CYCLES_CATEGORY,
			"Cycle in extends hierarchy of Category 'you'")
	}
	
}