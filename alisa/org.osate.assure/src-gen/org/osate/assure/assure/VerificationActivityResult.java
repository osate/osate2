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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Activity Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.VerificationActivityResult#getTargetReference <em>Target Reference</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationActivityResult#getPreconditionResult <em>Precondition Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationActivityResult#getValidationResult <em>Validation Result</em>}</li>
 * </ul>
 *
 * @see org.osate.assure.assure.AssurePackage#getVerificationActivityResult()
 * @model
 * @generated
 */
public interface VerificationActivityResult extends VerificationResult
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
   * @see #setTargetReference(QualifiedVAReference)
   * @see org.osate.assure.assure.AssurePackage#getVerificationActivityResult_TargetReference()
   * @model containment="true"
   * @generated
   */
  QualifiedVAReference getTargetReference();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationActivityResult#getTargetReference <em>Target Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Reference</em>' containment reference.
   * @see #getTargetReference()
   * @generated
   */
  void setTargetReference(QualifiedVAReference value);

  /**
   * Returns the value of the '<em><b>Precondition Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Precondition Result</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Precondition Result</em>' containment reference.
   * @see #setPreconditionResult(VerificationResult)
   * @see org.osate.assure.assure.AssurePackage#getVerificationActivityResult_PreconditionResult()
   * @model containment="true"
   * @generated
   */
  VerificationResult getPreconditionResult();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationActivityResult#getPreconditionResult <em>Precondition Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Precondition Result</em>' containment reference.
   * @see #getPreconditionResult()
   * @generated
   */
  void setPreconditionResult(VerificationResult value);

  /**
   * Returns the value of the '<em><b>Validation Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Validation Result</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Validation Result</em>' containment reference.
   * @see #setValidationResult(VerificationResult)
   * @see org.osate.assure.assure.AssurePackage#getVerificationActivityResult_ValidationResult()
   * @model containment="true"
   * @generated
   */
  VerificationResult getValidationResult();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationActivityResult#getValidationResult <em>Validation Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Validation Result</em>' containment reference.
   * @see #getValidationResult()
   * @generated
   */
  void setValidationResult(VerificationResult value);

} // VerificationActivityResult
