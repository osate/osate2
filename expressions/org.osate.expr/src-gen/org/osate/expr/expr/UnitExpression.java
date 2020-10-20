/**
 * *
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *  *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *  *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *  *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *  *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.expr.expr;

import org.osate.aadl2.UnitLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.UnitExpression#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.osate.expr.expr.UnitExpression#isConvert <em>Convert</em>}</li>
 *   <li>{@link org.osate.expr.expr.UnitExpression#isDrop <em>Drop</em>}</li>
 *   <li>{@link org.osate.expr.expr.UnitExpression#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getUnitExpression()
 * @model
 * @generated
 */
public interface UnitExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(Expression)
   * @see org.osate.expr.expr.ExprPackage#getUnitExpression_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.UnitExpression#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

  /**
   * Returns the value of the '<em><b>Convert</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Convert</em>' attribute.
   * @see #setConvert(boolean)
   * @see org.osate.expr.expr.ExprPackage#getUnitExpression_Convert()
   * @model
   * @generated
   */
  boolean isConvert();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.UnitExpression#isConvert <em>Convert</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Convert</em>' attribute.
   * @see #isConvert()
   * @generated
   */
  void setConvert(boolean value);

  /**
   * Returns the value of the '<em><b>Drop</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Drop</em>' attribute.
   * @see #setDrop(boolean)
   * @see org.osate.expr.expr.ExprPackage#getUnitExpression_Drop()
   * @model
   * @generated
   */
  boolean isDrop();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.UnitExpression#isDrop <em>Drop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Drop</em>' attribute.
   * @see #isDrop()
   * @generated
   */
  void setDrop(boolean value);

  /**
   * Returns the value of the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit</em>' reference.
   * @see #setUnit(UnitLiteral)
   * @see org.osate.expr.expr.ExprPackage#getUnitExpression_Unit()
   * @model
   * @generated
   */
  UnitLiteral getUnit();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.UnitExpression#getUnit <em>Unit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' reference.
   * @see #getUnit()
   * @generated
   */
  void setUnit(UnitLiteral value);

} // UnitExpression
