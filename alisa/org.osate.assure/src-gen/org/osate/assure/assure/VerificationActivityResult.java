/**
 */
package org.osate.assure.assure;

import org.osate.verify.verify.VerificationActivity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Activity Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.VerificationActivityResult#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationActivityResult#getConditionResult <em>Condition Result</em>}</li>
 * </ul>
 *
 * @see org.osate.assure.assure.AssurePackage#getVerificationActivityResult()
 * @model
 * @generated
 */
public interface VerificationActivityResult extends VerificationResult
{
  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(VerificationActivity)
   * @see org.osate.assure.assure.AssurePackage#getVerificationActivityResult_Target()
   * @model
   * @generated
   */
  VerificationActivity getTarget();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationActivityResult#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(VerificationActivity value);

  /**
   * Returns the value of the '<em><b>Condition Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition Result</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition Result</em>' containment reference.
   * @see #setConditionResult(VerificationResult)
   * @see org.osate.assure.assure.AssurePackage#getVerificationActivityResult_ConditionResult()
   * @model containment="true"
   * @generated
   */
  VerificationResult getConditionResult();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationActivityResult#getConditionResult <em>Condition Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition Result</em>' containment reference.
   * @see #getConditionResult()
   * @generated
   */
  void setConditionResult(VerificationResult value);

} // VerificationActivityResult
