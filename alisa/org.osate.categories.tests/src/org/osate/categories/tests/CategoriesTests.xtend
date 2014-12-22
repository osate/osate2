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