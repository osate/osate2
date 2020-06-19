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
 * A representation of the model object '<em><b>Assignment Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.AssignmentAction#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.AssignmentAction#getValueExpression <em>Value Expression</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getAssignmentAction()
 * @model
 * @generated
 */
public interface AssignmentAction extends BasicAction
{
  /**
   * Returns the value of the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' containment reference.
   * @see #setTarget(Target)
   * @see org.osate.ba.aadlba.AadlBaPackage#getAssignmentAction_Target()
   * @model containment="true" required="true"
   * @generated
   */
  Target getTarget();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.AssignmentAction#getTarget <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' containment reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Target value);

  /**
   * Returns the value of the '<em><b>Value Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Expression</em>' containment reference.
   * @see #setValueExpression(ValueExpression)
   * @see org.osate.ba.aadlba.AadlBaPackage#getAssignmentAction_ValueExpression()
   * @model containment="true" required="true"
   * @generated
   */
  ValueExpression getValueExpression();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.AssignmentAction#getValueExpression <em>Value Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value Expression</em>' containment reference.
   * @see #getValueExpression()
   * @generated
   */
  void setValueExpression(ValueExpression value);

} // AssignmentAction
