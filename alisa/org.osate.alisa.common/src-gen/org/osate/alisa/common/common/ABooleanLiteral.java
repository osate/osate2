/**
 */
package org.osate.alisa.common.common;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ABoolean Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.ABooleanLiteral#isIsTrue <em>Is True</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getABooleanLiteral()
 * @model
 * @generated
 */
public interface ABooleanLiteral extends AExpression
{
  /**
   * Returns the value of the '<em><b>Is True</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is True</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is True</em>' attribute.
   * @see #setIsTrue(boolean)
   * @see org.osate.alisa.common.common.CommonPackage#getABooleanLiteral_IsTrue()
   * @model
   * @generated
   */
  boolean isIsTrue();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ABooleanLiteral#isIsTrue <em>Is True</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is True</em>' attribute.
   * @see #isIsTrue()
   * @generated
   */
  void setIsTrue(boolean value);

} // ABooleanLiteral
