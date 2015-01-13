/**
 */
package org.osate.categories.categories;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.categories.categories.SelectionCategory#getExtends <em>Extends</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.categories.categories.CategoriesPackage#getSelectionCategory()
 * @model
 * @generated
 */
public interface SelectionCategory extends Category
{
  /**
   * Returns the value of the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extends</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends</em>' reference.
   * @see #setExtends(SelectionCategory)
   * @see org.osate.categories.categories.CategoriesPackage#getSelectionCategory_Extends()
   * @model
   * @generated
   */
  SelectionCategory getExtends();

  /**
   * Sets the value of the '{@link org.osate.categories.categories.SelectionCategory#getExtends <em>Extends</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extends</em>' reference.
   * @see #getExtends()
   * @generated
   */
  void setExtends(SelectionCategory value);

} // SelectionCategory
