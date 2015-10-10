/**
 */
package org.osate.categories.categories;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Categories</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.categories.categories.MethodCategories#getCategory <em>Category</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.categories.categories.CategoriesPackage#getMethodCategories()
 * @model
 * @generated
 */
public interface MethodCategories extends Categories
{
  /**
   * Returns the value of the '<em><b>Category</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.categories.categories.MethodCategory}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Category</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Category</em>' containment reference list.
   * @see org.osate.categories.categories.CategoriesPackage#getMethodCategories_Category()
   * @model containment="true"
   * @generated
   */
  EList<MethodCategory> getCategory();

} // MethodCategories
