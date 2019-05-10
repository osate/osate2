/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.alisa.common.common;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.PropertyExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AUnary Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.AUnaryOperation#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.AUnaryOperation#getOperand <em>Operand</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getAUnaryOperation()
 * @model
 * @generated
 */
public interface AUnaryOperation extends EObject, PropertyExpression
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.alisa.common.common.Operation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.osate.alisa.common.common.Operation
   * @see #setOperator(Operation)
   * @see org.osate.alisa.common.common.CommonPackage#getAUnaryOperation_Operator()
   * @model
   * @generated
   */
  Operation getOperator();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.AUnaryOperation#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.osate.alisa.common.common.Operation
   * @see #getOperator()
   * @generated
   */
  void setOperator(Operation value);

  /**
   * Returns the value of the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand</em>' containment reference.
   * @see #setOperand(PropertyExpression)
   * @see org.osate.alisa.common.common.CommonPackage#getAUnaryOperation_Operand()
   * @model containment="true"
   * @generated
   */
  PropertyExpression getOperand();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.AUnaryOperation#getOperand <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' containment reference.
   * @see #getOperand()
   * @generated
   */
  void setOperand(PropertyExpression value);

} // AUnaryOperation
