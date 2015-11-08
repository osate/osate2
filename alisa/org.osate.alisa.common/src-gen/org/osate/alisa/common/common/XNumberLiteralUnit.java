/**
 */
package org.osate.alisa.common.common;

import org.eclipse.xtext.xbase.XNumberLiteral;

import org.osate.aadl2.UnitLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XNumber Literal Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.XNumberLiteralUnit#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getXNumberLiteralUnit()
 * @model
 * @generated
 */
public interface XNumberLiteralUnit extends XNumberLiteral
{
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
   * @see org.osate.alisa.common.common.CommonPackage#getXNumberLiteralUnit_Unit()
   * @model
   * @generated
   */
  UnitLiteral getUnit();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.XNumberLiteralUnit#getUnit <em>Unit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' reference.
   * @see #getUnit()
   * @generated
   */
  void setUnit(UnitLiteral value);

} // XNumberLiteralUnit
