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

import org.eclipse.emf.common.util.EList;
import org.osate.ba.utils.visitor.IBAVisitable ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.SimpleExpression#getUnaryAddingOperator <em>Unary Adding Operator</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.SimpleExpression#getTerms <em>Terms</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.SimpleExpression#getBinaryAddingOperators <em>Binary Adding Operators</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getSimpleExpression()
 * @model
 * @generated
 */
public interface SimpleExpression extends BehaviorElement
{
  /**
   * Returns the value of the '<em><b>Unary Adding Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.ba.aadlba.UnaryAddingOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unary Adding Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unary Adding Operator</em>' attribute.
   * @see org.osate.ba.aadlba.UnaryAddingOperator
   * @see #isSetUnaryAddingOperator()
   * @see #unsetUnaryAddingOperator()
   * @see #setUnaryAddingOperator(UnaryAddingOperator)
   * @see org.osate.ba.aadlba.AadlBaPackage#getSimpleExpression_UnaryAddingOperator()
   * @model unsettable="true"
   * @generated
   */
  UnaryAddingOperator getUnaryAddingOperator();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.SimpleExpression#getUnaryAddingOperator <em>Unary Adding Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unary Adding Operator</em>' attribute.
   * @see org.osate.ba.aadlba.UnaryAddingOperator
   * @see #isSetUnaryAddingOperator()
   * @see #unsetUnaryAddingOperator()
   * @see #getUnaryAddingOperator()
   * @generated
   */
  void setUnaryAddingOperator(UnaryAddingOperator value);

  /**
   * Unsets the value of the '{@link org.osate.ba.aadlba.SimpleExpression#getUnaryAddingOperator <em>Unary Adding Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetUnaryAddingOperator()
   * @see #getUnaryAddingOperator()
   * @see #setUnaryAddingOperator(UnaryAddingOperator)
   * @generated
   */
  void unsetUnaryAddingOperator();

  /**
   * Returns whether the value of the '{@link org.osate.ba.aadlba.SimpleExpression#getUnaryAddingOperator <em>Unary Adding Operator</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Unary Adding Operator</em>' attribute is set.
   * @see #unsetUnaryAddingOperator()
   * @see #getUnaryAddingOperator()
   * @see #setUnaryAddingOperator(UnaryAddingOperator)
   * @generated
   */
  boolean isSetUnaryAddingOperator();

  /**
   * Returns the value of the '<em><b>Terms</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.ba.aadlba.Term}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Terms</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Terms</em>' containment reference list.
   * @see org.osate.ba.aadlba.AadlBaPackage#getSimpleExpression_Terms()
   * @model containment="true" required="true"
   * @generated
   */
  EList<Term> getTerms();

  /**
   * Returns the value of the '<em><b>Binary Adding Operators</b></em>' attribute list.
   * The list contents are of type {@link org.osate.ba.aadlba.BinaryAddingOperator}.
   * The literals are from the enumeration {@link org.osate.ba.aadlba.BinaryAddingOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Binary Adding Operators</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Binary Adding Operators</em>' attribute list.
   * @see org.osate.ba.aadlba.BinaryAddingOperator
   * @see #isSetBinaryAddingOperators()
   * @see #unsetBinaryAddingOperators()
   * @see org.osate.ba.aadlba.AadlBaPackage#getSimpleExpression_BinaryAddingOperators()
   * @model unique="false" unsettable="true"
   * @generated
   */
  EList<BinaryAddingOperator> getBinaryAddingOperators();

  /**
   * Unsets the value of the '{@link org.osate.ba.aadlba.SimpleExpression#getBinaryAddingOperators <em>Binary Adding Operators</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetBinaryAddingOperators()
   * @see #getBinaryAddingOperators()
   * @generated
   */
  void unsetBinaryAddingOperators();

  /**
   * Returns whether the value of the '{@link org.osate.ba.aadlba.SimpleExpression#getBinaryAddingOperators <em>Binary Adding Operators</em>}' attribute list is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Binary Adding Operators</em>' attribute list is set.
   * @see #unsetBinaryAddingOperators()
   * @see #getBinaryAddingOperators()
   * @generated
   */
  boolean isSetBinaryAddingOperators();

} // SimpleExpression
