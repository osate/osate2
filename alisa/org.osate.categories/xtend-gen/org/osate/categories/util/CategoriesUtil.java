package org.osate.categories.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.categories.categories.Categories;
import org.osate.categories.categories.Category;
import org.osate.categories.categories.HazardCategories;
import org.osate.categories.categories.RequirementCategories;
import org.osate.categories.categories.VerificationCategories;

@SuppressWarnings("all")
public class CategoriesUtil {
  public static Categories containingCategories(final Category sh) {
    EObject _eContainer = sh.eContainer();
    return ((Categories) _eContainer);
  }
  
  public static EList<? extends Category> category(final Categories cats) {
    EList<? extends Category> _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (cats instanceof RequirementCategories) {
        _matched=true;
        _switchResult = ((RequirementCategories)cats).getCategory();
      }
    }
    if (!_matched) {
      if (cats instanceof VerificationCategories) {
        _matched=true;
        _switchResult = ((VerificationCategories)cats).getCategory();
      }
    }
    if (!_matched) {
      if (cats instanceof HazardCategories) {
        _matched=true;
        _switchResult = ((HazardCategories)cats).getCategory();
      }
    }
    return _switchResult;
  }
}
