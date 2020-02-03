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
 * A representation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.Term#getFactors <em>Factors</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.Term#getMultiplyingOperators <em>Multiplying Operators</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getTerm()
 * @model
 * @generated
 */
public interface Term extends BehaviorElement
{
  /**
   * Returns the value of the '<em><b>Factors</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.ba.aadlba.Factor}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Factors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Factors</em>' containment reference list.
   * @see org.osate.ba.aadlba.AadlBaPackage#getTerm_Factors()
   * @model containment="true" required="true"
   * @generated
   */
  EList<Factor> getFactors();

  /**
   * Returns the value of the '<em><b>Multiplying Operators</b></em>' attribute list.
   * The list contents are of type {@link org.osate.ba.aadlba.MultiplyingOperator}.
   * The literals are from the enumeration {@link org.osate.ba.aadlba.MultiplyingOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplying Operators</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplying Operators</em>' attribute list.
   * @see org.osate.ba.aadlba.MultiplyingOperator
   * @see #isSetMultiplyingOperators()
   * @see #unsetMultiplyingOperators()
   * @see org.osate.ba.aadlba.AadlBaPackage#getTerm_MultiplyingOperators()
   * @model unique="false" unsettable="true"
   * @generated
   */
  EList<MultiplyingOperator> getMultiplyingOperators();

  /**
   * Unsets the value of the '{@link org.osate.ba.aadlba.Term#getMultiplyingOperators <em>Multiplying Operators</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMultiplyingOperators()
   * @see #getMultiplyingOperators()
   * @generated
   */
  void unsetMultiplyingOperators();

  /**
   * Returns whether the value of the '{@link org.osate.ba.aadlba.Term#getMultiplyingOperators <em>Multiplying Operators</em>}' attribute list is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Multiplying Operators</em>' attribute list is set.
   * @see #unsetMultiplyingOperators()
   * @see #getMultiplyingOperators()
   * @generated
   */
  boolean isSetMultiplyingOperators();

} // Term
