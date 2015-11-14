/**
 */
package org.osate.categories.categories;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.categories.categories.CategorySet#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.osate.categories.categories.CategoriesPackage#getCategorySet()
 * @model
 * @generated
 */
public interface CategorySet extends Category
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.Category}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' reference list.
   * @see org.osate.categories.categories.CategoriesPackage#getCategorySet_Elements()
   * @model
   * @generated
   */
  EList<Category> getElements();

} // CategorySet
