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

import org.eclipse.emf.common.util.EList;

import org.osate.aadl2.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fun Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.FunDecl#getArgs <em>Args</em>}</li>
 *   <li>{@link org.osate.expr.expr.FunDecl#getResultType <em>Result Type</em>}</li>
 *   <li>{@link org.osate.expr.expr.FunDecl#isJava <em>Java</em>}</li>
 *   <li>{@link org.osate.expr.expr.FunDecl#getFqn <em>Fqn</em>}</li>
 *   <li>{@link org.osate.expr.expr.FunDecl#getExp <em>Exp</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getFunDecl()
 * @model
 * @generated
 */
public interface FunDecl extends EDeclaration
{
  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.expr.expr.Argument}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see org.osate.expr.expr.ExprPackage#getFunDecl_Args()
   * @model containment="true"
   * @generated
   */
  EList<Argument> getArgs();

  /**
   * Returns the value of the '<em><b>Result Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result Type</em>' containment reference.
   * @see #setResultType(Type)
   * @see org.osate.expr.expr.ExprPackage#getFunDecl_ResultType()
   * @model containment="true"
   * @generated
   */
  Type getResultType();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.FunDecl#getResultType <em>Result Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result Type</em>' containment reference.
   * @see #getResultType()
   * @generated
   */
  void setResultType(Type value);

  /**
   * Returns the value of the '<em><b>Java</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Java</em>' attribute.
   * @see #setJava(boolean)
   * @see org.osate.expr.expr.ExprPackage#getFunDecl_Java()
   * @model
   * @generated
   */
  boolean isJava();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.FunDecl#isJava <em>Java</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Java</em>' attribute.
   * @see #isJava()
   * @generated
   */
  void setJava(boolean value);

  /**
   * Returns the value of the '<em><b>Fqn</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fqn</em>' attribute.
   * @see #setFqn(String)
   * @see org.osate.expr.expr.ExprPackage#getFunDecl_Fqn()
   * @model
   * @generated
   */
  String getFqn();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.FunDecl#getFqn <em>Fqn</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fqn</em>' attribute.
   * @see #getFqn()
   * @generated
   */
  void setFqn(String value);

  /**
   * Returns the value of the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' containment reference.
   * @see #setExp(Expression)
   * @see org.osate.expr.expr.ExprPackage#getFunDecl_Exp()
   * @model containment="true"
   * @generated
   */
  Expression getExp();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.FunDecl#getExp <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' containment reference.
   * @see #getExp()
   * @generated
   */
  void setExp(Expression value);

} // FunDecl
