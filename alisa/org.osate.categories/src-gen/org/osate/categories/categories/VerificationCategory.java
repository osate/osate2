/**
 */
package org.osate.categories.categories;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.categories.categories.VerificationCategory#getExtends <em>Extends</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.categories.categories.CategoriesPackage#getVerificationCategory()
 * @model
 * @generated
 */
public interface VerificationCategory extends Category
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
   * @see #setExtends(VerificationCategory)
   * @see org.osate.categories.categories.CategoriesPackage#getVerificationCategory_Extends()
   * @model
   * @generated
   */
  VerificationCategory getExtends();

  /**
   * Sets the value of the '{@link org.osate.categories.categories.VerificationCategory#getExtends <em>Extends</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extends</em>' reference.
   * @see #getExtends()
   * @generated
   */
  void setExtends(VerificationCategory value);

} // VerificationCategory
