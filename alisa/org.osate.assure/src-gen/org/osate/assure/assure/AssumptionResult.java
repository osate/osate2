/**
 */
package org.osate.assure.assure;

import org.osate.verify.verify.VerificationAssumption;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assumption Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.AssumptionResult#getVerificationActivity <em>Verification Activity</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssumptionResult#getStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getAssumptionResult()
 * @model
 * @generated
 */
public interface AssumptionResult extends EvidenceResult
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
   * @see #setVerificationActivity(VerificationAssumption)
   * @see org.osate.assure.assure.AssurePackage#getAssumptionResult_VerificationActivity()
   * @model
   * @generated
   */
  VerificationAssumption getVerificationActivity();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssumptionResult#getVerificationActivity <em>Verification Activity</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Verification Activity</em>' reference.
   * @see #getVerificationActivity()
   * @generated
   */
  void setVerificationActivity(VerificationAssumption value);

  /**
   * Returns the value of the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Status</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Status</em>' containment reference.
   * @see #setStatus(VerificationResult)
   * @see org.osate.assure.assure.AssurePackage#getAssumptionResult_Status()
   * @model containment="true"
   * @generated
   */
  VerificationResult getStatus();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssumptionResult#getStatus <em>Status</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Status</em>' containment reference.
   * @see #getStatus()
   * @generated
   */
  void setStatus(VerificationResult value);

} // AssumptionResult
