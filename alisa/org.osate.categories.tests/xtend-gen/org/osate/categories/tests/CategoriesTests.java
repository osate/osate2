package org.osate.categories.tests;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.categories.CategoriesInjectorProvider;
import org.osate.categories.categories.Categories;
import org.osate.categories.categories.CategoriesPackage;
import org.osate.categories.validation.CategoriesValidator;

@RunWith(XtextRunner.class)
@InjectWith(CategoriesInjectorProvider.class)
@SuppressWarnings("all")
public class CategoriesTests {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  @Extension
  private ParseHelper<Categories> _parseHelper;
  
  @Test
  public void testCycles() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("requirement categories [");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("category me extends you");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("category you extends me");
      _builder.newLine();
      _builder.append("]");
      _builder.newLine();
      final Categories categories = this._parseHelper.parse(_builder);
      EClass _category = CategoriesPackage.eINSTANCE.getCategory();
      this._validationTestHelper.assertError(categories, _category, 
        CategoriesValidator.CYCLES_CATEGORY, 
        "Cycle in extends hierarchy of Category \'me\'");
      EClass _category_1 = CategoriesPackage.eINSTANCE.getCategory();
      this._validationTestHelper.assertError(categories, _category_1, 
        CategoriesValidator.CYCLES_CATEGORY, 
        "Cycle in extends hierarchy of Category \'you\'");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
