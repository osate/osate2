/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.common.util.EList;

import org.osate.verify.verify.VerificationActivity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getVerificationActivity <em>Verification Activity</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getAssumptionResult <em>Assumption Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getPreconditionResult <em>Precondition Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getFirst <em>First</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getSecond <em>Second</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getVerificationResult()
 * @model
 * @generated
 */
public interface VerificationResult extends EvidenceResult
{
  /**
   * Returns the value of the '<em><b>Verification Activity</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Verification Activity</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Verification Activity</em>' reference.
   * @see #setVerificationActivity(VerificationActivity)
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_VerificationActivity()
   * @model
   * @generated
   */
  VerificationActivity getVerificationActivity();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getVerificationActivity <em>Verification Activity</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Verification Activity</em>' reference.
   * @see #getVerificationActivity()
   * @generated
   */
  void setVerificationActivity(VerificationActivity value);

  /**
   * Returns the value of the '<em><b>Assumption Result</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.AssumptionResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assumption Result</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assumption Result</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_AssumptionResult()
   * @model containment="true"
   * @generated
   */
  EList<AssumptionResult> getAssumptionResult();

  /**
   * Returns the value of the '<em><b>Precondition Result</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.PreconditionResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Precondition Result</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Precondition Result</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_PreconditionResult()
   * @model containment="true"
   * @generated
   */
  EList<PreconditionResult> getPreconditionResult();

  /**
   * Returns the value of the '<em><b>First</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.VerificationResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_First()
   * @model containment="true"
   * @generated
   */
  EList<VerificationResult> getFirst();

  /**
   * Returns the value of the '<em><b>Second</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.VerificationResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_Second()
   * @model containment="true"
   * @generated
   */
  EList<VerificationResult> getSecond();

} // VerificationResult
