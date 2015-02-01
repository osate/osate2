/**
 */
package org.osate.alisa.common.common;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Real Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.RealTerm#getValue <em>Value</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.RealTerm#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getRealTerm()
 * @model
 * @generated
 */
public interface RealTerm extends ConstantValue
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
   * @see org.osate.alisa.common.common.CommonPackage#getRealTerm_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.RealTerm#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit</em>' attribute.
   * @see #setUnit(String)
   * @see org.osate.alisa.common.common.CommonPackage#getRealTerm_Unit()
   * @model
   * @generated
   */
  String getUnit();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.RealTerm#getUnit <em>Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' attribute.
   * @see #getUnit()
   * @generated
   */
  void setUnit(String value);

} // RealTerm
