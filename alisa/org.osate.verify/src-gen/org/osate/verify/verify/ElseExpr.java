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
