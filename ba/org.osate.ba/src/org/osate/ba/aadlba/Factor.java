/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2020 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 2.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */
package org.osate.ba.aadlba;

import org.osate.ba.utils.visitor.IBAVisitable ;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Factor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.Factor#getFirstValue <em>First Value</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.Factor#getSecondValue <em>Second Value</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.Factor#getBinaryNumericOperator <em>Binary Numeric Operator</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.Factor#getUnaryNumericOperator <em>Unary Numeric Operator</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.Factor#getUnaryBooleanOperator <em>Unary Boolean Operator</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getFactor()
 * @model
 * @generated
 */
public interface Factor extends BehaviorElement
{
  /**
   * Returns the value of the '<em><b>First Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First Value</em>' containment reference.
   * @see #setFirstValue(Value)
   * @see org.osate.ba.aadlba.AadlBaPackage#getFactor_FirstValue()
   * @model containment="true" required="true"
   * @generated
   */
  Value getFirstValue();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.Factor#getFirstValue <em>First Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First Value</em>' containment reference.
   * @see #getFirstValue()
   * @generated
   */
  void setFirstValue(Value value);

  /**
   * Returns the value of the '<em><b>Second Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second Value</em>' containment reference.
   * @see #setSecondValue(Value)
   * @see org.osate.ba.aadlba.AadlBaPackage#getFactor_SecondValue()
   * @model containment="true"
   * @generated
   */
  Value getSecondValue();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.Factor#getSecondValue <em>Second Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Second Value</em>' containment reference.
   * @see #getSecondValue()
   * @generated
   */
  void setSecondValue(Value value);

  /**
   * Returns the value of the '<em><b>Binary Numeric Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.ba.aadlba.BinaryNumericOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Binary Numeric Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Binary Numeric Operator</em>' attribute.
   * @see org.osate.ba.aadlba.BinaryNumericOperator
   * @see #isSetBinaryNumericOperator()
   * @see #unsetBinaryNumericOperator()
   * @see #setBinaryNumericOperator(BinaryNumericOperator)
   * @see org.osate.ba.aadlba.AadlBaPackage#getFactor_BinaryNumericOperator()
   * @model unique="false" unsettable="true"
   * @generated
   */
  BinaryNumericOperator getBinaryNumericOperator();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.Factor#getBinaryNumericOperator <em>Binary Numeric Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Binary Numeric Operator</em>' attribute.
   * @see org.osate.ba.aadlba.BinaryNumericOperator
   * @see #isSetBinaryNumericOperator()
   * @see #unsetBinaryNumericOperator()
   * @see #getBinaryNumericOperator()
   * @generated
   */
  void setBinaryNumericOperator(BinaryNumericOperator value);

  /**
   * Unsets the value of the '{@link org.osate.ba.aadlba.Factor#getBinaryNumericOperator <em>Binary Numeric Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetBinaryNumericOperator()
   * @see #getBinaryNumericOperator()
   * @see #setBinaryNumericOperator(BinaryNumericOperator)
   * @generated
   */
  void unsetBinaryNumericOperator();

  /**
   * Returns whether the value of the '{@link org.osate.ba.aadlba.Factor#getBinaryNumericOperator <em>Binary Numeric Operator</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Binary Numeric Operator</em>' attribute is set.
   * @see #unsetBinaryNumericOperator()
   * @see #getBinaryNumericOperator()
   * @see #setBinaryNumericOperator(BinaryNumericOperator)
   * @generated
   */
  boolean isSetBinaryNumericOperator();

  /**
   * Returns the value of the '<em><b>Unary Numeric Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.ba.aadlba.UnaryNumericOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unary Numeric Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unary Numeric Operator</em>' attribute.
   * @see org.osate.ba.aadlba.UnaryNumericOperator
   * @see #isSetUnaryNumericOperator()
   * @see #unsetUnaryNumericOperator()
   * @see #setUnaryNumericOperator(UnaryNumericOperator)
   * @see org.osate.ba.aadlba.AadlBaPackage#getFactor_UnaryNumericOperator()
   * @model unique="false" unsettable="true"
   * @generated
   */
  UnaryNumericOperator getUnaryNumericOperator();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.Factor#getUnaryNumericOperator <em>Unary Numeric Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unary Numeric Operator</em>' attribute.
   * @see org.osate.ba.aadlba.UnaryNumericOperator
   * @see #isSetUnaryNumericOperator()
   * @see #unsetUnaryNumericOperator()
   * @see #getUnaryNumericOperator()
   * @generated
   */
  void setUnaryNumericOperator(UnaryNumericOperator value);

  /**
   * Unsets the value of the '{@link org.osate.ba.aadlba.Factor#getUnaryNumericOperator <em>Unary Numeric Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetUnaryNumericOperator()
   * @see #getUnaryNumericOperator()
   * @see #setUnaryNumericOperator(UnaryNumericOperator)
   * @generated
   */
  void unsetUnaryNumericOperator();

  /**
   * Returns whether the value of the '{@link org.osate.ba.aadlba.Factor#getUnaryNumericOperator <em>Unary Numeric Operator</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Unary Numeric Operator</em>' attribute is set.
   * @see #unsetUnaryNumericOperator()
   * @see #getUnaryNumericOperator()
   * @see #setUnaryNumericOperator(UnaryNumericOperator)
   * @generated
   */
  boolean isSetUnaryNumericOperator();

  /**
   * Returns the value of the '<em><b>Unary Boolean Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.ba.aadlba.UnaryBooleanOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unary Boolean Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unary Boolean Operator</em>' attribute.
   * @see org.osate.ba.aadlba.UnaryBooleanOperator
   * @see #isSetUnaryBooleanOperator()
   * @see #unsetUnaryBooleanOperator()
   * @see #setUnaryBooleanOperator(UnaryBooleanOperator)
   * @see org.osate.ba.aadlba.AadlBaPackage#getFactor_UnaryBooleanOperator()
   * @model unique="false" unsettable="true"
   * @generated
   */
  UnaryBooleanOperator getUnaryBooleanOperator();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.Factor#getUnaryBooleanOperator <em>Unary Boolean Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unary Boolean Operator</em>' attribute.
   * @see org.osate.ba.aadlba.UnaryBooleanOperator
   * @see #isSetUnaryBooleanOperator()
   * @see #unsetUnaryBooleanOperator()
   * @see #getUnaryBooleanOperator()
   * @generated
   */
  void setUnaryBooleanOperator(UnaryBooleanOperator value);

  /**
   * Unsets the value of the '{@link org.osate.ba.aadlba.Factor#getUnaryBooleanOperator <em>Unary Boolean Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetUnaryBooleanOperator()
   * @see #getUnaryBooleanOperator()
   * @see #setUnaryBooleanOperator(UnaryBooleanOperator)
   * @generated
   */
  void unsetUnaryBooleanOperator();

  /**
   * Returns whether the value of the '{@link org.osate.ba.aadlba.Factor#getUnaryBooleanOperator <em>Unary Boolean Operator</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Unary Boolean Operator</em>' attribute is set.
   * @see #unsetUnaryBooleanOperator()
   * @see #getUnaryBooleanOperator()
   * @see #setUnaryBooleanOperator(UnaryBooleanOperator)
   * @generated
   */
  boolean isSetUnaryBooleanOperator();

} // Factor
