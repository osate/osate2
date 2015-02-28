/**
 */
package org.osate.alisa.workbench.alisa;

import org.osate.categories.categories.Category;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection Category Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.SelectionCategoryReference#getCat <em>Cat</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.alisa.workbench.alisa.AlisaPackage#getSelectionCategoryReference()
 * @model
 * @generated
 */
public interface SelectionCategoryReference extends SelectionConditionExpr
{
  /**
   * Returns the value of the '<em><b>Cat</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cat</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cat</em>' reference.
   * @see #setCat(Category)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getSelectionCategoryReference_Cat()
   * @model
   * @generated
   */
  Category getCat();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.SelectionCategoryReference#getCat <em>Cat</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cat</em>' reference.
   * @see #getCat()
   * @generated
   */
  void setCat(Category value);

} // SelectionCategoryReference
