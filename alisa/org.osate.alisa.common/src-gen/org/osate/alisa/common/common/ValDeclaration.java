/**
 */
package org.osate.alisa.common.common;

import org.osate.aadl2.PropertyExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Val Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.ValDeclaration#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getValDeclaration()
 * @model
 * @generated
 */
public interface ValDeclaration extends AVariableDeclaration
{
  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(PropertyExpression)
   * @see org.osate.alisa.common.common.CommonPackage#getValDeclaration_Right()
   * @model containment="true"
   * @generated
   */
  PropertyExpression getRight();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ValDeclaration#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(PropertyExpression value);

} // ValDeclaration
