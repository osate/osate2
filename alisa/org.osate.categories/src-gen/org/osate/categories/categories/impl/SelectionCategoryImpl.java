/**
 */
package org.osate.categories.categories.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.categories.categories.CategoriesPackage;
import org.osate.categories.categories.SelectionCategory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection Category</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.categories.categories.impl.SelectionCategoryImpl#getSubCategories <em>Sub Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SelectionCategoryImpl extends CategoryImpl implements SelectionCategory
{
  /**
   * The cached value of the '{@link #getSubCategories() <em>Sub Categories</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubCategories()
   * @generated
   * @ordered
   */
  protected EList<SelectionCategory> subCategories;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SelectionCategoryImpl()
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
    return CategoriesPackage.Literals.SELECTION_CATEGORY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SelectionCategory> getSubCategories()
  {
    if (subCategories == null)
    {
      subCategories = new EObjectResolvingEList<SelectionCategory>(SelectionCategory.class, this, CategoriesPackage.SELECTION_CATEGORY__SUB_CATEGORIES);
    }
    return subCategories;
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
      case CategoriesPackage.SELECTION_CATEGORY__SUB_CATEGORIES:
        return getSubCategories();
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
      case CategoriesPackage.SELECTION_CATEGORY__SUB_CATEGORIES:
        getSubCategories().clear();
        getSubCategories().addAll((Collection<? extends SelectionCategory>)newValue);
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
      case CategoriesPackage.SELECTION_CATEGORY__SUB_CATEGORIES:
        getSubCategories().clear();
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
      case CategoriesPackage.SELECTION_CATEGORY__SUB_CATEGORIES:
        return subCategories != null && !subCategories.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SelectionCategoryImpl
