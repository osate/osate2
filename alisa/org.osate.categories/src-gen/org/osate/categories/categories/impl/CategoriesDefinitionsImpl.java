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
package org.osate.categories.categories.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.categories.categories.Categories;
import org.osate.categories.categories.CategoriesDefinitions;
import org.osate.categories.categories.CategoriesPackage;
import org.osate.categories.categories.CategoryFilter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Definitions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl#getCategoryFilters <em>Category Filters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CategoriesDefinitionsImpl extends MinimalEObjectImpl.Container implements CategoriesDefinitions
{
  /**
   * The cached value of the '{@link #getCategories() <em>Categories</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategories()
   * @generated
   * @ordered
   */
  protected EList<Categories> categories;

  /**
   * The cached value of the '{@link #getCategoryFilters() <em>Category Filters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategoryFilters()
   * @generated
   * @ordered
   */
  protected EList<CategoryFilter> categoryFilters;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CategoriesDefinitionsImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return CategoriesPackage.Literals.CATEGORIES_DEFINITIONS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Categories> getCategories()
  {
    if (categories == null)
    {
      categories = new EObjectContainmentEList<Categories>(Categories.class, this, CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORIES);
    }
    return categories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CategoryFilter> getCategoryFilters()
  {
    if (categoryFilters == null)
    {
      categoryFilters = new EObjectContainmentEList<CategoryFilter>(CategoryFilter.class, this, CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORY_FILTERS);
    }
    return categoryFilters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORIES:
        return ((InternalEList<?>)getCategories()).basicRemove(otherEnd, msgs);
      case CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORY_FILTERS:
        return ((InternalEList<?>)getCategoryFilters()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORIES:
        return getCategories();
      case CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORY_FILTERS:
        return getCategoryFilters();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORIES:
        getCategories().clear();
        getCategories().addAll((Collection<? extends Categories>)newValue);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORY_FILTERS:
        getCategoryFilters().clear();
        getCategoryFilters().addAll((Collection<? extends CategoryFilter>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORIES:
        getCategories().clear();
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORY_FILTERS:
        getCategoryFilters().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORIES:
        return categories != null && !categories.isEmpty();
      case CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORY_FILTERS:
        return categoryFilters != null && !categoryFilters.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CategoriesDefinitionsImpl
