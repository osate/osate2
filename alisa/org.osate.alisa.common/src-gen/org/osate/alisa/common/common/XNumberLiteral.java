/**
 */
package org.osate.alisa.common.common;

import org.osate.aadl2.UnitLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XNumber Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.XNumberLiteral#getValue <em>Value</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.XNumberLiteral#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getXNumberLiteral()
 * @model
 * @generated
 */
public interface XNumberLiteral extends XExpression
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.osate.alisa.common.common.CommonPackage#getXNumberLiteral_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.XNumberLiteral#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unit</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit</em>' reference.
   * @see #setUnit(UnitLiteral)
   * @see org.osate.alisa.common.common.CommonPackage#getXNumberLiteral_Unit()
   * @model
   * @generated
   */
  UnitLiteral getUnit();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.XNumberLiteral#getUnit <em>Unit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' reference.
   * @see #getUnit()
   * @generated
   */
  void setUnit(UnitLiteral value);

} // XNumberLiteral
