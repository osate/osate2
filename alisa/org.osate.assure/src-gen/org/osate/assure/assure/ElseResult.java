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
package org.osate.assure.assure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Else Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.ElseResult#getFirst <em>First</em>}</li>
 *   <li>{@link org.osate.assure.assure.ElseResult#getError <em>Error</em>}</li>
 *   <li>{@link org.osate.assure.assure.ElseResult#getFail <em>Fail</em>}</li>
 *   <li>{@link org.osate.assure.assure.ElseResult#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.osate.assure.assure.ElseResult#getDidFail <em>Did Fail</em>}</li>
 * </ul>
 *
 * @see org.osate.assure.assure.AssurePackage#getElseResult()
 * @model
 * @generated
 */
public interface ElseResult extends VerificationExpr
{
  /**
   * Returns the value of the '<em><b>First</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.VerificationExpr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getElseResult_First()
   * @model containment="true"
   * @generated
   */
  EList<VerificationExpr> getFirst();

  /**
   * Returns the value of the '<em><b>Error</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.VerificationExpr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Error</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Error</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getElseResult_Error()
   * @model containment="true"
   * @generated
   */
  EList<VerificationExpr> getError();

  /**
   * Returns the value of the '<em><b>Fail</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.VerificationExpr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fail</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fail</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getElseResult_Fail()
   * @model containment="true"
   * @generated
   */
  EList<VerificationExpr> getFail();

  /**
   * Returns the value of the '<em><b>Timeout</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.VerificationExpr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timeout</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timeout</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getElseResult_Timeout()
   * @model containment="true"
   * @generated
   */
  EList<VerificationExpr> getTimeout();

  /**
   * Returns the value of the '<em><b>Did Fail</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.assure.assure.ElseType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Did Fail</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Did Fail</em>' attribute.
   * @see org.osate.assure.assure.ElseType
   * @see #setDidFail(ElseType)
   * @see org.osate.assure.assure.AssurePackage#getElseResult_DidFail()
   * @model
   * @generated
   */
  ElseType getDidFail();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.ElseResult#getDidFail <em>Did Fail</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Did Fail</em>' attribute.
   * @see org.osate.assure.assure.ElseType
   * @see #getDidFail()
   * @generated
   */
  void setDidFail(ElseType value);

} // ElseResult
