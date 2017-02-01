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

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Claim Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.ClaimResult#getTargetReference <em>Target Reference</em>}</li>
 *   <li>{@link org.osate.assure.assure.ClaimResult#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link org.osate.assure.assure.ClaimResult#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.assure.assure.ClaimResult#getSubClaimResult <em>Sub Claim Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.ClaimResult#getVerificationActivityResult <em>Verification Activity Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.ClaimResult#getPredicateResult <em>Predicate Result</em>}</li>
 * </ul>
 *
 * @see org.osate.assure.assure.AssurePackage#getClaimResult()
 * @model
 * @generated
 */
public interface ClaimResult extends AssureResult
{
  /**
   * Returns the value of the '<em><b>Target Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Reference</em>' containment reference.
   * @see #setTargetReference(QualifiedClaimReference)
   * @see org.osate.assure.assure.AssurePackage#getClaimResult_TargetReference()
   * @model containment="true"
   * @generated
   */
  QualifiedClaimReference getTargetReference();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.ClaimResult#getTargetReference <em>Target Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Reference</em>' containment reference.
   * @see #getTargetReference()
   * @generated
   */
  void setTargetReference(QualifiedClaimReference value);

  /**
   * Returns the value of the '<em><b>Model Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model Element</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model Element</em>' reference.
   * @see #setModelElement(NamedElement)
   * @see org.osate.assure.assure.AssurePackage#getClaimResult_ModelElement()
   * @model
   * @generated
   */
  NamedElement getModelElement();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.ClaimResult#getModelElement <em>Model Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model Element</em>' reference.
   * @see #getModelElement()
   * @generated
   */
  void setModelElement(NamedElement value);

  /**
   * Returns the value of the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Message</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message</em>' attribute.
   * @see #setMessage(String)
   * @see org.osate.assure.assure.AssurePackage#getClaimResult_Message()
   * @model
   * @generated
   */
  String getMessage();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.ClaimResult#getMessage <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message</em>' attribute.
   * @see #getMessage()
   * @generated
   */
  void setMessage(String value);

  /**
   * Returns the value of the '<em><b>Sub Claim Result</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.ClaimResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Claim Result</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Claim Result</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getClaimResult_SubClaimResult()
   * @model containment="true"
   * @generated
   */
  EList<ClaimResult> getSubClaimResult();

  /**
   * Returns the value of the '<em><b>Verification Activity Result</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.VerificationExpr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Verification Activity Result</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Verification Activity Result</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getClaimResult_VerificationActivityResult()
   * @model containment="true"
   * @generated
   */
  EList<VerificationExpr> getVerificationActivityResult();

  /**
   * Returns the value of the '<em><b>Predicate Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Predicate Result</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Predicate Result</em>' containment reference.
   * @see #setPredicateResult(VerificationResult)
   * @see org.osate.assure.assure.AssurePackage#getClaimResult_PredicateResult()
   * @model containment="true"
   * @generated
   */
  VerificationResult getPredicateResult();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.ClaimResult#getPredicateResult <em>Predicate Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Predicate Result</em>' containment reference.
   * @see #getPredicateResult()
   * @generated
   */
  void setPredicateResult(VerificationResult value);

} // ClaimResult
