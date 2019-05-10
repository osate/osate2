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
 * A representation of the model object '<em><b>Then Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.ThenExpr#getLeft <em>Left</em>}</li>
 *   <li>{@link org.osate.verify.verify.ThenExpr#getSuccessor <em>Successor</em>}</li>
 * </ul>
 *
 * @see org.osate.verify.verify.VerifyPackage#getThenExpr()
 * @model
 * @generated
 */
public interface ThenExpr extends ArgumentExpr
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(ArgumentExpr)
   * @see org.osate.verify.verify.VerifyPackage#getThenExpr_Left()
   * @model containment="true"
   * @generated
   */
  ArgumentExpr getLeft();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.ThenExpr#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(ArgumentExpr value);

  /**
   * Returns the value of the '<em><b>Successor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Successor</em>' containment reference.
   * @see #setSuccessor(ArgumentExpr)
   * @see org.osate.verify.verify.VerifyPackage#getThenExpr_Successor()
   * @model containment="true"
   * @generated
   */
  ArgumentExpr getSuccessor();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.ThenExpr#getSuccessor <em>Successor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Successor</em>' containment reference.
   * @see #getSuccessor()
   * @generated
   */
  void setSuccessor(ArgumentExpr value);

} // ThenExpr
