/**
 */
package com.rockwellcollins.atc.resolute.resolute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.BaseType#getParamType <em>Param Type</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.BaseType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getBaseType()
 * @model
 * @generated
 */
public interface BaseType extends Type
{
  /**
   * Returns the value of the '<em><b>Param Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param Type</em>' containment reference.
   * @see #setParamType(Type)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getBaseType_ParamType()
   * @model containment="true"
   * @generated
   */
  Type getParamType();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.BaseType#getParamType <em>Param Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Param Type</em>' containment reference.
   * @see #getParamType()
   * @generated
   */
  void setParamType(Type value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getBaseType_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.BaseType#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

} // BaseType
