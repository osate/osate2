package org.osate.categories.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.categories.categories.Categories;
import org.osate.categories.categories.Category;
import org.osate.categories.categories.RequirementCategories;
import org.osate.categories.categories.RequirementCategory;
import org.osate.categories.categories.SelectionCategories;
import org.osate.categories.categories.SelectionCategory;
import org.osate.categories.categories.VerificationCategories;
import org.osate.categories.categories.VerificationCategory;

@SuppressWarnings("all")
public class CategoriesUtil {
  public Categories containingCategories(final Category sh) {
    EObject _eContainer = sh.eContainer();
    return ((Categories) _eContainer);
  }
  
  public EList<? extends Category> category(final Categories cats) {
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
      if (cats instanceof SelectionCategories) {
        _matched=true;
        _switchResult = ((SelectionCategories)cats).getCategory();
      }
    }
    return _switchResult;
  }
  
  public Category getSuperType(final Category cat) {
    Category _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (cat instanceof RequirementCategory) {
        _matched=true;
        _switchResult = ((RequirementCategory)cat).getExtends();
      }
    }
    if (!_matched) {
      if (cat instanceof VerificationCategory) {
        _matched=true;
        _switchResult = ((VerificationCategory)cat).getExtends();
      }
    }
    if (!_matched) {
      if (cat instanceof SelectionCategory) {
        _matched=true;
        _switchResult = ((SelectionCategory)cat).getExtends();
      }
    }
    return _switchResult;
  }
  
  public void setSuperType(final Category cat, final Category value) {
    boolean _matched = false;
    if (!_matched) {
      if (cat instanceof RequirementCategory) {
        _matched=true;
        ((RequirementCategory)cat).setExtends(((RequirementCategory) value));
      }
    }
    if (!_matched) {
      if (cat instanceof VerificationCategory) {
        _matched=true;
        ((VerificationCategory)cat).setExtends(((VerificationCategory) value));
      }
    }
    if (!_matched) {
      if (cat instanceof SelectionCategory) {
        _matched=true;
        ((SelectionCategory)cat).setExtends(((SelectionCategory) value));
      }
    }
  }
}
