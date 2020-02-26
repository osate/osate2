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
 * A representation of the model object '<em><b>Value Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.ValueExpression#getRelations <em>Relations</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.ValueExpression#getLogicalOperators <em>Logical Operators</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getValueExpression()
 * @model
 * @generated
 */
public interface ValueExpression extends Value, ParameterLabel, ExecuteCondition
{
  /**
   * Returns the value of the '<em><b>Relations</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.ba.aadlba.Relation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relations</em>' containment reference list.
   * @see org.osate.ba.aadlba.AadlBaPackage#getValueExpression_Relations()
   * @model containment="true"
   * @generated
   */
  EList<Relation> getRelations();

  /**
   * Returns the value of the '<em><b>Logical Operators</b></em>' attribute list.
   * The list contents are of type {@link org.osate.ba.aadlba.LogicalOperator}.
   * The literals are from the enumeration {@link org.osate.ba.aadlba.LogicalOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Logical Operators</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Logical Operators</em>' attribute list.
   * @see org.osate.ba.aadlba.LogicalOperator
   * @see #isSetLogicalOperators()
   * @see #unsetLogicalOperators()
   * @see org.osate.ba.aadlba.AadlBaPackage#getValueExpression_LogicalOperators()
   * @model unique="false" unsettable="true"
   * @generated
   */
  EList<LogicalOperator> getLogicalOperators();

  /**
   * Unsets the value of the '{@link org.osate.ba.aadlba.ValueExpression#getLogicalOperators <em>Logical Operators</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetLogicalOperators()
   * @see #getLogicalOperators()
   * @generated
   */
  void unsetLogicalOperators();

  /**
   * Returns whether the value of the '{@link org.osate.ba.aadlba.ValueExpression#getLogicalOperators <em>Logical Operators</em>}' attribute list is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Logical Operators</em>' attribute list is set.
   * @see #unsetLogicalOperators()
   * @see #getLogicalOperators()
   * @generated
   */
  boolean isSetLogicalOperators();

} // ValueExpression
