/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.verify.verify;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Else Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.ElseExpr#getLeft <em>Left</em>}</li>
 *   <li>{@link org.osate.verify.verify.ElseExpr#getError <em>Error</em>}</li>
 *   <li>{@link org.osate.verify.verify.ElseExpr#getFail <em>Fail</em>}</li>
 *   <li>{@link org.osate.verify.verify.ElseExpr#getTimeout <em>Timeout</em>}</li>
 * </ul>
 *
 * @see org.osate.verify.verify.VerifyPackage#getElseExpr()
 * @model
 * @generated
 */
public interface ElseExpr extends ArgumentExpr
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(ArgumentExpr)
   * @see org.osate.verify.verify.VerifyPackage#getElseExpr_Left()
   * @model containment="true"
   * @generated
   */
  ArgumentExpr getLeft();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.ElseExpr#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(ArgumentExpr value);

  /**
   * Returns the value of the '<em><b>Error</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Error</em>' containment reference.
   * @see #setError(ArgumentExpr)
   * @see org.osate.verify.verify.VerifyPackage#getElseExpr_Error()
   * @model containment="true"
   * @generated
   */
  ArgumentExpr getError();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.ElseExpr#getError <em>Error</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Error</em>' containment reference.
   * @see #getError()
   * @generated
   */
  void setError(ArgumentExpr value);

  /**
   * Returns the value of the '<em><b>Fail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fail</em>' containment reference.
   * @see #setFail(ArgumentExpr)
   * @see org.osate.verify.verify.VerifyPackage#getElseExpr_Fail()
   * @model containment="true"
   * @generated
   */
  ArgumentExpr getFail();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.ElseExpr#getFail <em>Fail</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fail</em>' containment reference.
   * @see #getFail()
   * @generated
   */
  void setFail(ArgumentExpr value);

  /**
   * Returns the value of the '<em><b>Timeout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timeout</em>' containment reference.
   * @see #setTimeout(ArgumentExpr)
   * @see org.osate.verify.verify.VerifyPackage#getElseExpr_Timeout()
   * @model containment="true"
   * @generated
   */
  ArgumentExpr getTimeout();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.ElseExpr#getTimeout <em>Timeout</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timeout</em>' containment reference.
   * @see #getTimeout()
   * @generated
   */
  void setTimeout(ArgumentExpr value);

} // ElseExpr
